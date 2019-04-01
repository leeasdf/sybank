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
 * @date 2019-03-21 17:00:05
 */
@TableName("ENT_LIST_INFO")
public class EntListInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
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
	private String creditCode;
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
	private Integer entityType;
	/**
	 * 
	 */
	private Long estiblishTime;
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
	private String regLocation;
	/**
	 * 
	 */
	private String regStatus;
	/**
	 * 
	 */
	private String regInstitute;
	/**
	 * 
	 */
	private String companyOrgType;
	/**
	 * 
	 */
	private Integer type;
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
	private String logo;
	/**
	 * 
	 */
	private String weibo;
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
	private String businessScope;
	/**
	 * 
	 */
	private String haveReport;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private String phoneList;
	/**
	 * 
	 */
	private String websiteList;
	/**
	 * 
	 */
	private String sourceFlag;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String area;
	/**
	 * 
	 */
	private String industry;
	/**
	 * 
	 */
	private Integer socialStaffNum;
	/**
	 * 
	 */
	private Date collectDate;
	/**
	 * 
	 */
	private Integer baseinfoFlag;
	/**
	 * 
	 */
	private Integer holderFlag;
	/**
	 * 
	 */
	private Integer inverstFlag;
	/**
	 * 
	 */
	private Integer changeinfoFlag;
	/**
	 * 
	 */
	private Integer branchFlag;
	/**
	 * 
	 */
	private Integer lawSuitFlag;
	/**
	 * 
	 */
	private Integer courtAnnouncementFlag;
	/**
	 * 
	 */
	private Integer dishonestFlag;
	/**
	 * 
	 */
	private Integer zhixinginfoFlag;
	/**
	 * 
	 */
	private Integer ktannouncementFlag;
	/**
	 * 
	 */
	private Integer abnormalFlag;
	/**
	 * 
	 */
	private Integer creditChinaFlag;
	/**
	 * 
	 */
	private Integer equityInfoFlag;
	/**
	 * 
	 */
	private Integer mortgageInfoFlag;
	/**
	 * 
	 */
	private Integer ownTaxFlag;
	/**
	 * 
	 */
	private Integer bidsFlag;
	/**
	 * 
	 */
	private Integer employmentsFlag;
	/**
	 * 
	 */
	private Integer tmFlag;
	/**
	 * 
	 */
	private Integer patentsFlag;
	/**
	 * 
	 */
	private Integer copyRegWorksFlag;
	/**
	 * 
	 */
	private Integer copyRegFlag;
	/**
	 * 
	 */
	private Integer icpFlag;
	/**
	 * 
	 */
	private Integer newsFlag;
	/**
	 * 
	 */
	private Integer oneKeyCFlag;
	/**
	 * 
	 */
	private Integer annualreportFlag;
	/**
	 * 
	 */
	private Integer companyInfoFlag;
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
	 * 
	 */
	private Integer listedFlag;
	/**
	 * 
	 */
	private String phoneNumber;

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
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：
	 */
	public String getArea() {
		return area;
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
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	/**
	 * 获取：
	 */
	public Date getCollectDate() {
		return collectDate;
	}
	/**
	 * 设置：
	 */
	public void setBaseinfoFlag(Integer baseinfoFlag) {
		this.baseinfoFlag = baseinfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getBaseinfoFlag() {
		return baseinfoFlag;
	}
	/**
	 * 设置：
	 */
	public void setHolderFlag(Integer holderFlag) {
		this.holderFlag = holderFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getHolderFlag() {
		return holderFlag;
	}
	/**
	 * 设置：
	 */
	public void setInverstFlag(Integer inverstFlag) {
		this.inverstFlag = inverstFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getInverstFlag() {
		return inverstFlag;
	}
	/**
	 * 设置：
	 */
	public void setChangeinfoFlag(Integer changeinfoFlag) {
		this.changeinfoFlag = changeinfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getChangeinfoFlag() {
		return changeinfoFlag;
	}
	/**
	 * 设置：
	 */
	public void setBranchFlag(Integer branchFlag) {
		this.branchFlag = branchFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getBranchFlag() {
		return branchFlag;
	}
	/**
	 * 设置：
	 */
	public void setLawSuitFlag(Integer lawSuitFlag) {
		this.lawSuitFlag = lawSuitFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getLawSuitFlag() {
		return lawSuitFlag;
	}
	/**
	 * 设置：
	 */
	public void setCourtAnnouncementFlag(Integer courtAnnouncementFlag) {
		this.courtAnnouncementFlag = courtAnnouncementFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCourtAnnouncementFlag() {
		return courtAnnouncementFlag;
	}
	/**
	 * 设置：
	 */
	public void setDishonestFlag(Integer dishonestFlag) {
		this.dishonestFlag = dishonestFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getDishonestFlag() {
		return dishonestFlag;
	}
	/**
	 * 设置：
	 */
	public void setZhixinginfoFlag(Integer zhixinginfoFlag) {
		this.zhixinginfoFlag = zhixinginfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getZhixinginfoFlag() {
		return zhixinginfoFlag;
	}
	/**
	 * 设置：
	 */
	public void setKtannouncementFlag(Integer ktannouncementFlag) {
		this.ktannouncementFlag = ktannouncementFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getKtannouncementFlag() {
		return ktannouncementFlag;
	}
	/**
	 * 设置：
	 */
	public void setAbnormalFlag(Integer abnormalFlag) {
		this.abnormalFlag = abnormalFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getAbnormalFlag() {
		return abnormalFlag;
	}
	/**
	 * 设置：
	 */
	public void setCreditChinaFlag(Integer creditChinaFlag) {
		this.creditChinaFlag = creditChinaFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCreditChinaFlag() {
		return creditChinaFlag;
	}
	/**
	 * 设置：
	 */
	public void setEquityInfoFlag(Integer equityInfoFlag) {
		this.equityInfoFlag = equityInfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getEquityInfoFlag() {
		return equityInfoFlag;
	}
	/**
	 * 设置：
	 */
	public void setMortgageInfoFlag(Integer mortgageInfoFlag) {
		this.mortgageInfoFlag = mortgageInfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getMortgageInfoFlag() {
		return mortgageInfoFlag;
	}
	/**
	 * 设置：
	 */
	public void setOwnTaxFlag(Integer ownTaxFlag) {
		this.ownTaxFlag = ownTaxFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getOwnTaxFlag() {
		return ownTaxFlag;
	}
	/**
	 * 设置：
	 */
	public void setBidsFlag(Integer bidsFlag) {
		this.bidsFlag = bidsFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getBidsFlag() {
		return bidsFlag;
	}
	/**
	 * 设置：
	 */
	public void setEmploymentsFlag(Integer employmentsFlag) {
		this.employmentsFlag = employmentsFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getEmploymentsFlag() {
		return employmentsFlag;
	}
	/**
	 * 设置：
	 */
	public void setTmFlag(Integer tmFlag) {
		this.tmFlag = tmFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getTmFlag() {
		return tmFlag;
	}
	/**
	 * 设置：
	 */
	public void setPatentsFlag(Integer patentsFlag) {
		this.patentsFlag = patentsFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getPatentsFlag() {
		return patentsFlag;
	}
	/**
	 * 设置：
	 */
	public void setCopyRegWorksFlag(Integer copyRegWorksFlag) {
		this.copyRegWorksFlag = copyRegWorksFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCopyRegWorksFlag() {
		return copyRegWorksFlag;
	}
	/**
	 * 设置：
	 */
	public void setCopyRegFlag(Integer copyRegFlag) {
		this.copyRegFlag = copyRegFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCopyRegFlag() {
		return copyRegFlag;
	}
	/**
	 * 设置：
	 */
	public void setIcpFlag(Integer icpFlag) {
		this.icpFlag = icpFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getIcpFlag() {
		return icpFlag;
	}
	/**
	 * 设置：
	 */
	public void setNewsFlag(Integer newsFlag) {
		this.newsFlag = newsFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getNewsFlag() {
		return newsFlag;
	}
	/**
	 * 设置：
	 */
	public void setOneKeyCFlag(Integer oneKeyCFlag) {
		this.oneKeyCFlag = oneKeyCFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getOneKeyCFlag() {
		return oneKeyCFlag;
	}
	/**
	 * 设置：
	 */
	public void setAnnualreportFlag(Integer annualreportFlag) {
		this.annualreportFlag = annualreportFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getAnnualreportFlag() {
		return annualreportFlag;
	}
	/**
	 * 设置：
	 */
	public void setCompanyInfoFlag(Integer companyInfoFlag) {
		this.companyInfoFlag = companyInfoFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyInfoFlag() {
		return companyInfoFlag;
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
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
