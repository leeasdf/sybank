package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open371AnnualreportReportSocialSecurityInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6961847946819516332L;
	@SerializedName("id")
	private String tableId;// 对应表id
	private Long annaulreportId;// 年报id
	private String endowmentInsurance;// 城镇职工基本养老保险人数
	private String unemploymentInsurance;// 失业保险人数
	private String medicalInsurance;// 职工基本医疗保险人数
	private String employmentInjuryInsurance;// 工伤保险
	private String maternityInsurance;// 生育保险人数
	private String endowmentInsuranceBase;// 单位参加城镇职工基本养老保险缴费基数
	private String unemploymentInsuranceBase;// 单位参加失业保险缴费基数
	private String medicalInsuranceBase;// 单位参加职工基本医疗保险缴费基数
	private String maternityInsuranceBase;// 单位参加生育保险缴费基数
	private String endowmentInsurancePayAmount;// 参加城镇职工基本养老保险本期实际缴费金额
	private String unemploymentInsurancePayAmount;// 参加失业保险本期实际缴费金额
	private String medicalInsurancePayAmount;// 参加职工基本医疗保险本期实际缴费金额
	private String employmentInjuryInsurancePayAmount;// 参加工伤保险本期实际缴费金额
	private String maternityInsurancePayAmount;// 参加生育保险本期实际缴费金额
	private String endowmentInsuranceOweAmount;// 单位参加城镇职工基本养老保险累计欠缴金额
	private String unemploymentInsuranceOweAmount;// 单位参加失业保险累计欠缴金额
	private String medicalInsuranceOweAmount;// 单位参加职工基本医疗保险累计欠缴金额
	private String employmentInjuryInsuranceOweAmount;// 单位参加工伤保险累计欠缴金额
	private String maternityInsuranceOweAmount;// 单位参加生育保险累计欠缴金额
	@SerializedName("createTime")
	private Long socialSecurityCreateTime;// 创建时间

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getEndowmentInsurance() {
		return endowmentInsurance;
	}

	public void setEndowmentInsurance(String endowmentInsurance) {
		this.endowmentInsurance = endowmentInsurance;
	}

	public String getUnemploymentInsurance() {
		return unemploymentInsurance;
	}

	public void setUnemploymentInsurance(String unemploymentInsurance) {
		this.unemploymentInsurance = unemploymentInsurance;
	}

	public String getMedicalInsurance() {
		return medicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public String getEmploymentInjuryInsurance() {
		return employmentInjuryInsurance;
	}

	public void setEmploymentInjuryInsurance(String employmentInjuryInsurance) {
		this.employmentInjuryInsurance = employmentInjuryInsurance;
	}

	public String getMaternityInsurance() {
		return maternityInsurance;
	}

	public void setMaternityInsurance(String maternityInsurance) {
		this.maternityInsurance = maternityInsurance;
	}

	public String getEndowmentInsuranceBase() {
		return endowmentInsuranceBase;
	}

	public void setEndowmentInsuranceBase(String endowmentInsuranceBase) {
		this.endowmentInsuranceBase = endowmentInsuranceBase;
	}

	public String getUnemploymentInsuranceBase() {
		return unemploymentInsuranceBase;
	}

	public void setUnemploymentInsuranceBase(String unemploymentInsuranceBase) {
		this.unemploymentInsuranceBase = unemploymentInsuranceBase;
	}

	public String getMedicalInsuranceBase() {
		return medicalInsuranceBase;
	}

	public void setMedicalInsuranceBase(String medicalInsuranceBase) {
		this.medicalInsuranceBase = medicalInsuranceBase;
	}

	public String getMaternityInsuranceBase() {
		return maternityInsuranceBase;
	}

	public void setMaternityInsuranceBase(String maternityInsuranceBase) {
		this.maternityInsuranceBase = maternityInsuranceBase;
	}

	public String getEndowmentInsurancePayAmount() {
		return endowmentInsurancePayAmount;
	}

	public void setEndowmentInsurancePayAmount(String endowmentInsurancePayAmount) {
		this.endowmentInsurancePayAmount = endowmentInsurancePayAmount;
	}

	public String getUnemploymentInsurancePayAmount() {
		return unemploymentInsurancePayAmount;
	}

	public void setUnemploymentInsurancePayAmount(String unemploymentInsurancePayAmount) {
		this.unemploymentInsurancePayAmount = unemploymentInsurancePayAmount;
	}

	public String getMedicalInsurancePayAmount() {
		return medicalInsurancePayAmount;
	}

	public void setMedicalInsurancePayAmount(String medicalInsurancePayAmount) {
		this.medicalInsurancePayAmount = medicalInsurancePayAmount;
	}

	public String getEmploymentInjuryInsurancePayAmount() {
		return employmentInjuryInsurancePayAmount;
	}

	public void setEmploymentInjuryInsurancePayAmount(String employmentInjuryInsurancePayAmount) {
		this.employmentInjuryInsurancePayAmount = employmentInjuryInsurancePayAmount;
	}

	public String getMaternityInsurancePayAmount() {
		return maternityInsurancePayAmount;
	}

	public void setMaternityInsurancePayAmount(String maternityInsurancePayAmount) {
		this.maternityInsurancePayAmount = maternityInsurancePayAmount;
	}

	public String getEndowmentInsuranceOweAmount() {
		return endowmentInsuranceOweAmount;
	}

	public void setEndowmentInsuranceOweAmount(String endowmentInsuranceOweAmount) {
		this.endowmentInsuranceOweAmount = endowmentInsuranceOweAmount;
	}

	public String getUnemploymentInsuranceOweAmount() {
		return unemploymentInsuranceOweAmount;
	}

	public void setUnemploymentInsuranceOweAmount(String unemploymentInsuranceOweAmount) {
		this.unemploymentInsuranceOweAmount = unemploymentInsuranceOweAmount;
	}

	public String getMedicalInsuranceOweAmount() {
		return medicalInsuranceOweAmount;
	}

	public void setMedicalInsuranceOweAmount(String medicalInsuranceOweAmount) {
		this.medicalInsuranceOweAmount = medicalInsuranceOweAmount;
	}

	public String getEmploymentInjuryInsuranceOweAmount() {
		return employmentInjuryInsuranceOweAmount;
	}

	public void setEmploymentInjuryInsuranceOweAmount(String employmentInjuryInsuranceOweAmount) {
		this.employmentInjuryInsuranceOweAmount = employmentInjuryInsuranceOweAmount;
	}

	public String getMaternityInsuranceOweAmount() {
		return maternityInsuranceOweAmount;
	}

	public void setMaternityInsuranceOweAmount(String maternityInsuranceOweAmount) {
		this.maternityInsuranceOweAmount = maternityInsuranceOweAmount;
	}

	public Long getAnnaulreportId() {
		return annaulreportId;
	}

	public void setAnnaulreportId(Long annaulreportId) {
		this.annaulreportId = annaulreportId;
	}

	public Long getSocialSecurityCreateTime() {
		return socialSecurityCreateTime;
	}

	public void setSocialSecurityCreateTime(Long socialSecurityCreateTime) {
		this.socialSecurityCreateTime = socialSecurityCreateTime;
	}

}
