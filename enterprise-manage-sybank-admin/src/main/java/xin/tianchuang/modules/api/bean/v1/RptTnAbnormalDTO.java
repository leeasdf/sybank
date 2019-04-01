package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 经营异常信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnAbnormalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12079169459564882L;
	/**
	 * 列入日期
	 */
	private String date;
	/**
	 * 决定机关
	 */
	private String agency;
	/**
	 * 列入原因
	 */
	private String reason;
	/**
	 * 移除日期
	 */
	private String removeDate;
	/**
	 * 移除机关
	 */
	private String removeAgency;
	/**
	 * 移除原因
	 */
	private String removeReason;

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
	 * 设置：移除日期
	 */
	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}

	/**
	 * 获取：移除日期
	 */
	public String getRemoveDate() {
		return removeDate;
	}

	/**
	 * 设置：移除机关
	 */
	public void setRemoveAgency(String removeAgency) {
		this.removeAgency = removeAgency;
	}

	/**
	 * 获取：移除机关
	 */
	public String getRemoveAgency() {
		return removeAgency;
	}

	/**
	 * 设置：移除原因
	 */
	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	/**
	 * 获取：移除原因
	 */
	public String getRemoveReason() {
		return removeReason;
	}
}
