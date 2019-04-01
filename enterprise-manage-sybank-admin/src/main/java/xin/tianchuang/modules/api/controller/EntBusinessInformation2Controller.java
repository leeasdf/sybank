package xin.tianchuang.modules.api.controller;

import com.alibaba.druid.support.json.JSONUtils;
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
import xin.tianchuang.common.enums.HolderCaptialEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.*;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.spider.entity.*;
import xin.tianchuang.modules.spider.service.*;
import xin.tianchuang.modules.sys.controller.AbstractController;

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
 * Created by lee on 2019/3/2.
 * 4.1.2.1.工商信息
 */
@RestController
@RequestMapping("/api/import1")
//@ApiIgnore
public class EntBusinessInformation2Controller extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(EntBusinessInformation2Controller.class);


    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";
    private ExecutorService executorService = Executors.newFixedThreadPool(6);

    @Autowired
    private EntListInfoService entListInfoService;

    @Autowired
    private EntHolderInfoService entHolderInfoService;
    @Autowired
    private EntHolderCapitalService entHolderCapitalService;
    @Autowired
    private EntInverstInfoService entInverstInfoService;
    @Autowired
    private EntChangeInfoService entChangeInfoService;

    /**
     * 股东信息
     */
    @GetMapping("/holder")
    public R holder() throws IOException {
        String path = rootPath + "/股东信息/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>>>>() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>>> wrapper = gson.fromJson(line, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>> dtos = wrapper.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }
                            Integer status = dtos.getStatus();
                            String uuid = dtos.getSeqNum();
                            String message = dtos.getMessage();
                            BaseRespnseDTO<List<Open368HolderDTO>> rtnDTO = new BaseRespnseDTO<List<Open368HolderDTO>>();
                            rtnDTO.setRtnSerialNo(uuid);
                            rtnDTO.setCode(status);
                            rtnDTO.setMsg(message);

                            if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                                ResponsePageNumResultDTO<Open368HolderDTO> data = dtos.getData();
                                if (null == data) {
                                    throw new SpiderException("data节点数据返回为空");
                                }
                                String entName = wrapper.getCname();
                                EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                                List<Open368HolderDTO> items = data.getItems();
                                if (null != items && items.size() > 0) {
                                    // 先删除
                                    entHolderInfoService.deleteByEntName(entName);
                                    entHolderCapitalService.deleteByEntName(entName);
                                    //  在新增
                                    List<EntHolderInfoEntity> list = new ArrayList<EntHolderInfoEntity>(items.size());
                                    List<EntHolderCapitalEntity> entHolderInfolist = Lists.newArrayList();
                                    for (Open368HolderDTO item : items) {
                                        EntHolderInfoEntity holderInfoEntity = new EntHolderInfoEntity();
                                        BeanUtils.copyProperties(item, holderInfoEntity);
                                        holderInfoEntity.setEntId(listInfoEntity.getId());
                                        holderInfoEntity.setEntName(entName);
                                        holderInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
                                        list.add(holderInfoEntity);

                                        List<Open368HolderCapitalDTO> capitalLs = item.getCapital();
                                        if (null != capitalLs && capitalLs.size() > 0) {
                                            for (Open368HolderCapitalDTO capital : capitalLs) {
                                                EntHolderCapitalEntity capitalEntity = new EntHolderCapitalEntity();
                                                BeanUtils.copyProperties(capital, capitalEntity);
                                                capitalEntity.setEntName(entName);
                                                capitalEntity.setHolderName(holderInfoEntity.getName());
                                                capitalEntity.setType(HolderCaptialEnum.CAPITAL.key());

                                                entHolderInfolist.add(capitalEntity);
                                            }
                                        }
                                        List<Open368HolderCapitalActlDTO> capitalActlLs = item.getCapitalActl();
                                        if (null != capitalActlLs && capitalActlLs.size() > 0) {
                                            for (Open368HolderCapitalActlDTO capitalActl : capitalActlLs) {
                                                EntHolderCapitalEntity capitalActlEntity = new EntHolderCapitalEntity();
                                                BeanUtils.copyProperties(capitalActl, capitalActlEntity);
                                                capitalActlEntity.setEntName(entName);
                                                capitalActlEntity.setHolderName(holderInfoEntity.getName());
                                                capitalActlEntity.setType(HolderCaptialEnum.CAPITAL_ACTL.key());

                                                entHolderInfolist.add(capitalActlEntity);
                                            }
                                        }
                                    }
                                    if (entHolderInfolist.size() > 0) {
                                        entHolderCapitalService.insertBatch(entHolderInfolist);
                                    }
                                    entHolderInfoService.insertBatch(list);
                                }
                            }
                        } catch (Exception e) {
                            logger.error(line, e);
                            try {
                                bw.write(line);
                                bw.flush();
                                bw.newLine();
                            } catch (IOException e1) {
                                logger.error("写文件异常", e1);
                            }
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
     * 对外投资
     *
     * @throws IOException
     */
    @GetMapping("/inverst")
    public R inverst() throws IOException {
        String path = rootPath + "/对外投资/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try{
                Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>>>>() {
                }.getType(); //
                ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>>> wrapper = gson.fromJson(line, jsonType);
                TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>> dtos = wrapper.getResult();
                if (dtos == null) { // 成功
                    throw new SpiderException("数据返回为空");
                }
                Integer status = dtos.getStatus();
                String uuid = dtos.getSeqNum();
                String message = dtos.getMessage();
                if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                    ResponsePageNumResultDTO<Open369InverstDTO> data = dtos.getData();
                    if (null == data) {
                        throw new SpiderException("data节点数据返回为空");
                    }
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    List<Open369InverstDTO> items = data.getItems();
                    if (null != items && items.size() > 0) {
                        // 先删除 在新增
                        entInverstInfoService.deleteByEntName(entName);
                        List<EntInverstInfoEntity> list = new ArrayList<EntInverstInfoEntity>(items.size());
                        for (Open369InverstDTO item : items) {
                            EntInverstInfoEntity inverstInfoEntity = new EntInverstInfoEntity();
                            BeanUtils.copyProperties(item, inverstInfoEntity);
                            inverstInfoEntity.setEntId(listInfoEntity.getId());
                            inverstInfoEntity.setEntName(entName);
                            inverstInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
                            list.add(inverstInfoEntity);
                        }
                        entInverstInfoService.insertBatch(list);
                    }
                }}catch (Exception e){
                    logger.error(line, e);
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
     * 变更记录
     * 刚哥指导的翻页中括号问题
     *
     */
    @GetMapping("/changeinfo")
    public R changeinfo(String file1, String file2) throws IOException {
        String path = rootPath + "/变更记录/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>>>>() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>>> wrapper = gson.fromJson(line, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>> dtos = wrapper.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }
                            Integer status = dtos.getStatus();
                            String uuid = dtos.getSeqNum();
                            String message = dtos.getMessage();
                            if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                                ResponsePageNumResultDTO<Open370ChangeinfoDTO> data = dtos.getData();
                                if (null == data) {
                                    throw new SpiderException("data节点数据返回为空");
                                }
                                String entName = wrapper.getCname();
                                EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                                List<Open370ChangeinfoDTO> items = data.getItems();
                                if (null != items && items.size() > 0) {
                                    entChangeInfoService.deleteByEntName(entName);
                                    List<EntChangeInfoEntity> list = Lists.newArrayList();
                                    EntChangeInfoEntity entity = null;
                                    for (Open370ChangeinfoDTO item : items) {
                                        entity = new EntChangeInfoEntity();
                                        BeanUtils.copyProperties(item, entity);
                                        entity.setEntId(listInfoEntity.getId());
                                        entity.setEntName(entName);
                                        entity.setCreditCode(listInfoEntity.getCreditCode());

                                        list.add(entity);
                                    }
                                    entChangeInfoService.insertBatch(list);
                                }
                            }
                        } catch (Exception e) {
                            logger.error(line, e);
                            try {
                                bw.write(line);
                                bw.newLine();
                                bw.flush();
                            } catch (IOException e1) {
                                logger.error("写文件异常", e1);
                            }
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

}
