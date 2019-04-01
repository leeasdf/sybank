package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "返回对象模型")
public class LoanBizResponseResultDTO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 814922542102430109L;

	@ApiModelProperty(name = "total", value = "总条数", dataType = "int", example="10")
	private Integer total; // Number 总数

	@ApiModelProperty(name = "items", value = "返回结果")
	private List<T> items; // 信息列表

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

}
