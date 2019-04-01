package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ResponseResultDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -587997660223733984L;

	/**
	 * 状态码
	 */
	@SerializedName("error_code")
	private Long errorCode;

	/**
	 * 错误信息
	 */
	private String reason;

	/**
	 * 结果集
	 */
	private T result;

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
