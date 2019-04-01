package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

public class Open777DishonestV2DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7398216504162330644L;
	private String iname;// 失信人名称 varchar(60)
	private String businessentity;// 法人、负责人姓名 varchar(60)
	private String gistid;// 执行依据文号 varchar(100)
	private String areaname;// 省份地区 varchar(30)
	private String cardnum;// 身份证号码/组织机构代码 varchar(30)
	private String courtname;// 法院 varchar(50)
	private String type;// 失信人类型，0代表人，1代表公司
	private Long publishdate;// 发布时间 毫秒数
	private String performedPart;// 已履行部分 mediumtext
	private List<Open777DishonestV2StaffDTO> staff = Lists.newArrayList();// 法定负责人/主要负责人信息 text
	private String gistunit;// 做出执行的依据单位 varchar(60)
	private String unperformPart;// 未履行部分 mediumtext
	private String duty;// 生效法律文书确定的义务 mediumtext
	private String performance;// 履行情况 varchar(60)
	private Long regdate;// 立案时间 毫秒数
	private String casecode;// 案号 varchar(50)
	private String disrupttypename;// 失信被执行人行为具体情形 varchar(2000)
	private String cpwsUrl;
	@SerializedName("id")
	private String tycId;

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getBusinessentity() {
		return businessentity;
	}

	public void setBusinessentity(String businessentity) {
		this.businessentity = businessentity;
	}

	public String getGistid() {
		return gistid;
	}

	public void setGistid(String gistid) {
		this.gistid = gistid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Long publishdate) {
		this.publishdate = publishdate;
	}

	public String getPerformedPart() {
		return performedPart;
	}

	public void setPerformedPart(String performedPart) {
		this.performedPart = performedPart;
	}

	public List<Open777DishonestV2StaffDTO> getStaff() {
		return staff;
	}

	public void setStaff(List<Open777DishonestV2StaffDTO> staff) {
		this.staff = staff;
	}

	public String getGistunit() {
		return gistunit;
	}

	public void setGistunit(String gistunit) {
		this.gistunit = gistunit;
	}

	public String getUnperformPart() {
		return unperformPart;
	}

	public void setUnperformPart(String unperformPart) {
		this.unperformPart = unperformPart;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public Long getRegdate() {
		return regdate;
	}

	public void setRegdate(Long regdate) {
		this.regdate = regdate;
	}

	public String getCasecode() {
		return casecode;
	}

	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	public String getDisrupttypename() {
		return disrupttypename;
	}

	public void setDisrupttypename(String disrupttypename) {
		this.disrupttypename = disrupttypename;
	}

	public String getCpwsUrl() {
		return cpwsUrl;
	}

	public void setCpwsUrl(String cpwsUrl) {
		this.cpwsUrl = cpwsUrl;
	}

	public String getTycId() {
		return tycId;
	}

	public void setTycId(String tycId) {
		this.tycId = tycId;
	}

}
