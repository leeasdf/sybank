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
@TableName("ENT_MORTGAGE_BASE_INFO")
public class EntMortgageBaseInfoEntity implements Serializable {
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
	private String overviewAmount;
	/**
	 * 
	 */
	private String scope;
	/**
	 * 
	 */
	private String tmStatus;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private String regDate;
	/**
	 * 
	 */
	private String overviewType;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String cancelReason;
	/**
	 * 
	 */
	private String overviewScope;
	/**
	 * 
	 */
	private Long tableId;
	/**
	 * 
	 */
	private String amount;
	/**
	 * 
	 */
	private String overviewRemark;
	/**
	 * 
	 */
	private String overviewTerm;
	/**
	 * 
	 */
	private String regDepartment;
	/**
	 * 
	 */
	private String regNum;
	/**
	 * 
	 */
	private String term;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	private Long cancelDate;
	/**
	 * 
	 */
	private Long publishDate;
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
	public void setOverviewAmount(String overviewAmount) {
		this.overviewAmount = overviewAmount;
	}
	/**
	 * 获取：
	 */
	public String getOverviewAmount() {
		return overviewAmount;
	}
	/**
	 * 设置：
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * 获取：
	 */
	public String getScope() {
		return scope;
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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	/**
	 * 获取：
	 */
	public String getRegDate() {
		return regDate;
	}
	/**
	 * 设置：
	 */
	public void setOverviewType(String overviewType) {
		this.overviewType = overviewType;
	}
	/**
	 * 获取：
	 */
	public String getOverviewType() {
		return overviewType;
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
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	/**
	 * 获取：
	 */
	public String getCancelReason() {
		return cancelReason;
	}
	/**
	 * 设置：
	 */
	public void setOverviewScope(String overviewScope) {
		this.overviewScope = overviewScope;
	}
	/**
	 * 获取：
	 */
	public String getOverviewScope() {
		return overviewScope;
	}
	/**
	 * 设置：
	 */
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public Long getTableId() {
		return tableId;
	}
	/**
	 * 设置：
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setOverviewRemark(String overviewRemark) {
		this.overviewRemark = overviewRemark;
	}
	/**
	 * 获取：
	 */
	public String getOverviewRemark() {
		return overviewRemark;
	}
	/**
	 * 设置：
	 */
	public void setOverviewTerm(String overviewTerm) {
		this.overviewTerm = overviewTerm;
	}
	/**
	 * 获取：
	 */
	public String getOverviewTerm() {
		return overviewTerm;
	}
	/**
	 * 设置：
	 */
	public void setRegDepartment(String regDepartment) {
		this.regDepartment = regDepartment;
	}
	/**
	 * 获取：
	 */
	public String getRegDepartment() {
		return regDepartment;
	}
	/**
	 * 设置：
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	/**
	 * 获取：
	 */
	public String getRegNum() {
		return regNum;
	}
	/**
	 * 设置：
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * 获取：
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * 设置：
	 */
	public void setBase(String base) {
		this.base = base;
	}
	/**
	 * 获取：
	 */
	public String getBase() {
		return base;
	}
	/**
	 * 设置：
	 */
	public void setCancelDate(Long cancelDate) {
		this.cancelDate = cancelDate;
	}
	/**
	 * 获取：
	 */
	public Long getCancelDate() {
		return cancelDate;
	}
	/**
	 * 设置：
	 */
	public void setPublishDate(Long publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：
	 */
	public Long getPublishDate() {
		return publishDate;
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
