package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open401CreditChinaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5126172596118257377L;
	private String punishmentName; // 公司名 varchar(255)
	private String areaName; // 地区 varchar(50)
	private String url; // url varchar(150)

	public String getPunishmentName() {
		return punishmentName;
	}

	public void setPunishmentName(String punishmentName) {
		this.punishmentName = punishmentName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
