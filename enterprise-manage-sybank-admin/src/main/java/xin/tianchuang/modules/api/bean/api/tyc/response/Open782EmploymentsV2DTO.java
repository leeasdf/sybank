package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open782EmploymentsV2DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4695681915294005514L;
	private String education;// 学历
	private String jobFirstClass;// 一级分类
	private String city;// 公司地点
	private String companyName;// 公司名称
	private String description;// 工作描述
	private String companyNameMws;// 公司名称
	private String source;// 招聘信息来源
	private String title;// 职位
	private String experience;// 经验
	private Long startdate;// 开始时间
	private String companyLng;// 企业纬度
	private String paramRegStatus;// 公司状态
	private String eventTime;// 无用
	@SerializedName("id")
	private String tableId;// 企业id
	private String companyLat;// 经度
	private String oriSalary;// 薪水
	private String estiblishTimeLong;// 成立时间
	@SerializedName("class")
	private String employClass;// 招聘类别 全职，兼职
	private String companyCity;// 公司地址
	private String searchType;// 搜索类型
	@SerializedName("_type")
	private String type;// 无用
	private String categoryCode;// 无用
	private String urlPath;// 招聘信息地址url
	private String employerNumber;// 雇员数量
	private String categoryCodeNew;// 无用
	private String uni;// 无用
	private String companyId;// 公司id
	private String deleted;// 0-未删除 1-删除
	private String paramRegCapital;// 注册资本
	private Long enddate;// 招聘结束时间
	private String paramRegYear;// 注册年
	@SerializedName("createTime")
	private String employCreateTime;// 创建时间
	private String fromUrl;// 省份
	private String district;// 区
	private String location;// 具体地址
	private String base;// 地点简称 各地的首字母拼接

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobFirstClass() {
		return jobFirstClass;
	}

	public void setJobFirstClass(String jobFirstClass) {
		this.jobFirstClass = jobFirstClass;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyNameMws() {
		return companyNameMws;
	}

	public void setCompanyNameMws(String companyNameMws) {
		this.companyNameMws = companyNameMws;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Long getStartdate() {
		return startdate;
	}

	public void setStartdate(Long startdate) {
		this.startdate = startdate;
	}

	public String getCompanyLng() {
		return companyLng;
	}

	public void setCompanyLng(String companyLng) {
		this.companyLng = companyLng;
	}

	public String getParamRegStatus() {
		return paramRegStatus;
	}

	public void setParamRegStatus(String paramRegStatus) {
		this.paramRegStatus = paramRegStatus;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getCompanyLat() {
		return companyLat;
	}

	public void setCompanyLat(String companyLat) {
		this.companyLat = companyLat;
	}

	public String getOriSalary() {
		return oriSalary;
	}

	public void setOriSalary(String oriSalary) {
		this.oriSalary = oriSalary;
	}

	public String getEstiblishTimeLong() {
		return estiblishTimeLong;
	}

	public void setEstiblishTimeLong(String estiblishTimeLong) {
		this.estiblishTimeLong = estiblishTimeLong;
	}

	public String getEmployClass() {
		return employClass;
	}

	public void setEmployClass(String employClass) {
		this.employClass = employClass;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getEmployerNumber() {
		return employerNumber;
	}

	public void setEmployerNumber(String employerNumber) {
		this.employerNumber = employerNumber;
	}

	public String getCategoryCodeNew() {
		return categoryCodeNew;
	}

	public void setCategoryCodeNew(String categoryCodeNew) {
		this.categoryCodeNew = categoryCodeNew;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getParamRegCapital() {
		return paramRegCapital;
	}

	public void setParamRegCapital(String paramRegCapital) {
		this.paramRegCapital = paramRegCapital;
	}

	public Long getEnddate() {
		return enddate;
	}

	public void setEnddate(Long enddate) {
		this.enddate = enddate;
	}

	public String getParamRegYear() {
		return paramRegYear;
	}

	public void setParamRegYear(String paramRegYear) {
		this.paramRegYear = paramRegYear;
	}

	public String getEmployCreateTime() {
		return employCreateTime;
	}

	public void setEmployCreateTime(String employCreateTime) {
		this.employCreateTime = employCreateTime;
	}

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

}
