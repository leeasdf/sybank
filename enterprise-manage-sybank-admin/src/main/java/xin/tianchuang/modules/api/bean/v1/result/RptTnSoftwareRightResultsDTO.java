package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnSoftwareRightAuthorDTO;

public class RptTnSoftwareRightResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6785335740739673125L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnSoftwareRightAuthorDTO> items = new ArrayList<>();;

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

	public List<RptTnSoftwareRightAuthorDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnSoftwareRightAuthorDTO> items) {
		this.items = items;
	}

}
