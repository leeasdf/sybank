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
@TableName("ENT_ANNUALREPORT_OUTBOUND_INVESTMENT")
public class EntAnnualreportOutboundInvestmentEntity implements Serializable {
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
	private String outcompanyName;
	/**
	 * 
	 */
	private String regNum;
	/**
	 * 
	 */
	private String outcompanyCreditCode;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String clickId;
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
	public void setOutcompanyName(String outcompanyName) {
		this.outcompanyName = outcompanyName;
	}
	/**
	 * 获取：
	 */
	public String getOutcompanyName() {
		return outcompanyName;
	}
	/**
	 * 设置：
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	/**
	 * 获取：
	 */
	public String getRegNum() {
		return regNum;
	}
	/**
	 * 设置：
	 */
	public void setOutcompanyCreditCode(String outcompanyCreditCode) {
		this.outcompanyCreditCode = outcompanyCreditCode;
	}
	/**
	 * 获取：
	 */
	public String getOutcompanyCreditCode() {
		return outcompanyCreditCode;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
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
