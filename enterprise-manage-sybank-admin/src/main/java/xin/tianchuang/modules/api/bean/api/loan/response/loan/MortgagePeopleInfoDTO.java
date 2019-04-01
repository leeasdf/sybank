package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-动产抵押-抵押权人信息")
public class MortgagePeopleInfoDTO {
    @ApiModelProperty(name = "licenseNum", value = "证照/证件号码")
    private String licenseNum;// 证照/证件号码 varchar(30)
    @ApiModelProperty(name = "peopleName", value = "抵押权人名称")
    private String peopleName;// 抵押权人名称 varchar(255)
    @ApiModelProperty(name = "liceseType", value = "抵押权人证照/证件类型")
    private String liceseType;// 抵押权人证照/证件类型 varchar(255)

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getLiceseType() {
        return liceseType;
    }

    public void setLiceseType(String liceseType) {
        this.liceseType = liceseType;
    }
}
