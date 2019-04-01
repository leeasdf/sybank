package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTrademarkDTO;

public class RptTnTrademarkResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3082185945506277128L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnTrademarkDTO> items = new ArrayList<>();;

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

	public List<RptTnTrademarkDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnTrademarkDTO> items) {
		this.items = items;
	}

}
