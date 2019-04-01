package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 行政处罚信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnPenaltiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7956260902064109133L;
	/**
	 * 决定日期
	 */
	private String decisionDate;
	/**
	 * 决定书文号
	 */
	private String punishNumber;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 决定机关
	 */
	private String departmentName;
	/**
	 * 处罚内容
	 */
	private String content;
	/**
	 * 地域
	 */
	private String areaName;
	/**
	 * 处罚名称
	 */
	private String punishmentName;

	/**
	 * 注册号
	 */
	private String regNum;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 发布日期
	 */
	private String publishDate;
	/**
	 * 地点
	 */
	private String base;
	/**
	 * 法人
	 */
	private String legalPersonName;

	/**
	 * 设置：决定日期
	 */
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	/**
	 * 获取：决定日期
	 */
	public String getDecisionDate() {
		return decisionDate;
	}

	/**
	 * 设置：决定书文号
	 */
	public void setPunishNumber(String punishNumber) {
		this.punishNumber = punishNumber;
	}

	/**
	 * 获取：决定书文号
	 */
	public String getPunishNumber() {
		return punishNumber;
	}

	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：决定机关
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * 获取：决定机关
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 设置：处罚内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：处罚内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：地域
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 获取：地域
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置：处罚名称
	 */
	public void setPunishmentName(String punishmentName) {
		this.punishmentName = punishmentName;
	}

	/**
	 * 获取：处罚名称
	 */
	public String getPunishmentName() {
		return punishmentName;
	}

	/**
	 * 设置：注册号
	 */
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	/**
	 * 获取：注册号
	 */
	public String getRegNum() {
		return regNum;
	}

	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：发布日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：发布日期
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：地点
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * 获取：地点
	 */
	public String getBase() {
		return base;
	}

	/**
	 * 设置：法人
	 */
	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	/**
	 * 获取：法人
	 */
	public String getLegalPersonName() {
		return legalPersonName;
	}
}
