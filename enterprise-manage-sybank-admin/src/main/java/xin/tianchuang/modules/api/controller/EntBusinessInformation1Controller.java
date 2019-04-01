package xin.tianchuang.modules.api.controller;

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
@Deprecated
public class EntBusinessInformation1Controller extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(EntBusinessInformation1Controller.class);

    private static final Splitter splitter = Splitter.on(",");

    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";

    private ExecutorService executorService = Executors.newFixedThreadPool(5);


    @Autowired
    private EntListInfoService entListInfoService;


    //372-分支机构
    @Autowired
    private EntBranchInfoService entBranchInfoService;


    //371-企业年报
    @Autowired
    private EntAnnualreportInfoService entAnnualreportInfoService;
    @Autowired
    private EntAnnualreportWebInfoService entAnnualreportWebInfoService;
    @Autowired
    private EntAnnualreportSocialSecurityService entAnnualreportSocialSecurityService;
    @Autowired
    private EntAnnualreportShareholderService entAnnualreportShareholderService;
    @Autowired
    private EntAnnualreportBaseInfoService entAnnualreportBaseInfoService;
    @Autowired
    private EntAnnualreportChangeRecordService entAnnualreportChangeRecordService;
    @Autowired
    private EntAnnualreportEquityChangeInfoService entAnnualreportEquityChangeInfoService;
    @Autowired
    private EntAnnualreportOutboundInvestmentService entAnnualreportOutboundInvestmentService;
    @Autowired
    private EntAnnualreportOutGuaranteeInfoService entAnnualreportOutGuaranteeInfoService;


    /**
     * 372 - 分支机构
     * <p>
     * 1、处理 },[{"regStatus":"注销"   和   }],[{"regStatus":"注销"    --->   },{"regStatus":"注销"    ]] --> ]
     * 不完整
     * <p>
     * 2、处理 }],[{   和 },[{ ---> },{
     * ]] --> ]
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/372branch")
    public R branch() throws IOException {
        String path = rootPath + "/分支机构/";
        String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="add.txt";

        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                        try {
                            // 这里处理一行字符串
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<
                                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>>>
                                    >() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>>>
                                    result = gson.fromJson(apiData, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>> dtos = result.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }

                            String entName = result.getCname();
                            // 保存数据
                            List<Open372BranchDTO> items = dtos.getData().getItems();
                            EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                            if (null == listInfoEntity) {
                                throw new SpiderException("系统异常，请稍后再试");
                            }
                            if (null != items && items.size() > 0) {

                                entBranchInfoService.deleteByEntName(entName);
                                EntBranchInfoEntity entity = null;
                                List<EntBranchInfoEntity> list = new ArrayList<EntBranchInfoEntity>();
                                for (Open372BranchDTO item : items) {
                                    entity = new EntBranchInfoEntity();
                                    BeanUtils.copyProperties(item, entity);
                                    entity.setEntId(listInfoEntity.getId());
                                    entity.setEntName(entName);
                                    entity.setCreditCode(listInfoEntity.getCreditCode());

                                    list.add(entity);
                                }
                                entBranchInfoService.insertBatch(list);

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

    /**
     * 371 - 企业年报
     * 字段扩大 爬虫程序问题补充数据 企业有三个bak中1、3、6行
     *
     * @return
     * @throws IOException
     */
        @RequestMapping("/371annualreport")
    public R annualreport() throws IOException {
        String path = rootPath + "/企业年报/";
        String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="bak.txt";

        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>>>
                            >() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>>>
                            result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open371AnnualreportDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }

                    Open371AnnualreportBaseInfoDTO baseInfo = null;
                    EntAnnualreportInfoEntity entAnnualreportInfoEntity = null;
                    EntAnnualreportBaseInfoEntity baseInfoEntity = null;
                    for (Open371AnnualreportDTO item : items) {
                        baseInfo = item.getBaseInfo();
                        String belongYear = baseInfo.getReportYear();
                        entAnnualreportInfoService.deleteByEntNameBlongYear(entName, belongYear);

                        entAnnualreportInfoEntity = new EntAnnualreportInfoEntity();
                        BeanUtils.copyProperties(item, entAnnualreportInfoEntity);
                        entAnnualreportInfoEntity.setEntId(listInfoEntity.getId());
                        entAnnualreportInfoEntity.setEntName(entName);
                        entAnnualreportInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
                        entAnnualreportInfoEntity.setBelongYear(belongYear);
                        entAnnualreportInfoService.insert(entAnnualreportInfoEntity);

                        entAnnualreportBaseInfoService.deleteByEntNameReportYear(entName, belongYear);
                        baseInfoEntity = new EntAnnualreportBaseInfoEntity();
                        BeanUtils.copyProperties(baseInfo, baseInfoEntity);
                        baseInfoEntity.setEntId(listInfoEntity.getId());
                        baseInfoEntity.setEntName(entName);
                        baseInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
                        baseInfoEntity.setBelongYear(belongYear);
                        entAnnualreportBaseInfoService.insert(baseInfoEntity);

                        List<Open371AnnualreportChangeRecordDTO> changeRecordList = item.getChangeRecordList();
                        List<EntAnnualreportChangeRecordEntity> changeRecordEntityList = new ArrayList<EntAnnualreportChangeRecordEntity>();
                        if (null != changeRecordList && changeRecordList.size() > 0) {
                            entAnnualreportChangeRecordService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportChangeRecordEntity entity = null;
                            for (Open371AnnualreportChangeRecordDTO dto : changeRecordList) {
                                entity = new EntAnnualreportChangeRecordEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                changeRecordEntityList.add(entity);
                            }
                            entAnnualreportChangeRecordService.insertBatch(changeRecordEntityList);
                        }
                        List<Open371AnnualreportEquityChangeInfoDTO> equityChangeInfoList = item.getEquityChangeInfoList();
                        List<EntAnnualreportEquityChangeInfoEntity> entAnnualreportEquityChangeInfoEntityList = new ArrayList<EntAnnualreportEquityChangeInfoEntity>();
                        if (null != equityChangeInfoList && equityChangeInfoList.size() > 0) {
                            entAnnualreportEquityChangeInfoService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportEquityChangeInfoEntity entity = null;
                            for (Open371AnnualreportEquityChangeInfoDTO dto : equityChangeInfoList) {
                                entity = new EntAnnualreportEquityChangeInfoEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                entAnnualreportEquityChangeInfoEntityList.add(entity);
                            }
                            entAnnualreportEquityChangeInfoService.insertBatch(entAnnualreportEquityChangeInfoEntityList);
                        }

                        List<Open371AnnualreportOutGuaranteeInfoDTO> outGuaranteeInfoList = item.getOutGuaranteeInfoList();
                        List<EntAnnualreportOutGuaranteeInfoEntity> outGuaranteeInfoEntityList = new ArrayList<EntAnnualreportOutGuaranteeInfoEntity>();
                        if (null != outGuaranteeInfoList && outGuaranteeInfoList.size() > 0) {
                            entAnnualreportOutGuaranteeInfoService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportOutGuaranteeInfoEntity entity = null;
                            for (Open371AnnualreportOutGuaranteeInfoDTO dto : outGuaranteeInfoList) {
                                entity = new EntAnnualreportOutGuaranteeInfoEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                outGuaranteeInfoEntityList.add(entity);
                            }
                            entAnnualreportOutGuaranteeInfoService.insertBatch(outGuaranteeInfoEntityList);
                        }
                        List<Open371AnnualreportOutboundInvestmentDTO> outboundInvestmentList = item.getOutboundInvestmentList();
                        List<EntAnnualreportOutboundInvestmentEntity> outboundInvestmentEntityList = new ArrayList<EntAnnualreportOutboundInvestmentEntity>();
                        if (null != outboundInvestmentList && outboundInvestmentList.size() > 0) {
                            entAnnualreportOutboundInvestmentService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportOutboundInvestmentEntity entity = null;
                            for (Open371AnnualreportOutboundInvestmentDTO dto : outboundInvestmentList) {
                                entity = new EntAnnualreportOutboundInvestmentEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                outboundInvestmentEntityList.add(entity);
                            }
                            entAnnualreportOutboundInvestmentService.insertBatch(outboundInvestmentEntityList);
                        }
                        List<Open371AnnualreportShareholderDTO> shareholderList = item.getShareholderList();
                        List<EntAnnualreportShareholderEntity> shareholderEntityList = new ArrayList<EntAnnualreportShareholderEntity>();
                        if (null != shareholderList && shareholderList.size() > 0) {
                            entAnnualreportShareholderService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportShareholderEntity entity = null;
                            for (Open371AnnualreportShareholderDTO dto : shareholderList) {
                                entity = new EntAnnualreportShareholderEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                shareholderEntityList.add(entity);
                            }
                            entAnnualreportShareholderService.insertBatch(shareholderEntityList);
                        }
                        List<Open371AnnualreportWebInfoDTO> webInfoList = item.getWebInfoList();
                        List<EntAnnualreportWebInfoEntity> webInfoEntityList = new ArrayList<EntAnnualreportWebInfoEntity>();
                        if (null != webInfoList && webInfoList.size() > 0) {
                            entAnnualreportWebInfoService.deleteByEntNameBelongYear(entName, belongYear);
                            EntAnnualreportWebInfoEntity entity = null;
                            for (Open371AnnualreportWebInfoDTO dto : webInfoList) {
                                entity = new EntAnnualreportWebInfoEntity();
                                BeanUtils.copyProperties(dto, entity);
                                entity.setEntId(listInfoEntity.getId());
                                entity.setEntName(entName);
                                entity.setCreditCode(listInfoEntity.getCreditCode());
                                entity.setBelongYear(belongYear);

                                webInfoEntityList.add(entity);
                            }
                            entAnnualreportWebInfoService.insertBatch(webInfoEntityList);
                        }
                        Open371AnnualreportReportSocialSecurityInfoDTO reportSocialSecurityInfo = item.getReportSocialSecurityInfo();
                        if (null != reportSocialSecurityInfo) {
                            entAnnualreportSocialSecurityService.deleteByAnnanlreportId(reportSocialSecurityInfo.getAnnaulreportId());
                            EntAnnualreportSocialSecurityEntity entity = new EntAnnualreportSocialSecurityEntity();
                            BeanUtils.copyProperties(reportSocialSecurityInfo, entity);
                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());
                            entity.setBelongYear(belongYear);

                            entAnnualreportSocialSecurityService.insert(entity);
                        }
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
