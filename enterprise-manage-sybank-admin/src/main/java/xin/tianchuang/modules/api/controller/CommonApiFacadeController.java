package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
import xin.tianchuang.modules.api.bean.api.loan.request.CommonApiCompanyReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiBizKnowleageSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiJudicialSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiMoreSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.CommonApiRiskSetDTO;
import xin.tianchuang.modules.api.facade.commonApi.CommonApiFacade;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/common")
@Api(value = "公共接口", tags = { "公共对接接口" })
public class CommonApiFacadeController {

	private static Logger logger = LoggerFactory.getLogger(CommonApiFacadeController.class);
	
	@Resource
	private CommonApiFacade commonApiFacade;

	// 工商信息:基本信息、股东信息、高管信息、对外投资、变更记录、企业年报（暂无）、分支机构
	@ResponseBody
	@PostMapping("/baseinfoSet")
	@ApiOperation(value = "查询工商集合信息", notes = "查询工商集合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<CommonApiBaseinfoSetDTO> getBaseinfoSet(@RequestBody CommonApiCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		CommonApiBaseinfoSetDTO dto = commonApiFacade.getBaseinfoSet(param);
		ApiResp<CommonApiBaseinfoSetDTO> apiResp = new ApiResp<CommonApiBaseinfoSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 司法信息 开庭公告、裁判文书、法院公告、执行公告、失信公告
	@ResponseBody
	@PostMapping("/judicialSet")
	@ApiOperation(value = "查询企业司法聚合信息", notes = "查询企业司法聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<CommonApiJudicialSetDTO> getJudicialSet(@RequestBody CommonApiCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		CommonApiJudicialSetDTO dto = commonApiFacade.getJudicialSet(param);
		ApiResp<CommonApiJudicialSetDTO> apiResp = new ApiResp<CommonApiJudicialSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 经营风险 经营异常、行政处罚-信用中国（新版）、股权出质、动产抵押、欠税公告
	@ResponseBody
	@PostMapping("/riskSet")
	@ApiOperation(value = "查询企业经营风险聚合信息", notes = "查询企业经营风险聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<CommonApiRiskSetDTO> getRiskSet(@RequestBody CommonApiCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		CommonApiRiskSetDTO dto = commonApiFacade.getRiskSet(param);
		ApiResp<CommonApiRiskSetDTO> apiResp = new ApiResp<CommonApiRiskSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 知识产权 商标信息、专利、作品著作权、著作权、网站备案
	@ResponseBody
	@PostMapping("/knowleageList")
	@ApiOperation(value = "查询企业知识产权聚合信息", notes = "查询企业知识产权聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<CommonApiBizKnowleageSetDTO> getKnowleageList(@RequestBody CommonApiCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		CommonApiBizKnowleageSetDTO dto = commonApiFacade.getKnowleageList(param);
		ApiResp<CommonApiBizKnowleageSetDTO> apiResp = new ApiResp<CommonApiBizKnowleageSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);

	}

	//
	@ResponseBody
	@PostMapping("/more")
	@ApiOperation(value = "查询其它聚合信息", notes = "查询其它聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<CommonApiMoreSetDTO> getMore(@RequestBody CommonApiCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		CommonApiMoreSetDTO dto = commonApiFacade.getMore(param);
		ApiResp<CommonApiMoreSetDTO> apiResp = new ApiResp<CommonApiMoreSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);

	}

}
