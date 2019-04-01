package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCheckDTO;

public class RptTnCheckResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8133256715216350195L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnCheckDTO> items = new ArrayList<>();;

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

	public List<RptTnCheckDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnCheckDTO> items) {
		this.items = items;
	}

}
