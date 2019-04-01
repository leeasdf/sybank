//package xin.tianchuang.modules.api.handler.tyc;
//
//import java.lang.reflect.Type;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import xin.tianchuang.common.enums.EntEntityTypeEnum;
//import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
//import xin.tianchuang.common.exception.ApiException;
//import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.response.Open459XgbaseinfoV2DTO;
//import xin.tianchuang.modules.api.bean.api.tyc.response.Open459XgbaseinfoV2LegalInfoDTO;
//import xin.tianchuang.modules.api.dto.TycApiRespDTO;
//import xin.tianchuang.modules.api.handler.QueryHandler;
//import xin.tianchuang.modules.spider.entity.EntBaseFoundationInfoEntity;
//import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;
//import xin.tianchuang.modules.spider.entity.EntBaseInstitutionInfoEntity;
//import xin.tianchuang.modules.spider.entity.EntBaseLawInfoEntity;
//import xin.tianchuang.modules.spider.entity.EntBaseSocialInfoEntity;
//import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
//import xin.tianchuang.modules.spider.service.EntBaseFoundationInfoService;
//import xin.tianchuang.modules.spider.service.EntBaseInfoService;
//import xin.tianchuang.modules.spider.service.EntBaseInstitutionInfoService;
//import xin.tianchuang.modules.spider.service.EntBaseLawInfoService;
//import xin.tianchuang.modules.spider.service.EntBaseSocialInfoService;
//import xin.tianchuang.modules.spider.service.EntListInfoService;
//
//import com.google.common.base.Joiner;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//
///**
// * 
// * @author denghui 该接口暂时废弃
// *
// @see BaseInfoV3handler
// */
//@Deprecated
//public class XgbaseinfoV2Handler implements QueryHandler {
//
//	private static final Logger logger = LoggerFactory.getLogger(XgbaseinfoV2Handler.class);
//
//	@Autowired
//	private EntListInfoService entListInfoService;
//	@Autowired
//	private EntBaseInfoService entBaseInfoService;
//	@Autowired
//	private EntBaseSocialInfoService entBaseSocialInfoService;
//	@Autowired
//	private EntBaseFoundationInfoService entBaseFoundationInfoService;
//	@Autowired
//	private EntBaseInstitutionInfoService entBaseInstitutionInfoService;
//	@Autowired
//	private EntBaseLawInfoService entBaseLawInfoService;
//
//	@Override
//	public BaseRespnseDTO parseData(BaseApiRequestDTO param, String apiData) {
//		// String apiData = XybkApiComponent.getApiRespData(param, TycInterfaceTypeEnum.BASEINFO_V3);
//		
//		//
//		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
//		Type jsonType = new TypeToken<TycApiRespDTO<Open459XgbaseinfoV2DTO>>() {
//		}.getType(); //
//		TycApiRespDTO<Open459XgbaseinfoV2DTO> dtos = gson.fromJson(apiData, jsonType);
//		if (dtos == null) { // 成功
//			throw new ApiException("接口响应数据为空", TcxyApiStatusCodeEnum.SYS_BUZY.key());
//		}
//
//		Integer status = dtos.getStatus();
//		String uuid = dtos.getSeqNum();
//		String message = dtos.getMessage();
//		if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
//			Open459XgbaseinfoV2DTO data = dtos.getData();
//			if (null == data) {
//				throw new ApiException(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc(), TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
//			}
//			Integer entityType = data.getEntityType();
//			String entName = param.getName();
//			EntListInfoEntity listInfoEntity = entListInfoService.selectByNameEntityType(entName, entityType);
//
//			List<String> phoneList = data.getPhoneList();
//			String phoneStr = Joiner.on(",").join(phoneList);
//			if (null == listInfoEntity) {
//				listInfoEntity = new EntListInfoEntity();
//				BeanUtils.copyProperties(data, listInfoEntity);
//
//				listInfoEntity.setPhoneList(phoneStr);
//
//				entListInfoService.insert(listInfoEntity);
//			} else {
//				BeanUtils.copyProperties(data, listInfoEntity);
//				listInfoEntity.setPhoneList(phoneStr);
//				entListInfoService.updateById(listInfoEntity);
//			}
//			// TODO 法人信息存储
//			List<Open459XgbaseinfoV2LegalInfoDTO> legalInfo = data.getLegalInfo();
//
//			if (EntEntityTypeEnum.COMPANY.key() == entityType) {
//				EntBaseInfoEntity entity = entBaseInfoService.selectOneByEntName(entName);
//				if (null == entity) {
//					entity = new EntBaseInfoEntity();
//					BeanUtils.copyProperties(data, entity);
//
//					entity.setPhoneList(phoneStr);
//
//					entBaseInfoService.insert(entity);
//				} else {
//					BeanUtils.copyProperties(data, entity);
//
//					entity.setPhoneList(phoneStr);
//
//					entBaseInfoService.updateById(entity);
//				}
//				// } else if (EntEntityTypeEnum.HK.key() == entityType) {
//				// EntBaseHkInfoEntity entBaseHkInfoEntity = new EntBaseHkInfoEntity();
//			} else if (EntEntityTypeEnum.SOCIAL.key() == entityType) {
//				EntBaseSocialInfoEntity entity = entBaseSocialInfoService.selectOneByName(entName);
//				if (null == entity) {
//					entity = new EntBaseSocialInfoEntity();
//					BeanUtils.copyProperties(data, entity);
//					entBaseSocialInfoService.insert(entity);
//				} else {
//					BeanUtils.copyProperties(data, entity);
//					entBaseSocialInfoService.updateById(entity);
//				}
//			} else if (EntEntityTypeEnum.LAW.key() == entityType) {
//
//				EntBaseLawInfoEntity entity = entBaseLawInfoService.selectOneByName(entName);
//				if (null == entity) {
//					entity = new EntBaseLawInfoEntity();
//					BeanUtils.copyProperties(data, entity);
//					entity.setPhoneList(phoneStr);
//					entBaseLawInfoService.insert(entity);
//				} else {
//					BeanUtils.copyProperties(data, entity);
//					entity.setPhoneList(phoneStr);
//					entBaseLawInfoService.updateById(entity);
//				}
//
//			} else if (EntEntityTypeEnum.INSTITUTION.key() == entityType) {
//				EntBaseInstitutionInfoEntity entity = entBaseInstitutionInfoService.selectOneByName(entName);
//				if (null == entity) {
//					entity = new EntBaseInstitutionInfoEntity();
//					BeanUtils.copyProperties(data, entity);
//					entBaseInstitutionInfoService.insert(entity);
//				} else {
//					BeanUtils.copyProperties(data, entity);
//					entBaseInstitutionInfoService.updateById(entity);
//				}
//
//			} else if (EntEntityTypeEnum.FOUNDATION.key() == entityType) {
//				EntBaseFoundationInfoEntity entity = entBaseFoundationInfoService.selectOneByName(entName);
//				if (null == entity) {
//					entity = new EntBaseFoundationInfoEntity();
//					BeanUtils.copyProperties(data, entity);
//					entBaseFoundationInfoService.insert(entity);
//				} else {
//					BeanUtils.copyProperties(data, entity);
//					entBaseFoundationInfoService.updateById(entity);
//				}
//			}
//
//			// 保存数据
//			// return data;
//			return null;
//		} else if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) { // 查询成功 无数据
//
//		} else if (TcxyApiStatusCodeEnum.SYS_BUZY.key() == status) { // 系统繁忙，重试
//
//		} else {
//			logger.error("[{}]状态为未成功状态:{}-->{}", uuid, status, message);
//			if (TcxyApiStatusCodeEnum.SYS_BUZY.key() == status) { // 系统繁忙，请稍后再试
//				throw new ApiException("系统繁忙，请稍后再试");
//			} else { // 其他
//				// 超出当天使用次数,请明天再试，系统异常等
//				// 502 查找可用代理失败
//				throw new ApiException("系统异常，请稍后再试");
//			}
//		}
//		return null;
//	}
//}
