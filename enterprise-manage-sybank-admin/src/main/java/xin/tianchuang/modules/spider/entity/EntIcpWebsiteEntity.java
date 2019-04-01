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
@TableName("ENT_ICP_WEBSITE")
@Deprecated
public class EntIcpWebsiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Long icpId;
	/**
	 * 
	 */
	private String website;
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
	public void setIcpId(Long icpId) {
		this.icpId = icpId;
	}

	/**
	 * 获取：
	 */
	public Long getIcpId() {
		return icpId;
	}

	/**
	 * 设置：
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * 获取：
	 */
	public String getWebsite() {
		return website;
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
