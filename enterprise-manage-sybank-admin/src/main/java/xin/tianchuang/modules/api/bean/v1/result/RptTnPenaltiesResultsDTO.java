package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPenaltiesDTO;

public class RptTnPenaltiesResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7936460556525593512L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnPenaltiesDTO> items = new ArrayList<>();;

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

	public List<RptTnPenaltiesDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnPenaltiesDTO> items) {
		this.items = items;
	}
}
