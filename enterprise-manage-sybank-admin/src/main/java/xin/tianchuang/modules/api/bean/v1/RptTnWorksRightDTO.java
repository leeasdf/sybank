package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 作品著作权信息
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:20
 */

public class RptTnWorksRightDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5084567362022486448L;

	/**
	 * 作品名称
	 */
	private String title;
	/**
	 * 登记号
	 */
	private String regnum;
	/**
	 * 类别
	 */
	private String category;
	/**
	 * 创作完成日期
	 */
	private String finishDate;
	/**
	 * 登记日期
	 */
	private String regtime;
	/**
	 * 首次发布日期
	 */
	private String publishtime;

	/**
	 * 设置：作品名称
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取：作品名称
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置：登记号
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	/**
	 * 获取：登记号
	 */
	public String getRegnum() {
		return regnum;
	}

	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 设置：创作完成日期
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * 获取：创作完成日期
	 */
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * 设置：登记日期
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	/**
	 * 获取：登记日期
	 */
	public String getRegtime() {
		return regtime;
	}

	/**
	 * 设置：首次发布日期
	 */
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	/**
	 * 获取：首次发布日期
	 */
	public String getPublishtime() {
		return publishtime;
	}

}
