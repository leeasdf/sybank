package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCNodesDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCNodesPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCNodesRelationshipsPropertiesDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCRelationshipsDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import xin.tianchuang.modules.spider.service.EntRefNodesService;
import xin.tianchuang.modules.spider.service.EntRefRelationshipsService;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class OneKeyCHandler implements QueryHandler<Open783OneKeyCDTO> {

	private static final Logger logger = LoggerFactory.getLogger(OneKeyCHandler.class);

	@Autowired
	private EntRefNodesService entRefNodesService;
	@Autowired
	private EntRefRelationshipsService entRefRelationshipsService;

	@Override
	public BaseRespnseDTO<Open783OneKeyCDTO> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/oneKeyC?companyId=25476889&appId=a8e319a8b6f64b3e91024e7792a2c701&sign=8b63c67eb547626a0c8f3e96ccb6ebcb
		// String apiData = XybkApiComponent.getApiRespData(param, TycInterfaceTypeEnum.ONE_KEY_C);
		//
		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<Open783OneKeyCDTO>>() {
		}.getType(); //
		TycApiRespDTO<Open783OneKeyCDTO> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<Open783OneKeyCDTO> rtnDTO = new BaseRespnseDTO<Open783OneKeyCDTO>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<Open783OneKeyCDTO> rtnDTO = new BaseRespnseDTO<Open783OneKeyCDTO>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(message);
		rtnDTO.setRespStr(apiData);
		// 如果查询不成功或者结果是成功无数据，那么直接返回查询失败
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) { // 非正常情况
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		// 更新状态
		String entName = param.getName();
		
		
		entRefNodesService.deleteByEntName(entName);
		entRefRelationshipsService.deleteByEntName(entName);
		// 节点数据为空
		Open783OneKeyCDTO data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 查询成功无数据
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
	
		List<Open783OneKeyCNodesDTO> nodes = data.getNodes();
		if (null == nodes || nodes.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntRefNodesEntity> refNodesEntityList = new ArrayList<EntRefNodesEntity>(nodes.size());
		if (null != nodes && nodes.size() >= 1) {
			Open783OneKeyCNodesPropertiesDTO properties = null;
			EntRefNodesEntity entity = null;
			List<String> labelsList = null;
			String labels = null;
			for (Open783OneKeyCNodesDTO dto : nodes) {
				entity = new EntRefNodesEntity();
				BeanUtils.copyProperties(dto, entity);
				properties = dto.getProperties();
				if (null != properties) {
					BeanUtils.copyProperties(properties, entity);
				}
				entity.setEntId(param.getEntListInfo().getId());
				entity.setEntName(entName);
				entity.setCreditCode(param.getEntListInfo().getCreditCode());
				labelsList = dto.getLabels();
				if (null != labelsList && labelsList.size() >= 1) {
					labels = Joiner.on(",").join(labelsList);
					entity.setLabels(labels);
				}
				refNodesEntityList.add(entity);
			}
			entRefNodesService.insertBatch(refNodesEntityList);
		}
		List<Open783OneKeyCRelationshipsDTO> relationships = data.getRelationships();
		if (null != relationships && relationships.size() >= 1) {
			List<EntRefRelationshipsEntity> refRelationshipsEntityList = new ArrayList<EntRefRelationshipsEntity>(relationships.size());
			EntRefRelationshipsEntity entity = null;
			Open783OneKeyCNodesRelationshipsPropertiesDTO properties = null;
			List<String> labelsList = null;
			String labels = null;
			for (Open783OneKeyCRelationshipsDTO dto : relationships) {
				entity = new EntRefRelationshipsEntity();
				BeanUtils.copyProperties(dto, entity);
				properties = dto.getProperties();
				if (null != properties) {
					labelsList = properties.getLabels();
					if (null != labelsList && labelsList.size() >= 1) {
						labels = Joiner.on(",").join(labelsList);
						entity.setLabels(labels);
					}
				}
				entity.setEntId(param.getEntListInfo().getId());
				entity.setEntName(entName);
				entity.setCreditCode(param.getEntListInfo().getCreditCode());

				refRelationshipsEntityList.add(entity);
			}
			entRefRelationshipsService.insertBatch(refRelationshipsEntityList);
		}
		rtnDTO.setData(data);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
