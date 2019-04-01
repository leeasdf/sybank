package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 法律诉讼信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnLawsuitDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7365642099654252439L;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 裁判文书
	 */
	private String referee;
	/**
	 * 案由
	 */
	private String reason;
	/**
	 * 案件身份
	 */
	private String identity;
	/**
	 * 案号
	 */
	private String caseNum;

	/**
	 * 待定
	 */
	private String plaintiff;
	/**
	 * 待定
	 */
	private String defendant;

	/**
	 * 设置：日期
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取：日期
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置：裁判文书
	 */
	public void setReferee(String referee) {
		this.referee = referee;
	}

	/**
	 * 获取：裁判文书
	 */
	public String getReferee() {
		return referee;
	}

	/**
	 * 设置：案由
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 获取：案由
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 设置：案件身份
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * 获取：案件身份
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * 设置：案号
	 */
	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	/**
	 * 获取：案号
	 */
	public String getCaseNum() {
		return caseNum;
	}

	/**
	 * 设置：待定
	 */
	public void setPlaintiff(String plaintiff) {
		this.plaintiff = plaintiff;
	}

	/**
	 * 获取：待定
	 */
	public String getPlaintiff() {
		return plaintiff;
	}

	/**
	 * 设置：待定
	 */
	public void setDefendant(String defendant) {
		this.defendant = defendant;
	}

	/**
	 * 获取：待定
	 */
	public String getDefendant() {
		return defendant;
	}
}
