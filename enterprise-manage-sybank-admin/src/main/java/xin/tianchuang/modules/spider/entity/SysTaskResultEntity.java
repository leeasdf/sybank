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
 * @date 2019-03-21 17:39:28
 */
@TableName("SYS_TASK_RESULT")
public class SysTaskResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String interfaceType;
	/**
	 * 
	 */
	private Integer count;
	/**
	 * 
	 */
	private Integer sucessCount;
	/**
	 * 
	 */
	private Integer errorCount;
	/**
	 * 
	 */
	private Integer unknownCount;
	/**
	 * 
	 */
	private String errorEntId;
	/**
	 * 
	 */
	private String unknownEntId;
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
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	/**
	 * 获取：
	 */
	public String getInterfaceType() {
		return interfaceType;
	}
	/**
	 * 设置：
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：
	 */
	public void setSucessCount(Integer sucessCount) {
		this.sucessCount = sucessCount;
	}
	/**
	 * 获取：
	 */
	public Integer getSucessCount() {
		return sucessCount;
	}
	/**
	 * 设置：
	 */
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
	/**
	 * 获取：
	 */
	public Integer getErrorCount() {
		return errorCount;
	}
	/**
	 * 设置：
	 */
	public void setUnknownCount(Integer unknownCount) {
		this.unknownCount = unknownCount;
	}
	/**
	 * 获取：
	 */
	public Integer getUnknownCount() {
		return unknownCount;
	}
	/**
	 * 设置：
	 */
	public void setErrorEntId(String errorEntId) {
		this.errorEntId = errorEntId;
	}
	/**
	 * 获取：
	 */
	public String getErrorEntId() {
		return errorEntId;
	}
	/**
	 * 设置：
	 */
	public void setUnknownEntId(String unknownEntId) {
		this.unknownEntId = unknownEntId;
	}
	/**
	 * 获取：
	 */
	public String getUnknownEntId() {
		return unknownEntId;
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
