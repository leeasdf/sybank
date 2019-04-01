package xin.tianchuang.common.enums;

import org.apache.commons.lang3.StringUtils;

import xin.tianchuang.common.enums.base.IntEnum;

/**
 * 上市标识
 * 
 * @author denghui
 *
 */
public enum ListedFlagEnum implements IntEnum {

	NO_LISTED(0, "未上市"), //
	LISTED_A(1, "A股"), //
	LISTED_B(2, "B股"), //
	LISTED_C(3, "新三板"), //
	LISTED_C_OLD(4, "老三板"), //
	;

	private int key;
	private String desc;

	ListedFlagEnum(Integer key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public static Integer getEnumByDesc(String desc) {
		if (StringUtils.isBlank(desc)) {
			return null;
		}

		for (ListedFlagEnum listedFlagEnum : ListedFlagEnum.values()) {
			if (listedFlagEnum.desc().equals(desc)) {
				return listedFlagEnum.key();
			}
		}

		return null;
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
