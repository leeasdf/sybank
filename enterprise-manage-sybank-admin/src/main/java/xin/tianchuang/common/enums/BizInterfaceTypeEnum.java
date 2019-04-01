package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum BizInterfaceTypeEnum implements IntEnum {

	FINANCE(1, "提额调查收集报告"), //
	CHECK(2, "贷后常规检查报告"), //
	TYC(3, "天眼查模型"), //
	CREDIT(4, "企业授信"), //
	COMPANY(5, "企业征信")
	;

	private int key;
	private String desc;

	BizInterfaceTypeEnum(int key, String desc) {
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
