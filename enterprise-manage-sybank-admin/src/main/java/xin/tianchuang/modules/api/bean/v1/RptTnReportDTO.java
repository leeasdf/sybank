package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业年报
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 10:14:18
 */

public class RptTnReportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 412061646881888338L;
	/**
	 * 年报年份
	 */
	private String years;
	/**
	 * 年报名称
	 */
	private String reportTitle;
	/**
	 * 年报内容
	 */
	private String reportBody;

	/**
	 * 设置：年报年份
	 */
	public void setYears(String years) {
		this.years = years;
	}

	/**
	 * 获取：年报年份
	 */
	public String getYears() {
		return years;
	}

	/**
	 * 设置：年报名称
	 */
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	/**
	 * 获取：年报名称
	 */
	public String getReportTitle() {
		return reportTitle;
	}

	/**
	 * 设置：年报内容
	 */
	public void setReportBody(String reportBody) {
		this.reportBody = reportBody;
	}

	/**
	 * 获取：年报内容
	 */
	public String getReportBody() {
		return reportBody;
	}

}
