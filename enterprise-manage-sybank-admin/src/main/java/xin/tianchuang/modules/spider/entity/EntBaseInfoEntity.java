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
@TableName("ENT_BASE_INFO")
public class EntBaseInfoEntity implements Serializable {
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
	private Long legalPersonId;
	/**
	 * 
	 */
	private String legalPersonName;
	/**
	 * 
	 */
	private String orgNumber;
	/**
	 * 
	 */
	private String taxNumber;
	/**
	 * 
	 */
	private String regNumber;
	/**
	 * 
	 */
	private String regCapital;
	/**
	 * 
	 */
	private String regCapitalCurrency;
	/**
	 * 
	 */
	private String actualCapital;
	/**
	 * 
	 */
	private String actualCapitalCurrency;
	/**
	 * 
	 */
	private String companyOrgType;
	/**
	 * 
	 */
	private String regInstitute;
	/**
	 * 
	 */
	private String regLocation;
	/**
	 * 
	 */
	private String regStatus;
	/**
	 * 
	 */
	private Long estiblishTime;
	/**
	 * 
	 */
	private Long fromTime;
	/**
	 * 
	 */
	private Long toTime;
	/**
	 * 
	 */
	private String industry;
	/**
	 * 
	 */
	private String alias;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private Long approvedTime;
	/**
	 * 
	 */
	private Long tycUpdateTime;
	/**
	 * 
	 */
	private Integer socialStaffNum;
	/**
	 * 
	 */
	private String staffNumRange;
	/**
	 * 
	 */
	private String businessScope;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer categoryScore;
	/**
	 * 
	 */
	private Integer percentileScore;
	/**
	 * 
	 */
	private String bondName;
	/**
	 * 
	 */
	private String usedBondName;
	/**
	 * 
	 */
	private String bondType;
	/**
	 * 
	 */
	private String bondNum;
	/**
	 * 
	 */
	private Integer listedFlag;
	/**
	 * 
	 */
	private String tags;
	/**
	 * 
	 */
	private String logo;
	/**
	 * 
	 */
	private String sourceFlag;
	/**
	 * 
	 */
	private Integer flag;
	/**
	 * 
	 */
	private String correctCompanyId;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String websiteList;
	/**
	 * 
	 */
	private String phoneNumber;
	/**
	 * 
	 */
	private Long updateTimes;
	/**
	 * 
	 */
	private Integer companyType;
	/**
	 * 
	 */
	private Long companyId;
	/**
	 * 
	 */
	private String historyNames;
	/**
	 * 
	 */
	private Integer isMicroEnt;
	/**
	 * 
	 */
	private String orgApprovedInstitute;
	/**
	 * 
	 */
	private String nameSuffix;
	/**
	 * 
	 */
	private String property3;
	/**
	 * 
	 */
	private String property4;
	/**
	 * 
	 */
	private String property5;
	/**
	 * 
	 */
	private String listCode;
	/**
	 * 
	 */
	private String ownershipStake;
	/**
	 * 
	 */
	private Long revokeDate;
	/**
	 * 
	 */
	private String revokeReason;
	/**
	 * 
	 */
	private Long cancelDate;
	/**
	 * 
	 */
	private String cancelReason;
	/**
	 * 
	 */
	private Integer isClaimed;
	/**
	 * 
	 */
	private String phoneList;
	/**
	 * 
	 */
	private String portray;
	/**
	 * 
	 */
	private String emailList;
	/**
	 * 
	 */
	private String isHightTech;
	/**
	 * 
	 */
	private String haveReport;
	/**
	 * 
	 */
	private String regLong;
	/**
	 * 
	 */
	private String phoneLong;
	/**
	 * 
	 */
	private String taxLong;
	/**
	 * 
	 */
	private String equityUrl;
	/**
	 * 
	 */
	private String orgLong;
	/**
	 * 
	 */
	private String baseInfo;
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
	public void setOrgNumber(String orgNumber) {
		this.orgNumber = orgNumber;
	}
	/**
	 * 获取：
	 */
	public String getOrgNumber() {
		return orgNumber;
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
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	/**
	 * 获取：
	 */
	public String getRegNumber() {
		return regNumber;
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
	public void setRegCapitalCurrency(String regCapitalCurrency) {
		this.regCapitalCurrency = regCapitalCurrency;
	}
	/**
	 * 获取：
	 */
	public String getRegCapitalCurrency() {
		return regCapitalCurrency;
	}
	/**
	 * 设置：
	 */
	public void setActualCapital(String actualCapital) {
		this.actualCapital = actualCapital;
	}
	/**
	 * 获取：
	 */
	public String getActualCapital() {
		return actualCapital;
	}
	/**
	 * 设置：
	 */
	public void setActualCapitalCurrency(String actualCapitalCurrency) {
		this.actualCapitalCurrency = actualCapitalCurrency;
	}
	/**
	 * 获取：
	 */
	public String getActualCapitalCurrency() {
		return actualCapitalCurrency;
	}
	/**
	 * 设置：
	 */
	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
	}
	/**
	 * 获取：
	 */
	public String getCompanyOrgType() {
		return companyOrgType;
	}
	/**
	 * 设置：
	 */
	public void setRegInstitute(String regInstitute) {
		this.regInstitute = regInstitute;
	}
	/**
	 * 获取：
	 */
	public String getRegInstitute() {
		return regInstitute;
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
	public void setFromTime(Long fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * 获取：
	 */
	public Long getFromTime() {
		return fromTime;
	}
	/**
	 * 设置：
	 */
	public void setToTime(Long toTime) {
		this.toTime = toTime;
	}
	/**
	 * 获取：
	 */
	public Long getToTime() {
		return toTime;
	}
	/**
	 * 设置：
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * 获取：
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * 设置：
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：
	 */
	public String getAlias() {
		return alias;
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
	public void setApprovedTime(Long approvedTime) {
		this.approvedTime = approvedTime;
	}
	/**
	 * 获取：
	 */
	public Long getApprovedTime() {
		return approvedTime;
	}
	/**
	 * 设置：
	 */
	public void setTycUpdateTime(Long tycUpdateTime) {
		this.tycUpdateTime = tycUpdateTime;
	}
	/**
	 * 获取：
	 */
	public Long getTycUpdateTime() {
		return tycUpdateTime;
	}
	/**
	 * 设置：
	 */
	public void setSocialStaffNum(Integer socialStaffNum) {
		this.socialStaffNum = socialStaffNum;
	}
	/**
	 * 获取：
	 */
	public Integer getSocialStaffNum() {
		return socialStaffNum;
	}
	/**
	 * 设置：
	 */
	public void setStaffNumRange(String staffNumRange) {
		this.staffNumRange = staffNumRange;
	}
	/**
	 * 获取：
	 */
	public String getStaffNumRange() {
		return staffNumRange;
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
	public void setCategoryScore(Integer categoryScore) {
		this.categoryScore = categoryScore;
	}
	/**
	 * 获取：
	 */
	public Integer getCategoryScore() {
		return categoryScore;
	}
	/**
	 * 设置：
	 */
	public void setPercentileScore(Integer percentileScore) {
		this.percentileScore = percentileScore;
	}
	/**
	 * 获取：
	 */
	public Integer getPercentileScore() {
		return percentileScore;
	}
	/**
	 * 设置：
	 */
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}
	/**
	 * 获取：
	 */
	public String getBondName() {
		return bondName;
	}
	/**
	 * 设置：
	 */
	public void setUsedBondName(String usedBondName) {
		this.usedBondName = usedBondName;
	}
	/**
	 * 获取：
	 */
	public String getUsedBondName() {
		return usedBondName;
	}
	/**
	 * 设置：
	 */
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}
	/**
	 * 获取：
	 */
	public String getBondType() {
		return bondType;
	}
	/**
	 * 设置：
	 */
	public void setBondNum(String bondNum) {
		this.bondNum = bondNum;
	}
	/**
	 * 获取：
	 */
	public String getBondNum() {
		return bondNum;
	}
	/**
	 * 设置：
	 */
	public void setListedFlag(Integer listedFlag) {
		this.listedFlag = listedFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getListedFlag() {
		return listedFlag;
	}
	/**
	 * 设置：
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：
	 */
	public String getTags() {
		return tags;
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
	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	/**
	 * 获取：
	 */
	public String getSourceFlag() {
		return sourceFlag;
	}
	/**
	 * 设置：
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * 设置：
	 */
	public void setCorrectCompanyId(String correctCompanyId) {
		this.correctCompanyId = correctCompanyId;
	}
	/**
	 * 获取：
	 */
	public String getCorrectCompanyId() {
		return correctCompanyId;
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
	public void setUpdateTimes(Long updateTimes) {
		this.updateTimes = updateTimes;
	}
	/**
	 * 获取：
	 */
	public Long getUpdateTimes() {
		return updateTimes;
	}
	/**
	 * 设置：
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyType() {
		return companyType;
	}
	/**
	 * 设置：
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：
	 */
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：
	 */
	public void setHistoryNames(String historyNames) {
		this.historyNames = historyNames;
	}
	/**
	 * 获取：
	 */
	public String getHistoryNames() {
		return historyNames;
	}
	/**
	 * 设置：
	 */
	public void setIsMicroEnt(Integer isMicroEnt) {
		this.isMicroEnt = isMicroEnt;
	}
	/**
	 * 获取：
	 */
	public Integer getIsMicroEnt() {
		return isMicroEnt;
	}
	/**
	 * 设置：
	 */
	public void setOrgApprovedInstitute(String orgApprovedInstitute) {
		this.orgApprovedInstitute = orgApprovedInstitute;
	}
	/**
	 * 获取：
	 */
	public String getOrgApprovedInstitute() {
		return orgApprovedInstitute;
	}
	/**
	 * 设置：
	 */
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}
	/**
	 * 获取：
	 */
	public String getNameSuffix() {
		return nameSuffix;
	}
	/**
	 * 设置：
	 */
	public void setProperty3(String property3) {
		this.property3 = property3;
	}
	/**
	 * 获取：
	 */
	public String getProperty3() {
		return property3;
	}
	/**
	 * 设置：
	 */
	public void setProperty4(String property4) {
		this.property4 = property4;
	}
	/**
	 * 获取：
	 */
	public String getProperty4() {
		return property4;
	}
	/**
	 * 设置：
	 */
	public void setProperty5(String property5) {
		this.property5 = property5;
	}
	/**
	 * 获取：
	 */
	public String getProperty5() {
		return property5;
	}
	/**
	 * 设置：
	 */
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	/**
	 * 获取：
	 */
	public String getListCode() {
		return listCode;
	}
	/**
	 * 设置：
	 */
	public void setOwnershipStake(String ownershipStake) {
		this.ownershipStake = ownershipStake;
	}
	/**
	 * 获取：
	 */
	public String getOwnershipStake() {
		return ownershipStake;
	}
	/**
	 * 设置：
	 */
	public void setRevokeDate(Long revokeDate) {
		this.revokeDate = revokeDate;
	}
	/**
	 * 获取：
	 */
	public Long getRevokeDate() {
		return revokeDate;
	}
	/**
	 * 设置：
	 */
	public void setRevokeReason(String revokeReason) {
		this.revokeReason = revokeReason;
	}
	/**
	 * 获取：
	 */
	public String getRevokeReason() {
		return revokeReason;
	}
	/**
	 * 设置：
	 */
	public void setCancelDate(Long cancelDate) {
		this.cancelDate = cancelDate;
	}
	/**
	 * 获取：
	 */
	public Long getCancelDate() {
		return cancelDate;
	}
	/**
	 * 设置：
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	/**
	 * 获取：
	 */
	public String getCancelReason() {
		return cancelReason;
	}
	/**
	 * 设置：
	 */
	public void setIsClaimed(Integer isClaimed) {
		this.isClaimed = isClaimed;
	}
	/**
	 * 获取：
	 */
	public Integer getIsClaimed() {
		return isClaimed;
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
	public void setPortray(String portray) {
		this.portray = portray;
	}
	/**
	 * 获取：
	 */
	public String getPortray() {
		return portray;
	}
	/**
	 * 设置：
	 */
	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}
	/**
	 * 获取：
	 */
	public String getEmailList() {
		return emailList;
	}
	/**
	 * 设置：
	 */
	public void setIsHightTech(String isHightTech) {
		this.isHightTech = isHightTech;
	}
	/**
	 * 获取：
	 */
	public String getIsHightTech() {
		return isHightTech;
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
	public void setRegLong(String regLong) {
		this.regLong = regLong;
	}
	/**
	 * 获取：
	 */
	public String getRegLong() {
		return regLong;
	}
	/**
	 * 设置：
	 */
	public void setPhoneLong(String phoneLong) {
		this.phoneLong = phoneLong;
	}
	/**
	 * 获取：
	 */
	public String getPhoneLong() {
		return phoneLong;
	}
	/**
	 * 设置：
	 */
	public void setTaxLong(String taxLong) {
		this.taxLong = taxLong;
	}
	/**
	 * 获取：
	 */
	public String getTaxLong() {
		return taxLong;
	}
	/**
	 * 设置：
	 */
	public void setEquityUrl(String equityUrl) {
		this.equityUrl = equityUrl;
	}
	/**
	 * 获取：
	 */
	public String getEquityUrl() {
		return equityUrl;
	}
	/**
	 * 设置：
	 */
	public void setOrgLong(String orgLong) {
		this.orgLong = orgLong;
	}
	/**
	 * 获取：
	 */
	public String getOrgLong() {
		return orgLong;
	}
	/**
	 * 设置：
	 */
	public void setBaseInfo(String baseInfo) {
		this.baseInfo = baseInfo;
	}
	/**
	 * 获取：
	 */
	public String getBaseInfo() {
		return baseInfo;
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
