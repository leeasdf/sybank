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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open369InverstDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntInverstInfoEntity;

import xin.tianchuang.modules.spider.service.EntInverstInfoService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class InverstHandler implements QueryHandler<List<Open369InverstDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(InverstHandler.class);

	@Autowired
	private EntInverstInfoService entInverstInfoService;

	@Override
	public BaseRespnseDTO<List<Open369InverstDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/inverst?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":46,\"items\":[{\"orgType\":\"其他有限责任公司\",\"business_scope\":\"计算机系统、网络系统的技术开发、技术服务、技术咨询；计算机系统服务；基础软件服务；应用软件服务；设计、制作、代理、发布广告；组织文化艺术交流活动（不含营业性演出）；企业策划；影视策划；公共关系服务；教育咨询；文化咨询；承办展览展示活动；会议服务；版权转让；版权代理；市场调查；经济贸易咨询；销售家用电器、机械设备、电子产品、文化用品、照相器材、计算机、软件及辅助设备、化妆品、体育用品、针纺织品、服装、鞋帽、日用杂货、首饰、工艺品、钟表、眼镜、玩具、汽车及摩托车配件、通讯设备；货物进出口、技术进出口、代理进出口；从事互联网文化活动。（企业依法自主选择经营项目，开展经营活动；依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\"percent\":\"53.35%\",\"regStatus\":\"开业\",\"estiblishTime\":1459440000000,\"legalPersonName\":\"胡浩\",\"type\":1,\"pencertileScore\":9241,\"legalPersonId\":2127300139,\"amount\":276.5283,\"id\":2350111935,\"category\":\"科技推广和应用服务业\",\"regCapital\":\"518.3251 万元\",\"name\":\"北京小度互娱科技有限公司\",\"base\":\"bj\",\"creditCode\":\"91110108MA004HKR33\",\"personType\":1},{\"orgType\":\"有限责任公司(自然人投资或控股)\",\"business_scope\":\"技术推广服务；计算机系统服务；设计、制作、代理、发布广告；经济信息咨询。（依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动。）\",\"percent\":\"40.87%\",\"regStatus\":\"开业\",\"estiblishTime\":1317312000000,\"legalPersonName\":\"黄修源\",\"type\":1,\"pencertileScore\":5598,\"legalPersonId\":2295273700,\"amount\":58.75,\"id\":33978180,\"category\":\"科技推广和应用服务业\",\"regCapital\":\"143.75 万元 人民币\",\"name\":\"北京亦水方舟科技有限公司\",\"base\":\"bj\",\"creditCode\":\"91110101584477119R\",\"personType\":1},{\"orgType\":\"有限责任公司(自然人投资或控股)\",\"business_scope\":\"移动电话机、移动终端的研发、生产（仅限分支机构经营）；技术推广服务；销售计算机、软件及辅助设备、电子产品、通讯设备；产品设计；维修手机、电话；会议及展览服务；经济贸易咨询；设计、代理、发布广告；软件设计。 移动电话机、移动终端的研发、生产（仅限分支机构经营）。（依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\"percent\":\"12.01%\",\"regStatus\":\"开业\",\"estiblishTime\":1354550400000,\"legalPersonName\":\"张伟华\",\"type\":1,\"pencertileScore\":9217,\"legalPersonId\":1920914416,\"amount\":301.5,\"id\":24644208,\"category\":\"科技推广和应用服务业\",\"regCapital\":\"2509.9865 万元 人民币\",\"name\":\"诺克萨斯（北京）科技有限公司\",\"base\":\"bj\",\"creditCode\":\"91110106059289814B\",\"personType\":1},{\"orgType\":\"有限责任公司\",\"business_scope\":\"计算机软件的设计、研发、销售。；从事广告业务。；\",\"percent\":\"3.00%\",\"regStatus\":\"存续（在营、开业、在册）\",\"estiblishTime\":1418659200000,\"legalPersonName\":\"李柯\",\"type\":1,\"pencertileScore\":5900,\"legalPersonId\":1986424252,\"amount\":4.8077,\"id\":1284552427,\"category\":\"软件和信息技术服务业\",\"regCapital\":\"(人民币)160.2563万元\",\"name\":\"深圳米筐科技有限公司\",\"base\":\"gd\",\"creditCode\":\"91440300319757355B\",\"personType\":1},{\"orgType\":\"其他有限责任公司\",\"business_scope\":\"组织文化艺术交流活动（不含演出）；文艺创作；资料编辑；会议服务；承办展览展示活动；从事文化经纪业务；设计、制作、代理、发布广告；电脑动画设计；软件开发；技术推广服务；销售工艺品、橡胶制品、塑料制品、钟表、眼镜（不含隐形眼镜）、玩具、体育用品、针纺织品、服装、日用品、化妆品、五金交电（不从事实体店铺经营）、电子产品、文具用品、照相器材；从事文化经纪业务；演出经纪；从事互联网文化活动。（企业依法自主选择经营项目，开展经营活动；演出经纪以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\"estiblishTime\":1409155200000,\"regStatus\":\"开业\",\"type\":1,\"legalPersonName\":\"钱实穆\",\"pencertileScore\":9840,\"legalPersonId\":2235722430,\"id\":934605,\"amount\":0,\"category\":\"文化艺术业\",\"regCapital\":\"3454.3907 万元\",\"name\":\"北京太合音乐文化发展有限公司\",\"base\":\"bj\",\"creditCode\":\"911101053067230171\",\"personType\":1}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open369InverstDTO>> rtnDTO = new BaseRespnseDTO<List<Open369InverstDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String message = dtos.getMessage();

		BaseRespnseDTO<List<Open369InverstDTO>> rtnDTO = new BaseRespnseDTO<List<Open369InverstDTO>>();
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
		entInverstInfoService.deleteByEntName(entName);
		// 节点数据为空
		ResponsePageNumResultDTO<Open369InverstDTO> data = dtos.getData();
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

		List<Open369InverstDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}
	
		List<EntInverstInfoEntity> list = new ArrayList<EntInverstInfoEntity>(items.size());
		EntInverstInfoEntity inverstInfoEntity = null;
		for (Open369InverstDTO item : items) {
			inverstInfoEntity = new EntInverstInfoEntity();
			BeanUtils.copyProperties(item, inverstInfoEntity);
			inverstInfoEntity.setEntId(param.getEntListInfo().getId());
			inverstInfoEntity.setEntName(entName);
			inverstInfoEntity.setCreditCode(param.getEntListInfo().getCreditCode());
			list.add(inverstInfoEntity);
		}
		entInverstInfoService.insertBatch(list);
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;

	}
}
