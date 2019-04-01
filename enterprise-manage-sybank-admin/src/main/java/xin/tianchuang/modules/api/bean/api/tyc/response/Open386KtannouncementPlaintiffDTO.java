package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open386KtannouncementPlaintiffDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9076458069986922709L;

	private Integer type; // Number 1-公司 2-人

	@SerializedName("id")
	private Long refId;// Number 人或公司id
	private String name;// String 人或公司名 varchar(255);

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
