package xin.tianchuang.modules.api.bean.api.tyc.request;

import java.io.Serializable;

import xin.tianchuang.modules.spider.entity.EntListInfoEntity;

public class BaseApiRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 401595623446686825L;

	/**
	 * 公司名称
	 */
	private String name;

	/**
	 * 统一社会信用代码
	 */
	private String creditCode;

	private String bizCode;

	private String seqNum;

	private String channelType;

	/**
	 * 公司id
	 */
	private Long companyId;

	/**
	 * 当前页数（默认第一页，每页10条或者20条）
	 */
	private Integer pageNum;

	/**
	 * 每页条数（默认10或者20）
	 */
	private Integer pageSize;

	/**
	 * 贷后预警同步标识，如果为true，这标识要计算新增、变更数据信息等，然后标记信息
	 */
	// private Boolean loanWarnSyncFlag = false;

	private EntListInfoEntity entListInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
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

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public EntListInfoEntity getEntListInfo() {
		return entListInfo;
	}

	public void setEntListInfo(EntListInfoEntity entListInfo) {
		this.entListInfo = entListInfo;
	}

}
