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
 * @date 2019-03-21 17:00:07
 */
@TableName("ENT_COPY_REG")
public class EntCopyRegEntity implements Serializable {
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
	private String tableId;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String regtime;
	/**
	 * 
	 */
	private String publishtime;
	/**
	 * 
	 */
	private String authorNationality;
	/**
	 * 
	 */
	private String simplename;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String regnum;
	/**
	 * 
	 */
	private String catnum;
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
	private String eventTime;
	/**
	 * 
	 */
	private String fullname;
	/**
	 * 
	 */
	private String regVersion;
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
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	/**
	 * 获取：
	 */
	public String getRegtime() {
		return regtime;
	}
	/**
	 * 设置：
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * 获取：
	 */
	public String getPublishtime() {
		return publishtime;
	}
	/**
	 * 设置：
	 */
	public void setAuthorNationality(String authorNationality) {
		this.authorNationality = authorNationality;
	}
	/**
	 * 获取：
	 */
	public String getAuthorNationality() {
		return authorNationality;
	}
	/**
	 * 设置：
	 */
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	/**
	 * 获取：
	 */
	public String getSimplename() {
		return simplename;
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
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	/**
	 * 获取：
	 */
	public String getRegnum() {
		return regnum;
	}
	/**
	 * 设置：
	 */
	public void setCatnum(String catnum) {
		this.catnum = catnum;
	}
	/**
	 * 获取：
	 */
	public String getCatnum() {
		return catnum;
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
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * 获取：
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * 设置：
	 */
	public void setRegVersion(String regVersion) {
		this.regVersion = regVersion;
	}
	/**
	 * 获取：
	 */
	public String getRegVersion() {
		return regVersion;
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
