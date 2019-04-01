package xin.tianchuang.modules.api.bean.v1;





import java.io.Serializable;

/**
 * 网站备案信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:21
 */

public class RptTnIcpDTO implements Serializable {
	

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1472118299070442975L;
	/**
	 * 单位性质
	 */
	private String unitProperties;
	/**
	 * 审核时间
	 */
	private String approveDate;
	/**
	 * 域名
	 */
	private String domainName;
	/**
	 * 网站名称
	 */
	private String regnum;
	/**
	 * 备案号
	 */
	private String recordNo;
	/**
	 * 网站首页
	 */
	private String homepage;
	/**
	 * 状态
	 */
	private String status;

	/**
	 * 网站名称
	 */
	private String siteName;


	/**
	 * 设置：单位性质
	 */
	public void setUnitProperties(String unitProperties) {
		this.unitProperties = unitProperties;
	}
	/**
	 * 获取：单位性质
	 */
	public String getUnitProperties() {
		return unitProperties;
	}
	/**
	 * 设置：审核时间
	 */
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}
	/**
	 * 获取：审核时间
	 */
	public String getApproveDate() {
		return approveDate;
	}
	/**
	 * 设置：域名
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	/**
	 * 获取：域名
	 */
	public String getDomainName() {
		return domainName;
	}
	/**
	 * 设置：网站名称
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	/**
	 * 获取：网站名称
	 */
	public String getRegnum() {
		return regnum;
	}
	/**
	 * 设置：备案号
	 */
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}
	/**
	 * 获取：备案号
	 */
	public String getRecordNo() {
		return recordNo;
	}
	/**
	 * 设置：网站首页
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	/**
	 * 获取：网站首页
	 */
	public String getHomepage() {
		return homepage;
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
	 * 设置：网站名称
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * 获取：网站名称
	 */
	public String getSiteName() {
		return siteName;
	}
}
