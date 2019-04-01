package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnEquityDTO;

public class RptTnEquityResultsDTO extends BaseDTO {


	/**
	 * 
	 */
	private static final long serialVersionUID = -698072036180844640L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnEquityDTO> items = new ArrayList<>();;

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

	public List<RptTnEquityDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnEquityDTO> items) {
		this.items = items;
	}

}
