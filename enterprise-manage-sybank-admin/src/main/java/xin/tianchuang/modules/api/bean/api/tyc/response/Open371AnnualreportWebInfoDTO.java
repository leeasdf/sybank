package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open371AnnualreportWebInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406586403597964034L;
	private String reportYear;// 年份
	private String webType;// 网站类型
	private String name;// 名称
	private String website;// 网址
 
	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getWebType() {
		return webType;
	}

	public void setWebType(String webType) {
		this.webType = webType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
