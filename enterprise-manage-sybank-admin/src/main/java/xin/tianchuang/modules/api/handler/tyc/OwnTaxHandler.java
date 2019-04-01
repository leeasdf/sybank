package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open422OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntOwnTaxEntity;
import xin.tianchuang.modules.spider.service.EntOwnTaxService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class OwnTaxHandler implements QueryHandler<List<Open422OwnTaxDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(OwnTaxHandler.class);

	@Autowired
	private EntOwnTaxService entOwnTaxService;

	@Override
	public BaseRespnseDTO<List<Open422OwnTaxDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/ownTax?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":2,\"items\":[{\"regType\":null,\"personIdNumber\":\"非公示项\",\"legalpersonName\":\"王惠民\",\"location\":\"洪山区珞瑜路196号\",\"ownTaxAmount\":\"66.19\",\"department\":\"湖北省地方税务局\",\"taxIdNumber\":\"\",\"type\":\"地税\",\"taxCategory\":\"营业税、城市维护建设税等\",\"taxpayerType\":null,\"newOwnTaxBalance\":null,\"ownTaxBalance\":\"\",\"name\":\"武汉远东绿世界集团有限公司\",\"personIdName\":null,\"publishDate\":\"2014-12-31\"},{\"regType\":null,\"personIdNumber\":\"非公示项\",\"legalpersonName\":\"王惠民\",\"location\":\"洪山区珞瑜路196号\",\"ownTaxAmount\":\"\",\"department\":null,\"taxIdNumber\":\"  \",\"type\":\"国税\",\"taxCategory\":\"营业税、城市维护建设税等\",\"taxpayerType\":null,\"newOwnTaxBalance\":\"\",\"ownTaxBalance\":\"661900\",\"name\":\"武汉远东绿世界集团有限公司\",\"personIdName\":null,\"publishDate\":null}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open422OwnTaxDTO>> rtnDTO = new BaseRespnseDTO<List<Open422OwnTaxDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();
		BaseRespnseDTO<List<Open422OwnTaxDTO>> rtnDTO = new BaseRespnseDTO<List<Open422OwnTaxDTO>>();
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
		
		// 节点数据为空
		ResponsePageNumResultDTO<Open422OwnTaxDTO> data = dtos.getData();
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
		// 保存数据
		List<Open422OwnTaxDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		// 先删除 在新增
		entOwnTaxService.deleteByEntName(entName);
		List<EntOwnTaxEntity> ownTaxEntityList = Lists.newArrayList();
		EntOwnTaxEntity entity = null;
		for (Open422OwnTaxDTO item : items) {

			entity = new EntOwnTaxEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			ownTaxEntityList.add(entity);
		}
		entOwnTaxService.insertBatch(ownTaxEntityList);

		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
