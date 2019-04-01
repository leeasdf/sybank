package xin.tianchuang.modules.api.facade.commonApi.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.common.enums.EntEntityTypeEnum;
import xin.tianchuang.common.enums.EntEquityPledgeeTypeEnum;
import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;
import xin.tianchuang.common.enums.KtannouncementsBltntypeEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.TycChangeItemUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.CommonApiCompanyReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.BidDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiBizKnowleageSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiJudicialSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiMoreSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiRiskSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CopyRegWorkDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.EmployDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.EquityInfoPledgeeListDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.IcpDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.ListedInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBaseinfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBranchDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCopyRegDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCourtWenShuDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizDishonestDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderCapitalDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizInverstDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementDefendantDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementPlaintiffDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizLawSuitDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesRelationshipsPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCRelationshipsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizPatentsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizStaffDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizTmDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.MortgageChangeInfoListDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.MortgageInfoBaseInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.MortgageInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.MortgagePawnInfoListDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.MortgagePeopleInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.NewsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.OneKeyNodeDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.PunishCreditChinaDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.facade.commonApi.CommonApiFacade;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBidsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBranchInfoEntity;
import xin.tianchuang.modules.spider.entity.EntChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntCopyRegEntity;
import xin.tianchuang.modules.spider.entity.EntCopyRegWorksEntity;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEquityInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEquityPledgeeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntHolderCapitalEntity;
import xin.tianchuang.modules.spider.entity.EntHolderInfoEntity;
import xin.tianchuang.modules.spider.entity.EntIcpInfoEntity;
import xin.tianchuang.modules.spider.entity.EntInverstInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;
import xin.tianchuang.modules.spider.entity.EntLawsuitInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgageBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgageChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePeopleInfoEntity;
import xin.tianchuang.modules.spider.entity.EntNewsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntOwnTaxEntity;
import xin.tianchuang.modules.spider.entity.EntPatentsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntPunishCreditChinaEntity;
import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;
import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;
import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;
import xin.tianchuang.modules.spider.service.EntAbnormalInfoService;
import xin.tianchuang.modules.spider.service.EntBaseInfoService;
import xin.tianchuang.modules.spider.service.EntBidsInfoService;
import xin.tianchuang.modules.spider.service.EntBranchInfoService;
import xin.tianchuang.modules.spider.service.EntChangeInfoService;
import xin.tianchuang.modules.spider.service.EntCopyRegService;
import xin.tianchuang.modules.spider.service.EntCopyRegWorksService;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceInfoService;
import xin.tianchuang.modules.spider.service.EntDishonestInfoService;
import xin.tianchuang.modules.spider.service.EntEmployInfoService;
import xin.tianchuang.modules.spider.service.EntEquityInfoService;
import xin.tianchuang.modules.spider.service.EntEquityPledgeeInfoService;
import xin.tianchuang.modules.spider.service.EntHolderCapitalService;
import xin.tianchuang.modules.spider.service.EntHolderInfoService;
import xin.tianchuang.modules.spider.service.EntIcpInfoService;
import xin.tianchuang.modules.spider.service.EntInverstInfoService;
import xin.tianchuang.modules.spider.service.EntKtannounceInfoService;
import xin.tianchuang.modules.spider.service.EntKtannouncePeopleInfoService;
import xin.tianchuang.modules.spider.service.EntLawsuitInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntMortgageBaseInfoService;
import xin.tianchuang.modules.spider.service.EntMortgageChangeInfoService;
import xin.tianchuang.modules.spider.service.EntMortgagePawnInfoService;
import xin.tianchuang.modules.spider.service.EntMortgagePeopleInfoService;
import xin.tianchuang.modules.spider.service.EntNewsInfoService;
import xin.tianchuang.modules.spider.service.EntOwnTaxService;
import xin.tianchuang.modules.spider.service.EntPatentsInfoService;
import xin.tianchuang.modules.spider.service.EntPunishCreditChinaService;
import xin.tianchuang.modules.spider.service.EntRefNodesService;
import xin.tianchuang.modules.spider.service.EntRefRelationshipsService;
import xin.tianchuang.modules.spider.service.EntStaffInfoService;
import xin.tianchuang.modules.spider.service.EntTmInfoService;
import xin.tianchuang.modules.spider.service.EntZhixingInfoService;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@Service
public class CommonApiFacadeImpl implements CommonApiFacade {

	private static Logger logger = LoggerFactory.getLogger(CommonApiFacade.class);
	@Autowired
	protected EjbDozerGenerator ejbGenerator;

	@Resource
	private EntBaseInfoService entBaseInfoService;
	@Resource
	private EntBranchInfoService entBranchInfoService;
	@Resource
	private EntHolderInfoService entHolderInfoService;
	@Resource
	private EntHolderCapitalService entHolderCapitalService;
	@Resource
	private EntInverstInfoService entInverstInfoService;
	@Resource
	private EntStaffInfoService entStaffInfoService;
	@Autowired
	private EntChangeInfoService entChangeInfoService;

	@Resource
	private EntKtannounceInfoService entKtannounceInfoService;
	@Resource
	private EntKtannouncePeopleInfoService entKtannouncePeopleInfoService;
	@Resource
	private EntCourtAnnounceInfoService entCourtAnnounceInfoService;
	@Resource
	private EntDishonestInfoService entDishonestInfoService;
	@Resource
	private EntLawsuitInfoService entLawsuitInfoService;
	@Resource
	private EntZhixingInfoService entZhixingInfoService;
	@Resource
	private EntAbnormalInfoService entAbnormalInfoService;
	@Resource
	private EntPunishCreditChinaService entPunishCreditChinaService;
	@Resource
	private EntOwnTaxService entOwnTaxService;
	@Resource
	private EntCopyRegWorksService entCopyRegWorksService;
	@Resource
	private EntIcpInfoService entIcpInfoService;
	@Resource
	private EntBidsInfoService entBidsInfoService;
	@Resource
	private EntEmployInfoService entEmployInfoService;
	@Resource
	private EntNewsInfoService entNewsInfoService;
	@Resource
	private EntRefNodesService entRefNodesService;
	@Resource
	private EntRefRelationshipsService entRefRelationshipsService;
	@Resource
	private EntListInfoService entListInfoService;

	@Resource
	private EntTmInfoService entTmInfoService;
	@Resource
	private EntPatentsInfoService entPatentsInfoService;
	@Resource
	private EntCopyRegService entCopyRegService;

	@Autowired
	private EntEquityInfoService entEquityInfoService;
	@Autowired
	private EntEquityPledgeeInfoService entEquityPledgeeInfoService;

	@Autowired
	private EntMortgageBaseInfoService entMortgageBaseInfoService;
	@Autowired
	private EntMortgagePeopleInfoService entMortgagePeopleInfoService;
	@Autowired
	private EntMortgagePawnInfoService entMortgagePawnInfoService;
	@Autowired
	private EntMortgageChangeInfoService entMortgageChangeInfoService;

	@Override
	public CommonApiBaseinfoSetDTO getBaseinfoSet(CommonApiCompanyReqDTO param) {

		BizRequestParamDTO reqParam = new BizRequestParamDTO();
		BeanUtils.copyProperties(param, reqParam);
		// 基本信息
		String entName = param.getName();
		EntListInfoEntity entListInfoEntity = entListInfoService.selectOneByName(entName);
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]企业[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}
		CommonApiBaseinfoSetDTO dto = new CommonApiBaseinfoSetDTO();
		LoanBizBaseinfoDTO baseInfoDTO = null;
		if (null != entListInfoEntity) {
			baseInfoDTO = new LoanBizBaseinfoDTO();
			BeanUtils.copyProperties(entListInfoEntity, baseInfoDTO);
			// if (StringUtils.isNotBlank(entBaseInfoEntity.getRegCapital())) {
			// baseInfoDTO.setRegCapital(TycRuleUtils.getAmount(entBaseInfoEntity.getRegCapital()));
			// }
		}
		if (null != baseInfoDTO) {
			dto.setBaseInfo(baseInfoDTO);
		}
		// 分支机构
		List<EntBranchInfoEntity> branchInfoEntities = entBranchInfoService.selectListByName(entName);
		List<LoanBizBranchDTO> branches = ejbGenerator.convert(branchInfoEntities, LoanBizBranchDTO.class);
		dto.setBranches(branches);
		// 股东信息
		List<EntHolderInfoEntity> entHolderInfoEntities = entHolderInfoService.selectListByName(entName);
		List<LoanBizHolderDTO> holders = ejbGenerator.convert(entHolderInfoEntities, LoanBizHolderDTO.class);

		List<EntHolderCapitalEntity> entHolderCapitalEntities = null;
		List<LoanBizHolderCapitalDTO> capitalLs = null;
		for (LoanBizHolderDTO loanBizHolderDTO : holders) {
			entHolderCapitalEntities = entHolderCapitalService.selectListByPerson(entName, loanBizHolderDTO.getName());
			capitalLs = ejbGenerator.convert(entHolderCapitalEntities, LoanBizHolderCapitalDTO.class);
			loanBizHolderDTO.setCapital(capitalLs);
		}
		dto.setHolders(holders);
		// 对外投资
		List<EntInverstInfoEntity> entInverstInfoEntities = entInverstInfoService.selectListByName(entName);
		List<LoanBizInverstDTO> inversts = ejbGenerator.convert(entInverstInfoEntities, LoanBizInverstDTO.class);
		dto.setInversts(inversts);
		// 变更信息
		List<EntChangeInfoEntity> changeInfoEntityList = entChangeInfoService.selectListByName(entName);
		List<LoanBizChangeinfoDTO> changeinfoDTOList = ejbGenerator.convert(changeInfoEntityList, LoanBizChangeinfoDTO.class);
		dataFormat(changeinfoDTOList);
		dto.setChangeinfos(changeinfoDTOList);
		// 高管信息
		List<EntStaffInfoEntity> entStaffInfoEntities = entStaffInfoService.selectListByName(entName);
		List<LoanBizStaffDTO> staffLs = Lists.newArrayList();
		List<String> typeJoinLs = null;
		LoanBizStaffDTO loanBizStaffDTO = null;
		for (EntStaffInfoEntity entity : entStaffInfoEntities) {
			loanBizStaffDTO = new LoanBizStaffDTO();
			BeanUtils.copyProperties(entity, loanBizStaffDTO);

			if (StringUtils.isNotBlank(entity.getTypeJoin())) {
				typeJoinLs = Splitter.on(",").trimResults().splitToList(entity.getTypeJoin());
				loanBizStaffDTO.setTypeJoin(typeJoinLs);
			}
			staffLs.add(loanBizStaffDTO);
		}

		dto.setStaffs(staffLs);

		return dto;
	}

	private void dataFormat(List<LoanBizChangeinfoDTO> changeinfoDTOList) {
		for (LoanBizChangeinfoDTO loanBizChangeinfoDTO : changeinfoDTOList) {
			loanBizChangeinfoDTO.setContentAfter(loanBizChangeinfoDTO.getContentAfter().replaceAll("<em>", "").replaceAll("</em>", ""));
			loanBizChangeinfoDTO.setContentBefore(loanBizChangeinfoDTO.getContentBefore().replaceAll("<em>", "").replaceAll("</em>", ""));
			loanBizChangeinfoDTO.setChangeType(TycChangeItemUtils.getChangeItemType(loanBizChangeinfoDTO.getChangeItem()).desc());
		}

	}

	@Override
	public CommonApiJudicialSetDTO getJudicialSet(CommonApiCompanyReqDTO param) {
		// 开庭公告
		List<EntKtannounceInfoEntity> entKtannounceInfoEntities = entKtannounceInfoService.selectListByEntName(param.getName());
		List<LoanBizKtannouncementDTO> loanBizKtannouncementDTOs = Lists.newArrayList();
		LoanBizKtannouncementDTO loanBizKtannouncementDTO = null;
		List<EntKtannouncePeopleInfoEntity> entKtannouncePlaintiffInfoEntities = null;
		List<LoanBizKtannouncementPlaintiffDTO> plaintiffLs = null;
		List<EntKtannouncePeopleInfoEntity> entKtannounceDefendantInfoEntities = null;
		List<LoanBizKtannouncementDefendantDTO> defendantLs = null;
		for (EntKtannounceInfoEntity entity : entKtannounceInfoEntities) {
			loanBizKtannouncementDTO = new LoanBizKtannouncementDTO();
			BeanUtils.copyProperties(entity, loanBizKtannouncementDTO);

			entKtannouncePlaintiffInfoEntities = entKtannouncePeopleInfoService.selectListByTableIdPeopleType(entity.getTableId(), EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
			plaintiffLs = ejbGenerator.convert(entKtannouncePlaintiffInfoEntities, LoanBizKtannouncementPlaintiffDTO.class);
			loanBizKtannouncementDTO.setPlaintiff(plaintiffLs);

			entKtannounceDefendantInfoEntities = entKtannouncePeopleInfoService.selectListByTableIdPeopleType(entity.getTableId(), EntKtannouncePeopleTypeEnum.DEFENDANT.key());
			defendantLs = ejbGenerator.convert(entKtannounceDefendantInfoEntities, LoanBizKtannouncementDefendantDTO.class);
			loanBizKtannouncementDTO.setDefendant(defendantLs);

			loanBizKtannouncementDTOs.add(loanBizKtannouncementDTO);
		}

		CommonApiJudicialSetDTO dto = new CommonApiJudicialSetDTO();
		dto.setKtannouncements(loanBizKtannouncementDTOs);
		// 法院公告
		List<EntCourtAnnounceInfoEntity> entCourtAnnounceInfoEntities = entCourtAnnounceInfoService.selectListByEntName(param.getName());
		List<LoanBizCourtAnnouncementDTO> courtAnnouncements = ejbGenerator.convert(entCourtAnnounceInfoEntities, LoanBizCourtAnnouncementDTO.class);
		dto.setCourtAnnouncements(courtAnnouncements);
		// 裁判文书bltype=62
		List<EntCourtAnnounceInfoEntity> courtWenshuEntites = entCourtAnnounceInfoService.selectListByEntNameBltntype(param.getName(), KtannouncementsBltntypeEnum.T_62.desc());
		List<LoanBizCourtWenShuDTO> courtWenShus = ejbGenerator.convert(courtWenshuEntites, LoanBizCourtWenShuDTO.class);
		dto.setCourtWenShus(courtWenShus);
		// 执行公告
		List<EntZhixingInfoEntity> entZhixingInfoEntities = entZhixingInfoService.selectListByEntName(param.getName());
		List<LoanBizZhixinginfoDTO> loanBizZhixinginfoDTOs = ejbGenerator.convert(entZhixingInfoEntities, LoanBizZhixinginfoDTO.class);
		dto.setZhixinginfos(loanBizZhixinginfoDTOs);
		// 失信公告
		List<EntDishonestInfoEntity> entDishonestInfoEntities = entDishonestInfoService.selectListByEntName(param.getName());
		List<LoanBizDishonestDTO> dishonests = ejbGenerator.convert(entDishonestInfoEntities, LoanBizDishonestDTO.class);
		dto.setDishonests(dishonests);
		// 法律诉讼
		List<EntLawsuitInfoEntity> entLawsuitInfoEntityList = entLawsuitInfoService.selectListByEntName(param.getName());
		List<LoanBizLawSuitDTO> loanBizLawSuitDTOList = ejbGenerator.convert(entLawsuitInfoEntityList, LoanBizLawSuitDTO.class);
		dto.setLawSuits(loanBizLawSuitDTOList);
		return dto;
	}

	@Override
	public CommonApiRiskSetDTO getRiskSet(CommonApiCompanyReqDTO param) {
		// 经营风险
		List<EntAbnormalInfoEntity> entAbnormalInfoEntityList = entAbnormalInfoService.selectListByEntName(param.getName());
		List<AbnormalDTO> abnormalDTOList = ejbGenerator.convert(entAbnormalInfoEntityList, AbnormalDTO.class);

		CommonApiRiskSetDTO dto = new CommonApiRiskSetDTO();
		dto.setAbnormals(abnormalDTOList);
		// 行政处罚-信用中国（新版）
		List<EntPunishCreditChinaEntity> entPunishCreditChinaEntityList = entPunishCreditChinaService.selectListByEntName(param.getName());
		List<PunishCreditChinaDTO> punishCreditChinaDTOList = ejbGenerator.convert(entPunishCreditChinaEntityList, PunishCreditChinaDTO.class);
		dto.setPunishCreditChinas(punishCreditChinaDTOList);
		// 欠税信息
		List<EntOwnTaxEntity> entOwnTaxEntityList = entOwnTaxService.selectListByEntName(param.getName());
		List<OwnTaxDTO> ownTaxDTOList = ejbGenerator.convert(entOwnTaxEntityList, OwnTaxDTO.class);
		dto.setOwnTaxs(ownTaxDTOList);
		// 股权出质
		List<EntEquityInfoEntity> entEquityInfoEntities = entEquityInfoService.selectListByEntName(param.getName());
		List<EquityInfoDTO> equityInfoDTOS = Lists.newArrayList();
		EquityInfoDTO equityInfoDTO = null;
		List<EntEquityPledgeeInfoEntity> equityCompanyInfos = null;
		List<EquityInfoPledgeeListDTO> companyListDTOS = null;
		List<EntEquityPledgeeInfoEntity> equityPledgeeInfos = null;
		List<EquityInfoPledgeeListDTO> pledgeeListDTOS = null;
		List<EntEquityPledgeeInfoEntity> equityPledgorInfos = null;
		List<EquityInfoPledgeeListDTO> pledgorListDTOS = null;
		for (EntEquityInfoEntity equityInfoEntity : entEquityInfoEntities) {
			equityInfoDTO = new EquityInfoDTO();
			BeanUtils.copyProperties(equityInfoEntity, equityInfoDTO);

			equityCompanyInfos = entEquityPledgeeInfoService.selectListByEntNameAndTypeAndRegNumber(param.getName(), EntEquityPledgeeTypeEnum.COMPANY, equityInfoEntity.getRegNumber());
			companyListDTOS = ejbGenerator.convert(equityCompanyInfos, EquityInfoPledgeeListDTO.class);
			equityInfoDTO.setCompanyList(companyListDTOS);

			equityPledgeeInfos = entEquityPledgeeInfoService.selectListByEntNameAndTypeAndRegNumber(param.getName(), EntEquityPledgeeTypeEnum.PLEDGEE, equityInfoEntity.getRegNumber());
			pledgeeListDTOS = ejbGenerator.convert(equityPledgeeInfos, EquityInfoPledgeeListDTO.class);
			equityInfoDTO.setPledgeeList(pledgeeListDTOS);

			equityPledgorInfos = entEquityPledgeeInfoService.selectListByEntNameAndTypeAndRegNumber(param.getName(), EntEquityPledgeeTypeEnum.PLEDGOR, equityInfoEntity.getRegNumber());
			pledgorListDTOS = ejbGenerator.convert(equityPledgorInfos, EquityInfoPledgeeListDTO.class);
			equityInfoDTO.setPledgorList(pledgorListDTOS);

			equityInfoDTOS.add(equityInfoDTO);
		}
		dto.setEquityInfos(equityInfoDTOS);
		// 动产抵押
		List<EntMortgageBaseInfoEntity> entMortgageBaseInfoEntities = entMortgageBaseInfoService.selectListByEntName(param.getName());
		List<MortgageInfoDTO> mortgageInfoDTOS = Lists.newArrayList();
		MortgageInfoDTO mortgageInfoDTO = null;
		MortgageInfoBaseInfoDTO mortgageInfoBaseInfoDTO = null;
		List<EntMortgagePawnInfoEntity> pawnInfoEntities = null;
		List<MortgagePawnInfoListDTO> pawnInfoListDTOS = null;
		List<EntMortgagePeopleInfoEntity> peopleInfoEntities = null;
		List<MortgagePeopleInfoDTO> peopleInfoDTOS = null;
		List<EntMortgageChangeInfoEntity> changeInfoEntities = null;
		List<MortgageChangeInfoListDTO> changeInfoListDTOS = null;
		for (EntMortgageBaseInfoEntity mortgageBaseInfoEntity : entMortgageBaseInfoEntities) {
			mortgageInfoDTO = new MortgageInfoDTO();
			mortgageInfoBaseInfoDTO = new MortgageInfoBaseInfoDTO();
			BeanUtils.copyProperties(mortgageBaseInfoEntity, mortgageInfoBaseInfoDTO);
			mortgageInfoDTO.setBaseInfo(mortgageInfoBaseInfoDTO);
			pawnInfoEntities = entMortgagePawnInfoService.selectListByEntNameAndRegNum(param.getName(), mortgageBaseInfoEntity.getRegNum());
			pawnInfoListDTOS = ejbGenerator.convert(pawnInfoEntities, MortgagePawnInfoListDTO.class);
			mortgageInfoDTO.setPawnInfoList(pawnInfoListDTOS);

			peopleInfoEntities = entMortgagePeopleInfoService.selectListByEntNameAndRegNum(param.getName(), mortgageBaseInfoEntity.getRegNum());
			peopleInfoDTOS = ejbGenerator.convert(peopleInfoEntities, MortgagePeopleInfoDTO.class);
			mortgageInfoDTO.setPeopleInfo(peopleInfoDTOS);

			changeInfoEntities = entMortgageChangeInfoService.selectListByEntNameAndRegNum(param.getName(), mortgageBaseInfoEntity.getRegNum());
			changeInfoListDTOS = ejbGenerator.convert(changeInfoEntities, MortgageChangeInfoListDTO.class);
			mortgageInfoDTO.setChangeInfoList(changeInfoListDTOS);

			mortgageInfoDTOS.add(mortgageInfoDTO);
		}
		dto.setMortgageInfos(mortgageInfoDTOS);
		return dto;
	}

	@Override
	public CommonApiBizKnowleageSetDTO getKnowleageList(CommonApiCompanyReqDTO param) {

		// 著作权
		List<EntCopyRegEntity> entCopyRegEntities = entCopyRegService.selectByEntName(param.getName());
		List<LoanBizCopyRegDTO> loanBizCopyRegDTOs = ejbGenerator.convert(entCopyRegEntities, LoanBizCopyRegDTO.class);

		CommonApiBizKnowleageSetDTO dto = new CommonApiBizKnowleageSetDTO();
		dto.setCopyRegs(loanBizCopyRegDTOs);
		// 商标
		List<EntTmInfoEntity> entTmInfoEntities = entTmInfoService.selectByEntName(param.getName());
		List<LoanBizTmDTO> loanBizTmDTOs = ejbGenerator.convert(entTmInfoEntities, LoanBizTmDTO.class);
		dto.setTms(loanBizTmDTOs);
		// 专利
		List<EntPatentsInfoEntity> entPatentsInfoEntities = entPatentsInfoService.selectByEntName(param.getName());
		List<LoanBizPatentsDTO> loanBizPatentsDTOs = ejbGenerator.convert(entPatentsInfoEntities, LoanBizPatentsDTO.class);
		dto.setPatents(loanBizPatentsDTOs);
		// 作品著作权
		List<EntCopyRegWorksEntity> entCopyRegWorksEntityList = entCopyRegWorksService.selectByEntName(param.getName());
		List<CopyRegWorkDTO> copyRegWorkDTOList = ejbGenerator.convert(entCopyRegWorksEntityList, CopyRegWorkDTO.class);
		dto.setCopyRegWorks(copyRegWorkDTOList);
		// 网站备案
		List<EntIcpInfoEntity> entIcpInfoEntityList = entIcpInfoService.selectByEntName(param.getName());
		List<IcpDTO> icpDTOList = ejbGenerator.convert(entIcpInfoEntityList, IcpDTO.class);
		dto.setIcps(icpDTOList);

		return dto;
	}

	@Override
	public CommonApiMoreSetDTO getMore(CommonApiCompanyReqDTO param) {
		// 招投标
		List<EntBidsInfoEntity> entBidsInfoEntityList = entBidsInfoService.selectByEntName(param.getName());
		List<BidDTO> bidDTOList = ejbGenerator.convert(entBidsInfoEntityList, BidDTO.class);

		CommonApiMoreSetDTO dto = new CommonApiMoreSetDTO();
		dto.setBids(bidDTOList);
		// 主要人员
		List<EntEmployInfoEntity> entEmployInfoEntityList = entEmployInfoService.selectByEntName(param.getName());
		List<EmployDTO> employDTOList = ejbGenerator.convert(entEmployInfoEntityList, EmployDTO.class);
		dto.setEmploys(employDTOList);
		// 舆情
		List<EntNewsInfoEntity> entNewsInfoEntityList = entNewsInfoService.selectByEntName(param.getName());
		List<NewsDTO> newsDTOList = ejbGenerator.convert(entNewsInfoEntityList, NewsDTO.class);
		dto.setNews(newsDTOList);
		// 关系图谱
		OneKeyNodeDTO companyReleations = new OneKeyNodeDTO();
		List<EntRefNodesEntity> entRefNodesEntities = entRefNodesService.selectListByEntName(param.getName());
		List<LoanBizOneKeyCNodesDTO> nodes = new ArrayList<>();
		LoanBizOneKeyCNodesDTO node = null;
		LoanBizOneKeyCNodesPropertiesDTO nodeProperties = null;
		for (EntRefNodesEntity entity : entRefNodesEntities) {
			node = new LoanBizOneKeyCNodesDTO();
			BeanUtils.copyProperties(entity, node);
			node.setId(entity.getNodeId());

			if (StringUtils.isNotBlank(entity.getLabels())) {
				List<String> labels = Splitter.on(",").trimResults().splitToList(entity.getLabels());
				node.setLabels(labels);
			}
			nodeProperties = new LoanBizOneKeyCNodesPropertiesDTO();
			BeanUtils.copyProperties(entity, nodeProperties);
			node.setProperties(nodeProperties);

			nodes.add(node);
		}
		if (nodes.size() >= 1) {
			companyReleations.setRefNodes(nodes);
		}

		List<EntRefRelationshipsEntity> entRefRelationshipsEntities = entRefRelationshipsService.selectListByEntName(param.getName());
		List<LoanBizOneKeyCRelationshipsDTO> relationships = new ArrayList<>();
		LoanBizOneKeyCRelationshipsDTO relationship = null;
		LoanBizOneKeyCNodesRelationshipsPropertiesDTO relationshipProperties = null;
		for (EntRefRelationshipsEntity entity : entRefRelationshipsEntities) {
			relationship = new LoanBizOneKeyCRelationshipsDTO();
			BeanUtils.copyProperties(entity, relationship);
			relationship.setId(entity.getRefId());

			relationshipProperties = new LoanBizOneKeyCNodesRelationshipsPropertiesDTO();
			BeanUtils.copyProperties(entity, relationshipProperties);
			relationship.setProperties(relationshipProperties);

			if (StringUtils.isNotBlank(entity.getLabels())) {
				List<String> labels = Splitter.on(",").trimResults().splitToList(entity.getLabels());
				relationshipProperties.setLabels(labels);
			}
			relationships.add(relationship);
		}

		if (relationships.size() >= 1) {
			companyReleations.setRefRelationships(relationships);
		}

		if (null != companyReleations) {
			dto.setNodeDTO(companyReleations);
		}
		
		// BeanUtils.copyProperties(param, reqParam);
		// 上市信息
		EntListInfoEntity entListInfoEntity = entListInfoService.selectByNameCreditCode(param.getName(), null);
		if (null != entListInfoEntity) {
			Integer entityType = entListInfoEntity.getEntityType();
			if (EntEntityTypeEnum.COMPANY.key() == entityType) {
				EntBaseInfoEntity entBaseInfoEntity = entBaseInfoService.selectOneByEntName(param.getName());
				if (null != entBaseInfoEntity && StringUtils.isNotBlank(entBaseInfoEntity.getName())) {
					ListedInfoDTO listedInfoDTO = new ListedInfoDTO();
					BeanUtils.copyProperties(entBaseInfoEntity, listedInfoDTO);
					dto.setListedInfo(listedInfoDTO);
				}
			}
		}

		return dto;
	}

}
