package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业-债券信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */

public class RptTnBondDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8628178885513313953L;
	/**
	 * 债券ID
	 */
	private String bId;
	/**
	 * 债券名称
	 */
	private String bondName;
	/**
	 * 债券代码
	 */
	private String bondNum;
	/**
	 * 发行人
	 */
	private String publisherName;
	/**
	 * 债券类型
	 */
	private String bondType;
	/**
	 * 发行日期
	 */
	private String publishTime;
	/**
	 * 债劵到期日
	 */
	private String publishExpireTime;
	/**
	 * 债劵期限
	 */
	private String bondTimeLimit;
	/**
	 * 上市交易日
	 */
	private String bondTradeTime;
	/**
	 * 计息方式
	 */
	private String calInterestType;
	/**
	 * 债劵摘牌日
	 */
	private String bondStopTime;
	/**
	 * 信用评级机构
	 */
	private String creditRatingGov;
	/**
	 * 债项评级
	 */
	private String debtRating;
	/**
	 * 面值（元）
	 */
	private String faceValue;
	/**
	 * 参考利率（％）
	 */
	private String refInterestRate;
	/**
	 * 票面利率（％）
	 */
	private String faceInterestRate;
	/**
	 * 实际发行量（亿）
	 */
	private String realIssuedQuantity;
	/**
	 * 计划发行量（亿）
	 */
	private String planIssuedQuantity;
	/**
	 * 发行价格（元）
	 */
	private String issuedPrice;
	/**
	 * 利差（BP）
	 */
	private String interestDiff;
	/**
	 * 付息频率
	 */
	private String payInterestHz;
	/**
	 * 债劵起息日
	 */
	private String startCalInterestTime;
	/**
	 * 行权类型
	 */
	private String exeRightType;
	/**
	 * 行权日期
	 */
	private String exeRightTime;
	/**
	 * 托管机构
	 */
	private String escrowAgent;
	/**
	 * 范围
	 */
	private String flowRange;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 提示
	 */
	private String tip;
	/**
	 * 债券创建时间
	 */
	private String bCreateTime;
	/**
	 * 债券更新时间
	 */
	private String bUpdateTime;
	/**
	 * 删除标识
	 */
	private String isDelete;

	/**
	 * 设置：债券ID
	 */
	public void setBId(String bId) {
		this.bId = bId;
	}

	/**
	 * 获取：债券ID
	 */
	public String getBId() {
		return bId;
	}

	/**
	 * 设置：债券名称
	 */
	public void setBondName(String bondName) {
		this.bondName = bondName;
	}

	/**
	 * 获取：债券名称
	 */
	public String getBondName() {
		return bondName;
	}

	/**
	 * 设置：债券代码
	 */
	public void setBondNum(String bondNum) {
		this.bondNum = bondNum;
	}

	/**
	 * 获取：债券代码
	 */
	public String getBondNum() {
		return bondNum;
	}

	/**
	 * 设置：发行人
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * 获取：发行人
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * 设置：债券类型
	 */
	public void setBondType(String bondType) {
		this.bondType = bondType;
	}

	/**
	 * 获取：债券类型
	 */
	public String getBondType() {
		return bondType;
	}

	/**
	 * 设置：发行日期
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * 获取：发行日期
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * 设置：债劵到期日
	 */
	public void setPublishExpireTime(String publishExpireTime) {
		this.publishExpireTime = publishExpireTime;
	}

	/**
	 * 获取：债劵到期日
	 */
	public String getPublishExpireTime() {
		return publishExpireTime;
	}

	/**
	 * 设置：债劵期限
	 */
	public void setBondTimeLimit(String bondTimeLimit) {
		this.bondTimeLimit = bondTimeLimit;
	}

	/**
	 * 获取：债劵期限
	 */
	public String getBondTimeLimit() {
		return bondTimeLimit;
	}

	/**
	 * 设置：上市交易日
	 */
	public void setBondTradeTime(String bondTradeTime) {
		this.bondTradeTime = bondTradeTime;
	}

	/**
	 * 获取：上市交易日
	 */
	public String getBondTradeTime() {
		return bondTradeTime;
	}

	/**
	 * 设置：计息方式
	 */
	public void setCalInterestType(String calInterestType) {
		this.calInterestType = calInterestType;
	}

	/**
	 * 获取：计息方式
	 */
	public String getCalInterestType() {
		return calInterestType;
	}

	/**
	 * 设置：债劵摘牌日
	 */
	public void setBondStopTime(String bondStopTime) {
		this.bondStopTime = bondStopTime;
	}

	/**
	 * 获取：债劵摘牌日
	 */
	public String getBondStopTime() {
		return bondStopTime;
	}

	/**
	 * 设置：信用评级机构
	 */
	public void setCreditRatingGov(String creditRatingGov) {
		this.creditRatingGov = creditRatingGov;
	}

	/**
	 * 获取：信用评级机构
	 */
	public String getCreditRatingGov() {
		return creditRatingGov;
	}

	/**
	 * 设置：债项评级
	 */
	public void setDebtRating(String debtRating) {
		this.debtRating = debtRating;
	}

	/**
	 * 获取：债项评级
	 */
	public String getDebtRating() {
		return debtRating;
	}

	/**
	 * 设置：面值（元）
	 */
	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	/**
	 * 获取：面值（元）
	 */
	public String getFaceValue() {
		return faceValue;
	}

	/**
	 * 设置：参考利率（％）
	 */
	public void setRefInterestRate(String refInterestRate) {
		this.refInterestRate = refInterestRate;
	}

	/**
	 * 获取：参考利率（％）
	 */
	public String getRefInterestRate() {
		return refInterestRate;
	}

	/**
	 * 设置：票面利率（％）
	 */
	public void setFaceInterestRate(String faceInterestRate) {
		this.faceInterestRate = faceInterestRate;
	}

	/**
	 * 获取：票面利率（％）
	 */
	public String getFaceInterestRate() {
		return faceInterestRate;
	}

	/**
	 * 设置：实际发行量（亿）
	 */
	public void setRealIssuedQuantity(String realIssuedQuantity) {
		this.realIssuedQuantity = realIssuedQuantity;
	}

	/**
	 * 获取：实际发行量（亿）
	 */
	public String getRealIssuedQuantity() {
		return realIssuedQuantity;
	}

	/**
	 * 设置：计划发行量（亿）
	 */
	public void setPlanIssuedQuantity(String planIssuedQuantity) {
		this.planIssuedQuantity = planIssuedQuantity;
	}

	/**
	 * 获取：计划发行量（亿）
	 */
	public String getPlanIssuedQuantity() {
		return planIssuedQuantity;
	}

	/**
	 * 设置：发行价格（元）
	 */
	public void setIssuedPrice(String issuedPrice) {
		this.issuedPrice = issuedPrice;
	}

	/**
	 * 获取：发行价格（元）
	 */
	public String getIssuedPrice() {
		return issuedPrice;
	}

	/**
	 * 设置：利差（BP）
	 */
	public void setInterestDiff(String interestDiff) {
		this.interestDiff = interestDiff;
	}

	/**
	 * 获取：利差（BP）
	 */
	public String getInterestDiff() {
		return interestDiff;
	}

	/**
	 * 设置：付息频率
	 */
	public void setPayInterestHz(String payInterestHz) {
		this.payInterestHz = payInterestHz;
	}

	/**
	 * 获取：付息频率
	 */
	public String getPayInterestHz() {
		return payInterestHz;
	}

	/**
	 * 设置：债劵起息日
	 */
	public void setStartCalInterestTime(String startCalInterestTime) {
		this.startCalInterestTime = startCalInterestTime;
	}

	/**
	 * 获取：债劵起息日
	 */
	public String getStartCalInterestTime() {
		return startCalInterestTime;
	}

	/**
	 * 设置：行权类型
	 */
	public void setExeRightType(String exeRightType) {
		this.exeRightType = exeRightType;
	}

	/**
	 * 获取：行权类型
	 */
	public String getExeRightType() {
		return exeRightType;
	}

	/**
	 * 设置：行权日期
	 */
	public void setExeRightTime(String exeRightTime) {
		this.exeRightTime = exeRightTime;
	}

	/**
	 * 获取：行权日期
	 */
	public String getExeRightTime() {
		return exeRightTime;
	}

	/**
	 * 设置：托管机构
	 */
	public void setEscrowAgent(String escrowAgent) {
		this.escrowAgent = escrowAgent;
	}

	/**
	 * 获取：托管机构
	 */
	public String getEscrowAgent() {
		return escrowAgent;
	}

	/**
	 * 设置：范围
	 */
	public void setFlowRange(String flowRange) {
		this.flowRange = flowRange;
	}

	/**
	 * 获取：范围
	 */
	public String getFlowRange() {
		return flowRange;
	}

	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置：提示
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * 获取：提示
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * 设置：债券创建时间
	 */
	public void setBCreateTime(String bCreateTime) {
		this.bCreateTime = bCreateTime;
	}

	/**
	 * 获取：债券创建时间
	 */
	public String getBCreateTime() {
		return bCreateTime;
	}

	/**
	 * 设置：债券更新时间
	 */
	public void setBUpdateTime(String bUpdateTime) {
		this.bUpdateTime = bUpdateTime;
	}

	/**
	 * 获取：债券更新时间
	 */
	public String getBUpdateTime() {
		return bUpdateTime;
	}

	/**
	 * 设置：删除标识
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 获取：删除标识
	 */
	public String getIsDelete() {
		return isDelete;
	}

}
