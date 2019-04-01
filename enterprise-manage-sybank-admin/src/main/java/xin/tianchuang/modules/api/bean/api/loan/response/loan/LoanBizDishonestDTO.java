package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业失信人信息-返回对象模型")
public class LoanBizDishonestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4864335911235307993L;

	@ApiModelProperty(name = "iname", value = "失信人名称")
	private String iname;
	
	@ApiModelProperty(name = "businessentity", value = "法人名称")
	private String businessentity;
	@ApiModelProperty(name = "regdate", value = "立案时间", dataType = "Long")
	private Long regdate;// 立案时间 毫秒数
	@ApiModelProperty(name = "casecode", value = "案号")
	private String casecode;// 案号 varchar(50)
	@ApiModelProperty(name = "courtname", value = "法院")
	private String courtname;// 法院 varchar(50)
	@ApiModelProperty(name = "performance", value = "履行情况")
	private String performance;// 履行情况 varchar(60)
	@ApiModelProperty(name = "gistid", value = "执行依据文号")
	private String gistid;// 执行依据文号

	public Long getRegdate() {
		return regdate;
	}

	public void setRegdate(Long regdate) {
		this.regdate = regdate;
	}

	public String getCasecode() {
		return casecode;
	}

	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getGistid() {
		return gistid;
	}

	public void setGistid(String gistid) {
		this.gistid = gistid;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}

	
}
