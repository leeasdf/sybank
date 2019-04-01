package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnInvestDTO;

public class RptTnInvestResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642582912612285304L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnInvestDTO> items = new ArrayList<>();;

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

	public List<RptTnInvestDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnInvestDTO> items) {
		this.items = items;
	}

}
