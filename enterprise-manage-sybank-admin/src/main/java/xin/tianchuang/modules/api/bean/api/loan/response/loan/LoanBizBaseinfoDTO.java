package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业工商基本信息-返回对象模型")
public class LoanBizBaseinfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 479454114238314344L;

	@ApiModelProperty(name = "name", value = "企业名称")
	private String name; // 企业名称

	@ApiModelProperty(name = "creditCode", value = "统一社会信用代码")
	private String creditCode; // 统一社会信用代码[varchar(255)]

	@ApiModelProperty(name = "regStatus", value = "经营状态")
	private String regStatus; // 企业状态[varchar(31)]
	@ApiModelProperty(name = "companyOrgType", value = "企业（机构）类型")
	private String companyOrgType; // 企业类型[varchar(127)]
	@ApiModelProperty(name = "regInstitute", value = "登记机关")
	private String regInstitute; // 登记机关[varchar(255)]
	@ApiModelProperty(name = "industry", value = "行业名称")
	private String industry; // 行业[varchar(255)]
	@ApiModelProperty(name = "regCapital", value = "注册资本")
	private String regCapital; // 注册资本[varchar(50)]
	@ApiModelProperty(name = "legalPersonName", value = "法人")
	private String legalPersonName; // 法人[varchar(120)]
	@ApiModelProperty(name = "fromTime", value = " 经营开始时间[毫秒数]", dataType = "Long")
	private Long fromTime; // 经营开始时间[毫秒数]
	@ApiModelProperty(name = "toTime", value = " 经营结束时间[毫秒数]", dataType = "Long")
	private Long toTime; // 经营结束时间[毫秒数]
	@ApiModelProperty(name = "businessScope", value = "经营范围")
	private String businessScope; // 经营范围[varchar(4091)]

	@ApiModelProperty(name = "socialStaffNum", value = "参保人数")
	private Integer socialStaffNum;

	// private String regint; // 注册号[varchar(31)]
	// private String orgint; // 组织机构代码[varchar(31)]
	// private String taxint; // 纳税人识别号[varchar(255)]
	// private String regLocation; // 注册地址[varchar(255)]

	// private Long estiblishTime; // 成立日期[毫秒数]

	// @ApiModelProperty(name = "bondName", value = "股票名")
	// private String bondName; // 股票名[varchar(20)]
	// @ApiModelProperty(name = "bondType", value = "股票类型")
	// private String bondType; // 股票类型[varchar(31)]
	// @ApiModelProperty(name = "bondNum", value = "股票号")
	// private String bondNum; // 股票号[varchar(20)]

	// private String base; // 省份简称[varchar(31)]

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public String getCompanyOrgType() {
		return companyOrgType;
	}

	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
	}

	public String getRegInstitute() {
		return regInstitute;
	}

	public void setRegInstitute(String regInstitute) {
		this.regInstitute = regInstitute;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Long getFromTime() {
		return fromTime;
	}

	public void setFromTime(Long fromTime) {
		this.fromTime = fromTime;
	}

	public Long getToTime() {
		return toTime;
	}

	public void setToTime(Long toTime) {
		this.toTime = toTime;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public Integer getSocialStaffNum() {
		return socialStaffNum;
	}

	public void setSocialStaffNum(Integer socialStaffNum) {
		this.socialStaffNum = socialStaffNum;
	}

}
