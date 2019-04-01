package xin.tianchuang.modules.api.bean.api.loan.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by lee on 2019/3/19.
 */
@ApiModel(value = "业务系统企业信息-请求对象模型-分页查询处理")
public class RiskManageBizPageReqDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -289536517815792119L;

	/**
	 * 业务请求编号
	 */
	@ApiModelProperty(value = "bizCode", name = "业务请求编号", example = "2018010100001R", required = true)
	@NotBlank(message = "业务请求编号不能为空")
	private String bizCode;

	@ApiModelProperty(hidden = true)
	private String seqNum = UUID.randomUUID().toString().replace("-", "");

	@ApiModelProperty(value = "pageSize", name = "分页大小", example = "50")
	private Integer pageSize;
	@ApiModelProperty(value = "page", name = "页面", example = "1")
	private Integer page;
	@ApiModelProperty(value = "startTime", name = "开始时间", example = "2019-03-03", required = true)
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date startTime;
	@ApiModelProperty(value = "endTime", name = "结束时间", example = "2019-03-03", required = true)
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date endTime;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

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

}
