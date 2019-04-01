package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业-软件著作权返回对象模型")
public class LoanBizCopyRegDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2771402053289576458L;
	@ApiModelProperty(name = "fullname", value = "全称")
	private String fullname;// 全称 varchar(200)
	@ApiModelProperty(name = "version", value = "版本号")
	private String version;// 版本号 varchar(45)
	@ApiModelProperty(name = "publishtime", value = "首次发表日期")
	private String publishtime;// 首次发表日期
	@ApiModelProperty(name = "simplename", value = "简称")
	private String simplename;// 简称 varchar(200)
	@ApiModelProperty(name = "regnum", value = "登记号")
	private String regnum;// 登记号 varchar(45)
	@ApiModelProperty(name = "eventTime", value = "批准日期[毫秒数]")
	private String eventTime;// 批准日期 毫秒数

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

}
