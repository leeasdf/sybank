package xin.tianchuang.modules.api.biz.impl;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.ApiLogStatusEnum;
import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
import xin.tianchuang.common.enums.YesOrNoEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.tcredit.XybkApiComponent;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
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
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponseBaseinfoDTO;
import xin.tianchuang.modules.api.biz.TycOpenBiz;
import xin.tianchuang.modules.api.component.TranMidWareComponent;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.api.handler.TycApiHandlerFactory;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;
import xin.tianchuang.modules.spider.service.EntListInfoService;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Component
public class TycOpenBizImpl<K> implements TycOpenBiz {

	private static Logger logger = LoggerFactory.getLogger(TycOpenBiz.class);

	@Autowired
	private TycApiHandlerFactory<K> tycApiHandlerFactory;
	@Autowired
	private EntListInfoService entListInfoService;
	@Autowired
	private ApiLogService apiLogService;
	@Resource
	private TranMidWareComponent tranMidWareComponent;

	private <T> T getApiRespData(BaseApiRequestDTO param, TycInterfaceTypeEnum interfaceTypeEnum) {
		// 参数校验
		// TODO 日志记录表记录请求
		ApiLogEntity apiLog = initApiLog(param, interfaceTypeEnum);
		// 送查询请求
		try {
			BizRequestParamDTO bizRequestParamDTO = new BizRequestParamDTO();
			// 获取企业名录信息和基本请求参数
			EntListInfoEntity entListInfoEntity = getEntListAndSetReqParam(param, interfaceTypeEnum, bizRequestParamDTO);
			String apiData = XybkApiComponent.getApiRespData(bizRequestParamDTO, interfaceTypeEnum);
			// String apiData =
			// "{\"data\":{\"total\":1,\"items\":[{\"regStatus\":\"存续\",\"estiblishTime\":1541952000000,\"regCapital\":\"\",\"pencertileScore\":3002,\"type\":1,\"legalPersonName\":\"张良\",\"toco\":2,\"legalPersonId\":1931638230,\"name\":\"宿迁市怡口商贸有限公司泗阳文城新都店\",\"alias\":\"怡口商贸\",\"id\":3272210875,\"category\":\"512\",\"personType\":1,\"base\":\"js\"}]},\"seqNum\":\"c7478effb86c4265a0ad10d902400ebf\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
			logger.info("{}-{}企业信息数据响应结果：{}", param.getSeqNum(), param.getName(), apiData);
			if (StringUtils.isBlank(apiData)) {
				throw new ApiException("返回接口数据为空，请核实", TcxyApiStatusCodeEnum.SYS_ERR.key());
			}
			QueryHandler<K> handlder = tycApiHandlerFactory.create(interfaceTypeEnum);
			BaseRespnseDTO<T> parseData = tranMidWareComponent.transactionParse(handlder, param, apiData);
			// 状态码是否需要判断
			int code = parseData.getCode();

			apiLog.setResponseCode(String.valueOf(code));
			apiLog.setResponseMsg(parseData.getMsg());
			apiLog.setResponseInfo(parseData.getRespStr());
			// 结果终态
			if (TcxyApiStatusCodeEnum.SUCCESS.key() == code || TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == code || TcxyApiStatusCodeEnum.FAIL.key() == code) {
				if (TcxyApiStatusCodeEnum.FAIL.key() == code) {
					apiLog.setSuccessFailTime(new Date());
					apiLog.setStatus(ApiLogStatusEnum.FAIL.key());
					apiLogService.updateById(apiLog);

					throw new ApiException(TcxyApiStatusCodeEnum.FAIL.desc(), TcxyApiStatusCodeEnum.FAIL.key());
				}

				// 更新flag
				if (null != entListInfoEntity) {
					updateFlagById(interfaceTypeEnum, entListInfoEntity, code);
				}

				apiLog.setSuccessFailTime(new Date());
				apiLog.setStatus(ApiLogStatusEnum.SUCCESS.key());
				return parseData.getData(); // 成功返回
			} else if (TcxyApiStatusCodeEnum.PROCESS.key() == code || TcxyApiStatusCodeEnum.SYS_BUZY.key() == code) {// 进行中
				// TODO 重试机制
				apiLog.setStatus(ApiLogStatusEnum.PROCESS.key());
				throw new ApiException(TcxyApiStatusCodeEnum.PROCESS.desc(), TcxyApiStatusCodeEnum.PROCESS.key());
			} else { // 系统终态
				apiLog.setSuccessFailTime(new Date());
				apiLog.setStatus(ApiLogStatusEnum.FAIL.key());
				throw new ApiException(parseData.getMsg(), TcxyApiStatusCodeEnum.FAIL.key());
			}
		} catch (ApiException e) {
			logger.error("{},API调用异常，返回{}-{}", param.getName(), e.getCode(), e.getMessage());
			apiLog.setErrorMsg(e.getMessage());
			throw new ApiException(e.getMessage(), e.getCode());
		} catch (Exception e) {
			logger.error("{}", e.getLocalizedMessage());
			apiLog.setErrorMsg(e.getMessage());
			throw new ApiException(TcxyApiStatusCodeEnum.SYS_ERR.desc(), TcxyApiStatusCodeEnum.SYS_ERR.key());
		} finally {
			apiLogService.updateById(apiLog);
		}
	}

	private EntListInfoEntity getEntListAndSetReqParam(BaseApiRequestDTO param, TycInterfaceTypeEnum interfaceTypeEnum, BizRequestParamDTO bizRequestParamDTO) {
		String name = param.getName();
		
		if (StringUtils.isBlank(name) && StringUtils.isBlank(param.getCreditCode())) {
			logger.error("企业名称、统一社会信用代码不能同时为空");
			throw new ApiException("企业名称、统一社会信用代码不能同时为空", TcxyApiStatusCodeEnum.PARAM_ERR.key());
		}

		// 无企业名称，有社会信用代码
		if (StringUtils.isBlank(name) && StringUtils.isNotBlank(param.getCreditCode())) {
			EntListInfoEntity entListInfoEntity = entListInfoService.selectByNameCreditCode(null, param.getCreditCode());
			if (null != entListInfoEntity) {
				bizRequestParamDTO.setName(entListInfoEntity.getName());
				bizRequestParamDTO.setCompanyId(entListInfoEntity.getTycId());

				param.setEntListInfo(entListInfoEntity);
				return entListInfoEntity;
			}
		} else { // 有企业名称
			EntListInfoEntity entListInfoEntity = entListInfoService.selectByNameCreditCode(param.getName(), null);
			if (null != entListInfoEntity) {
				Long tycId = entListInfoEntity.getTycId();
				if (interfaceTypeEnum == TycInterfaceTypeEnum.ONE_KEY_C && null == tycId) {
					logger.error("{}企业关系图谱必须需要基础信息中有companyId", name);
					throw new ApiException(TcxyApiStatusCodeEnum.PARAM_ERR.desc(), TcxyApiStatusCodeEnum.PARAM_ERR.key());
				}
				bizRequestParamDTO.setCompanyId(tycId);
				bizRequestParamDTO.setName(name);

				param.setEntListInfo(entListInfoEntity);
				return entListInfoEntity;
			}

		}
		logger.error("{}企业名录中无该企业信息", name);
		throw new ApiException("}企业名录中无该企业信息，请核实", TcxyApiStatusCodeEnum.PARAM_ERR.key());
		
	}

	private void updateFlagById(TycInterfaceTypeEnum interfaceTypeEnum, EntListInfoEntity entListInfoEntity, int code) {
		// 设置更新字段值
		if (TcxyApiStatusCodeEnum.SUCCESS.key() == code) {
			getEntListInfoEntityFlag(interfaceTypeEnum, entListInfoEntity, YesOrNoEnum.YES.key());
		} else {
			getEntListInfoEntityFlag(interfaceTypeEnum, entListInfoEntity, YesOrNoEnum.NO.key());
		}
		entListInfoEntity.setCollectDate(new Date());
		// 更新
		int rows = entListInfoService.updateRowsById(entListInfoEntity);
		// 更新不成功版本号不一致了 锁住去查获得最新记录更新
		if (rows < 0) {
			syncUpdateFlagById(interfaceTypeEnum, entListInfoEntity, code);
		}
	}

	synchronized private void syncUpdateFlagById(TycInterfaceTypeEnum interfaceTypeEnum, EntListInfoEntity entListInfoEntity, int code) {
		entListInfoEntity = entListInfoService.selectOneByName(entListInfoEntity.getName());
		if (TcxyApiStatusCodeEnum.SUCCESS.key() == code) {
			getEntListInfoEntityFlag(interfaceTypeEnum, entListInfoEntity, YesOrNoEnum.YES.key());
		} else {
			getEntListInfoEntityFlag(interfaceTypeEnum, entListInfoEntity, YesOrNoEnum.NO.key());
		}
		entListInfoEntity.setCollectDate(new Date());
		entListInfoService.updateRowsById(entListInfoEntity);
	}

	private void getEntListInfoEntityFlag(TycInterfaceTypeEnum interfaceTypeEnum, EntListInfoEntity entListInfoEntity, Integer flag) {
		switch (interfaceTypeEnum) {
		// case BASEINFO_V3:
		// entListInfoEntity.setBaseinfoFlag(flag);
		// break;
		case HOLDER:
			entListInfoEntity.setHolderFlag(flag);
			break;
		case INVERST:
			entListInfoEntity.setInverstFlag(flag);
			break;
		case CHANGEINFO:
			entListInfoEntity.setChangeinfoFlag(flag);
			break;
		case BRANCH:
			entListInfoEntity.setBranchFlag(flag);
			break;
		case LAW_SUIT:
			entListInfoEntity.setLawSuitFlag(flag);
			break;
		case COURT_ANNOUNCEMENT:
			entListInfoEntity.setCourtAnnouncementFlag(flag);
			break;
		case DISHONEST_V2:
			entListInfoEntity.setDishonestFlag(flag);
			break;
		case ZHIXINGINFO:
			entListInfoEntity.setZhixinginfoFlag(flag);
			break;
		case KTANNOUNCEMENT:
			entListInfoEntity.setKtannouncementFlag(flag);
			break;
		case ABNORMAL:
			entListInfoEntity.setAbnormalFlag(flag);
			break;
		case CREDIT_CHINA_V2:
			entListInfoEntity.setCreditChinaFlag(flag);
			break;
		case EQUITY_INFO:
			entListInfoEntity.setEquityInfoFlag(flag);
			break;
		case MORTGAGE_INFO:
			entListInfoEntity.setMortgageInfoFlag(flag);
			break;
		case OWN_TAX:
			entListInfoEntity.setOwnTaxFlag(flag);
			break;
		case BIDS:
			entListInfoEntity.setBidsFlag(flag);
			break;
		case EMPLOYMENTS_V2:
			entListInfoEntity.setEmploymentsFlag(flag);
			break;
		case TM:
			entListInfoEntity.setTmFlag(flag);
			break;
		case PATENTS:
			entListInfoEntity.setPatentsFlag(flag);
			break;
		case COPY_REG_WORKS:
			entListInfoEntity.setCopyRegWorksFlag(flag);
			break;
		case COPY_REG:
			entListInfoEntity.setCopyRegFlag(flag);
			break;
		case ICP:
			entListInfoEntity.setIcpFlag(flag);
			break;
		case NEWS:
			entListInfoEntity.setNewsFlag(flag);
			break;
		case ONE_KEY_C:
			entListInfoEntity.setOneKeyCFlag(flag);
			break;
		case ANNUALREPORT:
			entListInfoEntity.setAnnualreportFlag(flag);
			break;
		case COMPANY_INFO:
			entListInfoEntity.setCompanyInfoFlag(flag);
			break;
		default:
			break;
		}
	}

	private ApiLogEntity initApiLog(BaseApiRequestDTO param, TycInterfaceTypeEnum interfaceTypeEnum) {
		Gson gson = new Gson();
		String jsonStr = gson.toJson(param);

		ApiLogEntity apiLogEntity = new ApiLogEntity();
		apiLogEntity.setEntName(param.getName());
		apiLogEntity.setCreditCode(param.getCreditCode());
		apiLogEntity.setBizCode(param.getBizCode());
		apiLogEntity.setSeqNum(param.getSeqNum());
		apiLogEntity.setChannelType(param.getChannelType());
		apiLogEntity.setInterfaceType(interfaceTypeEnum.key());
		apiLogEntity.setReqInfo(jsonStr);
		apiLogEntity.setStatus(ApiLogStatusEnum.INIT.key());

		apiLogService.insert(apiLogEntity);
		return apiLogEntity;
	}

	@Override
	public OpenBaseinfoSetDTO getBaseinfoV3(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.BASEINFO_V3);
	}

	@Override
	public List<Open368HolderDTO> getHolder(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.HOLDER);
	}

	@Override
	public List<Open369InverstDTO> getInvest(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.INVERST);
	}

	@Override
	public List<Open370ChangeinfoDTO> getChangeinfo(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.CHANGEINFO);
	}

	@Override
	public List<Open372BranchDTO> getBranch(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.BRANCH);
	}

	@Override
	public List<Open384LawSuitDTO> getLawSuit(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.LAW_SUIT);

	}

	@Override
	public List<Open385CourtAnnouncementDTO> getCourtAnnouncement(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.COURT_ANNOUNCEMENT);
	}

	// 失信人
	@Override
	public List<Open777DishonestV2DTO> getDishonest(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.DISHONEST_V2);
	}

	// 被执行人
	@Override
	public List<Open389ZhixinginfoDTO> getZhixinginfo(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.ZHIXINGINFO);
	}

	// 开庭公告
	@Override
	public List<Open386KtannouncementDTO> getKtannouncement(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.KTANNOUNCEMENT);
	}

	// 经营异常
	@Override
	public List<Open391AbnormalDTO> getAbnormal(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.ABNORMAL);
	}

	// 行政处罚-信用中国（新版）
	@Override
	public List<Open767CreditChinaV2DTO> getCreditChinaV2(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.CREDIT_CHINA_V2);
	}

	// 股权出质
	@Override
	public List<Open404EquityInfoDTO> getEquityInfo(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.EQUITY_INFO);
	}

	// 动产抵押
	@Override
	public List<Open421MortgageInfoDTO> getMortgageInfo(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.MORTGAGE_INFO);
	}

	// 欠税公告
	@Override
	public List<Open422OwnTaxDTO> getOweTax(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.OWN_TAX);
	}

	// 招投标
	@Override
	public List<Open429BidsDTO> getBids(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.BIDS);
	}

	// 招聘
	@Override
	public List<Open782EmploymentsV2DTO> getEmploymentsV2(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.EMPLOYMENTS_V2);
	}

	@Override
	public List<Open439TmDTO> getTm(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.TM);
	}

	// 专利
	@Override
	public List<Open440PatentsDTO> getPatents(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.PATENTS);
	}

	// 作品著作权
	@Override
	public List<Open733CopyRegWorksDTO> getCopyRegWorks(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.COPY_REG_WORKS);
	}

	// 著作权
	@Override
	public List<Open441CopyRegDTO> getCopyReg(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.COPY_REG);
	}

	// 网站备案
	@Override
	public List<Open442IcpDTO> getIcp(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.ICP);
	}

	// 获取公司新闻列表
	@Override
	public List<Open446NewsDTO> getNews(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.NEWS);
	}

	@Override
	public boolean getCompanyInfo(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.COMPANY_INFO);
	}

	@Override
	public Open783OneKeyCDTO getOneKeyC(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.ONE_KEY_C);
	}

	@Override
	public List<Open371AnnualreportDTO> getAnnualReport(BizRequestParamDTO param) {
		BaseApiRequestDTO dto = new BaseApiRequestDTO();
		BeanUtils.copyProperties(param, dto);
		return getApiRespData(dto, TycInterfaceTypeEnum.ANNUALREPORT);
	}

	// @Override
	// public Open459XgbaseinfoV2DTO getXgbaseinfoV2(BizRequestParamDTO param) {
	// BaseApiRequestDTO dto = new BaseApiRequestDTO();
	// BeanUtils.copyProperties(param, dto);
	// return getApiRespData(dto, TycInterfaceTypeEnum.XGBASEINFO_V2);
	// }

	/**
	 * 信息不入库
	 */

	@Override
	public OpenBaseinfoSetDTO getDirectBaseinfo(BizRequestParamDTO param) {
		String apiData = XybkApiComponent.getApiRespData(param, TycInterfaceTypeEnum.BASEINFO_V3);
		logger.info("企业信息数据 response：{}", apiData);
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponseBaseinfoDTO<OpenBaseinfoSetDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponseBaseinfoDTO<OpenBaseinfoSetDTO>> tycApiRespDTO = gson.fromJson(apiData, jsonType);

		ResponseBaseinfoDTO<OpenBaseinfoSetDTO> result = tycApiRespDTO.getData();
		if (result == null) { // 成功
			throw new ApiException(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc(), TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
		}

		Integer status = tycApiRespDTO.getStatus();
		// 如果invokeTyp=0，则为365公司接口，如果为1，459接口
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status) { // 查询成功 有数据
			if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) { // 成功无数据情况
				logger.info("{}查询基本信息接口，返回查询成功无数据", param.getName());
				return null;
			}
			logger.info("{}查询基本信息接口，返回其他异常[{}]", param.getName(), apiData);
			throw new ApiException("接口返回异常", TcxyApiStatusCodeEnum.FAIL.key());
		}

		OpenBaseinfoSetDTO data = result.getResult();
		if (null == data) {
			logger.info("{}查询基本信息接口，返回查询成功,节点无数据", param.getName());
			return null;
		}

		return data;

	}

}
