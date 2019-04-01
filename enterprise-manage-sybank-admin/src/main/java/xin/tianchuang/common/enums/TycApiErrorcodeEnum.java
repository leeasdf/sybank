package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.IntEnum;

public enum TycApiErrorcodeEnum implements IntEnum {

	EC_0(0, "请求成功"), //
	EC_300000(300000, "无数据"), //
	EC_300001(300001, "请求失败"), //
	EC_300002(300002, "账号失效"), //
	EC_300003(300003, "账号过期"), //
	EC_300004(300004, "访问频率过快"), //
	EC_300005(300005, "无权限访问此api"), //
	EC_300006(300006, "余额不足"), //
	EC_300007(300007, "剩余次数不足"), //
	EC_300008(300008, "缺少必要参数"), //
	EC_300009(300009, "账号信息有误"), //
	EC_300010(300010, "URL不存在"), //
	;
	private int key;
	private String desc;

	TycApiErrorcodeEnum(int key, String desc) {
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
