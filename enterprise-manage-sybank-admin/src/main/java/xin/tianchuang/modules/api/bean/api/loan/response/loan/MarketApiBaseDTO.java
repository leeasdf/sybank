package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/13.
 *
 */
@ApiModel(value = "营销报告-天眼查数据-基本信息相关）")
public class MarketApiBaseDTO {

    /**
     * 工商信息
     */
    private LoanBizBaseinfoDTO baseInfo;

    /**
     * 主要人员
     */
    private List<LoanBizStaffDTO> staffs;
    /**
     * 股东信息
     */
    private List<LoanBizHolderDTO> holders;

    /**
     * 对外投资
     */
    private List<LoanBizInverstDTO> inversts;

    /**
     * 分支机构
     */
    private List<LoanBizBranchDTO> branches;

    /**
     * 关系图谱
     */
    private OneKeyNodeDTO nodeDTO;

    public LoanBizBaseinfoDTO getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(LoanBizBaseinfoDTO baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<LoanBizStaffDTO> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<LoanBizStaffDTO> staffs) {
        this.staffs = staffs;
    }

    public List<LoanBizHolderDTO> getHolders() {
        return holders;
    }

    public void setHolders(List<LoanBizHolderDTO> holders) {
        this.holders = holders;
    }

    public List<LoanBizInverstDTO> getInversts() {
        return inversts;
    }

    public void setInversts(List<LoanBizInverstDTO> inversts) {
        this.inversts = inversts;
    }

    public List<LoanBizBranchDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<LoanBizBranchDTO> branches) {
        this.branches = branches;
    }

    public OneKeyNodeDTO getNodeDTO() {
        return nodeDTO;
    }

    public void setNodeDTO(OneKeyNodeDTO nodeDTO) {
        this.nodeDTO = nodeDTO;
    }
}
