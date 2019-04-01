package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open367StaffResultsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5523987438610170912L;
	private Integer total; // 主要人员总数
	private List<Open367StaffDTO> items;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Open367StaffDTO> getItems() {
		return items;
	}

	public void setItems(List<Open367StaffDTO> items) {
		this.items = items;
	}

}
