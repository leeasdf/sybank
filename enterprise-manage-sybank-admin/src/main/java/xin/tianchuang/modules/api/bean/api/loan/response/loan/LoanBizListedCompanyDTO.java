package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业上市基本信息-返回对象模型")
public class LoanBizListedCompanyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5452658460975227229L;

	@ApiModelProperty(name = "bondName", value = "上市标识")
	private Integer listedFlag; // 股票名[varchar(20)]

	@ApiModelProperty(name = "bondName", value = "股票名")
	private String bondName; // 股票名[varchar(20)]
	@ApiModelProperty(name = "bondType", value = "股票类型")
	private String bondType; // 股票类型[varchar(31)]
	@ApiModelProperty(name = "bondNum", value = "股票号")
	private String bondNum; // 股票号[varchar(20)]

	public String getBondName() {
		return bondName;
	}

	public void setBondName(String bondName) {
		this.bondName = bondName;
	}

	public String getBondNum() {
		return bondNum;
	}

	public void setBondNum(String bondNum) {
		this.bondNum = bondNum;
	}

	public String getBondType() {
		return bondType;
	}

	public void setBondType(String bondType) {
		this.bondType = bondType;
	}

	public Integer getListedFlag() {
		return listedFlag;
	}

	public void setListedFlag(Integer listedFlag) {
		this.listedFlag = listedFlag;
	}

}
