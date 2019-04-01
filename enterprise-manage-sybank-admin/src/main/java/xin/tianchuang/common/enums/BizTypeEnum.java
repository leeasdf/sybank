package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum BizTypeEnum implements IntEnum {

	UP(1, "提额调查收集"), //
	BEFORE(2, "贷后常规检查"), //

	CHECK(3, "突击调查"), //
	TYC(4, "天眼查模型加工"), //
	;

	private int key;
	private String desc;

	BizTypeEnum(int key, String desc) {
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
