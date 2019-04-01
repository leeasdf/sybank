package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open371AnnualreportOutGuaranteeInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7277147667866877725L;
	private String reportYear;// 年份
	private String creditor;// 债权人
	private String obligor;// 债务人
	private String creditoType;// 主债权种类
	private String creditoAmount;// 主债权数额
	private String creditoTerm;// 履行债务的期限
	private String guaranteeTerm;// 保证的期间
	private String guaranteeWay;// 保证的方式
	private String guaranteeScope;// 保证担保的范围

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}

	public String getObligor() {
		return obligor;
	}

	public void setObligor(String obligor) {
		this.obligor = obligor;
	}

	public String getCreditoType() {
		return creditoType;
	}

	public void setCreditoType(String creditoType) {
		this.creditoType = creditoType;
	}

	public String getCreditoAmount() {
		return creditoAmount;
	}

	public void setCreditoAmount(String creditoAmount) {
		this.creditoAmount = creditoAmount;
	}

	public String getCreditoTerm() {
		return creditoTerm;
	}

	public void setCreditoTerm(String creditoTerm) {
		this.creditoTerm = creditoTerm;
	}

	public String getGuaranteeTerm() {
		return guaranteeTerm;
	}

	public void setGuaranteeTerm(String guaranteeTerm) {
		this.guaranteeTerm = guaranteeTerm;
	}

	public String getGuaranteeWay() {
		return guaranteeWay;
	}

	public void setGuaranteeWay(String guaranteeWay) {
		this.guaranteeWay = guaranteeWay;
	}

	public String getGuaranteeScope() {
		return guaranteeScope;
	}

	public void setGuaranteeScope(String guaranteeScope) {
		this.guaranteeScope = guaranteeScope;
	}

}
