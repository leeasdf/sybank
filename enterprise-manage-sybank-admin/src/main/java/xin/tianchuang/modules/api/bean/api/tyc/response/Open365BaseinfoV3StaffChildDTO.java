package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open365BaseinfoV3StaffChildDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1809627741965925659L;

	private Integer toco; // 拥有公司数量

	@SerializedName("id")
	private Long tycId; // 人或公司id

	private String name; // 主要人员名称

	private List<String> typeJoin; // 职位

	private Integer type; // 1-公司 2-人 varchar(20)

	private String logo;

	public Integer getToco() {
		return toco;
	}

	public void setToco(Integer toco) {
		this.toco = toco;
	}

	public Long getTycId() {
		return tycId;
	}

	public void setTycId(Long tycId) {
		this.tycId = tycId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTypeJoin() {
		return typeJoin;
	}

	public void setTypeJoin(List<String> typeJoin) {
		this.typeJoin = typeJoin;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
