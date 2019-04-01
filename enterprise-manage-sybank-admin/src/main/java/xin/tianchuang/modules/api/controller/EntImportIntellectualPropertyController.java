package xin.tianchuang.modules.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.response.*;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.spider.entity.*;
import xin.tianchuang.modules.spider.service.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yp-tc-m-7179 on 2019/2/28.
 */
@RestController
@RequestMapping("/api/import1")
@ApiIgnore
@Deprecated
public class EntImportIntellectualPropertyController {

    private static final Logger logger = LoggerFactory.getLogger(EntImportIntellectualPropertyController.class);
    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";
    private ExecutorService executorService = Executors.newFixedThreadPool(6);
    @Autowired
    private EntListInfoService entListInfoService;
    @Autowired
    private EntTmInfoService entTmInfoService;
    @Autowired
    private EntPatentsInfoService entPatentsInfoService;
    @Autowired
    private EntCopyRegWorksService entCopyRegWorksService;
    @Autowired
    private EntCopyRegService entCopyRegService;
    @Autowired
    private EntIcpInfoService entIcpInfoService;

    /**
     * 商标信息
     *
     * @throws IOException 问题：
     *                     1.connList多级
     *                     2.tmFlow、category字段加长
     *                     3.4.9m
     */
    @GetMapping("/tm")
    public R tm(String file1, String file2) throws IOException {
        String path = rootPath + "/商标信息/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, "error2.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error3.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>>>>() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>>> wrapper = gson.fromJson(line, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>> dtos = wrapper.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }
                            Integer status = dtos.getStatus();
                            String uuid = dtos.getSeqNum();
                            String message = dtos.getMessage();
                            if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                                ResponsePageNumResultDTO<Open439TmDTO> data = dtos.getData();
                                if (null == data) {
                                    throw new SpiderException("data节点数据返回为空");
                                }
                                // 保存数据
                                String entName = wrapper.getCname();
                                EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                                List<Open439TmDTO> items = data.getItems();
                                if (null != items && items.size() > 0) {
                                    // 先删除 在新增
                                    entTmInfoService.deleteByEntName(entName);

                                    List<EntTmInfoEntity> tmInfoEntityList = Lists.newArrayList();
                                    List<String> connLs = null;
                                    EntTmInfoEntity entity = null;
                                    String connStr = null;
                                    for (Open439TmDTO item : items) {
                                        entity = new EntTmInfoEntity();
                                        BeanUtils.copyProperties(item, entity);

                                        entity.setEntId(listInfoEntity.getId());
                                        entity.setEntName(entName);
                                        entity.setCreditCode(listInfoEntity.getCreditCode());

                                        connLs = item.getConnList();
                                        if (null != connLs && connLs.size() >= 1) {
                                            connStr = Joiner.on(",").join(connLs);
                                            entity.setConnList(connStr);
                                        }
//                                        List<SubTm> subTms = item.getTmFlow();
//                                        if (null != subTms && subTms.size() >= 1) {
//                                            entity.setTmFlow( JSON.toJSONString(subTms));
//                                        }

                                        tmInfoEntityList.add(entity);
                                    }
                                    entTmInfoService.insertBatch(tmInfoEntityList);
                                }
                            }
                        } catch (Exception e) {
                            try {
                                bw.write(line);
                                bw.flush();
                                bw.newLine();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }
                    }
                });
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 专利
     * 问题：
     * 1.connList多级
     * 2.多处出现特殊字符："rn"，例如：[ rn
     * 3.多处字符串有多余字符:main_cat_num-["H04M1/725"] 、 APPLICANT_NAME-["宿迁王氏蜜蜂园有限公司"]
     * 4.文件大小10.8m
     *
     * @throws IOException
     */
    @GetMapping("/patents")
    public R patents() throws IOException {
        String path = rootPath + "/专利/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, "error1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error2.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
//                executorService.execute(new Runnable() {
//                    @Override
//                    public void run() {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open440PatentsDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open440PatentsDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open440PatentsDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    Integer status = dtos.getStatus();
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                        ResponsePageNumResultDTO<Open440PatentsDTO> data = dtos.getData();
                        if (null == data) {
                            throw new SpiderException("data节点数据返回为空");
                        }
                        // 保存数据
                        String entName = wrapper.getCname();
                        EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                        List<Open440PatentsDTO> items = data.getItems();
                        if (null != items && items.size() > 0) {
                            // 先删除 在新增
                            entPatentsInfoService.deleteByEntName(entName);
                            List<EntPatentsInfoEntity> entityList = Lists.newArrayList();
                            List<String> connLs = null;
                            EntPatentsInfoEntity entity = null;
                            String connStr = null;
                            for (Open440PatentsDTO item : items) {
                                entity = new EntPatentsInfoEntity();
                                BeanUtils.copyProperties(item, entity);

                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());

                                connLs = item.getConnList();
                                if (null != connLs && connLs.size() >= 1) {
                                    connStr = Joiner.on(",").join(connLs);
                                    entity.setConnList(connStr);
                                }
//                                connLs = item.getApplicantname();
//                                if (null != connLs && connLs.size() >= 1) {
//                                    connStr = Joiner.on(",").join(connLs);
//                                    entity.setApplicantname(connStr);
//                                }
//
//                                connLs = item.getMainCatNum();
//                                if (null != connLs && connLs.size() >= 1) {
//                                    connStr = Joiner.on(",").join(connLs);
//                                    entity.setMainCatNum(connStr);
//                                }
                                entityList.add(entity);
                            }
                            entPatentsInfoService.insertBatch(entityList);
                        }
                    }
                } catch (Exception e) {
                    logger.error("数据异常", e);
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
                    }

                }
//                    }
//                });
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 作品著作权
     *
     * @throws IOException
     */
    @GetMapping("/copy_reg_works")
    public R copyRegWorks() throws IOException {
        String path = rootPath + "/作品著作权/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    Integer status = dtos.getStatus();
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                        ResponsePageNumResultDTO<Open733CopyRegWorksDTO> data = dtos.getData();
                        if (null == data) {
                            throw new SpiderException("data节点数据返回为空");
                        }
                        // 保存数据
                        List<Open733CopyRegWorksDTO> items = data.getItems();
                        if (null != items && items.size() > 0) {
                            entCopyRegWorksService.deleteByEntName(entName);
                            List<EntCopyRegWorksEntity> copyRegWorksEntityList = Lists.newArrayList();
                            EntCopyRegWorksEntity entity = null;
                            for (Open733CopyRegWorksDTO item : items) {
                                entity = new EntCopyRegWorksEntity();
                                BeanUtils.copyProperties(item, entity);

                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());

                                copyRegWorksEntityList.add(entity);
                            }
                            entCopyRegWorksService.insertBatch(copyRegWorksEntityList);
                        }

                    }
                }catch (Exception e){
                    logger.error("数据异常", e);
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
                    }
                }
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 著作权
     *
     * @throws IOException
     */
    @GetMapping("/copy_reg")
    public R copyReg() throws IOException {
        String path = rootPath + "/著作权/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    Integer status = dtos.getStatus();
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                        ResponsePageNumResultDTO<Open441CopyRegDTO> data = dtos.getData();
                        if (null == data) {
                            throw new SpiderException("data节点数据返回为空");
                        }
                        // 保存数据
                        List<Open441CopyRegDTO> items = data.getItems();
                        if (null != items && items.size() > 0) {
                            List<EntCopyRegEntity> copyRegEntityList = Lists.newArrayList();
                            // 先删除 在新增
                            entCopyRegService.deleteByEntName(entName);
                            List<String> connLs = null;
                            EntCopyRegEntity entity = null;
                            String connStr = null;
                            for (Open441CopyRegDTO item : items) {
                                entity = new EntCopyRegEntity();
                                BeanUtils.copyProperties(item, entity);

                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());

                                connLs = item.getConnList();
                                if (null != connLs && connLs.size() > 0) {
                                    connStr = Joiner.on(",").join(connLs);
                                    entity.setConnList(connStr);
                                }

                                copyRegEntityList.add(entity);
                            }
                            entCopyRegService.insertBatch(copyRegEntityList);
                        }
                    }
                }catch ( Exception e){
                    logger.error("数据异常", e);
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
                    }
                }
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 网站备案
     * 空指针问题
     * @throws IOException
     */
    @GetMapping("/icp")
    public R icp() throws IOException {
        String path = rootPath + "/网站备案/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    Integer status = dtos.getStatus();
                    String uuid = dtos.getSeqNum();
                    String message = dtos.getMessage();
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                        ResponsePageNumResultDTO<Open442IcpDTO> data = dtos.getData();
                        if (null == data) {
                            throw new SpiderException("data节点数据返回为空");
                        }
                        String entName = wrapper.getCname();
                        EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                        // 保存数据
                        List<Open442IcpDTO> items = data.getItems();
                        if (null != items && items.size() > 0) {
                            List<EntIcpInfoEntity> icpInfoEntityList = new ArrayList<EntIcpInfoEntity>(items.size());
                            entIcpInfoService.deleteByEntName(entName);
                            List<String> webSiteLs = null;
                            String str = null;
                            for (Open442IcpDTO item : items) {
                                EntIcpInfoEntity entity = new EntIcpInfoEntity();
                                BeanUtils.copyProperties(item, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                webSiteLs = item.getWebSite();
                                if (null != webSiteLs && webSiteLs.size() >= 1) {
                                    str = Joiner.on(",").join(webSiteLs);
                                    entity.setWebsites(str);
                                }

                                icpInfoEntityList.add(entity);
                            }
                            entIcpInfoService.insertBatch(icpInfoEntityList);
                        }
                    }
                }catch ( Exception e){
                    logger.error("数据异常", e);
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
                    }
                }
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

}
