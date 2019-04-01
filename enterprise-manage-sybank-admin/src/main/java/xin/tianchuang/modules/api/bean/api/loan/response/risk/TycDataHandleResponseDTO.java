package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户信息
 * 
 * @author denghui
 *
 */
@ApiModel(value = "天眼查加工处理返回对象模型")
public class TycDataHandleResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2382117959921468426L;

	@ApiModelProperty(name = "name", value = "企业名称")
	private String name; // 企业名称

	@ApiModelProperty(name = "operationDuration", value = "经营年限")
	private BigDecimal operationDuration;
	@ApiModelProperty(name = "enterpriseNature", value = "企业性质")
	private String enterpriseNature;
	@ApiModelProperty(name = "industryClassEvaluate", value = "行业分类评价")
	private String industryClassEvaluate;
	@ApiModelProperty(name = "socialSecurityPayerNo", value = "社保缴费人数")
	private Integer socialSecurityPayerNo;
	@ApiModelProperty(name = "changeAggregateVar", value = "变更信息综合变量")
	private BigDecimal changeAggregateVar;
	@ApiModelProperty(name = "capitalMarketFinancing", value = "资本市场融资信息")
	private String capitalMarketFinancing;
	@ApiModelProperty(name = "stockMortgageNo", value = "股权与动产质押信息数量")
	private Integer stockMortgageNo;
	@ApiModelProperty(name = "judicialWeightedNo", value = "司法信息加权数量")
	private BigDecimal judicialWeightedNo;
	@ApiModelProperty(name = "administrativePenaltyNo", value = "行政处罚信息数量")
	private Integer administrativePenaltyNo;
	@ApiModelProperty(name = "abnormalNo", value = "经营异常信息数量")
	private Integer abnormalNo;
	@ApiModelProperty(name = "oweTaxNo", value = "欠税公告信息数量")
	private Integer oweTaxNo;
	@ApiModelProperty(name = "negativeNewsWeightedNo", value = "负面新闻舆情加权数量")
	private Integer negativeNewsWeightedNo;
	@ApiModelProperty(name = "employInfoNo", value = "招聘信息数量")
	private Integer employInfoNo;
	@ApiModelProperty(name = "intellectualPropertyRightsNo", value = "知识产权数量")
	private BigDecimal intellectualPropertyRightsNo;
	@ApiModelProperty(name = "bidsNo", value = "招投标信息数量")
	private Integer bidsNo;
	@ApiModelProperty(name = "icpNo", value = "网站备案")
	private Integer icpNo;
	@ApiModelProperty(name = "newsNo", value = "新闻舆情数量")
	private BigDecimal newsNo;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOperationDuration() {
		return operationDuration;
	}

	public void setOperationDuration(BigDecimal operationDuration) {
		this.operationDuration = operationDuration;
	}

	public String getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public String getIndustryClassEvaluate() {
		return industryClassEvaluate;
	}

	public void setIndustryClassEvaluate(String industryClassEvaluate) {
		this.industryClassEvaluate = industryClassEvaluate;
	}

	public Integer getSocialSecurityPayerNo() {
		return socialSecurityPayerNo;
	}

	public void setSocialSecurityPayerNo(Integer socialSecurityPayerNo) {
		this.socialSecurityPayerNo = socialSecurityPayerNo;
	}

	public BigDecimal getChangeAggregateVar() {
		return changeAggregateVar;
	}

	public void setChangeAggregateVar(BigDecimal changeAggregateVar) {
		this.changeAggregateVar = changeAggregateVar;
	}

	public String getCapitalMarketFinancing() {
		return capitalMarketFinancing;
	}

	public void setCapitalMarketFinancing(String capitalMarketFinancing) {
		this.capitalMarketFinancing = capitalMarketFinancing;
	}

	public Integer getStockMortgageNo() {
		return stockMortgageNo;
	}

	public void setStockMortgageNo(Integer stockMortgageNo) {
		this.stockMortgageNo = stockMortgageNo;
	}

	public BigDecimal getJudicialWeightedNo() {
		return judicialWeightedNo;
	}

	public void setJudicialWeightedNo(BigDecimal judicialWeightedNo) {
		this.judicialWeightedNo = judicialWeightedNo;
	}

	public Integer getAdministrativePenaltyNo() {
		return administrativePenaltyNo;
	}

	public void setAdministrativePenaltyNo(Integer administrativePenaltyNo) {
		this.administrativePenaltyNo = administrativePenaltyNo;
	}

	public Integer getAbnormalNo() {
		return abnormalNo;
	}

	public void setAbnormalNo(Integer abnormalNo) {
		this.abnormalNo = abnormalNo;
	}

	public Integer getOweTaxNo() {
		return oweTaxNo;
	}

	public void setOweTaxNo(Integer oweTaxNo) {
		this.oweTaxNo = oweTaxNo;
	}

	public Integer getNegativeNewsWeightedNo() {
		return negativeNewsWeightedNo;
	}

	public void setNegativeNewsWeightedNo(Integer negativeNewsWeightedNo) {
		this.negativeNewsWeightedNo = negativeNewsWeightedNo;
	}

	public Integer getEmployInfoNo() {
		return employInfoNo;
	}

	public void setEmployInfoNo(Integer employInfoNo) {
		this.employInfoNo = employInfoNo;
	}

	public BigDecimal getIntellectualPropertyRightsNo() {
		return intellectualPropertyRightsNo;
	}

	public void setIntellectualPropertyRightsNo(BigDecimal intellectualPropertyRightsNo) {
		this.intellectualPropertyRightsNo = intellectualPropertyRightsNo;
	}

	public Integer getBidsNo() {
		return bidsNo;
	}

	public void setBidsNo(Integer bidsNo) {
		this.bidsNo = bidsNo;
	}

	public Integer getIcpNo() {
		return icpNo;
	}

	public void setIcpNo(Integer icpNo) {
		this.icpNo = icpNo;
	}

	public BigDecimal getNewsNo() {
		return newsNo;
	}

	public void setNewsNo(BigDecimal newsNo) {
		this.newsNo = newsNo;
	}

}
