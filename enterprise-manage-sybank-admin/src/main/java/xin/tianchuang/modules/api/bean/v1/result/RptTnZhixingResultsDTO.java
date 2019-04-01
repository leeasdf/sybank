package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnZhixingDTO;

public class RptTnZhixingResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8231202216658706390L;

	/**
	 * 
	 */

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnZhixingDTO> items = new ArrayList<>();;

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

	public List<RptTnZhixingDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnZhixingDTO> items) {
		this.items = items;
	}

}
