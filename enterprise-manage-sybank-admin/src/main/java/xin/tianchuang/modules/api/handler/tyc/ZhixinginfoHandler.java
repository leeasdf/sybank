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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;
import xin.tianchuang.modules.spider.service.EntZhixingInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class ZhixinginfoHandler implements QueryHandler<List<Open389ZhixinginfoDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(ZhixinginfoHandler.class);

	@Autowired
	private EntZhixingInfoService entZhixingInfoService;

	@Override
	public BaseRespnseDTO<List<Open389ZhixinginfoDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/zhixinginfo?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData = XybkApiComponent.getApiRespData(param, TycInterfaceTypeEnum.ZHIXINGINFO);
		// String apiData =
		// "{\"data\":{\"total\":19,\"items\":[{\"caseCode\":\"(2017)苏0812执4249号\",\"execCourtName\":\"淮安市清江浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"91320811696****409A\",\"caseCreateTime\":1511107200000,\"execMoney\":\"55593\"},{\"caseCode\":\"(2017)苏0812执4247号\",\"execCourtName\":\"淮安市清江浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1511107200000,\"execMoney\":\"47689\"},{\"caseCode\":\"(2017)苏0812执4248号\",\"execCourtName\":\"淮安市清江浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1511107200000,\"execMoney\":\"58435\"},{\"caseCode\":\"(2017)苏0812执3091号\",\"execCourtName\":\"淮安市清江浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1502985600000,\"execMoney\":\"25061\"},{\"caseCode\":\"(2017)苏0812执3090号\",\"execCourtName\":\"淮安市清江浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1502985600000,\"execMoney\":\"38806\"},{\"caseCode\":\"(2017)苏08执78号\",\"execCourtName\":\"淮安市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1490889600000,\"execMoney\":\"42576\"},{\"caseCode\":\"(2017)苏08执77号\",\"execCourtName\":\"淮安市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1490889600000,\"execMoney\":\"42576\"},{\"caseCode\":\"(2017)苏08执76号\",\"execCourtName\":\"淮安市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1490889600000,\"execMoney\":\"42576\"},{\"caseCode\":\"(2017)苏0581执272号\",\"execCourtName\":\"常熟市人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1484150400000,\"execMoney\":\"263298\"},{\"caseCode\":\"(2016)苏0811执2348号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1482681600000,\"execMoney\":\"250016\"},{\"caseCode\":\"(2016)苏0811执2346号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1482681600000,\"execMoney\":\"1737968\"},{\"caseCode\":\"(2016)苏0811执2072号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1479916800000,\"execMoney\":\"5025\"},{\"caseCode\":\"(2016)苏0811执恢338号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740-9\",\"caseCreateTime\":1476892800000,\"execMoney\":\"4029200\"},{\"caseCode\":\"(2016)苏08执406号\",\"execCourtName\":\"淮安市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"12345678-9\",\"caseCreateTime\":1474819200000,\"execMoney\":\"151094\"},{\"caseCode\":\"(2016)苏0811执1504号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"56261546-7\",\"caseCreateTime\":1472054400000,\"execMoney\":\"35338\"},{\"caseCode\":\"(2016)鲁02执659号\",\"execCourtName\":\"青岛市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":\"69670740－9\",\"caseCreateTime\":1471276800000,\"execMoney\":\"33100000\"},{\"caseCode\":\"(2016)苏0811执1444号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1471190400000,\"execMoney\":\"11654208.0\"},{\"caseCode\":\"(2016)苏0811执1258号\",\"execCourtName\":\"淮安市清浦区人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1469030400000,\"execMoney\":\"520350\"},{\"caseCode\":\"(2016)苏08执273号\",\"execCourtName\":\"淮安市中级人民法院\",\"pname\":\"淮安禧徕乐投资发展有限公司\",\"partyCardNum\":null,\"caseCreateTime\":1465315200000,\"execMoney\":\"61371224.0\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open389ZhixinginfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open389ZhixinginfoDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String entName = param.getName();

		BaseRespnseDTO<List<Open389ZhixinginfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open389ZhixinginfoDTO>>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setRespStr(apiData);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(dtos.getMessage());
		// 非正常情况
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) {
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		
		// 先删除 在新增
		entZhixingInfoService.deleteByEntName(entName);
		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}

		// 查询成功
		ResponsePageNumResultDTO<Open389ZhixinginfoDTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open389ZhixinginfoDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntZhixingInfoEntity> list = Lists.newArrayList();
		EntZhixingInfoEntity entity = null;
		for (Open389ZhixinginfoDTO item : items) {
			entity = new EntZhixingInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);

		}
		entZhixingInfoService.insertBatch(list);
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
