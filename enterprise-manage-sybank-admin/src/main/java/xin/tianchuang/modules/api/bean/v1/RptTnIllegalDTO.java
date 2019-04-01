package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 严重违法信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnIllegalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1761297886971563282L;
	/**
	 * 列入日期
	 */
	private String date;
	/**
	 * 列入原因
	 */
	private String reason;
	/**
	 * 决定机关
	 */
	private String agency;

	/**
	 * 设置：列入日期
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取：列入日期
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置：列入原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 获取：列入原因
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * 设置：决定机关
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * 获取：决定机关
	 */
	public String getAgency() {
		return agency;
	}

}
