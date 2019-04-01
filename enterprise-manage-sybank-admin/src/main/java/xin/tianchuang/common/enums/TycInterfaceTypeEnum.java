package xin.tianchuang.common.enums;

import org.apache.commons.lang3.StringUtils;

import xin.tianchuang.common.enums.base.StrEnum;

public enum TycInterfaceTypeEnum implements StrEnum {

	BASEINFO_V3("BASEINFO_V3", "365-获取企业基本信息（含主要人员）"), //
	HOLDER("HOLDER", "368-股东信息"), //
	INVERST("INVERST", "369-对外投资"), //
	CHANGEINFO("CHANGEINFO", "370-变更记录"), //
	BRANCH("BRANCH", "372-分支机构"), //
	
	LAW_SUIT("LAW_SUIT", "384-法律诉讼"), //
	COURT_ANNOUNCEMENT("COURT_ANNOUNCEMENT", "385-法院公告"), //
	DISHONEST_V2("DISHONEST_V2", "777-失信人（新版）"), //
	ZHIXINGINFO("ZHIXINGINFO", "389-被执行人"), //
	KTANNOUNCEMENT("KTANNOUNCEMENT", "386-开庭公告"), //
	
	ABNORMAL("ABNORMAL", "391-经营异常"), //
	CREDIT_CHINA_V2("CREDIT_CHINA_V2", "767-行政处罚--信用中国（新版）"), //
	EQUITY_INFO("EQUITY_INFO", "404-股权出质"), //
	MORTGAGE_INFO("MORTGAGE_INFO", "421-动产抵押"), //
	OWN_TAX("OWN_TAX", "422-欠税公告"), //
	
	BIDS("BIDS", "429-招投标"), //
	EMPLOYMENTS_V2("EMPLOYMENTS_V2", "782-招聘（新版）"), //
	TM("TM", "439-商标信息"), //
	PATENTS("PATENTS", "440-专利"), //
	COPY_REG_WORKS("COPY_REG_WORKS", "733-作品著作权"), //
	
	COPY_REG("COPY_REG", "441-著作权"), //
	ICP("ICP", "442-网站备案"), //
	NEWS("NEWS", "446-获取公司新闻列表"), //
	ONE_KEY_C("ONE_KEY_C", "783-企业图谱（新版）"), //
	ANNUALREPORT("ANNUALREPORT", "371-企业年报"), //
	
	COMPANY_INFO("COMPANY_INFO","460-企业简介"),
	@Deprecated
	XGBASEINFO_V2("XGBASEINFO_V2","459-香港公司、社会组织、律所"),
	;

	private String key;
	private String desc;

	TycInterfaceTypeEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}

    public static TycInterfaceTypeEnum transfar(String interfaceName) {
		if(StringUtils.isBlank(interfaceName)){
			return  null;
		}
		for(TycInterfaceTypeEnum item: TycInterfaceTypeEnum.values()){
			if(item.key.equals(interfaceName)){
				return item;
			}
		}
		return null;
    }
}
