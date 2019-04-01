package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum EntKtannouncePeopleTypeEnum implements IntEnum {

	PLAINTIFF(1, "原告/上诉人"), //
	DEFENDANT(2, "被告/被上诉人"), //
	;

	private int key;
	private String desc;

	EntKtannouncePeopleTypeEnum(Integer key, String desc) {
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
