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
 * @date 2019-03-21 17:00:09
 */
@TableName("ENT_BASE_LEGAL_INFO")
public class EntBaseLegalInfoEntity implements Serializable {
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
	private String name;
	/**
	 * 
	 */
	private String hid;
	/**
	 * 
	 */
	private String headUrl;
	/**
	 * 
	 */
	private Integer companyNum;
	/**
	 * 
	 */
	private Integer partners;
	/**
	 * 
	 */
	private String cid;
	/**
	 * 
	 */
	private String typeJoin;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}
	/**
	 * 获取：
	 */
	public String getHid() {
		return hid;
	}
	/**
	 * 设置：
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	/**
	 * 获取：
	 */
	public String getHeadUrl() {
		return headUrl;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNum(Integer companyNum) {
		this.companyNum = companyNum;
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyNum() {
		return companyNum;
	}
	/**
	 * 设置：
	 */
	public void setPartners(Integer partners) {
		this.partners = partners;
	}
	/**
	 * 获取：
	 */
	public Integer getPartners() {
		return partners;
	}
	/**
	 * 设置：
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：
	 */
	public void setTypeJoin(String typeJoin) {
		this.typeJoin = typeJoin;
	}
	/**
	 * 获取：
	 */
	public String getTypeJoin() {
		return typeJoin;
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
