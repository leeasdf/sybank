package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open368HolderCapitalDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7225708317899018171L;
	private String amomon;// 出资金额 varchar(50)
	private String time;// 出资时间
	private String percent;// 占比
	private String paymet;// 实缴方式 varchar(10)

	public String getAmomon() {
		return amomon;
	}

	public void setAmomon(String amomon) {
		this.amomon = amomon;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getPaymet() {
		return paymet;
	}

	public void setPaymet(String paymet) {
		this.paymet = paymet;
	}

}
