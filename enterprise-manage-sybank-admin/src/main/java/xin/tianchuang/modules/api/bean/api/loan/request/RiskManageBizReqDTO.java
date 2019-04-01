package xin.tianchuang.modules.api.bean.api.loan.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "风控系统-企业信息-请求对象模型")
public class RiskManageBizReqDTO extends BaseLoanBizReqDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6699456487619530716L;

	@ApiModelProperty(value = "creditCode", name = "统一社会信用代码", example = "1232131241R3")
	private String creditCode;

	@ApiModelProperty(value = "reportDate", name = "报告日期", example = "2018-01-12")
	private String reportDate;

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

}
