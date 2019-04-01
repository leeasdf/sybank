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
 * @date 2019-03-21 17:00:10
 */
@TableName("ENT_ANNUALREPORT_SOCIAL_SECURITY")
public class EntAnnualreportSocialSecurityEntity implements Serializable {
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
	private String belongYear;
	/**
	 * 
	 */
	private String tableId;
	/**
	 * 
	 */
	private Long annaulreportId;
	/**
	 * 
	 */
	private String endowmentInsurance;
	/**
	 * 
	 */
	private String unemploymentInsurance;
	/**
	 * 
	 */
	private String medicalInsurance;
	/**
	 * 
	 */
	private String employmentInjuryInsurance;
	/**
	 * 
	 */
	private String maternityInsurance;
	/**
	 * 
	 */
	private String endowmentInsuranceBase;
	/**
	 * 
	 */
	private String unemploymentInsuranceBase;
	/**
	 * 
	 */
	private String medicalInsuranceBase;
	/**
	 * 
	 */
	private String maternityInsuranceBase;
	/**
	 * 
	 */
	private String endowmentInsurancePayAmount;
	/**
	 * 
	 */
	private String unemploymentInsurancePayAmount;
	/**
	 * 
	 */
	private String medicalInsurancePayAmount;
	/**
	 * 
	 */
	private String employmentInjuryInsurancePayAmount;
	/**
	 * 
	 */
	private String maternityInsurancePayAmount;
	/**
	 * 
	 */
	private String endowmentInsuranceOweAmount;
	/**
	 * 
	 */
	private String unemploymentInsuranceOweAmount;
	/**
	 * 
	 */
	private String medicalInsuranceOweAmount;
	/**
	 * 
	 */
	private String employmentInjuryInsuranceOweAmount;
	/**
	 * 
	 */
	private String maternityInsuranceOweAmount;
	/**
	 * 
	 */
	private Long socialSecurityCreateTime;
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
	public void setBelongYear(String belongYear) {
		this.belongYear = belongYear;
	}
	/**
	 * 获取：
	 */
	public String getBelongYear() {
		return belongYear;
	}
	/**
	 * 设置：
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public String getTableId() {
		return tableId;
	}
	/**
	 * 设置：
	 */
	public void setAnnaulreportId(Long annaulreportId) {
		this.annaulreportId = annaulreportId;
	}
	/**
	 * 获取：
	 */
	public Long getAnnaulreportId() {
		return annaulreportId;
	}
	/**
	 * 设置：
	 */
	public void setEndowmentInsurance(String endowmentInsurance) {
		this.endowmentInsurance = endowmentInsurance;
	}
	/**
	 * 获取：
	 */
	public String getEndowmentInsurance() {
		return endowmentInsurance;
	}
	/**
	 * 设置：
	 */
	public void setUnemploymentInsurance(String unemploymentInsurance) {
		this.unemploymentInsurance = unemploymentInsurance;
	}
	/**
	 * 获取：
	 */
	public String getUnemploymentInsurance() {
		return unemploymentInsurance;
	}
	/**
	 * 设置：
	 */
	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}
	/**
	 * 获取：
	 */
	public String getMedicalInsurance() {
		return medicalInsurance;
	}
	/**
	 * 设置：
	 */
	public void setEmploymentInjuryInsurance(String employmentInjuryInsurance) {
		this.employmentInjuryInsurance = employmentInjuryInsurance;
	}
	/**
	 * 获取：
	 */
	public String getEmploymentInjuryInsurance() {
		return employmentInjuryInsurance;
	}
	/**
	 * 设置：
	 */
	public void setMaternityInsurance(String maternityInsurance) {
		this.maternityInsurance = maternityInsurance;
	}
	/**
	 * 获取：
	 */
	public String getMaternityInsurance() {
		return maternityInsurance;
	}
	/**
	 * 设置：
	 */
	public void setEndowmentInsuranceBase(String endowmentInsuranceBase) {
		this.endowmentInsuranceBase = endowmentInsuranceBase;
	}
	/**
	 * 获取：
	 */
	public String getEndowmentInsuranceBase() {
		return endowmentInsuranceBase;
	}
	/**
	 * 设置：
	 */
	public void setUnemploymentInsuranceBase(String unemploymentInsuranceBase) {
		this.unemploymentInsuranceBase = unemploymentInsuranceBase;
	}
	/**
	 * 获取：
	 */
	public String getUnemploymentInsuranceBase() {
		return unemploymentInsuranceBase;
	}
	/**
	 * 设置：
	 */
	public void setMedicalInsuranceBase(String medicalInsuranceBase) {
		this.medicalInsuranceBase = medicalInsuranceBase;
	}
	/**
	 * 获取：
	 */
	public String getMedicalInsuranceBase() {
		return medicalInsuranceBase;
	}
	/**
	 * 设置：
	 */
	public void setMaternityInsuranceBase(String maternityInsuranceBase) {
		this.maternityInsuranceBase = maternityInsuranceBase;
	}
	/**
	 * 获取：
	 */
	public String getMaternityInsuranceBase() {
		return maternityInsuranceBase;
	}
	/**
	 * 设置：
	 */
	public void setEndowmentInsurancePayAmount(String endowmentInsurancePayAmount) {
		this.endowmentInsurancePayAmount = endowmentInsurancePayAmount;
	}
	/**
	 * 获取：
	 */
	public String getEndowmentInsurancePayAmount() {
		return endowmentInsurancePayAmount;
	}
	/**
	 * 设置：
	 */
	public void setUnemploymentInsurancePayAmount(String unemploymentInsurancePayAmount) {
		this.unemploymentInsurancePayAmount = unemploymentInsurancePayAmount;
	}
	/**
	 * 获取：
	 */
	public String getUnemploymentInsurancePayAmount() {
		return unemploymentInsurancePayAmount;
	}
	/**
	 * 设置：
	 */
	public void setMedicalInsurancePayAmount(String medicalInsurancePayAmount) {
		this.medicalInsurancePayAmount = medicalInsurancePayAmount;
	}
	/**
	 * 获取：
	 */
	public String getMedicalInsurancePayAmount() {
		return medicalInsurancePayAmount;
	}
	/**
	 * 设置：
	 */
	public void setEmploymentInjuryInsurancePayAmount(String employmentInjuryInsurancePayAmount) {
		this.employmentInjuryInsurancePayAmount = employmentInjuryInsurancePayAmount;
	}
	/**
	 * 获取：
	 */
	public String getEmploymentInjuryInsurancePayAmount() {
		return employmentInjuryInsurancePayAmount;
	}
	/**
	 * 设置：
	 */
	public void setMaternityInsurancePayAmount(String maternityInsurancePayAmount) {
		this.maternityInsurancePayAmount = maternityInsurancePayAmount;
	}
	/**
	 * 获取：
	 */
	public String getMaternityInsurancePayAmount() {
		return maternityInsurancePayAmount;
	}
	/**
	 * 设置：
	 */
	public void setEndowmentInsuranceOweAmount(String endowmentInsuranceOweAmount) {
		this.endowmentInsuranceOweAmount = endowmentInsuranceOweAmount;
	}
	/**
	 * 获取：
	 */
	public String getEndowmentInsuranceOweAmount() {
		return endowmentInsuranceOweAmount;
	}
	/**
	 * 设置：
	 */
	public void setUnemploymentInsuranceOweAmount(String unemploymentInsuranceOweAmount) {
		this.unemploymentInsuranceOweAmount = unemploymentInsuranceOweAmount;
	}
	/**
	 * 获取：
	 */
	public String getUnemploymentInsuranceOweAmount() {
		return unemploymentInsuranceOweAmount;
	}
	/**
	 * 设置：
	 */
	public void setMedicalInsuranceOweAmount(String medicalInsuranceOweAmount) {
		this.medicalInsuranceOweAmount = medicalInsuranceOweAmount;
	}
	/**
	 * 获取：
	 */
	public String getMedicalInsuranceOweAmount() {
		return medicalInsuranceOweAmount;
	}
	/**
	 * 设置：
	 */
	public void setEmploymentInjuryInsuranceOweAmount(String employmentInjuryInsuranceOweAmount) {
		this.employmentInjuryInsuranceOweAmount = employmentInjuryInsuranceOweAmount;
	}
	/**
	 * 获取：
	 */
	public String getEmploymentInjuryInsuranceOweAmount() {
		return employmentInjuryInsuranceOweAmount;
	}
	/**
	 * 设置：
	 */
	public void setMaternityInsuranceOweAmount(String maternityInsuranceOweAmount) {
		this.maternityInsuranceOweAmount = maternityInsuranceOweAmount;
	}
	/**
	 * 获取：
	 */
	public String getMaternityInsuranceOweAmount() {
		return maternityInsuranceOweAmount;
	}
	/**
	 * 设置：
	 */
	public void setSocialSecurityCreateTime(Long socialSecurityCreateTime) {
		this.socialSecurityCreateTime = socialSecurityCreateTime;
	}
	/**
	 * 获取：
	 */
	public Long getSocialSecurityCreateTime() {
		return socialSecurityCreateTime;
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
