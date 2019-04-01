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
@TableName("ENT_ZHIXING_INFO")
public class EntZhixingInfoEntity implements Serializable {
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
	private String caseCode;
	/**
	 * 
	 */
	private String execCourtName;
	/**
	 * 
	 */
	private String pname;
	/**
	 * 
	 */
	private String partyCardNum;
	/**
	 * 
	 */
	private Long caseCreateTime;
	/**
	 * 
	 */
	private String execMoney;
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
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	/**
	 * 获取：
	 */
	public String getCaseCode() {
		return caseCode;
	}
	/**
	 * 设置：
	 */
	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}
	/**
	 * 获取：
	 */
	public String getExecCourtName() {
		return execCourtName;
	}
	/**
	 * 设置：
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * 获取：
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 设置：
	 */
	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}
	/**
	 * 获取：
	 */
	public String getPartyCardNum() {
		return partyCardNum;
	}
	/**
	 * 设置：
	 */
	public void setCaseCreateTime(Long caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}
	/**
	 * 获取：
	 */
	public Long getCaseCreateTime() {
		return caseCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}
	/**
	 * 获取：
	 */
	public String getExecMoney() {
		return execMoney;
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
