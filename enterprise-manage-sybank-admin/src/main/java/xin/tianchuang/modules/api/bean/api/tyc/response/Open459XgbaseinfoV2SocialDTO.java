package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2SocialDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8713224038670269129L;
	private String logo; // 公司logo
	private String regStatus; // 经营状态
	private String legalPersonName; // 法人
	private Integer entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	@SerializedName("id")
	private Long id; // 公司id
	private String businessUnit; // 业务主管单位
	private String websiteList; //
	private String registrationDate; // 成立时间
	private String phoneLong; // 电话
	private Boolean haveReport; // 是否有年报
	private String regCapital; // 注册资本
	private String name; // 机构名称
	private String regInstitute; // 登记管理机关
	private String regLocation; // 注册地址
	private String creditCode; // 统一信用代码
	// 报文返回
	private String phoneNumber;
	private String types; // 类型
	private String weibo; // 微博

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getWebsiteList() {
		return websiteList;
	}

	public void setWebsiteList(String websiteList) {
		this.websiteList = websiteList;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getRegInstitute() {
		return regInstitute;
	}

	public void setRegInstitute(String regInstitute) {
		this.regInstitute = regInstitute;
	}

	public String getRegLocation() {
		return regLocation;
	}

	public void setRegLocation(String regLocation) {
		this.regLocation = regLocation;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}