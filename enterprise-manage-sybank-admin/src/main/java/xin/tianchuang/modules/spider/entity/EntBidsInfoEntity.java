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
 * @date 2019-03-21 17:00:08
 */
@TableName("ENT_BIDS_INFO")
public class EntBidsInfoEntity implements Serializable {
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
	private String purchaser;
	/**
	 * 
	 */
	private String publishTime;
	/**
	 * 
	 */
	private String link;
	/**
	 * 
	 */
	private String pid;
	/**
	 * 
	 */
	private String searchType;
	/**
	 * 
	 */
	private String uni;
	/**
	 * 
	 */
	private String bidUrl;
	/**
	 * 
	 */
	private String intro;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String uniqueHash;
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
	private String recordHash;
	/**
	 * 
	 */
	private String abs;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String proxy;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String uuid;
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
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	/**
	 * 获取：
	 */
	public String getPurchaser() {
		return purchaser;
	}
	/**
	 * 设置：
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：
	 */
	public String getPublishTime() {
		return publishTime;
	}
	/**
	 * 设置：
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * 获取：
	 */
	public String getLink() {
		return link;
	}
	/**
	 * 设置：
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public String getPid() {
		return pid;
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
	public void setBidUrl(String bidUrl) {
		this.bidUrl = bidUrl;
	}
	/**
	 * 获取：
	 */
	public String getBidUrl() {
		return bidUrl;
	}
	/**
	 * 设置：
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setUniqueHash(String uniqueHash) {
		this.uniqueHash = uniqueHash;
	}
	/**
	 * 获取：
	 */
	public String getUniqueHash() {
		return uniqueHash;
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
	public void setRecordHash(String recordHash) {
		this.recordHash = recordHash;
	}
	/**
	 * 获取：
	 */
	public String getRecordHash() {
		return recordHash;
	}
	/**
	 * 设置：
	 */
	public void setAbs(String abs) {
		this.abs = abs;
	}
	/**
	 * 获取：
	 */
	public String getAbs() {
		return abs;
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
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	/**
	 * 获取：
	 */
	public String getProxy() {
		return proxy;
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
