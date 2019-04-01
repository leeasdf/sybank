package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 税务评级信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnTaxCreditDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6002029938999906835L;
	/**
	 * 纳税评级
	 */
	private String taxLevel;
	/**
	 * 纳税人识别号
	 */
	private String taxNo;
	/**
	 * 评价单位
	 */
	private String agency;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 年份
	 */
	private String years;

	/**
	 * 设置：纳税评级
	 */
	public void setTaxLevel(String taxLevel) {
		this.taxLevel = taxLevel;
	}

	/**
	 * 获取：纳税评级
	 */
	public String getTaxLevel() {
		return taxLevel;
	}

	/**
	 * 设置：纳税人识别号
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	/**
	 * 获取：纳税人识别号
	 */
	public String getTaxNo() {
		return taxNo;
	}

	/**
	 * 设置：评价单位
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * 获取：评价单位
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

	/**
	 * 设置：年份
	 */
	public void setYears(String years) {
		this.years = years;
	}

	/**
	 * 获取：年份
	 */
	public String getYears() {
		return years;
	}

}
