package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;



/**
 * API接口参数-数据类型
 * @author denghui
 *
 */
public enum ApiDataTypeEnum implements IEnum {
	// 企业
	TC_INDUSTRY_COMMERCE(1, "天创_工商接口(收费)"),
	TC_INTELLECTUAL_PROPERTY_RIGHTS(2, "天创_知识产权"),
	TC_ENTERPRISE_LITIGATION(3, "天创_企业涉诉基本信息"),
	TC_ENTERPRISE_LITIGATION_DETAIL(4, "天创_企业涉诉详细信息"),
	TC_ENTERPRISE_TAX(5, "天创_企业税务信息"),
	// 个人
	TC_PERSON_BAD(6, "天创_个人不良信息"),
	TC_PERSON_BAD2(7, "天创_个人不良信息"),
	TC_PERSON_LITIGATION(7, "天创_个人涉诉信息"),
	TC_VERIFY_IDCARD(7, "天创_个人身份认证信息"),
	;

	private int key;
	private String desc;

	ApiDataTypeEnum(int key, String desc) {
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
