package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class ResponsePageNumResultDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 814922542102430109L;

	private Integer total; // Number 总数

	private List<T> items; // 信息列表

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

}
