package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业关系节点属性-返回对象模型")
public class LoanBizOneKeyCNodesPropertiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7356849768340046520L;

	@ApiModelProperty(name = "aias", value = "节点简称")
	private String aias; // 节点简称

	@ApiModelProperty(name = "name", value = "节点名称")
	private String name; // 节点名称

	@ApiModelProperty(name = "ntype", value = "节点类型")
	private String ntype; // 节点类型

	public String getAias() {
		return aias;
	}

	public void setAias(String aias) {
		this.aias = aias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNtype() {
		return ntype;
	}

	public void setNtype(String ntype) {
		this.ntype = ntype;
	}

}
