package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:06
 */
@TableName("ENT_EMPLOY_INFO")
public class EntEmployInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer entId;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String creditCode;
	/**
	 * 
	 */
	private String education;
	/**
	 * 
	 */
	private String jobFirstClass;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String companyName;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String companyNameMws;
	/**
	 * 
	 */
	private String source;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String experience;
	/**
	 * 
	 */
	private Long startdate;
	/**
	 * 
	 */
	private String companyLng;
	/**
	 * 
	 */
	private String paramRegStatus;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String tableId;
	/**
	 * 
	 */
	private String companyLat;
	/**
	 * 
	 */
	private String oriSalary;
	/**
	 * 
	 */
	private String stablishTimeLong;
	/**
	 * 
	 */
	private String employClass;
	/**
	 * 
	 */
	private String companyCity;
	/**
	 * 
	 */
	private String searchType;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String categoryCode;
	/**
	 * 
	 */
	private String urlPath;
	/**
	 * 
	 */
	private String employerNumber;
	/**
	 * 
	 */
	private String categoryCodeNew;
	/**
	 * 
	 */
	private String uni;
	/**
	 * 
	 */
	private String companyId;
	/**
	 * 
	 */
	private String deleted;
	/**
	 * 
	 */
	private String paramRegCapital;
	/**
	 * 
	 */
	private Long enddate;
	/**
	 * 
	 */
	private String paramRegYear;
	/**
	 * 
	 */
	private String employCreateTime;
	/**
	 * 
	 */
	private String fromUrl;
	/**
	 * 
	 */
	private String district;
	/**
	 * 
	 */
	private String location;
	/**
	 * 
	 */
	private String base;
	/**
	 * 
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 
	 */
	@TableField(value = "data_status", fill = FieldFill.INSERT)
	private Integer dataStatus;
	/**
	 * 
	 */
	@Version
	private Integer version;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setEntId(Integer entId) {
		this.entId = entId;
	}
	/**
	 * 获取：
	 */
	public Integer getEntId() {
		return entId;
	}
	/**
	 * 设置：
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：
	 */
	public void setJobFirstClass(String jobFirstClass) {
		this.jobFirstClass = jobFirstClass;
	}
	/**
	 * 获取：
	 */
	public String getJobFirstClass() {
		return jobFirstClass;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNameMws(String companyNameMws) {
		this.companyNameMws = companyNameMws;
	}
	/**
	 * 获取：
	 */
	public String getCompanyNameMws() {
		return companyNameMws;
	}
	/**
	 * 设置：
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * 获取：
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * 设置：
	 */
	public void setStartdate(Long startdate) {
		this.startdate = startdate;
	}
	/**
	 * 获取：
	 */
	public Long getStartdate() {
		return startdate;
	}
	/**
	 * 设置：
	 */
	public void setCompanyLng(String companyLng) {
		this.companyLng = companyLng;
	}
	/**
	 * 获取：
	 */
	public String getCompanyLng() {
		return companyLng;
	}
	/**
	 * 设置：
	 */
	public void setParamRegStatus(String paramRegStatus) {
		this.paramRegStatus = paramRegStatus;
	}
	/**
	 * 获取：
	 */
	public String getParamRegStatus() {
		return paramRegStatus;
	}
	/**
	 * 设置：
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	/**
	 * 获取：
	 */
	public String getEventTime() {
		return eventTime;
	}
	/**
	 * 设置：
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public String getTableId() {
		return tableId;
	}
	/**
	 * 设置：
	 */
	public void setCompanyLat(String companyLat) {
		this.companyLat = companyLat;
	}
	/**
	 * 获取：
	 */
	public String getCompanyLat() {
		return companyLat;
	}
	/**
	 * 设置：
	 */
	public void setOriSalary(String oriSalary) {
		this.oriSalary = oriSalary;
	}
	/**
	 * 获取：
	 */
	public String getOriSalary() {
		return oriSalary;
	}
	/**
	 * 设置：
	 */
	public void setStablishTimeLong(String stablishTimeLong) {
		this.stablishTimeLong = stablishTimeLong;
	}
	/**
	 * 获取：
	 */
	public String getStablishTimeLong() {
		return stablishTimeLong;
	}
	/**
	 * 设置：
	 */
	public void setEmployClass(String employClass) {
		this.employClass = employClass;
	}
	/**
	 * 获取：
	 */
	public String getEmployClass() {
		return employClass;
	}
	/**
	 * 设置：
	 */
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	/**
	 * 获取：
	 */
	public String getCompanyCity() {
		return companyCity;
	}
	/**
	 * 设置：
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * 获取：
	 */
	public String getSearchType() {
		return searchType;
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
	 * 设置：
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 获取：
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 设置：
	 */
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	/**
	 * 获取：
	 */
	public String getUrlPath() {
		return urlPath;
	}
	/**
	 * 设置：
	 */
	public void setEmployerNumber(String employerNumber) {
		this.employerNumber = employerNumber;
	}
	/**
	 * 获取：
	 */
	public String getEmployerNumber() {
		return employerNumber;
	}
	/**
	 * 设置：
	 */
	public void setCategoryCodeNew(String categoryCodeNew) {
		this.categoryCodeNew = categoryCodeNew;
	}
	/**
	 * 获取：
	 */
	public String getCategoryCodeNew() {
		return categoryCodeNew;
	}
	/**
	 * 设置：
	 */
	public void setUni(String uni) {
		this.uni = uni;
	}
	/**
	 * 获取：
	 */
	public String getUni() {
		return uni;
	}
	/**
	 * 设置：
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：
	 */
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：
	 */
	public String getDeleted() {
		return deleted;
	}
	/**
	 * 设置：
	 */
	public void setParamRegCapital(String paramRegCapital) {
		this.paramRegCapital = paramRegCapital;
	}
	/**
	 * 获取：
	 */
	public String getParamRegCapital() {
		return paramRegCapital;
	}
	/**
	 * 设置：
	 */
	public void setEnddate(Long enddate) {
		this.enddate = enddate;
	}
	/**
	 * 获取：
	 */
	public Long getEnddate() {
		return enddate;
	}
	/**
	 * 设置：
	 */
	public void setParamRegYear(String paramRegYear) {
		this.paramRegYear = paramRegYear;
	}
	/**
	 * 获取：
	 */
	public String getParamRegYear() {
		return paramRegYear;
	}
	/**
	 * 设置：
	 */
	public void setEmployCreateTime(String employCreateTime) {
		this.employCreateTime = employCreateTime;
	}
	/**
	 * 获取：
	 */
	public String getEmployCreateTime() {
		return employCreateTime;
	}
	/**
	 * 设置：
	 */
	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}
	/**
	 * 获取：
	 */
	public String getFromUrl() {
		return fromUrl;
	}
	/**
	 * 设置：
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：
	 */
	public void setBase(String base) {
		this.base = base;
	}
	/**
	 * 获取：
	 */
	public String getBase() {
		return base;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}
