package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open384LawSuitDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 289969281032517528L;
	@SerializedName("SplitGids")
	private String splitGids;// 相关公司id
	private String plaintiffs;// 原告 varchar(150)
	private String plaintiffId;// 原告id
	private String court;// 法院 varchar(100)
	private String searchType;// 无用
	private String casereason;// 案由 varchar(500)
	private String uni;// 无用
	private String url;// 原文链接地址 varchar(150)
	private String caseno;// 案号 varchar(1000)
	@SerializedName("id")
	private String tableId;// 对应表id
	@SerializedName("_type")
	private String type;// 无用
	private String docid;// 无用
	private String title;// 标题 varchar(2000)
	private String appelleeId;// 无用
	private String abstracts;// 摘要 longtext
	private List<String> connList;// 公司列表
	private String submittime;// 发布时间 毫秒数
	private String defendantId;// 被告id
	private String lawsuitUrl;// 天眼查显示url varchar(150)
	private String casetype;// 案件类型 varchar(50)
	private String appellantId;// 无用
	private String uuid;// uuid
	private String eventTime;// 无用
	private String doctype;// 文书类型 varchar(1000)
	private String agent;// 代理人 varchar(255)
	private String thirdParties;// 第三人 varchar(255)
	private String defendants;// 被告
	private Number num;// 无用
	private Number pageNum;// 当前页

	public String getSplitGids() {
		return splitGids;
	}

	public void setSplitGids(String splitGids) {
		this.splitGids = splitGids;
	}

	public String getPlaintiffs() {
		return plaintiffs;
	}

	public void setPlaintiffs(String plaintiffs) {
		this.plaintiffs = plaintiffs;
	}

	public String getPlaintiffId() {
		return plaintiffId;
	}

	public void setPlaintiffId(String plaintiffId) {
		this.plaintiffId = plaintiffId;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getCasereason() {
		return casereason;
	}

	public void setCasereason(String casereason) {
		this.casereason = casereason;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
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

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAppelleeId() {
		return appelleeId;
	}

	public void setAppelleeId(String appelleeId) {
		this.appelleeId = appelleeId;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getSubmittime() {
		return submittime;
	}

	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}

	public String getDefendantId() {
		return defendantId;
	}

	public void setDefendantId(String defendantId) {
		this.defendantId = defendantId;
	}

	public String getLawsuitUrl() {
		return lawsuitUrl;
	}

	public void setLawsuitUrl(String lawsuitUrl) {
		this.lawsuitUrl = lawsuitUrl;
	}

	public String getCasetype() {
		return casetype;
	}

	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}

	public String getAppellantId() {
		return appellantId;
	}

	public void setAppellantId(String appellantId) {
		this.appellantId = appellantId;
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

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(String thirdParties) {
		this.thirdParties = thirdParties;
	}

	public String getDefendants() {
		return defendants;
	}

	public void setDefendants(String defendants) {
		this.defendants = defendants;
	}

	public Number getNum() {
		return num;
	}

	public void setNum(Number num) {
		this.num = num;
	}

	public Number getPageNum() {
		return pageNum;
	}

	public void setPageNum(Number pageNum) {
		this.pageNum = pageNum;
	}

}
