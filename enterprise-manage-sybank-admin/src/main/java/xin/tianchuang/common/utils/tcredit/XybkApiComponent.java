package xin.tianchuang.common.utils.tcredit;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;

import com.google.common.collect.Maps;

public class XybkApiComponent {

	private static Logger logger = LoggerFactory.getLogger(XybkApiComponent.class);

	private static String appId = "a8e319a8b6f64b3e91024e7792a2c701";
	private static String tokenId = "5f69b81d04f14dfea669252892a25d0f";
//	private static String baseUrl = "http://124.207.122.29:18080/dmp-service-web";
	private static String baseUrl = "http://sy.tcredit.com/dmp-service-web/";

	// 天眼查接口
	private static final Map<String, String>  urlMap = Maps.newHashMap();;
	static{
	urlMap.put(TycInterfaceTypeEnum.BASEINFO_V3.key(), "/service/tianyancha/baseinfoV3"); // 获取企业基本信息_含主要人员 商标信息
	urlMap.put(TycInterfaceTypeEnum.HOLDER.key(), "/service/tianyancha/holder"); // 股东信息
	urlMap.put(TycInterfaceTypeEnum.INVERST.key(), "/service/tianyancha/inverst"); // 对外投资
	urlMap.put(TycInterfaceTypeEnum.CHANGEINFO.key(), "/service/tianyancha/changeinfo"); //
	urlMap.put(TycInterfaceTypeEnum.BRANCH.key(), "/service/tianyancha/branch"); //
	urlMap.put(TycInterfaceTypeEnum.LAW_SUIT.key(), "/service/tianyancha/lawSuit"); //
	urlMap.put(TycInterfaceTypeEnum.COURT_ANNOUNCEMENT.key(), "/service/tianyancha/courtAnnouncement"); //
	urlMap.put(TycInterfaceTypeEnum.DISHONEST_V2.key(), "/service/tianyancha/dishonestV2"); //
	urlMap.put(TycInterfaceTypeEnum.ZHIXINGINFO.key(), "/service/tianyancha/zhixinginfo"); //
	urlMap.put(TycInterfaceTypeEnum.KTANNOUNCEMENT.key(), "/service/tianyancha/ktannouncement"); //
	urlMap.put(TycInterfaceTypeEnum.ABNORMAL.key(), "/service/tianyancha/abnormal"); //
	urlMap.put(TycInterfaceTypeEnum.CREDIT_CHINA_V2.key(), "/service/tianyancha/creditChinaV2"); //
	urlMap.put(TycInterfaceTypeEnum.EQUITY_INFO.key(), "/service/tianyancha/equityInfo"); //
	urlMap.put(TycInterfaceTypeEnum.MORTGAGE_INFO.key(), "/service/tianyancha/mortgageInfo"); //
	urlMap.put(TycInterfaceTypeEnum.OWN_TAX.key(), "/service/tianyancha/ownTax"); //
	urlMap.put(TycInterfaceTypeEnum.BIDS.key(), "/service/tianyancha/bids"); //
	urlMap.put(TycInterfaceTypeEnum.EMPLOYMENTS_V2.key(), "/service/tianyancha/employmentsV2"); //
	urlMap.put(TycInterfaceTypeEnum.TM.key(), "/service/tianyancha/tm"); //
	urlMap.put(TycInterfaceTypeEnum.PATENTS.key(), "/service/tianyancha/patents"); //
	urlMap.put(TycInterfaceTypeEnum.COPY_REG_WORKS.key(), "/service/tianyancha/copyRegWorks"); //
	urlMap.put(TycInterfaceTypeEnum.COPY_REG.key(), "/service/tianyancha/copyReg"); //
	urlMap.put(TycInterfaceTypeEnum.ICP.key(), "/service/tianyancha/icp"); //
	urlMap.put(TycInterfaceTypeEnum.NEWS.key(), "/service/tianyancha/news"); //
	urlMap.put(TycInterfaceTypeEnum.ONE_KEY_C.key(), "/service/tianyancha/oneKeyC"); //
	urlMap.put(TycInterfaceTypeEnum.ANNUALREPORT.key(), "/service/tianyancha/annualreport"); //
	urlMap.put(TycInterfaceTypeEnum.COMPANY_INFO.key(), "/service/tianyancha/companyInfo"); //
	}
	private static String getApiUrl(TycInterfaceTypeEnum interfaceType) {
		switch (interfaceType) {
		case BASEINFO_V3:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.BASEINFO_V3.key());
		case HOLDER:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.HOLDER.key());
		case INVERST:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.INVERST.key());
		case CHANGEINFO:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.CHANGEINFO.key());
		case BRANCH:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.BRANCH.key());
		case LAW_SUIT:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.LAW_SUIT.key());
		case COURT_ANNOUNCEMENT:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.COURT_ANNOUNCEMENT.key());
		case DISHONEST_V2:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.DISHONEST_V2.key());
		case ZHIXINGINFO:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.ZHIXINGINFO.key());
		case KTANNOUNCEMENT:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.KTANNOUNCEMENT.key());
		case ABNORMAL:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.ABNORMAL.key());
		case CREDIT_CHINA_V2:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.CREDIT_CHINA_V2.key());
		case EQUITY_INFO:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.EQUITY_INFO.key());
		case MORTGAGE_INFO:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.MORTGAGE_INFO.key());
		case OWN_TAX:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.OWN_TAX.key());
		case BIDS:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.BIDS.key());
		case EMPLOYMENTS_V2:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.EMPLOYMENTS_V2.key());
		case TM:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.TM.key());
		case PATENTS:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.PATENTS.key());
		case COPY_REG_WORKS:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.COPY_REG_WORKS.key());
		case COPY_REG:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.COPY_REG.key());
		case ICP:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.ICP.key());
		case NEWS:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.NEWS.key());
		case ONE_KEY_C:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.ONE_KEY_C.key());
		case ANNUALREPORT:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.ANNUALREPORT.key());
		case COMPANY_INFO:
			return baseUrl + urlMap.get(TycInterfaceTypeEnum.COMPANY_INFO.key());
		default:
			break;
		}
		return null;

	}

	public static String getApiRespData(BizRequestParamDTO param, TycInterfaceTypeEnum interfaceType) {
		Map<String, String> paramMap = Maps.newHashMap();;
		paramMap.put("appId", appId);

		if (null != param.getCompanyId()) {
			paramMap.put("companyId", "" + param.getCompanyId());
		}

		if (StringUtils.isNotBlank(param.getName())) {
			paramMap.put("companyName", param.getName());
		}

		if (null != param.getPageNum()) { // 当前页数（默认第一页，每页20条）
			paramMap.put("pageNum", String.valueOf(param.getPageNum()));
		}

		if (null == param.getCompanyId() && StringUtils.isBlank(param.getName())) {
			throw new SpiderException("企业id和企业名称不能同时为空");
		}

		paramMap.put("sign", SignUtil.signature(tokenId, paramMap));
		Response content = SpiderJsoupUtil.getContent(getApiUrl(interfaceType), paramMap, null, Method.GET,null,4000,3,false);
		logger.info("API查询结果 --> {}", content.body());
		return content.body();
	}

}
