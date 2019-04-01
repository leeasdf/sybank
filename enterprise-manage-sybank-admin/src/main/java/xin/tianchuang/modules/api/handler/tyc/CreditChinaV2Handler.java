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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open767CreditChinaV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntPunishCreditChinaEntity;
import xin.tianchuang.modules.spider.service.EntPunishCreditChinaService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class CreditChinaV2Handler implements QueryHandler<List<Open767CreditChinaV2DTO>> {

	private static final Logger logger = LoggerFactory.getLogger(CreditChinaV2Handler.class);

	@Autowired
	private EntPunishCreditChinaService entPunishCreditChinaService;

	@Override
	public BaseRespnseDTO<List<Open767CreditChinaV2DTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/creditChinaV2?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":9,\"items\":[{\"result\":\"1.没收广告费用142393.15元        2.罚款427179.45元\",\"areaName\":\"北京市\",\"punishNumber\":\"京工商海处字【2018】第1583号\",\"reason\":\"广告经营者、广告发布者明知或者应知未经审查，广告主擅自发布医疗、药品、医疗器械、农药、兽药和保健食品广告，以及法律、行政法规规定应当进行审查的其他广告，仍设计、制作、代理、发布的进行处罚\",\"typeSecond\":\"没收非法所得\",\"evidence\":\"依据《中华人民共和国广告法》第五十八条第三款的规定\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-08-17\",\"type\":\"罚款\",\"departmentName\":\"北京市工商行政管理局海淀分局\",\"punishName\":\"北京百度网讯科技有限公司\"},{\"result\":\"罚款30000元。\",\"areaName\":\"北京市\",\"punishNumber\":\"(京)文执罚〔2018〕第40213号\",\"reason\":\"未经批准，擅自从事网络出版服务\",\"typeSecond\":\"\",\"evidence\":\"《网络出版服务管理规定》\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-05-28\",\"type\":\"罚款\",\"departmentName\":\"北京市文化市场行政执法总队\",\"punishName\":\"北京百度网讯科技有限公司未经批准，擅自从事网络出版服务案\"},{\"result\":\"罚款30000元。\",\"areaName\":\"北京市\",\"punishNumber\":\"(京)文执罚【2018】第40219号\",\"reason\":\"经营性互联网文化单位提供含有禁止内容的互联网文化产品\",\"typeSecond\":\"\",\"evidence\":\"《互联网文化管理暂行规定》\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-04-24\",\"type\":\"罚款\",\"departmentName\":\"北京市文化市场行政执法总队\",\"punishName\":\"北京百度网讯科技有限公司 经营性互联网文化单位提供含有禁止内容的互联网文化产品案\"},{\"result\":\"警告。\",\"areaName\":\"北京市\",\"punishNumber\":\"(京海)食药监食罚〔2018〕270256号\",\"reason\":\"《网络餐饮服务食品安全监督管理办法》第九条\",\"typeSecond\":\"\",\"evidence\":\"《网络餐饮服务食品安全监督管理办法》第三十二条\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-04-20\",\"type\":\"其他（见处罚类别2）\",\"departmentName\":\"海淀局\",\"punishName\":\"北京百度网讯科技有限公司涉嫌未按要求进行信息公示案\"},{\"result\":\"罚款16539元。\",\"areaName\":\"北京市\",\"punishNumber\":\"京工商海处字〔2018〕第302号\",\"reason\":\"食品广告出现与药品相混淆的用语，直接或者间接地宣传治疗作用，借助宣传某些成分的作用明示或者暗示该食品的治疗作用\",\"typeSecond\":\"其他\",\"evidence\":\"依据《食品广告发布暂行规定\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-03-19\",\"type\":\"罚款\",\"departmentName\":\"北京市工商行政管理局海淀分局\",\"punishName\":\"北京百度网讯科技有限公司\"},{\"result\":\"1、没收广告费用3218.18元；        2、罚款3218.18元。\",\"areaName\":\"北京市\",\"punishNumber\":\"京工商海处字〔2018〕第303号\",\"reason\":\"广告主发布含有对未来效果、收益或者与其相关的情况作出保证性承诺，明示或者暗示保本、无风险或者保收益等内容的招商等有投资回报预期的商品或者服务广告\",\"typeSecond\":\"没收非法所得\",\"evidence\":\"依据《中华人民共和国广告法》第五十八条第一款第（七）项和第三款的规定\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-03-19\",\"type\":\"罚款\",\"departmentName\":\"北京市工商行政管理局海淀分局\",\"punishName\":\"北京百度网讯科技有限公司\"},{\"result\":\"予以警告。\",\"areaName\":\"北京市\",\"punishNumber\":\"京工商海青龙当处字〔2018〕第1号\",\"reason\":\"第三方交易平台经营者未对申请进入平台销售商品或者提供服务的法人、其他经济组织或者个体工商户的经营主体身份进行审查和登记，建立登记档案并定期核实更新，在其从事经营活动的主页面醒目位置公开营业执照登载的信息或者其营业执照的电子链接标识\",\"typeSecond\":\"其他\",\"evidence\":\"《网络交易管理办法》第五十条：“违反本办法第七条第二款、第二十三条、第二十五条、第二十六条第二款、第二十九条、第三十条、第三十四条、第三十五条、第三十六条、第三十八条规定的，予以警告，责令改正，拒不改正的，处以一万元以上三万元以下的罚款。”\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-02-11\",\"type\":\"其他（见处罚类别2）\",\"departmentName\":\"北京市工商行政管理局海淀分局\",\"punishName\":\"北京百度网讯科技有限公司\"},{\"result\":\"警告；罚款28000元。\",\"areaName\":\"北京市\",\"punishNumber\":\"(京)文执罚【2018】第40002号\",\"reason\":\"传播的视听节目含禁止内容\",\"typeSecond\":\"\",\"evidence\":\"《互联网视听节目服务管理规定》\",\"punishStatus\":\"0\",\"decisionDate\":\"2018-02-05\",\"type\":\"警告\",\"departmentName\":\"北京市文化市场行政执法总队\",\"punishName\":\"北京百度网讯科技有限公司传播的视听节目含禁止内容案\"},{\"result\":\"处1万元罚款\",\"areaName\":\"北京市\",\"punishNumber\":\"未经备案网站提供互联网接入服务\",\"reason\":\"'《非经营性互联网信息服务备案管理办法》第十八条： \n互联网接入服务提供者不得为未经备案的组织或者个人从事非经营性互联网信息服务提供互联网接入服务。对被省通信管理局处以暂时关闭网站或关闭网站处罚的非经营性互联网信息服务提供者或者非法从事非经营性互联网信息服务的组织或者个人，互联网接入服务提供者应立即暂停或终止向其提供互联网接入服务。\n'\",\"typeSecond\":\"\",\"evidence\":\"《非经营性互联网信息服务备案管理办法》第二十四条：违反本办法第十条、第十八条、第十九条的规定的，由违法行为发生地省通信管理局责令改正，并处一万元罚款。\",\"punishStatus\":\"0\",\"decisionDate\":\"2017-07-27\",\"type\":\"罚款\",\"departmentName\":\"北京市通信管理局\",\"punishName\":\"罚款\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open767CreditChinaV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open767CreditChinaV2DTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();
		BaseRespnseDTO<List<Open767CreditChinaV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open767CreditChinaV2DTO>>();
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
		entPunishCreditChinaService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open767CreditChinaV2DTO> data = dtos.getData();
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
		List<Open767CreditChinaV2DTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntPunishCreditChinaEntity> list = Lists.newArrayList();
		EntPunishCreditChinaEntity entity = null;
		for (Open767CreditChinaV2DTO item : items) {
			entity = new EntPunishCreditChinaEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(entity);

		}
		entPunishCreditChinaService.insertBatch(list);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
