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
 * @date 2019-03-21 17:00:06
 */
@TableName("ENT_HOLDER_CAPITAL")
public class EntHolderCapitalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String holderName;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String amomon;
	/**
	 * 
	 */
	private String time;
	/**
	 * 
	 */
	private String percent;
	/**
	 * 
	 */
	private String paymet;
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
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	/**
	 * 获取：
	 */
	public String getHolderName() {
		return holderName;
	}
	/**
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setAmomon(String amomon) {
		this.amomon = amomon;
	}
	/**
	 * 获取：
	 */
	public String getAmomon() {
		return amomon;
	}
	/**
	 * 设置：
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 获取：
	 */
	public String getTime() {
		return time;
	}
	/**
	 * 设置：
	 */
	public void setPercent(String percent) {
		this.percent = percent;
	}
	/**
	 * 获取：
	 */
	public String getPercent() {
		return percent;
	}
	/**
	 * 设置：
	 */
	public void setPaymet(String paymet) {
		this.paymet = paymet;
	}
	/**
	 * 获取：
	 */
	public String getPaymet() {
		return paymet;
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
