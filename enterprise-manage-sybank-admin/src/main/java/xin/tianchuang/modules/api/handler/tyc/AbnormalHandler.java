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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open391AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;

import xin.tianchuang.modules.spider.service.EntAbnormalInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class AbnormalHandler implements QueryHandler<List<Open391AbnormalDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(AbnormalHandler.class);

	@Autowired
	private EntAbnormalInfoService entAbnormalInfoService;

	@Override
	public BaseRespnseDTO<List<Open391AbnormalDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/abnormal?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":2,\"items\":[{\"createTime\":\"2017-04-09\",\"putDate\":\"2015-07-14\",\"removeDate\":\"2016-04-15\",\"removeDepartment\":\"长沙市工商行政管理局天心分局\",\"removeReason\":\"依法补报了未报年份的年度报告并公示\",\"putReason\":\"未按照规定报送2014年度年度报告\",\"putDepartment\":\"长沙市工商行政管理局天心分局\"},{\"createTime\":\"2017-04-09\",\"putDate\":\"2015-07-13\",\"removeDate\":\"2016-04-15\",\"removeDepartment\":\"长沙市工商行政管理局天心分局\",\"removeReason\":\"依法补报了未报年份的年度报告并公示\",\"putReason\":\"未按照规定报送2013年度年度报告\",\"putDepartment\":\"长沙市工商行政管理局天心分局\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open391AbnormalDTO>> rtnDTO = new BaseRespnseDTO<List<Open391AbnormalDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open391AbnormalDTO>> rtnDTO = new BaseRespnseDTO<List<Open391AbnormalDTO>>();
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
		
		// 先删除 在新增
		entAbnormalInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open391AbnormalDTO> data = dtos.getData();
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
		List<Open391AbnormalDTO> items = data.getItems();

		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntAbnormalInfoEntity> list = Lists.newArrayList();
		EntAbnormalInfoEntity entity = null;
		for (Open391AbnormalDTO item : items) {
			entity = new EntAbnormalInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);
		}
		entAbnormalInfoService.insertBatch(list);

		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
