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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgageChangeInfoListDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgageInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgagePawnInfoListDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgagePeopleInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntMortgageBaseInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgageChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePeopleInfoEntity;
import xin.tianchuang.modules.spider.service.EntMortgageBaseInfoService;
import xin.tianchuang.modules.spider.service.EntMortgageChangeInfoService;
import xin.tianchuang.modules.spider.service.EntMortgagePawnInfoService;
import xin.tianchuang.modules.spider.service.EntMortgagePeopleInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class MortgageInfoHandler implements QueryHandler<List<Open421MortgageInfoDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(MortgageInfoHandler.class);

	@Autowired
	private EntMortgageBaseInfoService entMortgageBaseInfoService;
	@Autowired
	private EntMortgagePeopleInfoService entMortgagePeopleInfoService;
	@Autowired
	private EntMortgagePawnInfoService entMortgagePawnInfoService;
	@Autowired
	private EntMortgageChangeInfoService entMortgageChangeInfoService;

	@Override
	public BaseRespnseDTO<List<Open421MortgageInfoDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/mortgageInfo?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":2,\"items\":[{\"baseInfo\":{\"overviewAmount\":\"350万元人民币元\",\"scope\":\"抵押担保\",\"status\":\"有效\",\"remark\":\"\",\"regDate\":\"2017-04-27\",\"overviewType\":\"借款合同\",\"type\":\"借款合同\",\"cancelReason\":\"\",\"overviewScope\":\"抵押担保\",\"id\":9896676,\"amount\":\"350万元人民币元\",\"overviewRemark\":\"\",\"overviewTerm\":\"2017年04月27日至2018年04月26日\",\"regDepartment\":\"融水苗族自治县市场监督管理局\",\"regNum\":\"融工商抵登字[2017]31号\",\"term\":\"2017年04月27日至2018年04月26日\",\"base\":\"gx\",\"cancelDate\":1498752000000,\"publishDate\":1498752000000},\"changeInfoList\":[{\"changeDate\":1461600000000,\"changeContent\":\"原借款合同编号234803150906681变更为：234803160529541.\"}],\"pawnInfoList\":[{\"detail\":\"28台套、良好、老莱镇丰盛村\",\"ownership\":\"讷河市丰盛现代农业农机专业合作社\",\"pawnName\":\"农机具\",\"remark\":\"\"}],\"peopleInfo\":[{\"licenseNum\":\"非公示项\",\"peopleName\":\"讷河市农村信用合作联社\",\"liceseType\":\"其他\"}]}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open421MortgageInfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open421MortgageInfoDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open421MortgageInfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open421MortgageInfoDTO>>();
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
		entMortgageBaseInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open421MortgageInfoDTO> data = dtos.getData();
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
		List<Open421MortgageInfoDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntMortgageBaseInfoEntity> list = new ArrayList<EntMortgageBaseInfoEntity>(items.size());
		List<EntMortgageChangeInfoEntity> mortgageChangeInfoEntityList = Lists.newArrayList();
		List<EntMortgagePawnInfoEntity> mortgagePawnInfoEntityList = Lists.newArrayList();
		List<EntMortgagePeopleInfoEntity> mortgagePeopleInfoList = Lists.newArrayList();
		EntMortgageBaseInfoEntity entity = null;
		List<Open421MortgageChangeInfoListDTO> changeInfoList = null;
		List<Open421MortgagePawnInfoListDTO> pawnInfoList = null;
		List<Open421MortgagePeopleInfoDTO> peopleInfo = null;
		for (Open421MortgageInfoDTO item : items) {
			// 基本信息
			entity = new EntMortgageBaseInfoEntity();
			BeanUtils.copyProperties(item.getBaseInfo(), entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);
			// 变更信息
			changeInfoList = item.getChangeInfoList();
			if (null != changeInfoList && changeInfoList.size() > 0) {
				entMortgageChangeInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
				EntMortgageChangeInfoEntity changeInfoEntity = null;
				for (Open421MortgageChangeInfoListDTO changeInfo : changeInfoList) {
					changeInfoEntity = new EntMortgageChangeInfoEntity();
					BeanUtils.copyProperties(changeInfo, changeInfoEntity);
					changeInfoEntity.setEntId(param.getEntListInfo().getId());
					changeInfoEntity.setEntName(entName);
					changeInfoEntity.setCreditCode(param.getEntListInfo().getCreditCode());
					changeInfoEntity.setRegNum(entity.getRegNum());
					mortgageChangeInfoEntityList.add(changeInfoEntity);
				}
			}
			// 资产信息
			pawnInfoList = item.getPawnInfoList();
			if (null != pawnInfoList && pawnInfoList.size() > 0) {
				entMortgagePawnInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
				EntMortgagePawnInfoEntity pawnEntity = null;
				for (Open421MortgagePawnInfoListDTO pawn : pawnInfoList) {
					pawnEntity = new EntMortgagePawnInfoEntity();
					BeanUtils.copyProperties(pawn, pawnEntity);
					pawnEntity.setEntId(param.getEntListInfo().getId());
					pawnEntity.setEntName(entName);
					pawnEntity.setCreditCode(param.getEntListInfo().getCreditCode());
					pawnEntity.setRegNum(entity.getRegNum());
					mortgagePawnInfoEntityList.add(pawnEntity);
				}
			}
			// 抵押信息
			peopleInfo = item.getPeopleInfo();
			if (null != peopleInfo && peopleInfo.size() > 0) {
				entMortgagePeopleInfoService.deleteByEntNameAndRegNum(entName, entity.getRegNum());
				EntMortgagePeopleInfoEntity peopleEntity = null;
				for (Open421MortgagePeopleInfoDTO people : peopleInfo) {
					peopleEntity = new EntMortgagePeopleInfoEntity();
					BeanUtils.copyProperties(people, peopleEntity);
					peopleEntity.setEntId(param.getEntListInfo().getId());
					peopleEntity.setEntName(entName);
					peopleEntity.setCreditCode(param.getEntListInfo().getCreditCode());
					peopleEntity.setRegNum(entity.getRegNum());
					mortgagePeopleInfoList.add(peopleEntity);
				}
			}
		}
		if (mortgageChangeInfoEntityList.size() > 0) {
			entMortgageChangeInfoService.insertBatch(mortgageChangeInfoEntityList);
		}
		if (mortgagePawnInfoEntityList.size() > 0) {
			entMortgagePawnInfoService.insertBatch(mortgagePawnInfoEntityList);
		}
		if (mortgagePeopleInfoList.size() > 0) {
			entMortgagePeopleInfoService.insertBatch(mortgagePeopleInfoList);
		}
		entMortgageBaseInfoService.insertBatch(list);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
