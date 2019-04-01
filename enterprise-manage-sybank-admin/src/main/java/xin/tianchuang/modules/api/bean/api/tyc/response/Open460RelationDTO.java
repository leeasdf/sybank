package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open460RelationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4628267249591413073L;

	private String id; // 法人id

	private Integer cType; // 类型 1公司 2 人

	private String name; // 法人

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getcType() {
		return cType;
	}

	public void setcType(Integer cType) {
		this.cType = cType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
