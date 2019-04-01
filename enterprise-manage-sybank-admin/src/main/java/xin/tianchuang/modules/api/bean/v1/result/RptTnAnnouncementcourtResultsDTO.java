package xin.tianchuang.modules.api.bean.v1.result;

import java.util.ArrayList;
import java.util.List;

import xin.tianchuang.common.bean.BaseDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnAnnouncementcourtDTO;

public class RptTnAnnouncementcourtResultsDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 308879678223621682L;

	private Integer pageTotal;

	private Integer pageNum;

	private List<RptTnAnnouncementcourtDTO> items = new ArrayList<>();

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

	public List<RptTnAnnouncementcourtDTO> getItems() {
		return items;
	}

	public void setItems(List<RptTnAnnouncementcourtDTO> items) {
		this.items = items;
	}

}
