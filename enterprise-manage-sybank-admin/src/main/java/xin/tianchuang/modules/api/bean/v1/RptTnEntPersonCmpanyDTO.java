package xin.tianchuang.modules.api.bean.v1;





import java.io.Serializable;

/**
 * 所有公司
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:22
 */

public class RptTnEntPersonCmpanyDTO implements Serializable {
	

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7237712053569385807L;
	/**
	 * 个人ID
	 */
	private String personid;
	/**
	 * 姓名
	 */
	private String personname;
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
	 * 注册资本
	 */
	private String regcap;



	/**
	 * 设置：个人ID
	 */
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	/**
	 * 获取：个人ID
	 */
	public String getPersonid() {
		return personid;
	}
	/**
	 * 设置：姓名
	 */
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	/**
	 * 获取：姓名
	 */
	public String getPersonname() {
		return personname;
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
	/**
	 * 设置：注册资本
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资本
	 */
	public String getRegcap() {
		return regcap;
	}

}
