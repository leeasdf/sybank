package xin.tianchuang.modules.api.bean.api.loan.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "业务系统请求对象模型")
public class LoanBizViewReqDTO extends BaseLoanBizReqDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1925186108918139420L;
	/**
	 * 统一社会信用代码
	 */
	@ApiModelProperty(value = "creditCode", example = "91110000802100433B", name = "公司名称和统一社会信用代码不能同时为空")
	private String creditCode;
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

}
