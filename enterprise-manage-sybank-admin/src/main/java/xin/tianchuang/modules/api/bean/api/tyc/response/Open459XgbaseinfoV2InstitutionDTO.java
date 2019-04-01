package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open459XgbaseinfoV2InstitutionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6678111898701982460L;
	private String scope; // 宗旨和业务范围
	private String regUnitNameSecond; // 第二举办单位
	private String regUnitName; // 举办单位名称
	private Integer entityType; // 1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会
	private Integer type; //
	@SerializedName("id")
	private Long tycId; // id
	private Boolean haveReport; // 是否有年报
	private String regCapital; // 注册资本
	private String name; // 单位名称
	private String regUnitNameThird; // 第三举办单位
	private String regLocation; // 地址
	private String nameSecond; // 第二名称
	private String regUnit; // 举办单位
	private String expendSource; // 经费来源
	private String nameThird; // 第三名称
	private String logo; // logo
	private String usCreditCode; // 统一社会信用代码
	private String regStatus; // 经营状态
	private String legalPersonName; // 法人
	private String regUnitNameOther; // 其它举办单位
	private Long legalPersonId; // 法人id
	private String address; // 地址
	private String holdUnit; // 登记管理机关
	private String validTime; // 有效期
	private String base; // 省份
	private String oldCert; // 原证书号
	private String nameOther; // 其他名称
	private String weibo; // 微博

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRegUnitNameSecond() {
		return regUnitNameSecond;
	}

	public void setRegUnitNameSecond(String regUnitNameSecond) {
		this.regUnitNameSecond = regUnitNameSecond;
	}

	public String getRegUnitName() {
		return regUnitName;
	}

	public void setRegUnitName(String regUnitName) {
		this.regUnitName = regUnitName;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public Boolean getHaveReport() {
		return haveReport;
	}

	public void setHaveReport(Boolean haveReport) {
		this.haveReport = haveReport;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegUnitNameThird() {
		return regUnitNameThird;
	}

	public void setRegUnitNameThird(String regUnitNameThird) {
		this.regUnitNameThird = regUnitNameThird;
	}

	public String getRegLocation() {
		return regLocation;
	}

	public void setRegLocation(String regLocation) {
		this.regLocation = regLocation;
	}

	public String getNameSecond() {
		return nameSecond;
	}

	public void setNameSecond(String nameSecond) {
		this.nameSecond = nameSecond;
	}

	public String getRegUnit() {
		return regUnit;
	}

	public void setRegUnit(String regUnit) {
		this.regUnit = regUnit;
	}

	public String getExpendSource() {
		return expendSource;
	}

	public void setExpendSource(String expendSource) {
		this.expendSource = expendSource;
	}

	public String getNameThird() {
		return nameThird;
	}

	public void setNameThird(String nameThird) {
		this.nameThird = nameThird;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUsCreditCode() {
		return usCreditCode;
	}

	public void setUsCreditCode(String usCreditCode) {
		this.usCreditCode = usCreditCode;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getRegUnitNameOther() {
		return regUnitNameOther;
	}

	public void setRegUnitNameOther(String regUnitNameOther) {
		this.regUnitNameOther = regUnitNameOther;
	}

	public Long getLegalPersonId() {
		return legalPersonId;
	}

	public void setLegalPersonId(Long legalPersonId) {
		this.legalPersonId = legalPersonId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHoldUnit() {
		return holdUnit;
	}

	public void setHoldUnit(String holdUnit) {
		this.holdUnit = holdUnit;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getOldCert() {
		return oldCert;
	}

	public void setOldCert(String oldCert) {
		this.oldCert = oldCert;
	}

	public String getNameOther() {
		return nameOther;
	}

	public void setNameOther(String nameOther) {
		this.nameOther = nameOther;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}