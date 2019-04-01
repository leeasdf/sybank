package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-其它信息-上市信息）")
public class ListedInfoDTO {

    @ApiModelProperty(name = "bondName", value = "股票名")
    private String bondName; // 股票名[varchar(20)]
    @ApiModelProperty(name = "bondType", value = "股票类型")
    private String bondType; // 股票类型[varchar(31)]
    @ApiModelProperty(name = "bondNum", value = "股票号")
    private String bondNum; // 股票号[varchar(20)]

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public String getBondNum() {
        return bondNum;
    }

    public void setBondNum(String bondNum) {
        this.bondNum = bondNum;
    }
}
