package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open367StaffDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6526235792526764279L;
	private Integer toco;// 拥有公司个数
	@SerializedName("id")
	private Long tycId; // 人或公司id
	private List<String> typeJoin; // 职位
	private String logo; // logo
	private Integer type;// 1-公司 2-人
	private String name; // 主要人员名

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

	public List<String> getTypeJoin() {
		return typeJoin;
	}

	public void setTypeJoin(List<String> typeJoin) {
		this.typeJoin = typeJoin;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
