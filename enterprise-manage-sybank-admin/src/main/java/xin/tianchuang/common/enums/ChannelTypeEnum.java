package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum ChannelTypeEnum implements StrEnum {
	RISK("RISK", "风控"), //
	CREDIT("CREDIT", "信贷"), //
	SYS("SYS", "定时"),
	;

	private String key;
	private String desc;

	ChannelTypeEnum(String key, String desc) {
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
}
