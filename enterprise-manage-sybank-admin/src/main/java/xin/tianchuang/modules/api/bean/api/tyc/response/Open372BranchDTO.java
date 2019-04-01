package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open372BranchDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912382915198479721L;
	private Integer toco;// 拥有公司数量
	private String logo;// logo varchar(150)
	private String alias;// 简称 varchar(30)
	private Long estiblishTime;// 开业时间 毫秒数
	private String regStatus;// 企业状态 varchar(31)
	private Integer type;// 1-公司 2-人
	private String legalPersonName;// 法人 varchar(120)
	private Integer pencertileScore;// 评分
	private Long legalPersonId;// 法人id
	@SerializedName("id")
	private Long companyId;// 公司id
	private String category;// 行业code
	private String regCapital;// 注册资金 varchar(50)
	private String name;// 公司名 varchar(255)
	private String base;// 省份简称 varchar(10)
	private Integer personType;// 法人类型 1-人 2-公司

	public Integer getToco() {
		return toco;
	}

	public void setToco(Integer toco) {
		this.toco = toco;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Integer getPencertileScore() {
		return pencertileScore;
	}

	public void setPencertileScore(Integer pencertileScore) {
		this.pencertileScore = pencertileScore;
	}

	public Long getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Long legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Integer getPersonType() {
		return personType;
	}

	public void setPersonType(Integer personType) {
		this.personType = personType;
	}

}
