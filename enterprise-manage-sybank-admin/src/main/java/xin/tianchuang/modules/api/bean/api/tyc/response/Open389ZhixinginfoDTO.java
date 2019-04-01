package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

public class Open389ZhixinginfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5616907383957995919L;
	private String caseCode;// 案号 varchar(50)
	private String execCourtName;// 执行法院 varchar(50)
	private String pname;// 被执行人名称 varchar(60)
	private String partyCardNum;// 身份证号／组织机构代码 varchar(30)
	private Long caseCreateTime;// 创建时间
	private String execMoney;// 执行标的 varchar(20)

	public String getCaseCode() {
		return caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getExecCourtName() {
		return execCourtName;
	}

	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPartyCardNum() {
		return partyCardNum;
	}

	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}

	public Long getCaseCreateTime() {
		return caseCreateTime;
	}

	public void setCaseCreateTime(Long caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

}
