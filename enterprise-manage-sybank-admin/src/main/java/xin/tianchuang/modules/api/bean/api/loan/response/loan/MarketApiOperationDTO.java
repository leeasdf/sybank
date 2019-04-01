package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/14.
 *
 */
@ApiModel(value = "营销报告-天眼查数据-信用历史相关）")
public class MarketApiOperationDTO {
    /**
     * 商标
     */
    private List<LoanBizTmDTO> tms;

    /**
     * 专利
     */
    private List<LoanBizPatentsDTO> patents;

    /**
     * 著作权
     */
    private List<LoanBizCopyRegDTO> copyRegs;
    /**
     * 舆情
     */
    private List<NewsDTO> news;
    /**
     * 上市信息
     */
    private ListedInfoDTO listedInfo;

    public List<LoanBizTmDTO> getTms() {
        return tms;
    }

    public void setTms(List<LoanBizTmDTO> tms) {
        this.tms = tms;
    }

    public List<LoanBizPatentsDTO> getPatents() {
        return patents;
    }

    public void setPatents(List<LoanBizPatentsDTO> patents) {
        this.patents = patents;
    }

    public List<LoanBizCopyRegDTO> getCopyRegs() {
        return copyRegs;
    }

    public void setCopyRegs(List<LoanBizCopyRegDTO> copyRegs) {
        this.copyRegs = copyRegs;
    }

    public List<NewsDTO> getNews() {
        return news;
    }

    public void setNews(List<NewsDTO> news) {
        this.news = news;
    }

    public ListedInfoDTO getListedInfo() {
        return listedInfo;
    }

    public void setListedInfo(ListedInfoDTO listedInfo) {
        this.listedInfo = listedInfo;
    }
}
