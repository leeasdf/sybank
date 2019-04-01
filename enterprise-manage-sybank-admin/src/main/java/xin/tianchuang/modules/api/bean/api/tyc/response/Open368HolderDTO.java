package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open368HolderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000505106877954019L;

	@SerializedName("id")
	private Long tableId;// 对应表id
	private Integer toco;// 拥有公司个数
	private String logo;// logo varchar(150)
	private String name;// 股东名 varchar(50)
	private String alias;
	private List<Open368HolderCapitalActlDTO> capitalActl;// 实缴
	private Integer type;// 1-公司 2-人
	private List<Open368HolderCapitalDTO> capital;// 认缴

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Integer getToco() {
		return toco;
	}

	public void setToco(Integer toco) {
		this.toco = toco;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Open368HolderCapitalActlDTO> getCapitalActl() {
		return capitalActl;
	}

	public void setCapitalActl(List<Open368HolderCapitalActlDTO> capitalActl) {
		this.capitalActl = capitalActl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Open368HolderCapitalDTO> getCapital() {
		return capital;
	}

	public void setCapital(List<Open368HolderCapitalDTO> capital) {
		this.capital = capital;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	
}
