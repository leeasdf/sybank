package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-知识产权）")
public class CommonApiBizKnowleageSetDTO {

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

    private List<CopyRegWorkDTO> copyRegWorks;

    private List<IcpDTO> icps;

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

    public List<CopyRegWorkDTO> getCopyRegWorks() {
        return copyRegWorks;
    }

    public void setCopyRegWorks(List<CopyRegWorkDTO> copyRegWorks) {
        this.copyRegWorks = copyRegWorks;
    }

    public List<IcpDTO> getIcps() {
        return icps;
    }

    public void setIcps(List<IcpDTO> icps) {
        this.icps = icps;
    }
}
