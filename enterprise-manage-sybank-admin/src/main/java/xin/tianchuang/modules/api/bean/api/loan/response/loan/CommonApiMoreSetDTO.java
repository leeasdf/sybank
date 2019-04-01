package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-其它）")
public class CommonApiMoreSetDTO {

    private List<BidDTO> bids;

    private List<EmployDTO> employs;

    private List<NewsDTO> news;

    private OneKeyNodeDTO nodeDTO;

    private ListedInfoDTO listedInfo;

    public List<BidDTO> getBids() {
        return bids;
    }

    public void setBids(List<BidDTO> bids) {
        this.bids = bids;
    }

    public List<EmployDTO> getEmploys() {
        return employs;
    }

    public void setEmploys(List<EmployDTO> employs) {
        this.employs = employs;
    }

    public List<NewsDTO> getNews() {
        return news;
    }

    public void setNews(List<NewsDTO> news) {
        this.news = news;
    }

    public OneKeyNodeDTO getNodeDTO() {
        return nodeDTO;
    }

    public void setNodeDTO(OneKeyNodeDTO nodeDTO) {
        this.nodeDTO = nodeDTO;
    }

    public ListedInfoDTO getListedInfo() {
        return listedInfo;
    }

    public void setListedInfo(ListedInfoDTO listedInfo) {
        this.listedInfo = listedInfo;
    }
}
