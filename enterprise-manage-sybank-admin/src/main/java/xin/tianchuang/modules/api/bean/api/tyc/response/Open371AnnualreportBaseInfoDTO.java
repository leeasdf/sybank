package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open371AnnualreportBaseInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516788509519186384L;
	private String reportYear;// 年份
	private String companyName;// 公司名
	@SerializedName("creditCode")
	private String annualreportCreditCode;// 统一社会信用代码
	private String regNumber;// 注册码
	private String phoneNumber;// 联系方式
	private String postcode;// 邮编
	private String postalAddress;// 邮编地址
	private String email;// 邮箱
	private String manageState;// 经营状态
	private String employeeNum;// 从业人数
	private String operatorName;// 经营者名称
	private String totalAssets;// 资产总额
	private String totalEquity;// 所有者权益合计
	private String totalSales;// 销售总额(营业总收入)
	private String totalProfit;// 利润总额
	private String primeBusProfit;// 主营业务收入
	private String retainedProfit;// 净利润
	private String totalTax;// 纳税总额
	private String totalLiability;// 负债总额

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAnnualreportCreditCode() {
		return annualreportCreditCode;
	}

	public void setAnnualreportCreditCode(String annualreportCreditCode) {
		this.annualreportCreditCode = annualreportCreditCode;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManageState() {
		return manageState;
	}

	public void setManageState(String manageState) {
		this.manageState = manageState;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getTotalEquity() {
		return totalEquity;
	}

	public void setTotalEquity(String totalEquity) {
		this.totalEquity = totalEquity;
	}

	public String getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}

	public String getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}

	public String getPrimeBusProfit() {
		return primeBusProfit;
	}

	public void setPrimeBusProfit(String primeBusProfit) {
		this.primeBusProfit = primeBusProfit;
	}

	public String getRetainedProfit() {
		return retainedProfit;
	}

	public void setRetainedProfit(String retainedProfit) {
		this.retainedProfit = retainedProfit;
	}

	public String getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

	public String getTotalLiability() {
		return totalLiability;
	}

	public void setTotalLiability(String totalLiability) {
		this.totalLiability = totalLiability;
	}

}
