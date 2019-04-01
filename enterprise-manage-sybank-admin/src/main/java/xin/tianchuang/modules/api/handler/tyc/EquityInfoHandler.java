package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.EntEquityPledgeeTypeEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoPledgeeListDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntEquityInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEquityPledgeeInfoEntity;

import xin.tianchuang.modules.spider.service.EntEquityInfoService;
import xin.tianchuang.modules.spider.service.EntEquityPledgeeInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class EquityInfoHandler implements QueryHandler<List<Open404EquityInfoDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(EquityInfoHandler.class);

	@Autowired
	private EntEquityInfoService entEquityInfoService;
	@Autowired
	private EntEquityPledgeeInfoService entEquityPledgeeInfoService;

	@Override
	public BaseRespnseDTO<List<Open404EquityInfoDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/equityInfo?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":2,\"items\":[{\"equityAmount\":\"5400\",\"regNumber\":\"A1600984068\",\"pledgee\":\"中信银行股份有限公司呼和浩特分行\",\"putDate\":1464019200000,\"companyList\":[{\"id\":\"211058937\",\"name\":\"中信银行股份有限公司呼和浩特分行\"}],\"pledgorStr\":\"<a href=&singlequote&https://www.tianyancha.com/human/2066606298-c236499922&singlequote& target=&singlequote&_blank&singlequote&>王凤龙</a>\",\"pledgeeList\":[{\"id\":\"211058937\",\"name\":\"中信银行股份有限公司呼和浩特分行\"}],\"regDate\":1464019200000,\"pledgorList\":[{\"name\":\"王凤龙\"}],\"state\":\"有效\",\"pledgor\":\"王凤龙\",\"certifNumberR\":\"非公示项\",\"certifNumber\":\"非公示项\",\"pledgeeStr\":\"<a href=&singlequote&http://www.tianyancha.com/company/211058937&singlequote& target=&singlequote&_blank&singlequote&>中信银行股份有限公司呼和浩特分行</a>\"},{\"equityAmount\":\"3900\",\"regNumber\":\"A1600984294\",\"pledgee\":\"中信银行股份有限公司呼和浩特分行\",\"putDate\":1464019200000,\"companyList\":[{\"id\":\"211058937\",\"name\":\"中信银行股份有限公司呼和浩特分行\"},{\"id\":\"288006849\",\"name\":\"鄂尔多斯市山湾投资有限公司\"}],\"pledgorStr\":\"<a href=&singlequote&http://www.tianyancha.com/company/288006849&singlequote& target=&singlequote&_blank&singlequote&>鄂尔多斯市山湾投资有限公司</a>\",\"pledgeeList\":[{\"id\":\"211058937\",\"name\":\"中信银行股份有限公司呼和浩特分行\"}],\"regDate\":1464019200000,\"pledgorList\":[{\"id\":\"288006849\",\"name\":\"鄂尔多斯市山湾投资有限公司\"}],\"state\":\"有效\",\"pledgor\":\"鄂尔多斯市山湾投资有限公司\",\"certifNumberR\":\"非公示项\",\"certifNumber\":\"非公示项\",\"pledgeeStr\":\"<a href=&singlequote&http://www.tianyancha.com/company/211058937&singlequote& target=&singlequote&_blank&singlequote&>中信银行股份有限公司呼和浩特分行</a>\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open404EquityInfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open404EquityInfoDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open404EquityInfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open404EquityInfoDTO>>();
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
		entEquityInfoService.deleteByEntName(entName);
		entEquityPledgeeInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open404EquityInfoDTO> data = dtos.getData();
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
		List<Open404EquityInfoDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntEquityInfoEntity> list = new ArrayList<EntEquityInfoEntity>(items.size());
		List<EntEquityPledgeeInfoEntity> entEquityPledgeeInfolist = Lists.newArrayList();
		EntEquityInfoEntity entity = null;
		List<Open404EquityInfoPledgeeListDTO> companyLs = null;
		List<Open404EquityInfoPledgeeListDTO> pledgeeLs = null;
		for (Open404EquityInfoDTO item : items) {
			entity = new EntEquityInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);

			companyLs = item.getCompanyList();
			if (null != companyLs && companyLs.size() > 0) {
				EntEquityPledgeeInfoEntity companyEntity = null;
				for (Open404EquityInfoPledgeeListDTO company : companyLs) {
					companyEntity = new EntEquityPledgeeInfoEntity();
					BeanUtils.copyProperties(company, companyEntity);
					companyEntity.setEntId(param.getEntListInfo().getId());
					companyEntity.setEntName(entName);
					companyEntity.setType(EntEquityPledgeeTypeEnum.COMPANY.key());
					companyEntity.setRegNumber(entity.getRegNumber());

					entEquityPledgeeInfolist.add(companyEntity);
				}
			}
			pledgeeLs = item.getPledgeeList();
			if (null != pledgeeLs && pledgeeLs.size() > 0) {
				EntEquityPledgeeInfoEntity pledgeeEntity = null;
				for (Open404EquityInfoPledgeeListDTO pledgee : pledgeeLs) {
					pledgeeEntity = new EntEquityPledgeeInfoEntity();
					BeanUtils.copyProperties(pledgee, pledgeeEntity);
					pledgeeEntity.setEntId(param.getEntListInfo().getId());
					pledgeeEntity.setEntName(entName);
					pledgeeEntity.setType(EntEquityPledgeeTypeEnum.PLEDGEE.key());
					pledgeeEntity.setRegNumber(entity.getRegNumber());

					entEquityPledgeeInfolist.add(pledgeeEntity);
				}
			}
			List<Open404EquityInfoPledgeeListDTO> pledgorLs = item.getPledgorList();
			if (null != pledgorLs && pledgorLs.size() > 0) {
				EntEquityPledgeeInfoEntity pledgorEntity = null;
				for (Open404EquityInfoPledgeeListDTO pledgor : pledgorLs) {
					pledgorEntity = new EntEquityPledgeeInfoEntity();
					BeanUtils.copyProperties(pledgor, pledgorEntity);
					pledgorEntity.setEntId(param.getEntListInfo().getId());
					pledgorEntity.setEntName(entName);
					pledgorEntity.setType(EntEquityPledgeeTypeEnum.PLEDGOR.key());
					pledgorEntity.setRegNumber(entity.getRegNumber());

					entEquityPledgeeInfolist.add(pledgorEntity);
				}
			}
		}
		if(entEquityPledgeeInfolist.size()>0) {
			entEquityPledgeeInfoService.insertBatch(entEquityPledgeeInfolist);
		}
		entEquityInfoService.insertBatch(list);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
