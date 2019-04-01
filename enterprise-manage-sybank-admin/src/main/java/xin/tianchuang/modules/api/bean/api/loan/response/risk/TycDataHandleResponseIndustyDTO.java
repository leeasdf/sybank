package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lee on 2019/3/11.
 */
@ApiModel(value = "获取所以企业对应的行业的模型对象")
public class TycDataHandleResponseIndustyDTO implements Serializable {

    private static final long serialVersionUID = -2382117959921468498L;

    @ApiModelProperty(name = "name", value = "企业名称")
    private String name; // 企业名称

    @ApiModelProperty(name = "name", value = "企业行业" ,example = "1")
    private String industry;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
