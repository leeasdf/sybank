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
 * @date 2019-03-21 17:00:02
 */
@TableName("ENT_ABNORMAL_INFO")
public class EntAbnormalInfoEntity implements Serializable {
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
	private String abnormalCreateTime;
	/**
	 * 
	 */
	private String putDate;
	/**
	 * 
	 */
	private String removeDate;
	/**
	 * 
	 */
	private String removeDepartment;
	/**
	 * 
	 */
	private String removeReason;
	/**
	 * 
	 */
	private String putReason;
	/**
	 * 
	 */
	private String putDepartment;
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
	public void setAbnormalCreateTime(String abnormalCreateTime) {
		this.abnormalCreateTime = abnormalCreateTime;
	}
	/**
	 * 获取：
	 */
	public String getAbnormalCreateTime() {
		return abnormalCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}
	/**
	 * 获取：
	 */
	public String getPutDate() {
		return putDate;
	}
	/**
	 * 设置：
	 */
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}
	/**
	 * 获取：
	 */
	public String getRemoveDate() {
		return removeDate;
	}
	/**
	 * 设置：
	 */
	public void setRemoveDepartment(String removeDepartment) {
		this.removeDepartment = removeDepartment;
	}
	/**
	 * 获取：
	 */
	public String getRemoveDepartment() {
		return removeDepartment;
	}
	/**
	 * 设置：
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}
	/**
	 * 获取：
	 */
	public String getRemoveReason() {
		return removeReason;
	}
	/**
	 * 设置：
	 */
	public void setPutReason(String putReason) {
		this.putReason = putReason;
	}
	/**
	 * 获取：
	 */
	public String getPutReason() {
		return putReason;
	}
	/**
	 * 设置：
	 */
	public void setPutDepartment(String putDepartment) {
		this.putDepartment = putDepartment;
	}
	/**
	 * 获取：
	 */
	public String getPutDepartment() {
		return putDepartment;
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
