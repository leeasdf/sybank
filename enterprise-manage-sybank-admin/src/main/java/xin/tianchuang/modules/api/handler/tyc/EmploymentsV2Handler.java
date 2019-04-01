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
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;

import xin.tianchuang.modules.spider.service.EntEmployInfoService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class EmploymentsV2Handler implements QueryHandler<List<Open782EmploymentsV2DTO>> {

	private static final Logger logger = LoggerFactory.getLogger(EmploymentsV2Handler.class);

	@Autowired
	private EntEmployInfoService entEmployInfoService;

	@Override
	public BaseRespnseDTO<List<Open782EmploymentsV2DTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/employmentsV2?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":1,\"items\":[{\"education\":\"本科\",\"jobFirstClass\":\"内容审核\",\"city\":\"北京\",\"companyName\":\"北京百度网讯科技有限公司\",\"description\":\"[工作职责： -负责7亿用户百度APP和1亿用户好看视频APP的短视频资源审核管理，承接视频内容审核需求，评估制定合理的内容审核规范和标注规则，为公司产品内容提供安全和质量审核保障 -把控审核部门的日常工作，管理工作进度和人员工作情况，进行人员评估 -负责内容审核相关标准的制定、完善及执行，开展审核标准培训工作 -进行常规的内容数据统计与数据分析，通过数据分析深度挖掘优质内容特征，为策略算法提供建议，优化线上推荐效果，提升用户体验 -负责内容审核相关制度的优化，对后台产品的优化升级提出修改意见 -协助审核部门与其他部门的工作往来，解决问题，促进合作 任职资格： -本科及以上学历，新闻传播、中文等专业优先 -具有3年及以上互联网内容运营、编辑、审核管理相关工作经验，有在今日头条、秒拍、美拍等短视频网站工作经验的优先 -各类视频网站深度爱好者，对短视频行业有深入了解，对内容质量、格调、尺度有明确判断能力，了解新闻及实事政策，具备高度的政治敏感性，能够及时发现政治安全风险 -具备良好的总结分析能力和逻辑分析能力，文本写作能力强 -较强抗压能力，快速响应问题和跟进问题；责任心强，工作认真仔细]\",\"companyNameMws\":\"北京百度网讯科技有限公司\",\"source\":\"BOSS直聘\",\"title\":\"视频审核管理产品运营\",\"experience\":\"1-3年\",\"startdate\":1542988800000,\"companyLng\":\"40.056855610737580\",\"paramRegStatus\":\"开业\",\"eventTime\":\"1542988800000\",\"id\":\"22822\",\"companyLat\":\"116.307755395409820\",\"oriSalary\":\"15000-30000\",\"estiblishTimeLong\":\"991670400000\",\"class\":\"全职\",\"companyCity\":\"北京\",\"searchType\":\"304\",\"_type\":\"54\",\"categoryCode\":\"2102\",\"urlPath\":\"https://www.zhipin.com/job_detail/d52a73fe9ed26ace1Xx_3d24EFA~.html?sid=seo_aladingb\",\"employerNumber\":\"若干\",\"categoryCodeNew\":\"759\",\"uni\":\"c384d07514c6a9095d44f93b9712b08c\",\"companyId\":\"431\",\"deleted\":\"0\",\"paramRegCapital\":\"89000.00000\",\"enddate\":1545580800000,\"paramRegYear\":\"2001\",\"createTime\":\"1543027729000\",\"fromUrl\":\"北京\",\"district\":\"海淀区\",\"location\":\"北京市 海淀区 鹏寰国际大厦\",\"base\":\"bj\"}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open782EmploymentsV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open782EmploymentsV2DTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String entName = param.getName();

		BaseRespnseDTO<List<Open782EmploymentsV2DTO>> rtnDTO = new BaseRespnseDTO<List<Open782EmploymentsV2DTO>>();
		rtnDTO.setRtnSerialNo(uuid);
		rtnDTO.setRespStr(apiData);
		rtnDTO.setCode(status);
		rtnDTO.setMsg(dtos.getMessage());
		// 非正常情况
		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) {
			rtnDTO.setRemark("查询失败");
			return rtnDTO;
		}
		
		entEmployInfoService.deleteByEntName(entName);
		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 查询成功
		ResponsePageNumResultDTO<Open782EmploymentsV2DTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open782EmploymentsV2DTO> items = data.getItems();
		if (null == items || items.size() <= 0) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}

		List<EntEmployInfoEntity> employInfoEntityList = new ArrayList<EntEmployInfoEntity>(items.size());
		EntEmployInfoEntity entity = null;
		for (Open782EmploymentsV2DTO item : items) {
			entity = new EntEmployInfoEntity();
			BeanUtils.copyProperties(item, entity);

			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());

			employInfoEntityList.add(entity);
		}
		entEmployInfoService.insertBatch(employInfoEntityList);
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
