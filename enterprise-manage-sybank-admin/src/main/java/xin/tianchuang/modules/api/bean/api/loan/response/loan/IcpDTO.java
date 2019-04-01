package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-知识产权-网站备案）")
public class IcpDTO {
    /**
     *
     */
    @ApiModelProperty(name = "websites", value = "网站")
    private String websites;
    /**
     *
     */
    @ApiModelProperty(name = "examineDate", value = "检查时间")
    private String examineDate;
    /**
     *
     */
    @ApiModelProperty(name = "companyType", value = "公司类型")
    private String companyType;
    /**
     *
     */
    @ApiModelProperty(name = "webName", value = "网站名称")
    private String webName;
    /**
     *
     */
    @ApiModelProperty(name = "ym", value = "域名")
    private String ym;
    /**
     *
     */
    @ApiModelProperty(name = "liscense", value = "许可证")
    private String liscense;
    /**
     *
     */
    @ApiModelProperty(name = "companyName", value = "公司名称")
    private String companyName;

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public String getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(String examineDate) {
        this.examineDate = examineDate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getYm() {
        return ym;
    }

    public void setYm(String ym) {
        this.ym = ym;
    }

    public String getLiscense() {
        return liscense;
    }

    public void setLiscense(String liscense) {
        this.liscense = liscense;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
