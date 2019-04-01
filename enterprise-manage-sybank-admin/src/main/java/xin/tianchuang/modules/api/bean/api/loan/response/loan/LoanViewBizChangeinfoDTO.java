package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "全景图-企业重大变更信息列表-返回对象")
public class LoanViewBizChangeinfoDTO {

//    @ApiModelProperty(name = "changeItem", value = "变更项")
//    private String changeItem;
    /**
     *
     */
    @ApiModelProperty(name = "changeItem", value = "变更前")
    private String contentBefore;
    /**
     *
     */
    @ApiModelProperty(name = "changeItem", value = "变更后")
    private String contentAfter;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "changeItem", value = "变更时间")
//    private String changeTime;

    @ApiModelProperty(name = "changeType", value = "变更类型")
    private String changeType;

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }


    public String getContentBefore() {
        return contentBefore;
    }

    public void setContentBefore(String contentBefore) {
        this.contentBefore = contentBefore;
    }

    public String getContentAfter() {
        return contentAfter;
    }

    public void setContentAfter(String contentAfter) {
        this.contentAfter = contentAfter;
    }

}
