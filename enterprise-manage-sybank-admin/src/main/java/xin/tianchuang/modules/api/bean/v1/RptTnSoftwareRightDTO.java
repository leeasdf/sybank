package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 软件著作权信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnSoftwareRightDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6220345631400015176L;
	/**
	 * 批准日期
	 */
	private String appDate;
	/**
	 * 软件全称
	 */
	private String fullname;
	/**
	 * 软件简称
	 */
	private String simpleName;
	/**
	 * 登记号
	 */
	private String regnum;
	/**
	 * 分类号
	 */
	private String catnum;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 著作详情信息
	 */
	private String author;

	/**
	 * 设置：批准日期
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * 获取：批准日期
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * 设置：软件全称
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * 获取：软件全称
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * 设置：软件简称
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	/**
	 * 获取：软件简称
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * 设置：登记号
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	/**
	 * 获取：登记号
	 */
	public String getRegnum() {
		return regnum;
	}

	/**
	 * 设置：分类号
	 */
	public void setCatnum(String catnum) {
		this.catnum = catnum;
	}

	/**
	 * 获取：分类号
	 */
	public String getCatnum() {
		return catnum;
	}

	/**
	 * 设置：版本号
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 获取：版本号
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 设置：著作详情信息
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 获取：著作详情信息
	 */
	public String getAuthor() {
		return author;
	}
}
