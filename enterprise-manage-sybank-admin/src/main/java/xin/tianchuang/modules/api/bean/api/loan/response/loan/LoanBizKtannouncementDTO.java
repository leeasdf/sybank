package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业开庭公告-返回对象模型")
public class LoanBizKtannouncementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8586382635772923192L;
	@ApiModelProperty(name = "caseReason", value = "案由")
	private String caseReason;// 案由 varchar(150)
	@ApiModelProperty(name = "caseNo", value = "案号")
	private String caseNo;
	
	@ApiModelProperty(name = "plaintiff", value = "原告/上诉人")
	private List<LoanBizKtannouncementPlaintiffDTO> plaintiff;// 原告/上诉人
	
	@ApiModelProperty(name = "defendant", value = "被告/被上诉人")
	private List<LoanBizKtannouncementDefendantDTO> defendant;// 被告/被上诉人
	@ApiModelProperty(name = "startDate", value = "开庭日期(时间) 毫秒数")
	private String startDate;// 开庭日期(时间) 毫秒数
	@ApiModelProperty(name = "litigant", value = "当事人")
	private String litigant;// 当事人 varchar(800)
	@ApiModelProperty(name = "court", value = "法院")
	private String court;// 法院 varchar(50)

	public String getCaseReason() {
		return caseReason;
	}

	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public List<LoanBizKtannouncementPlaintiffDTO> getPlaintiff() {
		return plaintiff;
	}

	public void setPlaintiff(List<LoanBizKtannouncementPlaintiffDTO> plaintiff) {
		this.plaintiff = plaintiff;
	}

	public List<LoanBizKtannouncementDefendantDTO> getDefendant() {
		return defendant;
	}

	public void setDefendant(List<LoanBizKtannouncementDefendantDTO> defendant) {
		this.defendant = defendant;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLitigant() {
		return litigant;
	}

	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

}
