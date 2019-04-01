package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API接口参数-企业类型
 * 
 * @author denghui
 *
 */
public enum EnterpriseStatusEnum implements IEnum {
	HOLD(1, "存续（在营、开业、在册）"), //
	REVOKE_NOT_CANCLE(2, "吊销，未注销"), //
	REVOKED_CANCLED(3, "吊销，已注销"), //
	CANCLE(4, "注销"), //
	EVACUATION(6, "迁出"), //
	;

	private int key;
	private String desc;

	EnterpriseStatusEnum(int key, String desc) {
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
