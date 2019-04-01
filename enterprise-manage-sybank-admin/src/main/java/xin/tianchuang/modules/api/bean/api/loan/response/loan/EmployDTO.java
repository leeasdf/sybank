package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-其它信息-招聘信息）")
public class EmployDTO {

    /**
     *
     */
    @ApiModelProperty(name = "education", value = "学历")
    private String education;
    /**
     *
     */
    @ApiModelProperty(name = "jobFirstClass", value = "一级分类")
    private String jobFirstClass;
    /**
     *
     */
    @ApiModelProperty(name = "city", value = "所在城市")
    private String city;
    /**
     *
     */
    @ApiModelProperty(name = "companyName", value = "公司名称")
    private String companyName;
    /**
     *
     */
    @ApiModelProperty(name = "description", value = "工作描述")
    private String description;
    /**
     *
     */
    @ApiModelProperty(name = "companyNameMws", value = "公司名称")
    private String companyNameMws;
    /**
     *
     */
    @ApiModelProperty(name = "source", value = "招聘信息来源")
    private String source;
    /**
     *
     */
    @ApiModelProperty(name = "title", value = "职位")
    private String title;
    /**
     *
     */
    @ApiModelProperty(name = "experience", value = "经验")
    private String experience;
    /**
     *
     */
    @ApiModelProperty(name = "startdate", value = "开始时间")
    private Long startdate;
    /**
     *
     */
    @ApiModelProperty(name = "companyLng", value = "企业纬度")
    private String companyLng;
    /**
     *
     */
    @ApiModelProperty(name = "paramRegStatus", value = "公司状态")
    private String paramRegStatus;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "eventTime", value = "无用")
//    private String eventTime;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "tableId", value = "企业id")
//    private String tableId;
    /**
     *
     */
    @ApiModelProperty(name = "companyLat", value = "经度")
    private String companyLat;
    /**
     *
     */
    @ApiModelProperty(name = "oriSalary", value = "薪水")
    private String oriSalary;
    /**
     *
     */
    @ApiModelProperty(name = "stablishTimeLong", value = "成立时间")
    private String stablishTimeLong;
    /**
     *
     */
    @ApiModelProperty(name = "employClass", value = "招聘类别")
    private String employClass;
    /**
     *
     */
    @ApiModelProperty(name = "companyCity", value = "公司地址")
    private String companyCity;
    /**
     *
     */
    @ApiModelProperty(name = "searchType", value = "搜索类型")
    private String searchType;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "type", value = "无用")
//    private String type;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "categoryCode", value = "无用")
//    private String categoryCode;
    /**
     *
     */
    @ApiModelProperty(name = "urlPath", value = "招聘信息地址url")
    private String urlPath;
    /**
     *
     */
    @ApiModelProperty(name = "employerNumber", value = "雇员数量")
    private String employerNumber;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "categoryCodeNew", value = "无用")
//    private String categoryCodeNew;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "uni", value = "无用")
//    private String uni;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "companyId", value = "公司id")
//    private String companyId;
    /**
     *
     */
    @ApiModelProperty(name = "deleted", value = "0-未删除 1-删除")
    private String deleted;
    /**
     *
     */
    @ApiModelProperty(name = "paramRegCapital", value = "注册资本")
    private String paramRegCapital;
    /**
     *
     */
    @ApiModelProperty(name = "enddate", value = "招聘结束时间")
    private Long enddate;
    /**
     *
     */
    @ApiModelProperty(name = "paramRegYear", value = "注册年")
    private String paramRegYear;
    /**
     *
     */
    @ApiModelProperty(name = "employCreateTime", value = "创建时间")
    private String employCreateTime;
    /**
     *
     */
    @ApiModelProperty(name = "fromUrl", value = "公司地址")
    private String fromUrl;
    /**
     *
     */
    @ApiModelProperty(name = "district", value = "区")
    private String district;
    /**
     *
     */
    @ApiModelProperty(name = "location", value = "工作地址")
    private String location;
    /**
     *
     */
    @ApiModelProperty(name = "base", value = "省份简称")
    private String base;

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

    public String getStablishTimeLong() {
        return stablishTimeLong;
    }

    public void setStablishTimeLong(String stablishTimeLong) {
        this.stablishTimeLong = stablishTimeLong;
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
