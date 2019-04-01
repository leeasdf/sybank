package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTaxCreditDTO;

public class RptTnTaxCreditResultsDTO extends BaseDTO {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2483818524865515724L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnTaxCreditDTO> items = new ArrayList<>();;

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

	public List<RptTnTaxCreditDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnTaxCreditDTO> items) {
		this.items = items;
	}

}
