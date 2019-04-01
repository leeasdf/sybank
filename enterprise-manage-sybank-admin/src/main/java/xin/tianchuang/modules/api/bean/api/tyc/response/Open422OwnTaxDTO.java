package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open422OwnTaxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 784661697902462593L;
	private String regType;// 注册类型 varchar(50)
	private String personIdNumber;// 证件号码 varchar(150)
	private String legalpersonName;// 法人或负责人名称 varchar(150)
	private String location;// 经营地点 varchar(150)
	private String ownTaxAmount;// 欠税金额 varchar(50)
	private String department;// 部门 varchar(200)
	private String taxIdNumber;// 纳税人识别号 varchar(150)
	private String type;// 税务类型 varchar(10)
	private String taxCategory;// 欠税税种 varchar(255)
	private String taxpayerType;// 纳税人类型 varchar(10)
	private String newOwnTaxBalance;// 当前新发生欠税余额 varchar(20)
	private String ownTaxBalance;// 欠税余额 varchar(20)
	private String name;// 纳税人名称 varchar(255)
	private String personIdName;// 法人证件名称 varchar(50)
	private String publishDate;// 发布时间

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public String getPersonIdNumber() {
		return personIdNumber;
	}

	public void setPersonIdNumber(String personIdNumber) {
		this.personIdNumber = personIdNumber;
	}

	public String getLegalpersonName() {
		return legalpersonName;
	}

	public void setLegalpersonName(String legalpersonName) {
		this.legalpersonName = legalpersonName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwnTaxAmount() {
		return ownTaxAmount;
	}

	public void setOwnTaxAmount(String ownTaxAmount) {
		this.ownTaxAmount = ownTaxAmount;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}

	public String getTaxpayerType() {
		return taxpayerType;
	}

	public void setTaxpayerType(String taxpayerType) {
		this.taxpayerType = taxpayerType;
	}

	public String getNewOwnTaxBalance() {
		return newOwnTaxBalance;
	}

	public void setNewOwnTaxBalance(String newOwnTaxBalance) {
		this.newOwnTaxBalance = newOwnTaxBalance;
	}

	public String getOwnTaxBalance() {
		return ownTaxBalance;
	}

	public void setOwnTaxBalance(String ownTaxBalance) {
		this.ownTaxBalance = ownTaxBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonIdName() {
		return personIdName;
	}

	public void setPersonIdName(String personIdName) {
		this.personIdName = personIdName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
