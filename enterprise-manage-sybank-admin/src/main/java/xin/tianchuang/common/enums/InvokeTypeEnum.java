package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum InvokeTypeEnum implements IntEnum {

	COMPANY(0, "公司"), //
	OTHER(1, "其他"), //
	;

	private int key;
	private String desc;

	InvokeTypeEnum(int key, String desc) {
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
