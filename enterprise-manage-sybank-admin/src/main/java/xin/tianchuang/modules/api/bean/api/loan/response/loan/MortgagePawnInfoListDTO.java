package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-动产抵押-质押信息")
public class MortgagePawnInfoListDTO {
    @ApiModelProperty(name = "detail", value = "数量、质量、状况、所在地等情况")
    private String detail;// 数量、质量、状况、所在地等情况 varchar(5000)
    @ApiModelProperty(name = "ownership", value = "所有权归属")
    private String ownership;// 所有权归属 varchar(100)
    @ApiModelProperty(name = "pawnName", value = "名称")
    private String pawnName;// 名称 varchar(100)
    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;// 备注 varchar(200)

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getPawnName() {
        return pawnName;
    }

    public void setPawnName(String pawnName) {
        this.pawnName = pawnName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
