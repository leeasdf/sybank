package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业员工信息-返回对象模型")
public class LoanBizStaffDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6092233852017934912L;

	@ApiModelProperty(name = "name", value = "主要人员名称")
	private String name; // 主要人员名称

	@ApiModelProperty(name = "typeJoin", value = "职位")
	private List<String> typeJoin; // 职位

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTypeJoin() {
		return typeJoin;
	}

	public void setTypeJoin(List<String> typeJoin) {
		this.typeJoin = typeJoin;
	}

}
