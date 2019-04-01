package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCourtNoticeDTO;

public class RptTnCourtNoticeResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -11520580106980814L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnCourtNoticeDTO> items = new ArrayList<>();;

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

	public List<RptTnCourtNoticeDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnCourtNoticeDTO> items) {
		this.items = items;
	}

}
