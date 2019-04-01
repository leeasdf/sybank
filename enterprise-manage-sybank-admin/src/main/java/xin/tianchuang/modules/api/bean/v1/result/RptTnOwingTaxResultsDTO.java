package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnOwingTaxDTO;

public class RptTnOwingTaxResultsDTO extends BaseDTO {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6109772427434588471L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnOwingTaxDTO> items = new ArrayList<>();;

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

	public List<RptTnOwingTaxDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnOwingTaxDTO> items) {
		this.items = items;
	}

}
