package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPersonDTO;

public class RptTnPersonResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5808206046140211152L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnPersonDTO> items = new ArrayList<>();;

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

	public List<RptTnPersonDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnPersonDTO> items) {
		this.items = items;
	}

}
