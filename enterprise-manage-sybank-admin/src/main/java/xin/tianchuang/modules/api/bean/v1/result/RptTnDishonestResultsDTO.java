package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnDishonestDTO;

public class RptTnDishonestResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1371544065919882572L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnDishonestDTO> items = new ArrayList<>();;

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<RptTnDishonestDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnDishonestDTO> items) {
		this.items = items;
	}

}
