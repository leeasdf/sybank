package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 信用中国-行政许可
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */

public class CreditchinaPermissionDTO implements Serializable {
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
	/**
	 * 
	 */
	private String xkBz;
	/**
	 * 地方编码
	 */
	private String xkDfbm;
	/**
	 * 法人代表人姓名
	 */
	private String xkFr;
	/**
	 * 许可决定日期
	 */
	@JSONField(format="yyyy/MM/dd")
	private Date xkJdrq;
	/**
	 * 许可截止日期
	 */
	@JSONField(format="yyyy/MM/dd")
	private Date xkJzq;
	/**
	 * 内容许可
	 */
	private String xkNr;
	/**
	 * 数据更新时间
	 */
	@JSONField(format="yyyy/MM/dd")
	private Date xkSjc;
	/**
	 * 审核类型
	 */
	private String xkSplb;
	/**
	 * 行政许可决定书文号
	 */
	private String xkWsh;
	/**
	 * 企业名称
	 */
	private String xkXdr;
	/**
	 * 
	 */
	private String xkXdrGsdj;
	/**
	 * 
	 */
	private String xkXdrSfz;
	/**
	 * 
	 */
	private String xkXdrShxym;
	/**
	 * 
	 */
	private String xkXdrSwdj;
	/**
	 * 
	 */
	private String xkXdrZdm;
	/**
	 * 
	 */
	private String xkXmmc;
	/**
	 * 
	 */
	private String xkXzbm;
	/**
	 * 许可机关
	 */
	private String xkXzjg;
	/**
	 * 
	 */
	private String xkYxq;
	/**
	 * 
	 */
	private String xkZt;


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
	/**
	 * 设置：
	 */
	public void setXkBz(String xkBz) {
		this.xkBz = xkBz;
	}
	/**
	 * 获取：
	 */
	public String getXkBz() {
		return xkBz;
	}
	/**
	 * 设置：地方编码
	 */
	public void setXkDfbm(String xkDfbm) {
		this.xkDfbm = xkDfbm;
	}
	/**
	 * 获取：地方编码
	 */
	public String getXkDfbm() {
		return xkDfbm;
	}
	/**
	 * 设置：法人代表人姓名
	 */
	public void setXkFr(String xkFr) {
		this.xkFr = xkFr;
	}
	/**
	 * 获取：法人代表人姓名
	 */
	public String getXkFr() {
		return xkFr;
	}
	/**
	 * 设置：许可决定日期
	 */
	public void setXkJdrq(Date xkJdrq) {
		this.xkJdrq = xkJdrq;
	}
	/**
	 * 获取：许可决定日期
	 */
	public Date getXkJdrq() {
		return xkJdrq;
	}
	/**
	 * 设置：许可截止日期
	 */
	public void setXkJzq(Date xkJzq) {
		this.xkJzq = xkJzq;
	}
	/**
	 * 获取：许可截止日期
	 */
	public Date getXkJzq() {
		return xkJzq;
	}
	/**
	 * 设置：内容许可
	 */
	public void setXkNr(String xkNr) {
		this.xkNr = xkNr;
	}
	/**
	 * 获取：内容许可
	 */
	public String getXkNr() {
		return xkNr;
	}
	/**
	 * 设置：数据更新时间
	 */
	public void setXkSjc(Date xkSjc) {
		this.xkSjc = xkSjc;
	}
	/**
	 * 获取：数据更新时间
	 */
	public Date getXkSjc() {
		return xkSjc;
	}
	/**
	 * 设置：审核类型
	 */
	public void setXkSplb(String xkSplb) {
		this.xkSplb = xkSplb;
	}
	/**
	 * 获取：审核类型
	 */
	public String getXkSplb() {
		return xkSplb;
	}
	/**
	 * 设置：行政许可决定书文号
	 */
	public void setXkWsh(String xkWsh) {
		this.xkWsh = xkWsh;
	}
	/**
	 * 获取：行政许可决定书文号
	 */
	public String getXkWsh() {
		return xkWsh;
	}
	/**
	 * 设置：企业名称
	 */
	public void setXkXdr(String xkXdr) {
		this.xkXdr = xkXdr;
	}
	/**
	 * 获取：企业名称
	 */
	public String getXkXdr() {
		return xkXdr;
	}
	/**
	 * 设置：
	 */
	public void setXkXdrGsdj(String xkXdrGsdj) {
		this.xkXdrGsdj = xkXdrGsdj;
	}
	/**
	 * 获取：
	 */
	public String getXkXdrGsdj() {
		return xkXdrGsdj;
	}
	/**
	 * 设置：
	 */
	public void setXkXdrSfz(String xkXdrSfz) {
		this.xkXdrSfz = xkXdrSfz;
	}
	/**
	 * 获取：
	 */
	public String getXkXdrSfz() {
		return xkXdrSfz;
	}
	/**
	 * 设置：
	 */
	public void setXkXdrShxym(String xkXdrShxym) {
		this.xkXdrShxym = xkXdrShxym;
	}
	/**
	 * 获取：
	 */
	public String getXkXdrShxym() {
		return xkXdrShxym;
	}
	/**
	 * 设置：
	 */
	public void setXkXdrSwdj(String xkXdrSwdj) {
		this.xkXdrSwdj = xkXdrSwdj;
	}
	/**
	 * 获取：
	 */
	public String getXkXdrSwdj() {
		return xkXdrSwdj;
	}
	/**
	 * 设置：
	 */
	public void setXkXdrZdm(String xkXdrZdm) {
		this.xkXdrZdm = xkXdrZdm;
	}
	/**
	 * 获取：
	 */
	public String getXkXdrZdm() {
		return xkXdrZdm;
	}
	/**
	 * 设置：
	 */
	public void setXkXmmc(String xkXmmc) {
		this.xkXmmc = xkXmmc;
	}
	/**
	 * 获取：
	 */
	public String getXkXmmc() {
		return xkXmmc;
	}
	/**
	 * 设置：
	 */
	public void setXkXzbm(String xkXzbm) {
		this.xkXzbm = xkXzbm;
	}
	/**
	 * 获取：
	 */
	public String getXkXzbm() {
		return xkXzbm;
	}
	/**
	 * 设置：许可机关
	 */
	public void setXkXzjg(String xkXzjg) {
		this.xkXzjg = xkXzjg;
	}
	/**
	 * 获取：许可机关
	 */
	public String getXkXzjg() {
		return xkXzjg;
	}
	/**
	 * 设置：
	 */
	public void setXkYxq(String xkYxq) {
		this.xkYxq = xkYxq;
	}
	/**
	 * 获取：
	 */
	public String getXkYxq() {
		return xkYxq;
	}
	/**
	 * 设置：
	 */
	public void setXkZt(String xkZt) {
		this.xkZt = xkZt;
	}
	/**
	 * 获取：
	 */
	public String getXkZt() {
		return xkZt;
	}

}
