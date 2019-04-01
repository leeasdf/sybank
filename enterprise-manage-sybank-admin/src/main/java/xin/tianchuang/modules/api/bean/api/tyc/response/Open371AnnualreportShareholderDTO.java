package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open371AnnualreportShareholderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6767813563926284646L;
	private String investorName;// 股东名称
	private String subscribeAmount;// 认缴出资额
	private String subscribeTime;// 认缴出资时间
	private String subscribeType;// 认缴出资方式
	private String paidAmount;// 实缴出资额
	private String paidTime;// 实缴出资时间
	private String paidType;// 实缴出资方式
	private String type;// 1-人 2-公司
	private String clickId;// 股东id
	private String reportYear;// 年份
	public String getInvestorName() {
		return investorName;
	}
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	public String getSubscribeAmount() {
		return subscribeAmount;
	}
	public void setSubscribeAmount(String subscribeAmount) {
		this.subscribeAmount = subscribeAmount;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getSubscribeType() {
		return subscribeType;
	}
	public void setSubscribeType(String subscribeType) {
		this.subscribeType = subscribeType;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPaidTime() {
		return paidTime;
	}
	public void setPaidTime(String paidTime) {
		this.paidTime = paidTime;
	}
	public String getPaidType() {
		return paidType;
	}
	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClickId() {
		return clickId;
	}
	public void setClickId(String clickId) {
		this.clickId = clickId;
	}
	public String getReportYear() {
		return reportYear;
	}
	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	
}
