package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-股权出质")
public class EquityInfoDTO {
    @ApiModelProperty(name = "equityAmount", value = "出质股权数额")
    private String equityAmount;// 出质股权数额 varchar(20)
    @ApiModelProperty(name = "regNumber", value = "登记编号")
    private String regNumber;// 登记编号 varchar(50)
    @ApiModelProperty(name = "pledgee", value = "质权人")
    private String pledgee;// 质权人 varchar(255)
    @ApiModelProperty(name = "putDate", value = "股权出质设立发布日期", example = "121212")
    private Long putDate;// 股权出质设立发布日期 毫秒数
    @ApiModelProperty(name = "companyList", value = "公司列表")
    private List<EquityInfoPledgeeListDTO> companyList;// 公司列表
    @ApiModelProperty(name = "pledgorStr", value = "跳转到天眼查链接")
    private String pledgorStr;// 跳转到天眼查链接
    @ApiModelProperty(name = "pledgeeList", value = "质权人列表")
    private List<EquityInfoPledgeeListDTO> pledgeeList;// 质权人列表
    @ApiModelProperty(name = "regDate", value = "股权出质设立登记日期", example = "121212")
    private Long regDate;// 股权出质设立登记日期 毫秒数
    @ApiModelProperty(name = "pledgorList", value = "出质人列表")
    private List<EquityInfoPledgeeListDTO> pledgorList;// 出质人列表
    @ApiModelProperty(name = "state", value = "状态")
    private String state;// 状态 varchar(31)
    @ApiModelProperty(name = "pledgor", value = "出质人")
    private String pledgor;// 出质人 varchar(255)
    @ApiModelProperty(name = "certifNumberR", value = "质权人证照/证件号码")
    private String certifNumberR;// 质权人证照/证件号码 varchar(20)
    @ApiModelProperty(name = "certifNumber", value = "证照/证件号码")
    private String certifNumber;// 证照/证件号码 varchar(20)
    @ApiModelProperty(name = "pledgeeStr", value = "跳转到天眼查链接")
    private String pledgeeStr;// 跳转到天眼查链接


    public String getEquityAmount() {
        return equityAmount;
    }

    public void setEquityAmount(String equityAmount) {
        this.equityAmount = equityAmount;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    public Long getPutDate() {
        return putDate;
    }

    public void setPutDate(Long putDate) {
        this.putDate = putDate;
    }

    public List<EquityInfoPledgeeListDTO> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<EquityInfoPledgeeListDTO> companyList) {
        this.companyList = companyList;
    }

    public String getPledgorStr() {
        return pledgorStr;
    }

    public void setPledgorStr(String pledgorStr) {
        this.pledgorStr = pledgorStr;
    }

    public List<EquityInfoPledgeeListDTO> getPledgeeList() {
        return pledgeeList;
    }

    public void setPledgeeList(List<EquityInfoPledgeeListDTO> pledgeeList) {
        this.pledgeeList = pledgeeList;
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }

    public List<EquityInfoPledgeeListDTO> getPledgorList() {
        return pledgorList;
    }

    public void setPledgorList(List<EquityInfoPledgeeListDTO> pledgorList) {
        this.pledgorList = pledgorList;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getCertifNumberR() {
        return certifNumberR;
    }

    public void setCertifNumberR(String certifNumberR) {
        this.certifNumberR = certifNumberR;
    }

    public String getCertifNumber() {
        return certifNumber;
    }

    public void setCertifNumber(String certifNumber) {
        this.certifNumber = certifNumber;
    }

    public String getPledgeeStr() {
        return pledgeeStr;
    }

    public void setPledgeeStr(String pledgeeStr) {
        this.pledgeeStr = pledgeeStr;
    }
}
