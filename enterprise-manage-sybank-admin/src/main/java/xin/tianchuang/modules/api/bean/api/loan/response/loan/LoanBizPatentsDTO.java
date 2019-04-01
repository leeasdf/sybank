package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业专利信息-对象模型")
public class LoanBizPatentsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5558976181261966243L;

	@ApiModelProperty(name = "patentName", value = "专利名称")
	private String patentName;// 专利名称
	@ApiModelProperty(name = "patentType", value = "专利类型")
	private String patentType;// 专利类型
	@ApiModelProperty(name = "patentNum", value = "申请号/专利号")
	private String patentNum;// 申请号/专利号
	@ApiModelProperty(name = "applicationTime", value = "申请日")
	private String applicationTime;// 申请日

	public String getPatentName() {
		return patentName;
	}

	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}

	public String getPatentNum() {
		return patentNum;
	}

	public void setPatentNum(String patentNum) {
		this.patentNum = patentNum;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getPatentType() {
		return patentType;
	}

	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}

}
