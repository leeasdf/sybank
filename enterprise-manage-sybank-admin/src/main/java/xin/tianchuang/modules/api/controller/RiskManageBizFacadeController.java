package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.utils.ApiResp;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewEntReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewRntResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseBlackDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseIndustyDTO;
import xin.tianchuang.modules.api.biz.RiskManageBizFacade;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/risk")
@Api(value = "风控系统对接接口", tags = { "风控系统对接接口" })
public class RiskManageBizFacadeController {

	private static Logger logger = LoggerFactory.getLogger(RiskManageBizFacadeController.class);

	@Resource
	private RiskManageBizFacade riskManageBizFacade;

	@ResponseBody
	@PostMapping("/report/tyc")
	@ApiOperation(value = "天眼查模型加工接口", notes = "通过企业名称等生成天眼查模型加工-实时对接接口")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<TycDataHandleResponseDTO> tycReport(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		TycDataHandleResponseDTO dto = riskManageBizFacade.tycReport(param);
		ApiResp<TycDataHandleResponseDTO> apiResp = new ApiResp<TycDataHandleResponseDTO>();
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	@ResponseBody
	@PostMapping("/report/getIndustry")
	@ApiOperation(value = "行业查询接口", notes = "获取企业对应的行业信息")
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<List<TycDataHandleResponseIndustyDTO>> getAllIndusty(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		List<TycDataHandleResponseIndustyDTO> dto = riskManageBizFacade.getAllNameAndIndustry();
		ApiResp<List<TycDataHandleResponseIndustyDTO>> apiResp = new ApiResp<List<TycDataHandleResponseIndustyDTO>>();
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	@ResponseBody
	@PostMapping("/report/addEnt")
	@ApiOperation(value = "增量更新企业名录信息", notes = "根据传入的企业名称、统一社会信用代码，增量更新企业名录信息")
	@ApiResponse(code = 200, message = "请求成功", response = ApiResp.class)
	public ApiResp<RiskManageNewRntResponseDTO> addEnt(@RequestBody List<RiskManageNewEntReqDTO> param) throws Exception {
		logger.info("增量信息：请求信息{}", new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		RiskManageNewRntResponseDTO dto = riskManageBizFacade.addNewEntListInfo(param);
		ApiResp<RiskManageNewRntResponseDTO> apiResp = new ApiResp<RiskManageNewRntResponseDTO>();
		return apiResp.ok(dto);
	}

	@ResponseBody
	@PostMapping("/report/black")
	@ApiOperation(value = "黑名单企业查询接口", notes = "通过企业名称等查询是否为黑名单企业")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<TycDataHandleResponseBlackDTO> blackReport(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		TycDataHandleResponseBlackDTO dto = riskManageBizFacade.blackReport(param);
		ApiResp<TycDataHandleResponseBlackDTO> apiResp = new ApiResp<TycDataHandleResponseBlackDTO>();
		return apiResp.ok(dto);
	}

	@ResponseBody
	@PostMapping("/report/blackList")
	@ApiOperation(value = "批量查询-黑名单企业查询接口", notes = "通过企业名称等查询是否为黑名单企业")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<List<TycDataHandleResponseBlackDTO>> blackReport(@RequestBody List<RiskManageBizReqDTO> param) throws Exception {
		logger.info("批量查询请求信息{}", new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		List<TycDataHandleResponseBlackDTO> list = riskManageBizFacade.blackListReport(param);
		ApiResp<List<TycDataHandleResponseBlackDTO>> apiResp = new ApiResp<List<TycDataHandleResponseBlackDTO>>();
		return apiResp.ok(list);
	}

}
