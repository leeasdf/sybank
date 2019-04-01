package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-经营风险-行政处罚-信用中国（新版）")
public class PunishCreditChinaDTO {
    /**
     *
     */
    @ApiModelProperty(name = "result", value = "处罚结果")
    private String result;
    /**
     *
     */
    @ApiModelProperty(name = "areaName", value = "区域")
    private String areaName;
    /**
     *
     */
    @ApiModelProperty(name = "punishNumber", value = "行政处罚决定书文号")
    private String punishNumber;
    /**
     *
     */
    @ApiModelProperty(name = "reason", value = "处罚事由")
    private String reason;
    /**
     *
     */
    @ApiModelProperty(name = "typeSecond", value = "处罚类别2")
    private String typeSecond;
    /**
     *
     */
    @ApiModelProperty(name = "evidence", value = "处罚依据")
    private String evidence;
    /**
     *
     */
    @ApiModelProperty(name = "punishStatus", value = "处罚状态")
    private String punishStatus;
    /**
     *
     */
    @ApiModelProperty(name = "decisionDate", value = "作出行政处罚决定日期")
    private String decisionDate;
    /**
     *
     */
    @ApiModelProperty(name = "type", value = "处罚类别")
    private String type;
    /**
     *
     */
    @ApiModelProperty(name = "departmentName", value = "作出行政处罚决定机关名称")
    private String departmentName;
    /**
     *
     */
    @ApiModelProperty(name = "punishName", value = "处罚名称")
    private String punishName;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPunishNumber() {
        return punishNumber;
    }

    public void setPunishNumber(String punishNumber) {
        this.punishNumber = punishNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTypeSecond() {
        return typeSecond;
    }

    public void setTypeSecond(String typeSecond) {
        this.typeSecond = typeSecond;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getPunishStatus() {
        return punishStatus;
    }

    public void setPunishStatus(String punishStatus) {
        this.punishStatus = punishStatus;
    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPunishName() {
        return punishName;
    }

    public void setPunishName(String punishName) {
        this.punishName = punishName;
    }
}
