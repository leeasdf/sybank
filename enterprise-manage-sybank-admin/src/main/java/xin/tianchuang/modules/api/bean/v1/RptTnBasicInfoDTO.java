package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * 工商基本信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */

public class RptTnBasicInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7036538588260787183L;
	/**
	 * 企业主键
	 */
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 工商注册号
	 */
	private String regNo;
	/**
	 * 企业类别
	 */
	private String entType;
	/**
	 * 行业
	 */
	private String industryPhyName;
	/**
	 * 纳税人识别号
	 */
	private String ideNum;
	/**
	 * 统一社会信用代码
	 */
	@JsonAlias("creCode")
	private String creditCode;
	/**
	 * 英文名称
	 */
	private String engName;
	/**
	 * 组织机构代码
	 */
	private String orgCode;
	/**
	 * 登记机关
	 */
	private String regAuthority;
	/**
	 * 营业期限
	 */
	private String opePeriod;
	/**
	 * 核准日期
	 */
	private String appDate;
	/**
	 * 注册地址
	 */
	private String regAddress;
	/**
	 * 经营范围
	 */
	private String busScope;
	/**
	 * 公司名称
	 */
	private String cmpName;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 法人
	 */
	private String legalPerson;
	/**
	 * 注册资本
	 */
	private String regCap;
	/**
	 * 企业状态
	 */
	private String status;

	/**
	 * 公司类型 1-普通公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金 相关问题
	 */
//	private String companyType;
//
//	/***
//	 * 更新时间 linux时间戳
//	 */
//	private Long updateTimes;
//	
//	/**
//	 * 数据来源
//	 */
//	private String base;
//	/**
//	 * 纠正企业id
//	 */
//	private String correctCompanyId;
	

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置：工商注册号
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	/**
	 * 获取：工商注册号
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * 设置：企业类别
	 */
	public void setEntType(String entType) {
		this.entType = entType;
	}

	/**
	 * 获取：企业类别
	 */
	public String getEntType() {
		return entType;
	}

	/**
	 * 设置：行业
	 */
	public void setIndustryPhyName(String industryPhyName) {
		this.industryPhyName = industryPhyName;
	}

	/**
	 * 获取：行业
	 */
	public String getIndustryPhyName() {
		return industryPhyName;
	}

	/**
	 * 设置：纳税人识别号
	 */
	public void setIdeNum(String ideNum) {
		this.ideNum = ideNum;
	}

	/**
	 * 获取：纳税人识别号
	 */
	public String getIdeNum() {
		return ideNum;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	/**
	 * 设置：英文名称
	 */
	public void setEngName(String engName) {
		this.engName = engName;
	}

	/**
	 * 获取：英文名称
	 */
	public String getEngName() {
		return engName;
	}

	/**
	 * 设置：组织机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * 获取：组织机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * 设置：登记机关
	 */
	public void setRegAuthority(String regAuthority) {
		this.regAuthority = regAuthority;
	}

	/**
	 * 获取：登记机关
	 */
	public String getRegAuthority() {
		return regAuthority;
	}

	/**
	 * 设置：营业期限
	 */
	public void setOpePeriod(String opePeriod) {
		this.opePeriod = opePeriod;
	}

	/**
	 * 获取：营业期限
	 */
	public String getOpePeriod() {
		return opePeriod;
	}

	/**
	 * 设置：核准日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：核准日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：注册地址
	 */
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	/**
	 * 获取：注册地址
	 */
	public String getRegAddress() {
		return regAddress;
	}

	/**
	 * 设置：经营范围
	 */
	public void setBusScope(String busScope) {
		this.busScope = busScope;
	}

	/**
	 * 获取：经营范围
	 */
	public String getBusScope() {
		return busScope;
	}

	/**
	 * 设置：公司名称
	 */
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	/**
	 * 获取：公司名称
	 */
	public String getCmpName() {
		return cmpName;
	}

	/**
	 * 设置：注册时间
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	/**
	 * 获取：注册时间
	 */
	public String getRegTime() {
		return regTime;
	}

	/**
	 * 设置：法人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * 获取：法人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * 设置：注册资本
	 */
	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	/**
	 * 获取：注册资本
	 */
	public String getRegCap() {
		return regCap;
	}

	/**
	 * 设置：企业状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：企业状态
	 */
	public String getStatus() {
		return status;
	}
}
