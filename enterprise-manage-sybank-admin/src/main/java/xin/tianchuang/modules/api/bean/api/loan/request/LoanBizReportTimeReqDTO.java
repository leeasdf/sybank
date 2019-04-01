package xin.tianchuang.modules.api.bean.api.loan.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by lee on 2019/3/22.
 */
public class LoanBizReportTimeReqDTO extends BaseLoanBizReqDTO {

    private static final long serialVersionUID = -1925186108918139420L;

    @ApiModelProperty(value = "balanceTime", name = "资产负债表时间", example = "2019-03-03", required = true)
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date balanceTime;

    @ApiModelProperty(value = "profitTime", example = "2019-01", name = "利润表时间")
    private String profitTime;

    @ApiModelProperty(value = "creditCode", example = "91110000802100433B", name = "公司名称和统一社会信用代码不能同时为空")
    private String creditCode;

    @ApiModelProperty(value = "data", name = "数据（此处存为json字符串)")
    private String data;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getBalanceTime() {
        return balanceTime;
    }

    public void setBalanceTime(Date balanceTime) {
        this.balanceTime = balanceTime;
    }

    public String getProfitTime() {
        return profitTime;
    }

    public void setProfitTime(String profitTime) {
        this.profitTime = profitTime;
    }
}
