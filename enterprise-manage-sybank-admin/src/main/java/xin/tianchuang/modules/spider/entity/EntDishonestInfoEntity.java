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
@TableName("ENT_DISHONEST_INFO")
public class EntDishonestInfoEntity implements Serializable {
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
	private String iname;
	/**
	 * 
	 */
	private String businessentity;
	/**
	 * 
	 */
	private String gistid;
	/**
	 * 
	 */
	private String areaname;
	/**
	 * 
	 */
	private String cardnum;
	/**
	 * 
	 */
	private String courtname;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private Long publishdate;
	/**
	 * 
	 */
	private String performedPart;
	/**
	 * 
	 */
	private String staff;
	/**
	 * 
	 */
	private String gistunit;
	/**
	 * 
	 */
	private String unperformPart;
	/**
	 * 
	 */
	private String duty;
	/**
	 * 
	 */
	private String performance;
	/**
	 * 
	 */
	private Long regdate;
	/**
	 * 
	 */
	private String casecode;
	/**
	 * 
	 */
	private String disrupttypename;
	/**
	 * 
	 */
	private String cpwsUrl;
	/**
	 * 
	 */
	private String tycId;
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
	public void setIname(String iname) {
		this.iname = iname;
	}
	/**
	 * 获取：
	 */
	public String getIname() {
		return iname;
	}
	/**
	 * 设置：
	 */
	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}
	/**
	 * 获取：
	 */
	public String getBusinessentity() {
		return businessentity;
	}
	/**
	 * 设置：
	 */
	public void setGistid(String gistid) {
		this.gistid = gistid;
	}
	/**
	 * 获取：
	 */
	public String getGistid() {
		return gistid;
	}
	/**
	 * 设置：
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	/**
	 * 获取：
	 */
	public String getAreaname() {
		return areaname;
	}
	/**
	 * 设置：
	 */
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	/**
	 * 获取：
	 */
	public String getCardnum() {
		return cardnum;
	}
	/**
	 * 设置：
	 */
	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}
	/**
	 * 获取：
	 */
	public String getCourtname() {
		return courtname;
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
	public void setPublishdate(Long publishdate) {
		this.publishdate = publishdate;
	}
	/**
	 * 获取：
	 */
	public Long getPublishdate() {
		return publishdate;
	}
	/**
	 * 设置：
	 */
	public void setPerformedPart(String performedPart) {
		this.performedPart = performedPart;
	}
	/**
	 * 获取：
	 */
	public String getPerformedPart() {
		return performedPart;
	}
	/**
	 * 设置：
	 */
	public void setStaff(String staff) {
		this.staff = staff;
	}
	/**
	 * 获取：
	 */
	public String getStaff() {
		return staff;
	}
	/**
	 * 设置：
	 */
	public void setGistunit(String gistunit) {
		this.gistunit = gistunit;
	}
	/**
	 * 获取：
	 */
	public String getGistunit() {
		return gistunit;
	}
	/**
	 * 设置：
	 */
	public void setUnperformPart(String unperformPart) {
		this.unperformPart = unperformPart;
	}
	/**
	 * 获取：
	 */
	public String getUnperformPart() {
		return unperformPart;
	}
	/**
	 * 设置：
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}
	/**
	 * 获取：
	 */
	public String getDuty() {
		return duty;
	}
	/**
	 * 设置：
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	/**
	 * 获取：
	 */
	public String getPerformance() {
		return performance;
	}
	/**
	 * 设置：
	 */
	public void setRegdate(Long regdate) {
		this.regdate = regdate;
	}
	/**
	 * 获取：
	 */
	public Long getRegdate() {
		return regdate;
	}
	/**
	 * 设置：
	 */
	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}
	/**
	 * 获取：
	 */
	public String getCasecode() {
		return casecode;
	}
	/**
	 * 设置：
	 */
	public void setDisrupttypename(String disrupttypename) {
		this.disrupttypename = disrupttypename;
	}
	/**
	 * 获取：
	 */
	public String getDisrupttypename() {
		return disrupttypename;
	}
	/**
	 * 设置：
	 */
	public void setCpwsUrl(String cpwsUrl) {
		this.cpwsUrl = cpwsUrl;
	}
	/**
	 * 获取：
	 */
	public String getCpwsUrl() {
		return cpwsUrl;
	}
	/**
	 * 设置：
	 */
	public void setTycId(String tycId) {
		this.tycId = tycId;
	}
	/**
	 * 获取：
	 */
	public String getTycId() {
		return tycId;
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
