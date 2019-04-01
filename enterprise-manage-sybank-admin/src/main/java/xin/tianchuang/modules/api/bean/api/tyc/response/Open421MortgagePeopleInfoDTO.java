package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open421MortgagePeopleInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 17952559873867196L;
	private String licenseNum;// 证照/证件号码 varchar(30)
	private String peopleName;// 抵押权人名称 varchar(255)
	private String liceseType;// 抵押权人证照/证件类型 varchar(255)

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public String getLiceseType() {
		return liceseType;
	}

	public void setLiceseType(String liceseType) {
		this.liceseType = liceseType;
	}

}
