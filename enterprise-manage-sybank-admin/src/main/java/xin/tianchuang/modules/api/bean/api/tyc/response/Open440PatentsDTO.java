package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

public class Open440PatentsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5558976181261966243L;
	private String mainCatNum;// 主分类号
	@SerializedName("createTime")
	@JSONField(name = "createTime")
	private String patentsCreateTime;// 创建时间 ()毫秒数
	private String pubnumber;// 申请公布号
	private String searchType;// 无用
	private String appnumber;// 申请号
	@SerializedName("id")
	@JSONField(name = "id")
	private String tableId;// 对应表id
	@SerializedName("_type")
	@JSONField(name = "_type")
	private String type;// 无用
	private String title;// 名称
	private String patentName;// 专利名称
	private List<String> connList;// 跳转到天眼查链接
	@SerializedName("_child")
	@JSONField(name = "_child")
	private String child;//
	private String applicationTime;// 申请日
	private String applicantname;// 申请人
	private String patentType;// 专利类型
	private String pubDate;// 公开公告日
	private String applicationPublishNum;// 申请公布号（废弃）
	private String agency;// 代理机构
	private String uni;// 唯一标识符
	private String inventor;// 发明人
	private String agent;// 代理人
	private String applicationPublishTime;// 申请公布日
	private String patentNum;// 申请号/专利号
	private String imgUrl;// 图片url
	private String allCatNum;// 全部分类号
	private String abstracts;// 摘要
	private String address;// 地址
	private String uuid;// uuid
	private String eventTime;// 无用
	private String applicantName;// 申请人

	public String getMainCatNum() {
		return mainCatNum;
	}

	public void setMainCatNum(String mainCatNum) {
		this.mainCatNum = mainCatNum;
	}

	public String getPatentsCreateTime() {
		return patentsCreateTime;
	}

	public void setPatentsCreateTime(String patentsCreateTime) {
		this.patentsCreateTime = patentsCreateTime;
	}

	public String getPubnumber() {
		return pubnumber;
	}

	public void setPubnumber(String pubnumber) {
		this.pubnumber = pubnumber;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getAppnumber() {
		return appnumber;
	}

	public void setAppnumber(String appnumber) {
		this.appnumber = appnumber;
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

	public String getPatentName() {
		return patentName;
	}

	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	public String getPatentType() {
		return patentType;
	}

	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getApplicationPublishNum() {
		return applicationPublishNum;
	}

	public void setApplicationPublishNum(String applicationPublishNum) {
		this.applicationPublishNum = applicationPublishNum;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getInventor() {
		return inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getApplicationPublishTime() {
		return applicationPublishTime;
	}

	public void setApplicationPublishTime(String applicationPublishTime) {
		this.applicationPublishTime = applicationPublishTime;
	}

	public String getPatentNum() {
		return patentNum;
	}

	public void setPatentNum(String patentNum) {
		this.patentNum = patentNum;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAllCatNum() {
		return allCatNum;
	}

	public void setAllCatNum(String allCatNum) {
		this.allCatNum = allCatNum;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

}
