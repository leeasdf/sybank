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
 * @date 2019-03-21 17:00:10
 */
@TableName("ENT_ANNUALREPORT_OUT_GUARANTEE_INFO")
public class EntAnnualreportOutGuaranteeInfoEntity implements Serializable {
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
	private String belongYear;
	/**
	 * 
	 */
	private String reportYear;
	/**
	 * 
	 */
	private String creditor;
	/**
	 * 
	 */
	private String obligor;
	/**
	 * 
	 */
	private String creditoType;
	/**
	 * 
	 */
	private String creditoAmount;
	/**
	 * 
	 */
	private String creditoTerm;
	/**
	 * 
	 */
	private String guaranteeTerm;
	/**
	 * 
	 */
	private String guaranteeWay;
	/**
	 * 
	 */
	private String guaranteeScope;
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
	public void setBelongYear(String belongYear) {
		this.belongYear = belongYear;
	}
	/**
	 * 获取：
	 */
	public String getBelongYear() {
		return belongYear;
	}
	/**
	 * 设置：
	 */
	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}
	/**
	 * 获取：
	 */
	public String getReportYear() {
		return reportYear;
	}
	/**
	 * 设置：
	 */
	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}
	/**
	 * 获取：
	 */
	public String getCreditor() {
		return creditor;
	}
	/**
	 * 设置：
	 */
	public void setObligor(String obligor) {
		this.obligor = obligor;
	}
	/**
	 * 获取：
	 */
	public String getObligor() {
		return obligor;
	}
	/**
	 * 设置：
	 */
	public void setCreditoType(String creditoType) {
		this.creditoType = creditoType;
	}
	/**
	 * 获取：
	 */
	public String getCreditoType() {
		return creditoType;
	}
	/**
	 * 设置：
	 */
	public void setCreditoAmount(String creditoAmount) {
		this.creditoAmount = creditoAmount;
	}
	/**
	 * 获取：
	 */
	public String getCreditoAmount() {
		return creditoAmount;
	}
	/**
	 * 设置：
	 */
	public void setCreditoTerm(String creditoTerm) {
		this.creditoTerm = creditoTerm;
	}
	/**
	 * 获取：
	 */
	public String getCreditoTerm() {
		return creditoTerm;
	}
	/**
	 * 设置：
	 */
	public void setGuaranteeTerm(String guaranteeTerm) {
		this.guaranteeTerm = guaranteeTerm;
	}
	/**
	 * 获取：
	 */
	public String getGuaranteeTerm() {
		return guaranteeTerm;
	}
	/**
	 * 设置：
	 */
	public void setGuaranteeWay(String guaranteeWay) {
		this.guaranteeWay = guaranteeWay;
	}
	/**
	 * 获取：
	 */
	public String getGuaranteeWay() {
		return guaranteeWay;
	}
	/**
	 * 设置：
	 */
	public void setGuaranteeScope(String guaranteeScope) {
		this.guaranteeScope = guaranteeScope;
	}
	/**
	 * 获取：
	 */
	public String getGuaranteeScope() {
		return guaranteeScope;
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
