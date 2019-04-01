package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业司法信息集合-返回对象模型")
public class LoanBizJudicialSetDTO implements Serializable {

	// 司法信息 开庭公告、裁判文书、法院公告、执行公告、失信公告

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204039690673004972L;

	/**
	 * 开庭公告
	 */
	private List<LoanBizKtannouncementDTO> ktannouncements;

	/**
	 * 法院公告
	 */
	private List<LoanBizCourtAnnouncementDTO> courtAnnouncements;
	/**
	 * 裁判文书
	 */
	private List<LoanBizCourtWenShuDTO> courtWenShus;

//	/**
//	 * 法律诉讼
//	 */
//	private List<LoanBizLawSuitDTO> lawSuits;

	/**
	 * 执行公告
	 */
	private List<LoanBizZhixinginfoDTO> zhixinginfos;

	/**
	 * 失信公告
	 */
	private List<LoanBizDishonestDTO> dishonests;

	public List<LoanBizKtannouncementDTO> getKtannouncements() {
		return ktannouncements;
	}

	public void setKtannouncements(List<LoanBizKtannouncementDTO> ktannouncements) {
		this.ktannouncements = ktannouncements;
	}


	public List<LoanBizCourtWenShuDTO> getCourtWenShus() {
		return courtWenShus;
	}

	public void setCourtWenShus(List<LoanBizCourtWenShuDTO> courtWenShus) {
		this.courtWenShus = courtWenShus;
	}

	public List<LoanBizZhixinginfoDTO> getZhixinginfos() {
		return zhixinginfos;
	}

	public void setZhixinginfos(List<LoanBizZhixinginfoDTO> zhixinginfos) {
		this.zhixinginfos = zhixinginfos;
	}

	public List<LoanBizDishonestDTO> getDishonests() {
		return dishonests;
	}

	public void setDishonests(List<LoanBizDishonestDTO> dishonests) {
		this.dishonests = dishonests;
	}

	public List<LoanBizCourtAnnouncementDTO> getCourtAnnouncements() {
		return courtAnnouncements;
	}

	public void setCourtAnnouncements(List<LoanBizCourtAnnouncementDTO> courtAnnouncements) {
		this.courtAnnouncements = courtAnnouncements;
	}

	
}
