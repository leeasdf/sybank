package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open421MortgageChangeInfoListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1106023349221794551L;
	private Long changeDate;// 变更日期 毫秒数
	private String changeContent;// 变更内容 varchar(500)

	public Long getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Long changeDate) {
		this.changeDate = changeDate;
	}

	public String getChangeContent() {
		return changeContent;
	}

	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

}
