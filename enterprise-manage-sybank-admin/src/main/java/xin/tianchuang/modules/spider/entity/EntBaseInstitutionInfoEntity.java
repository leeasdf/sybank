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
 * @date 2019-03-21 17:00:09
 */
@TableName("ENT_BASE_INSTITUTION_INFO")
public class EntBaseInstitutionInfoEntity implements Serializable {
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
	private String scope;
	/**
	 * 
	 */
	private String regUnitNameSecond;
	/**
	 * 
	 */
	private String regUnitName;
	/**
	 * 
	 */
	private Integer entityType;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Long tycId;
	/**
	 * 
	 */
	private String haveReport;
	/**
	 * 
	 */
	private String regCapital;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String regUnitNameThird;
	/**
	 * 
	 */
	private String regLocation;
	/**
	 * 
	 */
	private String nameSecond;
	/**
	 * 
	 */
	private String regUnit;
	/**
	 * 
	 */
	private String expendSource;
	/**
	 * 
	 */
	private String nameThird;
	/**
	 * 
	 */
	private String logo;
	/**
	 * 
	 */
	private String usCreditCode;
	/**
	 * 
	 */
	private String regStatus;
	/**
	 * 
	 */
	private String legalPersonName;
	/**
	 * 
	 */
	private String regUnitNameOther;
	/**
	 * 
	 */
	private Long legalPersonId;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String holdUnit;
	/**
	 * 
	 */
	private String validTime;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private String oldCert;
	/**
	 * 
	 */
	private String nameOther;
	/**
	 * 
	 */
	private String weibo;
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
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取：
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * 设置：
	 */
	public void setRegUnitNameSecond(String regUnitNameSecond) {
		this.regUnitNameSecond = regUnitNameSecond;
	}
	/**
	 * 获取：
	 */
	public String getRegUnitNameSecond() {
		return regUnitNameSecond;
	}
	/**
	 * 设置：
	 */
	public void setRegUnitName(String regUnitName) {
		this.regUnitName = regUnitName;
	}
	/**
	 * 获取：
	 */
	public String getRegUnitName() {
		return regUnitName;
	}
	/**
	 * 设置：
	 */
	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}
	/**
	 * 获取：
	 */
	public Integer getEntityType() {
		return entityType;
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
	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}
	/**
	 * 获取：
	 */
	public Long getTycId() {
		return tycId;
	}
	/**
	 * 设置：
	 */
	public void setHaveReport(String haveReport) {
		this.haveReport = haveReport;
	}
	/**
	 * 获取：
	 */
	public String getHaveReport() {
		return haveReport;
	}
	/**
	 * 设置：
	 */
	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}
	/**
	 * 获取：
	 */
	public String getRegCapital() {
		return regCapital;
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
	public void setRegUnitNameThird(String regUnitNameThird) {
		this.regUnitNameThird = regUnitNameThird;
	}
	/**
	 * 获取：
	 */
	public String getRegUnitNameThird() {
		return regUnitNameThird;
	}
	/**
	 * 设置：
	 */
	public void setRegLocation(String regLocation) {
		this.regLocation = regLocation;
	}
	/**
	 * 获取：
	 */
	public String getRegLocation() {
		return regLocation;
	}
	/**
	 * 设置：
	 */
	public void setNameSecond(String nameSecond) {
		this.nameSecond = nameSecond;
	}
	/**
	 * 获取：
	 */
	public String getNameSecond() {
		return nameSecond;
	}
	/**
	 * 设置：
	 */
	public void setRegUnit(String regUnit) {
		this.regUnit = regUnit;
	}
	/**
	 * 获取：
	 */
	public String getRegUnit() {
		return regUnit;
	}
	/**
	 * 设置：
	 */
	public void setExpendSource(String expendSource) {
		this.expendSource = expendSource;
	}
	/**
	 * 获取：
	 */
	public String getExpendSource() {
		return expendSource;
	}
	/**
	 * 设置：
	 */
	public void setNameThird(String nameThird) {
		this.nameThird = nameThird;
	}
	/**
	 * 获取：
	 */
	public String getNameThird() {
		return nameThird;
	}
	/**
	 * 设置：
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：
	 */
	public void setUsCreditCode(String usCreditCode) {
		this.usCreditCode = usCreditCode;
	}
	/**
	 * 获取：
	 */
	public String getUsCreditCode() {
		return usCreditCode;
	}
	/**
	 * 设置：
	 */
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	/**
	 * 获取：
	 */
	public String getRegStatus() {
		return regStatus;
	}
	/**
	 * 设置：
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
	/**
	 * 获取：
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
	/**
	 * 设置：
	 */
	public void setRegUnitNameOther(String regUnitNameOther) {
		this.regUnitNameOther = regUnitNameOther;
	}
	/**
	 * 获取：
	 */
	public String getRegUnitNameOther() {
		return regUnitNameOther;
	}
	/**
	 * 设置：
	 */
	public void setLegalPersonId(Long legalPersonId) {
		this.legalPersonId = legalPersonId;
	}
	/**
	 * 获取：
	 */
	public Long getLegalPersonId() {
		return legalPersonId;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setHoldUnit(String holdUnit) {
		this.holdUnit = holdUnit;
	}
	/**
	 * 获取：
	 */
	public String getHoldUnit() {
		return holdUnit;
	}
	/**
	 * 设置：
	 */
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	/**
	 * 获取：
	 */
	public String getValidTime() {
		return validTime;
	}
	/**
	 * 设置：
	 */
	public void setBase(String base) {
		this.base = base;
	}
	/**
	 * 获取：
	 */
	public String getBase() {
		return base;
	}
	/**
	 * 设置：
	 */
	public void setOldCert(String oldCert) {
		this.oldCert = oldCert;
	}
	/**
	 * 获取：
	 */
	public String getOldCert() {
		return oldCert;
	}
	/**
	 * 设置：
	 */
	public void setNameOther(String nameOther) {
		this.nameOther = nameOther;
	}
	/**
	 * 获取：
	 */
	public String getNameOther() {
		return nameOther;
	}
	/**
	 * 设置：
	 */
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	/**
	 * 获取：
	 */
	public String getWeibo() {
		return weibo;
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
