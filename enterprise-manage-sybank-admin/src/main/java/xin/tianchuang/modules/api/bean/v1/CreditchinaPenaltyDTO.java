package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 信用中国-行政处罚
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public class CreditchinaPenaltyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

//	/**
//	 * 主键
//	 */
//	@TableId
//	private Long id;
	/**
	 * 
	 */
	private String areaCode;
	/**
	 * 
	 */
	private String cfBz;
	/**
	 * 处罚类别
	 */
	private String cfCflb1;
	/**
	 * 
	 */
	private String cfCflb2;
	/**
	 * 处罚名称
	 */
	private String cfCfmc;
	/**
	 * 
	 */
	private String cfDfbm;
	/**
	 * 法人代表人姓名
	 */
	private String cfFr;
	/**
	 * 处罚决定日期
	 */
	@JSONField(format="yyyy/MM/dd")
	private Date cfJdrq;
	/**
	 * 处罚结果
	 */
	private String cfJg;
	/**
	 * 
	 */
	private String cfQx;
	/**
	 * 数据更新时间
	 */
	@JSONField(format="yyyy/MM/dd")
	private Date cfSjc;
	/**
	 * 处罚事由
	 */
	private String cfSy;
	/**
	 * 决定书文号
	 */
	private String cfWsh;
	/**
	 * 
	 */
	private String cfXdrGsdj;
	/**
	 * 
	 */
	private String cfXdrMc;
	/**
	 * 
	 */
	private String cfXdrSfz;
	/**
	 * 
	 */
	private String cfXdrShxym;
	/**
	 * 
	 */
	private String cfXdrSwdj;
	/**
	 * 
	 */
	private String cfXdrZdm;
	/**
	 * 
	 */
	private String cfXzbm;
	/**
	 * 处罚机关
	 */
	private String cfXzjg;
	/**
	 * 处罚依据
	 */
	private String cfYj;
	/**
	 * 
	 */
	private String cfZt;
	/**
	 * 
	 */
	private String fileId;
	/**
	 * 
	 */
	private String fingerPrint;
	/**
	 * 
	 */
	private String pv;
	/**
	 * 
	 */
	private String roleId;
	/**
	 * 
	 */
	private String subjectId;
	/**
	 * 
	 */
	private String uploadDate;

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
	 * 设置：
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：
	 */
	public void setCfBz(String cfBz) {
		this.cfBz = cfBz;
	}
	/**
	 * 获取：
	 */
	public String getCfBz() {
		return cfBz;
	}
	/**
	 * 设置：处罚类别
	 */
	public void setCfCflb1(String cfCflb1) {
		this.cfCflb1 = cfCflb1;
	}
	/**
	 * 获取：处罚类别
	 */
	public String getCfCflb1() {
		return cfCflb1;
	}
	/**
	 * 设置：
	 */
	public void setCfCflb2(String cfCflb2) {
		this.cfCflb2 = cfCflb2;
	}
	/**
	 * 获取：
	 */
	public String getCfCflb2() {
		return cfCflb2;
	}
	/**
	 * 设置：处罚名称
	 */
	public void setCfCfmc(String cfCfmc) {
		this.cfCfmc = cfCfmc;
	}
	/**
	 * 获取：处罚名称
	 */
	public String getCfCfmc() {
		return cfCfmc;
	}
	/**
	 * 设置：
	 */
	public void setCfDfbm(String cfDfbm) {
		this.cfDfbm = cfDfbm;
	}
	/**
	 * 获取：
	 */
	public String getCfDfbm() {
		return cfDfbm;
	}
	/**
	 * 设置：法人代表人姓名
	 */
	public void setCfFr(String cfFr) {
		this.cfFr = cfFr;
	}
	/**
	 * 获取：法人代表人姓名
	 */
	public String getCfFr() {
		return cfFr;
	}
	/**
	 * 设置：处罚决定日期
	 */
	public void setCfJdrq(Date cfJdrq) {
		this.cfJdrq = cfJdrq;
	}
	/**
	 * 获取：处罚决定日期
	 */
	public Date getCfJdrq() {
		return cfJdrq;
	}
	/**
	 * 设置：处罚结果
	 */
	public void setCfJg(String cfJg) {
		this.cfJg = cfJg;
	}
	/**
	 * 获取：处罚结果
	 */
	public String getCfJg() {
		return cfJg;
	}
	/**
	 * 设置：
	 */
	public void setCfQx(String cfQx) {
		this.cfQx = cfQx;
	}
	/**
	 * 获取：
	 */
	public String getCfQx() {
		return cfQx;
	}
	/**
	 * 设置：数据更新时间
	 */
	public void setCfSjc(Date cfSjc) {
		this.cfSjc = cfSjc;
	}
	/**
	 * 获取：数据更新时间
	 */
	public Date getCfSjc() {
		return cfSjc;
	}
	/**
	 * 设置：处罚事由
	 */
	public void setCfSy(String cfSy) {
		this.cfSy = cfSy;
	}
	/**
	 * 获取：处罚事由
	 */
	public String getCfSy() {
		return cfSy;
	}
	/**
	 * 设置：决定书文号
	 */
	public void setCfWsh(String cfWsh) {
		this.cfWsh = cfWsh;
	}
	/**
	 * 获取：决定书文号
	 */
	public String getCfWsh() {
		return cfWsh;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrGsdj(String cfXdrGsdj) {
		this.cfXdrGsdj = cfXdrGsdj;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrGsdj() {
		return cfXdrGsdj;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrMc(String cfXdrMc) {
		this.cfXdrMc = cfXdrMc;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrMc() {
		return cfXdrMc;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrSfz(String cfXdrSfz) {
		this.cfXdrSfz = cfXdrSfz;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrSfz() {
		return cfXdrSfz;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrShxym(String cfXdrShxym) {
		this.cfXdrShxym = cfXdrShxym;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrShxym() {
		return cfXdrShxym;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrSwdj(String cfXdrSwdj) {
		this.cfXdrSwdj = cfXdrSwdj;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrSwdj() {
		return cfXdrSwdj;
	}
	/**
	 * 设置：
	 */
	public void setCfXdrZdm(String cfXdrZdm) {
		this.cfXdrZdm = cfXdrZdm;
	}
	/**
	 * 获取：
	 */
	public String getCfXdrZdm() {
		return cfXdrZdm;
	}
	/**
	 * 设置：
	 */
	public void setCfXzbm(String cfXzbm) {
		this.cfXzbm = cfXzbm;
	}
	/**
	 * 获取：
	 */
	public String getCfXzbm() {
		return cfXzbm;
	}
	/**
	 * 设置：处罚机关
	 */
	public void setCfXzjg(String cfXzjg) {
		this.cfXzjg = cfXzjg;
	}
	/**
	 * 获取：处罚机关
	 */
	public String getCfXzjg() {
		return cfXzjg;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setCfYj(String cfYj) {
		this.cfYj = cfYj;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getCfYj() {
		return cfYj;
	}
	/**
	 * 设置：
	 */
	public void setCfZt(String cfZt) {
		this.cfZt = cfZt;
	}
	/**
	 * 获取：
	 */
	public String getCfZt() {
		return cfZt;
	}
	/**
	 * 设置：
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	/**
	 * 获取：
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}
	/**
	 * 设置：
	 */
	public void setPv(String pv) {
		this.pv = pv;
	}
	/**
	 * 获取：
	 */
	public String getPv() {
		return pv;
	}
	/**
	 * 设置：
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：
	 */
	public String getSubjectId() {
		return subjectId;
	}
	/**
	 * 设置：
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	/**
	 * 获取：
	 */
	public String getUploadDate() {
		return uploadDate;
	}

}
