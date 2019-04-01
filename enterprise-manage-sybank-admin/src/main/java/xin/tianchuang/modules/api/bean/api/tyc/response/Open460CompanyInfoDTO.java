package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open460CompanyInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571902542636066885L;
	private Open460RelationDTO legal;
	private Open460RelationDTO chairman;
	private Open460RelationDTO generalManager;
	private Open460RelationDTO secretaries;

	private String postalcode;// 邮编
	private String controllingShareholder;// 控股股东
	private String fax;// 传真
	private String website;// 网址
	private String employeesNum;// 员工数量
	private String mainBusiness;// 主营业务
	private String code;// 股票编号
	private String companyName;// 公司名
	private String registeredCapital;// 注册资金
	private String usedName;// 曾用名
	private String area;// 省份
	private String address;// 地址
	private String name;// 股票名
	private String actualController;// 实际控股
	private String finalController;// 最终控股
	private String industry;// 行业
	private String productName;// 业务
	private String engName;// 英文名
	private String introduction;// 介绍
	private String mobile;// 电话

	public Open460RelationDTO getLegal() {
		return legal;
	}

	public void setLegal(Open460RelationDTO legal) {
		this.legal = legal;
	}

	public Open460RelationDTO getChairman() {
		return chairman;
	}

	public void setChairman(Open460RelationDTO chairman) {
		this.chairman = chairman;
	}

	public Open460RelationDTO getGeneralManager() {
		return generalManager;
	}

	public void setGeneralManager(Open460RelationDTO generalManager) {
		this.generalManager = generalManager;
	}

	public Open460RelationDTO getSecretaries() {
		return secretaries;
	}

	public void setSecretaries(Open460RelationDTO secretaries) {
		this.secretaries = secretaries;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getControllingShareholder() {
		return controllingShareholder;
	}

	public void setControllingShareholder(String controllingShareholder) {
		this.controllingShareholder = controllingShareholder;
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

	public String getEmployeesNum() {
		return employeesNum;
	}

	public void setEmployeesNum(String employeesNum) {
		this.employeesNum = employeesNum;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getUsedName() {
		return usedName;
	}

	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActualController() {
		return actualController;
	}

	public void setActualController(String actualController) {
		this.actualController = actualController;
	}

	public String getFinalController() {
		return finalController;
	}

	public void setFinalController(String finalController) {
		this.finalController = finalController;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
