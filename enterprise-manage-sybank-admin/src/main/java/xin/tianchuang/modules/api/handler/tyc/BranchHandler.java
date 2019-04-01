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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open372BranchDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntBranchInfoEntity;

import xin.tianchuang.modules.spider.service.EntBranchInfoService;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class BranchHandler implements QueryHandler<List<Open372BranchDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(BranchHandler.class);
	@Autowired
	private EntBranchInfoService entBranchInfoService;

	@Override
	public BaseRespnseDTO<List<Open372BranchDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/branch?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":9,\"items\":[{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/8e1aa6e84ff617657c2eeadae5b451f0.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1208448000000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":1335,\"legalPersonId\":1839080315,\"id\":139572921,\"category\":\"652\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司深圳分公司\",\"base\":\"gd\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/e94da5a7b0bb926632ac585766028e6f.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1211212800000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":139572971,\"category\":\"653\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司广州分公司\",\"base\":\"gd\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/762a5d7bd8f3a41a6ea39bbad6d946f0.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1210780800000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":139573020,\"category\":\"732\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司东莞分公司\",\"base\":\"gd\",\"personType\":1},{\"toco\":1,\"logo\":\"http://img.tianyancha.com/logo/lll/010c44218af9a39e745a400850b48af0.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1374681600000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"赵坤\",\"pencertileScore\":2498,\"legalPersonId\":2191149373,\"id\":139573097,\"category\":\"724\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司南京分公司\",\"base\":\"js\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/53b97676f92b3ea6b7f37babdfbea680.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1326211200000,\"regStatus\":\"注销\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":412551136,\"category\":\"653\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司重庆分公司\",\"base\":\"cq\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/33c94402e09f1b2d027057f1ba61957f.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1209916800000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":711249800,\"category\":\"751\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司上海分公司\",\"base\":\"sh\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/1e21bc076c4f1629d8de5be85fd0e2cb.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1330617600000,\"regStatus\":\"注销\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":1566690935,\"category\":\"659\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司西安分公司\",\"base\":\"snx\",\"personType\":1},{\"toco\":36,\"logo\":\"http://img.tianyancha.com/logo/lll/5ed7edde6ac52f84fed757e78a23c49f.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1336406400000,\"regStatus\":\"存续\",\"type\":1,\"legalPersonName\":\"向海龙\",\"pencertileScore\":3835,\"legalPersonId\":1839080315,\"id\":1615756664,\"category\":\"642\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司哈尔滨分公司\",\"base\":\"hlj\",\"personType\":1},{\"toco\":8,\"logo\":\"http://img.tianyancha.com/logo/lll/809d933b2ef0d6392274daab2fa0c24d.png@!f_200x200\",\"alias\":\"百度网讯\",\"estiblishTime\":1209398400000,\"regStatus\":\"注销\",\"type\":1,\"legalPersonName\":\"刘计平\",\"pencertileScore\":2567,\"legalPersonId\":1816841111,\"id\":2456357709,\"category\":\"642\",\"regCapital\":\"\",\"name\":\"北京百度网讯科技有限公司佛山分公司\",\"base\":\"gd\",\"personType\":1}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open372BranchDTO>> rtnDTO = new BaseRespnseDTO<List<Open372BranchDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String entName = param.getName();

		BaseRespnseDTO<List<Open372BranchDTO>> rtnDTO = new BaseRespnseDTO<List<Open372BranchDTO>>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setRespStr(apiData);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(dtos.getMessage());
		// 非正常情况
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) {
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		
		//先删除，在新增
		entBranchInfoService.deleteByEntName(entName);
		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 查询成功
		ResponsePageNumResultDTO<Open372BranchDTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open372BranchDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		EntBranchInfoEntity entity = null;
		List<EntBranchInfoEntity> list = Lists.newArrayList();
		for (Open372BranchDTO item : items) {
			entity = new EntBranchInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			list.add(entity);
		}
		entBranchInfoService.insertBatch(list);
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
