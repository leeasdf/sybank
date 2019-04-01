package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open767CreditChinaV2DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7843897151272796816L;
	private String result;// 处罚结果 mediumtext
	private String areaName;// 区域 varchar(50)
	private String punishNumber;// 行政处罚决定书文号 varchar(200)
	private String reason;// 处罚事由 mediumtext
	private String typeSecond;// 处罚类别2 varchar(100)
	private String evidence;// 处罚依据 varchar(1000)
	private String punishStatus;// 处罚状态 varchar(10)
	private String decisionDate;// 作出行政处罚决定日期
	private String type;// 处罚类别 varchar(100)
	private String departmentName;// 作出行政处罚决定机关名称 varchar(100)
	private String punishName;// 处罚名称 varchar(500)

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPunishNumber() {
		return punishNumber;
	}

	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTypeSecond() {
		return typeSecond;
	}

	public void setTypeSecond(String typeSecond) {
		this.typeSecond = typeSecond;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getPunishStatus() {
		return punishStatus;
	}

	public void setPunishStatus(String punishStatus) {
		this.punishStatus = punishStatus;
	}

	public String getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPunishName() {
		return punishName;
	}

	public void setPunishName(String punishName) {
		this.punishName = punishName;
	}

}
