package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 进出口信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnImportExportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6284091168507228211L;
	/**
	 * 行业种类
	 */
	private String industryCategory;
	/**
	 * 年报情况
	 */
	private String annualReport;
	/**
	 * 海关注销标识
	 */
	private String status;
	/**
	 * 行政区划
	 */
	private String administrativeDivision;
	/**
	 * 经营类别
	 */
	private String managementCategory;
	/**
	 * 注册海关
	 */
	private String customsRegisteredAddress;
	/**
	 * 报关有效期
	 */
	private String validityDate;
	/**
	 * 经济区划
	 */
	private String economicDivision;
	/**
	 * 注册日期
	 */
	private String recordDate;
	/**
	 * 海关注册号
	 */
	private String crCode;
	/**
	 * 特殊贸易区域
	 */
	private String specialTradeArea;
	/**
	 * 跨境贸易电子商务类型
	 */
	private String types;
	/**
	 * 信用登记
	 */
	private String creditRating;
	/**
	 * sanction
	 */
	private String sanction;

	/**
	 * 设置：行业种类
	 */
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	/**
	 * 获取：行业种类
	 */
	public String getIndustryCategory() {
		return industryCategory;
	}

	/**
	 * 设置：年报情况
	 */
	public void setAnnualReport(String annualReport) {
		this.annualReport = annualReport;
	}

	/**
	 * 获取：年报情况
	 */
	public String getAnnualReport() {
		return annualReport;
	}

	/**
	 * 设置：海关注销标识
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：海关注销标识
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置：行政区划
	 */
	public void setAdministrativeDivision(String administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}

	/**
	 * 获取：行政区划
	 */
	public String getAdministrativeDivision() {
		return administrativeDivision;
	}

	/**
	 * 设置：经营类别
	 */
	public void setManagementCategory(String managementCategory) {
		this.managementCategory = managementCategory;
	}

	/**
	 * 获取：经营类别
	 */
	public String getManagementCategory() {
		return managementCategory;
	}

	/**
	 * 设置：注册海关
	 */
	public void setCustomsRegisteredAddress(String customsRegisteredAddress) {
		this.customsRegisteredAddress = customsRegisteredAddress;
	}

	/**
	 * 获取：注册海关
	 */
	public String getCustomsRegisteredAddress() {
		return customsRegisteredAddress;
	}

	/**
	 * 设置：报关有效期
	 */
	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	/**
	 * 获取：报关有效期
	 */
	public String getValidityDate() {
		return validityDate;
	}

	/**
	 * 设置：经济区划
	 */
	public void setEconomicDivision(String economicDivision) {
		this.economicDivision = economicDivision;
	}

	/**
	 * 获取：经济区划
	 */
	public String getEconomicDivision() {
		return economicDivision;
	}

	/**
	 * 设置：注册日期
	 */
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	/**
	 * 获取：注册日期
	 */
	public String getRecordDate() {
		return recordDate;
	}

	/**
	 * 设置：海关注册号
	 */
	public void setCrCode(String crCode) {
		this.crCode = crCode;
	}

	/**
	 * 获取：海关注册号
	 */
	public String getCrCode() {
		return crCode;
	}

	/**
	 * 设置：特殊贸易区域
	 */
	public void setSpecialTradeArea(String specialTradeArea) {
		this.specialTradeArea = specialTradeArea;
	}

	/**
	 * 获取：特殊贸易区域
	 */
	public String getSpecialTradeArea() {
		return specialTradeArea;
	}

	/**
	 * 设置：跨境贸易电子商务类型
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * 获取：跨境贸易电子商务类型
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * 设置：信用登记
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}

	/**
	 * 获取：信用登记
	 */
	public String getCreditRating() {
		return creditRating;
	}

	/**
	 * 设置：sanction
	 */
	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	/**
	 * 获取：sanction
	 */
	public String getSanction() {
		return sanction;
	}

}
