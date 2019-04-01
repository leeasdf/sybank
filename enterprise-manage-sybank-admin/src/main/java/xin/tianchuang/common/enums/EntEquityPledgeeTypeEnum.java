package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum EntEquityPledgeeTypeEnum implements IntEnum {

	COMPANY(1, "公司"), //
	PLEDGEE(2, "质权人"), //
	PLEDGOR(3, "出质人"), //
	;

	private int key;
	private String desc;

	EntEquityPledgeeTypeEnum(Integer key, String desc) {
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
