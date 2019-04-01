package xin.tianchuang.modules.api.bean.api.tyc.request;

import java.io.Serializable;

public class RequestPageSizeParamDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8587814659349921651L;
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
	private Integer pageNum;

	/**
	 * 每页条数（默认20）
	 */
	private Integer pageSize;

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

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
