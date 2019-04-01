package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 客户信息
 * 
 * @author denghui
 *
 */
@ApiModel(value = "企业名录返回对象模型")
public class LoanBizCompanyInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2382117959921468426L;

	@ApiModelProperty(name = "name", value = "企业名称")
	private String name; // 企业名称
	@ApiModelProperty(name = "creditCode", value = "统一社会信用代码")
	private String creditCode; // 统一社会信用代码[varchar(255)]
	@ApiModelProperty(name = "legalPersonName", value = "法人姓名")
	private String legalPersonName; // 法人
	@ApiModelProperty(name = "companyOrgType", value = "企业（机构）类型")
	private String companyOrgType; // 企业类型[varchar(127)]
	@ApiModelProperty(name = "regCapital", value = "注册资本")
	private String regCapital; // 注册资本
	// private String regCapitalCurrency; // 注册资本币种 人民币 美元 欧元 等[varchar(10)]
	@ApiModelProperty(name = "listedFlag", value = "0-未上市 1-A股 2-B股 3-新三板 4-老三板")
	private Integer listedFlag; // 

	@ApiModelProperty(name = "industry", value = "行业门类")
	private String industry;

	@ApiModelProperty(name = "estiblishTime", value = "成立时间(unix时间戳)", example = "112")
	private Long estiblishTime; // 成立日期
	@ApiModelProperty(name = "regLocation", value = "注册地址")
	private String regLocation; // 注册地址[varchar(255)]
	@ApiModelProperty(name = "area", value = "区域")
	private String area; // 区域
	@ApiModelProperty(name = "tycId", value = "天眼查id", example = "112")
	private Long tycId;

	@ApiModelProperty(name = "phoneNumber", value = "电话号码", example = "13813838438")
	private String phoneNumber;
	
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

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getCompanyOrgType() {
		return companyOrgType;
	}

	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}



	public Integer getListedFlag() {
		return listedFlag;
	}

	public void setListedFlag(Integer listedFlag) {
		this.listedFlag = listedFlag;
	}

	public Long getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getRegLocation() {
		return regLocation;
	}

	public void setRegLocation(String regLocation) {
		this.regLocation = regLocation;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
