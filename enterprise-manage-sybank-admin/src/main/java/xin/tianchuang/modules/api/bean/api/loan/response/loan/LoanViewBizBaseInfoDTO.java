package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lee on 2019/3/21.
 */
@ApiModel(value = "全景图-基本信息-返回对象")
public class LoanViewBizBaseInfoDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4794541142383144444L;

    @ApiModelProperty(name = "name", value = "企业名称")
    private String name; // 企业名称

    @ApiModelProperty(name = "creditCode", value = "统一社会信用代码")
    private String creditCode; // 统一社会信用代码[varchar(255)]

    @ApiModelProperty(name = "estiblishTime", value = "成立时间" , example = "2019-01-01")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date estiblishTime; // 企业状态[varchar(31)]

    @ApiModelProperty(name = "companyOrgType", value = "企业性质")
    private String companyOrgType; // 企业类型[varchar(127)]

    @ApiModelProperty(name = "regCapital", value = "注册资本")
    private String regCapital; // 注册资本[varchar(50)]

    @ApiModelProperty(name = "regLocation", value = "企业地址")
    private String regLocation; // 法人[varchar(120)]


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Date getEstiblishTime() {
        return estiblishTime;
    }

    public void setEstiblishTime(Date estiblishTime) {
        this.estiblishTime = estiblishTime;
    }

    public String getCompanyOrgType() {
        return companyOrgType;
    }

    public void setCompanyOrgType(String companyOrgType) {
        this.companyOrgType = companyOrgType;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegLocation() {
        return regLocation;
    }

    public void setRegLocation(String regLocation) {
        this.regLocation = regLocation;
    }
}
