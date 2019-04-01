package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

/**
 * API日志状态
 * 
 * @author denghui
 *
 */
public enum ApiLogStatusEnum implements StrEnum {
	INIT("INIT", "初始化"), //
	SUCCESS("SUCCESS", "成功"), //
	PROCESS("PROCESS", "进行中"), //
	FAIL("FAIL", "失败"), //
	;

	private String key;
	private String desc;

	ApiLogStatusEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String key() {
		return key;
	}

	public String desc() {
		return desc;
	}

}
