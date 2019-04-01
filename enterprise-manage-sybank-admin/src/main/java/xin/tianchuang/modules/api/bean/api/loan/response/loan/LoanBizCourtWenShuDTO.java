package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业裁判文书-返回对象模型")
public class LoanBizCourtWenShuDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -785502184147910981L;
	@ApiModelProperty(name = "publishdate", value = "日期")
	private String publishdate;// 刊登日期
	@ApiModelProperty(name = "content", value = "裁判文书")
	private String content;// 原告 text
	@ApiModelProperty(name = "reason", value = "案由（暂无数据）")
	private String reason;//
	@ApiModelProperty(name = "party1", value = "原告/上诉人")
	private String party1;// 原告/上诉人
	@ApiModelProperty(name = "party2", value = "被告/被上诉人")
	private String party2;// 被告/被上诉人
	@ApiModelProperty(name = "caseno", value = "案号")
	private String caseno;

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public String getParty1() {
		return party1;
	}

	public void setParty1(String party1) {
		this.party1 = party1;
	}

	public String getParty2() {
		return party2;
	}

	public void setParty2(String party2) {
		this.party2 = party2;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

}
