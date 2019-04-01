package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-经营风险-经营异常")
public class AbnormalDTO {

    @ApiModelProperty(name = "putDate", value = "列入日期")
    private String putDate;
    /**
     *
     */
    @ApiModelProperty(name = "removeDate", value = "移出日期")
    private String removeDate;
    /**
     *
     */
    @ApiModelProperty(name = "removeDepartment", value = "移出部门")
    private String removeDepartment;
    /**
     *
     */
    @ApiModelProperty(name = "removeReason", value = "移除异常名录原因")
    private String removeReason;
    /**
     *
     */
    @ApiModelProperty(name = "putReason", value = "列入异常名录原因")
    private String putReason;
    /**
     *
     */
    @ApiModelProperty(name = "putDepartment", value = "决定列入异常名录部门(作出决定机关)")
    private String putDepartment;

    public String getPutDate() {
        return putDate;
    }

    public void setPutDate(String putDate) {
        this.putDate = putDate;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getRemoveDepartment() {
        return removeDepartment;
    }

    public void setRemoveDepartment(String removeDepartment) {
        this.removeDepartment = removeDepartment;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getPutReason() {
        return putReason;
    }

    public void setPutReason(String putReason) {
        this.putReason = putReason;
    }

    public String getPutDepartment() {
        return putDepartment;
    }

    public void setPutDepartment(String putDepartment) {
        this.putDepartment = putDepartment;
    }
}
