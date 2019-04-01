package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIllegalDTO;

public class RptTnIllegalResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5024833494454735781L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnIllegalDTO> items = new ArrayList<>();;

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

	public List<RptTnIllegalDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnIllegalDTO> items) {
		this.items = items;
	}

}
