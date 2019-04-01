package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIcpDTO;

public class RptTnIcpResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8037846394204301633L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnIcpDTO> items = new ArrayList<>();;

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

	public List<RptTnIcpDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnIcpDTO> items) {
		this.items = items;
	}

}
