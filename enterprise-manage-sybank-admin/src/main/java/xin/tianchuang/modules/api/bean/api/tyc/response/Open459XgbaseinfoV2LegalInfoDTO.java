package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open459XgbaseinfoV2LegalInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -781739318065507144L;

	private String name;// 名称
	private String hid;// id
	private String headUrl;// 头像Url
	private List<Open459XgbaseinfoV2OfficeDTO> office;

	private Integer companyNum;// 拥有公司数量
	private String partners;// 弃用
	private Long cid;//
	private String typeJoin;// 职位

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public List<Open459XgbaseinfoV2OfficeDTO> getOffice() {
		return office;
	}

	public void setOffice(List<Open459XgbaseinfoV2OfficeDTO> office) {
		this.office = office;
	}

	public Integer getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(Integer companyNum) {
		this.companyNum = companyNum;
	}

	public String getPartners() {
		return partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getTypeJoin() {
		return typeJoin;
	}

	public void setTypeJoin(String typeJoin) {
		this.typeJoin = typeJoin;
	}

}