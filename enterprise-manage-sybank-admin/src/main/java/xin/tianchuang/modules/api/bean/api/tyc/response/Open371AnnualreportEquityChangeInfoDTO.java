package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open371AnnualreportEquityChangeInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7327347116895267804L;
	private String reportYear;// 年份
	private String investorName;// 股东（发起人）
	private String ratioBefore;// 变更前股权比例
	private String ratioAfter;// 变更后股权比例
	private String changeTime;// 股权变更日期

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getRatioBefore() {
		return ratioBefore;
	}

	public void setRatioBefore(String ratioBefore) {
		this.ratioBefore = ratioBefore;
	}

	public String getRatioAfter() {
		return ratioAfter;
	}

	public void setRatioAfter(String ratioAfter) {
		this.ratioAfter = ratioAfter;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

}
