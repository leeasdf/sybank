package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open442IcpDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539241837539173161L;

	private List<String> webSite; // 网站
	private String examineDate;// 检查时间
	private String companyType;// 公司类型 varchar(96)
	private String webName;// 网站名称 varchar(255)
	private String ym;// 域名 varchar(255)
	private String liscense;// 许可证 varchar(255)
	private String companyName;// 公司名称 varchar(255)

	public List<String> getWebSite() {
		return webSite;
	}

	public void setWebSite(List<String> webSite) {
		this.webSite = webSite;
	}

	public String getExamineDate() {
		return examineDate;
	}

	public void setExamineDate(String examineDate) {
		this.examineDate = examineDate;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}

	public String getLiscense() {
		return liscense;
	}

	public void setLiscense(String liscense) {
		this.liscense = liscense;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
