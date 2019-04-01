package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 商标信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnTrademarkDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2339066676914570330L;
	/**
	 * 申请日期
	 */
	private String appDate;
	/**
	 * 商标名称
	 */
	private String name;
	/**
	 * 注册号
	 */
	private String appNum;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 流程状态
	 */
	private String processStatus;

	/**
	 * 设置：申请日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：申请日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：商标名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：商标名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：注册号
	 */
	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}

	/**
	 * 获取：注册号
	 */
	public String getAppNum() {
		return appNum;
	}

	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 设置：流程状态
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * 获取：流程状态
	 */
	public String getProcessStatus() {
		return processStatus;
	}

}
