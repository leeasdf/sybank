package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业对外投资-返回对象模型")
public class LoanBizInverstDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621968636193319872L;
	@ApiModelProperty(name = "name", value = "被投资公司")
	private String name; // 被投资公司 varchar(255)
	@ApiModelProperty(name = "legalPersonName", value = "法定代表人")
	private String legalPersonName; // 法人 varchar(120)
	@ApiModelProperty(name = "regCapital", value = "注册资金")
	private String regCapital; // 注册资金 varchar(50)
	@ApiModelProperty(name = "percent", value = "投资占比")
	private String percent; // 投资占比
	@ApiModelProperty(name = "estiblishTime", value = "开业时间（毫秒数）", example="112")
	private Long estiblishTime; // 开业时间 毫秒数
	@ApiModelProperty(name = "regStatus", value = "企业状态")
	private String regStatus; // 企业状态 varchar(50)

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

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
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
