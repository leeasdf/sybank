package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业-产品信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 10:14:18
 */

public class RptTnProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1667323714757205092L;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品简称
	 */
	private String shortname;
	/**
	 * 产品分类
	 */
	private String type;
	/**
	 * 领域
	 */
	private String zone;

	/**
	 * 设置：产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：产品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：产品简称
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	/**
	 * 获取：产品简称
	 */
	public String getShortname() {
		return shortname;
	}

	/**
	 * 设置：产品分类
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：产品分类
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：领域
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * 获取：领域
	 */
	public String getZone() {
		return zone;
	}

}
