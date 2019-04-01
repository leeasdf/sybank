package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2DTO extends OpenBaseinfoSetDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519051718606017144L;
	// entityType=1 公司
	@SerializedName("updatetime")
	private Long tycUpdateTime;// 更新时间 毫秒数
	private List<String> phoneList; // 电话列表
	private String portray; // 企业描述
	private Long fromTime; // 经营开始时间
	private Integer type; // 法人类型，1 人 2 公司
	private Integer entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会，7-不存在法人、注册资本、统一社会信用代码、经营状态
	private String emailList; // 邮箱列表
	@SerializedName("id")
	private Long tycId; // 公司id
	private String isHightTech; // 是否高新企业
	private Long percentileScore; // 企业评分(万分制)
	private Boolean haveReport; // 是否有年报
	private String companyOrgType; // 企业类型
	private String regLong; // 注册号
	private String phoneLong; // 电话
	private String regCapital; // 注册资金
	private String regInstitute; // 登记机关
	private String name; // 公司名称
	private String regLocation; // 注册地址
	private Long approvedTime; // 核准时间
	private String industry; // 行业
	private String tags; // 企业标签
	private String logo; // logo（不建议使用）
	private String businessScope; // 经营范围
	private String taxLong; // 纳税人识别号
	private String property4; // 弃用
	private String property3; // 英文名
	private String equityUrl; // 股权结构图
	private String orgLong; // 组织机构代码

	private List<Open459XgbaseinfoV2LegalInfoDTO> legalInfo; // 法人信息
	private Long estiblishTime;// 成立日期
	private String regStatus;// 企业状态
	private String baseInfo;// 企业介绍
	private String legalPersonName;// 法人
	private Long toTime;// 经营结束时间
	private Long legalPersonId;// 法人id
	private String sourceFlag;// 数据来源
	private Integer isClaimed;// 弃用
	private String actualCapital;// 实收注册资本（工商已不公示）
	private String websiteList;// 网址
	private Integer flag;// 0-显示 1-不显示(弃用)
	private String email;// 邮箱
	private String correctCompanyId;// 新公司名id
	private Long updateTimes;// 更新时间
	private String base;// 省份
	private Integer companyType;// 无用
	private String creditCode;// 统一社会信用代码
	private Long companyId;// 对应表id
	private String bondNum;// 股票号
	private String bondName;// 股票名称
	private String usedBondName;// 股票曾用名
	private String bondType;// 股票类型
	private String weibo;// 微博

	// entityType=2 香港公司
	// private String logo;// 公司logo
	private String remarksS;// 备注
	private String nameEn;// 英文名
	private String companyNum;// 公司编号
	// private Long estiblishTime;// 成立时间（毫秒数）
	// private String regStatus;// 公司现状
	// private Long entityType;// 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会，7-不存在法人、注册资本、统一社会信用代码、经营状态
	private String mortgageS;// 押记登记册
	// private Long toTime;// 结束时间
	// private Long id;// 公司id
	// private Boolean haveReport;// 是否有年报
	// private String companyOrgType;// 公司类型
	// private String name;// 公司名称
	// private String base;// 省份
	private String liquidationModeS;// 清盘模式
	private String importantItemsS;// 重要事项
	// private String weibo;// 微博
	// entityType=3 社会组织
	// private String logo; // 公司logo
	// private String regStatus; // 经营状态
	// private String legalPersonName; // 法人
	// private Long entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	// private Long id; // 公司id
	private String businessUnit; // 业务主管单位
	// private String websiteList; //
	private String registrationDate; // 成立时间
	// private String phoneLong; // 电话
	// private Boolean haveReport; // 是否有年报
	// private String regCapital; // 注册资本
	// private String name; // 机构名称
	// private String regInstitute; // 登记管理机关
	// private String regLocation; // 注册地址
	// private String creditCode; // 统一信用代码
	// 报文返回
	private String phoneNumber;

	private String types; // 类型
	// private String weibo; // 微博
	// entityType=4 律所
	private String summary;// 律所简介
	// private List<String> phoneList;// 电话列表
	private String permit;// 证书
	private String organizationForm;// 组织形式
	// private Long entityType;// 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	// private Long id;//
	// private String phoneLong;// 电话
	// private Boolean haveReport;// 是否有年报
	// private String regCapital;// 注册资本
	// private String name;// 律所名称
	// private String regLocation;// 地址
	private String businessExpertise;// 业务特长
	// private String logo;// logo
	// private String taxLong;// 税务登记号
	private String headquartersBranch;// 总所/分所
	private String dateOfEstablishment;// 成立日期
	// private String legalPersonName;//
	private String creditRating;// 信用等级
	// private String websiteList;//
	private String practiceState;// 执业状态、状态
	private String authorities;// 主管机关
	// private String email;// 邮箱
	private String approvalDate;// 核准时间
	// private String creditCode;//
	private String uuid;// uuid
	private String dateOfIssue;//
	// private String weibo;// 微博

	// entityType=5 事业单位
	private String scope; // 宗旨和业务范围
	private String regUnitNameSecond; // 第二举办单位
	private String regUnitName; // 举办单位名称
	// private Long entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	// private Integer type; //
	// private Long id; // id
	// private Boolean haveReport; // 是否有年报
	// private String regCapital; // 注册资本
	// private String name; // 单位名称
	private String regUnitNameThird; // 第三举办单位
	// private String regLocation; // 地址
	private String nameSecond; // 第二名称
	private String regUnit; // 举办单位
	private String expendSource; // 经费来源
	private String nameThird; // 第三名称
	// private String logo; // logo
	// private String usCreditCode; // 统一社会信用代码
	// private String regStatus; // 经营状态
	// private String legalPersonName; // 法人
	private String regUnitNameOther; // 其它举办单位
	// private Long legalPersonId; // 法人id
	private String address; // 地址
	private String holdUnit; // 登记管理机关
	private String validTime; // 有效期
	// private String base; // 省份
	private String oldCert; // 原证书号
	private String nameOther; // 其他名称
	// private String weibo; // 微博

	// entityType=6 基金会
	private String preferentialQualificationType; // 优惠资格类型
	private Long createTime; // 创建时间
	private String dataSource; // 数据来源
	private String nationalWorkerLong; // 负责人中国家工作人员数
	// private String scope; // 基金会范围
	private String department; // 登记部门
	private String historyName; // 历史名
	private String purpose; // 宗旨
	// private Integer type; //
	// private Long entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	private String contacts; // 对外联系人姓名
	// private Long id; // 基金会id
	// private Boolean haveReport; // 是否有年报
	// private String regCapital; // 注册资本
	private String orgCode; // 组织机构代码
	private String establishTime; // 成立时间
	// private String name; // 基金名称
	// private String regLocation; // 地址
	private String grade; // 评估等级
	private String specialFundLong; // 专项基金数
	// private String logo; // logo
	// private String businessScope; // 业务范围
	private String fax; // 传真
	private String website; // 网址
	// private Long estiblishTime; //
	private String provinceWorkerLong; // 负责人中担任过省部级工作人员数
	private String postcode; // 邮政编码
	// private String legalPersonName; // 法人
	private String contactDuty; // 联系人职务
	// private Long legalPersonId; // 法人id
	private String secretary; // 秘书长
	private String field; // 关注领域
	private String englishName; // 基金会英文名称
	// private String businessUnit; // 业务主管单位
	// private String address; // 地址
	// private String email; // 邮箱
	// private String creditCode; // 统一社会信用代码
	private String volunteerLong; // 志愿者数量
	private String employeeLong; // 全职员工数量
	private String telephone; // 电话

	// private String weibo; // 微博

	public List<String> getPhoneList() {
		return phoneList;
	}

	public Long getTycUpdateTime() {
		return tycUpdateTime;
	}

	public void setTycUpdateTime(Long tycUpdateTime) {
		this.tycUpdateTime = tycUpdateTime;
	}

	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}

	public String getPortray() {
		return portray;
	}

	public void setPortray(String portray) {
		this.portray = portray;
	}

	public Long getFromTime() {
		return fromTime;
	}

	public void setFromTime(Long fromTime) {
		this.fromTime = fromTime;
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

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public String getIsHightTech() {
		return isHightTech;
	}

	public void setIsHightTech(String isHightTech) {
		this.isHightTech = isHightTech;
	}

	public Boolean getHaveReport() {
		return haveReport;
	}

	public void setHaveReport(Boolean haveReport) {
		this.haveReport = haveReport;
	}

	public String getCompanyOrgType() {
		return companyOrgType;
	}

	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
	}

	public String getRegLong() {
		return regLong;
	}

	public void setRegLong(String regLong) {
		this.regLong = regLong;
	}

	public String getPhoneLong() {
		return phoneLong;
	}

	public void setPhoneLong(String phoneLong) {
		this.phoneLong = phoneLong;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegInstitute() {
		return regInstitute;
	}

	public void setRegInstitute(String regInstitute) {
		this.regInstitute = regInstitute;
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

	public Long getApprovedTime() {
		return approvedTime;
	}

	public void setApprovedTime(Long approvedTime) {
		this.approvedTime = approvedTime;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public String getTaxLong() {
		return taxLong;
	}

	public void setTaxLong(String taxLong) {
		this.taxLong = taxLong;
	}

	public String getProperty4() {
		return property4;
	}

	public void setProperty4(String property4) {
		this.property4 = property4;
	}

	public String getProperty3() {
		return property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}

	public String getEquityUrl() {
		return equityUrl;
	}

	public void setEquityUrl(String equityUrl) {
		this.equityUrl = equityUrl;
	}

	public String getOrgLong() {
		return orgLong;
	}

	public void setOrgLong(String orgLong) {
		this.orgLong = orgLong;
	}

	public List<Open459XgbaseinfoV2LegalInfoDTO> getLegalInfo() {
		return legalInfo;
	}

	public void setLegalInfo(List<Open459XgbaseinfoV2LegalInfoDTO> legalInfo) {
		this.legalInfo = legalInfo;
	}

	public Long getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public String getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Long getToTime() {
		return toTime;
	}

	public void setToTime(Long toTime) {
		this.toTime = toTime;
	}

	public Long getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Long legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public String getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getIsClaimed() {
		return isClaimed;
	}

	public void setIsClaimed(Integer isClaimed) {
		this.isClaimed = isClaimed;
	}

	public String getActualCapital() {
		return actualCapital;
	}

	public void setActualCapital(String actualCapital) {
		this.actualCapital = actualCapital;
	}

	public String getWebsiteList() {
		return websiteList;
	}

	public void setWebsiteList(String websiteList) {
		this.websiteList = websiteList;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCorrectCompanyId() {
		return correctCompanyId;
	}

	public void setCorrectCompanyId(String correctCompanyId) {
		this.correctCompanyId = correctCompanyId;
	}

	public Long getUpdateTimes() {
		return updateTimes;
	}

	public void setUpdateTimes(Long updateTimes) {
		this.updateTimes = updateTimes;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getBondNum() {
		return bondNum;
	}

	public void setBondNum(String bondNum) {
		this.bondNum = bondNum;
	}

	public String getBondName() {
		return bondName;
	}

	public void setBondName(String bondName) {
		this.bondName = bondName;
	}

	public String getUsedBondName() {
		return usedBondName;
	}

	public void setUsedBondName(String usedBondName) {
		this.usedBondName = usedBondName;
	}

	public String getBondType() {
		return bondType;
	}

	public void setBondType(String bondType) {
		this.bondType = bondType;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getRemarksS() {
		return remarksS;
	}

	public void setRemarksS(String remarksS) {
		this.remarksS = remarksS;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}

	public String getMortgageS() {
		return mortgageS;
	}

	public void setMortgageS(String mortgageS) {
		this.mortgageS = mortgageS;
	}

	public String getLiquidationModeS() {
		return liquidationModeS;
	}

	public void setLiquidationModeS(String liquidationModeS) {
		this.liquidationModeS = liquidationModeS;
	}

	public String getImportantItemsS() {
		return importantItemsS;
	}

	public void setImportantItemsS(String importantItemsS) {
		this.importantItemsS = importantItemsS;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getBusinessExpertise() {
		return businessExpertise;
	}

	public void setBusinessExpertise(String businessExpertise) {
		this.businessExpertise = businessExpertise;
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

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
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

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRegUnitNameSecond() {
		return regUnitNameSecond;
	}

	public void setRegUnitNameSecond(String regUnitNameSecond) {
		this.regUnitNameSecond = regUnitNameSecond;
	}

	public String getRegUnitName() {
		return regUnitName;
	}

	public void setRegUnitName(String regUnitName) {
		this.regUnitName = regUnitName;
	}

	public String getRegUnitNameThird() {
		return regUnitNameThird;
	}

	public void setRegUnitNameThird(String regUnitNameThird) {
		this.regUnitNameThird = regUnitNameThird;
	}

	public String getNameSecond() {
		return nameSecond;
	}

	public void setNameSecond(String nameSecond) {
		this.nameSecond = nameSecond;
	}

	public String getRegUnit() {
		return regUnit;
	}

	public void setRegUnit(String regUnit) {
		this.regUnit = regUnit;
	}

	public String getExpendSource() {
		return expendSource;
	}

	public void setExpendSource(String expendSource) {
		this.expendSource = expendSource;
	}

	public String getNameThird() {
		return nameThird;
	}

	public void setNameThird(String nameThird) {
		this.nameThird = nameThird;
	}

	public String getRegUnitNameOther() {
		return regUnitNameOther;
	}

	public void setRegUnitNameOther(String regUnitNameOther) {
		this.regUnitNameOther = regUnitNameOther;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHoldUnit() {
		return holdUnit;
	}

	public void setHoldUnit(String holdUnit) {
		this.holdUnit = holdUnit;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	public String getOldCert() {
		return oldCert;
	}

	public void setOldCert(String oldCert) {
		this.oldCert = oldCert;
	}

	public String getNameOther() {
		return nameOther;
	}

	public void setNameOther(String nameOther) {
		this.nameOther = nameOther;
	}

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

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
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

	public String getContactDuty() {
		return contactDuty;
	}

	public void setContactDuty(String contactDuty) {
		this.contactDuty = contactDuty;
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

	public Long getPercentileScore() {
		return percentileScore;
	}

	public void setPercentileScore(Long percentileScore) {
		this.percentileScore = percentileScore;
	}

	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

}