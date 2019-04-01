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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open439TmDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;
import xin.tianchuang.modules.spider.service.EntTmInfoService;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class TmHandler implements QueryHandler<List<Open439TmDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(TmHandler.class);

	@Autowired
	private EntTmInfoService entTmInfoService;

	@Override
	public BaseRespnseDTO<List<Open439TmDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/tm?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":\"783\",\"items\":[{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"5900469bd7013dbbd5421b6b1a883760\",\"tmName\":\"小度\",\"id\":\"28557243\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-05-23 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/63d873954f3399ee781d52b0be92ae5f.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1527004800000\",\"appDate\":\"1527004800000\",\"regNo\":\"31110384\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"8b33476b37b991fe97c302105f70f540\",\"tmName\":\"百度\",\"id\":\"28536446\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-05-22 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/4790d5abdc05226d6971aebb1d7d4c47.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1526918400000\",\"appDate\":\"1526918400000\",\"regNo\":\"31061621\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"id\":\"28382159\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/a8072983fc489c5c3aada8ad47dce091.jpg\",\"status\":\"待审\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"8573973852e7e989895567f650ea6da3\",\"eventTime\":\"1526918400000\",\"regNo\":\"31061623\",\"appDate\":\"1526918400000\",\"applicantCn\":\"北京百度网讯科技有限公司\",\"tmName\":\"百度简单搜索\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"e49e8f196ccf688439dedb5d821608e0\",\"tmName\":\"EASYDL\",\"id\":\"28856416\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-27 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/7905505466b0ea8b287b72c08e3bdc90.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524758400000\",\"appDate\":\"1524758400000\",\"regNo\":\"30579070\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"9c4389f6c90e79d34d603b30c437fe63\",\"tmName\":\"百度\",\"id\":\"28753872\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-27 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/f3b7206c416392c21ffd43871a313f4e.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524758400000\",\"appDate\":\"1524758400000\",\"regNo\":\"30550774\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"0250b9a8338c6dfb5ec286fc82c6de4a\",\"tmName\":\"点石\",\"id\":\"28738993\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-26 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/d9c83d93eab2f17f797e5f491147bff3.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524672000000\",\"appDate\":\"1524672000000\",\"regNo\":\"30537816\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"70b0035bf7b5c64f73affac1db3d1932\",\"tmName\":\"AD BAIDU AIID\",\"id\":\"28953659\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-26 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/0bbfe55439bbc6c5b7b7fbee97400490.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524672000000\",\"appDate\":\"1524672000000\",\"regNo\":\"30540987\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"78a02edc961019456f743aae5cdde9f0\",\"tmName\":\"百度智慧认证\",\"id\":\"28805283\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-26 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/be73d8a40ad221495f36c180720755d6.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524672000000\",\"appDate\":\"1524672000000\",\"regNo\":\"30536204\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"38b17d31f09162a6cd756ac06aed4efc\",\"tmName\":\"百度智慧认证\",\"id\":\"28967882\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-26 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/049e96da0a525c5763876b86e87a2d11.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524672000000\",\"appDate\":\"1524672000000\",\"regNo\":\"30536208\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"f26f1cc8ef3e06d25ae76e440c97b332\",\"tmName\":\"百度课堂\",\"id\":\"26807795\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-20 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/64946b169e9240dca1681c309c5d85d2.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1524153600000\",\"appDate\":\"1524153600000\",\"regNo\":\"30397115\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"82ae1b2a2105e3cd555a90945254ed17\",\"tmName\":\"创作大脑\",\"id\":\"28114401\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-18 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/68d4c24356a189187d41ca484d7cfa0d.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523980800000\",\"appDate\":\"1523980800000\",\"regNo\":\"30344806\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"0e1e6ede87cbfb1f82a9dac92007cf13\",\"tmName\":\"百度创作大脑\",\"id\":\"28227150\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-18 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/13e66d7992c9e009cd4d28e71005b529.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523980800000\",\"appDate\":\"1523980800000\",\"regNo\":\"30330384\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"1b5e0df4753404cdbae3b89979e7a389\",\"tmName\":\"增强现实\",\"id\":\"28099799\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/19cccba4edb080d0ca8511c790e5d39b.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30272232\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"17a13d115cf6046e7eab539d35176b09\",\"tmName\":\"百度搜索风云榜\",\"id\":\"27220466\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/1da56af6ba1238326228f9e16095258b.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30260252\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"21fe176359d94a6bf941c84540a7d4c6\",\"tmName\":\"百度增强现实\",\"id\":\"27739155\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/465805bd5290a72448e7e87d9a49212a.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30262390\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"44279bb850ac3963bb9bf27611ff2666\",\"tmName\":\"BAIDU AR AR\",\"id\":\"29002717\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/70c28ebfbf88c3124ae1c7a1c71e6029.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30261284\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"7cf0c907c3c5d911f3cbaf611f0d13b0\",\"tmName\":\"搜索风云榜\",\"id\":\"29002715\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/65a2490f2c31d1bfd599922ddf472b6c.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30275848\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"4c016f12b4d1f04d81a03f91be38c640\",\"tmName\":\"百度\",\"id\":\"27423506\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/6508194101ce13964fe6f9a5d7901e9f.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30261291\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"287e81c35267163ca0fc9e97abba6eb7\",\"tmName\":\"智能营销\",\"id\":\"29303769\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/b88d808b2cf261041235c55a29888dbb.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30276059\",\"applicantCn\":\"北京百度网讯科技有限公司\"},{\"status\":\"待审\",\"tmClass\":\"38\",\"searchType\":\"401\",\"uni\":\"ae22742deed7f06dbd0a5ca801a3e2f6\",\"tmName\":\"百度搜索风云榜\",\"id\":\"27443659\",\"_type\":\"61\",\"intCls\":\"38-电讯、通信服务\",\"tmFlow\":\"[{'cat':2726,'time':'2018-04-16 00:00:00'}]\",\"category\":\"商标注册申请---申请收文\",\"tmPic\":\"http://tm-image.tianyancha.com/tm/fadc83ec2437f88a40939c6b22b1876c.jpg\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"eventTime\":\"1523808000000\",\"appDate\":\"1523808000000\",\"regNo\":\"30260257\",\"applicantCn\":\"北京百度网讯科技有限公司\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>> dtos = gson.fromJson(apiData, jsonType);

		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open439TmDTO>> rtnDTO = new BaseRespnseDTO<List<Open439TmDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();
		BaseRespnseDTO<List<Open439TmDTO>> rtnDTO = new BaseRespnseDTO<List<Open439TmDTO>>();
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
		entTmInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open439TmDTO> data = dtos.getData();
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
		List<Open439TmDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntTmInfoEntity> tmInfoEntityList = Lists.newArrayList();
		List<String> connLs = null;
		EntTmInfoEntity entity = null;
		String connStr = null;
		for (Open439TmDTO item : items) {
			entity = new EntTmInfoEntity();
			BeanUtils.copyProperties(item, entity);

			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			connLs = item.getConnList();
			if (null != connLs && connLs.size() >= 1) {
				connStr = Joiner.on(",").join(connLs);
				entity.setConnList(connStr);
			}

			tmInfoEntityList.add(entity);
		}
		entTmInfoService.insertBatch(tmInfoEntityList);

		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
