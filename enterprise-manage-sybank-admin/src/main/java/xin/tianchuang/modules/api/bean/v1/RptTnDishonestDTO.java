package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 失信人信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnDishonestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3486462845286376848L;
	/**
	 * 
	 */
	private String regdate;
	/**
	 * 
	 */
	private String casecode;
	/**
	 * 
	 */
	private String courtname;
	/**
	 * 
	 */
	private String performance;
	/**
	 * 
	 */
	private String gistid;

	/**
	 * 
	 */
	private String date;
	/**
	 * 
	 */
	private String type;
	/**
	 * 执行法院结果
	 */
	private String result;
	/**
	 * 
	 */
	private String iname;
	/**
	 * 
	 */
	private String businessentity;
	/**
	 * 
	 */
	private String areaname;
	/**
	 * 
	 */
	private String cardnum;
	/**
	 * 
	 */
	private String publishdate;
	/**
	 * 
	 */
	private String gistunit;
	/**
	 * 
	 */
	private String duty;
	/**
	 * 
	 */
	private String disrupttypename;

	/**
	 * 设置：
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	/**
	 * 获取：
	 */
	public String getRegdate() {
		return regdate;
	}

	/**
	 * 设置：
	 */
	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	/**
	 * 获取：
	 */
	public String getCasecode() {
		return casecode;
	}

	/**
	 * 设置：
	 */
	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	/**
	 * 获取：
	 */
	public String getCourtname() {
		return courtname;
	}

	/**
	 * 设置：
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}

	/**
	 * 获取：
	 */
	public String getPerformance() {
		return performance;
	}

	/**
	 * 设置：
	 */
	public void setGistid(String gistid) {
		this.gistid = gistid;
	}

	/**
	 * 获取：
	 */
	public String getGistid() {
		return gistid;
	}

	/**
	 * 设置：
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 获取：
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：执行法院结果
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 获取：执行法院结果
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 设置：
	 */
	public void setIname(String iname) {
		this.iname = iname;
	}

	/**
	 * 获取：
	 */
	public String getIname() {
		return iname;
	}

	/**
	 * 设置：
	 */
	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}

	/**
	 * 获取：
	 */
	public String getBusinessentity() {
		return businessentity;
	}

	/**
	 * 设置：
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	/**
	 * 获取：
	 */
	public String getAreaname() {
		return areaname;
	}

	/**
	 * 设置：
	 */
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	/**
	 * 获取：
	 */
	public String getCardnum() {
		return cardnum;
	}

	/**
	 * 设置：
	 */
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	/**
	 * 获取：
	 */
	public String getPublishdate() {
		return publishdate;
	}

	/**
	 * 设置：
	 */
	public void setGistunit(String gistunit) {
		this.gistunit = gistunit;
	}

	/**
	 * 获取：
	 */
	public String getGistunit() {
		return gistunit;
	}

	/**
	 * 设置：
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * 获取：
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * 设置：
	 */
	public void setDisrupttypename(String disrupttypename) {
		this.disrupttypename = disrupttypename;
	}

	/**
	 * 获取：
	 */
	public String getDisrupttypename() {
		return disrupttypename;
	}
}
