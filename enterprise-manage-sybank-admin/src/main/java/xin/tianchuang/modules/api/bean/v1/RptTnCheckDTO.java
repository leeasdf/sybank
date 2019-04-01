package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 抽查检查信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnCheckDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -473364668976475190L;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 结果
	 */
	private String result;
	/**
	 * 检查实施机关
	 */
	private String agency;
	/**
	 * 类别
	 */
	private String type;

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
	 * 设置：结果
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 获取：结果
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 设置：检查实施机关
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * 获取：检查实施机关
	 */
	public String getAgency() {
		return agency;
	}

	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}

}
