package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open365BaseinfoV3StaffDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4814728322855592055L;

	private Integer total; // 总数

	private List<Open365BaseinfoV3StaffChildDTO> result;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Open365BaseinfoV3StaffChildDTO> getResult() {
		return result;
	}

	public void setResult(List<Open365BaseinfoV3StaffChildDTO> result) {
		this.result = result;
	}

}
