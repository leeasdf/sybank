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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open733CopyRegWorksDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntCopyRegWorksEntity;

import xin.tianchuang.modules.spider.service.EntCopyRegWorksService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class CopyRegWorksHandler implements QueryHandler<List<Open733CopyRegWorksDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(CopyRegWorksHandler.class);

	@Autowired
	private EntCopyRegWorksService entCopyRegWorksService;

	@Override
	public BaseRespnseDTO<List<Open733CopyRegWorksDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/copyRegWorks?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":539,\"items\":[{\"createTime\":1505774606000,\"regtime\":\"2012-12-13\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-12-09\",\"regnum\":\"京作登字-2012-F-00339041\",\"finishTime\":\"2011-10-22\",\"type\":\"美术\",\"fullname\":\"hao123形象标识\"},{\"createTime\":1506117379000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-02\",\"regnum\":\"京作登字-2013-A-00014065\",\"finishTime\":\"2011-04-02\",\"type\":\"文字\",\"fullname\":\"百度旅游-阿勒泰\"},{\"createTime\":1506117383000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-28\",\"regnum\":\"京作登字-2013-A-00014066\",\"finishTime\":\"2011-03-28\",\"type\":\"文字\",\"fullname\":\"百度旅游-安顺\"},{\"createTime\":1506117386000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-21\",\"regnum\":\"京作登字-2013-A-00014067\",\"finishTime\":\"2011-04-21\",\"type\":\"文字\",\"fullname\":\"百度旅游-巴厘岛\"},{\"createTime\":1506117389000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-27\",\"regnum\":\"京作登字-2013-A-00014075\",\"finishTime\":\"2011-04-27\",\"type\":\"文字\",\"fullname\":\"百度旅游-大阪\"},{\"createTime\":1506117392000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-17\",\"regnum\":\"京作登字-2013-A-00014068\",\"finishTime\":\"2011-04-17\",\"type\":\"文字\",\"fullname\":\"百度旅游-巴黎\"},{\"createTime\":1506117396000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014069\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-包头\"},{\"createTime\":1506117399000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-16\",\"regnum\":\"京作登字-2013-A-00014070\",\"finishTime\":\"2011-04-16\",\"type\":\"文字\",\"fullname\":\"百度旅游-北海道\"},{\"createTime\":1506117402000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-22\",\"regnum\":\"京作登字-2013-A-00014071\",\"finishTime\":\"2011-03-22\",\"type\":\"文字\",\"fullname\":\"百度旅游-北京\"},{\"createTime\":1506117406000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-30\",\"regnum\":\"京作登字-2013-A-00014072\",\"finishTime\":\"2011-03-30\",\"type\":\"文字\",\"fullname\":\"百度旅游-成都\"},{\"createTime\":1506117409000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014073\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-承德\"},{\"createTime\":1506117424000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014074\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-赤峰\"},{\"createTime\":1506118030000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-22\",\"regnum\":\"京作登字-2013-A-00014076\",\"finishTime\":\"2011-03-22\",\"type\":\"文字\",\"fullname\":\"百度旅游-大连\"},{\"createTime\":1506118033000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014077\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-大同\"},{\"createTime\":1506118037000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-06\",\"regnum\":\"京作登字-2013-A-00014078\",\"finishTime\":\"2011-04-06\",\"type\":\"文字\",\"fullname\":\"百度旅游-丹东\"},{\"createTime\":1506118040000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-30\",\"regnum\":\"京作登字-2013-A-00014079\",\"finishTime\":\"2011-03-30\",\"type\":\"文字\",\"fullname\":\"百度旅游-东莞\"},{\"createTime\":1506118043000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-08\",\"regnum\":\"京作登字-2013-A-00014080\",\"finishTime\":\"2011-04-08\",\"type\":\"文字\",\"fullname\":\"百度旅游-东京\"},{\"createTime\":1506118047000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-04-06\",\"regnum\":\"京作登字-2013-A-00014081\",\"finishTime\":\"2011-04-06\",\"type\":\"文字\",\"fullname\":\"百度旅游-敦煌\"},{\"createTime\":1506118050000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014082\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-鄂尔多斯\"},{\"createTime\":1506118053000,\"regtime\":\"2013-01-30\",\"authorNationality\":\"北京百度网讯科技有限公司\",\"publishtime\":\"2011-03-29\",\"regnum\":\"京作登字-2013-A-00014083\",\"finishTime\":\"2011-03-29\",\"type\":\"文字\",\"fullname\":\"百度旅游-恩施\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open733CopyRegWorksDTO>> rtnDTO = new BaseRespnseDTO<List<Open733CopyRegWorksDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open733CopyRegWorksDTO>> rtnDTO = new BaseRespnseDTO<List<Open733CopyRegWorksDTO>>();
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
		entCopyRegWorksService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open733CopyRegWorksDTO> data = dtos.getData();
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
		List<Open733CopyRegWorksDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntCopyRegWorksEntity> copyRegWorksEntityList = Lists.newArrayList();
		EntCopyRegWorksEntity entity = null;
		for (Open733CopyRegWorksDTO item : items) {
			entity = new EntCopyRegWorksEntity();
			BeanUtils.copyProperties(item, entity);

			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			copyRegWorksEntityList.add(entity);
		}
		entCopyRegWorksService.insertBatch(copyRegWorksEntityList);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
