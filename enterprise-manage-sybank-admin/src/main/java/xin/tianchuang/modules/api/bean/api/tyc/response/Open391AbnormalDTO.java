package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open391AbnormalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5137459954773474126L;
	@SerializedName("createTime")
	private String abnormalCreateTime;// 创建时间
	private String putDate;// 列入日期
	private String removeDate;// 移出日期
	private String removeDepartment;// 移出部门 varchar(200)
	private String removeReason;// 移除异常名录原因 varchar(4091)
	private String putReason;// 列入异常名录原因 varchar(4091)
	private String putDepartment;// 决定列入异常名录部门(作出决定机关) varchar(200)

	public String getAbnormalCreateTime() {
		return abnormalCreateTime;
	}

	public void setAbnormalCreateTime(String abnormalCreateTime) {
		this.abnormalCreateTime = abnormalCreateTime;
	}

	public String getPutDate() {
		return putDate;
	}

	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}

	public String getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(String removeDate) {
		this.removeDate = removeDate;
	}

	public String getRemoveDepartment() {
		return removeDepartment;
	}

	public void setRemoveDepartment(String removeDepartment) {
		this.removeDepartment = removeDepartment;
	}

	public String getRemoveReason() {
		return removeReason;
	}

	public void setRemoveReason(String removeReason) {
		this.removeReason = removeReason;
	}

	public String getPutReason() {
		return putReason;
	}

	public void setPutReason(String putReason) {
		this.putReason = putReason;
	}

	public String getPutDepartment() {
		return putDepartment;
	}

	public void setPutDepartment(String putDepartment) {
		this.putDepartment = putDepartment;
	}

}
