package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业-行政处罚[信用中国]
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnLicensingXyzgDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7525548054794838225L;
	/**
	 * 有效时间
	 */
	private String validityTime;
	/**
	 * 决定书文号
	 */
	private String licenceNumber;
	/**
	 * 决定机关
	 */
	private String department;
	/**
	 * 处罚内容
	 */
	private String licenceContent;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 * 类型
	 */
	private String audiType;
	/**
	 * 决定日期
	 */
	private String decisionDate;
	/**
	 * 法人
	 */
	private String legalPersonName;
	/**
	 * 处罚ID
	 */
	private String cid;
	/**
	 * 当地编码
	 */
	private String localCode;
	/**
	 * 法人ID
	 */
	private String legalPersonId;

	/**
	 * 设置：有效时间
	 */
	public void setValidityTime(String validityTime) {
		this.validityTime = validityTime;
	}

	/**
	 * 获取：有效时间
	 */
	public String getValidityTime() {
		return validityTime;
	}

	/**
	 * 设置：决定书文号
	 */
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	/**
	 * 获取：决定书文号
	 */
	public String getLicenceNumber() {
		return licenceNumber;
	}

	/**
	 * 设置：决定机关
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 获取：决定机关
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 设置：处罚内容
	 */
	public void setLicenceContent(String licenceContent) {
		this.licenceContent = licenceContent;
	}

	/**
	 * 获取：处罚内容
	 */
	public String getLicenceContent() {
		return licenceContent;
	}

	/**
	 * 设置：结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 获取：结束日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 设置：类型
	 */
	public void setAudiType(String audiType) {
		this.audiType = audiType;
	}

	/**
	 * 获取：类型
	 */
	public String getAudiType() {
		return audiType;
	}

	/**
	 * 设置：决定日期
	 */
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	/**
	 * 获取：决定日期
	 */
	public String getDecisionDate() {
		return decisionDate;
	}

	/**
	 * 设置：法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	/**
	 * 获取：法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}

	/**
	 * 设置：处罚ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 获取：处罚ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 设置：当地编码
	 */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/**
	 * 获取：当地编码
	 */
	public String getLocalCode() {
		return localCode;
	}

	/**
	 * 设置：法人ID
	 */
	public void setLegalPersonId(String legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	/**
	 * 获取：法人ID
	 */
	public String getLegalPersonId() {
		return legalPersonId;
	}

}
