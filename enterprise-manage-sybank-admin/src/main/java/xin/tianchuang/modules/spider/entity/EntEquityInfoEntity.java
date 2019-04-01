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
 * @date 2019-03-21 17:00:06
 */
@TableName("ENT_EQUITY_INFO")
public class EntEquityInfoEntity implements Serializable {
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
	private String equityAmount;
	/**
	 * 
	 */
	private String regNumber;
	/**
	 * 
	 */
	private String pledgee;
	/**
	 * 
	 */
	private Long putDate;
	/**
	 * 
	 */
	private String pledgorStr;
	/**
	 * 
	 */
	private Long regDate;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String pledgor;
	/**
	 * 
	 */
	private String certifNumberR;
	/**
	 * 
	 */
	private String certifNumber;
	/**
	 * 
	 */
	private String pledgeeStr;
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
	public void setEquityAmount(String equityAmount) {
		this.equityAmount = equityAmount;
	}
	/**
	 * 获取：
	 */
	public String getEquityAmount() {
		return equityAmount;
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
	public void setPledgee(String pledgee) {
		this.pledgee = pledgee;
	}
	/**
	 * 获取：
	 */
	public String getPledgee() {
		return pledgee;
	}
	/**
	 * 设置：
	 */
	public void setPutDate(Long putDate) {
		this.putDate = putDate;
	}
	/**
	 * 获取：
	 */
	public Long getPutDate() {
		return putDate;
	}
	/**
	 * 设置：
	 */
	public void setPledgorStr(String pledgorStr) {
		this.pledgorStr = pledgorStr;
	}
	/**
	 * 获取：
	 */
	public String getPledgorStr() {
		return pledgorStr;
	}
	/**
	 * 设置：
	 */
	public void setRegDate(Long regDate) {
		this.regDate = regDate;
	}
	/**
	 * 获取：
	 */
	public Long getRegDate() {
		return regDate;
	}
	/**
	 * 设置：
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：
	 */
	public void setPledgor(String pledgor) {
		this.pledgor = pledgor;
	}
	/**
	 * 获取：
	 */
	public String getPledgor() {
		return pledgor;
	}
	/**
	 * 设置：
	 */
	public void setCertifNumberR(String certifNumberR) {
		this.certifNumberR = certifNumberR;
	}
	/**
	 * 获取：
	 */
	public String getCertifNumberR() {
		return certifNumberR;
	}
	/**
	 * 设置：
	 */
	public void setCertifNumber(String certifNumber) {
		this.certifNumber = certifNumber;
	}
	/**
	 * 获取：
	 */
	public String getCertifNumber() {
		return certifNumber;
	}
	/**
	 * 设置：
	 */
	public void setPledgeeStr(String pledgeeStr) {
		this.pledgeeStr = pledgeeStr;
	}
	/**
	 * 获取：
	 */
	public String getPledgeeStr() {
		return pledgeeStr;
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
