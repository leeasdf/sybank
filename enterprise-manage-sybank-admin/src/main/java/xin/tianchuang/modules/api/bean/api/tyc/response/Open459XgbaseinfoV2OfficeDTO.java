package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open459XgbaseinfoV2OfficeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1743906696461395256L;
	private String area;// 区域
	private Integer total;//
	private String companyName;// 企业名称
	private Long cid;// 企业id
	private Integer score;// 弃用
	private String state;// 弃用

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}