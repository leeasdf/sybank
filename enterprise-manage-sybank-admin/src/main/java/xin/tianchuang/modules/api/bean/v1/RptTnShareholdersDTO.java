package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 股东信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */

public class RptTnShareholdersDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8334351966442274385L;

	// toco 拥有公司个数
	// logo varchar(150) logo
	// capitalActl 实际缴纳 array
	// amomon 出资金额 time 出资时间 percent 占比 paymet 实缴方式
	/**
	 * 股东(发起人)
	 */
	private String name;
	/**
	 * 出资比例
	 */
	private String funRatio;
	/**
	 * 认缴出资
	 */
	private String subFunding;

	/**
	 * 出资时间
	 */
	private String amountDate;
	/**
	 * 是否大股东
	 */
	private String isMax;

	// type 1-公司 2-人
	// capital 认缴
	// amomon 出资金额 time 出资时间 percent 占比 paymet认缴方式

	/**
	 * 设置：股东(发起人)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：股东(发起人)
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：出资比例
	 */
	public void setFunRatio(String funRatio) {
		this.funRatio = funRatio;
	}

	/**
	 * 获取：出资比例
	 */
	public String getFunRatio() {
		return funRatio;
	}

	/**
	 * 设置：认缴出资
	 */
	public void setSubFunding(String subFunding) {
		this.subFunding = subFunding;
	}

	/**
	 * 获取：认缴出资
	 */
	public String getSubFunding() {
		return subFunding;
	}

	/**
	 * 设置：出资时间
	 */
	public void setAmountDate(String amountDate) {
		this.amountDate = amountDate;
	}

	/**
	 * 获取：出资时间
	 */
	public String getAmountDate() {
		return amountDate;
	}

	/**
	 * 设置：是否大股东
	 */
	public void setIsMax(String isMax) {
		this.isMax = isMax;
	}

	/**
	 * 获取：是否大股东
	 */
	public String getIsMax() {
		return isMax;
	}
}
