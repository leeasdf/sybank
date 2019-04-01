package xin.tianchuang.modules.api.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open384LawSuitDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CompanyListDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDefendantDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementPlaintiffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2StaffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePerPageNumResultDTO;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.tyc.LawSuitHandler;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceCompanyEntity;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestStaffEntity;
import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;
import xin.tianchuang.modules.spider.entity.EntLawsuitInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceCompanyService;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceInfoService;
import xin.tianchuang.modules.spider.service.EntDishonestInfoService;
import xin.tianchuang.modules.spider.service.EntDishonestStaffService;
import xin.tianchuang.modules.spider.service.EntKtannounceInfoService;
import xin.tianchuang.modules.spider.service.EntKtannouncePeopleInfoService;
import xin.tianchuang.modules.spider.service.EntLawsuitInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntZhixingInfoService;
import xin.tianchuang.modules.sys.controller.AbstractController;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by lee on 2019/2/28.
 * 4.1.2.2.司法风险
 * Judicial Risk
 */
@RestController
@RequestMapping("/api/import1")
@ApiIgnore
@Deprecated
public class EntJudicialRiskController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(EntJudicialRiskController.class);


    private static final Splitter splitter = Splitter.on(",");

    private static final String rootPath = "/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";

    @Autowired
    private EntListInfoService entListInfoService;

    //384-法律诉讼
    @Autowired
    private EntLawsuitInfoService entLawsuitInfoService;

    //385-法院公告
    @Autowired
    private EntCourtAnnounceInfoService entCourtAnnounceInfoService;
    @Autowired
    private EntCourtAnnounceCompanyService entCourtAnnounceCompanyService;

    //386-开庭公告
    @Autowired
    private EntKtannounceInfoService entKtannounceInfoService;
    @Autowired
    private EntKtannouncePeopleInfoService entKtannouncePeopleInfoService;


    //777 - 失信人（新版）
    @Autowired
    private EntDishonestInfoService entDishonestInfoService;
    @Autowired
    private EntDishonestStaffService entDishonestStaffService;


    //389-被执行人
    @Autowired
    private EntZhixingInfoService entZhixingInfoService;

    /**
     * 384 - 法律诉讼
     *
     * @throws IOException
     */
    @RequestMapping("/384lawSuit")
    public R lawSuit() throws IOException {
        String path = rootPath + "/法律诉讼/";
        String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="test1.json";
        String file1 = "error.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file1)));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData)  {
                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open384LawSuitDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    entLawsuitInfoService.deleteByEntName(entName);
                    List<String> connLs = null;
                    List<EntLawsuitInfoEntity> list = new ArrayList<EntLawsuitInfoEntity>(items.size());
                    for (Open384LawSuitDTO item : items) {
                        EntLawsuitInfoEntity entity = new EntLawsuitInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());

                        connLs = item.getConnList();
                        String connStr = Joiner.on(",").join(connLs);
                        entity.setConnList(connStr);
                        list.add(entity);
                    }
                    entLawsuitInfoService.insertBatch(list);
                }catch (Exception e){
                    logger.error(apiData, e);
                    try {
                        bw.write(apiData);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
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
     * 385 - 法院公告
     * courtAnnouncement
     */
    @RequestMapping("/385courtAnnouncement")
    public R courtAnnouncement() throws IOException {
        String path = rootPath + "/法院公告/";
        String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="test1.json";
        String file1 = "error.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file1)));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }
                    String entName = result.getCname();
                    // 保存数据
                    List<Open385CourtAnnouncementDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    // 先删除 在新增
                    entCourtAnnounceInfoService.deleteByEntName(entName);
                    List<EntCourtAnnounceInfoEntity> list = new ArrayList<EntCourtAnnounceInfoEntity>(items.size());
                    List<EntCourtAnnounceCompanyEntity> entCourtAnnounceCompanylist = new ArrayList<EntCourtAnnounceCompanyEntity>();
                    EntCourtAnnounceInfoEntity entity = null;
                    List<Open385CompanyListDTO> companyList = null;
                    for (Open385CourtAnnouncementDTO item : items) {
                        entity = new EntCourtAnnounceInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());
                        list.add(entity);

                        companyList = item.getCompanyList();
                        if (null != companyList && companyList.size() > 0) {
                            entCourtAnnounceCompanyService.deleteByTycTableId(entity.getTableId());
                            EntCourtAnnounceCompanyEntity companyEntity = null;
                            for (Open385CompanyListDTO company : companyList) {
                                companyEntity = new EntCourtAnnounceCompanyEntity();
                                BeanUtils.copyProperties(company, companyEntity);
                                companyEntity.setTableId(entity.getTableId());
                                entCourtAnnounceCompanylist.add(companyEntity);
                            }
                        }

                    }
                    if (entCourtAnnounceCompanylist.size() > 0) {
                        entCourtAnnounceCompanyService.insertBatch(entCourtAnnounceCompanylist);
                    }
                    entCourtAnnounceInfoService.insertBatch(list);
                }catch (Exception e){
                    logger.error(apiData, e);
                    try {
                        bw.write(apiData);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
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
     * 386 - 开庭公告
     * ktannouncement
     */
    @RequestMapping("/386ktannouncement")
    public R ktannouncement() throws IOException {
        String path = rootPath + "/开庭公告/";
        String fileName = "callSuccessful.txt_file3.txt";
        String file1 = "error.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file1)));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                // 这里处理一行字符串
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open386KtannouncementDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    // 先删除 在新增
                    entKtannounceInfoService.deleteByEntName(entName);
                    List<EntKtannounceInfoEntity> list = new ArrayList<EntKtannounceInfoEntity>(items.size());
                    List<EntKtannouncePeopleInfoEntity> peopleInfoEntityList = new ArrayList<EntKtannouncePeopleInfoEntity>();
                    List<String> connLs = null;
                    for (Open386KtannouncementDTO item : items) {
                        EntKtannounceInfoEntity entity = new EntKtannounceInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());
                        connLs = item.getConnList();
                        String connStr = Joiner.on(",").join(connLs);
                        entity.setConnList(connStr);
                        list.add(entity);

                        List<Open386KtannouncementPlaintiffDTO> plaintiffLs = item.getPlaintiff();
                        String tableId = entity.getTableId();
                        if (null != plaintiffLs && plaintiffLs.size() > 0) {
                            entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
                            for (Open386KtannouncementPlaintiffDTO plaintiff : plaintiffLs) {
                                EntKtannouncePeopleInfoEntity plaintiffEntity = new EntKtannouncePeopleInfoEntity();
                                BeanUtils.copyProperties(plaintiff, plaintiffEntity);
                                plaintiffEntity.setPeopleType(EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
                                plaintiffEntity.setTableId(Long.valueOf(tableId));
                                peopleInfoEntityList.add(plaintiffEntity);
                            }
                        }
                        List<Open386KtannouncementDefendantDTO> defendantLs = item.getDefendant();
                        if (null != defendantLs && defendantLs.size() > 0) {
                            entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.DEFENDANT.key());
                            for (Open386KtannouncementDefendantDTO defendant : defendantLs) {
                                EntKtannouncePeopleInfoEntity defendantEntity = new EntKtannouncePeopleInfoEntity();
                                BeanUtils.copyProperties(defendant, defendantEntity);
                                defendantEntity.setPeopleType(EntKtannouncePeopleTypeEnum.DEFENDANT.key());
                                defendantEntity.setTableId(Long.valueOf(tableId));
                                peopleInfoEntityList.add(defendantEntity);
                            }
                        }
                    }
                    if (peopleInfoEntityList.size() > 0) {
                        entKtannouncePeopleInfoService.insertBatch(peopleInfoEntityList);
                    }
                    entKtannounceInfoService.insertBatch(list);
                }catch (Exception e) {
                    logger.error(apiData, e);
                    try {
                        bw.write(apiData);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
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
     * 777 - 失信人（新版）
     */
    @RequestMapping("/777dishonestV2")
    public R dishonestV2() throws IOException {
        String path = rootPath + "/失信人（新版）/";
        String fileName = "callSuccessful.txt_file3.txt";
        String file1 = "error.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file1)));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                try {
                    // 这里处理一行字符串
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open777DishonestV2DTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }
                    // 先删除 在新增
                    entDishonestInfoService.deleteByEntName(entName);
                    List<EntDishonestInfoEntity> list = new ArrayList<EntDishonestInfoEntity>(items.size());
                    List<EntDishonestStaffEntity> dishonestStafflist = new ArrayList<EntDishonestStaffEntity>();
                    EntDishonestInfoEntity entity = null;
                    for (Open777DishonestV2DTO item : items) {
                        entity = new EntDishonestInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());
                        list.add(entity);

                        List<Open777DishonestV2StaffDTO> staffLs = item.getStaff();
                        if (null != staffLs && staffLs.size() > 0) {
                            String caseCode = entity.getCasecode();
                            entDishonestStaffService.deleteByEntNameAndCasecode(entName, caseCode);
                            for (Open777DishonestV2StaffDTO staff : staffLs) {
                                EntDishonestStaffEntity entDishonestStaffEntity = new EntDishonestStaffEntity();
                                BeanUtils.copyProperties(staff, entDishonestStaffEntity);
                                entDishonestStaffEntity.setEntId(listInfoEntity.getId());
                                entDishonestStaffEntity.setEntName(entName);
                                entDishonestStaffEntity.setCreditCode(listInfoEntity.getCreditCode());
                                entDishonestStaffEntity.setCasecode(caseCode);
                                dishonestStafflist.add(entDishonestStaffEntity);
                            }
                        }
                    }
                    if (dishonestStafflist.size() > 0) {
                        entDishonestStaffService.insertBatch(dishonestStafflist);
                    }
                    entDishonestInfoService.insertBatch(list);
                }catch (Exception e){
                    logger.error(apiData, e);
                    try {
                        bw.write(apiData);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
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
     * 389 - 被执行人
     */
    @RequestMapping("/389zhixinginfo")
    public R zhixinginfo() throws IOException {
        String path = rootPath + "/被执行人/";
        String fileName = "callSuccessful.txt_file3.txt";
        String file1 = "error.txt";
        File file = new File(path, fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file1)));
        Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
            public boolean processLine(String apiData) throws IOException {
                // 这里处理一行字符串
                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                    Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>>>>() {
                    }.getType(); //
                    ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>>> result = gson.fromJson(apiData, jsonType);
                    TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>> dtos = result.getResult();
                    if (dtos == null) { // 成功
                        throw new SpiderException("数据返回为空");
                    }

                    String entName = result.getCname();
                    // 保存数据
                    List<Open389ZhixinginfoDTO> items = dtos.getData().getItems();
                    EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
                    if (null == listInfoEntity) {
                        throw new SpiderException("系统异常，请稍后再试");
                    }

                    // 先删除 在新增
                    entZhixingInfoService.deleteByEntName(entName);
                    List<EntZhixingInfoEntity> list = new ArrayList<EntZhixingInfoEntity>();
                    EntZhixingInfoEntity entity = null;
                    for (Open389ZhixinginfoDTO item : items) {
                        entity = new EntZhixingInfoEntity();
                        BeanUtils.copyProperties(item, entity);
                        entity.setEntId(listInfoEntity.getId());
                        entity.setEntName(entName);
                        entity.setCreditCode(listInfoEntity.getCreditCode());
                        list.add(entity);

                    }
                    entZhixingInfoService.insertBatch(list);
                }catch (Exception e){
                    logger.error(apiData, e);
                    try {
                        bw.write(apiData);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException e1) {
                        logger.error("写文件异常", e1);
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
}
