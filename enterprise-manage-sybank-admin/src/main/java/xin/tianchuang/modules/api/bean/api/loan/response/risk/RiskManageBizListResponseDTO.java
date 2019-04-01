package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "风控系统业务信息最近8条-返回对象模型")
public class RiskManageBizListResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6699456487619530716L;

	@ApiModelProperty(value = "entName", name = "企业名称")
	private String entName;
	@ApiModelProperty(value = "collectDate", name = "收集日期")
	private Date collectDate;
	@ApiModelProperty(value = "reportContent", name = "数据内容")
	private String reportContent;
	@ApiModelProperty(value = "bizCode", name = "流水号（业务编号）")
	private String bizCode;

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

}
