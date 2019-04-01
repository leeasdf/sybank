package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class ResponsePerPageNumResultDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 814922542102430109L;

	private Integer total; // Number 股东总数

	private List<T> items; // 股东信息列表

	private Integer num; // 无用

	private Integer pageNum; // 当前页

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
