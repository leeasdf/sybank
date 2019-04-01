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
 * @date 2019-03-21 17:00:03
 */
@TableName("ENT_REPORT_CHANGE_RECORD")
public class EntReportChangeRecordEntity implements Serializable {
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
	private Date collectDate;
	/**
	 * 
	 */
	private Integer changeType;
	/**
	 * 
	 */
	private Integer reportChangeType;
	/**
	 * 
	 */
	private String reportChangeDesc;
	/**
	 * 
	 */
	private Integer warningLevel;
	/**
	 * 
	 */
	private String remark;
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
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	/**
	 * 获取：
	 */
	public Date getCollectDate() {
		return collectDate;
	}
	/**
	 * 设置：
	 */
	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}
	/**
	 * 获取：
	 */
	public Integer getChangeType() {
		return changeType;
	}
	/**
	 * 设置：
	 */
	public void setReportChangeType(Integer reportChangeType) {
		this.reportChangeType = reportChangeType;
	}
	/**
	 * 获取：
	 */
	public Integer getReportChangeType() {
		return reportChangeType;
	}
	/**
	 * 设置：
	 */
	public void setReportChangeDesc(String reportChangeDesc) {
		this.reportChangeDesc = reportChangeDesc;
	}
	/**
	 * 获取：
	 */
	public String getReportChangeDesc() {
		return reportChangeDesc;
	}
	/**
	 * 设置：
	 */
	public void setWarningLevel(Integer warningLevel) {
		this.warningLevel = warningLevel;
	}
	/**
	 * 获取：
	 */
	public Integer getWarningLevel() {
		return warningLevel;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
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
