package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open446NewsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1723939234814270475L;
	private String title;// 新闻标题 varchar(150)
	private String url;// 链接 varchar(150)
	private String website;// 来源 varchar(50)
	private String time;// 时间 varchar(50)

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
