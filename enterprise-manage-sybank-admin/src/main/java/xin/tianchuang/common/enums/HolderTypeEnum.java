package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * 股东类型
 * 
 * @author denghui
 *
 */
public enum HolderTypeEnum implements IEnum {
	COMPANY(1, "企业股东"), //
	PERSON(2, "自然人股东"), //
	;

	private Integer key;
	private String desc;

	HolderTypeEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public int key() {
		return key;
	}

	public String desc() {
		return desc;
	}

	@Override
	public Serializable getValue() {
		return key;
	}

}
