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
 * @date 2019-03-21 17:00:04
 */
@TableName("ENT_PATENTS_INFO")
public class EntPatentsInfoEntity implements Serializable {
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
	private String mainCatNum;
	/**
	 * 
	 */
	private String patentsCreateTime;
	/**
	 * 
	 */
	private String pubnumber;
	/**
	 * 
	 */
	private String searchType;
	/**
	 * 
	 */
	private String appnumber;
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
	private String title;
	/**
	 * 
	 */
	private String patentName;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String applicationTime;
	/**
	 * 
	 */
	private String applicantname;
	/**
	 * 
	 */
	private String patentType;
	/**
	 * 
	 */
	private String pubDate;
	/**
	 * 
	 */
	private String applicationPublishNum;
	/**
	 * 
	 */
	private String agency;
	/**
	 * 
	 */
	private String uni;
	/**
	 * 
	 */
	private String inventor;
	/**
	 * 
	 */
	private String agent;
	/**
	 * 
	 */
	private String applicationPublishTime;
	/**
	 * 
	 */
	private String patentNum;
	/**
	 * 
	 */
	private String imgUrl;
	/**
	 * 
	 */
	private String allCatNum;
	/**
	 * 
	 */
	private String abstracts;
	/**
	 * 
	 */
	private String address;
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
	private String applicantName;
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
	public void setMainCatNum(String mainCatNum) {
		this.mainCatNum = mainCatNum;
	}
	/**
	 * 获取：
	 */
	public String getMainCatNum() {
		return mainCatNum;
	}
	/**
	 * 设置：
	 */
	public void setPatentsCreateTime(String patentsCreateTime) {
		this.patentsCreateTime = patentsCreateTime;
	}
	/**
	 * 获取：
	 */
	public String getPatentsCreateTime() {
		return patentsCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setPubnumber(String pubnumber) {
		this.pubnumber = pubnumber;
	}
	/**
	 * 获取：
	 */
	public String getPubnumber() {
		return pubnumber;
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
	public void setAppnumber(String appnumber) {
		this.appnumber = appnumber;
	}
	/**
	 * 获取：
	 */
	public String getAppnumber() {
		return appnumber;
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
	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}
	/**
	 * 获取：
	 */
	public String getPatentName() {
		return patentName;
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
	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}
	/**
	 * 获取：
	 */
	public String getApplicationTime() {
		return applicationTime;
	}
	/**
	 * 设置：
	 */
	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}
	/**
	 * 获取：
	 */
	public String getApplicantname() {
		return applicantname;
	}
	/**
	 * 设置：
	 */
	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}
	/**
	 * 获取：
	 */
	public String getPatentType() {
		return patentType;
	}
	/**
	 * 设置：
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * 获取：
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * 设置：
	 */
	public void setApplicationPublishNum(String applicationPublishNum) {
		this.applicationPublishNum = applicationPublishNum;
	}
	/**
	 * 获取：
	 */
	public String getApplicationPublishNum() {
		return applicationPublishNum;
	}
	/**
	 * 设置：
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}
	/**
	 * 获取：
	 */
	public String getAgency() {
		return agency;
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
	public void setInventor(String inventor) {
		this.inventor = inventor;
	}
	/**
	 * 获取：
	 */
	public String getInventor() {
		return inventor;
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
	public void setApplicationPublishTime(String applicationPublishTime) {
		this.applicationPublishTime = applicationPublishTime;
	}
	/**
	 * 获取：
	 */
	public String getApplicationPublishTime() {
		return applicationPublishTime;
	}
	/**
	 * 设置：
	 */
	public void setPatentNum(String patentNum) {
		this.patentNum = patentNum;
	}
	/**
	 * 获取：
	 */
	public String getPatentNum() {
		return patentNum;
	}
	/**
	 * 设置：
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：
	 */
	public void setAllCatNum(String allCatNum) {
		this.allCatNum = allCatNum;
	}
	/**
	 * 获取：
	 */
	public String getAllCatNum() {
		return allCatNum;
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
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
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
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	/**
	 * 获取：
	 */
	public String getApplicantName() {
		return applicantName;
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
