package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4225048038415589083L;

	public BaseResponse() {
	}

	public BaseResponse(boolean success, String msg, T data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 说明
	 */
	private String msg;

	/**
	 * 返回数据
	 */
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
