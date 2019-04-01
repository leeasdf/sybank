package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-知识产权-作品著作权）")
public class CopyRegWorkDTO {

    /**
     *
     */
    @ApiModelProperty(name = "regtime", value = "登记日期")
    private String regtime;
    /**
     *
     */
    @ApiModelProperty(name = "authorNationality", value = "著作权人姓名/名称")
    private String authorNationality;
    /**
     *
     */
    @ApiModelProperty(name = "publishtime", value = "发布日期")
    private String publishtime;
    /**
     *
     */
    @ApiModelProperty(name = "regnum", value = "登记号")
    private String regnum;
    /**
     *
     */
    @ApiModelProperty(name = "finishTime", value = "创作完成日期")
    private String finishTime;
    /**
     *
     */
    @ApiModelProperty(name = "type", value = "作品类别")
    private String type;
    /**
     *
     */
    @ApiModelProperty(name = "fullname", value = "作品名称")
    private String fullname;

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
