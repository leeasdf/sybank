package xin.tianchuang.modules.api.bean.v1;





import java.io.Serializable;

/**
 * 企业-司法协助信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */

public class RptTnJudicialAidDTO implements Serializable {
	

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2100604564141720093L;
	/**
	 * 被执行人
	 */
	private String executedPerson;
	/**
	 * 股权数额
	 */
	private String equityAmountOther;
	/**
	 * 执行法院
	 */
	private String executiveCourt;
	/**
	 * 执行通知文号
	 */
	private String executeNoticeNum;
	/**
	 * 类型|状态
	 */
	private String executedPersonType;

	/**
	 * 设置：被执行人
	 */
	public void setExecutedPerson(String executedPerson) {
		this.executedPerson = executedPerson;
	}
	/**
	 * 获取：被执行人
	 */
	public String getExecutedPerson() {
		return executedPerson;
	}
	/**
	 * 设置：股权数额
	 */
	public void setEquityAmountOther(String equityAmountOther) {
		this.equityAmountOther = equityAmountOther;
	}
	/**
	 * 获取：股权数额
	 */
	public String getEquityAmountOther() {
		return equityAmountOther;
	}
	/**
	 * 设置：执行法院
	 */
	public void setExecutiveCourt(String executiveCourt) {
		this.executiveCourt = executiveCourt;
	}
	/**
	 * 获取：执行法院
	 */
	public String getExecutiveCourt() {
		return executiveCourt;
	}
	/**
	 * 设置：执行通知文号
	 */
	public void setExecuteNoticeNum(String executeNoticeNum) {
		this.executeNoticeNum = executeNoticeNum;
	}
	/**
	 * 获取：执行通知文号
	 */
	public String getExecuteNoticeNum() {
		return executeNoticeNum;
	}
	/**
	 * 设置：类型|状态
	 */
	public void setExecutedPersonType(String executedPersonType) {
		this.executedPersonType = executedPersonType;
	}
	/**
	 * 获取：类型|状态
	 */
	public String getExecutedPersonType() {
		return executedPersonType;
	}

}
