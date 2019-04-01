package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open429BidsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -738382582513210055L;
	private String purchaser;// 采购人 varchar(256)
	private String publishTime;// 发布时间 毫秒数
	private String link;// 详细信息链接 varchar(128)
	private String pid;// id
	private String searchType;// 无用
	private String uni;// 无用
	private String bidUrl;// 天眼查链接 varchar(128)
	private String intro;// 正文简介 varchar(128)
	private String content;// 正文信息 longtext
	private String uniqueHash;// 无用
	@SerializedName("id")
	private String tableId;// id
	@SerializedName("_type")
	private String type;// 无用
	private String title;// 标题 varchar(256)
	private String recordHash;// 无用
	private String abs;// 摘要信息 varchar(6000)
	private List<String> connList;// 公司列表
	private String proxy;// 代理机构 varchar(256)
	private String eventTime;// 无用
	private String uuid;// uuid

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getBidUrl() {
		return bidUrl;
	}

	public void setBidUrl(String bidUrl) {
		this.bidUrl = bidUrl;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUniqueHash() {
		return uniqueHash;
	}

	public void setUniqueHash(String uniqueHash) {
		this.uniqueHash = uniqueHash;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecordHash() {
		return recordHash;
	}

	public void setRecordHash(String recordHash) {
		this.recordHash = recordHash;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
