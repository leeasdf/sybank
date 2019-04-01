package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * 有误数据类型
 * 
 * @author denghui
 *
 */
public enum YesOrNoEnum implements IEnum {
	NO(0, "无数据"), //
	YES(1, "有数据"), //
	;

	private Integer key;
	private String desc;

	YesOrNoEnum(int key, String desc) {
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
