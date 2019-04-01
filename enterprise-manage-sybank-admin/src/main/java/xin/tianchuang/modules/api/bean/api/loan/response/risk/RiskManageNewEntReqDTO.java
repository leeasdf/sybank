package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * Created by lee on 2019/3/11.
 */
@ApiModel(value = "高管驾驶舱-添加新企业名单 模型")
public class RiskManageNewEntReqDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2678055589102999404L;

	@ApiModelProperty(name = "name", value = "企业名称")
    @NotBlank(message = "企业名称name不能为空")
    private String name;

    @ApiModelProperty(value = "creditCode", name = "统一社会信用代码", example = "12321312413")
    private String creditCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }
}
