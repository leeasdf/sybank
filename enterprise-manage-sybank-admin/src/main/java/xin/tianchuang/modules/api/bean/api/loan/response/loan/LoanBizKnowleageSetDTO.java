package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业知识产权信息集合-返回对象模型")
public class LoanBizKnowleageSetDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813958804355115272L;

	// 知识产权 商标信息、专利、软件著作权
	/**
	 * 商标
	 */
	private List<LoanBizTmDTO> tms;

	/**
	 * 专利
	 */
	private List<LoanBizPatentsDTO> patents;

	/**
	 * 软件著作权
	 */
	private List<LoanBizCopyRegDTO> copyRegs;

	public List<LoanBizCopyRegDTO> getCopyRegs() {
		return copyRegs;
	}

	public void setCopyRegs(List<LoanBizCopyRegDTO> copyRegs) {
		this.copyRegs = copyRegs;
	}

	public List<LoanBizPatentsDTO> getPatents() {
		return patents;
	}

	public void setPatents(List<LoanBizPatentsDTO> patents) {
		this.patents = patents;
	}

	public List<LoanBizTmDTO> getTms() {
		return tms;
	}

	public void setTms(List<LoanBizTmDTO> tms) {
		this.tms = tms;
	}

}
