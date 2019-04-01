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
@TableName("ENT_BASE_FOUNDATION_INFO")
public class EntBaseFoundationInfoEntity implements Serializable {
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
	private Long tycId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String preferentialQualificationType;
	/**
	 * 
	 */
	private Long tycCreateTime;
	/**
	 * 
	 */
	private String dataSource;
	/**
	 * 
	 */
	private String nationalWorkerNumber;
	/**
	 * 
	 */
	private String scope;
	/**
	 * 
	 */
	private String department;
	/**
	 * 
	 */
	private String historyName;
	/**
	 * 
	 */
	private String purpose;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer entityType;
	/**
	 * 
	 */
	private String contacts;
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
	private String orgCode;
	/**
	 * 
	 */
	private String establishTime;
	/**
	 * 
	 */
	private String regLocation;
	/**
	 * 
	 */
	private String grade;
	/**
	 * 
	 */
	private String specialFundNumber;
	/**
	 * 
	 */
	private String logo;
	/**
	 * 
	 */
	private String businessScope;
	/**
	 * 
	 */
	private String fax;
	/**
	 * 
	 */
	private String website;
	/**
	 * 
	 */
	private Long estiblishTime;
	/**
	 * 
	 */
	private String provinceWorkerNumber;
	/**
	 * 
	 */
	private String postcode;
	/**
	 * 
	 */
	private String legalPersonName;
	/**
	 * 
	 */
	private String contactDuty;
	/**
	 * 
	 */
	private Long legalPersonId;
	/**
	 * 
	 */
	private String secretary;
	/**
	 * 
	 */
	private String field;
	/**
	 * 
	 */
	private String englishName;
	/**
	 * 
	 */
	private String businessUnit;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String volunteerNumber;
	/**
	 * 
	 */
	private String employeeNumber;
	/**
	 * 
	 */
	private String telephone;
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
	public void setPreferentialQualificationType(String preferentialQualificationType) {
		this.preferentialQualificationType = preferentialQualificationType;
	}
	/**
	 * 获取：
	 */
	public String getPreferentialQualificationType() {
		return preferentialQualificationType;
	}
	/**
	 * 设置：
	 */
	public void setTycCreateTime(Long tycCreateTime) {
		this.tycCreateTime = tycCreateTime;
	}
	/**
	 * 获取：
	 */
	public Long getTycCreateTime() {
		return tycCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取：
	 */
	public String getDataSource() {
		return dataSource;
	}
	/**
	 * 设置：
	 */
	public void setNationalWorkerNumber(String nationalWorkerNumber) {
		this.nationalWorkerNumber = nationalWorkerNumber;
	}
	/**
	 * 获取：
	 */
	public String getNationalWorkerNumber() {
		return nationalWorkerNumber;
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
	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}
	/**
	 * 获取：
	 */
	public String getHistoryName() {
		return historyName;
	}
	/**
	 * 设置：
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	/**
	 * 获取：
	 */
	public String getPurpose() {
		return purpose;
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
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	/**
	 * 获取：
	 */
	public String getContacts() {
		return contacts;
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
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * 获取：
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * 设置：
	 */
	public void setEstablishTime(String establishTime) {
		this.establishTime = establishTime;
	}
	/**
	 * 获取：
	 */
	public String getEstablishTime() {
		return establishTime;
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
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 设置：
	 */
	public void setSpecialFundNumber(String specialFundNumber) {
		this.specialFundNumber = specialFundNumber;
	}
	/**
	 * 获取：
	 */
	public String getSpecialFundNumber() {
		return specialFundNumber;
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
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * 设置：
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * 获取：
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * 设置：
	 */
	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}
	/**
	 * 获取：
	 */
	public Long getEstiblishTime() {
		return estiblishTime;
	}
	/**
	 * 设置：
	 */
	public void setProvinceWorkerNumber(String provinceWorkerNumber) {
		this.provinceWorkerNumber = provinceWorkerNumber;
	}
	/**
	 * 获取：
	 */
	public String getProvinceWorkerNumber() {
		return provinceWorkerNumber;
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
	public void setContactDuty(String contactDuty) {
		this.contactDuty = contactDuty;
	}
	/**
	 * 获取：
	 */
	public String getContactDuty() {
		return contactDuty;
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
	public void setSecretary(String secretary) {
		this.secretary = secretary;
	}
	/**
	 * 获取：
	 */
	public String getSecretary() {
		return secretary;
	}
	/**
	 * 设置：
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * 获取：
	 */
	public String getField() {
		return field;
	}
	/**
	 * 设置：
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * 获取：
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 设置：
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * 获取：
	 */
	public String getBusinessUnit() {
		return businessUnit;
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
	public void setVolunteerNumber(String volunteerNumber) {
		this.volunteerNumber = volunteerNumber;
	}
	/**
	 * 获取：
	 */
	public String getVolunteerNumber() {
		return volunteerNumber;
	}
	/**
	 * 设置：
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * 获取：
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * 设置：
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * 获取：
	 */
	public String getTelephone() {
		return telephone;
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
