package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2FoundationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2123433939735632176L;

	private String preferentialQualificationType; // 优惠资格类型
	private Long createTime; // 创建时间
	private String dataSource; // 数据来源
	private String nationalWorkerLong; // 负责人中国家工作人员数
	private String scope; // 基金会范围
	private String department; // 登记部门
	private String historyName; // 历史名
	private String purpose; // 宗旨
	private Integer type; //
	private Integer entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	private String contacts; // 对外联系人姓名
	@SerializedName("id")
	private Long tycId; // 基金会id
	private Boolean haveReport; // 是否有年报
	private String regCapital; // 注册资本
	private String orgCode; // 组织机构代码
	private String establishTime; // 成立时间
	private String name; // 基金名称
	private String regLocation; // 地址
	private String grade; // 评估等级
	private String specialFundLong; // 专项基金数
	private String logo; // logo
	private String businessScope; // 业务范围
	private String fax; // 传真
	private String website; // 网址
	private Long estiblishTime; //
	private String provinceWorkerLong; // 负责人中担任过省部级工作人员数
	private String postcode; // 邮政编码
	private String legalPersonName; // 法人
	private String contactDuty; // 联系人职务
	private Long legalPersonId; // 法人id
	private String secretary; // 秘书长
	private String field; // 关注领域
	private String englishName; // 基金会英文名称
	private String businessUnit; // 业务主管单位
	private String address; // 地址
	private String email; // 邮箱
	private String creditCode; // 统一社会信用代码
	private String volunteerLong; // 志愿者数量
	private String employeeLong; // 全职员工数量
	private String telephone; // 电话
	private String weibo; // 微博

	public String getPreferentialQualificationType() {
		return preferentialQualificationType;
	}

	public void setPreferentialQualificationType(String preferentialQualificationType) {
		this.preferentialQualificationType = preferentialQualificationType;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getNationalWorkerLong() {
		return nationalWorkerLong;
	}

	public void setNationalWorkerLong(String nationalWorkerLong) {
		this.nationalWorkerLong = nationalWorkerLong;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHistoryName() {
		return historyName;
	}

	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getEstablishTime() {
		return establishTime;
	}

	public void setEstablishTime(String establishTime) {
		this.establishTime = establishTime;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSpecialFundLong() {
		return specialFundLong;
	}

	public void setSpecialFundLong(String specialFundLong) {
		this.specialFundLong = specialFundLong;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Long getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getProvinceWorkerLong() {
		return provinceWorkerLong;
	}

	public void setProvinceWorkerLong(String provinceWorkerLong) {
		this.provinceWorkerLong = provinceWorkerLong;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getContactDuty() {
		return contactDuty;
	}

	public void setContactDuty(String contactDuty) {
		this.contactDuty = contactDuty;
	}

	public Long getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Long legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public String getSecretary() {
		return secretary;
	}

	public void setSecretary(String secretary) {
		this.secretary = secretary;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getVolunteerLong() {
		return volunteerLong;
	}

	public void setVolunteerLong(String volunteerLong) {
		this.volunteerLong = volunteerLong;
	}

	public String getEmployeeLong() {
		return employeeLong;
	}

	public void setEmployeeLong(String employeeLong) {
		this.employeeLong = employeeLong;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}