package xin.tianchuang.modules.api.bean.api.tyc.request;

import java.io.Serializable;

public class RequestParamDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -587997660223733984L;
	/**
	 * 公司id（id与name只需输入其中一个）
	 */
	private Long id;
	/**
	 * 公司名称（id与name只需输入其中一个）
	 */
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
