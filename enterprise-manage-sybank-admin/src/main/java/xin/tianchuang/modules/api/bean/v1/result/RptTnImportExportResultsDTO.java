package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnImportExportDTO;

public class RptTnImportExportResultsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609299061769250244L;

	private Integer pageTotal;

	private Integer pageNum;
	private List<RptTnImportExportDTO> items = new ArrayList<>();;

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

	public List<RptTnImportExportDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnImportExportDTO> items) {
		this.items = items;
	}

}
