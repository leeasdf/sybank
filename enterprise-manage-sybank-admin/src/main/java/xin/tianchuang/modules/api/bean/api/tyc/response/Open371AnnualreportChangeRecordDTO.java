package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open371AnnualreportChangeRecordDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8418424613800816292L;
	private String reportYear;// 年份
	private String changeItem;// 变更事项
	private String contentBefore;// 变更前
	private String contentAfter;// 变更后
	private String changeTime;// 变更时间

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getChangeItem() {
		return changeItem;
	}

	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}

	public String getContentBefore() {
		return contentBefore;
	}

	public void setContentBefore(String contentBefore) {
		this.contentBefore = contentBefore;
	}

	public String getContentAfter() {
		return contentAfter;
	}

	public void setContentAfter(String contentAfter) {
		this.contentAfter = contentAfter;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

}
