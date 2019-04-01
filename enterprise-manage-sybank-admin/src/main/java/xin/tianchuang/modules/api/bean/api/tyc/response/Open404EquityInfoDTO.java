package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open404EquityInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7442298922576828848L;
	private String equityAmount;// 出质股权数额 varchar(20)
	private String regNumber;// 登记编号 varchar(50)
	private String pledgee;// 质权人 varchar(255)
	private Long putDate;// 股权出质设立发布日期 毫秒数
	private List<Open404EquityInfoPledgeeListDTO> companyList;// 公司列表
	private String pledgorStr;// 跳转到天眼查链接
	private List<Open404EquityInfoPledgeeListDTO> pledgeeList;// 质权人列表
	private Long regDate;// 股权出质设立登记日期 毫秒数
	private List<Open404EquityInfoPledgeeListDTO> pledgorList;// 出质人列表
	private String state;// 状态 varchar(31)
	private String pledgor;// 出质人 varchar(255)
	private String certifNumberR;// 质权人证照/证件号码 varchar(20)
	private String certifNumber;// 证照/证件号码 varchar(20)
	private String pledgeeStr;// 跳转到天眼查链接

	public String getEquityAmount() {
		return equityAmount;
	}

	public void setEquityAmount(String equityAmount) {
		this.equityAmount = equityAmount;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getPledgee() {
		return pledgee;
	}

	public void setPledgee(String pledgee) {
		this.pledgee = pledgee;
	}

	public Long getPutDate() {
		return putDate;
	}

	public void setPutDate(Long putDate) {
		this.putDate = putDate;
	}

	public void setRegDate(Long regDate) {
		this.regDate = regDate;
	}

	public String getPledgorStr() {
		return pledgorStr;
	}

	public void setPledgorStr(String pledgorStr) {
		this.pledgorStr = pledgorStr;
	}

	public List<Open404EquityInfoPledgeeListDTO> getPledgeeList() {
		return pledgeeList;
	}

	public void setPledgeeList(List<Open404EquityInfoPledgeeListDTO> pledgeeList) {
		this.pledgeeList = pledgeeList;
	}

	public List<Open404EquityInfoPledgeeListDTO> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Open404EquityInfoPledgeeListDTO> companyList) {
		this.companyList = companyList;
	}

	public List<Open404EquityInfoPledgeeListDTO> getPledgorList() {
		return pledgorList;
	}

	public void setPledgorList(List<Open404EquityInfoPledgeeListDTO> pledgorList) {
		this.pledgorList = pledgorList;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPledgor() {
		return pledgor;
	}

	public void setPledgor(String pledgor) {
		this.pledgor = pledgor;
	}

	public String getCertifNumberR() {
		return certifNumberR;
	}

	public void setCertifNumberR(String certifNumberR) {
		this.certifNumberR = certifNumberR;
	}

	public String getCertifNumber() {
		return certifNumber;
	}

	public void setCertifNumber(String certifNumber) {
		this.certifNumber = certifNumber;
	}

	public String getPledgeeStr() {
		return pledgeeStr;
	}

	public void setPledgeeStr(String pledgeeStr) {
		this.pledgeeStr = pledgeeStr;
	}

	public Long getRegDate() {
		return regDate;
	}

}
