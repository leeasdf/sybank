package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 分支机构
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */

public class RptTnBranchesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1359115334726213560L;
	// toco 拥有公司数量
	/**
	 * 注册时间
	 */
	private String regTime;
	/**
	 * 法人
	 */
	private String legalPerson;
	/**
	 * 公司名
	 */
	private String cmpName;
	/**
	 * 经营状态
	 */
	private String status;

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
	 * 设置：法人
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/**
	 * 获取：法人
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * 设置：公司名
	 */
	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	/**
	 * 获取：公司名
	 */
	public String getCmpName() {
		return cmpName;
	}

	/**
	 * 设置：经营状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：经营状态
	 */
	public String getStatus() {
		return status;
	}

}
