package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 软件著作人详情信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnSoftwareRightAuthorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2419709457777254163L;
	/**
	 * 企业主键
	 */
	private Long enterpriseId;
	/**
	 * 企业名称
	 */
	private String entAme;
	/**
	 * 软件全称
	 */
	private String fullname;
	/**
	 * 软件简称
	 */
	private String simplename;
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
	 * 著作权人(国籍)
	 */
	private String authorNationality;
	/**
	 * 首次发表日期
	 */
	private String publishtime;
	/**
	 * 登记日期
	 */
	private String regtime;

	/**
	 * 设置：企业主键
	 */
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	/**
	 * 获取：企业主键
	 */
	public Long getEnterpriseId() {
		return enterpriseId;
	}

	/**
	 * 设置：企业名称
	 */
	public void setEntAme(String entAme) {
		this.entAme = entAme;
	}

	/**
	 * 获取：企业名称
	 */
	public String getEntAme() {
		return entAme;
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
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	/**
	 * 获取：软件简称
	 */
	public String getSimplename() {
		return simplename;
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
	 * 设置：著作权人(国籍)
	 */
	public void setAuthorNationality(String authorNationality) {
		this.authorNationality = authorNationality;
	}

	/**
	 * 获取：著作权人(国籍)
	 */
	public String getAuthorNationality() {
		return authorNationality;
	}

	/**
	 * 设置：首次发表日期
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	/**
	 * 获取：首次发表日期
	 */
	public String getPublishtime() {
		return publishtime;
	}

	/**
	 * 设置：登记日期
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	/**
	 * 获取：登记日期
	 */
	public String getRegtime() {
		return regtime;
	}

}
