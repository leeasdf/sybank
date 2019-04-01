package xin.tianchuang.modules.api.bean.api.tyc.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "信用百科请求对象模型")
public class BizRequestParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6680111339757520353L;

	/**
	 * 公司id
	 */
	@ApiModelProperty(value = "companyId", name = "公司id", example = "10")
	private Long companyId;
	/**
	 * 公司名称
	 */
	@ApiModelProperty(value = "name", name = "企业名称", example = "平安银行股份有限公司")
	@NotBlank(message = "企业名称name不能为空")
	@NotNull
	private String name;

	/**
	 * 当前页数（默认第一页，每页10条或者20条）
	 */
	@ApiModelProperty(value = "pageNum", name = "当前页数", example = "1")
	private Integer pageNum;

	/**
	 * 每页条数（默认10或者20）
	 */
	@ApiModelProperty(value = "pageSize", name = "每页条数", example = "10")
	private Integer pageSize;

	@ApiModelProperty(hidden = true)
	private String channelType;

	@ApiModelProperty(hidden = true)
	private String creditCode;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

}
