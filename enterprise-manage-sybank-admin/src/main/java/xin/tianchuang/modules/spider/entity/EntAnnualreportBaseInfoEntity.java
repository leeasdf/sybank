package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:11
 */
@TableName("ENT_ANNUALREPORT_BASE_INFO")
public class EntAnnualreportBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer entId;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String creditCode;
	/**
	 * 
	 */
	private String belongYear;
	/**
	 * 
	 */
	private String reportYear;
	/**
	 * 
	 */
	private String companyName;
	/**
	 * 
	 */
	private String annualreportCreditCode;
	/**
	 * 
	 */
	private String regNumber;
	/**
	 * 
	 */
	private String phoneNumber;
	/**
	 * 
	 */
	private String postcode;
	/**
	 * 
	 */
	private String postalAddress;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String manageState;
	/**
	 * 
	 */
	private String employeeNum;
	/**
	 * 
	 */
	private String operatorName;
	/**
	 * 
	 */
	private String totalAssets;
	/**
	 * 
	 */
	private String totalEquity;
	/**
	 * 
	 */
	private String totalSales;
	/**
	 * 
	 */
	private String totalProfit;
	/**
	 * 
	 */
	private String primeBusProfit;
	/**
	 * 
	 */
	private String retainedProfit;
	/**
	 * 
	 */
	private String totalTax;
	/**
	 * 
	 */
	private String totalLiability;
	/**
	 * 
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 
	 */
	@TableField(value = "data_status", fill = FieldFill.INSERT)
	private Integer dataStatus;
	/**
	 * 
	 */
	@Version
	private Integer version;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setEntId(Integer entId) {
		this.entId = entId;
	}
	/**
	 * 获取：
	 */
	public Integer getEntId() {
		return entId;
	}
	/**
	 * 设置：
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：
	 */
	public void setBelongYear(String belongYear) {
		this.belongYear = belongYear;
	}
	/**
	 * 获取：
	 */
	public String getBelongYear() {
		return belongYear;
	}
	/**
	 * 设置：
	 */
	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}
	/**
	 * 获取：
	 */
	public String getReportYear() {
		return reportYear;
	}
	/**
	 * 设置：
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：
	 */
	public void setAnnualreportCreditCode(String annualreportCreditCode) {
		this.annualreportCreditCode = annualreportCreditCode;
	}
	/**
	 * 获取：
	 */
	public String getAnnualreportCreditCode() {
		return annualreportCreditCode;
	}
	/**
	 * 设置：
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	/**
	 * 获取：
	 */
	public String getRegNumber() {
		return regNumber;
	}
	/**
	 * 设置：
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * 获取：
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * 设置：
	 */
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	/**
	 * 获取：
	 */
	public String getPostalAddress() {
		return postalAddress;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setManageState(String manageState) {
		this.manageState = manageState;
	}
	/**
	 * 获取：
	 */
	public String getManageState() {
		return manageState;
	}
	/**
	 * 设置：
	 */
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	/**
	 * 获取：
	 */
	public String getEmployeeNum() {
		return employeeNum;
	}
	/**
	 * 设置：
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 * 获取：
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 设置：
	 */
	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}
	/**
	 * 获取：
	 */
	public String getTotalAssets() {
		return totalAssets;
	}
	/**
	 * 设置：
	 */
	public void setTotalEquity(String totalEquity) {
		this.totalEquity = totalEquity;
	}
	/**
	 * 获取：
	 */
	public String getTotalEquity() {
		return totalEquity;
	}
	/**
	 * 设置：
	 */
	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}
	/**
	 * 获取：
	 */
	public String getTotalSales() {
		return totalSales;
	}
	/**
	 * 设置：
	 */
	public void setTotalProfit(String totalProfit) {
		this.totalProfit = totalProfit;
	}
	/**
	 * 获取：
	 */
	public String getTotalProfit() {
		return totalProfit;
	}
	/**
	 * 设置：
	 */
	public void setPrimeBusProfit(String primeBusProfit) {
		this.primeBusProfit = primeBusProfit;
	}
	/**
	 * 获取：
	 */
	public String getPrimeBusProfit() {
		return primeBusProfit;
	}
	/**
	 * 设置：
	 */
	public void setRetainedProfit(String retainedProfit) {
		this.retainedProfit = retainedProfit;
	}
	/**
	 * 获取：
	 */
	public String getRetainedProfit() {
		return retainedProfit;
	}
	/**
	 * 设置：
	 */
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}
	/**
	 * 获取：
	 */
	public String getTotalTax() {
		return totalTax;
	}
	/**
	 * 设置：
	 */
	public void setTotalLiability(String totalLiability) {
		this.totalLiability = totalLiability;
	}
	/**
	 * 获取：
	 */
	public String getTotalLiability() {
		return totalLiability;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}
