package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open371AnnualreportDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6519845689226656610L;

	private Open371AnnualreportBaseInfoDTO baseInfo;

	private String companyId;

	private List<Open371AnnualreportChangeRecordDTO> changeRecordList;

	private List<Open371AnnualreportEquityChangeInfoDTO> equityChangeInfoList;
	private List<Open371AnnualreportOutGuaranteeInfoDTO> outGuaranteeInfoList;
	private List<Open371AnnualreportOutboundInvestmentDTO> outboundInvestmentList;
	private List<Open371AnnualreportShareholderDTO> shareholderList;
	private List<Open371AnnualreportWebInfoDTO> webInfoList;
	private Open371AnnualreportReportSocialSecurityInfoDTO reportSocialSecurityInfo;

	private String govReport; // 无用

	private String type; // 无用

	public Open371AnnualreportBaseInfoDTO getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(Open371AnnualreportBaseInfoDTO baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public List<Open371AnnualreportChangeRecordDTO> getChangeRecordList() {
		return changeRecordList;
	}

	public void setChangeRecordList(List<Open371AnnualreportChangeRecordDTO> changeRecordList) {
		this.changeRecordList = changeRecordList;
	}

	public List<Open371AnnualreportEquityChangeInfoDTO> getEquityChangeInfoList() {
		return equityChangeInfoList;
	}

	public void setEquityChangeInfoList(List<Open371AnnualreportEquityChangeInfoDTO> equityChangeInfoList) {
		this.equityChangeInfoList = equityChangeInfoList;
	}

	public List<Open371AnnualreportOutGuaranteeInfoDTO> getOutGuaranteeInfoList() {
		return outGuaranteeInfoList;
	}

	public void setOutGuaranteeInfoList(List<Open371AnnualreportOutGuaranteeInfoDTO> outGuaranteeInfoList) {
		this.outGuaranteeInfoList = outGuaranteeInfoList;
	}

	public List<Open371AnnualreportOutboundInvestmentDTO> getOutboundInvestmentList() {
		return outboundInvestmentList;
	}

	public void setOutboundInvestmentList(List<Open371AnnualreportOutboundInvestmentDTO> outboundInvestmentList) {
		this.outboundInvestmentList = outboundInvestmentList;
	}

	public List<Open371AnnualreportShareholderDTO> getShareholderList() {
		return shareholderList;
	}

	public void setShareholderList(List<Open371AnnualreportShareholderDTO> shareholderList) {
		this.shareholderList = shareholderList;
	}

	public List<Open371AnnualreportWebInfoDTO> getWebInfoList() {
		return webInfoList;
	}

	public void setWebInfoList(List<Open371AnnualreportWebInfoDTO> webInfoList) {
		this.webInfoList = webInfoList;
	}

	public Open371AnnualreportReportSocialSecurityInfoDTO getReportSocialSecurityInfo() {
		return reportSocialSecurityInfo;
	}

	public void setReportSocialSecurityInfo(Open371AnnualreportReportSocialSecurityInfoDTO reportSocialSecurityInfo) {
		this.reportSocialSecurityInfo = reportSocialSecurityInfo;
	}

	public String getGovReport() {
		return govReport;
	}

	public void setGovReport(String govReport) {
		this.govReport = govReport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
