package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBranchesDTO;

public class RptTnBranchesResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6800754521979894603L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnBranchesDTO> items = new ArrayList<>();;

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

	public List<RptTnBranchesDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnBranchesDTO> items) {
		this.items = items;
	}

}
