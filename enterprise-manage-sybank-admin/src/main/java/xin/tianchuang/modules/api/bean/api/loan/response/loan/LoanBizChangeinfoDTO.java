package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业变更信息-返回对象模型")
public class LoanBizChangeinfoDTO {

    @ApiModelProperty(name = "changeItem", value = "变更项")
    private String changeItem;
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
    /**
     *
     */
    @ApiModelProperty(name = "changeItem", value = "变更时间")
    private String changeTime;

    @ApiModelProperty(name = "changeType", value = "变更类型")
    private String changeType;

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getChangeItem() {
        return changeItem;
    }

    public void setChangeItem(String changeItem) {
        this.changeItem = changeItem;
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

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }
}
