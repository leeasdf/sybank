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

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.utils.ApiResp;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizCompanyListReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizCompanyReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizViewReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCompanyInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderRelationsSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizIndexDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizJudicialSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKnowleageSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizListedCompanyDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizNewsDTO;
import xin.tianchuang.modules.api.biz.LoanBizFacade;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/loan")
@Api(value = "业务系统对接企业-全景图接口", tags = { "业务对接接口" })
public class LoanBizFacadeController {

	private static Logger logger = LoggerFactory.getLogger(LoanBizFacadeController.class);

	@Resource
	private LoanBizFacade loanBizFacade;

	/**
	 * 全景图首页信息，包含部分基本信息、重大变更、标的额、负面舆情等
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/index")
	@ApiOperation(value = "全景图-首页信息", notes = "全景图-首页信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<LoanBizIndexDTO> getIndex(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizIndexDTO dto = loanBizFacade.getIndex(param);
		ApiResp<LoanBizIndexDTO> apiResp = new ApiResp<LoanBizIndexDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	@ResponseBody
	@PostMapping("/company")
	@ApiOperation(value = "企业名录-单企业查询接口", notes = "查询单企业信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "查询成功", response = ApiResp.class)
	public ApiResp<LoanBizCompanyInfoDTO> getCompany(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizCompanyInfoDTO dto = loanBizFacade.getEntList(param);
		ApiResp<LoanBizCompanyInfoDTO> apiResp = new ApiResp<LoanBizCompanyInfoDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 0、企业信息名录
	@ResponseBody
	@PostMapping("/companyList")
	@ApiOperation(value = "全景图-查询企业名录", notes = "查询企业信息名录列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "beginDate", value = "查询开始时间", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<List<LoanBizCompanyInfoDTO>> companyList(@RequestBody LoanBizCompanyListReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		List<LoanBizCompanyInfoDTO> dtos = loanBizFacade.getCompanyList(param);
		ApiResp<List<LoanBizCompanyInfoDTO>> apiResp = new ApiResp<List<LoanBizCompanyInfoDTO>>();
		if (null == dtos || dtos.size() <= 0) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dtos);
	}

	// 工商信息 基本信息、股东信息、高管信息、对外投资、分支机构、关联关系图谱
	@ResponseBody
	@PostMapping("/baseinfoSet")
	@ApiOperation(value = "全景图-查询工商集合信息", notes = "查询工商集合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<LoanBizBaseinfoSetDTO> getBaseinfoSet(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizBaseinfoSetDTO dto = loanBizFacade.getBaseinfoSet(param);
		ApiResp<LoanBizBaseinfoSetDTO> apiResp = new ApiResp<LoanBizBaseinfoSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}

		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);

	}

	// 司法信息 开庭公告、裁判文书、法院公告、执行公告、失信公告
	@ResponseBody
	@PostMapping("/judicialSet")
	@ApiOperation(value = "全景图-查询企业司法聚合信息", notes = "查询企业司法聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<LoanBizJudicialSetDTO> getJudicialSet(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizJudicialSetDTO dto = loanBizFacade.getJudicialSet(param);
		ApiResp<LoanBizJudicialSetDTO> apiResp = new ApiResp<LoanBizJudicialSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 舆情信息
	@ResponseBody
	@PostMapping("/newsSet")
	@ApiOperation(value = "全景图-查询企业舆情列表信息", notes = "查询企业舆情列表信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<List<LoanBizNewsDTO>> getNewsSet(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		List<LoanBizNewsDTO> dtos = loanBizFacade.getNewsSet(param);
		ApiResp<List<LoanBizNewsDTO>> apiResp = new ApiResp<List<LoanBizNewsDTO>>();
		if (null == dtos || dtos.size() <= 0) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dtos);
	}

	// 上市信息
	@ResponseBody
	@PostMapping("/listedCompany")
	@ApiOperation(value = "全景图-查询企业上市信息", notes = "查询企业上市信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<LoanBizListedCompanyDTO> getListedCompany(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizListedCompanyDTO dto = loanBizFacade.getListedCompany(param);
		ApiResp<LoanBizListedCompanyDTO> apiResp = new ApiResp<LoanBizListedCompanyDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);
	}

	// 知识产权 商标信息、专利、软件著作权
	@ResponseBody
	@PostMapping("/knowleageList")
	@ApiOperation(value = "全景图-查询企业知识产权聚合信息", notes = "查询企业知识产权聚合信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp<LoanBizKnowleageSetDTO> getKnowleageList(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		LoanBizKnowleageSetDTO dto = loanBizFacade.getKnowleageList(param);
		ApiResp<LoanBizKnowleageSetDTO> apiResp = new ApiResp<LoanBizKnowleageSetDTO>();
		if (null == dto) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dto);

	}

	@ResponseBody
	@PostMapping("/holder")
	@ApiOperation(value = "股东信息-单个查询股东信息", notes = "根据企业名称查询该企业的股东信息，如果为自然人股东，这返回自然人相关信息，如果为企业股东，这返回企业股东的相关信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@SysLog("股东信息查询")
	public ApiResp<List<LoanBizHolderRelationsSetDTO>> getHolder(@RequestBody LoanBizViewReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		List<LoanBizHolderRelationsSetDTO> dtos = loanBizFacade.getHoldersSet(param);
		ApiResp<List<LoanBizHolderRelationsSetDTO>> apiResp = new ApiResp<List<LoanBizHolderRelationsSetDTO>>();
		if (null == dtos || dtos.size() <= 0) {
			return apiResp.successNoData(param.getBizCode(), param.getSeqNum());
		}
		return apiResp.ok(param.getBizCode(), param.getSeqNum(), dtos);
	}

	// 企业关系图谱 --行内交易圈 企业担保圈 相关人关系
	@ResponseBody
	@PostMapping("/businessRelation")
	@ApiOperation(value = "全景图-查询企业关系图谱信息(上线前废除)", notes = "查询企业图谱信息-该接口为mock接口")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@Deprecated
	public String getBusinessRelation(@RequestBody LoanBizCompanyReqDTO param) throws Exception {
		// mock
		String mock = "{\"data\":{\"bank\":{\"nodes\":[{\"id\":\"948954637\",\"labels\":[\"Company\"],\"properties\":{\"name\":\"阜阳领育教育咨询有限公司\",\"ntype\":\"s\"}},{\"id\":\"1989544547\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫菲\",\"ntype\":\"s\"}},{\"id\":\"1989537051\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫墨\",\"ntype\":\"s\"}}],\"relationships\":[{\"id\":\"175212850\",\"type\":\"OWN\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"法人\"]}},{\"id\":\"23117878\",\"type\":\"SERVE\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"执行董事兼总经理\"]}},{\"id\":\"48101351\",\"type\":\"INVEST_H\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}},{\"id\":\"231907279\",\"type\":\"SERVE\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"监事\"]}},{\"id\":\"23858947\",\"type\":\"INVEST_H\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}}],\"relationshipsTable\":[{\"companyName\":\"企业B\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业B\",\"status\":\"有贷款记录，五级分类正常\"},{\"companyName\":\"企业C\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业C\",\"status\":\"有贷款记录，五级分\"},{\"companyName\":\"企业D\",\"layer\":\"2\",\"relationshipChain\":\"企业A——企业C——企业D\",\"status\":\"有贷款记录，五级分\"}]},\"guarantee\":{\"nodes\":[{\"id\":\"948954637\",\"labels\":[\"Company\"],\"properties\":{\"name\":\"阜阳领育教育咨询有限公司\",\"ntype\":\"s\"}},{\"id\":\"1989544547\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫菲\",\"ntype\":\"s\"}},{\"id\":\"1989537051\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫墨\",\"ntype\":\"s\"}}],\"relationships\":[{\"id\":\"175212850\",\"type\":\"OWN\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"法人\"]}},{\"id\":\"23117878\",\"type\":\"SERVE\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"执行董事兼总经理\"]}},{\"id\":\"48101351\",\"type\":\"INVEST_H\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}},{\"id\":\"231907279\",\"type\":\"SERVE\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"监事\"]}},{\"id\":\"23858947\",\"type\":\"INVEST_H\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}}],\"relationshipsTable\":[{\"companyName\":\"企业B\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业B\",\"status\":\"有贷款记录，五级分类正常\"},{\"companyName\":\"企业C\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业C\",\"status\":\"有贷款记录，五级分\"},{\"companyName\":\"企业D\",\"layer\":\"2\",\"relationshipChain\":\"企业A——企业C——企业D\",\"status\":\"有贷款记录，五级分\"}]},\"people\":{\"nodes\":[{\"id\":\"948954637\",\"labels\":[\"Company\"],\"properties\":{\"name\":\"阜阳领育教育咨询有限公司\",\"ntype\":\"s\"}},{\"id\":\"1989544547\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫菲\",\"ntype\":\"s\"}},{\"id\":\"1989537051\",\"labels\":[\"Human\"],\"properties\":{\"name\":\"李紫墨\",\"ntype\":\"s\"}}],\"relationships\":[{\"id\":\"175212850\",\"type\":\"OWN\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"法人\"]}},{\"id\":\"23117878\",\"type\":\"SERVE\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"执行董事兼总经理\"]}},{\"id\":\"48101351\",\"type\":\"INVEST_H\",\"startNode\":\"1989544547\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}},{\"id\":\"231907279\",\"type\":\"SERVE\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"监事\"]}},{\"id\":\"23858947\",\"type\":\"INVEST_H\",\"startNode\":\"1989537051\",\"endNode\":\"948954637\",\"properties\":{\"labels\":[\"参股\"]}}],\"relationshipsTable\":[{\"companyName\":\"企业B\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业B\",\"status\":\"有贷款记录，五级分类正常\"},{\"companyName\":\"企业C\",\"layer\":\"1\",\"relationshipChain\":\"企业A——企业C\",\"status\":\"有贷款记录，五级分\"},{\"companyName\":\"企业D\",\"layer\":\"2\",\"relationshipChain\":\"企业A——企业C——企业D\",\"status\":\"有贷款记录，五级分\"}]}},\"seqNum\":\"6f0b52d11a4a4f60babbefe3ddf7e59d\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
		return mock;
	}

}
