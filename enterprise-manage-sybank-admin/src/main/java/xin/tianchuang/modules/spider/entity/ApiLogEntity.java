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
 * @date 2019-03-21 17:39:29
 */
@TableName("API_LOG")
public class ApiLogEntity implements Serializable {
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
	private String creditCode;
	/**
	 * 
	 */
	private String seqNum;
	/**
	 * 
	 */
	private String bizCode;
	/**
	 * 
	 */
	private String channelType;
	/**
	 * 
	 */
	private String interfaceType;
	/**
	 * 
	 */
	private String reqInfo;
	/**
	 * 
	 */
	private String responseInfo;
	/**
	 * 
	 */
	private String responseCode;
	/**
	 * 
	 */
	private String responseMsg;
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private String errorMsg;
	/**
	 * 
	 */
	private Date successFailTime;
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
	 * 
	 */
	private Integer retryTimes;

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
	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	/**
	 * 获取：
	 */
	public String getSeqNum() {
		return seqNum;
	}
	/**
	 * 设置：
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	/**
	 * 获取：
	 */
	public String getBizCode() {
		return bizCode;
	}
	/**
	 * 设置：
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * 获取：
	 */
	public String getChannelType() {
		return channelType;
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
	public void setReqInfo(String reqInfo) {
		this.reqInfo = reqInfo;
	}
	/**
	 * 获取：
	 */
	public String getReqInfo() {
		return reqInfo;
	}
	/**
	 * 设置：
	 */
	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}
	/**
	 * 获取：
	 */
	public String getResponseInfo() {
		return responseInfo;
	}
	/**
	 * 设置：
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * 获取：
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * 设置：
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	/**
	 * 获取：
	 */
	public String getResponseMsg() {
		return responseMsg;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * 获取：
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 设置：
	 */
	public void setSuccessFailTime(Date successFailTime) {
		this.successFailTime = successFailTime;
	}
	/**
	 * 获取：
	 */
	public Date getSuccessFailTime() {
		return successFailTime;
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
	/**
	 * 设置：
	 */
	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
	/**
	 * 获取：
	 */
	public Integer getRetryTimes() {
		return retryTimes;
	}
}
