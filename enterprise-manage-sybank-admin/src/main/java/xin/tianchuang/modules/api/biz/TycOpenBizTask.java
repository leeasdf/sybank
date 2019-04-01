package xin.tianchuang.modules.api.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.ApiLogStatusEnum;
import xin.tianchuang.common.enums.ChannelTypeEnum;
import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
import xin.tianchuang.common.enums.YesOrNoEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.utils.tcredit.XybkApiComponent;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.component.TranMidWareComponent;
import xin.tianchuang.modules.api.dto.SysTaskReqDTO;
import xin.tianchuang.modules.api.dto.SysTaskRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.api.handler.TycApiHandlerFactory;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;
import xin.tianchuang.modules.spider.service.EntListInfoService;

import com.google.gson.Gson;

/**
 * Created by lee on 2019/3/9.
 */
@Component
public class TycOpenBizTask {

	private static Logger logger = LoggerFactory.getLogger(TycOpenBizTask.class);

	@Autowired
	private TycApiHandlerFactory tycApiHandlerFactory;

	@Autowired
	private ApiLogService apiLogService;

	@Autowired
	private EntListInfoService entListInfoService;

	@Autowired
	private TranMidWareComponent tranMidWareComponent;

	/**
	 * 跑单个接口的
	 * 
	 * @param paramList
	 * @param interfaceTypeEnum
	 * @return
	 */
	public List<SysTaskRespDTO> getApiRespDataList(List<SysTaskReqDTO> paramList, TycInterfaceTypeEnum interfaceTypeEnum) {
		if (paramList == null || paramList.isEmpty()) {
			return null;
		}
		List<SysTaskRespDTO> res = new ArrayList<SysTaskRespDTO>(paramList.size());
		SysTaskRespDTO apiRespData = null;
		for (SysTaskReqDTO param : paramList) {
			apiRespData = getApiRespData(param, interfaceTypeEnum);
			res.add(apiRespData);
		}
		return res;
	}

	public SysTaskRespDTO getApiRespData(SysTaskReqDTO param, TycInterfaceTypeEnum interfaceTypeEnum) {
		ApiLogEntity apiLog = null;
		if (param.getRetry()) {
			apiLog = param.getApiLogEntity();
			// 重试 重试次数+1
			apiLog.setRetryTimes(apiLog.getRetryTimes() + 1);
		} else {
			BaseApiRequestDTO req = new BaseApiRequestDTO();
			BeanUtils.copyProperties(param, req);
			apiLog = initApiLog(req, interfaceTypeEnum);
		}

		SysTaskRespDTO res = new SysTaskRespDTO();
		res.setEntId(param.getEntId());
		res.setInterfaceName(interfaceTypeEnum.key());

		try {
			BizRequestParamDTO bizRequestParamDTO = new BizRequestParamDTO();
			bizRequestParamDTO.setCompanyId(param.getCompanyId());
			bizRequestParamDTO.setName(param.getName());
			bizRequestParamDTO.setCreditCode(param.getCreditCode());
			bizRequestParamDTO.setChannelType(ChannelTypeEnum.SYS.key());

			String apiData = XybkApiComponent.getApiRespData(bizRequestParamDTO, interfaceTypeEnum);
			logger.info("{}企业信息数据response：{}", param.getName(), apiData);
			QueryHandler handlder = tycApiHandlerFactory.create(interfaceTypeEnum);

			BaseApiRequestDTO dtoParam = new BaseApiRequestDTO();
			BeanUtils.copyProperties(param, dtoParam);
			dtoParam.setEntListInfo(param.getEntListInfo());

			BaseRespnseDTO parseData = tranMidWareComponent.transactionParse(handlder, dtoParam, apiData);
			// 状态码是否需要判断
			int code = parseData.getCode();
			apiLog.setResponseCode(String.valueOf(code));
			apiLog.setResponseMsg(parseData.getMsg());
			apiLog.setResponseInfo(parseData.getRespStr());

			res.setCode(code);
			res.setMsg(parseData.getMsg());

			if (TcxyApiStatusCodeEnum.SUCCESS.key() == code || TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == code || TcxyApiStatusCodeEnum.FAIL.key() == code) {

				if (TcxyApiStatusCodeEnum.FAIL.key() == code) {
					apiLog.setSuccessFailTime(new Date());
					apiLog.setStatus(ApiLogStatusEnum.FAIL.key());
					res.fail();
					throw new ApiException(TcxyApiStatusCodeEnum.FAIL.desc(), TcxyApiStatusCodeEnum.FAIL.key());
				}
				// 更新flag
				if (null != param.getEntListInfo()) {
					updateFlagById(interfaceTypeEnum, param.getEntListInfo(), code);
				}

				apiLog.setSuccessFailTime(new Date());
				apiLog.setStatus(ApiLogStatusEnum.SUCCESS.key());
				res.success();

			} else if (TcxyApiStatusCodeEnum.PROCESS.key() == code || TcxyApiStatusCodeEnum.SYS_BUZY.key() == code) {// 进行中
				// TODO 重试机制
				apiLog.setStatus(ApiLogStatusEnum.PROCESS.key());
				res.unknown();
			} else { // 系统终态
				apiLog.setSuccessFailTime(new Date());
				apiLog.setStatus(ApiLogStatusEnum.FAIL.key());
				res.fail();
			}

		} catch (Exception e) {
			logger.error("{}", e.getLocalizedMessage());
			apiLog.setErrorMsg(e.getMessage());

			res.fail();
			res.setMsg(e.getMessage());

		} finally {
			apiLogService.updateById(apiLog);
		}
		return res;
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
		// waring：更新不成功版本号不一致了 去查询获得最新记录更新，可能会导致脏读，暂没任何影响
		if (rows < 0) {
			syncUpdateFlagById(interfaceTypeEnum, entListInfoEntity, code);
		}
	}

	private void syncUpdateFlagById(TycInterfaceTypeEnum interfaceTypeEnum, EntListInfoEntity entListInfoEntity, int code) {
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
}
