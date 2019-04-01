package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 被执行人信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnZhixingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5427721140337908622L;
	/**
	 * 立案日期
	 */
	private String date;
	/**
	 * 执行标的
	 */
	private String target;
	/**
	 * 案号
	 */
	private String caseNo;
	/**
	 * 执行法院
	 */
	private String court;

	/**
	 * 设置：立案日期
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取：立案日期
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置：执行标的
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 获取：执行标的
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 设置：案号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * 获取：案号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * 设置：执行法院
	 */
	public void setCourt(String court) {
		this.court = court;
	}

	/**
	 * 获取：执行法院
	 */
	public String getCourt() {
		return court;
	}

}
