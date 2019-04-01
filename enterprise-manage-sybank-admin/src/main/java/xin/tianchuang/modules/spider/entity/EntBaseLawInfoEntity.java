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
@TableName("ENT_BASE_LAW_INFO")
public class EntBaseLawInfoEntity implements Serializable {
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
	private String summary;
	/**
	 * 
	 */
	private String phoneList;
	/**
	 * 
	 */
	private String permit;
	/**
	 * 
	 */
	private String organizationForm;
	/**
	 * 
	 */
	private Integer entityType;
	/**
	 * 
	 */
	private Long tycId;
	/**
	 * 
	 */
	private String phoneNumber;
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
	private String regLocation;
	/**
	 * 
	 */
	private String businessExpertise;
	/**
	 * 
	 */
	private String logo;
	/**
	 * 
	 */
	private String taxNumber;
	/**
	 * 
	 */
	private String headquartersBranch;
	/**
	 * 
	 */
	private String dateOfEstablishment;
	/**
	 * 
	 */
	private String legalPersonName;
	/**
	 * 
	 */
	private String creditRating;
	/**
	 * 
	 */
	private String websiteList;
	/**
	 * 
	 */
	private String practiceState;
	/**
	 * 
	 */
	private String authorities;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String approvalDate;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 
	 */
	private String dateOfIssue;
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
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：
	 */
	public void setPhoneList(String phoneList) {
		this.phoneList = phoneList;
	}
	/**
	 * 获取：
	 */
	public String getPhoneList() {
		return phoneList;
	}
	/**
	 * 设置：
	 */
	public void setPermit(String permit) {
		this.permit = permit;
	}
	/**
	 * 获取：
	 */
	public String getPermit() {
		return permit;
	}
	/**
	 * 设置：
	 */
	public void setOrganizationForm(String organizationForm) {
		this.organizationForm = organizationForm;
	}
	/**
	 * 获取：
	 */
	public String getOrganizationForm() {
		return organizationForm;
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
	public void setBusinessExpertise(String businessExpertise) {
		this.businessExpertise = businessExpertise;
	}
	/**
	 * 获取：
	 */
	public String getBusinessExpertise() {
		return businessExpertise;
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
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	/**
	 * 获取：
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	/**
	 * 设置：
	 */
	public void setHeadquartersBranch(String headquartersBranch) {
		this.headquartersBranch = headquartersBranch;
	}
	/**
	 * 获取：
	 */
	public String getHeadquartersBranch() {
		return headquartersBranch;
	}
	/**
	 * 设置：
	 */
	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}
	/**
	 * 获取：
	 */
	public String getDateOfEstablishment() {
		return dateOfEstablishment;
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
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：
	 */
	public void setWebsiteList(String websiteList) {
		this.websiteList = websiteList;
	}
	/**
	 * 获取：
	 */
	public String getWebsiteList() {
		return websiteList;
	}
	/**
	 * 设置：
	 */
	public void setPracticeState(String practiceState) {
		this.practiceState = practiceState;
	}
	/**
	 * 获取：
	 */
	public String getPracticeState() {
		return practiceState;
	}
	/**
	 * 设置：
	 */
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	/**
	 * 获取：
	 */
	public String getAuthorities() {
		return authorities;
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
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	/**
	 * 获取：
	 */
	public String getApprovalDate() {
		return approvalDate;
	}
	/**
	 * 设置：
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * 设置：
	 */
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	/**
	 * 获取：
	 */
	public String getDateOfIssue() {
		return dateOfIssue;
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
