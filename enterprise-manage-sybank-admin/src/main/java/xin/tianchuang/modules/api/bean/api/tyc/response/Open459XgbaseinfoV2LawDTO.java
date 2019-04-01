package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2LawDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5458327003895687556L;
	private String summary;// 律所简介
	private List<String> phoneList;// 电话列表
	private String permit;// 证书
	private String organizationForm;// 组织形式
	private Integer entityType;// 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	@SerializedName("id")
	private Long tycId;//
	private String phoneLong;// 电话
	private Boolean haveReport;// 是否有年报
	private String regCapital;// 注册资本
	private String name;// 律所名称
	private String regLocation;// 地址
	private String businessExpertise;// 业务特长
	private String logo;// logo
	private String taxLong;// 税务登记号
	private String headquartersBranch;// 总所/分所
	private String dateOfEstablishment;// 成立日期
	private String legalPersonName;//
	private String creditRating;// 信用等级
	private String websiteList;//
	private String practiceState;// 执业状态、状态
	private String authorities;// 主管机关
	private String email;// 邮箱
	private String approvalDate;// 核准时间
	private String creditCode;//
	private String uuid;// uuid
	private String dateOfIssue;//
	private String weibo;// 微博

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getOrganizationForm() {
		return organizationForm;
	}

	public void setOrganizationForm(String organizationForm) {
		this.organizationForm = organizationForm;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public String getPhoneLong() {
		return phoneLong;
	}

	public void setPhoneLong(String phoneLong) {
		this.phoneLong = phoneLong;
	}

	public Boolean getHaveReport() {
		return haveReport;
	}

	public void setHaveReport(Boolean haveReport) {
		this.haveReport = haveReport;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegLocation() {
		return regLocation;
	}

	public void setRegLocation(String regLocation) {
		this.regLocation = regLocation;
	}

	public String getBusinessExpertise() {
		return businessExpertise;
	}

	public void setBusinessExpertise(String businessExpertise) {
		this.businessExpertise = businessExpertise;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTaxLong() {
		return taxLong;
	}

	public void setTaxLong(String taxLong) {
		this.taxLong = taxLong;
	}

	public String getHeadquartersBranch() {
		return headquartersBranch;
	}

	public void setHeadquartersBranch(String headquartersBranch) {
		this.headquartersBranch = headquartersBranch;
	}

	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	public String getWebsiteList() {
		return websiteList;
	}

	public void setWebsiteList(String websiteList) {
		this.websiteList = websiteList;
	}

	public String getPracticeState() {
		return practiceState;
	}

	public void setPracticeState(String practiceState) {
		this.practiceState = practiceState;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}