package xin.tianchuang.modules.api.biz.impl;

import io.jsonwebtoken.lang.Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.common.constant.TycWeightPointsConstant;
import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.common.enums.ChangeItemTypeEnum;
import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;
import xin.tianchuang.common.enums.HolderTypeEnum;
import xin.tianchuang.common.enums.KtannouncementsBltntypeEnum;
import xin.tianchuang.common.enums.ListedFlagEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.TycChangeItemUtils;
import xin.tianchuang.common.utils.TycRuleUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizCompanyListReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizCompanyReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizReportReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizReportTimeReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizViewReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBaseinfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBranchDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCompanyInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCopyRegDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCourtWenShuDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizDishonestDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderCapitalDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderRelationsSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizIndexDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizInverstDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizJudicialSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKnowleageSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementDefendantDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKtannouncementPlaintiffDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizListedCompanyDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizNewsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCNodesRelationshipsPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizOneKeyCRelationshipsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizPatentsDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizStaffDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizTmDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanViewBizBaseInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanViewBizChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanViewBizNewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.OpenBaseinfoSetDTO;
import xin.tianchuang.modules.api.biz.LoanBizFacade;
import xin.tianchuang.modules.api.biz.TycOpenBiz;
import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBranchInfoEntity;
import xin.tianchuang.modules.spider.entity.EntChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntCopyRegEntity;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.entity.EntHolderCapitalEntity;
import xin.tianchuang.modules.spider.entity.EntHolderInfoEntity;
import xin.tianchuang.modules.spider.entity.EntInverstInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntNewsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntPatentsInfoEntity;
import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;
import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;
import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseInfoService;
import xin.tianchuang.modules.spider.service.EntBranchInfoService;
import xin.tianchuang.modules.spider.service.EntChangeInfoService;
import xin.tianchuang.modules.spider.service.EntCopyRegService;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceInfoService;
import xin.tianchuang.modules.spider.service.EntDishonestInfoService;
import xin.tianchuang.modules.spider.service.EntHolderCapitalService;
import xin.tianchuang.modules.spider.service.EntHolderInfoService;
import xin.tianchuang.modules.spider.service.EntInverstInfoService;
import xin.tianchuang.modules.spider.service.EntKtannounceInfoService;
import xin.tianchuang.modules.spider.service.EntKtannouncePeopleInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntNewsInfoService;
import xin.tianchuang.modules.spider.service.EntPatentsInfoService;
import xin.tianchuang.modules.spider.service.EntRefNodesService;
import xin.tianchuang.modules.spider.service.EntRefRelationshipsService;
import xin.tianchuang.modules.spider.service.EntReportLogService;
import xin.tianchuang.modules.spider.service.EntStaffInfoService;
import xin.tianchuang.modules.spider.service.EntTmInfoService;
import xin.tianchuang.modules.spider.service.EntZhixingInfoService;
import cn.hutool.core.util.StrUtil;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

@Component
public class LoanBizFacadeImpl implements LoanBizFacade {

	private static Logger logger = LoggerFactory.getLogger(LoanBizFacade.class);
	@Autowired
	protected EjbDozerGenerator ejbGenerator;

	@Resource
	private TycOpenBiz tycOpenBiz;

	@Resource
	private EntListInfoService entListInfoService;
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

	@Resource
	private EntKtannounceInfoService entKtannounceInfoService;
	@Resource
	private EntKtannouncePeopleInfoService entKtannouncePeopleInfoService;
	@Resource
	private EntCourtAnnounceInfoService entCourtAnnounceInfoService;
	@Resource
	private EntDishonestInfoService entDishonestInfoService;
	@Resource
	private EntChangeInfoService entChangeInfoService;
	@Resource
	private EntZhixingInfoService entZhixingInfoService;

	//
	@Resource
	private EntNewsInfoService entNewsInfoService;

	@Resource
	private EntTmInfoService entTmInfoService;
	@Resource
	private EntPatentsInfoService entPatentsInfoService;
	@Resource
	private EntCopyRegService entCopyRegService;
	//
	@Resource
	private EntRefNodesService entRefNodesService;
	@Resource
	private EntRefRelationshipsService entRefRelationshipsService;
	@Resource
	private EntReportLogService entReportLogService;

	@Override
	public LoanBizCompanyInfoDTO getEntList(LoanBizCompanyReqDTO param) throws Exception {
		BizRequestParamDTO reqParam = new BizRequestParamDTO();
		BeanUtils.copyProperties(param, reqParam);

		EntListInfoEntity entListInfoEntity = entListInfoService.selectOneByName(param.getName());
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]企业[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}
		return getEntListDTO(entListInfoEntity);
	}

	@Override
	public List<LoanBizCompanyInfoDTO> getCompanyList(LoanBizCompanyListReqDTO param) throws Exception {
		List<EntListInfoEntity> entities = entListInfoService.selectByCreateDate(param.getBeginDate());
		if (Collections.isEmpty(entities)) {
			logger.info("流水号[{}],业务编号[{}]在[{}]后企业名录中无新增数据", param.getSeqNum(), param.getBizCode(), param.getBeginDate());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}
		List<LoanBizCompanyInfoDTO> dtos = Lists.newArrayList();
		for (EntListInfoEntity entListInfoEntity : entities) {
			LoanBizCompanyInfoDTO dto = getEntListDTO(entListInfoEntity);
			dtos.add(dto);
		}
		return dtos;
	}

	private LoanBizCompanyInfoDTO getEntListDTO(EntListInfoEntity entListInfoEntity) {
		LoanBizCompanyInfoDTO dto = new LoanBizCompanyInfoDTO();
		BeanUtils.copyProperties(entListInfoEntity, dto);

		// // 企业、判断是否上市
		// if (null != entListInfoEntity.getEntityType() && EntEntityTypeEnum.COMPANY.key() ==
		// entListInfoEntity.getEntityType()) {
		// EntBaseInfoEntity entBaseInfoEntity = entBaseInfoService.selectOneByEntName(entListInfoEntity.getName());
		// if (null != entBaseInfoEntity) {
		// // 金额去掉单位
		// if (StringUtils.isNotBlank(entBaseInfoEntity.getRegCapital())) {
		// dto.setRegCapital(TycRuleUtils.getAmount(entBaseInfoEntity.getRegCapital()));
		// }
		// }
		// }

		String area = ""; // 区域
		if (StringUtils.isNotBlank(entListInfoEntity.getRegLocation())) {
			area = TycRuleUtils.getArea(entListInfoEntity.getRegLocation());
		} else {
			if (StringUtils.isNotBlank(entListInfoEntity.getName())) {
				area = TycRuleUtils.getArea(entListInfoEntity.getName());
			}
		}

		if (StringUtils.isNotBlank(area)) {
			dto.setArea(area);
		}
		return dto;
	}

	@Override
	public LoanBizBaseinfoSetDTO getBaseinfoSet(LoanBizCompanyReqDTO param) throws Exception {
		BizRequestParamDTO reqParam = new BizRequestParamDTO();
		BeanUtils.copyProperties(param, reqParam);
		// 基本信息
		LoanBizBaseinfoSetDTO dto = new LoanBizBaseinfoSetDTO();
		String entName = param.getName();
		EntListInfoEntity entListInfoEntity = entListInfoService.selectOneByName(entName);
		LoanBizBaseinfoDTO baseInfoDTO = null;
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}
		baseInfoDTO = new LoanBizBaseinfoDTO();
		BeanUtils.copyProperties(entListInfoEntity, baseInfoDTO);
		// if (StringUtils.isNotBlank(entBaseInfoEntity.getRegCapital())) {
		// baseInfoDTO.setRegCapital(TycRuleUtils.getAmount(entBaseInfoEntity.getRegCapital()));
		// }
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

		for (LoanBizHolderDTO loanBizHolderDTO : holders) {
			List<EntHolderCapitalEntity> entHolderCapitalEntities = entHolderCapitalService.selectListByPerson(entName, loanBizHolderDTO.getName());
			List<LoanBizHolderCapitalDTO> capitalLs = ejbGenerator.convert(entHolderCapitalEntities, LoanBizHolderCapitalDTO.class);
			loanBizHolderDTO.setCapital(capitalLs);
		}
		dto.setHolders(holders);
		// 对外投资
		List<EntInverstInfoEntity> entInverstInfoEntities = entInverstInfoService.selectListByName(entName);
		List<LoanBizInverstDTO> inversts = ejbGenerator.convert(entInverstInfoEntities, LoanBizInverstDTO.class);
		dto.setInversts(inversts);
		// 高管信息
		List<EntStaffInfoEntity> entStaffInfoEntities = entStaffInfoService.selectListByName(entName);
		List<LoanBizStaffDTO> staffLs = new ArrayList<LoanBizStaffDTO>();
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
		// 关系图谱
		LoanBizOneKeyCDTO companyReleations = new LoanBizOneKeyCDTO();
		List<EntRefNodesEntity> entRefNodesEntities = entRefNodesService.selectListByEntName(entName);
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
			companyReleations.setNodes(nodes);
		}

		List<EntRefRelationshipsEntity> entRefRelationshipsEntities = entRefRelationshipsService.selectListByEntName(entName);
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
			companyReleations.setRelationships(relationships);
		}

		if (null != companyReleations) {
			dto.setCompanyReleations(companyReleations);
		}
		return dto;
	}

	// 司法信息 开庭公告、裁判文书、法院公告、执行公告、失信公告
	@Override
	public LoanBizJudicialSetDTO getJudicialSet(LoanBizCompanyReqDTO param) throws Exception {

		// 开庭公告
		List<EntKtannounceInfoEntity> entKtannounceInfoEntities = entKtannounceInfoService.selectListByEntName(param.getName());
		List<LoanBizKtannouncementDTO> loanBizKtannouncementDTOs = new ArrayList<LoanBizKtannouncementDTO>();
		LoanBizKtannouncementDTO loanBizKtannouncementDTO = null;
		for (EntKtannounceInfoEntity entity : entKtannounceInfoEntities) {
			loanBizKtannouncementDTO = new LoanBizKtannouncementDTO();
			BeanUtils.copyProperties(entity, loanBizKtannouncementDTO);

			List<EntKtannouncePeopleInfoEntity> entKtannouncePlaintiffInfoEntities = entKtannouncePeopleInfoService.selectListByTableIdPeopleType(entity.getTableId(),
					EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
			List<LoanBizKtannouncementPlaintiffDTO> plaintiffLs = ejbGenerator.convert(entKtannouncePlaintiffInfoEntities, LoanBizKtannouncementPlaintiffDTO.class);
			loanBizKtannouncementDTO.setPlaintiff(plaintiffLs);

			List<EntKtannouncePeopleInfoEntity> entKtannounceDefendantInfoEntities = entKtannouncePeopleInfoService.selectListByTableIdPeopleType(entity.getTableId(),
					EntKtannouncePeopleTypeEnum.DEFENDANT.key());
			List<LoanBizKtannouncementDefendantDTO> defendantLs = ejbGenerator.convert(entKtannounceDefendantInfoEntities, LoanBizKtannouncementDefendantDTO.class);
			loanBizKtannouncementDTO.setDefendant(defendantLs);

			loanBizKtannouncementDTOs.add(loanBizKtannouncementDTO);
		}

		LoanBizJudicialSetDTO dto = new LoanBizJudicialSetDTO();
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

		return dto;
	}

	@Override
	public List<LoanBizNewsDTO> getNewsSet(LoanBizCompanyReqDTO param) {
		List<EntNewsInfoEntity> entNewsInfoEntities = entNewsInfoService.selectByEntName(param.getName());
		List<LoanBizNewsDTO> loanBizLawSuitDTOs = ejbGenerator.convert(entNewsInfoEntities, LoanBizNewsDTO.class);
		return loanBizLawSuitDTOs;
	}

	@Override
	public LoanBizListedCompanyDTO getListedCompany(LoanBizCompanyReqDTO param) {
		BizRequestParamDTO reqParam = new BizRequestParamDTO();
		BeanUtils.copyProperties(param, reqParam);

		EntListInfoEntity entListInfoEntity = entListInfoService.selectByNameCreditCode(param.getName(), null);
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}

		EntBaseInfoEntity entBaseInfoEntity = entBaseInfoService.selectOneByEntName(param.getName());
		if (null == entBaseInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]无该企业基本信息，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("流水号[{}],业务编号[{}]根据企业名称查询[{}]无该企业基本信息，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}

		if (StringUtils.isBlank(entBaseInfoEntity.getBondNum())) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]无上市信息，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			LoanBizListedCompanyDTO dto = new LoanBizListedCompanyDTO();
			dto.setListedFlag(ListedFlagEnum.NO_LISTED.key());
			return dto;
		}
		LoanBizListedCompanyDTO dto = new LoanBizListedCompanyDTO();
		BeanUtils.copyProperties(entBaseInfoEntity, dto);
		if (StringUtils.isNotBlank(entBaseInfoEntity.getBondType())) {
			try {
				Integer listedFlag = ListedFlagEnum.getEnumByDesc(entBaseInfoEntity.getBondType());
				if (null != listedFlag) {
					dto.setListedFlag(listedFlag);
				}
			} catch (Exception e) {
				logger.error("{}对应的上市枚举转化异常", param.getName(), e);
			}
		}

		return dto;
	}

	@Override
	public LoanBizKnowleageSetDTO getKnowleageList(LoanBizCompanyReqDTO param) {
		LoanBizKnowleageSetDTO dto = new LoanBizKnowleageSetDTO();

		List<EntCopyRegEntity> entCopyRegEntities = entCopyRegService.selectByEntName(param.getName());
		List<LoanBizCopyRegDTO> loanBizCopyRegDTOs = ejbGenerator.convert(entCopyRegEntities, LoanBizCopyRegDTO.class);
		dto.setCopyRegs(loanBizCopyRegDTOs);

		List<EntTmInfoEntity> entTmInfoEntities = entTmInfoService.selectByEntName(param.getName());
		List<LoanBizTmDTO> loanBizTmDTOs = ejbGenerator.convert(entTmInfoEntities, LoanBizTmDTO.class);
		dto.setTms(loanBizTmDTOs);

		List<EntPatentsInfoEntity> entPatentsInfoEntities = entPatentsInfoService.selectByEntName(param.getName());
		List<LoanBizPatentsDTO> loanBizPatentsDTOs = ejbGenerator.convert(entPatentsInfoEntities, LoanBizPatentsDTO.class);
		dto.setPatents(loanBizPatentsDTOs);

		return dto;
	}

	/**
	 * 规则：①如果股东为自然人股东，则返回相应信息；②如果股东为企业股东，这需要获得对应的法人姓名和统一社会信用代码
	 */
	@Override
	public List<LoanBizHolderRelationsSetDTO> getHoldersSet(LoanBizViewReqDTO param) throws Exception {
		// 股东信息
		List<EntHolderInfoEntity> entHolderInfoEntities = entHolderInfoService.selectListByName(param.getName());
		List<LoanBizHolderRelationsSetDTO> holders = new ArrayList<>();
		LoanBizHolderRelationsSetDTO dto = null;
		for (EntHolderInfoEntity entity : entHolderInfoEntities) {
			Integer type = entity.getType();
			if (null != type) {
				dto = new LoanBizHolderRelationsSetDTO();
				String holderName = entity.getName();
				if (type == HolderTypeEnum.PERSON.key()) { // 自然人股东
					dto.setPname(holderName);
					dto.setType(entity.getType());
				}

				if (type == HolderTypeEnum.COMPANY.key()) { // 企业股东
					dto = new LoanBizHolderRelationsSetDTO();
					dto.setCname(holderName);
					dto.setType(entity.getType());
					// 查找数据库有无数据，没有，这查询接口数据
					EntListInfoEntity entBaseInfoEntity = entListInfoService.selectOneByName(holderName);
					if (null != entBaseInfoEntity) {
						dto.setPname(entBaseInfoEntity.getLegalPersonName());
						dto.setCcode(entBaseInfoEntity.getCreditCode());
					} else {
						BizRequestParamDTO reqParam = new BizRequestParamDTO();
						reqParam.setName(holderName);
						// TODO 规则待完善
						OpenBaseinfoSetDTO baseinfoV3 = tycOpenBiz.getDirectBaseinfo(reqParam);
						if (null != baseinfoV3) {
							dto.setPname(baseinfoV3.getLegalPersonName());
							dto.setCcode(baseinfoV3.getCreditCode());
							dto.setAddress(baseinfoV3.getRegLocation());
						}
					}
				}
			}

			if (null != dto) {
				holders.add(dto);
			}
		}

		if (holders.size() <= 0) {
			return null;
		}
		return holders;
	}

	@Override
	public boolean saveReport(LoanBizReportTimeReqDTO param, BizInterfaceTypeEnum interfaceType) {
		LoanBizReportReqDTO dto = new LoanBizReportReqDTO();
		BeanUtils.copyProperties(param, dto);
		EntReportLogEntity entity = initReportLogEntity(dto, interfaceType);
		// 需求修改 存的 贷后常规检查 提额调查信息收集 收集时间是传入的 还有个时间存在remark表中，
		// 但之前做的查询都是创建时间查询 这次修改要求查询也按照收集时间来 那就收集时间==创建时间 ，updatetime存真的时间
		entity.setCollectDate(param.getBalanceTime());
		entity.setRemark(param.getProfitTime());
		entity.setCreateTime(param.getBalanceTime());
		return entReportLogService.insert(entity);
	}

	@Override
	public boolean saveReport(LoanBizReportReqDTO param, BizInterfaceTypeEnum interfaceType) {
		EntReportLogEntity entity = initReportLogEntity(param, interfaceType);
		return entReportLogService.insert(entity);
	}

	private EntReportLogEntity initReportLogEntity(LoanBizReportReqDTO param, BizInterfaceTypeEnum interfaceType) {
		EntListInfoEntity entListInfoEntity = entListInfoService.selectOneByName(param.getName());
		Integer entId = null;
		String entName = param.getName();
		String creditCode = param.getCreditCode();
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			if (StringUtils.isNotBlank(param.getCreditCode())) {
				entListInfoEntity = entListInfoService.selectOneByCreditCode(param.getCreditCode());
				if (null != entListInfoEntity) {
					entId = entListInfoEntity.getId();
				}
			} else {
				logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]和统一社会信用代码[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName(), param.getCreditCode());
				throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
			}
		} else {
			entId = entListInfoEntity.getId();
		}

		EntReportLogEntity entity = new EntReportLogEntity();
		if (null != entId) {
			entity.setEntId(entListInfoEntity.getId());
		}
		entity.setEntName(entName);
		entity.setCreditCode(creditCode);
		entity.setBizCode(param.getBizCode());
		entity.setSeqNum(param.getSeqNum());
		entity.setCollectDate(new Date());
		entity.setInterfaceType(interfaceType.key());
		entity.setRemark(interfaceType.desc());
		entity.setReportContent(param.getData());
		return entity;
	}

	@Override
	public LoanBizIndexDTO getIndex(LoanBizCompanyReqDTO param) {
		// 基本信息
		String entName = param.getName();
		EntListInfoEntity entListInfoEntity = entListInfoService.selectOneByName(entName);
		if (null == entListInfoEntity) {
			logger.info("流水号[{}],业务编号[{}]根据企业名称查询[{}]在企业名录中无数据，请核实", param.getSeqNum(), param.getBizCode(), param.getName());
			throw new ApiException("该企业名称或统一社会信用代码不存在于企业名录，请核实", TcxyApiStatusCodeEnum.FAIL.key());
		}
		LoanViewBizBaseInfoDTO baseInfoDTO = null;
		LoanBizIndexDTO dto = new LoanBizIndexDTO();
		if (null != entListInfoEntity) {
			baseInfoDTO = new LoanViewBizBaseInfoDTO();
			// if (StringUtils.isNotBlank(entBaseInfoEntity.getRegCapital())) {
			// baseInfoDTO.setRegCapital(TycRuleUtils.getAmount(entBaseInfoEntity.getRegCapital()));
			// }
			EntBaseInfoEntity baseInfoEntity = entBaseInfoService.selectOneByEntName(entName);
			// 主要信息在baseinfo 表里面 没有在list里面copy有限的值
			if (baseInfoEntity != null) {
				BeanUtils.copyProperties(baseInfoEntity, baseInfoDTO);
				if (baseInfoEntity.getEstiblishTime() != null) {
					baseInfoDTO.setEstiblishTime(new Date(baseInfoEntity.getEstiblishTime()));
				}
			} else {
				BeanUtils.copyProperties(entListInfoEntity, baseInfoDTO);
			}
			baseInfoDTO.setName(entName);
			dto.setBaseinfo(baseInfoDTO);
		}
		// 重大工商变更
		List<EntChangeInfoEntity> entChangeInfoEntityList = entChangeInfoService.selectListByName(param.getName());
		List<LoanViewBizChangeinfoDTO> loanBizChangeinfoDTOList = filtSeriousChange(entChangeInfoEntityList);
		dto.setChangeInfos(loanBizChangeinfoDTOList);
		// 司法信息中位于被告角色的条目数量
		Integer countAccused = countAccused(entName);
		if (Optional.ofNullable(countAccused).isPresent()) {
			dto.setAccusedCount(countAccused);
		}
		// 执行标的
		Double sumExecMoney = sumExecMoney(entName);
		if (Optional.ofNullable(sumExecMoney).isPresent()) {
			dto.setExecMoney(sumExecMoney);
		}
		// 负面舆情
		List<LoanViewBizNewsDTO> negativeNews = getNegativeNews(entName);
		if (!Collections.isEmpty(negativeNews)) {
			dto.setNews(negativeNews);
		}
		return dto;
	}

	/**
	 * 获取负面舆情
	 * 
	 * @param entName
	 * @return
	 */
	private List<LoanViewBizNewsDTO> getNegativeNews(String entName) {
		List<EntNewsInfoEntity> entNewsInfoEntityList = entNewsInfoService.selectByEntName(entName);
		List<EntNewsInfoEntity> negativeNews = entNewsInfoEntityList.parallelStream().filter(entNewsInfoEntity ->ifNegative(entNewsInfoEntity)).collect(Collectors.toList());
		return ejbGenerator.convert(negativeNews, LoanViewBizNewsDTO.class);
	}

	private boolean ifNegative(EntNewsInfoEntity entNewsInfoEntity) {
		String title = entNewsInfoEntity.getTitle();
		if (StrUtil.isNotBlank(title)) {
			for (String badWords : TycWeightPointsConstant.NEWS_BAD_WORDS) {
				if (title.contains(badWords)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 标的额合计
	 * 
	 * @param entName
	 * @return
	 */
	private Double sumExecMoney(String entName) {
		return entZhixingInfoService.sumExecMoney(entName);
	}

	/**
	 * 统计被告条目数量 去除裁判文书，貌似裁判文书没被告？
	 * 
	 * @param entName
	 * @return
	 */
	private Integer countAccused(String entName) {
		Integer num1 = entCourtAnnounceInfoService.countAccused(entName);
		Integer num2 = entKtannounceInfoService.countAccused(entName);
		return num1 + num2;
	}

	/**
	 * 过滤出重大工商变更 并转换为输出的DTO
	 * 
	 * @param list
	 * @return
	 */
	private List<LoanViewBizChangeinfoDTO> filtSeriousChange(List<EntChangeInfoEntity> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		List<LoanViewBizChangeinfoDTO> resutlList = null;
		for (EntChangeInfoEntity entChangeInfoEntity : list) {
			ChangeItemTypeEnum changeItemTypeEnum = TycChangeItemUtils.getChangeItemType(entChangeInfoEntity.getChangeItem());
			if (ifSeriousChange(changeItemTypeEnum)) {
				if (resutlList == null) {
					resutlList = new ArrayList<>();
				}
				LoanViewBizChangeinfoDTO dto = new LoanViewBizChangeinfoDTO();
				dto.setChangeType(changeItemTypeEnum.desc());
				dto.setContentAfter(dealTab(entChangeInfoEntity.getContentAfter()));
				dto.setContentBefore(dealTab(entChangeInfoEntity.getContentBefore()));
				resutlList.add(dto);
			}
		}
		return resutlList;
	}

	/**
	 * 去掉掉<em></em> 标签
	 * 
	 * @param content
	 * @return
	 */
	private String dealTab(String content) {
		if (StrUtil.isNotBlank(content)) {
			return content.replaceAll("<em>", "").replaceAll("</em>", "").replaceAll(" ", "");
		}
		return null;
	}

	private boolean ifSeriousChange(ChangeItemTypeEnum changeItemTypeEnum) {
		// 重大变更包括：股东变更、企业名称变更、法定代表人变更、董监高变更、经营范围变更、注册资本变更、经营范围变更，
		if (changeItemTypeEnum != null && ChangeItemTypeEnum.INDUSTRY != changeItemTypeEnum && ChangeItemTypeEnum.REG_LOCATION != changeItemTypeEnum
				&& ChangeItemTypeEnum.ENTERPRISETYPE != changeItemTypeEnum) {
			return true;
		}
		return false;
	}

}
