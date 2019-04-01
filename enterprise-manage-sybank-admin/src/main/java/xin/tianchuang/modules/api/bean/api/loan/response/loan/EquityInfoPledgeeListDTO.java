package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-股权出质-质权列表")
public class EquityInfoPledgeeListDTO {

    @ApiModelProperty(name = "pledgeeId", value = "公司id")
    private String pledgeeId;// 公司id
    @ApiModelProperty(name = "pledgeeName", value = "公司名")
    private String pledgeeName;// 公司名 varchar(255)


    public String getPledgeeId() {
        return pledgeeId;
    }

    public void setPledgeeId(String pledgeeId) {
        this.pledgeeId = pledgeeId;
    }

    public String getPledgeeName() {
        return pledgeeName;
    }

    public void setPledgeeName(String pledgeeName) {
        this.pledgeeName = pledgeeName;
    }
}
