package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open783OneKeyCNodesPropertiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846361716821453693L;
	private String aias; // 节点简称
	private String name; // 节点名称
	private String logo; // 节点logo地址
	private String ntype; // 节点类型

	public String getAias() {
		return aias;
	}

	public void setAias(String aias) {
		this.aias = aias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNtype() {
		return ntype;
	}

	public void setNtype(String ntype) {
		this.ntype = ntype;
	}

}
