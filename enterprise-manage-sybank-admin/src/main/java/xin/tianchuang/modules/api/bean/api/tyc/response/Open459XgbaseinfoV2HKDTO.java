package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2HKDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -385612419549020557L;
	private String logo;// 公司logo
	private String remarksS;// 备注
	private String nameEn;// 英文名
	private String companyNum;// 公司编号
	private Long estiblishTime;// 成立时间（毫秒数）
	private String regStatus;// 公司现状
	private Integer entityType;// 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会，7-不存在法人、注册资本、统一社会信用代码、经营状态
	private String mortgageS;// 押记登记册
	private Long toTime;// 结束时间
	@SerializedName("id")
	private Long tycId;// 公司id
	private Boolean haveReport;// 是否有年报
	private String companyOrgType;// 公司类型
	private String name;// 公司名称
	private String base;// 省份
	private String liquidationModeS;// 清盘模式
	private String importantItemsS;// 重要事项
	private String weibo;// 微博

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRemarksS() {
		return remarksS;
	}

	public void setRemarksS(String remarksS) {
		this.remarksS = remarksS;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
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

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public String getMortgageS() {
		return mortgageS;
	}

	public void setMortgageS(String mortgageS) {
		this.mortgageS = mortgageS;
	}

	public Long getToTime() {
		return toTime;
	}

	public void setToTime(Long toTime) {
		this.toTime = toTime;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public Boolean getHaveReport() {
		return haveReport;
	}

	public void setHaveReport(Boolean haveReport) {
		this.haveReport = haveReport;
	}

	public String getCompanyOrgType() {
		return companyOrgType;
	}

	public void setCompanyOrgType(String companyOrgType) {
		this.companyOrgType = companyOrgType;
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

	public String getLiquidationModeS() {
		return liquidationModeS;
	}

	public void setLiquidationModeS(String liquidationModeS) {
		this.liquidationModeS = liquidationModeS;
	}

	public String getImportantItemsS() {
		return importantItemsS;
	}

	public void setImportantItemsS(String importantItemsS) {
		this.importantItemsS = importantItemsS;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}