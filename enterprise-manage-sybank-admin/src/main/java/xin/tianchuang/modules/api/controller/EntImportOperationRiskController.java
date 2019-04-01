package xin.tianchuang.modules.api.controller;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.enums.EntEquityPledgeeTypeEnum;
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
 * 经营异常数据导入
 */
@RestController
@RequestMapping("/api/import1")
@ApiIgnore
@Deprecated
public class EntImportOperationRiskController {

    private static final Splitter splitter = Splitter.on(",");

    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private EntAbnormalInfoService entAbnormalInfoService;
    @Autowired
    private EntListInfoService entListInfoService;
    @Autowired
    private EntPunishCreditChinaService entPunishCreditChinaService;
    @Autowired
    private EntEquityPledgeeInfoService entEquityPledgeeInfoService;
    @Autowired
    private EntEquityInfoService entEquityInfoService;
    @Autowired
    private EntMortgageBaseInfoService entMortgageBaseInfoService;
    @Autowired
    private EntMortgagePeopleInfoService entMortgagePeopleInfoService;
    @Autowired
    private EntMortgagePawnInfoService entMortgagePawnInfoService;
    @Autowired
    private EntMortgageChangeInfoService entMortgageChangeInfoService;
    @Autowired
    private EntOwnTaxService entOwnTaxService;

    /**
     * 经营异常
     *
     * @throws IOException
     */
    @GetMapping("/abnormal")
    public void abnormal() throws IOException {
        String path = rootPath + "/经营异常/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    Integer status = dtos.getStatus();
                    String uuid = dtos.getSeqNum();
                    String message = dtos.getMessage();
                    ResponsePageNumResultDTO<Open391AbnormalDTO> data = dtos.getData();
                    if (null == data) {
                        throw new SpiderException("data节点数据返回为空");
                    }
                    // 保存数据
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    List<Open391AbnormalDTO> items = data.getItems();
                    if (null != items && items.size() > 0) {
                        // 先删除 在新增
                        entAbnormalInfoService.deleteByEntName(entName);
                        List<EntAbnormalInfoEntity> list = Lists.newArrayList();
                        EntAbnormalInfoEntity entity = null;
                        for (Open391AbnormalDTO item : items) {
                            entity = new EntAbnormalInfoEntity();
                            BeanUtils.copyProperties(item, entity);
                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());
                            list.add(entity);
                        }
                        entAbnormalInfoService.insertBatch(list);
                    }
                } catch (Exception e) {
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
                return true;// 如果是false，则会中断读取操作
            }
            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

    }

    /**
     * 767-行政处罚--信用中国（新版）
     *
     * @throws IOException
     */
    @GetMapping("/credit_china_v2")
    public R creditChinaV2() throws IOException {
        String path = rootPath + "/行政处罚信用中国新版/";
//        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, "error.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error1.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    Integer status = dtos.getStatus();
                    String uuid = dtos.getSeqNum();
                    String message = dtos.getMessage();
                    ResponsePageNumResultDTO<Open767CreditChinaV2DTO> data = dtos.getData();
                    if (null == data) {
                        throw new SpiderException("data节点数据返回为空");
                    }
                    // 保存数据
                    List<Open767CreditChinaV2DTO> items = data.getItems();
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null != items && items.size() > 0) {
                        // 先删除 在新增
                        entPunishCreditChinaService.deleteByEntName(entName);
                        List<EntPunishCreditChinaEntity> list = new ArrayList<EntPunishCreditChinaEntity>();
                        EntPunishCreditChinaEntity entity = null;
                        for (Open767CreditChinaV2DTO item : items) {
                            entity = new EntPunishCreditChinaEntity();
                            BeanUtils.copyProperties(item, entity);
                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());
                            list.add(entity);

                        }
                        entPunishCreditChinaService.insertBatch(list);

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

                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 股权出质
     *
     * @throws IOException
     */
    @GetMapping("equity_info")
    public R equityInfo() throws IOException {
        String path = rootPath + "/股权出质/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {
                try{
                Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>>>>() {
                }.getType(); //
                ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>>> wrapper = gson.fromJson(line, jsonType);
                TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>> dtos = wrapper.getResult();

                if (dtos == null) { // 成功
                    throw new SpiderException("数据返回为空");
                }
                Integer status = dtos.getStatus();
                String uuid = dtos.getSeqNum();
                String message = dtos.getMessage();
                ResponsePageNumResultDTO<Open404EquityInfoDTO> data = dtos.getData();
                if (null == data) {
                    throw new SpiderException("data节点数据返回为空");
                }
                // 保存数据
                String entName = wrapper.getCname();
                EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                List<Open404EquityInfoDTO> items = data.getItems();
                if (null != items && items.size() > 0) {

                    // 先删除 在新增
                    entEquityInfoService.deleteByEntName(entName);
                    entEquityPledgeeInfoService.deleteByEntName(entName);
                    List<EntEquityInfoEntity> list = new ArrayList<EntEquityInfoEntity>(items.size());
                    List<EntEquityPledgeeInfoEntity> entEquityPledgeeInfolist = new ArrayList<EntEquityPledgeeInfoEntity>();
                    for (Open404EquityInfoDTO item : items) {
                        EntEquityInfoEntity entity = new EntEquityInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());
                        list.add(entity);

                        List<Open404EquityInfoPledgeeListDTO> companyLs = item.getCompanyList();
                        if (null != companyLs && companyLs.size() > 0) {
                            for (Open404EquityInfoPledgeeListDTO company : companyLs) {
                                EntEquityPledgeeInfoEntity companyEntity = new EntEquityPledgeeInfoEntity();
                                BeanUtils.copyProperties(company, companyEntity);
                                companyEntity.setEntId(listInfoEntity.getId());
                                companyEntity.setEntName(entName);
                                companyEntity.setType(EntEquityPledgeeTypeEnum.COMPANY.key());
                                companyEntity.setRegNumber(entity.getRegNumber());

                                entEquityPledgeeInfolist.add(companyEntity);
                            }
                        }
                        List<Open404EquityInfoPledgeeListDTO> pledgeeLs = item.getPledgeeList();
                        if (null != pledgeeLs && pledgeeLs.size() > 0) {
                            for (Open404EquityInfoPledgeeListDTO pledgee : pledgeeLs) {
                                EntEquityPledgeeInfoEntity pledgeeEntity = new EntEquityPledgeeInfoEntity();
                                BeanUtils.copyProperties(pledgee, pledgeeEntity);
                                pledgeeEntity.setEntId(listInfoEntity.getId());
                                pledgeeEntity.setEntName(entName);
                                pledgeeEntity.setType(EntEquityPledgeeTypeEnum.PLEDGEE.key());
                                pledgeeEntity.setRegNumber(entity.getRegNumber());

                                entEquityPledgeeInfolist.add(pledgeeEntity);
                            }
                        }
                        List<Open404EquityInfoPledgeeListDTO> pledgorLs = item.getPledgorList();
                        if (null != pledgorLs && pledgorLs.size() > 0) {
                            for (Open404EquityInfoPledgeeListDTO pledgor : pledgorLs) {
                                EntEquityPledgeeInfoEntity pledgorEntity = new EntEquityPledgeeInfoEntity();
                                BeanUtils.copyProperties(pledgor, pledgorEntity);
                                pledgorEntity.setEntId(listInfoEntity.getId());
                                pledgorEntity.setEntName(entName);
                                pledgorEntity.setType(EntEquityPledgeeTypeEnum.PLEDGOR.key());
                                pledgorEntity.setRegNumber(entity.getRegNumber());

                                entEquityPledgeeInfolist.add(pledgorEntity);
                            }
                        }
                    }
                    if (entEquityPledgeeInfolist.size() > 0) {
                        entEquityPledgeeInfoService.insertBatch(entEquityPledgeeInfolist);
                    }
                    entEquityInfoService.insertBatch(list);
                }
                }catch (Exception e){
                    try {
                        bw.write(line);
                        bw.flush();
                        bw.newLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
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
     * 动产抵押
     *
     * @throws IOException
     */
    @GetMapping("/mortgage_info")
    public R mortgageInfo() throws IOException {
        String path = rootPath + "/动产抵押/";
//        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, "error.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error1.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(final String line) throws IOException {

                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>>> wrapper = gson.fromJson(line, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>> dtos = wrapper.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    Integer status = dtos.getStatus();
                    String entName = wrapper.getCname();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) {

                        List<Open421MortgageInfoDTO> items = dtos.getData().getItems();
                        // 先删除 在新增
                        entMortgageBaseInfoService.deleteByEntName(entName);
                        List<EntMortgageBaseInfoEntity> list = new ArrayList<EntMortgageBaseInfoEntity>(items.size());
                        List<EntMortgageChangeInfoEntity> mortgageChangeInfoEntityList = new ArrayList<EntMortgageChangeInfoEntity>();
                        List<EntMortgagePawnInfoEntity> mortgagePawnInfoEntityList = new ArrayList<EntMortgagePawnInfoEntity>();
                        List<EntMortgagePeopleInfoEntity> mortgagePeopleInfoList = new ArrayList<EntMortgagePeopleInfoEntity>();
                        for (Open421MortgageInfoDTO item : items) {
                            // 基本信息
                            EntMortgageBaseInfoEntity entity = new EntMortgageBaseInfoEntity();
                            BeanUtils.copyProperties(item.getBaseInfo(), entity);
                            entity.setEntId(listInfoEntity.getId());
                            entity.setEntName(entName);
                            entity.setCreditCode(listInfoEntity.getCreditCode());
                            list.add(entity);
                            // 变更信息
                            List<Open421MortgageChangeInfoListDTO> changeInfoList = item.getChangeInfoList();
                            if (null != changeInfoList && changeInfoList.size() > 0) {
                                entMortgageChangeInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
                                for (Open421MortgageChangeInfoListDTO changeInfo : changeInfoList) {
                                    EntMortgageChangeInfoEntity changeInfoEntity = new EntMortgageChangeInfoEntity();
                                    BeanUtils.copyProperties(changeInfo, changeInfoEntity);
                                    changeInfoEntity.setEntId(listInfoEntity.getId());
                                    changeInfoEntity.setEntName(entName);
                                    changeInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
                                    changeInfoEntity.setRegNum(entity.getRegNum());
                                    mortgageChangeInfoEntityList.add(changeInfoEntity);
                                }
                            }
                            // 资产信息
                            List<Open421MortgagePawnInfoListDTO> pawnInfoList = item.getPawnInfoList();
                            if (null != pawnInfoList && pawnInfoList.size() > 0) {
                                entMortgagePawnInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
                                for (Open421MortgagePawnInfoListDTO pawn : pawnInfoList) {
                                    EntMortgagePawnInfoEntity pawnEntity = new EntMortgagePawnInfoEntity();
                                    BeanUtils.copyProperties(pawn, pawnEntity);
                                    pawnEntity.setEntId(listInfoEntity.getId());
                                    pawnEntity.setEntName(entName);
                                    pawnEntity.setCreditCode(listInfoEntity.getCreditCode());
                                    pawnEntity.setRegNum(entity.getRegNum());
                                    mortgagePawnInfoEntityList.add(pawnEntity);
                                }
                            }
                            // 抵押信息
                            List<Open421MortgagePeopleInfoDTO> peopleInfo = item.getPeopleInfo();
                            if (null != peopleInfo && peopleInfo.size() > 0) {
                                entMortgagePeopleInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
                                for (Open421MortgagePeopleInfoDTO people : peopleInfo) {
                                    EntMortgagePeopleInfoEntity peopleEntity = new EntMortgagePeopleInfoEntity();
                                    BeanUtils.copyProperties(people, peopleEntity);
                                    peopleEntity.setEntId(listInfoEntity.getId());
                                    peopleEntity.setEntName(entName);
                                    peopleEntity.setCreditCode(listInfoEntity.getCreditCode());
                                    peopleEntity.setRegNum(entity.getRegNum());
                                    mortgagePeopleInfoList.add(peopleEntity);
                                }
                            }
                        }
                        if (mortgageChangeInfoEntityList.size() > 0) {
                            entMortgageChangeInfoService.insertBatch(mortgageChangeInfoEntityList);
                        }
                        if (mortgagePawnInfoEntityList.size() > 0) {
                            entMortgagePawnInfoService.insertBatch(mortgagePawnInfoEntityList);
                        }
                        if (mortgagePeopleInfoList.size() > 0) {
                            entMortgagePeopleInfoService.insertBatch(mortgagePeopleInfoList);
                        }
                        entMortgageBaseInfoService.insertBatch(list);

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
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

        return R.ok("导入成功");
    }

    /**
     * 欠税公告
     *
     * @throws IOException
     */
    @GetMapping("/own_tax")
    public void ownTax() throws IOException {
        String path = rootPath + "/欠税公告/";
        String fileName = "callSuccessful.txt_file3.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "error.txt")));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String line) throws IOException {

                        try {
                            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                            Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>>>>() {
                            }.getType(); //
                            ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>>> wrapper = gson.fromJson(line, jsonType);
                            TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>> dtos = wrapper.getResult();
                            if (dtos == null) { // 成功
                                throw new SpiderException("数据返回为空");
                            }
                            Integer status = dtos.getStatus();
                            String entName = wrapper.getCname();
                            EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                            if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
                                ResponsePageNumResultDTO<Open422OwnTaxDTO> data = dtos.getData();
                                if (null == data) {
                                    throw new SpiderException("data节点数据返回为空");
                                }
                                // 保存数据
                                List<Open422OwnTaxDTO> items = data.getItems();
                                if (null != items && items.size() > 0) {
                                    // 先删除 在新增
                                    entOwnTaxService.deleteByEntName(entName);
                                    List<EntOwnTaxEntity> ownTaxEntityList = Lists.newArrayList();
                                    EntOwnTaxEntity entity = null;
                                    for (Open422OwnTaxDTO item : items) {

                                        entity = new EntOwnTaxEntity();
                                        BeanUtils.copyProperties(item, entity);
                                        entity.setEntId(listInfoEntity.getId());
                                        entity.setEntName(entName);
                                        entity.setCreditCode(listInfoEntity.getCreditCode());

                                        ownTaxEntityList.add(entity);
                                    }
                                    entOwnTaxService.insertBatch(ownTaxEntityList);
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
                return true;// 如果是false，则会中断读取操作
            }

            public String getResult() {
                return null;// 返回的结果。可以自定义
            }
        });

    }
}
