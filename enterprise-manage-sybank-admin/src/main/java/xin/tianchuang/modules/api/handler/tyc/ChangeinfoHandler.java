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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntChangeInfoEntity;

import xin.tianchuang.modules.spider.service.EntChangeInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class ChangeinfoHandler implements QueryHandler<List<Open370ChangeinfoDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(ChangeinfoHandler.class);

	@Autowired
	private EntChangeInfoService entChangeInfoService;

	@Override
	public BaseRespnseDTO<List<Open370ChangeinfoDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/changeinfo?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":18,\"items\":[{\"changeItem\":\"注册资本\",\"createTime\":\"2017-10-27\",\"contentBefore\":\"8<em>9000</em>万元\",\"contentAfter\":\"<em>21712</em>8万元\",\"changeTime\":\"2017-09-07\"},{\"changeItem\":\"经营范围\",\"createTime\":\"2017-10-27\",\"contentBefore\":\"因特信息服务业务（除出版、教育、医疗保健以外的内容）；第一类增值电信业务中的在线数据处理与交易处理业务、国内因特网虚拟专用网业务、因特网数据中心业务；第二类增值电信业务中的因特网接入服务业务、呼叫中心业务、信息服务业务（不含固定网电话信息服务和互联网信息服务）；图书、电子出版物、音像制品批发、零售、网上销售；利用信息网络经营音乐娱乐产品，游戏产品，演出剧（节）目、表演，动漫产品（文化经营许可证有效期至2020年04月17日）。技术服务、技术培训、技术推广；设计、开发、销售计算机软件；经济信息咨询；利用www.baidu.com、www.hao123.com(www.hao222.net、www.hao222.com)<em>、</em>网站发布广告；设计、制作、代理、发布广告；货物进出口、技术进出口、代理进出口；医疗软件技术开发；委托生产电子产品、玩具、照相器材；销售家用电器、机械设备、五金交电、电子产品、文化用品、照相器材、计算机、软件及辅助设备、化妆品、卫生用品、体育用品、纺织品、服装、鞋帽、日用品、家具、首饰、避孕器具、工艺品、钟表、眼镜、玩具、汽车及摩托车配件、仪器仪表、塑料制品、花、草及观赏植物、建筑材料、通讯设备；预防保健咨询；公园门票、文艺演出、体育赛事、展览会票务代理。企业依法自主选择经营项目，开展经营活动；<em>利用信息网络经营音乐娱乐产品，游戏产品，</em>演出<em>剧（节）目、表演，动漫产品</em>以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。\",\"contentAfter\":\"因特<em>网</em>信息服务业务（除出版、教育、医疗保健以外的内容）；第一类增值电信业务中的在线数据处理与交易处理业务、国内因特网虚拟专用网业务、因特网数据中心业务；第二类增值电信业务中的因特网接入服务业务、呼叫中心业务、信息服务业务（不含固定网电话信息服务和互联网信息服务）；图书、电子出版物、音像制品批发、零售、网上销售；利用信息网络经营音乐娱乐产品，游戏产品，演出剧（节）目、表演，动漫产品（文化经营许可证有效期至2020年04月17日）<em>；演出经纪</em>。技术服务、技术培训、技术推广；设计、开发、销售计算机软件；经济信息咨询；利用www.baidu.com、www.hao123.com(www.hao222.net、www.hao222.com)网站发布广告；设计、制作、代理、发布广告；货物进出口、技术进出口、代理进出口；医疗软件技术开发；委托生产电子产品、玩具、照相器材；销售家用电器、机械设备、五金交电、电子产品、文化用品、照相器材、计算机、软件及辅助设备、化妆品、卫生用品、体育用品、纺织品、服装、鞋帽、日用品、家具、首饰、避孕器具、工艺品、钟表、眼镜、玩具、汽车及摩托车配件、仪器仪表、塑料制品、花、草及观赏植物、建筑材料、通讯设备；预防保健咨询；公园门票、文艺演出、体育赛事、展览会票务代理。企业依法自主选择经营项目，开展经营活动；演出<em>经纪</em>以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。\",\"changeTime\":\"2017-09-07\"},{\"changeItem\":\"经营范围\",\"createTime\":\"2017-07-10\",\"contentBefore\":\"因特信息服务业务（除出版、教育、医疗保健以外的内容）；第一类增值电信业务中的在线数据处理与交易处理业务、国内因特网虚拟专用网业务、因特网数据中心业务；第二类增值电信业务中的因特网接入服务业务、呼叫中心业务、信息服务业务（不含固定网电话信息服务和互联网信息服务）；利用<em>互联</em>网经营音乐娱乐产品，游戏产品<em>运营，网络游戏虚拟货币发行，美术品</em>，演出剧（节）目，动漫<em>（画）</em>产品<em>，从事互联网文化产品展览、比赛活动</em>（<em>网络</em>文化经营许可证有效期至20<em>16</em>年<em>11</em>月<em>2</em>1日）<em>；图书</em>、<em>电子出版物</em>、<em>音像制品批发、零售、网上销售</em>；设计、开发、销售计算机软件<em>；技术服务、技术培训、技术推广</em>；经济信息咨询；利用www.baidu.com、www.hao123.com(www.hao222.net、www.hao222.com)、网站发布广告；设计、制作、代理、发布广告；货物进出口、技术进出口、代理进出口；医疗软件技术开发；委托生产电子产品、玩具、照相器材；销售家用电器、机械设备、五金交电、电子产品、文化用品、照相器材、计算机、软件及辅助设备、化妆品、卫生用品、体育用品、纺织品、服装、鞋帽、日用品、家具、首饰、避孕器具、工艺品、钟表、眼镜、玩具、汽车及摩托车配件、仪器仪表、塑料制品、花、草及观赏植物、建筑材料、通讯设备；预防保健咨询；公园门票、文艺演出、体育赛事、展览会票务代理。企业依法自主选择经营项目，开展经营活动；<em>增值电</em>信<em>业务</em>以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。\",\"contentAfter\":\"因特信息服务业务（除出版、教育、医疗保健以外的内容）；第一类增值电信业务中的在线数据处理与交易处理业务、国内因特网虚拟专用网业务、因特网数据中心业务；第二类增值电信业务中的因特网接入服务业务、呼叫中心业务、信息服务业务（不含固定网电话信息服务和互联网信息服务）；<em>图书、电子出版物、音像制品批发、零售、网上销售；</em>利用<em>信息</em>网<em>络</em>经营音乐娱乐产品，游戏产品，演出剧（节）目<em>、表演</em>，动漫产品（文化经营许可证有效期至20<em>20</em>年<em>04</em>月1<em>7</em>日）<em>。技术服务</em>、<em>技术培训</em>、<em>技术推广</em>；设计、开发、销售计算机软件；经济信息咨询；利用www.baidu.com、www.hao123.com(www.hao222.net、www.hao222.com)、网站发布广告；设计、制作、代理、发布广告；货物进出口、技术进出口、代理进出口；医疗软件技术开发；委托生产电子产品、玩具、照相器材；销售家用电器、机械设备、五金交电、电子产品、文化用品、照相器材、计算机、软件及辅助设备、化妆品、卫生用品、体育用品、纺织品、服装、鞋帽、日用品、家具、首饰、避孕器具、工艺品、钟表、眼镜、玩具、汽车及摩托车配件、仪器仪表、塑料制品、花、草及观赏植物、建筑材料、通讯设备；预防保健咨询；公园门票、文艺演出、体育赛事、展览会票务代理。企业依法自主选择经营项目，开展经营活动；<em>利用</em>信<em>息网络经营音乐娱乐产品，游戏产品，演出剧（节）目、表演，动漫产品</em>以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。\",\"changeTime\":\"2017-07-04\"},{\"changeItem\":\"投资人\",\"createTime\":\"2017-07-10\",\"contentBefore\":\"1 李彦宏 自然人股东2 <em>王湛</em> 自然人股东\",\"contentAfter\":\"1 李彦宏 自然人股东2 <em>向海龙</em> 自然人股东\",\"changeTime\":\"2017-07-04\"},{\"changeItem\":\"董事（理事）、经理、监事\",\"createTime\":\"2017-07-10\",\"contentBefore\":\"（注：标有*标志的为法定代表人）1 李彦宏 执行董事2 梁志祥* <em>总</em>经理3 <em>王湛</em> 监事\",\"contentAfter\":\"（注：标有*标志的为法定代表人）1 李彦宏 执行董事2 梁志祥* 经理3 <em>向海龙</em> 监事\",\"changeTime\":\"2017-07-04\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open370ChangeinfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open370ChangeinfoDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open370ChangeinfoDTO>> rtnDTO = new BaseRespnseDTO<List<Open370ChangeinfoDTO>>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(message);
		rtnDTO.setRespStr(apiData);
		// 如果查询不成功或者结果是成功无数据，那么直接返回查询失败
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) { // 非正常情况
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		String entName = param.getName();
		
		// 先删除 在新增
		entChangeInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open370ChangeinfoDTO> data = dtos.getData();
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
		// 更新状态

		List<Open370ChangeinfoDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntChangeInfoEntity> list = Lists.newArrayList();
		EntChangeInfoEntity entity = null;
		for (Open370ChangeinfoDTO item : items) {
			entity = new EntChangeInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			list.add(entity);
		}
		entChangeInfoService.insertBatch(list);

		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;

	}
}
