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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open441CopyRegDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntCopyRegEntity;

import xin.tianchuang.modules.spider.service.EntCopyRegService;
import xin.tianchuang.modules.spider.service.EntListInfoService;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class CopyRegHandler implements QueryHandler<List<Open441CopyRegDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(CopyRegHandler.class);

	@Autowired
	private EntListInfoService entListInfoService;
	@Autowired
	private EntCopyRegService entCopyRegService;

	@Override
	public BaseRespnseDTO<List<Open441CopyRegDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/copyReg?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":\"127\",\"items\":[{\"id\":\"2797175\",\"_type\":\"63\",\"regtime\":\"1505059200000\",\"publishtime\":\"1503763200000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度文库\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR502655\",\"catnum\":\"30200-0000\",\"searchType\":\"403\",\"uni\":\"c5ae6b0d9c8cf7e1ad68c5a43a2f9d1d\",\"eventTime\":\"1505059200000\",\"fullname\":\"百度文库Android终端软件\",\"version\":\"V4.2.4\"},{\"id\":\"2797174\",\"_type\":\"63\",\"regtime\":\"1505059200000\",\"publishtime\":\"1503590400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度文库\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR501409\",\"catnum\":\"30309-0000\",\"searchType\":\"403\",\"uni\":\"2b32807553e5497cefb7f48a52880a77\",\"eventTime\":\"1505059200000\",\"fullname\":\"百度文库iOS终端软件\",\"version\":\"V4.2.4\"},{\"id\":\"1556690\",\"_type\":\"63\",\"regtime\":\"1494950400000\",\"publishtime\":\"1484582400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度糯米\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR185245\",\"catnum\":\"30000-0000\",\"searchType\":\"403\",\"uni\":\"ec4c797e94c2947e663279ee3b73ee67\",\"eventTime\":\"1494950400000\",\"fullname\":\"百度糯米IOS终端软件\",\"version\":\"V7.1.0\"},{\"id\":\"1558272\",\"_type\":\"63\",\"regtime\":\"1494950400000\",\"publishtime\":\"1484582400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度糯米\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR185306\",\"catnum\":\"30000-0000\",\"searchType\":\"403\",\"uni\":\"478437223ff01623c8f8422739287fc2\",\"eventTime\":\"1494950400000\",\"fullname\":\"百度糯米Android终端软件\",\"version\":\"V7.1.0\"},{\"id\":\"2797171\",\"_type\":\"63\",\"regtime\":\"1494172800000\",\"publishtime\":\"1458316800000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度效率云\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR165645\",\"catnum\":\"30200-0000\",\"searchType\":\"403\",\"uni\":\"dc839dfab8d2c749f7c2fe199deead27\",\"eventTime\":\"1494172800000\",\"fullname\":\"持续集成与交付平台\",\"version\":\"V1.0.0\"},{\"id\":\"2797170\",\"_type\":\"63\",\"regtime\":\"1488470400000\",\"publishtime\":\"1470326400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"皇家德州圈iOS版\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2017SR066324\",\"catnum\":\"30105-6200\",\"searchType\":\"403\",\"uni\":\"a0a956656dcf2c2cae9f150e37a12be4\",\"eventTime\":\"1488470400000\",\"fullname\":\"皇家德州圈iOS软件\",\"version\":\"V1.7.1\"},{\"id\":\"1717799\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1361462400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度刷机\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339599\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"4b187c57b044998684fd0b26f048ea3b\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度刷机手机端软件\",\"version\":\"V1.0.4\"},{\"id\":\"1717803\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1338393600000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339660\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"9018f9804cfbaef0175bb50b38afbad0\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度云系统备份恢复软件\",\"version\":\"V2.0.0.0\"},{\"id\":\"1717806\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1369929600000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339665\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"6b1d8838996fa9233f6df69b9a6e934b\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度云应用分发平台软件\",\"version\":\"V1.0.0.0\"},{\"id\":\"1717815\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1366992000000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339655\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"2b320dae7ec2b17e303e90702d405edb\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度移动云应用备份软件\",\"version\":\"V1.0\"},{\"id\":\"1717798\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1460736000000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"皇家德州圈Android版\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339446\",\"catnum\":\"30105-6200\",\"searchType\":\"403\",\"uni\":\"185e519cee98699aa14e9a5badba3194\",\"eventTime\":\"1479744000000\",\"fullname\":\"皇家德州圈Android软件\",\"version\":\"V2.4.236\"},{\"id\":\"1717801\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1368028800000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"一键清理\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339676\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"50b2a484d59a14c58633ba242936d664\",\"eventTime\":\"1479744000000\",\"fullname\":\"一键清理后台应用程序系统\",\"version\":\"V1.0\"},{\"id\":\"1717812\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1351612800000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339672\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"1b9040989e4f8ba94393ec0166a28f01\",\"eventTime\":\"1479744000000\",\"fullname\":\"网络电话软件\",\"version\":\"V2.0.0.0\"},{\"id\":\"1717813\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1371830400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339647\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"872b0025369bdff139a3a4ad1f197f95\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度一键Root安卓手机端工具软件\",\"version\":\"V2.0.0\"},{\"id\":\"1717814\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1338393600000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339590\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"b29dffac6934705dd87c6f31011fe21f\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度防骚扰软件\",\"version\":\"V2.0.0.0\"},{\"id\":\"1717797\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1338480000000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度一键刷机\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339653\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"13eb70de33db596b612e39b26f7e8791\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度一键刷机PC端软件\",\"version\":\"V2.0.6\"},{\"id\":\"1717802\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1351699200000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度一键Root\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339595\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"0967304257f152ad8679475f01200536\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度一键Root安卓手机PC端工具软件\",\"version\":\"V3.3.03\"},{\"id\":\"1717805\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1366819200000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"百度桌面\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339639\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"b1703429473a526187c333fd34019f9c\",\"eventTime\":\"1479744000000\",\"fullname\":\"移动设备桌面管理软件\",\"version\":\"V3.4.0\"},{\"id\":\"1717810\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1357574400000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339603\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"196b0ae093d6e2e7d13d62cdc9b03f6f\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度手机找回软件\",\"version\":\"V1.0\"},{\"id\":\"1717811\",\"_type\":\"63\",\"regtime\":\"1479744000000\",\"publishtime\":\"1368547200000\",\"authorNationality\":\"北京百度网讯科技有限公司:中国\",\"simplename\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"regnum\":\"2016SR339668\",\"catnum\":\"10100-0000\",\"searchType\":\"403\",\"uni\":\"d072e98a6a0b46a71e6b94fd5db3d0b6\",\"eventTime\":\"1479744000000\",\"fullname\":\"百度智能电源管理软件\",\"version\":\"V1.0.0.0\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open441CopyRegDTO>> rtnDTO = new BaseRespnseDTO<List<Open441CopyRegDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open441CopyRegDTO>> rtnDTO = new BaseRespnseDTO<List<Open441CopyRegDTO>>();
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
		entCopyRegService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open441CopyRegDTO> data = dtos.getData();
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
		List<Open441CopyRegDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntCopyRegEntity> copyRegEntityList = Lists.newArrayList();
		List<String> connLs = null;
		EntCopyRegEntity entity = null;
		String connStr = null;
		for (Open441CopyRegDTO item : items) {
			entity = new EntCopyRegEntity();
			BeanUtils.copyProperties(item, entity);

			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			connLs = item.getConnList();
			if (null != connLs && connLs.size() > 0) {
				connStr = Joiner.on(",").join(connLs);
				entity.setConnList(connStr);
			}

			copyRegEntityList.add(entity);
		}
		entCopyRegService.insertBatch(copyRegEntityList);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
