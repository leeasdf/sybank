package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:05
 */
@TableName("ENT_INVERST_INFO")
public class EntInverstInfoEntity implements Serializable {
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
	private String orgType;
	/**
	 * 
	 */
	private String businessScope;
	/**
	 * 
	 */
	private String percent;
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
	private String legalPersonName;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private Integer pencertileScore;
	/**
	 * 
	 */
	private Long legalPersonId;
	/**
	 * 
	 */
	private BigDecimal amount;
	/**
	 * 
	 */
	private Long tycId;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String regCapital;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private String inverstCreditCode;
	/**
	 * 
	 */
	private Integer personType;
	/**
	 * 
	 */
	private Integer toco;
	/**
	 * 
	 */
	private String alias;
	/**
	 * 
	 */
	private String logo;
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
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	/**
	 * 获取：
	 */
	public String getOrgType() {
		return orgType;
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
	public void setPercent(String percent) {
		this.percent = percent;
	}
	/**
	 * 获取：
	 */
	public String getPercent() {
		return percent;
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
	public void setPencertileScore(Integer pencertileScore) {
		this.pencertileScore = pencertileScore;
	}
	/**
	 * 获取：
	 */
	public Integer getPencertileScore() {
		return pencertileScore;
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
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAmount() {
		return amount;
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
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：
	 */
	public String getCategory() {
		return category;
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
	public void setInverstCreditCode(String inverstCreditCode) {
		this.inverstCreditCode = inverstCreditCode;
	}
	/**
	 * 获取：
	 */
	public String getInverstCreditCode() {
		return inverstCreditCode;
	}
	/**
	 * 设置：
	 */
	public void setPersonType(Integer personType) {
		this.personType = personType;
	}
	/**
	 * 获取：
	 */
	public Integer getPersonType() {
		return personType;
	}
	/**
	 * 设置：
	 */
	public void setToco(Integer toco) {
		this.toco = toco;
	}
	/**
	 * 获取：
	 */
	public Integer getToco() {
		return toco;
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
