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
 * @date 2019-03-21 17:00:02
 */
@TableName("ENT_TM_INFO")
public class EntTmInfoEntity implements Serializable {
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
	private String tmStatus;
	/**
	 * 
	 */
	private String tmClass;
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
	private String tmName;
	/**
	 * 
	 */
	private String tmId;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String intCls;
	/**
	 * 
	 */
	private String tmFlow;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String tmPic;
	/**
	 * 
	 */
	private String connList;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String appDate;
	/**
	 * 
	 */
	private String regNo;
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
	public void setTmStatus(String tmStatus) {
		this.tmStatus = tmStatus;
	}
	/**
	 * 获取：
	 */
	public String getTmStatus() {
		return tmStatus;
	}
	/**
	 * 设置：
	 */
	public void setTmClass(String tmClass) {
		this.tmClass = tmClass;
	}
	/**
	 * 获取：
	 */
	public String getTmClass() {
		return tmClass;
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
	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
	/**
	 * 获取：
	 */
	public String getTmName() {
		return tmName;
	}
	/**
	 * 设置：
	 */
	public void setTmId(String tmId) {
		this.tmId = tmId;
	}
	/**
	 * 获取：
	 */
	public String getTmId() {
		return tmId;
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
	public void setIntCls(String intCls) {
		this.intCls = intCls;
	}
	/**
	 * 获取：
	 */
	public String getIntCls() {
		return intCls;
	}
	/**
	 * 设置：
	 */
	public void setTmFlow(String tmFlow) {
		this.tmFlow = tmFlow;
	}
	/**
	 * 获取：
	 */
	public String getTmFlow() {
		return tmFlow;
	}
	/**
	 * 设置：
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：
	 */
	public void setTmPic(String tmPic) {
		this.tmPic = tmPic;
	}
	/**
	 * 获取：
	 */
	public String getTmPic() {
		return tmPic;
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
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	/**
	 * 获取：
	 */
	public String getAppDate() {
		return appDate;
	}
	/**
	 * 设置：
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * 获取：
	 */
	public String getRegNo() {
		return regNo;
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
