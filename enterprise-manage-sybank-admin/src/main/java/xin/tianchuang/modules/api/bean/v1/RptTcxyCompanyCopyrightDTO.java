package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业-作品著作权(天创信用)
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:19
 */

public class RptTcxyCompanyCopyrightDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1334581260722919771L;
	/**
	 * 企业id
	 */
	private Long companyId;
	/**
	 * 分类号
	 */
	private String classifyCode;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 登记号
	 */
	private String registerCode;
	/**
	 * 登记日期
	 */
	private Date registerDate;
	/**
	 * 著作权人（国籍）
	 */
	private String ownerName;
	/**
	 * 作品名称
	 */
	private String fullName;
	/**
	 * 首次发表时间
	 */
	private Date launchDate;
	/**
	 * 首次发表时间
	 */
	private Date finishDate;
	/**
	 * 作品类别
	 */
	private String cateName;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：企业id
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取：企业id
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 设置：分类号
	 */
	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}

	/**
	 * 获取：分类号
	 */
	public String getClassifyCode() {
		return classifyCode;
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
	 * 设置：登记号
	 */
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	/**
	 * 获取：登记号
	 */
	public String getRegisterCode() {
		return registerCode;
	}

	/**
	 * 设置：登记日期
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * 获取：登记日期
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * 设置：著作权人（国籍）
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * 获取：著作权人（国籍）
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * 设置：作品名称
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 获取：作品名称
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 设置：首次发表时间
	 */
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	/**
	 * 获取：首次发表时间
	 */
	public Date getLaunchDate() {
		return launchDate;
	}

	/**
	 * 设置：首次发表时间
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * 获取：首次发表时间
	 */
	public Date getFinishDate() {
		return finishDate;
	}

	/**
	 * 设置：作品类别
	 */
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	/**
	 * 获取：作品类别
	 */
	public String getCateName() {
		return cateName;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
