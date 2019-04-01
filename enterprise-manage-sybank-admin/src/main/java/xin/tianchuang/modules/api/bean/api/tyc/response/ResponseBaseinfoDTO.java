package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class ResponseBaseinfoDTO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3890151457478656729L;

	/**
	 * 类型 0为天眼查365接口 ，1为459接口返回信息
	 */
	private Integer invokeType;

	private T result;

	public Integer getInvokeType() {
		return invokeType;
	}

	public void setInvokeType(Integer invokeType) {
		this.invokeType = invokeType;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
