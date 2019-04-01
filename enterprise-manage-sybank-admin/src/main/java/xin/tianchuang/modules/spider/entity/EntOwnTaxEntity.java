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
@TableName("ENT_OWN_TAX")
public class EntOwnTaxEntity implements Serializable {
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
	private String regType;
	/**
	 * 
	 */
	private String personIdNumber;
	/**
	 * 
	 */
	private String legalpersonName;
	/**
	 * 
	 */
	private String location;
	/**
	 * 
	 */
	private String ownTaxAmount;
	/**
	 * 
	 */
	private String department;
	/**
	 * 
	 */
	private String taxIdNumber;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String taxCategory;
	/**
	 * 
	 */
	private String taxpayerType;
	/**
	 * 
	 */
	private String newOwnTaxBalance;
	/**
	 * 
	 */
	private String ownTaxBalance;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String personIdName;
	/**
	 * 
	 */
	private String publishDate;
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
	public void setRegType(String regType) {
		this.regType = regType;
	}
	/**
	 * 获取：
	 */
	public String getRegType() {
		return regType;
	}
	/**
	 * 设置：
	 */
	public void setPersonIdNumber(String personIdNumber) {
		this.personIdNumber = personIdNumber;
	}
	/**
	 * 获取：
	 */
	public String getPersonIdNumber() {
		return personIdNumber;
	}
	/**
	 * 设置：
	 */
	public void setLegalpersonName(String legalpersonName) {
		this.legalpersonName = legalpersonName;
	}
	/**
	 * 获取：
	 */
	public String getLegalpersonName() {
		return legalpersonName;
	}
	/**
	 * 设置：
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：
	 */
	public void setOwnTaxAmount(String ownTaxAmount) {
		this.ownTaxAmount = ownTaxAmount;
	}
	/**
	 * 获取：
	 */
	public String getOwnTaxAmount() {
		return ownTaxAmount;
	}
	/**
	 * 设置：
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 获取：
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * 设置：
	 */
	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}
	/**
	 * 获取：
	 */
	public String getTaxIdNumber() {
		return taxIdNumber;
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
	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}
	/**
	 * 获取：
	 */
	public String getTaxCategory() {
		return taxCategory;
	}
	/**
	 * 设置：
	 */
	public void setTaxpayerType(String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}
	/**
	 * 获取：
	 */
	public String getTaxpayerType() {
		return taxpayerType;
	}
	/**
	 * 设置：
	 */
	public void setNewOwnTaxBalance(String newOwnTaxBalance) {
		this.newOwnTaxBalance = newOwnTaxBalance;
	}
	/**
	 * 获取：
	 */
	public String getNewOwnTaxBalance() {
		return newOwnTaxBalance;
	}
	/**
	 * 设置：
	 */
	public void setOwnTaxBalance(String ownTaxBalance) {
		this.ownTaxBalance = ownTaxBalance;
	}
	/**
	 * 获取：
	 */
	public String getOwnTaxBalance() {
		return ownTaxBalance;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPersonIdName(String personIdName) {
		this.personIdName = personIdName;
	}
	/**
	 * 获取：
	 */
	public String getPersonIdName() {
		return personIdName;
	}
	/**
	 * 设置：
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：
	 */
	public String getPublishDate() {
		return publishDate;
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
