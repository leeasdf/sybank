package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业基本信息集合-返回对象模型")
public class LoanBizBaseinfoSetDTO implements Serializable {

	// 工商信息 基本信息、股东信息、高管信息、对外投资、分支机构、关联关系图谱
	/**
	 * 
	 */
	private static final long serialVersionUID = 574864670092267259L;

	/**
	 * 工商信息
	 */
	private LoanBizBaseinfoDTO baseInfo;

	/**
	 * 股东信息
	 */
	private List<LoanBizHolderDTO> holders;

	/**
	 * 高管信息
	 */
	private List<LoanBizStaffDTO> staffs;
	/**
	 * 对外投资
	 */
	private List<LoanBizInverstDTO> inversts;

	/**
	 * 分支机构
	 */
	private List<LoanBizBranchDTO> branches;

	/**
	 * 企业关系
	 */
	private LoanBizOneKeyCDTO companyReleations;

	public LoanBizBaseinfoDTO getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(LoanBizBaseinfoDTO baseInfo) {
		this.baseInfo = baseInfo;
	}

	public List<LoanBizHolderDTO> getHolders() {
		return holders;
	}

	public void setHolders(List<LoanBizHolderDTO> holders) {
		this.holders = holders;
	}

	public List<LoanBizStaffDTO> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<LoanBizStaffDTO> staffs) {
		this.staffs = staffs;
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

	public LoanBizOneKeyCDTO getCompanyReleations() {
		return companyReleations;
	}

	public void setCompanyReleations(LoanBizOneKeyCDTO companyReleations) {
		this.companyReleations = companyReleations;
	}


}
