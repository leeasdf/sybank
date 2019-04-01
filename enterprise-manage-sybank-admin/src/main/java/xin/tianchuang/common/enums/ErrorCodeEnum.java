package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API_对外错误码
 * 
 * @author denghui
 *
 */
public enum ErrorCodeEnum implements IEnum {
	/**
	 * 对外错误码
	 */
	REQ_SUCCESS(0, "请求成功"), //
	NO_DATA(300000, "无数据"), //
	REQ_FAIL(300001, "请求失败"), //
	ACCOUNT_INVALID(300002, "账号失效或停用"), //
	ACCOUNT_EXPIRE(300003, "账号过期"), //
	frequent_access(300004, "访问频率过快"), //
	NO_AUTH_ACCESS_API(300005, "无权限访问此api"), //
	NO_MONEY(300006, "余额不足"), //
	NO_RESIDUE_DEGREE(300007, "剩余次数不足"), //
	MISS_NECESSARA_PARAM(300008, "缺少必要参数"), //
	ACCOUNT_INCORRECT(300009, "账号信息有误"), //
	URL_NOT_EXIST(300010, "URL不存在") //
	;

	private  int key;
	private String desc;

	ErrorCodeEnum(int key, String desc) {
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
