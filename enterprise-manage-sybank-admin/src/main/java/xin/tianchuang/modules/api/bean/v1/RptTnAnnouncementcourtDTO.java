package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 作品著作权信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */

public class RptTnAnnouncementcourtDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1856987162401940711L;
	/**
	 * 开庭日期
	 */
	private String startDate;
	/**
	 * 原告/上诉人
	 */
	private String plaintiff;
	/**
	 * 被告/被上诉人
	 */
	private String defendant;
	/**
	 * 案件原由
	 */
	private String caseReason;
	/**
	 * 法庭
	 */
	private String courtroom;
	/**
	 * 案件编号
	 */
	private String caseNo;
	/**
	 * 法院
	 */
	private String court;
	/**
	 * 事件ID
	 */
	private String aId;
	/**
	 * 搜索类别
	 */
	private String searchType;
	/**
	 * 诉讼当事人
	 */
	private String litigant;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 关联名单
	 */
	private String connList;
	/**
	 * 审判者/主审人
	 */
	private String contractors;
	/**
	 * 事件时间
	 */
	private String eventTime;

	/**
	 * 设置：开庭日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 获取：开庭日期
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * 设置：原告/上诉人
	 */
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}

	/**
	 * 获取：原告/上诉人
	 */
	public String getPlaintiff() {
		return plaintiff;
	}

	/**
	 * 设置：被告/被上诉人
	 */
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}

	/**
	 * 获取：被告/被上诉人
	 */
	public String getDefendant() {
		return defendant;
	}

	/**
	 * 设置：案件原由
	 */
	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}

	/**
	 * 获取：案件原由
	 */
	public String getCaseReason() {
		return caseReason;
	}

	/**
	 * 设置：法庭
	 */
	public void setCourtroom(String courtroom) {
		this.courtroom = courtroom;
	}

	/**
	 * 获取：法庭
	 */
	public String getCourtroom() {
		return courtroom;
	}

	/**
	 * 设置：案件编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * 获取：案件编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * 设置：法院
	 */
	public void setCourt(String court) {
		this.court = court;
	}

	/**
	 * 获取：法院
	 */
	public String getCourt() {
		return court;
	}

	/**
	 * 设置：事件ID
	 */
	public void setAId(String aId) {
		this.aId = aId;
	}

	/**
	 * 获取：事件ID
	 */
	public String getAId() {
		return aId;
	}

	/**
	 * 设置：搜索类别
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * 获取：搜索类别
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * 设置：诉讼当事人
	 */
	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}

	/**
	 * 获取：诉讼当事人
	 */
	public String getLitigant() {
		return litigant;
	}

	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：关联名单
	 */
	public void setConnList(String connList) {
		this.connList = connList;
	}

	/**
	 * 获取：关联名单
	 */
	public String getConnList() {
		return connList;
	}

	/**
	 * 设置：审判者/主审人
	 */
	public void setContractors(String contractors) {
		this.contractors = contractors;
	}

	/**
	 * 获取：审判者/主审人
	 */
	public String getContractors() {
		return contractors;
	}

	/**
	 * 设置：事件时间
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * 获取：事件时间
	 */
	public String getEventTime() {
		return eventTime;
	}
}
