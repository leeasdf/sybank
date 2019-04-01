package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业法院公告-返回对象模型")
public class LoanBizCourtAnnouncementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597231029095204391L;

	@ApiModelProperty(name = "publishdate", value = "刊登日期")
	private String publishdate;// 刊登日期
	@ApiModelProperty(name = "party1", value = "原告")
	private String party1;// 原告 text
	@ApiModelProperty(name = "party2", value = "当事人")
	private String party2;// 当事人 text
	@ApiModelProperty(name = "bltntypename", value = "公告类型")
	private String bltntypename;// 公告类型 varchar(10)
	@ApiModelProperty(name = "courtcode", value = "法院名")
	private String courtcode;// 法院名 varchar(500)
	@ApiModelProperty(name = "content", value = "案件内容")
	private String content;// 案件内容 text

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
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

	public String getBltntypename() {
		return bltntypename;
	}

	public void setBltntypename(String bltntypename) {
		this.bltntypename = bltntypename;
	}

	public String getCourtcode() {
		return courtcode;
	}

	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
