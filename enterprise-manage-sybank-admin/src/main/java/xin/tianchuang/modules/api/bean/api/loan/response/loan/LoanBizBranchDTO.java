package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业分支机构-返回对象模型")
public class LoanBizBranchDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7725772694913362734L;

	@ApiModelProperty(name = "name", value = "公司名")
	private String name;// 公司名 varchar(255)
	@ApiModelProperty(name = "legalPersonName", value = "法人")
	private String legalPersonName;// 法人 varchar(120)
	@ApiModelProperty(name = "estiblishTime", value = "开业时间【毫秒数】", example="112")
	private Long estiblishTime;// 开业时间 毫秒数
	@ApiModelProperty(name = "regStatus", value = "企业状态")
	private String regStatus;// 企业状态 varchar(31)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public Long getEstiblishTime() {
		return estiblishTime;
	}

	public void setEstiblishTime(Long estiblishTime) {
		this.estiblishTime = estiblishTime;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

}
