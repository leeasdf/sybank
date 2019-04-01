package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 信用中国-基本信息
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public class CreditchinaBaseInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

//	/**
//	 * 主键
//	 */
//	@TableId
//	private Long id;
	/**
	 * 信用代码
	 */
	private String creditCode;
	/**
	 * 企业名称
	 */
	private String entName;
	/**
	 * 企业地址
	 */
	private String dom;
	/**
	 * 企业类型
	 */
	private String enttype;
	/**
	 * 成立日期
	 */
	@JSONField(format="yyyy/MM/ddHH:mm:ss.SSS")
	private Date esdate;
	/**
	 * 法人代表
	 */
	private String legal;
	/**
	 * 组织机构代码
	 */
	private String organizationCode;
	/**
	 * 注册资本
	 */
	private BigDecimal regcap;
	/**
	 * 工商注册号
	 */
	private String regno;
	/**
	 * 登记机关
	 */
	private String regorg;
	/**
	 * 修订日期
	 */
	//@JSONField (format="yyyy-MM-ddHH:mm:ss")
	private Date revdate;
	/**
	 * 有效时间
	 */
	@JSONField (format="yyyyMMdd")
	private Date validtime;
	/**
	 * 税号
	 */
	private String taxCode;
	/**
	 * 
	 */
	private Date apprdate;
	/**
	 * 
	 */
	private String area;
	/**
	 * 
	 */
	private Integer badCount;
	/**
	 * 
	 */
	@JSONField (format="yyyy/MM/ddHH:mm:ss.SSS")
	private Date candate;
	/**
	 * 
	 */
	private Integer cfCount;
	/**
	 * 
	 */
	private Integer dishonestyCount;
	/**
	 * 
	 */
	private Integer entstatus;
	/**
	 * 
	 */
	private Integer goodCount;
	/**
	 * 
	 */
	private String idcard;
	/**
	 * 
	 */
	private String opfrom;
	/**
	 * 
	 */
	private String opscope;
	/**
	 * 
	 */
	private String opto;
	/**
	 * 
	 */
	private Integer otherCount;
	/**
	 * 
	 */
	private Integer rank;
	/**
	 * 
	 */
	private Integer solrStatus;
	/**
	 * 
	 */
	private Integer source;
	/**
	 * 
	 */
	@JSONField (format="yyyy-MM-dd HH:mm:ss.SSS")
	private Date sysUpdateTime;
	/**
	 * 
	 */
	private Integer xkCount;

//	/**
//	 * 设置：主键
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}
//	/**
//	 * 获取：主键
//	 */
//	public Long getId() {
//		return id;
//	}
	/**
	 * 设置：信用代码
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：信用代码
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：企业地址
	 */
	public void setDom(String dom) {
		this.dom = dom;
	}
	/**
	 * 获取：企业地址
	 */
	public String getDom() {
		return dom;
	}
	/**
	 * 设置：企业类型
	 */
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	/**
	 * 获取：企业类型
	 */
	public String getEnttype() {
		return enttype;
	}
	/**
	 * 设置：成立日期
	 */
	public void setEsdate(Date esdate) {
		this.esdate = esdate;
	}
	/**
	 * 获取：成立日期
	 */
	public Date getEsdate() {
		return esdate;
	}
	/**
	 * 设置：法人代表
	 */
	public void setLegal(String legal) {
		this.legal = legal;
	}
	/**
	 * 获取：法人代表
	 */
	public String getLegal() {
		return legal;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：注册资本
	 */
	public void setRegcap(BigDecimal regcap) {
		this.regcap = regcap;
	}
	/**
	 * 获取：注册资本
	 */
	public BigDecimal getRegcap() {
		return regcap;
	}
	/**
	 * 设置：工商注册号
	 */
	public void setRegno(String regno) {
		this.regno = regno;
	}
	/**
	 * 获取：工商注册号
	 */
	public String getRegno() {
		return regno;
	}
	/**
	 * 设置：登记机关
	 */
	public void setRegorg(String regorg) {
		this.regorg = regorg;
	}
	/**
	 * 获取：登记机关
	 */
	public String getRegorg() {
		return regorg;
	}
	/**
	 * 设置：修订日期
	 */
	public void setRevdate(Date revdate) {
		this.revdate = revdate;
	}
	/**
	 * 获取：修订日期
	 */
	public Date getRevdate() {
		return revdate;
	}
	/**
	 * 设置：有效时间
	 */
	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}
	/**
	 * 获取：有效时间
	 */
	public Date getValidtime() {
		return validtime;
	}
	/**
	 * 设置：税号
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	/**
	 * 获取：税号
	 */
	public String getTaxCode() {
		return taxCode;
	}
	/**
	 * 设置：
	 */
	public void setApprdate(Date apprdate) {
		this.apprdate = apprdate;
	}
	/**
	 * 获取：
	 */
	public Date getApprdate() {
		return apprdate;
	}
	/**
	 * 设置：
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：
	 */
	public void setBadCount(Integer badCount) {
		this.badCount = badCount;
	}
	/**
	 * 获取：
	 */
	public Integer getBadCount() {
		return badCount;
	}
	/**
	 * 设置：
	 */
	public void setCandate(Date candate) {
		this.candate = candate;
	}
	/**
	 * 获取：
	 */
	public Date getCandate() {
		return candate;
	}
	/**
	 * 设置：
	 */
	public void setCfCount(Integer cfCount) {
		this.cfCount = cfCount;
	}
	/**
	 * 获取：
	 */
	public Integer getCfCount() {
		return cfCount;
	}
	/**
	 * 设置：
	 */
	public void setDishonestyCount(Integer dishonestyCount) {
		this.dishonestyCount = dishonestyCount;
	}
	/**
	 * 获取：
	 */
	public Integer getDishonestyCount() {
		return dishonestyCount;
	}
	/**
	 * 设置：
	 */
	public void setEntstatus(Integer entstatus) {
		this.entstatus = entstatus;
	}
	/**
	 * 获取：
	 */
	public Integer getEntstatus() {
		return entstatus;
	}
	/**
	 * 设置：
	 */
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}
	/**
	 * 获取：
	 */
	public Integer getGoodCount() {
		return goodCount;
	}
	/**
	 * 设置：
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 设置：
	 */
	public void setOpfrom(String opfrom) {
		this.opfrom = opfrom;
	}
	/**
	 * 获取：
	 */
	public String getOpfrom() {
		return opfrom;
	}
	/**
	 * 设置：
	 */
	public void setOpscope(String opscope) {
		this.opscope = opscope;
	}
	/**
	 * 获取：
	 */
	public String getOpscope() {
		return opscope;
	}
	/**
	 * 设置：
	 */
	public void setOpto(String opto) {
		this.opto = opto;
	}
	/**
	 * 获取：
	 */
	public String getOpto() {
		return opto;
	}
	/**
	 * 设置：
	 */
	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}
	/**
	 * 获取：
	 */
	public Integer getOtherCount() {
		return otherCount;
	}
	/**
	 * 设置：
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	/**
	 * 获取：
	 */
	public Integer getRank() {
		return rank;
	}
	/**
	 * 设置：
	 */
	public void setSolrStatus(Integer solrStatus) {
		this.solrStatus = solrStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getSolrStatus() {
		return solrStatus;
	}
	/**
	 * 设置：
	 */
	public void setSource(Integer source) {
		this.source = source;
	}
	/**
	 * 获取：
	 */
	public Integer getSource() {
		return source;
	}
	/**
	 * 设置：
	 */
	public void setSysUpdateTime(Date sysUpdateTime) {
		this.sysUpdateTime = sysUpdateTime;
	}
	/**
	 * 获取：
	 */
	public Date getSysUpdateTime() {
		return sysUpdateTime;
	}
	/**
	 * 设置：
	 */
	public void setXkCount(Integer xkCount) {
		this.xkCount = xkCount;
	}
	/**
	 * 获取：
	 */
	public Integer getXkCount() {
		return xkCount;
	}

}
