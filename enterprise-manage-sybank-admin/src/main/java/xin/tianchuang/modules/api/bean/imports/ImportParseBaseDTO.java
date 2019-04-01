package xin.tianchuang.modules.api.bean.imports;

import java.io.Serializable;

public class ImportParseBaseDTO<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6450158544144223212L;

	private String cid;
	
	private String cname;
	
	private String rid;
	
	private String ccode;
	
	private T result;
	
	private String bizCode;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	
	

	
}
