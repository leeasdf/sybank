package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open371AnnualreportOutboundInvestmentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5081110973469955249L;
	private String reportYear;// 年份
	private String outcompanyName;// 被投资公司
	private String regNum;// 注册码
	@SerializedName("creditCode")
	private String outcompanyCreditCode;// 社会统一信用代码
	private Integer type;// 1-人 2-公司
	private String clickId;// 被投资公司id

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getOutcompanyName() {
		return outcompanyName;
	}

	public void setOutcompanyName(String outcompanyName) {
		this.outcompanyName = outcompanyName;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getOutcompanyCreditCode() {
		return outcompanyCreditCode;
	}

	public void setOutcompanyCreditCode(String outcompanyCreditCode) {
		this.outcompanyCreditCode = outcompanyCreditCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getClickId() {
		return clickId;
	}

	public void setClickId(String clickId) {
		this.clickId = clickId;
	}

}
