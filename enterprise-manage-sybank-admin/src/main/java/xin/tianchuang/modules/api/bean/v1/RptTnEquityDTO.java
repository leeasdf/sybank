package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 股权质押信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnEquityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6692651286532532594L;
	/**
	 * 出质股权数额
	 */
	private String equityAmount;
	/**
	 * 待定
	 */
	private String putDate;
	/**
	 * 公布日期
	 */
	private String publishDate;
	/**
	 * 质权人网址
	 */
	private String pledgorStr;
	/**
	 * 登记日
	 */
	private String regDate;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 质权人证件号码
	 */
	private String certifNumber;
	/**
	 * 登记编号
	 */
	private String regNumber;
	/**
	 * 出质人
	 */
	private String pledgee;
	/**
	 * 公司列表
	 */
	private String companyList;
	/**
	 * 出质人列表
	 */
	private String pledgeeList;
	/**
	 * 质权人列表
	 */
	private String pledgorList;
	/**
	 * 质权人
	 */
	private String pledgor;
	/**
	 * 出质人证件号码
	 */
	private String certifNumberR;

	/**
	 * 来源
	 */
	private String base;
	/**
	 * 出质人网址
	 */
	private String pledgeeStr;

	/**
	 * 设置：出质股权数额
	 */
	public void setEquityAmount(String equityAmount) {
		this.equityAmount = equityAmount;
	}

	/**
	 * 获取：出质股权数额
	 */
	public String getEquityAmount() {
		return equityAmount;
	}

	/**
	 * 设置：待定
	 */
	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}

	/**
	 * 获取：待定
	 */
	public String getPutDate() {
		return putDate;
	}

	/**
	 * 设置：公布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：公布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：质权人网址
	 */
	public void setPledgorStr(String pledgorStr) {
		this.pledgorStr = pledgorStr;
	}

	/**
	 * 获取：质权人网址
	 */
	public String getPledgorStr() {
		return pledgorStr;
	}

	/**
	 * 设置：登记日
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * 获取：登记日
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
	}

	/**
	 * 设置：质权人证件号码
	 */
	public void setCertifNumber(String certifNumber) {
		this.certifNumber = certifNumber;
	}

	/**
	 * 获取：质权人证件号码
	 */
	public String getCertifNumber() {
		return certifNumber;
	}

	/**
	 * 设置：登记编号
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	/**
	 * 获取：登记编号
	 */
	public String getRegNumber() {
		return regNumber;
	}

	/**
	 * 设置：出质人
	 */
	public void setPledgee(String pledgee) {
		this.pledgee = pledgee;
	}

	/**
	 * 获取：出质人
	 */
	public String getPledgee() {
		return pledgee;
	}

	/**
	 * 设置：公司列表
	 */
	public void setCompanyList(String companyList) {
		this.companyList = companyList;
	}

	/**
	 * 获取：公司列表
	 */
	public String getCompanyList() {
		return companyList;
	}

	/**
	 * 设置：出质人列表
	 */
	public void setPledgeeList(String pledgeeList) {
		this.pledgeeList = pledgeeList;
	}

	/**
	 * 获取：出质人列表
	 */
	public String getPledgeeList() {
		return pledgeeList;
	}

	/**
	 * 设置：质权人列表
	 */
	public void setPledgorList(String pledgorList) {
		this.pledgorList = pledgorList;
	}

	/**
	 * 获取：质权人列表
	 */
	public String getPledgorList() {
		return pledgorList;
	}

	/**
	 * 设置：质权人
	 */
	public void setPledgor(String pledgor) {
		this.pledgor = pledgor;
	}

	/**
	 * 获取：质权人
	 */
	public String getPledgor() {
		return pledgor;
	}

	/**
	 * 设置：出质人证件号码
	 */
	public void setCertifNumberR(String certifNumberR) {
		this.certifNumberR = certifNumberR;
	}

	/**
	 * 获取：出质人证件号码
	 */
	public String getCertifNumberR() {
		return certifNumberR;
	}

	/**
	 * 设置：来源
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * 获取：来源
	 */
	public String getBase() {
		return base;
	}

	/**
	 * 设置：出质人网址
	 */
	public void setPledgeeStr(String pledgeeStr) {
		this.pledgeeStr = pledgeeStr;
	}

	/**
	 * 获取：出质人网址
	 */
	public String getPledgeeStr() {
		return pledgeeStr;
	}
}
