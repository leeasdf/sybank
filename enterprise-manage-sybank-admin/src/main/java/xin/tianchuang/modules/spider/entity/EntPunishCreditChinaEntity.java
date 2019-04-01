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
 * @date 2019-03-21 17:00:04
 */
@TableName("ENT_PUNISH_CREDIT_CHINA")
public class EntPunishCreditChinaEntity implements Serializable {
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
	private String result;
	/**
	 * 
	 */
	private String areaName;
	/**
	 * 
	 */
	private String punishNumber;
	/**
	 * 
	 */
	private String reason;
	/**
	 * 
	 */
	private String typeSecond;
	/**
	 * 
	 */
	private String evidence;
	/**
	 * 
	 */
	private String punishStatus;
	/**
	 * 
	 */
	private String decisionDate;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String departmentName;
	/**
	 * 
	 */
	private String punishName;
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
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * 获取：
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 设置：
	 */
	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}
	/**
	 * 获取：
	 */
	public String getPunishNumber() {
		return punishNumber;
	}
	/**
	 * 设置：
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：
	 */
	public void setTypeSecond(String typeSecond) {
		this.typeSecond = typeSecond;
	}
	/**
	 * 获取：
	 */
	public String getTypeSecond() {
		return typeSecond;
	}
	/**
	 * 设置：
	 */
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	/**
	 * 获取：
	 */
	public String getEvidence() {
		return evidence;
	}
	/**
	 * 设置：
	 */
	public void setPunishStatus(String punishStatus) {
		this.punishStatus = punishStatus;
	}
	/**
	 * 获取：
	 */
	public String getPunishStatus() {
		return punishStatus;
	}
	/**
	 * 设置：
	 */
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}
	/**
	 * 获取：
	 */
	public String getDecisionDate() {
		return decisionDate;
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
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * 获取：
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * 设置：
	 */
	public void setPunishName(String punishName) {
		this.punishName = punishName;
	}
	/**
	 * 获取：
	 */
	public String getPunishName() {
		return punishName;
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
