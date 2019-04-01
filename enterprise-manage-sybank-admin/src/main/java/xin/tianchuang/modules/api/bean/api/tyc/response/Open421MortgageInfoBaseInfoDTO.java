package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open421MortgageInfoBaseInfoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6299518861326584080L;
	private String overviewAmount;// 概况数额（已废弃） varchar(50)
	private String scope;// 担保范围 varchar(1000)
	private String status;// 状态 varchar(100)
	private String remark;// 备注 varchar(1000)
	private String regDate;// 登记日期
	private String overviewType;// 概况种类（已废弃） varchar(50)
	private String type;// 被担保债权种类 varchar(50)
	private String cancelReason;// 注销原因 varchar(500)
	private String overviewScope;// 概况担保的范围（已废弃） varchar(500)
	@SerializedName("id")
	private Long tableId;// 表id
	private String amount;// 被担保债权数额 varchar(50)
	private String overviewRemark;// 概况备注（已废弃） varchar(1000)
	private String overviewTerm;// 概况债务人履行债务的期限（已废弃） varchar(1000)
	private String regDepartment;// 登记机关 varchar(255)
	private String regNum;// 登记编号 varchar(100)
	private String term;// 债务人履行债务的期限 varchar(1000)
	private String base;// 省份 varchar(4)
	private Long cancelDate;// 注销日期 毫秒数
	private Long publishDate;// 公示日期 毫秒数

	public String getOverviewAmount() {
		return overviewAmount;
	}

	public void setOverviewAmount(String overviewAmount) {
		this.overviewAmount = overviewAmount;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getOverviewType() {
		return overviewType;
	}

	public void setOverviewType(String overviewType) {
		this.overviewType = overviewType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getOverviewScope() {
		return overviewScope;
	}

	public void setOverviewScope(String overviewScope) {
		this.overviewScope = overviewScope;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOverviewRemark() {
		return overviewRemark;
	}

	public void setOverviewRemark(String overviewRemark) {
		this.overviewRemark = overviewRemark;
	}

	public String getOverviewTerm() {
		return overviewTerm;
	}

	public void setOverviewTerm(String overviewTerm) {
		this.overviewTerm = overviewTerm;
	}

	public String getRegDepartment() {
		return regDepartment;
	}

	public void setRegDepartment(String regDepartment) {
		this.regDepartment = regDepartment;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Long getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Long cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Long getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Long publishDate) {
		this.publishDate = publishDate;
	}
}
