package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

/**
 * 报告预警类型
 * @author denghui
 *
 */
public enum ReportWaringTypeEnum implements IntEnum {
	NO_WARN(0, "无预警"), //
	RED(1, "红色"), //
	YELLOW(2, "黄色"), //
	YELLOW_SURVEY(3, "黄色（需要调查）"), //
	
	;

	private int key;
	private String desc;

	ReportWaringTypeEnum(int key, String desc) {
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
