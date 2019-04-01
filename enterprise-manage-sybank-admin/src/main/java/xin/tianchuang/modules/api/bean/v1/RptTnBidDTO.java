package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 招投标信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnBidDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8258421078028265021L;
	/**
	 * /** 采购人
	 */
	private String purchaser;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private String publishDate;

	/**
	 * 设置：采购人
	 */
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	/**
	 * 获取：采购人
	 */
	public String getPurchaser() {
		return purchaser;
	}

	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：发布时间
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：发布时间
	 */
	public String getPublishDate() {
		return publishDate;
	}
}
