package xin.tianchuang.modules.api.bean.v1;





import java.io.Serializable;

/**
 * 商业角色
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:22
 */

public class RptTnBusroleDTO implements Serializable {
	

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4597303593339816091L;
	/**
	 * 企业名称
	 */
	private String entname;
	/**
	 * 注册资本
	 */
	private String capital;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 省份地址
	 */
	private String province;
	/**
	 * 公司名
	 */
	private String cmpname;
	/**
	 * 开业日期
	 */
	private String opendate;
	/**
	 * 经营状态
	 */
	private String status;



	/**
	 * 设置：企业名称
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntname() {
		return entname;
	}
	/**
	 * 设置：注册资本
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}
	/**
	 * 获取：注册资本
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * 设置：角色
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取：角色
	 */
	public String getRole() {
		return role;
	}
	/**
	 * 设置：省份地址
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份地址
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：公司名
	 */
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	/**
	 * 获取：公司名
	 */
	public String getCmpname() {
		return cmpname;
	}
	/**
	 * 设置：开业日期
	 */
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	/**
	 * 获取：开业日期
	 */
	public String getOpendate() {
		return opendate;
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
