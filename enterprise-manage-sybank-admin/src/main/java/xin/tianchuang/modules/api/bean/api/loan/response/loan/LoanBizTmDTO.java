package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业商标信息-返回对象模型")
public class LoanBizTmDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6662781538485197151L;

	@ApiModelProperty(name = "tmName", value = "商标名称")
	private String tmName;// 商标名称 varchar(600)
//	@ApiModelProperty(name = "status", value = "状态")
//	private String status;// 状态 varchar(50)
	@ApiModelProperty(name = "appDate", value = "申请日期[毫秒数]")
	private String appDate;// 申请日期 毫秒数
	@ApiModelProperty(name = "regNo", value = "注册号")
	private String regNo;// 注册号 varchar(20)
	
//	@ApiModelProperty(name = "tmClass", value = "国际分类code")
//	private String tmClass;// 国际分类code

	@ApiModelProperty(name = "category", value = "商标状态")
	private String category;// 状态 varchar(50)
	
	@ApiModelProperty(name = "intCls", value = "国际分类code")
	private String intCls;// 国际分类

	public String getTmName() {
		return tmName;
	}

	public void setTmName(String tmName) {
		this.tmName = tmName;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIntCls() {
		return intCls;
	}

	public void setIntCls(String intCls) {
		this.intCls = intCls;
	}
	

}
