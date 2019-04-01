package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open441CopyRegDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5840864661604618175L;
	@SerializedName("id")
	private String tableId;// 对应表id
	@SerializedName("_type")
	private String type;// 无用
	private String regtime;// 登记日期 毫秒数
	private String publishtime;// 首次发表日期
	private String authorNationality;// 著作权人 varchar(255)
	private String simplename;// 简称 varchar(200)
	private List<String> connList;// 跳转到天眼查链接
	private String regnum;// 登记号 varchar(45)
	private String catnum;// 分类号 varchar(45)
	private String searchType;// 无用
	private String uni;// 唯一标识符 varchar(45)
	private String eventTime;// 批准日期 毫秒数
	private String fullname;// 全称 varchar(200)
	@SerializedName("version")
	private String regVersion;// 版本号 varchar(45)

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

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getAuthorNationality() {
		return authorNationality;
	}

	public void setAuthorNationality(String authorNationality) {
		this.authorNationality = authorNationality;
	}

	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	public List<String> getConnList() {
		return connList;
	}

	public void setConnList(List<String> connList) {
		this.connList = connList;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getCatnum() {
		return catnum;
	}

	public void setCatnum(String catnum) {
		this.catnum = catnum;
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

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRegVersion() {
		return regVersion;
	}

	public void setRegVersion(String regVersion) {
		this.regVersion = regVersion;
	}

}
