package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业开庭公告原告/上诉人-对象模型")
public class LoanBizKtannouncementPlaintiffDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8733696494638873854L;

	@ApiModelProperty(name = "name", value = "人或公司名")
	private String name;// String 人或公司名 varchar(255);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
