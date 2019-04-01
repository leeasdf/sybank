package xin.tianchuang.modules.api.bean.api.loan.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "业务系统企业列表信息-请求对象模型")
public class LoanBizCompanyListReqDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1288233217762901931L;

	/**
	 * 业务请求编号
	 */
	@ApiModelProperty(value = "bizCode", name = "业务请求编号", example = "2018010100001R", required = true)
	@NotBlank(message = "业务请求编号不能为空")
	private String bizCode;

	@ApiModelProperty(hidden = true)
	private String seqNum = UUID.randomUUID().toString().replace("-", "");

	/**
	 * 查询时间
	 */
	@ApiModelProperty(value = "beginDate", name = "查询时间", example = "2019-01-11")
	private String beginDate;

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

}
