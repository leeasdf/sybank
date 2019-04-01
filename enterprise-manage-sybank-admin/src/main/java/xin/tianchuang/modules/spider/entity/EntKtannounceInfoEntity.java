package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:05
 */
@TableName("ENT_KTANNOUNCE_INFO")
public class EntKtannounceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer entId;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String creditCode;
	/**
	 * 
	 */
	private String startDate;
	/**
	 * 
	 */
	private String plaintiffId;
	/**
	 * 
	 */
	private String courtroom;
	/**
	 * 
	 */
	private String caseReason;
	/**
	 * 
	 */
	private String court;
	/**
	 * 
	 */
	private String uni;
	/**
	 * 
	 */
	private String searchType;
	/**
	 * 
	 */
	private String litigant;
	/**
	 * 
	 */
	private String tableId;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String judge;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String defendantId;
	/**
	 * 
	 */
	private String contractors;
	/**
	 * 
	 */
	private String caseNo;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 
	 */
	@TableField(value = "data_status", fill = FieldFill.INSERT)
	private Integer dataStatus;
	/**
	 * 
	 */
	@Version
	private Integer version;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setEntId(Integer entId) {
		this.entId = entId;
	}
	/**
	 * 获取：
	 */
	public Integer getEntId() {
		return entId;
	}
	/**
	 * 设置：
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：
	 */
	public void setPlaintiffId(String plaintiffId) {
		this.plaintiffId = plaintiffId;
	}
	/**
	 * 获取：
	 */
	public String getPlaintiffId() {
		return plaintiffId;
	}
	/**
	 * 设置：
	 */
	public void setCourtroom(String courtroom) {
		this.courtroom = courtroom;
	}
	/**
	 * 获取：
	 */
	public String getCourtroom() {
		return courtroom;
	}
	/**
	 * 设置：
	 */
	public void setCaseReason(String caseReason) {
		this.caseReason = caseReason;
	}
	/**
	 * 获取：
	 */
	public String getCaseReason() {
		return caseReason;
	}
	/**
	 * 设置：
	 */
	public void setCourt(String court) {
		this.court = court;
	}
	/**
	 * 获取：
	 */
	public String getCourt() {
		return court;
	}
	/**
	 * 设置：
	 */
	public void setUni(String uni) {
		this.uni = uni;
	}
	/**
	 * 获取：
	 */
	public String getUni() {
		return uni;
	}
	/**
	 * 设置：
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * 获取：
	 */
	public String getSearchType() {
		return searchType;
	}
	/**
	 * 设置：
	 */
	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}
	/**
	 * 获取：
	 */
	public String getLitigant() {
		return litigant;
	}
	/**
	 * 设置：
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public String getTableId() {
		return tableId;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setJudge(String judge) {
		this.judge = judge;
	}
	/**
	 * 获取：
	 */
	public String getJudge() {
		return judge;
	}
	/**
	 * 设置：
	 */
	public void setConnList(String connList) {
		this.connList = connList;
	}
	/**
	 * 获取：
	 */
	public String getConnList() {
		return connList;
	}
	/**
	 * 设置：
	 */
	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}
	/**
	 * 获取：
	 */
	public String getDefendantId() {
		return defendantId;
	}
	/**
	 * 设置：
	 */
	public void setContractors(String contractors) {
		this.contractors = contractors;
	}
	/**
	 * 获取：
	 */
	public String getContractors() {
		return contractors;
	}
	/**
	 * 设置：
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	/**
	 * 获取：
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 设置：
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	/**
	 * 获取：
	 */
	public String getEventTime() {
		return eventTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}
