package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

/**
 * 报告变更事项类型
 * @author denghui
 *
 */
public enum ChangeTypeEnum implements IntEnum {
	LEGAL(3, "法定代表人变更"), //
	REG_CAPITAL(4, "注册资本变更"), //
	INDUSTRY(5, "行业变更"), //
	REG_LOCATION(6, "注册地址变更"), //
	BUSINESS_SCOPE(7, "经营范围变更"), //
	HOLDER(8, "股东变更"), //
	INVERST(2, "对外投资变更"), //
	SOCIAL_STAFF_NUM(1, "人员变更"), //
	LAW_SUIT_PLAINTIFFS(10, "法律诉讼变更"), //
	COURT_ANNOUNCE(12, "法院公告变更"), //
	DISHONEST_V2(16, "失信人（新版）"), //
	
	STAFF(9, "主要人员变更"), //
	
	COURT_ANNOUNCE_DEFENDANTS(13, "法院公告被告"), //
	KTANNOUNCE_PLAINTIFFS(14, "开庭公告原告"), //
	KTANNOUNCE_DEFENDANTS(15, "开庭公告被告"), //
	
	ABNORMA_BROKEN_RULE(17, "经营异常_未按照规定报送年报"), //
	ABNORMA_OUT_CONTACT(18, "经营异常_失联"), //
	EQUITY(19,"股权出质"), //
	MORTGAGE(20,"动产抵押"), //
	
	OWNTAX(21,"欠税公告"), //
	EMPLOYMENTS_V2(22,"招聘信息"), //
	NEGATIVE_NEWS(23,"负面信息"), //
	;

	private int key;
	private String desc;

	ChangeTypeEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public int key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}
}
