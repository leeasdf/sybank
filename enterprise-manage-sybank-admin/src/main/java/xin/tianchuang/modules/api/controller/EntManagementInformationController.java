package xin.tianchuang.modules.api.controller;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open429BidsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.spider.entity.EntBidsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntNewsInfoEntity;
import xin.tianchuang.modules.spider.service.EntBidsInfoService;
import xin.tianchuang.modules.spider.service.EntEmployInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntNewsInfoService;
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
 * Created by lee on 2019/2/28.
 * 4.1.2.4.经营信息
 * Management information
 */
@RestController
@RequestMapping("/api/import1")
@ApiIgnore
@Deprecated
public class EntManagementInformationController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(EntManagementInformationController.class);

    private static final Splitter splitter = Splitter.on(",");

    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private EntListInfoService entListInfoService;


    //429-招投标
    @Autowired
    private EntBidsInfoService entBidsInfoService;

    //782-- 招聘（新版）
    @Autowired
    private EntEmployInfoService entEmployInfoService;


    /**
     * 429 - 招投标
     * <p>
     * 先跑一遍  字段扩充 conlist 换成clob
     * 结构问题 多了一个[] ---> 找到换掉  有两种 },[{"publishTime"  和 }],[{"publishTime" 吧 ]] ---> ]  25行
     * 网页内容找出来 复制到工具转义在回来处理 16行
     *
     * @throws IOException
     */
    @RequestMapping("/429bids")
    public R bids() throws IOException {
        String path = rootPath + "/招投标/";
        String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="add.txt";

        File file = new File(path, "error1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error2.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {

                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open429BidsDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    if (null != items && items.size() > 0) {

                        entBidsInfoService.deleteByEntName(entName);
                        List<EntBidsInfoEntity> bidsInfoEntityList = new ArrayList<EntBidsInfoEntity>();
                        // 先删除 在新增
                        List<String> connLs = null;
                        EntBidsInfoEntity entity = null;
                        String connStr = null;
                        for (Open429BidsDTO item : items) {
                            entity = new EntBidsInfoEntity();
                            BeanUtils.copyProperties(item, entity);
                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());
                            connLs = item.getConnList();
                            if (connLs != null && connLs.size() >= 1) {
                                connStr = Joiner.on(",").join(connLs);
                                entity.setConnList(connStr);
                            }

                            bidsInfoEntityList.add(entity);
                        }
                        entBidsInfoService.insertBatch(bidsInfoEntityList);


                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    try {
                        bw.write(apiData);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
                return true;
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });
        return R.ok("导入成功");
    }


    /**
     * 782 - 招聘（新版）
     * <p>
     * 字段超长 所以整体表字段都扩大了
     * 后面还有超长的 又一次扩大部分数据
     * 文件里面"/"的处理 识别为转义字符了
     * 文件有些""的处理
     *
     * @throws IOException
     */
    @RequestMapping("/782employmentsV2")
    public R employmentsV2() throws IOException {
        String path = rootPath + "/招聘新版/";
        String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="add.txt";

        File file = new File(path, "error.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error1.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open782EmploymentsV2DTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    if (null != items && items.size() > 0) {

                        entEmployInfoService.deleteByEntName(entName);
                        List<EntEmployInfoEntity> employInfoEntityList = new ArrayList<EntEmployInfoEntity>(items.size());
                        EntEmployInfoEntity entity = null;
                        for (Open782EmploymentsV2DTO item : items) {
                            entity = new EntEmployInfoEntity();
                            BeanUtils.copyProperties(item, entity);

                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());

                            employInfoEntityList.add(entity);
                        }
                        entEmployInfoService.insertBatch(employInfoEntityList);

                        }

                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    try {
                        bw.write(apiData);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
                return true;
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });
        return R.ok("导入成功");
    }


    //446 - 获取公司新闻列表
    @Autowired
    private EntNewsInfoService entNewsInfoService;


    /**
     * 446 - 获取公司新闻列表
     * 1.先5个线程跑了大概一个半小时 问题数据->bak.txt
     * 2.大概有200行 其内容中有引号没有转译破坏了json结构所以手动处理大概1小时bak.json
     * 3。跑bak.json-->问题数据bak1.json  20多条
     * 4.企业名称有繁体字啥的名称不对 根据ccode找到正确的名称再跑 bak2.json 4条
     * 5，转译小问题处理掉
     *
     * @throws IOException
     */
    @RequestMapping("/446news")
    public R news() throws IOException {
        String path = rootPath + "/获取公司新闻列表/";
        String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="bak2.json";

        File file = new File(path, "error2.json");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error3.json")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                        try {
                            // 这里处理一行字符串
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>>>>() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>>> result = gson.fromJson(apiData, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>> dtos = result.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }

                            String entName = result.getCname();
                            // 保存数据
                            List<Open446NewsDTO> items = dtos.getData().getItems();
                            EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                            if (null == listInfoEntity) {
                                throw new SpiderException("系统异常，请稍后再试");
                            }
                            if (null != items && items.size() > 0) {
                                List<EntNewsInfoEntity> newsInfoEntityList = new ArrayList<EntNewsInfoEntity>(items.size());
                                // 先删除 在新增
                                entNewsInfoService.deleteByEntName(entName);
                                for (Open446NewsDTO item : items) {
                                    EntNewsInfoEntity entity = new EntNewsInfoEntity();
                                    BeanUtils.copyProperties(item, entity);
                                    entity.setEntId(listInfoEntity.getId());
                                    entity.setEntName(entName);
                                    entity.setCreditCode(listInfoEntity.getCreditCode());
                                    newsInfoEntityList.add(entity);
                                }
                                entNewsInfoService.insertBatch(newsInfoEntityList);

                            }
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);
                            try {
                                bw.write(apiData);
                                bw.flush();
                                bw.newLine();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                return true;
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });
        return R.ok("导入成功");
    }

}
