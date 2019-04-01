package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnWorksRightDTO;

public class RptTnWorksRightResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3847736268360660915L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnWorksRightDTO> items = new ArrayList<>();;

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

	public List<RptTnWorksRightDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnWorksRightDTO> items) {
		this.items = items;
	}

}
