package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open421MortgagePawnInfoListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6713728365104952016L;
	private String detail;// 数量、质量、状况、所在地等情况 varchar(5000)
	private String ownership;// 所有权归属 varchar(100)
	private String pawnName;// 名称 varchar(100)
	private String remark;// 备注 varchar(200)

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getPawnName() {
		return pawnName;
	}

	public void setPawnName(String pawnName) {
		this.pawnName = pawnName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
