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
@TableName("ENT_BASE_HK_INFO")
public class EntBaseHkInfoEntity implements Serializable {
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
	private String logo;
	/**
	 * 
	 */
	private String nameEn;
	/**
	 * 
	 */
	private String companyNum;
	/**
	 * 
	 */
	private Long estiblishTime;
	/**
	 * 
	 */
	private String regStatus;
	/**
	 * 
	 */
	private Long entityType;
	/**
	 * 
	 */
	private String mortgageS;
	/**
	 * 
	 */
	private Long toTime;
	/**
	 * 
	 */
	private String haveReport;
	/**
	 * 
	 */
	private String companyOrgType;
	/**
	 * 
	 */
	private String remarksS;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private String liquidationModeS;
	/**
	 * 
	 */
	private String importantItemsS;
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
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	/**
	 * 获取：
	 */
	public String getNameEn() {
		return nameEn;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}
	/**
	 * 获取：
	 */
	public String getCompanyNum() {
		return companyNum;
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
	public void setEntityType(Long entityType) {
		this.entityType = entityType;
	}
	/**
	 * 获取：
	 */
	public Long getEntityType() {
		return entityType;
	}
	/**
	 * 设置：
	 */
	public void setMortgageS(String mortgageS) {
		this.mortgageS = mortgageS;
	}
	/**
	 * 获取：
	 */
	public String getMortgageS() {
		return mortgageS;
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
	public void setRemarksS(String remarksS) {
		this.remarksS = remarksS;
	}
	/**
	 * 获取：
	 */
	public String getRemarksS() {
		return remarksS;
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
	public void setLiquidationModeS(String liquidationModeS) {
		this.liquidationModeS = liquidationModeS;
	}
	/**
	 * 获取：
	 */
	public String getLiquidationModeS() {
		return liquidationModeS;
	}
	/**
	 * 设置：
	 */
	public void setImportantItemsS(String importantItemsS) {
		this.importantItemsS = importantItemsS;
	}
	/**
	 * 获取：
	 */
	public String getImportantItemsS() {
		return importantItemsS;
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
