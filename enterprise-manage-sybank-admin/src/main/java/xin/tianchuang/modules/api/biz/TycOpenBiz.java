package xin.tianchuang.modules.api.biz;

import java.util.List;

import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open369InverstDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open372BranchDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open384LawSuitDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open391AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgageInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open422OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open429BidsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open439TmDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open440PatentsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open441CopyRegDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open442IcpDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open733CopyRegWorksDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open767CreditChinaV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.OpenBaseinfoSetDTO;

public interface TycOpenBiz {

	OpenBaseinfoSetDTO getBaseinfoV3(BizRequestParamDTO param);

	OpenBaseinfoSetDTO getDirectBaseinfo(BizRequestParamDTO param);

	List<Open368HolderDTO> getHolder(BizRequestParamDTO BizRequestParamDTO);

	List<Open369InverstDTO> getInvest(BizRequestParamDTO BizRequestParamDTO);

	List<Open370ChangeinfoDTO> getChangeinfo(BizRequestParamDTO BizRequestParamDTO);

	List<Open372BranchDTO> getBranch(BizRequestParamDTO BizRequestParamDTO);

	List<Open384LawSuitDTO> getLawSuit(BizRequestParamDTO param);

	List<Open385CourtAnnouncementDTO> getCourtAnnouncement(BizRequestParamDTO param);

	List<Open777DishonestV2DTO> getDishonest(BizRequestParamDTO param);

	List<Open389ZhixinginfoDTO> getZhixinginfo(BizRequestParamDTO param);

	List<Open386KtannouncementDTO> getKtannouncement(BizRequestParamDTO param);

	List<Open391AbnormalDTO> getAbnormal(BizRequestParamDTO param);

	List<Open767CreditChinaV2DTO> getCreditChinaV2(BizRequestParamDTO param);

	List<Open404EquityInfoDTO> getEquityInfo(BizRequestParamDTO param);

	List<Open421MortgageInfoDTO> getMortgageInfo(BizRequestParamDTO param);

	List<Open422OwnTaxDTO> getOweTax(BizRequestParamDTO param);

	List<Open429BidsDTO> getBids(BizRequestParamDTO param);

	List<Open782EmploymentsV2DTO> getEmploymentsV2(BizRequestParamDTO param);

	List<Open439TmDTO> getTm(BizRequestParamDTO param);

	List<Open440PatentsDTO> getPatents(BizRequestParamDTO param);

	List<Open733CopyRegWorksDTO> getCopyRegWorks(BizRequestParamDTO param);

	List<Open441CopyRegDTO> getCopyReg(BizRequestParamDTO param);

	List<Open442IcpDTO> getIcp(BizRequestParamDTO param);

	List<Open446NewsDTO> getNews(BizRequestParamDTO param);

	boolean getCompanyInfo(BizRequestParamDTO param);

	Open783OneKeyCDTO getOneKeyC(BizRequestParamDTO param);

	List<Open371AnnualreportDTO> getAnnualReport(BizRequestParamDTO param);

	// Open459XgbaseinfoV2DTO getXgbaseinfoV2(BizRequestParamDTO param) ;

}
