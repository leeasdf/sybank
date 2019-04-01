package xin.tianchuang.common.enums.tcxy;

import xin.tianchuang.common.enums.base.IntEnum;

public enum TcxyApiStatusCodeEnum implements IntEnum {

	SUCCESS(10, "查询成功"), //
	SUCCESS_NO_DATA(11, "查询成功无数据"), //
	FAIL(12, "查询失败"), //
	
	PROCESS(13, "查询中"), //
	SYS_BUZY(21, "系统繁忙"), //
	
	SYS_ERR(20, "系统错误"), //
	INTERFACE_ERR(22, "接口错误"), //
	ACCOUNT_ERR(23, "用户错误"), //
	PARAM_ERR(24, "参数错误"), //
	;

	private int key;
	private String desc;

	TcxyApiStatusCodeEnum(int key, String desc) {
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
