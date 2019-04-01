package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open362BaseinfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4593837030314768437L;

	private Long updatetime; // 更新时间[毫秒数]
	private String staffNumRange; // 人员规模[varchar(200)]
	private Long fromTime; // 经营开始时间[毫秒数]
	private Integer type; // 法人类型，1 人 2 公司[]
	private Integer categoryScore; // 行业分数[万分制]
	private String bondName; // 股票名[varchar(20)]
	private Integer id; // 企业id[]
	private Integer isMicroEnt; // 是否是小微企业 0不是 1是[]
	private String usedBondName; // 股票曾用名[varchar(20)]
	private String regint; // 注册号[varchar(31)]
	private Integer percentileScore; // 企业评分[万分制]
	private String regCapital; // 注册资本[varchar(50)]
	private String name; // 企业名[varchar(255)]
	private String regInstitute; // 登记机关[varchar(255)]
	private String regLocation; // 注册地址[varchar(255)]
	private String industry; // 行业[varchar(255)]
	private Long approvedTime; // 核准时间[毫秒数]
	private Integer socialStaffNum; // 参保人数[]
	private String tags; // 企业标签[varchar(255)]
	private String logo; // logo（不建议使用）[varchar(150)]
	private String taxint; // 纳税人识别号[varchar(255)]
	private String businessScope; // 经营范围[varchar(4091)]
	private String property3; // 英文名[varchar(255)]
	private String alias; // 简称[varchar(255)]
	private String orgint; // 组织机构代码[varchar(31)]
	private String regStatus; // 企业状态[varchar(31)]
	private Long estiblishTime; // 成立日期[毫秒数]
	private String bondType; // 股票类型[varchar(31)]
	private String legalPersonName; // 法人[varchar(120)]
	private Long toTime; // 经营结束时间[毫秒数]
	private Integer legalPersonId; // 法人id[]
	private String sourceFlag; // 数据来源标志[varchar(30)]
	private String actualCapital; // 实收注册资金[varchar(50)]
	private Integer flag; // 0-显示 1-不显示(弃用)[]
	private String correctCompanyId; // 新公司名id[]
	private String companyOrgType; // 企业类型[varchar(127)]
	private String base; // 省份简称[varchar(31)]
	private Long updateTimes; // 更新时间[毫秒数]
	private Integer companyType; // 无用[]
	private String creditCode; // 统一社会信用代码[varchar(255)]
	private Integer companyId; // 对应表id[]
	private String historyNames; // 曾用名[varchar(255)]
	private String bondNum; // 股票号[varchar(20)]
	private String regCapitalCurrency; // 注册资本币种 人民币 美元 欧元 等[varchar(10)]
	private String actualCapitalCurrency; // 实收注册资本币种 人民币 美元 欧元 等[varchar(10)]
	private String orgApprovedInstitute; // 核准机关（无用）[]
	private String nameSuffix; // 无用[]
	private String property5; // 无用[]
	private String listCode; // 无用[]
	private String ownershipStake; // 无用[]
	private Long revokeDate; // 吊销日期[毫秒数]
	private String revokeReason; // 吊销原因[varchar(500)]
	private Long cancelDate; // 注销日期[毫秒数]
	private String cancelReason; // 注销原因[varchar(500)]
	private String String;

	public Long getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public String getStaffNumRange() {
		return staffNumRange;
	}

	public void setStaffNumRange(String staffNumRange) {
		this.staffNumRange = staffNumRange;
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

	public Integer getCategoryScore() {
		return categoryScore;
	}

	public void setCategoryScore(Integer categoryScore) {
		this.categoryScore = categoryScore;
	}

	public String getBondName() {
		return bondName;
	}

	public void setBondName(String bondName) {
		this.bondName = bondName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsMicroEnt() {
		return isMicroEnt;
	}

	public void setIsMicroEnt(Integer isMicroEnt) {
		this.isMicroEnt = isMicroEnt;
	}

	public String getUsedBondName() {
		return usedBondName;
	}

	public void setUsedBondName(String usedBondName) {
		this.usedBondName = usedBondName;
	}

	public String getRegint() {
		return regint;
	}

	public void setRegint(String regint) {
		this.regint = regint;
	}

	public Integer getPercentileScore() {
		return percentileScore;
	}

	public void setPercentileScore(Integer percentileScore) {
		this.percentileScore = percentileScore;
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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Long getApprovedTime() {
		return approvedTime;
	}

	public void setApprovedTime(Long approvedTime) {
		this.approvedTime = approvedTime;
	}

	public Integer getSocialStaffNum() {
		return socialStaffNum;
	}

	public void setSocialStaffNum(Integer socialStaffNum) {
		this.socialStaffNum = socialStaffNum;
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

	public String getTaxint() {
		return taxint;
	}

	public void setTaxint(String taxint) {
		this.taxint = taxint;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getProperty3() {
		return property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getOrgint() {
		return orgint;
	}

	public void setOrgint(String orgint) {
		this.orgint = orgint;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public Long getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getBondType() {
		return bondType;
	}

	public void setBondType(String bondType) {
		this.bondType = bondType;
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

	public Integer getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Integer legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public String getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getActualCapital() {
		return actualCapital;
	}

	public void setActualCapital(String actualCapital) {
		this.actualCapital = actualCapital;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCorrectCompanyId() {
		return correctCompanyId;
	}

	public void setCorrectCompanyId(String correctCompanyId) {
		this.correctCompanyId = correctCompanyId;
	}

	public String getCompanyOrgType() {
		return companyOrgType;
	}

	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Long getUpdateTimes() {
		return updateTimes;
	}

	public void setUpdateTimes(Long updateTimes) {
		this.updateTimes = updateTimes;
	}

	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getHistoryNames() {
		return historyNames;
	}

	public void setHistoryNames(String historyNames) {
		this.historyNames = historyNames;
	}

	public String getBondNum() {
		return bondNum;
	}

	public void setBondNum(String bondNum) {
		this.bondNum = bondNum;
	}

	public String getRegCapitalCurrency() {
		return regCapitalCurrency;
	}

	public void setRegCapitalCurrency(String regCapitalCurrency) {
		this.regCapitalCurrency = regCapitalCurrency;
	}

	public String getActualCapitalCurrency() {
		return actualCapitalCurrency;
	}

	public void setActualCapitalCurrency(String actualCapitalCurrency) {
		this.actualCapitalCurrency = actualCapitalCurrency;
	}

	public String getOrgApprovedInstitute() {
		return orgApprovedInstitute;
	}

	public void setOrgApprovedInstitute(String orgApprovedInstitute) {
		this.orgApprovedInstitute = orgApprovedInstitute;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getProperty5() {
		return property5;
	}

	public void setProperty5(String property5) {
		this.property5 = property5;
	}

	public String getListCode() {
		return listCode;
	}

	public void setListCode(String listCode) {
		this.listCode = listCode;
	}

	public String getOwnershipStake() {
		return ownershipStake;
	}

	public void setOwnershipStake(String ownershipStake) {
		this.ownershipStake = ownershipStake;
	}

	public Long getRevokeDate() {
		return revokeDate;
	}

	public void setRevokeDate(Long revokeDate) {
		this.revokeDate = revokeDate;
	}

	public String getRevokeReason() {
		return revokeReason;
	}

	public void setRevokeReason(String revokeReason) {
		this.revokeReason = revokeReason;
	}

	public Long getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Long cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getString() {
		return String;
	}

	public void setString(String string) {
		String = string;
	}

}
