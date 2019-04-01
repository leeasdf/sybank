package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业-动产抵押信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnMortgageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878368684015845982L;
	/**
	 * 被担保债权数额
	 */
	private String overviewAmount;
	/**
	 * 经营范围
	 */
	private String scope;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 担保范围
	 */
	private String overviewScope;
	/**
	 * 担保ID
	 */
	private String mId;
	/**
	 * 金额
	 */
	private String amount;
	/**
	 * 登记机关
	 */
	private String regDepartment;
	/**
	 * 登记日期
	 */
	private String regDate;
	/**
	 * 担保1时间
	 */
	private String overviewTerm;
	/**
	 * 登记编号
	 */
	private String regNum;
	/**
	 * 债务人履行债务期限
	 */
	private String term;
	/**
	 * 公布日期
	 */
	private String publishDate;
	/**
	 * 动产抵押登记信息
	 */
	private String changeInfoList;
	/**
	 * 抵押物信息
	 */
	private String pawnInfoList;
	/**
	 * 抵押权人信息
	 */
	private String peopleInfo;

	/**
	 * 设置：被担保债权数额
	 */
	public void setOverviewAmount(String overviewAmount) {
		this.overviewAmount = overviewAmount;
	}

	/**
	 * 获取：被担保债权数额
	 */
	public String getOverviewAmount() {
		return overviewAmount;
	}

	/**
	 * 设置：经营范围
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * 获取：经营范围
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置：担保范围
	 */
	public void setOverviewScope(String overviewScope) {
		this.overviewScope = overviewScope;
	}

	/**
	 * 获取：担保范围
	 */
	public String getOverviewScope() {
		return overviewScope;
	}

	/**
	 * 设置：担保ID
	 */
	public void setMId(String mId) {
		this.mId = mId;
	}

	/**
	 * 获取：担保ID
	 */
	public String getMId() {
		return mId;
	}

	/**
	 * 设置：金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 获取：金额
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 设置：登记机关
	 */
	public void setRegDepartment(String regDepartment) {
		this.regDepartment = regDepartment;
	}

	/**
	 * 获取：登记机关
	 */
	public String getRegDepartment() {
		return regDepartment;
	}

	/**
	 * 设置：登记日期
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	/**
	 * 获取：登记日期
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * 设置：担保1时间
	 */
	public void setOverviewTerm(String overviewTerm) {
		this.overviewTerm = overviewTerm;
	}

	/**
	 * 获取：担保1时间
	 */
	public String getOverviewTerm() {
		return overviewTerm;
	}

	/**
	 * 设置：登记编号
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	/**
	 * 获取：登记编号
	 */
	public String getRegNum() {
		return regNum;
	}

	/**
	 * 设置：债务人履行债务期限
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * 获取：债务人履行债务期限
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * 设置：公布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：公布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：动产抵押登记信息
	 */
	public void setChangeInfoList(String changeInfoList) {
		this.changeInfoList = changeInfoList;
	}

	/**
	 * 获取：动产抵押登记信息
	 */
	public String getChangeInfoList() {
		return changeInfoList;
	}

	/**
	 * 设置：抵押物信息
	 */
	public void setPawnInfoList(String pawnInfoList) {
		this.pawnInfoList = pawnInfoList;
	}

	/**
	 * 获取：抵押物信息
	 */
	public String getPawnInfoList() {
		return pawnInfoList;
	}

	/**
	 * 设置：抵押权人信息
	 */
	public void setPeopleInfo(String peopleInfo) {
		this.peopleInfo = peopleInfo;
	}

	/**
	 * 获取：抵押权人信息
	 */
	public String getPeopleInfo() {
		return peopleInfo;
	}

}
