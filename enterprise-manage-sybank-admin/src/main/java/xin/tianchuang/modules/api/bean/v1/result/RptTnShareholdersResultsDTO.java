package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnShareholdersDTO;

public class RptTnShareholdersResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2595435661193590621L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnShareholdersDTO> items = new ArrayList<>();;

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

	public List<RptTnShareholdersDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnShareholdersDTO> items) {
		this.items = items;
	}

}
