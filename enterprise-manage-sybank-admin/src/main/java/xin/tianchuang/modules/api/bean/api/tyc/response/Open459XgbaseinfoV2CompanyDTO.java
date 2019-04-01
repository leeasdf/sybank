package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open459XgbaseinfoV2CompanyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1962204540455989927L;
	private Long updatetime; // 更新时间
	private List<String> phoneList; // 电话列表
	private String portray; // 企业描述
	private Long fromTime; // 经营开始时间
	private Integer type; // 法人类型，1 人 2 公司
	private Integer entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会，7-不存在法人、注册资本、统一社会信用代码、经营状态
	private String emailList; // 邮箱列表
	private Long id; // 公司id
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
	private Long companyType;// 无用
	private String creditCode;// 统一社会信用代码
	private Long companyId;// 对应表id
	private String bondNum;// 股票号
	private String bondName;// 股票名称
	private String usedBondName;// 股票曾用名
	private String bondType;// 股票类型
	private String weibo;// 微博

	public Long getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public List<String> getPhoneList() {
		return phoneList;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsHightTech() {
		return isHightTech;
	}

	public void setIsHightTech(String isHightTech) {
		this.isHightTech = isHightTech;
	}

	public Long getPercentileScore() {
		return percentileScore;
	}

	public void setPercentileScore(Long percentileScore) {
		this.percentileScore = percentileScore;
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

	public Long getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Long companyType) {
		this.companyType = companyType;
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

}