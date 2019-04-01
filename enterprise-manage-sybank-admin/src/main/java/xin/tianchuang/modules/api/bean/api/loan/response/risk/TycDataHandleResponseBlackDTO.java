package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 黑名单
 * 
 * @author jinh
 *
 */
@ApiModel(value = "黑名单")
public class TycDataHandleResponseBlackDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2382117959921468426L;

	@ApiModelProperty(name = "name", value = "企业名称")
	private String name; // 企业名称

	@ApiModelProperty(value = "creditCode", name = "统一社会信用代码", example = "12321312413")
	private String creditCode;
	
	@ApiModelProperty(value = "black", name = "是否黑名单", example = "1")
	private String black;



	public String getBlack() {
		return black;
	}

	public void setBlack(String black) {
		this.black = black;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	
}
