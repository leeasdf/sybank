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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2StaffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestStaffEntity;

import xin.tianchuang.modules.spider.service.EntDishonestInfoService;
import xin.tianchuang.modules.spider.service.EntDishonestStaffService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class DishonestV2Handler implements QueryHandler<List<Open777DishonestV2DTO>> {

	private static final Logger logger = LoggerFactory.getLogger(DishonestV2Handler.class);

	@Autowired
	private EntDishonestInfoService entDishonestInfoService;
	@Autowired
	private EntDishonestStaffService entDishonestStaffService;

	@Override
	public BaseRespnseDTO<List<Open777DishonestV2DTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/dishonestV2?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":4,\"items\":[{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":[{\"role\":\"法定代表人\",\"code\":\"P799339(4)\",\"name\":\"徐永清\"}],\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2018)津0103执1265号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1519920000000,\"publishdate\":1532275200000,\"duty\":\"给付申请人10217元\",\"gistunit\":\"天津市仲裁委员会\",\"id\":13395182,\"gistid\":\"【2017】津仲裁字第0330号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":\"[]\",\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2017)津0103执1606号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1491321600000,\"publishdate\":1501171200000,\"duty\":\"一、被执行人退还申请执行人购房款23515元及加倍支付迟延履行期间的债务利息681元；\r\n二、交付申请执行人案件受理费2226元、公告费1000元。\",\"gistunit\":\"天津仲裁委员会\",\"id\":10406580,\"gistid\":\"2016津仲裁字第47号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\" \",\"staff\":\"[]\",\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\" \",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务的\",\"casecode\":\"(2016)津0103执4676号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1483027200000,\"publishdate\":1493222400000,\"duty\":\"一、被告于2014年12月31日前返还原告借款200000元，于2015年12月31日前返还原告剩余借款400000元；\n二、案件受理费9800元，减半收取后为4900元，由原、被告各自承担2450元\",\"gistunit\":\"天津市河西区人民法院\",\"id\":8621591,\"gistid\":\"(2014)西民一初字第751号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":\"[]\",\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2013)西法执字第01218号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1372262400000,\"publishdate\":1381248000000,\"duty\":\"一、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司工程款1800000元。\n二、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司滞纳金449800元（从2011年6月31日起至2013年1月30日止）及从2013年2月1日开始实际给付工程款1800000元之日止的滞纳金，每延期一日按万分之五计算\n案件受理费24798元由被告天津信裕房地产发展有限公司负担\",\"gistunit\":\"河西法院\",\"id\":9253950,\"gistid\":\"(2013)西民二初字224号\"}]},\"seqNum\":\"372d303671ed4cafa3db364b49f4946d\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
		// String apiData =
		// "{\"data\":{\"total\":4,\"items\":[{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":[{\"role\":\"法定代表人\",\"code\":\"P799339(4)\",\"name\":\"徐永清\"}],\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2018)津0103执1265号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1519920000000,\"publishdate\":1532275200000,\"gistunit\":\"天津市仲裁委员会\",\"duty\":\"给付申请人10217元\",\"id\":13395182,\"gistid\":\"【2017】津仲裁字第0330号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":[],\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2017)津0103执1606号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1491321600000,\"publishdate\":1501171200000,\"gistunit\":\"天津仲裁委员会\",\"duty\":\"一、被执行人退还申请执行人购房款23515元及加倍支付迟延履行期间的债务利息681元；\r\n二、交付申请执行人案件受理费2226元、公告费1000元。\",\"id\":10406580,\"gistid\":\"2016津仲裁字第47号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\" \",\"staff\":[],\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\" \",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务的\",\"casecode\":\"(2016)津0103执4676号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1483027200000,\"publishdate\":1493222400000,\"gistunit\":\"天津市河西区人民法院\",\"duty\":\"一、被告于2014年12月31日前返还原告借款200000元，于2015年12月31日前返还原告剩余借款400000元；\n二、案件受理费9800元，减半收取后为4900元，由原、被告各自承担2450元\",\"id\":8621591,\"gistid\":\"(2014)西民一初字第751号\"},{\"businessentity\":\"徐永清\",\"areaname\":\"天津\",\"courtname\":\"天津市河西区人民法院\",\"unperformPart\":\"\",\"staff\":[],\"cpwsUrl\":\"\",\"type\":\"1\",\"performedPart\":\"\",\"iname\":\"天津信裕房地产发展有限公司\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务\",\"casecode\":\"(2013)西法执字第01218号\",\"cardnum\":\"60056316-5\",\"performance\":\"全部未履行\",\"regdate\":1372262400000,\"publishdate\":1381248000000,\"gistunit\":\"河西法院\",\"duty\":\"一、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司工程款1800000元。\n二、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司滞纳金449800元（从2011年6月31日起至2013年1月30日止）及从2013年2月1日开始实际给付工程款1800000元之日止的滞纳金，每延期一日按万分之五计算\n案件受理费24798元由被告天津信裕房地产发展有限公司负担\",\"id\":9253950,\"gistid\":\"(2013)西民二初字224号\"}]},\"seqNum\":\"a2070e518f0640f4b18b2ed51499f2b6\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
		// String apiData =
		// "{\"data\":{\"total\":4,\"items\":[{\"iname\":\"天津信裕房地产发展有限公司\",\"businessentity\":\"徐永清\",\"gistid\":\"【2017】津仲裁字第0330号\",\"areaname\":\"天津\",\"cardnum\":\"60056316-5\",\"courtname\":\"天津市河西区人民法院\",\"type\":\"1\",\"publishdate\":1532275200000,\"performedPart\":\"\",\"staff\":\"['P799339(4)@@法定代表人@@徐永清']\",\"gistunit\":\"天津市仲裁委员会\",\"unperformPart\":\"\",\"duty\":\"给付申请人10217元\",\"performance\":\"全部未履行\",\"regdate\":1519920000000,\"casecode\":\"(2018)津0103执1265号\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\"},{\"iname\":\"天津信裕房地产发展有限公司\",\"businessentity\":\"徐永清\",\"gistid\":\"2016津仲裁字第47号\",\"areaname\":\"天津\",\"cardnum\":\"60056316-5\",\"courtname\":\"天津市河西区人民法院\",\"type\":\"1\",\"publishdate\":1501171200000,\"performedPart\":\"\",\"staff\":\"[]\",\"gistunit\":\"天津仲裁委员会\",\"unperformPart\":\"\",\"duty\":\"一、被执行人退还申请执行人购房款23515元及加倍支付迟延履行期间的债务利息681元；\r\n二、交付申请执行人案件受理费2226元、公告费1000元。\",\"performance\":\"全部未履行\",\"regdate\":1491321600000,\"casecode\":\"(2017)津0103执1606号\",\"disrupttypename\":\"有履行能力而拒不履行生效法律文书确定义务\"},{\"iname\":\"天津信裕房地产发展有限公司\",\"businessentity\":\"徐永清\",\"gistid\":\"(2014)西民一初字第751号\",\"areaname\":\"天津\",\"cardnum\":\"60056316-5\",\"courtname\":\"天津市河西区人民法院\",\"type\":\"1\",\"publishdate\":1493222400000,\"performedPart\":\" \",\"staff\":\"[]\",\"gistunit\":\"天津市河西区人民法院\",\"unperformPart\":\" \",\"duty\":\"一、被告于2014年12月31日前返还原告借款200000元，于2015年12月31日前返还原告剩余借款400000元；\n二、案件受理费9800元，减半收取后为4900元，由原、被告各自承担2450元\",\"performance\":\"全部未履行\",\"regdate\":1483027200000,\"casecode\":\"(2016)津0103执4676号\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务的\"},{\"iname\":\"天津信裕房地产发展有限公司\",\"businessentity\":\"徐永清\",\"gistid\":\"(2013)西民二初字224号\",\"areaname\":\"天津\",\"cardnum\":\"60056316-5\",\"courtname\":\"天津市河西区人民法院\",\"type\":\"1\",\"publishdate\":1381248000000,\"performedPart\":\"\",\"staff\":\"[]\",\"gistunit\":\"河西法院\",\"unperformPart\":\"\",\"duty\":\"一、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司工程款1800000元。\n二、被告天津信裕房地产发展有限公司于本判决生效之日起十日内支付原告天津和平建工集团有限公司滞纳金449800元（从2011年6月31日起至2013年1月30日止）及从2013年2月1日开始实际给付工程款1800000元之日止的滞纳金，每延期一日按万分之五计算\n案件受理费24798元由被告天津信裕房地产发展有限公司负担\",\"performance\":\"全部未履行\",\"regdate\":1372262400000,\"casecode\":\"(2013)西法执字第01218号\",\"disrupttypename\":\"其他有履行能力而拒不履行生效法律文书确定义务\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>> dtos = gson.fromJson(apiData.replace("\"staff\":\"[]\"", "\"staff\":[]"), jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open777DishonestV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open777DishonestV2DTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String entName = param.getName();

		BaseRespnseDTO<List<Open777DishonestV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open777DishonestV2DTO>>();
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
		entDishonestInfoService.deleteByEntName(entName);
		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 查询成功
		ResponsePageNumResultDTO<Open777DishonestV2DTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open777DishonestV2DTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}
	
		List<EntDishonestInfoEntity> list = new ArrayList<EntDishonestInfoEntity>(items.size());
		List<EntDishonestStaffEntity> dishonestStafflist = Lists.newArrayList();
		EntDishonestInfoEntity entity = null;
		for (Open777DishonestV2DTO item : items) {
			entity = new EntDishonestInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);

			List<Open777DishonestV2StaffDTO> staffLs = item.getStaff();
			if (null != staffLs && staffLs.size() > 0) {
				String caseCode=entity.getCasecode();
				entDishonestStaffService.deleteByEntNameAndCasecode(entName,caseCode);
				for (Open777DishonestV2StaffDTO staff : staffLs) {
					EntDishonestStaffEntity entDishonestStaffEntity = new EntDishonestStaffEntity();
					BeanUtils.copyProperties(staff, entDishonestStaffEntity);
					entDishonestStaffEntity.setEntId(param.getEntListInfo().getId());
					entDishonestStaffEntity.setEntName(entName);
					entDishonestStaffEntity.setCreditCode(param.getEntListInfo().getCreditCode());
					entDishonestStaffEntity.setCasecode(caseCode);
					dishonestStafflist.add(entDishonestStaffEntity);
				}
			}
		}
		if(dishonestStafflist.size()>0) {
			entDishonestStaffService.insertBatch(dishonestStafflist);
		}
		entDishonestInfoService.insertBatch(list);
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
