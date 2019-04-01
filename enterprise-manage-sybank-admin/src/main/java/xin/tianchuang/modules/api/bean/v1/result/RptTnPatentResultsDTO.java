package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPatentDTO;

public class RptTnPatentResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7092899636924628226L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnPatentDTO> items = new ArrayList<>();;

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

	public List<RptTnPatentDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnPatentDTO> items) {
		this.items = items;
	}

}
