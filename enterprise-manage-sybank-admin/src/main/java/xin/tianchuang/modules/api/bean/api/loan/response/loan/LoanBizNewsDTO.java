package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业舆情信息-返回对象模型")
public class LoanBizNewsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1040838492406514741L;

	@ApiModelProperty(name = "title", value = "新闻标题")
	private String title;// 新闻标题 varchar(150)
	@ApiModelProperty(name = "website", value = "来源")
	private String website;// 来源 varchar(50)
	@ApiModelProperty(name = "time", value = "时间")
	private String time;// 时间 varchar(50)

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
