package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum ApiStatusEnum implements StrEnum {

	INIT("INIT", "已请求"), FAIL("FAIL", "已失败"), SUCCESS("SUCCESS", "已成功"), PROCESS("PROCESS", "处理中"), ;

	private String key;
	private String desc;

	ApiStatusEnum(String key, String desc) {
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
