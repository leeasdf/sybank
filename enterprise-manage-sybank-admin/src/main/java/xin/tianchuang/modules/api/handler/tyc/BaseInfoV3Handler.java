package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.EntEntityTypeEnum;
import xin.tianchuang.common.enums.InvokeTypeEnum;
import xin.tianchuang.common.enums.ListedFlagEnum;
import xin.tianchuang.common.enums.YesOrNoEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open365BaseinfoV3DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open365BaseinfoV3StaffChildDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open365BaseinfoV3StaffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open459XgbaseinfoV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.OpenBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponseBaseinfoDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBaseInstitutionInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBaseSocialInfoEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;
import xin.tianchuang.modules.spider.entity.EntStaffPositionEntity;
import xin.tianchuang.modules.spider.service.EntBaseFoundationInfoService;
import xin.tianchuang.modules.spider.service.EntBaseInfoService;
import xin.tianchuang.modules.spider.service.EntBaseInstitutionInfoService;
import xin.tianchuang.modules.spider.service.EntBaseLawInfoService;
import xin.tianchuang.modules.spider.service.EntBaseSocialInfoService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.EntStaffInfoService;
import xin.tianchuang.modules.spider.service.EntStaffPositionService;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author denghui
 *
 */
public class BaseInfoV3Handler implements QueryHandler<OpenBaseinfoSetDTO> {

	private static final Logger logger = LoggerFactory.getLogger(BaseInfoV3Handler.class);

	@Autowired
	private EntListInfoService entListInfoService;
	@Autowired
	private EntBaseInfoService entBaseInfoService;
	@Autowired
	private EntStaffInfoService entStaffInfoService;
	@Autowired
	private EntStaffPositionService entStaffPositionService;
	// 465 接口
	@Autowired
	private EntBaseSocialInfoService entBaseSocialInfoService;
	@Autowired
	private EntBaseFoundationInfoService entBaseFoundationInfoService;
	@Autowired
	private EntBaseInstitutionInfoService entBaseInstitutionInfoService;
	@Autowired
	private EntBaseLawInfoService entBaseLawInfoService;

	@Override
	public BaseRespnseDTO<OpenBaseinfoSetDTO> parseData(BaseApiRequestDTO param, String apiData) {
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponseBaseinfoDTO<OpenBaseinfoSetDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponseBaseinfoDTO<OpenBaseinfoSetDTO>> tycApiRespDTO = gson.fromJson(apiData, jsonType);

		ResponseBaseinfoDTO<OpenBaseinfoSetDTO> result = tycApiRespDTO.getData();
		if (result == null) { // 成功
			logger.error("{}数据返回为空", param.getSeqNum());
			BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = tycApiRespDTO.getStatus();
		String uuid = tycApiRespDTO.getSeqNum();

		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status) { // 非正常情况
			if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) { // 成功无数据情况
				EntListInfoEntity entity = entListInfoService.selectByNameCreditCode(param.getName(), null);
				if (null != entity) {
					entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
					entity.setCollectDate(new Date());
					entity.setBaseinfoFlag(YesOrNoEnum.YES.key());
					entListInfoService.updateById(entity);
				}

				BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
				rtnDTO.setRtnSerialNo(uuid);
				rtnDTO.setRespStr(apiData);
				rtnDTO.setRemark("查询成功无数据");
				return rtnDTO;
			} else {
				BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
				rtnDTO.setRtnSerialNo(uuid);
				rtnDTO.setCode(status);
				rtnDTO.setMsg(tycApiRespDTO.getMessage());
				rtnDTO.setRespStr(apiData);
				rtnDTO.setRemark("查询失败");
				return rtnDTO;
			}
		}
		// 查询成功 有数据
		OpenBaseinfoSetDTO data = result.getResult();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}

		String entName = data.getName();
		// 如果invokeTyp=0，则为365公司接口，如果为1，459接口
		Integer invokeType = result.getInvokeType();
		if (InvokeTypeEnum.COMPANY.key() == invokeType) { // 公司
			Open365BaseinfoV3DTO baseinfoV3DTO = new Open365BaseinfoV3DTO();
			BeanUtils.copyProperties(data, baseinfoV3DTO);

			EntBaseInfoEntity dbBaseInfoEntity = entBaseInfoService.selectOneByEntName(entName);
			Integer entId = null; // 企业id
			EntBaseInfoEntity baseInfoEntity = null;
			// 有股票代码，这为上市企业
			String bondType = baseinfoV3DTO.getBondType();

			ListedFlagEnum listedFlag = null;
			if (StringUtils.isNotBlank(bondType)) {
				try {
					listedFlag = ListedFlagEnum.valueOf(bondType);
				} catch (Exception e) {
					logger.error("{}对应的上市枚举转化异常", param.getName(), e);
				}
			}
			if (null == dbBaseInfoEntity) {

				EntListInfoEntity entity = entListInfoService.selectByNameCreditCode(entName, null);
				if (null == entity) {
					entity = new EntListInfoEntity();
					BeanUtils.copyProperties(baseinfoV3DTO, entity);
					entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
					entity.setCollectDate(new Date());
					entity.setBaseinfoFlag(YesOrNoEnum.YES.key());
					if (null != listedFlag) {
						entity.setListedFlag(listedFlag.key());
					}
					entListInfoService.insert(entity);
				} else {
					BeanUtils.copyProperties(baseinfoV3DTO, entity);
					entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
					entity.setCollectDate(new Date());
					entity.setBaseinfoFlag(YesOrNoEnum.YES.key());
					if (null != listedFlag) {
						entity.setListedFlag(listedFlag.key());
					}
					entListInfoService.updateById(entity);
				}
				entId = entity.getId();

				baseInfoEntity = new EntBaseInfoEntity();
				BeanUtils.copyProperties(baseinfoV3DTO, baseInfoEntity);
				baseInfoEntity.setEntId(entity.getId());
				baseInfoEntity.setEntName(entName);
				baseInfoEntity.setCreditCode(entity.getCreditCode());
				if (null != listedFlag) {
					baseInfoEntity.setListedFlag(listedFlag.key());
				}

				entBaseInfoService.insert(baseInfoEntity);
			} else {
				EntListInfoEntity entity = entListInfoService.selectByNameEntityType(entName, EntEntityTypeEnum.COMPANY.key());
				BeanUtils.copyProperties(baseinfoV3DTO, entity);
				entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
				entity.setCollectDate(new Date());
				if (null != listedFlag) {
					entity.setListedFlag(listedFlag.key());
				}
				entListInfoService.updateById(entity);
				entId = entity.getId();

				BeanUtils.copyProperties(baseinfoV3DTO, dbBaseInfoEntity);

				if (null != listedFlag) {
					dbBaseInfoEntity.setListedFlag(listedFlag.key());
				}
				entBaseInfoService.updateById(dbBaseInfoEntity);
			}

			Open365BaseinfoV3StaffDTO open365BaseinfoV3StaffDTO = baseinfoV3DTO.getStaffList();
			if (null != open365BaseinfoV3StaffDTO && null != open365BaseinfoV3StaffDTO.getResult() && open365BaseinfoV3StaffDTO.getResult().size() > 0) {
				// 先删除 在插入
				entStaffInfoService.deleteByEntName(entName);

				List<String> typeJoinLs = null;
				EntStaffInfoEntity staffInfoEntity = null;

				List<EntStaffPositionEntity> list = Lists.newArrayList();
				EntStaffPositionEntity entity = null;
				for (Open365BaseinfoV3StaffChildDTO staffChild : open365BaseinfoV3StaffDTO.getResult()) {
					staffInfoEntity = new EntStaffInfoEntity();
					BeanUtils.copyProperties(staffChild, staffInfoEntity);

					staffInfoEntity.setEntId(entId);
					staffInfoEntity.setEntName(entName);
					staffInfoEntity.setCreditCode(baseinfoV3DTO.getCreditCode());

					typeJoinLs = staffChild.getTypeJoin();
					if (null != typeJoinLs && typeJoinLs.size() >= 1) {
						String str = Joiner.on(",").join(typeJoinLs);
						staffInfoEntity.setTypeJoin(str);
					}

					boolean insertFlag = entStaffInfoService.insert(staffInfoEntity);
					if (insertFlag) {
						entStaffPositionService.deleteByName(entName, staffInfoEntity.getName());
						for (String type : typeJoinLs) {
							entity = new EntStaffPositionEntity();
							entity.setEntId(entId);
							entity.setEntName(entName);
							entity.setCreditCode(baseinfoV3DTO.getCreditCode());
							entity.setName(staffInfoEntity.getName());
							entity.setPositon(type);

							list.add(entity);
						}
					}
				}

				if (list.size() > 0) {
					entStaffPositionService.insertBatch(list);
				}
			}

			BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
			rtnDTO.setRtnSerialNo(uuid);
			rtnDTO.setData(data);
			rtnDTO.setRespStr(apiData);
			rtnDTO.setRemark("查询公司信息成功");
			logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
			return rtnDTO;

		} else { // 社会组织、事业单位
			Open459XgbaseinfoV2DTO xgbaseinfoV2DTO = new Open459XgbaseinfoV2DTO();
			BeanUtils.copyProperties(data, xgbaseinfoV2DTO);

			Integer entityType = xgbaseinfoV2DTO.getEntityType();
			EntListInfoEntity listInfoEntity = entListInfoService.selectByNameEntityType(entName, entityType);

			List<String> phoneList = xgbaseinfoV2DTO.getPhoneList();
			String phoneStr = "";
			if (null != phoneList && phoneList.size() >= 1) {
				phoneStr = Joiner.on(",").join(phoneList);
			}
			if (null == listInfoEntity) {
				listInfoEntity = new EntListInfoEntity();
				BeanUtils.copyProperties(xgbaseinfoV2DTO, listInfoEntity);

				if (StringUtils.isNotBlank(phoneStr)) {
					listInfoEntity.setPhoneList(phoneStr);
				}

				listInfoEntity.setCollectDate(new Date());
				listInfoEntity.setBaseinfoFlag(YesOrNoEnum.YES.key());
				entListInfoService.insert(listInfoEntity);
			} else {
				BeanUtils.copyProperties(xgbaseinfoV2DTO, listInfoEntity);

				if (StringUtils.isNotBlank(phoneStr)) {
					listInfoEntity.setPhoneList(phoneStr);
				}
				listInfoEntity.setCollectDate(new Date());
				listInfoEntity.setBaseinfoFlag(YesOrNoEnum.YES.key());
				entListInfoService.updateById(listInfoEntity);
			}

			if (EntEntityTypeEnum.SOCIAL.key() == entityType) {
				EntBaseSocialInfoEntity entity = entBaseSocialInfoService.selectOneByName(entName);
				if (null == entity) {
					entity = new EntBaseSocialInfoEntity();
					BeanUtils.copyProperties(xgbaseinfoV2DTO, entity);

					entity.setEntId(listInfoEntity.getId());
					entity.setEntName(listInfoEntity.getName());
					entity.setCreditCode(listInfoEntity.getCreditCode());
					entBaseSocialInfoService.insert(entity);
				} else {
					BeanUtils.copyProperties(xgbaseinfoV2DTO, entity);

					entity.setEntId(listInfoEntity.getId());
					entity.setEntName(listInfoEntity.getName());
					entity.setCreditCode(listInfoEntity.getCreditCode());
					entBaseSocialInfoService.updateById(entity);
				}

				listInfoEntity.setEntityType(EntEntityTypeEnum.SOCIAL.key());
				entListInfoService.updateById(listInfoEntity);
			} else if (EntEntityTypeEnum.INSTITUTION.key() == entityType) {
				EntBaseInstitutionInfoEntity entity = entBaseInstitutionInfoService.selectOneByName(entName);
				if (null == entity) {
					entity = new EntBaseInstitutionInfoEntity();
					BeanUtils.copyProperties(xgbaseinfoV2DTO, entity);

					entity.setEntId(listInfoEntity.getId());
					entity.setEntName(listInfoEntity.getName());
					entity.setCreditCode(listInfoEntity.getCreditCode());
					entBaseInstitutionInfoService.insert(entity);
				} else {
					BeanUtils.copyProperties(xgbaseinfoV2DTO, entity);

					entity.setEntId(listInfoEntity.getId());
					entity.setEntName(listInfoEntity.getName());
					entity.setCreditCode(listInfoEntity.getCreditCode());
					entBaseInstitutionInfoService.updateById(entity);
				}

				listInfoEntity.setEntityType(EntEntityTypeEnum.INSTITUTION.key());
				entListInfoService.updateById(listInfoEntity);
			}

			BaseRespnseDTO<OpenBaseinfoSetDTO> rtnDTO = new BaseRespnseDTO<OpenBaseinfoSetDTO>();
			rtnDTO.setRtnSerialNo(uuid);
			rtnDTO.setData(data);
			rtnDTO.setRespStr(apiData);
			rtnDTO.setRemark("查询其他成功");
			logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
			return rtnDTO;
		}

	}
}
