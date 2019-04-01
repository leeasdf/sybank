package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DataStatusEnum implements IEnum {
	UN_ACTIVE(0, "待激活"), ACTIVE(1, "正常"), FROZEN(2, "冻结"), ;

	private Integer key;
	private String desc;

	DataStatusEnum(final int key, final String desc) {
		this.key = key;
		this.desc = desc;
	}

	public int key() {
		return key;
	}

	@JsonValue
	public String desc() {
		return desc;
	}

	@Override
	public Serializable getValue() {
		return this.key;
	}

}
