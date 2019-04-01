package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API接口参数-企业类型
 * 
 * @author denghui
 *
 */
public enum ApiEnterpriseTypeEnum implements IEnum {
	/* 企业名称 */
	NAME(2, "企业名称"), REG_NO(3, "工商注册号"), CERT_NO(4, "法人身份证号码"), ;

	private int key;
	private String desc;

	ApiEnterpriseTypeEnum(int key, String desc) {
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
