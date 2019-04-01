package xin.tianchuang.modules.api.bean.api.tyc.request;

import java.io.Serializable;

public class RequestPageNumParamDTO implements Serializable {
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

	/**
	 * 当前页数（默认第一页，每页20条）
	 */
	private int pageNum;

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

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
