package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class Open369InverstDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 748787851323281922L;
	private String orgType; // 公司类型 varchar(127)
	@SerializedName("business_scope")
	private String businessScope; // 经营范围 varchar(4091)
	private String percent; // 投资占比
	private String regStatus; // 企业状态 varchar(50)
	private Long estiblishTime; // 开业时间 毫秒数
	private String legalPersonName; // 法人 varchar(120)
	private Integer type; // 1-公司 2-人
	private Integer pencertileScore; // 评分
	private Long legalPersonId; // 法人id
	private BigDecimal amount; // 投资金额 单位：万
	@SerializedName("id")
	private Long tycId; // 公司id
	private String category; // 行业 varchar(256)
	private String regCapital; // 注册资金 varchar(50)
	private String name; // 被投资公司 varchar(255)
	private String base; // 省份简称 varchar(10
	@SerializedName("creditCode")
	private String inverstCreditCode; // 统一社会信用代码 varchar(18)
	private Integer personType; // 1 人 2 公司
	private Integer toco; // 拥有公司数量
	private String alias; // 简称 varchar(30)
	private String logo; // logo varchar(150)

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
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

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
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

	public String getInverstCreditCode() {
		return inverstCreditCode;
	}

	public void setInverstCreditCode(String inverstCreditCode) {
		this.inverstCreditCode = inverstCreditCode;
	}

	public Integer getPersonType() {
		return personType;
	}

	public void setPersonType(Integer personType) {
		this.personType = personType;
	}

	public Integer getToco() {
		return toco;
	}

	public void setToco(Integer toco) {
		this.toco = toco;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
