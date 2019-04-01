package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "风控系统返回-报告对象模型")
public class LoanBizReportResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2343146650813300825L;

	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "name", name = "企业名称", example = "平安银行股份有限公司")
	@NotBlank(message = "企业名称name不能为空")
	private String name;

	/**
	 * 业务请求编号
	 */
	@ApiModelProperty(value = "bizCode", name = "业务请求编号", example = "2018010100001", required = true)
	private String bizCode;

	@ApiModelProperty(hidden = true)
	private String seqNum = UUID.randomUUID().toString().replace("-", "");
	/**
	 * 统一社会信用代码
	 */
	@ApiModelProperty(value = "creditCode", example = "91110000802100433B", name = "公司名称和统一社会信用代码不能同时为空")
	private String creditCode;

	@ApiModelProperty(value = "data", name = "数据（此处存为json字符串)")
	private String data;

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
