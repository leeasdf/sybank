package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum EntEntityTypeEnum implements IntEnum {

	COMPANY(1, "公司"), //
	HK(2, "香港公司"), //
	SOCIAL(3, "社会组织"), //
	LAW(4, "律所"), //
	INSTITUTION(5, "事业单位"), //
	FOUNDATION(6, "基金会"), //
	OTHER(7, "不存在法人、注册资本、统一社会信用代码、经营状态的企业"), //
	
	;

	private int key;
	private String desc;

	EntEntityTypeEnum(int key, String desc) {
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
