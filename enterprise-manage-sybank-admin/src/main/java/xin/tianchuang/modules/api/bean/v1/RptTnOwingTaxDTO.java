package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 欠税信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnOwingTaxDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4570899623423713648L;
	/**
	 * 发布日期
	 */
	private String publicDate;
	/**
	 * 纳税人识别号(已加密)
	 */
	private String taxNo;
	/**
	 * 欠税税种
	 */
	private String oweTaxType;
	/**
	 * 当前发生的欠税额
	 */
	private String currentOweTaxAmount;
	/**
	 * 欠税余额
	 */
	private String ownTaxBalance;
	/**
	 * 税务机关
	 */
	private String taxDepart;

	/**
	 * 设置：发布日期
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	/**
	 * 获取：发布日期
	 */
	public String getPublicDate() {
		return publicDate;
	}

	/**
	 * 设置：纳税人识别号(已加密)
	 */
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	/**
	 * 获取：纳税人识别号(已加密)
	 */
	public String getTaxNo() {
		return taxNo;
	}

	/**
	 * 设置：欠税税种
	 */
	public void setOweTaxType(String oweTaxType) {
		this.oweTaxType = oweTaxType;
	}

	/**
	 * 获取：欠税税种
	 */
	public String getOweTaxType() {
		return oweTaxType;
	}

	/**
	 * 设置：当前发生的欠税额
	 */
	public void setCurrentOweTaxAmount(String currentOweTaxAmount) {
		this.currentOweTaxAmount = currentOweTaxAmount;
	}

	/**
	 * 获取：当前发生的欠税额
	 */
	public String getCurrentOweTaxAmount() {
		return currentOweTaxAmount;
	}

	/**
	 * 设置：欠税余额
	 */
	public void setOwnTaxBalance(String ownTaxBalance) {
		this.ownTaxBalance = ownTaxBalance;
	}

	/**
	 * 获取：欠税余额
	 */
	public String getOwnTaxBalance() {
		return ownTaxBalance;
	}

	/**
	 * 设置：税务机关
	 */
	public void setTaxDepart(String taxDepart) {
		this.taxDepart = taxDepart;
	}

	/**
	 * 获取：税务机关
	 */
	public String getTaxDepart() {
		return taxDepart;
	}

}
