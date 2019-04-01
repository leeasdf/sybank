package xin.tianchuang.modules.api.dto;

import java.io.Serializable;

public class TycApiRespDTO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963516610611203279L;

	private Integer status;

	private String message;

	private String bizCode;

	private String seqNum;

	private T data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
