package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 企业-资质证书信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:22
 */
public class RptTnCertificateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2535282684720643630L;
	/**
	 * 类别
	 */
	private String type;
	/**
	 * 证书编号
	 */
	private String certNo;
	/**
	 * 发证日期
	 */
	private String publishDate;
	/**
	 * 截止日期
	 */
	private String deadlineDate;

	/**
	 * 设置：类别
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取：类别
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置：证书编号
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * 获取：证书编号
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * 设置：发证日期
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：发证日期
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * 设置：截止日期
	 */
	public void setDeadlineDate(String deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	/**
	 * 获取：截止日期
	 */
	public String getDeadlineDate() {
		return deadlineDate;
	}

}
