package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业股东出资信息-返回对象模型")
public class LoanBizHolderCapitalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8166028110851242742L;
	@ApiModelProperty(name = "amomon", value = "出资金额")
	private String amomon;// 出资金额 varchar(50)
	@ApiModelProperty(name = "time", value = "出资时间")
	private String time;// 出资时间
	@ApiModelProperty(name = "percent", value = "占比")
	private String percent;// 占比

	public String getAmomon() {
		return amomon;
	}

	public void setAmomon(String amomon) {
		this.amomon = amomon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

}
