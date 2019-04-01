package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "风控系统业务信息-返回对象模型")
public class RiskManageBizResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6699456487619530716L;

	@ApiModelProperty(value = "entName", name = "企业名称")
	private String entName;
	
	@ApiModelProperty(value = "creditCode", name = "统一社会信用代码", example = "12321312413")
	private String creditCode;

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	

}
