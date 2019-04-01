package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum HolderCaptialEnum implements IntEnum {
	CAPITAL_ACTL(1, "实缴"), //
	CAPITAL(2, "认缴"), ;

	private int key;
	private String desc;

	HolderCaptialEnum(int key, String desc) {
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
