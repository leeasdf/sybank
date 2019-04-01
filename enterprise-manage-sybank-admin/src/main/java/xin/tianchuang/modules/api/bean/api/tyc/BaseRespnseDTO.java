/**
 * Copyright: Copyright (c)2016
 * Company: 易宝支付(YeePay)
 */
package xin.tianchuang.modules.api.bean.api.tyc;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;

/**
 * @author：hui.deng
 * @since：2016年12月28日 下午4:44:19
 * @version:
 * @param <T>
 */
public class BaseRespnseDTO<T> extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8889153956058636836L;

	/**
	 * 返回流水号
	 */
	private String rtnSerialNo;

	/**
	 * 返回实体
	 */
	private String respStr;
	/**
	 * 返回码
	 */
	private int code = TcxyApiStatusCodeEnum.SUCCESS.key();
	/**
	 * 返回码描述
	 */
	private String msg = TcxyApiStatusCodeEnum.SUCCESS.desc();

	/**
	 * 响应保留信息
	 */
	private String respReserve;
	/**
	 * 备注
	 */
	private String remark;
	
	private T data;

	public String getRtnSerialNo() {
		return rtnSerialNo;
	}

	public void setRtnSerialNo(String rtnSerialNo) {
		this.rtnSerialNo = rtnSerialNo;
	}

	public String getRespStr() {
		return respStr;
	}

	public void setRespStr(String respStr) {
		this.respStr = respStr;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRespReserve() {
		return respReserve;
	}

	public void setRespReserve(String respReserve) {
		this.respReserve = respReserve;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
