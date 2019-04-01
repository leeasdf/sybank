package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportBaseInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportChangeRecordDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportEquityChangeInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportOutGuaranteeInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportOutboundInvestmentDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportReportSocialSecurityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportShareholderDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportWebInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntAnnualreportBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportChangeRecordEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportEquityChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportInfoEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportOutGuaranteeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportOutboundInvestmentEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportShareholderEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportSocialSecurityEntity;
import xin.tianchuang.modules.spider.entity.EntAnnualreportWebInfoEntity;

import xin.tianchuang.modules.spider.service.EntAnnualreportBaseInfoService;
import xin.tianchuang.modules.spider.service.EntAnnualreportChangeRecordService;
import xin.tianchuang.modules.spider.service.EntAnnualreportEquityChangeInfoService;
import xin.tianchuang.modules.spider.service.EntAnnualreportInfoService;
import xin.tianchuang.modules.spider.service.EntAnnualreportOutGuaranteeInfoService;
import xin.tianchuang.modules.spider.service.EntAnnualreportOutboundInvestmentService;
import xin.tianchuang.modules.spider.service.EntAnnualreportShareholderService;
import xin.tianchuang.modules.spider.service.EntAnnualreportSocialSecurityService;
import xin.tianchuang.modules.spider.service.EntAnnualreportWebInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class AnnualreportHandler implements QueryHandler<List<Open371AnnualreportDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(AnnualreportHandler.class);

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

	@Override
	public BaseRespnseDTO<List<Open371AnnualreportDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/annualreport?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":5,\"items\":[{\"baseInfo\":{\"reportYear\":\"2017\",\"companyName\":\"北京百度网讯科技有限公司\",\"creditCode\":\"91110000802100433B\",\"regNumber\":\"\",\"phoneNumber\":\"010-59928888\",\"postcode\":\"100085\",\"postalAddress\":\"北京市海淀区上地十街10号百度大厦2层\",\"email\":\"无\",\"manageState\":\"开业\",\"employeeNum\":\"企业选择不公示\",\"operatorName\":\"\",\"totalAssets\":\"企业选择不公示\",\"totalEquity\":\"企业选择不公示\",\"totalSales\":\"企业选择不公示\",\"totalProfit\":\"企业选择不公示\",\"primeBusProfit\":\"企业选择不公示\",\"retainedProfit\":\"企业选择不公示\",\"totalTax\":\"企业选择不公示\",\"totalLiability\":\"企业选择不公示\"},\"companyId\":\"22822\",\"changeRecordList\":[],\"equityChangeInfoList\":[],\"outGuaranteeInfoList\":[],\"outboundInvestmentList\":[],\"shareholderList\":[{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"9950万元\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"9950万元\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"127487.36万元\",\"subscribeTime\":\"2017-10-11\",\"subscribeType\":\"货币\",\"paidAmount\":\"127487.36万元\",\"paidTime\":\"2017-10-11\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"向海龙\",\"subscribeAmount\":\"445万元\",\"subscribeTime\":\"2016-06-13\",\"subscribeType\":\"货币\",\"paidAmount\":\"445万元\",\"paidTime\":\"2016-06-13\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1839080315\",\"reportYear\":null,\"toco\":\"37\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"64675万元\",\"subscribeTime\":\"2015-12-22\",\"subscribeType\":\"货币\",\"paidAmount\":\"64675万元\",\"paidTime\":\"2015-12-22\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"13930万元\",\"subscribeTime\":\"2016-03-29\",\"subscribeType\":\"货币\",\"paidAmount\":\"13930万元\",\"paidTime\":\"2016-03-29\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"向海龙\",\"subscribeAmount\":\"640.64万元\",\"subscribeTime\":\"2017-10-24\",\"subscribeType\":\"货币\",\"paidAmount\":\"640.64万元\",\"paidTime\":\"2017-10-24\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1839080315\",\"reportYear\":null,\"toco\":\"37\"}],\"webInfoList\":[],\"reportSocialSecurityInfo\":{\"id\":null,\"annaulreportId\":2707492311,\"endowmentInsurance\":\"3411人\",\"unemploymentInsurance\":\"3411人\",\"medicalInsurance\":\"3411人\",\"employmentInjuryInsurance\":\"3411人\",\"maternityInsurance\":\"3411人\",\"endowmentInsuranceBase\":\"企业选择不公示\",\"unemploymentInsuranceBase\":\"企业选择不公示\",\"medicalInsuranceBase\":\"企业选择不公示\",\"maternityInsuranceBase\":\"企业选择不公示\",\"endowmentInsurancePayAmount\":\"企业选择不公示\",\"unemploymentInsurancePayAmount\":\"企业选择不公示\",\"medicalInsurancePayAmount\":\"企业选择不公示\",\"employmentInjuryInsurancePayAmount\":\"企业选择不公示\",\"maternityInsurancePayAmount\":\"企业选择不公示\",\"endowmentInsuranceOweAmount\":\"企业选择不公示\",\"unemploymentInsuranceOweAmount\":\"企业选择不公示\",\"medicalInsuranceOweAmount\":\"企业选择不公示\",\"employmentInjuryInsuranceOweAmount\":\"企业选择不公示\",\"maternityInsuranceOweAmount\":\"企业选择不公示\",\"createTime\":1535871345000},\"govReport\":null,\"type\":0},{\"baseInfo\":{\"reportYear\":\"2016\",\"companyName\":\"北京百度网讯科技有限公司\",\"creditCode\":\"91110000802100433B\",\"regNumber\":\"\",\"phoneNumber\":\"010-59928888\",\"postcode\":\"100085\",\"postalAddress\":\"北京市海淀区上地十街10号百度大厦\",\"email\":\"无\",\"manageState\":\"开业\",\"employeeNum\":\"企业选择不公示\",\"operatorName\":\"\",\"totalAssets\":\"企业选择不公示\",\"totalEquity\":\"企业选择不公示\",\"totalSales\":\"企业选择不公示\",\"totalProfit\":\"企业选择不公示\",\"primeBusProfit\":\"企业选择不公示\",\"retainedProfit\":\"企业选择不公示\",\"totalTax\":\"企业选择不公示\",\"totalLiability\":\"企业选择不公示\"},\"companyId\":\"22822\",\"changeRecordList\":[],\"equityChangeInfoList\":[],\"outGuaranteeInfoList\":[],\"outboundInvestmentList\":[{\"reportYear\":null,\"outcompanyName\":\"风灵创景(北京)技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******450612E\",\"type\":null,\"clickId\":null},{\"reportYear\":null,\"outcompanyName\":\"北京百度保险经纪有限公司\",\"regNum\":\"\",\"creditCode\":\"91110108MA006JY671\",\"type\":\"2\",\"clickId\":\"2353690439\"},{\"reportYear\":null,\"outcompanyName\":\"北京鼎新天下科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******95430XC\",\"type\":\"2\",\"clickId\":\"2262980\"},{\"reportYear\":null,\"outcompanyName\":\"北京百付宝科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******354426W\",\"type\":\"2\",\"clickId\":\"26031220\"},{\"reportYear\":null,\"outcompanyName\":\"华扬联众数字技术股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******343096U\",\"type\":\"2\",\"clickId\":\"3174100\"},{\"reportYear\":null,\"outcompanyName\":\"河南沸点网络科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******03928XQ\",\"type\":\"2\",\"clickId\":\"888343156\"},{\"reportYear\":null,\"outcompanyName\":\"百度鹏寰资产管理（北京）有限公司\",\"regNum\":\"\",\"creditCode\":\"******934777T\",\"type\":\"2\",\"clickId\":\"2310470083\"},{\"reportYear\":null,\"outcompanyName\":\"诺克萨斯（北京）科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******289814B\",\"type\":\"2\",\"clickId\":\"24644208\"},{\"reportYear\":null,\"outcompanyName\":\"北京捷通华声科技股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******968939Y\",\"type\":\"2\",\"clickId\":\"2345039913\"},{\"reportYear\":null,\"outcompanyName\":\"北京北冥鱼信息技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******022365X\",\"type\":\"2\",\"clickId\":\"41457332\"},{\"reportYear\":null,\"outcompanyName\":\"广东瑞图万方科技股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"18139981\"},{\"reportYear\":null,\"outcompanyName\":\"北京长地万方科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******53190XJ\",\"type\":\"2\",\"clickId\":\"26080527\"},{\"reportYear\":null,\"outcompanyName\":\"上海优扬新媒信息技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******239729M\",\"type\":\"2\",\"clickId\":\"1251488443\"},{\"reportYear\":null,\"outcompanyName\":\"沪江教育科技（上海）股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******518944H\",\"type\":\"2\",\"clickId\":\"2349015448\"},{\"reportYear\":null,\"outcompanyName\":\"北京趣活科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"33015172\"},{\"reportYear\":null,\"outcompanyName\":\"上海叶萌广告传媒有限公司\",\"regNum\":\"310113001004153\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"522030252\"},{\"reportYear\":null,\"outcompanyName\":\"北京幻想纵横网络技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******221683F\",\"type\":\"2\",\"clickId\":\"24489290\"},{\"reportYear\":null,\"outcompanyName\":\"星云融创(北京)信息技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******155521C\",\"type\":null,\"clickId\":null},{\"reportYear\":null,\"outcompanyName\":\"美味不用等（上海）信息科技股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******502540G\",\"type\":\"2\",\"clickId\":\"2358521463\"},{\"reportYear\":null,\"outcompanyName\":\"北京龙渊天启投资管理中心（有限合伙）\",\"regNum\":\"\",\"creditCode\":\"******104515C\",\"type\":\"2\",\"clickId\":\"99739261\"},{\"reportYear\":null,\"outcompanyName\":\"北京创新伙伴教育科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******389960Y\",\"type\":\"2\",\"clickId\":\"24643544\"},{\"reportYear\":null,\"outcompanyName\":\"小船出海教育科技（北京）有限公司\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"2310297330\"},{\"reportYear\":null,\"outcompanyName\":\"上海兴容信息技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******404344D\",\"type\":\"2\",\"clickId\":\"3049680574\"},{\"reportYear\":null,\"outcompanyName\":\"北京太合音乐文化发展有限公司\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"934605\"},{\"reportYear\":null,\"outcompanyName\":\"北京小度互娱科技有限公司\",\"regNum\":\"\",\"creditCode\":\"91110108MA004HKR33\",\"type\":\"2\",\"clickId\":\"2350111935\"},{\"reportYear\":null,\"outcompanyName\":\"深圳米筐科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******757355B\",\"type\":\"2\",\"clickId\":\"1284552427\"},{\"reportYear\":null,\"outcompanyName\":\"北京智能车联产业创新中心有限公司\",\"regNum\":\"\",\"creditCode\":\"91110302MA0094445T\",\"type\":\"2\",\"clickId\":\"2959951982\"},{\"reportYear\":null,\"outcompanyName\":\"沈阳分分钟企业管理有限公司\",\"regNum\":\"\",\"creditCode\":\"******66462XD\",\"type\":\"2\",\"clickId\":\"2332608915\"},{\"reportYear\":null,\"outcompanyName\":\"南京信风网络科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******879916G\",\"type\":\"2\",\"clickId\":\"2332608916\"},{\"reportYear\":null,\"outcompanyName\":\"上海齐家网信息科技股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"174626493\"},{\"reportYear\":null,\"outcompanyName\":\"北京乐和彩科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******407704H\",\"type\":\"2\",\"clickId\":\"25104813\"},{\"reportYear\":null,\"outcompanyName\":\"客如云科技（北京）股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******37837XC\",\"type\":\"2\",\"clickId\":\"968162943\"},{\"reportYear\":null,\"outcompanyName\":\"深圳前海华视移动互联有限公司\",\"regNum\":\"\",\"creditCode\":\"******11008XF\",\"type\":\"2\",\"clickId\":\"2313860920\"},{\"reportYear\":null,\"outcompanyName\":\"天津龙渊云腾投资管理合伙企业（有限合伙）\",\"regNum\":\"\",\"creditCode\":\"******\",\"type\":\"2\",\"clickId\":\"220504138\"},{\"reportYear\":null,\"outcompanyName\":\"北京百誉信征信有限公司\",\"regNum\":\"\",\"creditCode\":\"******250562L\",\"type\":\"2\",\"clickId\":\"82770842\"}],\"shareholderList\":[{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"13930\",\"subscribeTime\":\"2016-03-29\",\"subscribeType\":\"货币\",\"paidAmount\":\"13930\",\"paidTime\":\"2016-03-29\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"9950\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"9950\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"64675\",\"subscribeTime\":\"2015-12-22\",\"subscribeType\":\"货币\",\"paidAmount\":\"64675\",\"paidTime\":\"2015-12-22\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"70\",\"subscribeTime\":\"2016-03-29\",\"subscribeType\":\"货币\",\"paidAmount\":\"70\",\"paidTime\":\"2016-03-29\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"325\",\"subscribeTime\":\"2015-12-22\",\"subscribeType\":\"货币\",\"paidAmount\":\"325\",\"paidTime\":\"2015-12-22\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"50\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"50\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"}],\"webInfoList\":[{\"reportYear\":null,\"webType\":\"网站\",\"name\":\"百度\",\"website\":\"www.baidu.com\"}],\"reportSocialSecurityInfo\":{\"id\":null,\"annaulreportId\":2691912894,\"endowmentInsurance\":\"1904人\",\"unemploymentInsurance\":\"1904人\",\"medicalInsurance\":\"1904人\",\"employmentInjuryInsurance\":\"1904人\",\"maternityInsurance\":\"1904人\",\"endowmentInsuranceBase\":\"企业选择不公示\",\"unemploymentInsuranceBase\":\"企业选择不公示\",\"medicalInsuranceBase\":\"企业选择不公示\",\"maternityInsuranceBase\":\"企业选择不公示\",\"endowmentInsurancePayAmount\":\"企业选择不公示\",\"unemploymentInsurancePayAmount\":\"企业选择不公示\",\"medicalInsurancePayAmount\":\"企业选择不公示\",\"employmentInjuryInsurancePayAmount\":\"企业选择不公示\",\"maternityInsurancePayAmount\":\"企业选择不公示\",\"endowmentInsuranceOweAmount\":\"企业选择不公示\",\"unemploymentInsuranceOweAmount\":\"企业选择不公示\",\"medicalInsuranceOweAmount\":\"企业选择不公示\",\"employmentInjuryInsuranceOweAmount\":\"企业选择不公示\",\"maternityInsuranceOweAmount\":\"企业选择不公示\",\"createTime\":1534713986000},\"govReport\":null,\"type\":0},{\"baseInfo\":{\"reportYear\":\"2015\",\"companyName\":\"北京百度网讯科技有限公司\",\"creditCode\":\"91110000802100433B\",\"regNumber\":\"\",\"phoneNumber\":\"010-59928888\",\"postcode\":\"100085\",\"postalAddress\":\"北京市海淀区上地十街百度大厦\",\"email\":\"无\",\"manageState\":\"开业\",\"employeeNum\":\"企业选择不公示\",\"operatorName\":\"\",\"totalAssets\":\"企业选择不公示\",\"totalEquity\":\"企业选择不公示\",\"totalSales\":\"企业选择不公示\",\"totalProfit\":\"企业选择不公示\",\"primeBusProfit\":\"企业选择不公示\",\"retainedProfit\":\"企业选择不公示\",\"totalTax\":\"企业选择不公示\",\"totalLiability\":\"企业选择不公示\"},\"companyId\":\"22822\",\"changeRecordList\":[{\"reportYear\":null,\"changeItem\":\"认缴出资额\",\"contentBefore\":\"375\",\"contentAfter\":\"50\",\"changeTime\":\"2016-06-28\"},{\"reportYear\":null,\"changeItem\":\"认缴出资日期\",\"contentBefore\":\"2015-12-22\",\"contentAfter\":\"2008-04-28\",\"changeTime\":\"2016-06-28\"},{\"reportYear\":null,\"changeItem\":\"实缴出资额\",\"contentBefore\":\"375\",\"contentAfter\":\"50\",\"changeTime\":\"2016-06-28\"},{\"reportYear\":null,\"changeItem\":\"实缴出资日期\",\"contentBefore\":\"2015-12-22\",\"contentAfter\":\"2008-04-28\",\"changeTime\":\"2016-06-28\"}],\"equityChangeInfoList\":[],\"outGuaranteeInfoList\":[],\"outboundInvestmentList\":[{\"reportYear\":null,\"outcompanyName\":\"百度鹏寰资产管理（北京）有限公司\",\"regNum\":\"\",\"creditCode\":\"******934777T\",\"type\":\"2\",\"clickId\":\"2310470083\"},{\"reportYear\":null,\"outcompanyName\":\"诺克萨斯（北京）科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******289814B\",\"type\":\"2\",\"clickId\":\"24644208\"},{\"reportYear\":null,\"outcompanyName\":\"北京鼎新天下科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******95430XC\",\"type\":\"2\",\"clickId\":\"2262980\"},{\"reportYear\":null,\"outcompanyName\":\"沈阳分分钟企业管理有限公司\",\"regNum\":\"\",\"creditCode\":\"******66462XD\",\"type\":\"2\",\"clickId\":\"2332608915\"},{\"reportYear\":null,\"outcompanyName\":\"南京信风网络科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******879916G\",\"type\":\"2\",\"clickId\":\"2332608916\"},{\"reportYear\":null,\"outcompanyName\":\"北京捷通华声科技股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******968939Y\",\"type\":\"2\",\"clickId\":\"2345039913\"},{\"reportYear\":null,\"outcompanyName\":\"北京北冥鱼信息技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******022365X\",\"type\":\"2\",\"clickId\":\"41457332\"},{\"reportYear\":null,\"outcompanyName\":\"上海普景信息科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******502540G\",\"type\":\"2\",\"clickId\":\"498896652\"},{\"reportYear\":null,\"outcompanyName\":\"北京幻想纵横网络技术有限公司\",\"regNum\":\"\",\"creditCode\":\"******221683F\",\"type\":\"2\",\"clickId\":\"24489290\"},{\"reportYear\":null,\"outcompanyName\":\"星云融创（北京）科技有限公司\",\"regNum\":\"110108013949273\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"28020234\"},{\"reportYear\":null,\"outcompanyName\":\"北京百付宝科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******354426W\",\"type\":\"2\",\"clickId\":\"26031220\"},{\"reportYear\":null,\"outcompanyName\":\"华扬联众数字技术股份有限公司\",\"regNum\":\"\",\"creditCode\":\"******343096U\",\"type\":\"2\",\"clickId\":\"3174100\"},{\"reportYear\":null,\"outcompanyName\":\"上海叶萌广告传媒有限公司\",\"regNum\":\"310113001004153\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"522030252\"},{\"reportYear\":null,\"outcompanyName\":\"河南沸点网络科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******03928XQ\",\"type\":\"2\",\"clickId\":\"888343156\"},{\"reportYear\":null,\"outcompanyName\":\"北京乐和彩科技有限公司\",\"regNum\":\"\",\"creditCode\":\"******407704H\",\"type\":\"2\",\"clickId\":\"25104813\"}],\"shareholderList\":[{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"64675\",\"subscribeTime\":\"2015-12-22\",\"subscribeType\":\"货币\",\"paidAmount\":\"64675\",\"paidTime\":\"2015-12-22\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"9950\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"9950\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"325\",\"subscribeTime\":\"2015-12-22\",\"subscribeType\":\"货币\",\"paidAmount\":\"325\",\"paidTime\":\"2015-12-22\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"50\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"50\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"}],\"webInfoList\":[{\"reportYear\":null,\"webType\":\"网站\",\"name\":\"百度\",\"website\":\"www.baidu.com\"}],\"reportSocialSecurityInfo\":null,\"govReport\":null,\"type\":0},{\"baseInfo\":{\"reportYear\":\"2014\",\"companyName\":\"北京百度网讯科技有限公司\",\"creditCode\":\"91110000802100433B\",\"regNumber\":\"\",\"phoneNumber\":\"56798989\",\"postcode\":\"100085\",\"postalAddress\":\"北京市海淀区上地十街百度大厦\",\"email\":\"无\",\"manageState\":\"开业\",\"employeeNum\":\"企业选择不公示\",\"operatorName\":\"\",\"totalAssets\":\"企业选择不公示\",\"totalEquity\":\"企业选择不公示\",\"totalSales\":\"企业选择不公示\",\"totalProfit\":\"企业选择不公示\",\"primeBusProfit\":\"企业选择不公示\",\"retainedProfit\":\"企业选择不公示\",\"totalTax\":\"企业选择不公示\",\"totalLiability\":\"企业选择不公示\"},\"companyId\":\"22822\",\"changeRecordList\":[],\"equityChangeInfoList\":[],\"outGuaranteeInfoList\":[],\"outboundInvestmentList\":[{\"reportYear\":null,\"outcompanyName\":\"北京乐和彩科技有限公司\",\"regNum\":\"110108012645996\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"25104813\"},{\"reportYear\":null,\"outcompanyName\":\"重庆融度科技有限公司\",\"regNum\":\"500103000096755\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"275778835\"},{\"reportYear\":null,\"outcompanyName\":\"上海百度人才咨询有限公司\",\"regNum\":\"310114002218153\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"107706459\"},{\"reportYear\":null,\"outcompanyName\":\"鹏寰资产管理（北京）有限公司\",\"regNum\":\"110108007831519\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"2358488052\"},{\"reportYear\":null,\"outcompanyName\":\"南京信风网络科技有限公司\",\"regNum\":\"320102000052417\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"2332608916\"}],\"shareholderList\":[{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"9950\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"9950\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"50\",\"subscribeTime\":\"2008-04-28\",\"subscribeType\":\"货币\",\"paidAmount\":\"50\",\"paidTime\":\"2008-04-28\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"}],\"webInfoList\":[{\"reportYear\":null,\"webType\":\"网站\",\"name\":\"百度\",\"website\":\"www.baidu.com\"}],\"reportSocialSecurityInfo\":null,\"govReport\":null,\"type\":0},{\"baseInfo\":{\"reportYear\":\"2013\",\"companyName\":\"北京百度网讯科技有限公司\",\"creditCode\":\"91110000802100433B\",\"regNumber\":\"\",\"phoneNumber\":\"59928888\",\"postcode\":\"100085\",\"postalAddress\":\"北京市海淀区上地十街百度大厦\",\"email\":\"无\",\"manageState\":\"开业\",\"employeeNum\":\"企业选择不公示\",\"operatorName\":\"\",\"totalAssets\":\"企业选择不公示\",\"totalEquity\":\"企业选择不公示\",\"totalSales\":\"企业选择不公示\",\"totalProfit\":\"企业选择不公示\",\"primeBusProfit\":\"企业选择不公示\",\"retainedProfit\":\"企业选择不公示\",\"totalTax\":\"企业选择不公示\",\"totalLiability\":\"企业选择不公示\"},\"companyId\":\"22822\",\"changeRecordList\":[],\"equityChangeInfoList\":[],\"outGuaranteeInfoList\":[],\"outboundInvestmentList\":[{\"reportYear\":null,\"outcompanyName\":\"北京鼎新天下科技有限公司\",\"regNum\":\"110108012602314\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"2262980\"},{\"reportYear\":null,\"outcompanyName\":\"鹏寰资产管理（北京）有限公司\",\"regNum\":\"110108007831519\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"2358488052\"},{\"reportYear\":null,\"outcompanyName\":\"北京百付宝科技有限公司\",\"regNum\":\"110000010841624\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"26031220\"},{\"reportYear\":null,\"outcompanyName\":\"诺克萨斯（北京）科技有限公司\",\"regNum\":\"110105015433076\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"24644208\"},{\"reportYear\":null,\"outcompanyName\":\"沈阳分分钟科技有限公司\",\"regNum\":\"210132000050933\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"367313515\"},{\"reportYear\":null,\"outcompanyName\":\"北京捷通华声语音技术有限公司\",\"regNum\":\"110108001716760\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"21473239\"},{\"reportYear\":null,\"outcompanyName\":\"北京亦水方舟科技有限公司\",\"regNum\":\"110101014299674\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"33978180\"},{\"reportYear\":null,\"outcompanyName\":\"北京北冥鱼信息技术有限公司\",\"regNum\":\"110107014932867\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"41457332\"},{\"reportYear\":null,\"outcompanyName\":\"河南沸点网络科技有限公司\",\"regNum\":\"410198000013965\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"888343156\"},{\"reportYear\":null,\"outcompanyName\":\"上海优扬新媒信息技术有限公司\",\"regNum\":\"310115001892641\",\"creditCode\":\"\",\"type\":\"2\",\"clickId\":\"1251488443\"}],\"shareholderList\":[{\"investorName\":\"李彦宏\",\"subscribeAmount\":\"9950\",\"subscribeTime\":\"2001-06-05\",\"subscribeType\":\"货币\",\"paidAmount\":\"9950\",\"paidTime\":\"2001-06-05\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"1984012283\",\"reportYear\":null,\"toco\":\"13\"},{\"investorName\":\"王湛\",\"subscribeAmount\":\"50\",\"subscribeTime\":\"2001-06-05\",\"subscribeType\":\"货币\",\"paidAmount\":\"50\",\"paidTime\":\"2001-06-05\",\"paidType\":\"货币\",\"type\":\"1\",\"clickId\":\"2074091018\",\"reportYear\":null,\"toco\":\"25\"}],\"webInfoList\":[{\"reportYear\":null,\"webType\":\"网站\",\"name\":\"百度\",\"website\":\"www.baidu.com\"}],\"reportSocialSecurityInfo\":null,\"govReport\":null,\"type\":0}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open371AnnualreportDTO>> rtnDTO = new BaseRespnseDTO<List<Open371AnnualreportDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String entName = param.getName();

		BaseRespnseDTO<List<Open371AnnualreportDTO>> rtnDTO = new BaseRespnseDTO<List<Open371AnnualreportDTO>>();
		rtnDTO.setRtnSerialNo(dtos.getSeqNum());
		rtnDTO.setRespStr(apiData);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(dtos.getMessage());
		// 非正常情况
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) {
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}

		

		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 查询成功
		ResponsePageNumResultDTO<Open371AnnualreportDTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open371AnnualreportDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
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
			entAnnualreportInfoEntity.setEntId(param.getEntListInfo().getId());
			entAnnualreportInfoEntity.setEntName(entName);
			entAnnualreportInfoEntity.setCreditCode(param.getEntListInfo().getCreditCode());
			entAnnualreportInfoEntity.setBelongYear(belongYear);
			entAnnualreportInfoService.insert(entAnnualreportInfoEntity);

			entAnnualreportBaseInfoService.deleteByEntNameReportYear(entName, belongYear);
			baseInfoEntity = new EntAnnualreportBaseInfoEntity();
			BeanUtils.copyProperties(baseInfo, baseInfoEntity);
			baseInfoEntity.setEntId(param.getEntListInfo().getId());
			baseInfoEntity.setEntName(entName);
			baseInfoEntity.setCreditCode(param.getEntListInfo().getCreditCode());
			baseInfoEntity.setBelongYear(belongYear);
			entAnnualreportBaseInfoService.insert(baseInfoEntity);

			List<Open371AnnualreportChangeRecordDTO> changeRecordList = item.getChangeRecordList();
			List<EntAnnualreportChangeRecordEntity> changeRecordEntityList = Lists.newArrayList();
			if (null != changeRecordList && changeRecordList.size() > 0) {
				entAnnualreportChangeRecordService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportChangeRecordEntity entity = null;
				for (Open371AnnualreportChangeRecordDTO dto : changeRecordList) {
					entity = new EntAnnualreportChangeRecordEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
					entity.setBelongYear(belongYear);

					changeRecordEntityList.add(entity);
				}
				entAnnualreportChangeRecordService.insertBatch(changeRecordEntityList);
			}
			List<Open371AnnualreportEquityChangeInfoDTO> equityChangeInfoList = item.getEquityChangeInfoList();
			List<EntAnnualreportEquityChangeInfoEntity> entAnnualreportEquityChangeInfoEntityList = Lists.newArrayList();
			if (null != equityChangeInfoList && equityChangeInfoList.size() > 0) {
				entAnnualreportEquityChangeInfoService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportEquityChangeInfoEntity entity = null;
				for (Open371AnnualreportEquityChangeInfoDTO dto : equityChangeInfoList) {
					entity = new EntAnnualreportEquityChangeInfoEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
					entity.setBelongYear(belongYear);

					entAnnualreportEquityChangeInfoEntityList.add(entity);
				}
				entAnnualreportEquityChangeInfoService.insertBatch(entAnnualreportEquityChangeInfoEntityList);
			}

			List<Open371AnnualreportOutGuaranteeInfoDTO> outGuaranteeInfoList = item.getOutGuaranteeInfoList();
			List<EntAnnualreportOutGuaranteeInfoEntity> outGuaranteeInfoEntityList = Lists.newArrayList();
			if (null != outGuaranteeInfoList && outGuaranteeInfoList.size() > 0) {
				entAnnualreportOutGuaranteeInfoService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportOutGuaranteeInfoEntity entity = null;
				for (Open371AnnualreportOutGuaranteeInfoDTO dto : outGuaranteeInfoList) {
					entity = new EntAnnualreportOutGuaranteeInfoEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
					entity.setBelongYear(belongYear);

					outGuaranteeInfoEntityList.add(entity);
				}
				entAnnualreportOutGuaranteeInfoService.insertBatch(outGuaranteeInfoEntityList);
			}
			List<Open371AnnualreportOutboundInvestmentDTO> outboundInvestmentList = item.getOutboundInvestmentList();
			List<EntAnnualreportOutboundInvestmentEntity> outboundInvestmentEntityList = Lists.newArrayList();
			if (null != outboundInvestmentList && outboundInvestmentList.size() > 0) {
				entAnnualreportOutboundInvestmentService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportOutboundInvestmentEntity entity = null;
				for (Open371AnnualreportOutboundInvestmentDTO dto : outboundInvestmentList) {
					entity = new EntAnnualreportOutboundInvestmentEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
					entity.setBelongYear(belongYear);

					outboundInvestmentEntityList.add(entity);
				}
				entAnnualreportOutboundInvestmentService.insertBatch(outboundInvestmentEntityList);
			}
			List<Open371AnnualreportShareholderDTO> shareholderList = item.getShareholderList();
			List<EntAnnualreportShareholderEntity> shareholderEntityList = Lists.newArrayList();
			if (null != shareholderList && shareholderList.size() > 0) {
				entAnnualreportShareholderService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportShareholderEntity entity = null;
				for (Open371AnnualreportShareholderDTO dto : shareholderList) {
					entity = new EntAnnualreportShareholderEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
					entity.setBelongYear(belongYear);

					shareholderEntityList.add(entity);
				}
				entAnnualreportShareholderService.insertBatch(shareholderEntityList);
			}
			List<Open371AnnualreportWebInfoDTO> webInfoList = item.getWebInfoList();
			List<EntAnnualreportWebInfoEntity> webInfoEntityList = Lists.newArrayList();
			if (null != webInfoList && webInfoList.size() > 0) {
				entAnnualreportWebInfoService.deleteByEntNameBelongYear(entName, belongYear);
				EntAnnualreportWebInfoEntity entity = null;
				for (Open371AnnualreportWebInfoDTO dto : webInfoList) {
					entity = new EntAnnualreportWebInfoEntity();
					BeanUtils.copyProperties(dto, entity);
					entity.setEntId(param.getEntListInfo().getId());
					entity.setEntName(entName);
					entity.setCreditCode(param.getEntListInfo().getCreditCode());
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
				entity.setEntId(param.getEntListInfo().getId());
				entity.setEntName(entName);
				entity.setCreditCode(param.getEntListInfo().getCreditCode());
				entity.setBelongYear(belongYear);

				entAnnualreportSocialSecurityService.insert(entity);
			}
		}
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
