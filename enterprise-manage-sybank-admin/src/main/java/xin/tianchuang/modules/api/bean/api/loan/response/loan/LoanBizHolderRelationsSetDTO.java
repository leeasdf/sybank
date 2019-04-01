package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业股东关联信息-返回对象模型")
public class LoanBizHolderRelationsSetDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1660465688943504384L;
	@ApiModelProperty(name = "type", value = "类别", example="1")
	private Integer type;

	@ApiModelProperty(name = "name", value = "股东名称(自然人股东或企业股东自然人姓名)/法人姓名")
	private String pname;// 股东名 varchar(50)

	@ApiModelProperty(name = "ccode", value = "统一社会信用代码")
	private String ccode;

	@ApiModelProperty(name = "cname", value = "企业名称")
	private String cname;

	@ApiModelProperty(name = "address", value = "企业注册地址")
	private String address;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
