package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open404EquityInfoPledgeeListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3729275841033670847L;
	@SerializedName("id")
	private String pledgeeId;// 公司id
	@SerializedName("name")
	private String pledgeeName;// 公司名 varchar(255)

	public String getPledgeeId() {
		return pledgeeId;
	}

	public void setPledgeeId(String pledgeeId) {
		this.pledgeeId = pledgeeId;
	}

	public String getPledgeeName() {
		return pledgeeName;
	}

	public void setPledgeeName(String pledgeeName) {
		this.pledgeeName = pledgeeName;
	}

}
