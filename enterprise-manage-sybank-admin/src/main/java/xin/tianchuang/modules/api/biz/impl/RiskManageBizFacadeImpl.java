package xin.tianchuang.modules.api.biz.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.common.constant.TycWeightPointsConstant;
import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.common.enums.BizTypeEnum;
import xin.tianchuang.common.enums.ChannelTypeEnum;
import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;
import xin.tianchuang.common.enums.YesOrNoEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.DateUtils;
import xin.tianchuang.common.utils.TycChangeItemUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewEntReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewRntResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseBlackDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseIndustyDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDefendantDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementPlaintiffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open391AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open422OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open429BidsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open439TmDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open440PatentsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open441CopyRegDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open442IcpDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open733CopyRegWorksDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open767CreditChinaV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.OpenBaseinfoSetDTO;
import xin.tianchuang.modules.api.biz.RiskManageBizFacade;
import xin.tianchuang.modules.api.biz.TycOpenBiz;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntOwnTaxEntity;
import xin.tianchuang.modules.spider.entity.EntPunishCreditChinaEntity;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;
import xin.tianchuang.modules.spider.service.EntDishonestInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntOwnTaxService;
import xin.tianchuang.modules.spider.service.EntPunishCreditChinaService;
import xin.tianchuang.modules.spider.service.EntReportLogService;
import cn.hutool.core.date.DateUtil;

import com.alibaba.fastjson.JSONObject;

@Component
public class RiskManageBizFacadeImpl implements RiskManageBizFacade {

    private static Logger logger = LoggerFactory
            .getLogger(RiskManageBizFacadeImpl.class);
    @Autowired
    private TycOpenBiz tycOpenBiz;

    @Autowired
    private EntListInfoService entListInfoService;

    @Autowired
    private EntReportLogService reportLogService;

    @Autowired
    private EjbDozerGenerator ejbGenerator;

    @Autowired
    private EntDishonestInfoService honestInfoService;

    @Autowired
    private EntPunishCreditChinaService punishCreditChinaService;

    @Autowired
    private EntOwnTaxService ownTaxService;

    @Autowired
    private ExecutorService executorService;

    /**
     * 因此接口计算 实时调用了17个天眼查接口 用串行计算耗时太长 交互时间过长 因此异步用线程去分别调用接口所有接口拿到结果后返回
     * 计算时长取决于耗时最长的接口
     * 本方法中使用了 初始化为20个线程的线程池(未设置等待队列)
     * 不知在并发的时候线程池够不够能否及时处理完
     * 若不行可以去掉线程池 直接new thread 处理 （new thread 的方法因每次请求新建十几个线程耗费资源所以现用的线程池 请斟酌考虑）
     * @param param
     * @return
     */
    @Override
    public TycDataHandleResponseDTO tycReport(RiskManageBizReqDTO param) {
        try {
            BizRequestParamDTO tycParam = new BizRequestParamDTO();
            BeanUtils.copyProperties(param, tycParam);
            tycParam.setChannelType(ChannelTypeEnum.RISK.key());
            TycDataHandleResponseDTO dto = new TycDataHandleResponseDTO();
            dto.setName(param.getName());
            //串行执行太慢了 使用并发异步执行节约时间

            CountDownLatch latch = new CountDownLatch(12);
            // 365 接口 //经营年限 企业性质 行业分类评价 社保缴费人数 资本市场融资信息
            executorService.execute(() -> {
                callTycGetSomeBaseInfo(tycParam, dto);
                latch.countDown();
            });

            // 370 变更信息综合变量
            executorService.execute(() -> {
                BigDecimal changeAggregateVar = callTycCalcChangeAggregateVar(tycParam);
                if (changeAggregateVar != null) {
                    dto.setChangeAggregateVar(changeAggregateVar);
                }
                latch.countDown();
            });

            // 386、385、389 司法信息加权数量
            executorService.execute(() -> {
                BigDecimal judicialWeightedNo = callTycCalcJudicialWeightedNo(tycParam);
                if (judicialWeightedNo != null) {
                    dto.setJudicialWeightedNo(judicialWeightedNo);
                }
                latch.countDown();
            });

            // 446 负面新闻舆情加权数量 新闻舆情数量
            executorService.execute(() -> {
                callTycCalcNewsAbout(tycParam, dto);
                latch.countDown();
            });
            // 439、440、441、733 知识产权数量
            executorService.execute(() -> {
                BigDecimal intellectualPropertyRightsNo = callTycCalcIntellectualPropertyRightsNo(tycParam);
                if (intellectualPropertyRightsNo != null) {
                    dto.setIntellectualPropertyRightsNo(intellectualPropertyRightsNo);
                }
                latch.countDown();
            });

            // 404 股权与动产质押信息数量
            executorService.execute(() -> {
                Integer stockMortgageNo = callTycGetStockMortgageNo(tycParam);
                if (stockMortgageNo != null) {
                    dto.setStockMortgageNo(stockMortgageNo);
                }
                latch.countDown();
            });

            // 399 行政处罚信息数量
            executorService.execute(() -> {
                Integer administrativePenaltyNo = callTycGetAdministrativePenaltyNo(tycParam);
                if (administrativePenaltyNo != null) {
                    dto.setAdministrativePenaltyNo(administrativePenaltyNo);
                }
                latch.countDown();
            });

            // 391 经营异常信息数量
            executorService.execute(() -> {
                Integer abnormalNo = callTycGetAbnormalNo(tycParam);
                if (abnormalNo != null) {
                    dto.setAbnormalNo(abnormalNo);
                }
                latch.countDown();
            });


            // 422 欠税公告信息数量
            executorService.execute(() -> {
                Integer oweTaxNo = callTycGetOweTaxNo(tycParam);
                if (oweTaxNo != null) {
                    dto.setOweTaxNo(oweTaxNo);
                }
                latch.countDown();
            });
            // 782 招聘信息数量
            executorService.execute(() -> {
                Integer employInfoNo = callTycGetemployInfoNo(tycParam);
                if (employInfoNo != null) {
                    dto.setEmployInfoNo(employInfoNo);
                }
                latch.countDown();
            });

            // 429 招投标信息数量
            executorService.execute(() -> {
                Integer bidsNo = callTycGetBidsNo(tycParam);
                if (bidsNo != null) {
                    dto.setBidsNo(bidsNo);
                }
                latch.countDown();
            });
            // 442 网站备案
            executorService.execute(() -> {
                Integer icpNo = callTycGetIcpNo(tycParam);
                if (icpNo != null) {
                    dto.setIcpNo(icpNo);
                }
                latch.countDown();
            });

            latch.await();
            // TODO 记录日志表
            saveLog(param, dto);
            return dto;
        } catch (Exception e) {
            logger.error("天眼查模型变量加工异常,", e);
        }
        return null;
    }

    private void saveLog(RiskManageBizReqDTO param, TycDataHandleResponseDTO dto) {
        try {
            EntListInfoEntity entity = entListInfoService.selectOneByName(param.getName());
            if (entity != null) {
                EntReportLogEntity log = new EntReportLogEntity();
                log.setBizCode(param.getBizCode());
                log.setEntId(entity.getId());
                log.setEntName(param.getName());
                log.setCollectDate(new Date());
                log.setCreditCode(entity.getCreditCode());
                log.setInterfaceType(BizInterfaceTypeEnum.TYC.key());
                log.setBizType(BizTypeEnum.TYC.key());
                log.setReportContent(JSONObject.toJSONString(dto));
                log.setSeqNum(param.getSeqNum());
                log.setRemark("天眼查变量加工");
                reportLogService.insert(log);
            }
        } catch (Exception e) {
            logger.error("保存日志出错");
        }
    }

    private Integer callTycGetIcpNo(BizRequestParamDTO tycParam) {
        try {
            List<Open442IcpDTO> list = tycOpenBiz.getIcp(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private Integer callTycGetBidsNo(BizRequestParamDTO tycParam) {
        try {
            List<Open429BidsDTO> list = tycOpenBiz.getBids(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    // 知识产权数量
    private BigDecimal callTycCalcIntellectualPropertyRightsNo(BizRequestParamDTO tycParam) {
        try {
            CountDownLatch latchIntellectual = new CountDownLatch(4);
            Future<BigDecimal> futurePatents = executorService.submit(() -> {
                BigDecimal entPatentsInfosSum = callTycPatentsInfosAndCalc(tycParam);
                latchIntellectual.countDown();
                return entPatentsInfosSum;
            });
            Future<BigDecimal> futureTm = executorService.submit(() -> {
                BigDecimal entTmInfoSum = callTycTmInfoAndCalc(tycParam);
                latchIntellectual.countDown();
                return entTmInfoSum;
            });
            Future<BigDecimal> futureCopyReg = executorService.submit(() -> {
                BigDecimal entCopyRegSum = callTycCopyRegAndCalc(tycParam);
                latchIntellectual.countDown();
                return entCopyRegSum;
            });
            Future<BigDecimal> futureCopyRegWorks = executorService.submit(() -> {
                BigDecimal entCopyRegWorksSum = callTycCopyRegWorksAndCalc(tycParam);
                latchIntellectual.countDown();
                return entCopyRegWorksSum;
            });

            latchIntellectual.await();
            // 专利加权数量 计算
            BigDecimal entPatentsInfosSum = futurePatents.get();
            // 商标加权数量
            BigDecimal entTmInfoSum = futureTm.get();
            // 软件著作权加权数量
            BigDecimal entCopyRegSum = futureCopyReg.get();
            // 作品著作权加权数量
            BigDecimal entCopyRegWorksSum = futureCopyRegWorks.get();
            // 计算结果
            if (entPatentsInfosSum != null && entTmInfoSum != null && entCopyRegSum != null && entCopyRegWorksSum != null) {
                return entPatentsInfosSum.multiply(new BigDecimal("2").add(entTmInfoSum)).add(entCopyRegSum).add(entCopyRegWorksSum);
            } else {
                return null;
            }
        }catch (Exception e){
            logger.error("知识产权数量数据异常", e);
        }
        return null;
    }

    private Integer callTycGetemployInfoNo(BizRequestParamDTO tycParam) {
        try {
            List<Open782EmploymentsV2DTO> list = tycOpenBiz.getEmploymentsV2(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    // 新闻舆情加权数量
    private void callTycCalcNewsAbout(BizRequestParamDTO tycParam, TycDataHandleResponseDTO dto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            List<Open446NewsDTO> list = tycOpenBiz.getNews(tycParam);
            if (list == null || list.isEmpty()) {
                dto.setNewsNo(BigDecimal.ZERO);
                dto.setNegativeNewsWeightedNo(0);
                return;
            }
            BigDecimal sum = BigDecimal.ZERO;
            Date now = new Date();
            Integer badNewsCount = 0;
            Date newsTime = null;
            Long betMonth = null;
            BigDecimal weight = null;
            for (Open446NewsDTO newsdto : list) {
                if (StringUtils.isNotBlank(newsdto.getTime())) {
                    try {
                        newsTime = sdf.parse(newsdto.getTime());
                        betMonth = DateUtil.betweenMonth(now, newsTime, true);
                        weight = TycWeightPointsConstant.NEWS_DATE.get(betMonth
                                .intValue());
                        sum = sum.add(weight);
                    } catch (Exception e) {
                        sum = sum.add(BigDecimal.ONE);
                        logger.error("新闻舆情加权数量数据异常", e);
                    }
                } else {
                    sum = sum.add(BigDecimal.ONE);
                }
                String title = newsdto.getTitle();
                if (StringUtils.isNotBlank(title)) {
                    Iterator<String> it = TycWeightPointsConstant.NEWS_BAD_WORDS
                            .iterator();
                    // 如果标题中有命中负面舆情词汇，则算一条负面舆情信息
                    while (it.hasNext()) {
                        String badWords = it.next();
                        if (title.indexOf(badWords) != -1) {
                            badNewsCount++;
                            break;
                        }
                    }
                }
            }

            dto.setNewsNo(sum);
            dto.setNegativeNewsWeightedNo(badNewsCount);
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
        }

    }

    private Integer callTycGetOweTaxNo(BizRequestParamDTO tycParam) {
        try {
            List<Open422OwnTaxDTO> list = tycOpenBiz.getOweTax(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private Integer callTycGetAbnormalNo(BizRequestParamDTO tycParam) {
        try {
            List<Open391AbnormalDTO> list = tycOpenBiz.getAbnormal(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private Integer callTycGetAdministrativePenaltyNo(
            BizRequestParamDTO tycParam) {
        try {
            List<Open767CreditChinaV2DTO> list = tycOpenBiz.getCreditChinaV2(tycParam);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private BigDecimal callTycCalcJudicialWeightedNo(BizRequestParamDTO tycParam) {
        // 开庭公告加权数量=SUM(距今时常权重*开庭公告身份权重）
        try {
            CountDownLatch latchJudicial = new CountDownLatch(3);
            Future<BigDecimal> futureKtannouncement = executorService.submit(() -> {
                BigDecimal ktannouncementCount = getKtannouncementCount(tycParam);
                latchJudicial.countDown();
                return ktannouncementCount;
            });
            Future<BigDecimal> futureAnnounce = executorService.submit(() -> {
                BigDecimal announceCount = getAnnounceCount(tycParam);
                latchJudicial.countDown();
                return announceCount;
            });
            Future<BigDecimal> futureZhixing = executorService.submit(() -> {
                BigDecimal zhixingCount = getZhixingCount(tycParam);
                latchJudicial.countDown();
                return zhixingCount;
            });
            latchJudicial.await();
            BigDecimal ktannouncementCount = futureKtannouncement.get();
            BigDecimal announceCount = futureAnnounce.get();
            BigDecimal zhixingCount = futureZhixing.get();
            if (ktannouncementCount != null && announceCount != null && zhixingCount != null) {
                BigDecimal JudicialWeightedNo = ktannouncementCount.add(ktannouncementCount).add(announceCount).add(zhixingCount);
                return JudicialWeightedNo;
            } else {
                return null;
            }
        }catch (Exception e){
            logger.error("开庭公告加权数量数据异常", e);
        }
        return null;
    }

    /**
     * 执行信息加权数量=SUM(距今时常权重*被执行标的权重）
     */
    private BigDecimal getZhixingCount(BizRequestParamDTO tycParam) {
        Long caseCreateTime = null;
        String execMoney = null;
        BigDecimal caseCreateTimeBigDecimal = null;
        BigDecimal zhixingCount = BigDecimal.ZERO;
        Long caseCreateTimeLong = null;
        BigDecimal execMoneyBigDecimal = null;
        try {
            List<Open389ZhixinginfoDTO> open389ZhixinginfoDTOs = tycOpenBiz.getZhixinginfo(tycParam);
            if (open389ZhixinginfoDTOs == null || open389ZhixinginfoDTOs.isEmpty()) {
                return BigDecimal.ZERO;
            }
            for (Open389ZhixinginfoDTO entity : open389ZhixinginfoDTOs) {
                caseCreateTime = entity.getCaseCreateTime();// 时间戳
                if (null != caseCreateTime) {
                    try {
                        caseCreateTimeLong = DateUtil.betweenMonth(new Date(), new Date(caseCreateTime), true);
                        caseCreateTimeBigDecimal = TycWeightPointsConstant.ZHI_XING_DATE.get(caseCreateTimeLong.intValue());
                    } catch (Exception e) {
                        caseCreateTimeBigDecimal = BigDecimal.ONE;
                        logger.error("被执行人日期数据异常", e);
                    }
                } else {
                    caseCreateTimeBigDecimal = BigDecimal.ONE;
                }

                if (caseCreateTimeBigDecimal == null) {
                    caseCreateTimeBigDecimal = BigDecimal.ONE;
                }

                execMoney = entity.getExecMoney();
                if (StringUtils.isNotBlank(execMoney)) {
                    execMoneyBigDecimal = new BigDecimal(execMoney);
                    try {
                        execMoneyBigDecimal = execMoneyBigDecimal.divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP);
                        execMoneyBigDecimal = TycWeightPointsConstant.ZHI_XING_MONEY.get(execMoneyBigDecimal.intValue());
                    } catch (Exception e) {
                        execMoneyBigDecimal = BigDecimal.ONE;
                        logger.error("被执行人执行标的数据异常", e);
                    }
                }

                if (execMoneyBigDecimal == null) {
                    execMoneyBigDecimal = BigDecimal.ONE;
                }

                zhixingCount = zhixingCount.add(execMoneyBigDecimal.multiply(
                        caseCreateTimeBigDecimal).multiply(
                        new BigDecimal("1.5")));
            }
            return zhixingCount;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    /**
     * "裁判文书加权数量=SUM(距今时常权重*裁判文书身份权重） 注：根据385-bltntypename返回结果 先选出 裁判文书类"
     * "法院公告加权数量裁判文书加权数量=SUM(距今时常权重*法院公告身份权重） 注：根据385-bltntypename返回结果 剔除 裁判文书类"
     */
    private BigDecimal getAnnounceCount(BizRequestParamDTO tycParam) {
        BigDecimal counrtAnnounceNo = BigDecimal.ZERO;
        BigDecimal changeTimeDouble = BigDecimal.ZERO;
        String publishdate = null;
        String bltntypename = null;
        String bltntype = null;
        String party1 = null;
        // String party2 = null;
        try {
            List<Open385CourtAnnouncementDTO> open385CourtAnnouncementDTOs = tycOpenBiz.getCourtAnnouncement(tycParam);
            if (open385CourtAnnouncementDTOs == null || open385CourtAnnouncementDTOs.isEmpty()) {
                return BigDecimal.ZERO;
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            for (Open385CourtAnnouncementDTO entity : open385CourtAnnouncementDTOs) {
                publishdate = entity.getPublishdate();
                bltntypename = entity.getBltntypename();
                bltntype = entity.getBltntype();
                party1 = entity.getParty1();
                // party2 = entity.getParty2();
                if (StringUtils.isBlank(publishdate)) {
                    changeTimeDouble = BigDecimal.ONE;
                }

                try {
                    Long changeTimeLong = DateUtil.betweenMonth(df.parse(DateUtil.today()), df.parse(publishdate), true);
                    if ("裁判文书".equals(bltntypename) || "62".equals(bltntype)) { // 裁判文书
                        changeTimeDouble = TycWeightPointsConstant.JUDICIAL_DOCUMENTS_DATE.get(changeTimeLong.intValue());
                    } else { // 法院公告
                        changeTimeDouble = TycWeightPointsConstant.COURT_ANNOUNCEMENT_DATE.get(changeTimeLong.intValue());
                    }
                } catch (Exception e) {
                    changeTimeDouble = BigDecimal.ONE;
                    logger.error("司法信息加权数量数据异常", e);
                }

                if (changeTimeDouble == null) {
                    changeTimeDouble = BigDecimal.ONE;
                }

                if (party1.indexOf(tycParam.getName()) != -1) {// 原告
                    BigDecimal defendantBigDecimal = TycWeightPointsConstant.JUDICIAL_DOCUMENTS_INDENTITY.get(EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
                    counrtAnnounceNo = counrtAnnounceNo.add(changeTimeDouble.multiply(defendantBigDecimal));
                } else {
                    BigDecimal plaintiffBigDecimal = TycWeightPointsConstant.COURT_ANNOUNCEMENT_INDENTITY.get(EntKtannouncePeopleTypeEnum.DEFENDANT.key());
                    counrtAnnounceNo = counrtAnnounceNo.add(changeTimeDouble.multiply(plaintiffBigDecimal));
                }

            }
            return counrtAnnounceNo;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    // 开庭公告加权数量=SUM(距今时常权重*开庭公告身份权重）
    private BigDecimal getKtannouncementCount(BizRequestParamDTO tycParam) {


        try {
            List<Open386KtannouncementDTO> open386KtannouncementDTOs = tycOpenBiz.getKtannouncement(tycParam);
            if (open386KtannouncementDTOs == null || open386KtannouncementDTOs.isEmpty()) {
                return BigDecimal.ZERO;
            }
            BigDecimal ktannouncementCount = BigDecimal.ZERO;
            ktannouncementCount = BigDecimal.ZERO;
            BigDecimal changeTimeDouble = BigDecimal.ZERO;
            String starDate = null;
            Long fromTimeLong = null;
            List<Open386KtannouncementPlaintiffDTO> plaintiffList = null;
            List<Open386KtannouncementDefendantDTO> defendantList = null;

            for (Open386KtannouncementDTO oepn386kKtannouncementDTO : open386KtannouncementDTOs) {
                // 开庭公告日期距今时长 （当前日期减386-startDate返回结果）
                starDate = oepn386kKtannouncementDTO.getStartDate();// 时间戳
                if (StringUtils.isNotBlank(starDate)) {
                    try {
                        fromTimeLong = DateUtil.betweenMonth(new Date(), new Date(Long.valueOf(starDate)), true);
                        changeTimeDouble = TycWeightPointsConstant.KT_ANNOUNCENENT_DATE.get(fromTimeLong.intValue());
                        if (changeTimeDouble == null) {
                            changeTimeDouble = BigDecimal.ONE;
                        }
                    } catch (Exception e) {
                        logger.error("司法信息加权数量数据异常", e);
                        changeTimeDouble = BigDecimal.ONE;
                    }
                } else {
                    changeTimeDouble = BigDecimal.ONE;
                }
                // 原告/上诉人
                // 开庭公告身份（根据386-plaintiff_name（原告名称）、386-defendant_name（被告名称）判断企业身份）
                plaintiffList = oepn386kKtannouncementDTO.getPlaintiff();
                if (plaintiffList != null && plaintiffList.size() >= 1) {
                    BigDecimal plaintiffBigDecimal = null;
                    for (Open386KtannouncementPlaintiffDTO open386KtannouncementPlaintiffDTO : plaintiffList) {
                        if (tycParam.getName().equals(
                                open386KtannouncementPlaintiffDTO.getName())) {
                            // 根据386-plaintiff_name（原告名称）、386-defendant_name（被告名称）判断企业身份
                            try {
                                plaintiffBigDecimal = TycWeightPointsConstant.KT_ANNOUNCENENT_IDENTITY.get(EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
                                if (plaintiffBigDecimal == null) {
                                    plaintiffBigDecimal = BigDecimal.ONE;
                                }
                            } catch (Exception e) {
                                logger.error("司法信息加权数量数据异常", e);
                                plaintiffBigDecimal = BigDecimal.ONE;
                            }

                            ktannouncementCount = ktannouncementCount.add(changeTimeDouble.multiply(plaintiffBigDecimal));
                        }
                    }
                }
                // 被告/被上诉人
                defendantList = oepn386kKtannouncementDTO.getDefendant();
                if (defendantList != null && defendantList.size() >= 1) {
                    BigDecimal defendantBigDecimal = null;
                    for (Open386KtannouncementDefendantDTO open386KtannouncementDefendantDTO : defendantList) {
                        if (tycParam.getName().equals(
                                open386KtannouncementDefendantDTO.getName())) {
                            // 根据386-plaintiff_name（原告名称）、386-defendant_name（被告名称）判断企业身份
                            try {
                                defendantBigDecimal = TycWeightPointsConstant.KT_ANNOUNCENENT_IDENTITY.get(EntKtannouncePeopleTypeEnum.DEFENDANT.key());
                                if (defendantBigDecimal == null) {
                                    defendantBigDecimal = BigDecimal.ONE;
                                }
                            } catch (Exception e) {
                                defendantBigDecimal = BigDecimal.ONE;
                                logger.error("司法信息加权数量数据异常", e);
                            }

                            ktannouncementCount = ktannouncementCount.add(changeTimeDouble.multiply(defendantBigDecimal));
                        }
                    }
                }
                if ((defendantList == null || defendantList.size() < 1) && (plaintiffList == null || plaintiffList.size() < 1)) {
                    ktannouncementCount = ktannouncementCount.add(changeTimeDouble.multiply(new BigDecimal("0.5")));
                }
            }
            return ktannouncementCount;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private Integer callTycGetStockMortgageNo(BizRequestParamDTO tycParam) {
        try {
            List<Open404EquityInfoDTO> list = tycOpenBiz.getEquityInfo(tycParam);
            if (list == null || list.isEmpty()) {
                return 0; // 数据返回列表为空，这默认为0
            }
            return list.size();
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    // 根据changeItem接口返回结果判断变更事项；变更信息综合变量=sum(注册资本变量+法定代表人变量+股东/投资人变量+经营范围变量+董监高变量+住所变量+企业类型变量+0.5*企业名称变量）；
    private BigDecimal callTycCalcChangeAggregateVar(BizRequestParamDTO tycParam) {
        try {
            BigDecimal changeItemValue = null;
            BigDecimal changeCount = BigDecimal.ZERO;
            List<Open370ChangeinfoDTO> list = tycOpenBiz.getChangeinfo(tycParam);
            if (list == null || list.isEmpty()) {
                logger.info("数据返回结果为空，不存在变更信息", tycParam.getName());
                return BigDecimal.ZERO;
            }

            for (Open370ChangeinfoDTO changeInfoDto : list) {
                // 先全匹配 后模糊匹配 indexof
                try {
                    changeItemValue = TycChangeItemUtils.calcChangeItemWeight(changeInfoDto);
                } catch (Exception e) {
                    logger.error("变更信息综合变量数据加工异常", e);
                    changeItemValue = BigDecimal.ZERO;
                }
                if (changeItemValue == null) {
                    continue;
                }
                changeCount = changeCount.add(changeItemValue);
            }
            return changeCount;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private void callTycGetSomeBaseInfo(BizRequestParamDTO tycParam, TycDataHandleResponseDTO dto) {
        try {
            OpenBaseinfoSetDTO openBaseinfo = tycOpenBiz.getBaseinfoV3(tycParam);
            if (openBaseinfo == null) {
                logger.info("数据返回结果为空，不存在企业基本信息", tycParam.getName());
                return;
            }
            /**
             * 经营年限OperationDuration 企业性质enterpriseNature
             * 行业分类评价industryClassEvaluate 社保缴费人数socialSecurityPayerNo
             * 资本市场融资信息capitalMarketFinancing
             */
            Long fromTime = openBaseinfo.getFromTime();
            if (null != fromTime) {
                try {
                    BigDecimal year = DateUtils.getBetweenYear(new Date(fromTime), new Date());
                    dto.setOperationDuration(year);
                } catch (Exception e) {
                    logger.error("经营年限计算异常", e);
                }
            }
            dto.setEnterpriseNature(openBaseinfo.getCompanyOrgType());
            dto.setIndustryClassEvaluate(openBaseinfo.getIndustry());
            dto.setSocialSecurityPayerNo(openBaseinfo.getSocialStaffNum());
            dto.setCapitalMarketFinancing(openBaseinfo.getBondType());
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);

        }
    }

    private BigDecimal callTycTmInfoAndCalc(BizRequestParamDTO tycParam) {
        // 商标加权数量
        try {
            BigDecimal entTmInfoSum = BigDecimal.ZERO;
            BigDecimal weight = null;
            List<Open439TmDTO> enttminfolist = tycOpenBiz.getTm(tycParam);
            if (enttminfolist == null || enttminfolist.isEmpty()) {
                return BigDecimal.ZERO;
            }
            for (Open439TmDTO enttminfoentity : enttminfolist) {
                if (StringUtils.isBlank(enttminfoentity.getAppDate())) {
                    continue;
                }
                try {
                    Long weightvalue = DateUtil.betweenMonth(new Date(), new Date(Long.valueOf(enttminfoentity.getAppDate())), true);
                    weight = TycWeightPointsConstant.TRADEMARK_DATE.get(weightvalue.intValue());
                } catch (Exception e) {
                    weight = BigDecimal.ZERO;
                    logger.error("知识产权数量数据异常", e);
                }

                if (weight == null) {
                    weight = BigDecimal.ZERO;
                }
                entTmInfoSum = entTmInfoSum.add(weight);
            }
            return entTmInfoSum;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private BigDecimal callTycPatentsInfosAndCalc(BizRequestParamDTO tycParam) {
        // 专利加权数量

        try {
            BigDecimal weight = null;
            BigDecimal entPatentsInfosSum = BigDecimal.ZERO;
            Date appLicationTime = null;
            Long weightValue = null;
            BigDecimal type = null;
            List<Open440PatentsDTO> entpatentsinfolist = tycOpenBiz.getPatents(tycParam);
            if (entpatentsinfolist == null || entpatentsinfolist.isEmpty()) {
                return BigDecimal.ZERO;
            }

            for (Open440PatentsDTO entpatentsinfoentity : entpatentsinfolist) {
                if (StringUtils.isBlank(entpatentsinfoentity.getApplicationTime()) && StringUtils.isBlank(entpatentsinfoentity.getPatentType())) {
                    continue;
                }

                if (StringUtils.isNotBlank(entpatentsinfoentity.getApplicationTime())) {
                    try {
                        appLicationTime = DateUtils.timeStrToDate(entpatentsinfoentity.getApplicationTime());
                        weightValue = DateUtil.betweenMonth(new Date(), appLicationTime, true);
                        weight = TycWeightPointsConstant.PATENT_DATE.get(weightValue.intValue());
                    } catch (Exception e) {
                        weight = BigDecimal.ZERO;
                        logger.error("知识产权数量数据异常", e);
                    }
                }

                if (weight == null) {
                    weight = BigDecimal.ZERO;
                }

                if (StringUtils.isNotBlank(entpatentsinfoentity.getPatentType())) {
                    try {
                        // 类型
                        String patentType = entpatentsinfoentity.getPatentType();
                        type = TycWeightPointsConstant.PATENT_TYPE.get(patentType);
                    } catch (Exception e) {
                        type = BigDecimal.ZERO;
                        logger.error("知识产权数量数据异常", e);
                    }
                }

                if (type == null) {
                    type = BigDecimal.ZERO;
                }

                // 专利加权数量
                entPatentsInfosSum = entPatentsInfosSum.add(weight.multiply(type));
            }
            return entPatentsInfosSum;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }

    }

    private BigDecimal callTycCopyRegAndCalc(BizRequestParamDTO tycParam) {
        // 软件著作权加权数量
        try {
            BigDecimal weight = null;
            Long weightvalue = null;
            BigDecimal entCopyRegSum = BigDecimal.ZERO;
            List<Open441CopyRegDTO> entcopyreglist = tycOpenBiz.getCopyReg(tycParam);
            if (entcopyreglist == null || entcopyreglist.isEmpty()) {
                return BigDecimal.ZERO;
            }

            for (Open441CopyRegDTO entcopyregentity : entcopyreglist) {
                if (StringUtils.isBlank(entcopyregentity.getEventTime())) {
                    continue;
                }
                try {
                    weightvalue = DateUtil.betweenMonth(new Date(), new Date(Long.valueOf(entcopyregentity.getEventTime())), true);
                    weight = TycWeightPointsConstant.SOFTWARE_COPYRIGHT_DATE.get(weightvalue.intValue());
                } catch (Exception e) {
                    weight = BigDecimal.ZERO;
                    logger.error("知识产权数量数据异常", e);
                }

                if (weight == null) {
                    weight = BigDecimal.ZERO;
                }

                entCopyRegSum = entCopyRegSum.add(weight);
            }
            return entCopyRegSum;
        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }
    }

    private BigDecimal callTycCopyRegWorksAndCalc(BizRequestParamDTO tycParam) {
        // 作品著作权加权数量

        try {
            BigDecimal entCopyRegWorksSum = BigDecimal.ZERO;

            SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
            List<Open733CopyRegWorksDTO> entcopyregworkslist = tycOpenBiz.getCopyRegWorks(tycParam);
            if (entcopyregworkslist == null || entcopyregworkslist.isEmpty()) {
                return BigDecimal.ZERO;
            }

            BigDecimal weight = null;
            Date regTime = null;
            Long weightValue = null;
            for (Open733CopyRegWorksDTO entcopyregworksentity : entcopyregworkslist) {
                if (StringUtils.isBlank(entcopyregworksentity.getRegtime())) {
                    continue;
                }
                try {
                    regTime = sdfs.parse(entcopyregworksentity.getRegtime());
                    weightValue = DateUtil.betweenMonth(new Date(), regTime, true);
                    weight = TycWeightPointsConstant.WORKS_COPYRIGHT_DATE.get(weightValue.intValue());
                } catch (Exception e) {
                    weight = BigDecimal.ZERO;
                    logger.error("知识产权数量数据异常", e);
                }
                if (weight == null) {
                    weight = BigDecimal.ZERO;
                }

                entCopyRegWorksSum = entCopyRegWorksSum.add(weight);
            }
            return entCopyRegWorksSum;

        } catch (ApiException e) {
            logger.error("查询失败,接口调用异常", e);
            return null;
        }


    }

    @Override
    public List<TycDataHandleResponseIndustyDTO> getAllNameAndIndustry() {
        List<EntListInfoEntity> entListInfoEntities = entListInfoService.getAllNameAndIndustry();
        List<TycDataHandleResponseIndustyDTO> dto = ejbGenerator.convert(entListInfoEntities, TycDataHandleResponseIndustyDTO.class);
        return dto;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RiskManageNewRntResponseDTO addNewEntListInfo(
            List<RiskManageNewEntReqDTO> riskManageNewEntReqDTOList) {
        RiskManageNewRntResponseDTO riskManageNewRntResponseDTO = new RiskManageNewRntResponseDTO();
        List<RiskManageNewEntReqDTO> existList = new ArrayList<RiskManageNewEntReqDTO>();
        int addCount = 0;
        int existCount = 0;
        for (RiskManageNewEntReqDTO riskManageNewEntReqDTO : riskManageNewEntReqDTOList) {
            EntListInfoEntity entity = entListInfoService
                    .selectOneByName(riskManageNewEntReqDTO.getName());
            if (null == entity) {
                addCount++;
                EntListInfoEntity entListInfoEntity = new EntListInfoEntity();
                entListInfoEntity.setName(riskManageNewEntReqDTO.getName());
                entListInfoEntity.setCreditCode(riskManageNewEntReqDTO
                        .getCreditCode());
                entListInfoService.insert(entListInfoEntity);
            } else {
                existCount++;
                existList.add(riskManageNewEntReqDTO);
            }
        }
        // 新增企业数
        riskManageNewRntResponseDTO.setAddCount(addCount);
        // 已经存在数
        riskManageNewRntResponseDTO.setExistCount(existCount);
        // 存在的结果记录
        riskManageNewRntResponseDTO.setExistList(existList);
        // 总企业数
        riskManageNewRntResponseDTO.setTotalCount(riskManageNewEntReqDTOList
                .size());

        return riskManageNewRntResponseDTO;
    }

    @Override
    public TycDataHandleResponseBlackDTO blackReport(RiskManageBizReqDTO param) {
        List<EntDishonestInfoEntity> list = honestInfoService
                .selectListByEntName(param.getName());
        List<EntPunishCreditChinaEntity> punishCreditChinalist = punishCreditChinaService
                .selectListByEntName(param.getName());
        List<EntOwnTaxEntity> ownTaxlist = ownTaxService
                .selectListByEntName(param.getName());
        TycDataHandleResponseBlackDTO dto = new TycDataHandleResponseBlackDTO();
        if ((list != null && !list.isEmpty())
                || (punishCreditChinalist != null && !punishCreditChinalist
                .isEmpty())
                || (ownTaxlist != null && !ownTaxlist.isEmpty())) {
            dto.setBlack(YesOrNoEnum.YES.key() + "");
        } else {
            dto.setBlack(YesOrNoEnum.NO.key() + "");
        }
        dto.setCreditCode(param.getCreditCode());
        dto.setName(param.getName());
        return dto;
    }

    @Override
    public List<TycDataHandleResponseBlackDTO> blackListReport(
            List<RiskManageBizReqDTO> param) {
        List<TycDataHandleResponseBlackDTO> blackList = new ArrayList<TycDataHandleResponseBlackDTO>();
        for (RiskManageBizReqDTO dto : param) {
            TycDataHandleResponseBlackDTO dtos = this.blackReport(dto);
            blackList.add(dtos);
        }
        return blackList;
    }
    // TODO 贷后常规检查 行业平均接口（起止时间、结束时间内的所有数据）

}
