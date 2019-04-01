package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open386KtannouncementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179644367973381627L;
	private String startDate;// 开庭日期(时间) 毫秒数
	private List<Open386KtannouncementPlaintiffDTO> plaintiff;// 原告/上诉人
	private String plaintiffId;// 原告id
	private String courtroom;// 法庭 varchar(50)
	private String caseReason;// 案由 varchar(150)
	private String court;// 法院 varchar(50)
	private String uni;// 无用
	private String searchType;// 无用
	private String litigant;// 当事人 varchar(800)
	@SerializedName("id")
	private String tableId;// id
	@SerializedName("_type")
	private String type;// 无用
	private String judge;// 审判长/主审人 varchar(20)
	private List<String> connList;// 跳转到天眼查链接
	private String defendantId;// 被告人id
	private String contractors;// 承办部门 varchar(50)
	private String caseNo;// 案号 varchar(50)
	private String eventTime;// 无用
	private List<Open386KtannouncementDefendantDTO> defendant;// 被告/被上诉人
	private String name;// 人或公司名 varchar(255)

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public List<Open386KtannouncementPlaintiffDTO> getPlaintiff() {
		return plaintiff;
	}

	public void setPlaintiff(List<Open386KtannouncementPlaintiffDTO> plaintiff) {
		this.plaintiff = plaintiff;
	}

	public String getPlaintiffId() {
		return plaintiffId;
	}

	public void setPlaintiffId(String plaintiffId) {
		this.plaintiffId = plaintiffId;
	}

	public String getCourtroom() {
		return courtroom;
	}

	public void setCourtroom(String courtroom) {
		this.courtroom = courtroom;
	}

	public String getCaseReason() {
		return caseReason;
	}

	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getLitigant() {
		return litigant;
	}

	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getDefendantId() {
		return defendantId;
	}

	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}

	public String getContractors() {
		return contractors;
	}

	public void setContractors(String contractors) {
		this.contractors = contractors;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public List<Open386KtannouncementDefendantDTO> getDefendant() {
		return defendant;
	}

	public void setDefendant(List<Open386KtannouncementDefendantDTO> defendant) {
		this.defendant = defendant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
