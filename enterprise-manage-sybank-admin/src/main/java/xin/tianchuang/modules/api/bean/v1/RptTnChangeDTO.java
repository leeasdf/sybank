package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业变更记录
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnChangeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4262632719354970540L;
	/**
	 * 变更时间
	 */
	private String changeDate;
	/**
	 * 变更后
	 */
	private String changeAfter;

	// private String changeAfterSrc;
	/**
	 * 变更项
	 */
	private String changeItem;
	/**
	 * 变更前
	 */
	private String changeBefore;

	// private String changeBeforeSrc;

	/**
	 * 设置：变更时间
	 */
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * 获取：变更时间
	 */
	public String getChangeDate() {
		return changeDate;
	}

	/**
	 * 设置：变更后
	 */
	public void setChangeAfter(String changeAfter) {
		this.changeAfter = changeAfter;
	}

	/**
	 * 获取：变更后
	 */
	public String getChangeAfter() {
		return changeAfter;
	}

	/**
	 * 设置：变更项
	 */
	public void setChangeItem(String changeItem) {
		this.changeItem = changeItem;
	}

	/**
	 * 获取：变更项
	 */
	public String getChangeItem() {
		return changeItem;
	}

	/**
	 * 设置：变更前
	 */
	public void setChangeBefore(String changeBefore) {
		this.changeBefore = changeBefore;
	}

	/**
	 * 获取：变更前
	 */
	public String getChangeBefore() {
		return changeBefore;
	}

}
