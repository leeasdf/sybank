package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-经营风险-欠税信息）")
public class OwnTaxDTO {

    /**
     *
     */
    @ApiModelProperty(name = "regType", value = "注册类型")
    private String regType;
    /**
     *
     */
    @ApiModelProperty(name = "personIdNumber", value = "证件号码")
    private String personIdNumber;
    /**
     *
     */
    @ApiModelProperty(name = "legalpersonName", value = "法人或负责人名称")
    private String legalpersonName;
    /**
     *
     */
    @ApiModelProperty(name = "location", value = "经营地点")
    private String location;
    /**
     *
     */
    @ApiModelProperty(name = "ownTaxAmount", value = "欠税金额")
    private String ownTaxAmount;
    /**
     *
     */
    @ApiModelProperty(name = "department", value = "部门")
    private String department;
    /**
     *
     */
    @ApiModelProperty(name = "taxIdNumber", value = "纳税人识别号")
    private String taxIdNumber;
    /**
     *
     */
    @ApiModelProperty(name = "type", value = "税务类型")
    private String type;
    /**
     *
     */
    @ApiModelProperty(name = "taxCategory", value = "欠税税种")
    private String taxCategory;
    /**
     *
     */
    @ApiModelProperty(name = "taxpayerType", value = "纳税人类型")
    private String taxpayerType;
    /**
     *
     */
    @ApiModelProperty(name = "newOwnTaxBalance", value = "当前新发生欠税余额")
    private String newOwnTaxBalance;
    /**
     *
     */
    @ApiModelProperty(name = "ownTaxBalance", value = "欠税余额")
    private String ownTaxBalance;
    /**
     *
     */
    @ApiModelProperty(name = "name", value = "纳税人名称")
    private String name;
    /**
     *
     */
    @ApiModelProperty(name = "personIdName", value = "法人证件名称")
    private String personIdName;
    /**
     *
     */
    @ApiModelProperty(name = "publishDate", value = "发布时间")
    private String publishDate;

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getPersonIdNumber() {
        return personIdNumber;
    }

    public void setPersonIdNumber(String personIdNumber) {
        this.personIdNumber = personIdNumber;
    }

    public String getLegalpersonName() {
        return legalpersonName;
    }

    public void setLegalpersonName(String legalpersonName) {
        this.legalpersonName = legalpersonName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnTaxAmount() {
        return ownTaxAmount;
    }

    public void setOwnTaxAmount(String ownTaxAmount) {
        this.ownTaxAmount = ownTaxAmount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getNewOwnTaxBalance() {
        return newOwnTaxBalance;
    }

    public void setNewOwnTaxBalance(String newOwnTaxBalance) {
        this.newOwnTaxBalance = newOwnTaxBalance;
    }

    public String getOwnTaxBalance() {
        return ownTaxBalance;
    }

    public void setOwnTaxBalance(String ownTaxBalance) {
        this.ownTaxBalance = ownTaxBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonIdName() {
        return personIdName;
    }

    public void setPersonIdName(String personIdName) {
        this.personIdName = personIdName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
