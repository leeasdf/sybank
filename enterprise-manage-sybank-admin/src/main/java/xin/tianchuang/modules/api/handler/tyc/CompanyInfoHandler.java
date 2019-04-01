//package xin.tianchuang.modules.api.handler.tyc;
//
//import java.lang.reflect.Type;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
//import xin.tianchuang.common.exception.ApiException;
//import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.response.Open460CompanyInfoDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
//import xin.tianchuang.modules.api.dto.TycApiRespDTO;
//import xin.tianchuang.modules.api.handler.QueryHandler;
//import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//
///**
// * 
// * @author denghui
// *
// */
//public class CompanyInfoHandler implements QueryHandler<Boolean> {
//
//	private static final Logger logger = LoggerFactory.getLogger(CompanyInfoHandler.class);
//
//	@Override
//	public BaseRespnseDTO<Boolean> parseData(BaseApiRequestDTO param, String apiData) {
//		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/companyInfo?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
//		
//		//
//		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
//		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open460CompanyInfoDTO>>>() {
//		}.getType(); //
//		TycApiRespDTO<ResponsePageNumResultDTO<Open460CompanyInfoDTO>> dtos = gson.fromJson(apiData, jsonType);
//		if (dtos == null) { // 成功
//			throw new ApiException("接口响应数据为空", TcxyApiStatusCodeEnum.SYS_BUZY.key());
//		}
//
//		Integer status = dtos.getStatus();
//		String uuid = dtos.getSeqNum();
//		String message = dtos.getMessage();
//
//		BaseRespnseDTO<Boolean> rtnDTO = new BaseRespnseDTO<Boolean>();
//		rtnDTO.setRtnSerialNo(uuid);
//		rtnDTO.setCode(status);
//		rtnDTO.setMsg(message);
//		rtnDTO.setRespStr(apiData);
//		//如果查询不成功或者结果是成功无数据，那么直接返回查询失败
//		if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) { // 非正常情况
//			rtnDTO.setRemark("查询失败");
//			return rtnDTO;
//		}
//		//更新状态
//		EntListInfoEntity listInfoEntity = param.getEntListInfo();
//		if (null == listInfoEntity) {
//			logger.error("[{}]企业名录中无该企业数据，请核实", param.getSeqNum());
//			throw new ApiException(TcxyApiStatusCodeEnum.PARAM_ERR.desc(), TcxyApiStatusCodeEnum.PARAM_ERR.key());
//		}
//		//查询成功无数据
//		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
//			rtnDTO.setRemark("查询成功无数据");
//			rtnDTO.setData(false);
//		}else {
//			rtnDTO.setRemark("查询成功");
//			rtnDTO.setData(true);
//		}
//		return rtnDTO;
//	}
//}
