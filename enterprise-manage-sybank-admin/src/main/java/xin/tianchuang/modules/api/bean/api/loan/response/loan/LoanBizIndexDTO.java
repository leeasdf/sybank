package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/8.
 */
@ApiModel(value = "全景图-首页信息")
public class LoanBizIndexDTO {

	@ApiModelProperty(name = "baseinfo", value = "工商基本信息")
	private LoanViewBizBaseInfoDTO baseinfo;

	// @ApiModelProperty(name = "loanBizChangeinfos", value = "工商重大变更信息列表")
	private List<LoanViewBizChangeinfoDTO> changeInfos;

	@ApiModelProperty(name = "accusedCount", value = "司法信息-被告信息条数")
	private Integer accusedCount;

	@ApiModelProperty(name = "execMoney", value = "司法信息-被执行标的总额")
	private Double execMoney;

	// @ApiModelProperty(name = "news", value = "经营风险-无风险或负面舆情信息")
	private List<LoanViewBizNewsDTO> news;

	public LoanViewBizBaseInfoDTO getBaseinfo() {
		return baseinfo;
	}

	public void setBaseinfo(LoanViewBizBaseInfoDTO baseinfo) {
		this.baseinfo = baseinfo;
	}

    public List<LoanViewBizChangeinfoDTO> getChangeInfos() {
        return changeInfos;
    }

    public void setChangeInfos(List<LoanViewBizChangeinfoDTO> changeInfos) {
        this.changeInfos = changeInfos;
    }

    public Integer getAccusedCount() {
		return accusedCount;
	}

	public void setAccusedCount(Integer accusedCount) {
		this.accusedCount = accusedCount;
	}

	public Double getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(Double execMoney) {
		this.execMoney = execMoney;
	}

	public List<LoanViewBizNewsDTO> getNews() {
		return news;
	}

	public void setNews(List<LoanViewBizNewsDTO> news) {
		this.news = news;
	}

}
