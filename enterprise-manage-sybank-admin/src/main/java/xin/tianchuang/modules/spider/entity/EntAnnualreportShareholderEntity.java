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
 * @date 2019-03-21 17:00:10
 */
@TableName("ENT_ANNUALREPORT_SHAREHOLDER")
public class EntAnnualreportShareholderEntity implements Serializable {
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
	private String investorName;
	/**
	 * 
	 */
	private String subscribeAmount;
	/**
	 * 
	 */
	private String subscribeTime;
	/**
	 * 
	 */
	private String subscribeType;
	/**
	 * 
	 */
	private String paidAmount;
	/**
	 * 
	 */
	private String paidTime;
	/**
	 * 
	 */
	private String paidType;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String clickId;
	/**
	 * 
	 */
	private String reportYear;
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
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	/**
	 * 获取：
	 */
	public String getInvestorName() {
		return investorName;
	}
	/**
	 * 设置：
	 */
	public void setSubscribeAmount(String subscribeAmount) {
		this.subscribeAmount = subscribeAmount;
	}
	/**
	 * 获取：
	 */
	public String getSubscribeAmount() {
		return subscribeAmount;
	}
	/**
	 * 设置：
	 */
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	/**
	 * 获取：
	 */
	public String getSubscribeTime() {
		return subscribeTime;
	}
	/**
	 * 设置：
	 */
	public void setSubscribeType(String subscribeType) {
		this.subscribeType = subscribeType;
	}
	/**
	 * 获取：
	 */
	public String getSubscribeType() {
		return subscribeType;
	}
	/**
	 * 设置：
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	/**
	 * 获取：
	 */
	public String getPaidAmount() {
		return paidAmount;
	}
	/**
	 * 设置：
	 */
	public void setPaidTime(String paidTime) {
		this.paidTime = paidTime;
	}
	/**
	 * 获取：
	 */
	public String getPaidTime() {
		return paidTime;
	}
	/**
	 * 设置：
	 */
	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}
	/**
	 * 获取：
	 */
	public String getPaidType() {
		return paidType;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setClickId(String clickId) {
		this.clickId = clickId;
	}
	/**
	 * 获取：
	 */
	public String getClickId() {
		return clickId;
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
