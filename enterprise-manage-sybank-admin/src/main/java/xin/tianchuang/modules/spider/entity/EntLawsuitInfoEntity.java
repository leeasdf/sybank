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
@TableName("ENT_LAWSUIT_INFO")
public class EntLawsuitInfoEntity implements Serializable {
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
	private String splitGids;
	/**
	 * 
	 */
	private String plaintiffs;
	/**
	 * 
	 */
	private String plaintiffId;
	/**
	 * 
	 */
	private String court;
	/**
	 * 
	 */
	private String searchType;
	/**
	 * 
	 */
	private String casereason;
	/**
	 * 
	 */
	private String uni;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private String caseno;
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
	private String docid;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String appelleeId;
	/**
	 * 
	 */
	private String abstracts;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String submittime;
	/**
	 * 
	 */
	private String defendantId;
	/**
	 * 
	 */
	private String lawsuitUrl;
	/**
	 * 
	 */
	private String casetype;
	/**
	 * 
	 */
	private String appellantId;
	/**
	 * 
	 */
	private String uuid;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String doctype;
	/**
	 * 
	 */
	private String agent;
	/**
	 * 
	 */
	private String thirdParties;
	/**
	 * 
	 */
	private String defendants;
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
	public void setSplitGids(String splitGids) {
		this.splitGids = splitGids;
	}
	/**
	 * 获取：
	 */
	public String getSplitGids() {
		return splitGids;
	}
	/**
	 * 设置：
	 */
	public void setPlaintiffs(String plaintiffs) {
		this.plaintiffs = plaintiffs;
	}
	/**
	 * 获取：
	 */
	public String getPlaintiffs() {
		return plaintiffs;
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
	public void setCasereason(String casereason) {
		this.casereason = casereason;
	}
	/**
	 * 获取：
	 */
	public String getCasereason() {
		return casereason;
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
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}
	/**
	 * 获取：
	 */
	public String getCaseno() {
		return caseno;
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
	public void setDocid(String docid) {
		this.docid = docid;
	}
	/**
	 * 获取：
	 */
	public String getDocid() {
		return docid;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setAppelleeId(String appelleeId) {
		this.appelleeId = appelleeId;
	}
	/**
	 * 获取：
	 */
	public String getAppelleeId() {
		return appelleeId;
	}
	/**
	 * 设置：
	 */
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	/**
	 * 获取：
	 */
	public String getAbstracts() {
		return abstracts;
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
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	/**
	 * 获取：
	 */
	public String getSubmittime() {
		return submittime;
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
	public void setLawsuitUrl(String lawsuitUrl) {
		this.lawsuitUrl = lawsuitUrl;
	}
	/**
	 * 获取：
	 */
	public String getLawsuitUrl() {
		return lawsuitUrl;
	}
	/**
	 * 设置：
	 */
	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}
	/**
	 * 获取：
	 */
	public String getCasetype() {
		return casetype;
	}
	/**
	 * 设置：
	 */
	public void setAppellantId(String appellantId) {
		this.appellantId = appellantId;
	}
	/**
	 * 获取：
	 */
	public String getAppellantId() {
		return appellantId;
	}
	/**
	 * 设置：
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * 获取：
	 */
	public String getUuid() {
		return uuid;
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
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	/**
	 * 获取：
	 */
	public String getDoctype() {
		return doctype;
	}
	/**
	 * 设置：
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}
	/**
	 * 获取：
	 */
	public String getAgent() {
		return agent;
	}
	/**
	 * 设置：
	 */
	public void setThirdParties(String thirdParties) {
		this.thirdParties = thirdParties;
	}
	/**
	 * 获取：
	 */
	public String getThirdParties() {
		return thirdParties;
	}
	/**
	 * 设置：
	 */
	public void setDefendants(String defendants) {
		this.defendants = defendants;
	}
	/**
	 * 获取：
	 */
	public String getDefendants() {
		return defendants;
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
