package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open421MortgageInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8438922659853873226L;
	private Open421MortgageInfoBaseInfoDTO baseInfo;
	private List<Open421MortgageChangeInfoListDTO> changeInfoList;
	private List<Open421MortgagePawnInfoListDTO> pawnInfoList;
	private List<Open421MortgagePeopleInfoDTO> peopleInfo;

	public Open421MortgageInfoBaseInfoDTO getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(Open421MortgageInfoBaseInfoDTO baseInfo) {
		this.baseInfo = baseInfo;
	}

	public List<Open421MortgageChangeInfoListDTO> getChangeInfoList() {
		return changeInfoList;
	}

	public void setChangeInfoList(List<Open421MortgageChangeInfoListDTO> changeInfoList) {
		this.changeInfoList = changeInfoList;
	}

	public List<Open421MortgagePawnInfoListDTO> getPawnInfoList() {
		return pawnInfoList;
	}

	public void setPawnInfoList(List<Open421MortgagePawnInfoListDTO> pawnInfoList) {
		this.pawnInfoList = pawnInfoList;
	}

	public List<Open421MortgagePeopleInfoDTO> getPeopleInfo() {
		return peopleInfo;
	}

	public void setPeopleInfo(List<Open421MortgagePeopleInfoDTO> peopleInfo) {
		this.peopleInfo = peopleInfo;
	}

}
