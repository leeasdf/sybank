package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 专利信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnPatentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2753543602680353393L;
	/**
	 * 申请公布日期
	 */
	private String appDate;
	/**
	 * 专利名称
	 */
	private String name;
	/**
	 * 申请号
	 */
	private String appNum;

	/**
	 * 申请公开号
	 */
	private String appPubNum;
	/**
	 * 专利类型
	 */
	private String appType;

	/**
	 * 设置：申请公布日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：申请公布日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：专利名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：专利名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：申请号
	 */
	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	/**
	 * 获取：申请号
	 */
	public String getAppNum() {
		return appNum;
	}

	/**
	 * 设置：申请公开号
	 */
	public void setAppPubNum(String appPubNum) {
		this.appPubNum = appPubNum;
	}

	/**
	 * 获取：申请公开号
	 */
	public String getAppPubNum() {
		return appPubNum;
	}

	/**
	 * 设置：专利类型
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * 获取：专利类型
	 */
	public String getAppType() {
		return appType;
	}
}
