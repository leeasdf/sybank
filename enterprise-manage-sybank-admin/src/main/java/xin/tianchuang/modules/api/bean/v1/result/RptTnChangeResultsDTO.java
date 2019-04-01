package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;

public class RptTnChangeResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1586900025153950268L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnChangeDTO> items = new ArrayList<>();;

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

	public List<RptTnChangeDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnChangeDTO> items) {
		this.items = items;
	}

}
