package xin.tianchuang.modules.api.bean.api.loan.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "基础请求对象模型")
public class BaseLoanBizReqDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -473405442084118858L;
	/**
	 * 企业名称
	 */
	@ApiModelProperty(value = "name", name = "企业名称", example = "中亚新材料科技泗阳有限公司", required = true ,dataType ="String")
	@NotBlank(message = "企业名称name不能为空")
	@Size(min = 1, max = 255, message = "企业名称长度为1-255之间")
	private String name;

	/**
	 * 业务请求编号
	 */
	@ApiModelProperty(value = "bizCode", name = "业务请求编号", example = "2018010100001R", required = true)
	@NotBlank(message = "业务请求编号不能为空")
	private String bizCode;

	@ApiModelProperty(hidden = true)
	private String seqNum = UUID.randomUUID().toString().replace("-", "");

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
