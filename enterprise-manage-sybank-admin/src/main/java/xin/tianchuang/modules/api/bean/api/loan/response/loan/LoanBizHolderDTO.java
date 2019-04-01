package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业股东信息-返回对象模型")
public class LoanBizHolderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1339419944769635633L;

	@ApiModelProperty(name = "name", value = "股东名")
	private String name;// 股东名 varchar(50)
	@ApiModelProperty(name = "capital", value = "认缴")
	private List<LoanBizHolderCapitalDTO> capital;// 认缴
	
	@ApiModelProperty(name = "type", value = "类别")
	private Integer type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LoanBizHolderCapitalDTO> getCapital() {
		return capital;
	}

	public void setCapital(List<LoanBizHolderCapitalDTO> capital) {
		this.capital = capital;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	
}
