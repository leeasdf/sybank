package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnAbnormalDTO;

public class RptTnAbnormalResultsDTO extends BaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6645529199124391208L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnAbnormalDTO> items = new ArrayList<>();

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

	public List<RptTnAbnormalDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnAbnormalDTO> items) {
		this.items = items;
	}

	
}
