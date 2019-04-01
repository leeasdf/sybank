package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业被执行人信息-返回对象模型")
public class LoanBizZhixinginfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5670798876903936374L;

	@ApiModelProperty(name = "caseCreateTime", value = "创建时间", example="112")
	private Long caseCreateTime;// 创建时间
	@ApiModelProperty(name = "execMoney", value = "执行标的")
	private String execMoney;// 执行标的 varchar(20)
	@ApiModelProperty(name = "caseCode", value = "案号")
	private String caseCode;// 案号 varchar(50)
	@ApiModelProperty(name = "execCourtName", value = "执行法院")
	private String execCourtName;// 执行法院 varchar(50)

	// private String pname;// 被执行人名称 varchar(60)
	// private String partyCardNum;// 身份证号／组织机构代码 varchar(30)

	public String getCaseCode() {
		return caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getExecCourtName() {
		return execCourtName;
	}

	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}

	public Long getCaseCreateTime() {
		return caseCreateTime;
	}

	public void setCaseCreateTime(Long caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

}
