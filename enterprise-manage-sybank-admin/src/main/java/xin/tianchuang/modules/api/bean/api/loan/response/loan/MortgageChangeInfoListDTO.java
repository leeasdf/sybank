package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-动产抵押-变更信息")
public class MortgageChangeInfoListDTO {
    @ApiModelProperty(name = "changeDate", value = "变更日期", example = "1211212")
    private Long changeDate;// 变更日期 毫秒数
    @ApiModelProperty(name = "changeContent", value = "变更内容")
    private String changeContent;// 变更内容 varchar(500)

    public Long getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Long changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }
}
