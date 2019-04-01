package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业法律诉讼-返回对象模型")
public class LoanBizLawSuitDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3152521866843935442L;

	@ApiModelProperty(name = "submittime", value = " 发布时间 毫秒数")
	private String submittime;// 发布时间 毫秒数

	@ApiModelProperty(name = "title", value = "标题")
	private String title;// 标题 varchar(2000)

	@ApiModelProperty(name = "url", value = "原文链接地址")
	private String url;// 原文链接地址 varchar(150)
	@ApiModelProperty(name = "casereason", value = "案由")
	private String casereason;// 案由 varchar(500)
	@ApiModelProperty(name = "plaintiffs", value = "原告")
	private String plaintiffs;// 原告 varchar(150)
	@ApiModelProperty(name = "defendants", value = "被告")
	private String defendants;// 被告
	@ApiModelProperty(name = "caseno", value = "案号")
	private String caseno;// 案号 varchar(1000)

	public String getSubmittime() {
		return submittime;
	}

	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCasereason() {
		return casereason;
	}

	public void setCasereason(String casereason) {
		this.casereason = casereason;
	}

	public String getPlaintiffs() {
		return plaintiffs;
	}

	public void setPlaintiffs(String plaintiffs) {
		this.plaintiffs = plaintiffs;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getDefendants() {
		return defendants;
	}

	public void setDefendants(String defendants) {
		this.defendants = defendants;
	}

}
