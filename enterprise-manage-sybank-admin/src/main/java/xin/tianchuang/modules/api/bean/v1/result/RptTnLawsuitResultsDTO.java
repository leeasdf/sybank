package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnLawsuitDTO;

public class RptTnLawsuitResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5996414871223953651L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnLawsuitDTO> items = new ArrayList<>();;

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

	public List<RptTnLawsuitDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnLawsuitDTO> items) {
		this.items = items;
	}

}
