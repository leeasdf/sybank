package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 对外投资
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnInvestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3327002969070556918L;
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 被投资法定代表人
	 */
	private String legalPerson;
	/**
	 * 注册资本
	 */
	private String invAmount;
	/**
	 * 被投资公司名称
	 */
	private String cmpName;
	/**
	 * 投资占比
	 */
	private String invRatio;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * （已废弃）
	 */
	private String regCap;

	// orgType 公司类型 varchar(127)
	// business_scope String 经营范围 varchar(4091)
	// percent String 投资占比
	// regStatus String 企业状态 varchar(50)
	// estiblishTime Number 开业时间 毫秒数
	// legalPersonName String 法人 varchar(120)
	// type Number 1-公司 2-人
	// pencertileScore Number 评分
	// legalPersonId Number 法人id
	// amount Number 投资金额
	// id Number 公司id
	// category String 行业 varchar(256)
	// regCapital String 注册资金 varchar(50)
	// name String 被投资公司 varchar(255)
	// base String 省份简称 varchar(10)
	// creditCode String 统一社会信用代码 varchar(18)
	// personType Number 1 人 2 公司
	// toco Number 拥有公司数量
	// alias String 简称 varchar(30)
	// logo String logo varchar(150)

	/**
	 * 设置：注册时间
	 */
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	/**
	 * 获取：注册时间
	 */
	public String getRegTime() {
		return regTime;
	}

	/**
	 * 设置：被投资法定代表人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * 获取：被投资法定代表人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * 设置：注册资本
	 */
	public void setInvAmount(String invAmount) {
		this.invAmount = invAmount;
	}

	/**
	 * 获取：注册资本
	 */
	public String getInvAmount() {
		return invAmount;
	}

	/**
	 * 设置：被投资公司名称
	 */
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	/**
	 * 获取：被投资公司名称
	 */
	public String getCmpName() {
		return cmpName;
	}

	/**
	 * 设置：投资占比
	 */
	public void setInvRatio(String invRatio) {
		this.invRatio = invRatio;
	}

	/**
	 * 获取：投资占比
	 */
	public String getInvRatio() {
		return invRatio;
	}

	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置：（已废弃）
	 */
	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	/**
	 * 获取：（已废弃）
	 */
	public String getRegCap() {
		return regCap;
	}

}
