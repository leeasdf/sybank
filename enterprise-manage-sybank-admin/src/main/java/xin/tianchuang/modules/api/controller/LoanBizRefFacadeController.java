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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.common.utils.ApiResp;
import xin.tianchuang.common.utils.DateUtils;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizReportReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.LoanBizReportTimeReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizPageReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageBizListResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageBizResponseDTO;
import xin.tianchuang.modules.api.biz.LoanBizFacade;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;
import xin.tianchuang.modules.spider.service.EntReportLogService;

import com.google.gson.Gson;

@Controller
@RequestMapping("/api/loan")
@Api(value = "存取对接", tags = { "业务系统对信息进行存取，风控系统对数据进行查询获取" })
public class LoanBizRefFacadeController {

	private static Logger logger = LoggerFactory.getLogger(LoanBizRefFacadeController.class);
	@Resource
	private LoanBizFacade loanBizFacade;

	@Resource
	protected EjbDozerGenerator ejbGenerator;

	@Resource
	private EntReportLogService entReportLogService;

	@ResponseBody
	@PostMapping("/finance")
	@ApiOperation(value = "存储-提额调查信息收集", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "data", value = "数据（此处存为json字符串)", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	@SysLog("存-提额调查信息")
	public ApiResp financeReport(@RequestBody LoanBizReportTimeReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		if(null == param.getBalanceTime()){
			return new ApiResp().error("资产负债表时间不能为空");
		}
		boolean successFlag = loanBizFacade.saveReport(param, BizInterfaceTypeEnum.FINANCE);
		if (successFlag) {
			return new ApiResp().ok("存储成功");
		}
		return new ApiResp().error();
	}

	@ResponseBody
	@PostMapping("/check")
	@ApiOperation(value = "存储-贷后常规检查信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "data", value = "数据（此处存为json字符串)", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	@SysLog("存-贷后常规检查信息")
	public ApiResp checkReport(@RequestBody LoanBizReportTimeReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		if(null == param.getBalanceTime()){
			return new ApiResp().error("资产负债表时间不能为空");
		}
		boolean successFlag = loanBizFacade.saveReport(param, BizInterfaceTypeEnum.CHECK);
		if (successFlag) {
			return new ApiResp().ok("存储成功");
		}
		return new ApiResp().error();
	}

	/**
	 * 企业授信-存储
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/companyCredit")
	@ApiOperation(value = "存储-正式授信信息", notes = "企业法人四要素以及关联人信息的存储")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "data", value = "数据（此处存为json字符串)", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	@SysLog("存-正式授信信息")
	public ApiResp companyCredit(@RequestBody LoanBizReportReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		boolean successFlag = loanBizFacade.saveReport(param, BizInterfaceTypeEnum.CREDIT);
		if (successFlag) {
			return new ApiResp().ok("存储成功");
		}
		return new ApiResp().error();
	}

	/**
	 * 企业征信-存储
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/bankCredit")
	@ApiOperation(value = "存储-企业央行征信收集信息", notes = "")
	@SysLog("存-央行征信信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "data", value = "数据（此处存为json字符串)", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	public ApiResp bankCredit(@RequestBody LoanBizReportReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		boolean successFlag = loanBizFacade.saveReport(param, BizInterfaceTypeEnum.COMPANY);
		if (successFlag) {
			return new ApiResp().ok("存储成功");
		}

		return new ApiResp().error();
	}

	@ResponseBody
	@PostMapping("/queryFinance")
	@ApiOperation(value = "查询-提额调查信息收集", notes = "查询最近8条-提额调查信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	public ApiResp queryFinance(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		return getEightRtnRisk(param, BizInterfaceTypeEnum.FINANCE);
	}

	@ResponseBody
	@PostMapping("/queryCheck")
	@ApiOperation(value = "查询-贷后常规检查信息", notes = "查询最近8条-贷后常规检查信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	public ApiResp queryCheck(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		return getEightRtnRisk(param, BizInterfaceTypeEnum.CHECK);
	}

	/**
	 * 贷后常规检查 行业平均接口（根据起止时间、结束时间内的所有贷后常规检查数据，对接口进行分页设计）
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/queryCheckPage")
	@ApiOperation(value = "分页查询-贷后常规检查信息", notes = "查询最近8条-贷后常规检查信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	public ApiResp queryCheckPage(@RequestBody RiskManageBizPageReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		if(param.getEndTime().getTime()-param.getStartTime().getTime()<0){
			return new ApiResp().error("结束时间小于开始时间");
		}
		// 传入的开始时间结束时间是yyyy-mm-dd 转化为date为那天的0点 希望能查到结束时间那天的记录date+1 就是time<结束时间的+1天的0点
		// 2019-01-01 到 2019-01-01 查的是 2019-01-01 00:00:00 到 2019-01-02 00:00:00 的数据
		param.setEndTime(DateUtils.addDateDays(param.getEndTime(), 1));
		return getRtnRiskPage(param, BizInterfaceTypeEnum.CHECK);
	}

	/**
	 * 查询企业授信
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/queryCompanyCredit")
	@ApiOperation(value = "查询-正式授信信息", notes = "查询-企业法人四要素以及关联人信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	public ApiResp queryCompanyCredit(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		return getRtnRisk(param, BizInterfaceTypeEnum.CREDIT);
	}

	/**
	 * 企业征信-查询
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/queryBankcCredit")
	@ApiOperation(value = "查询-企业央行征信收集信息", notes = "查询企业央行征信收集的信息")
	@ApiResponse(code = 200, message = "成功", response = ApiResp.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "creditCode", value = "统一社会信用代码", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "name", value = "企业名称", dataType = "String", paramType = "query"), //
			@ApiImplicitParam(name = "bizCode", value = "业务请求编号", dataType = "String", paramType = "query"), //
	})
	public ApiResp queryBankcCredit(@RequestBody RiskManageBizReqDTO param) throws Exception {
		logger.info("请求流水号[{}]-业务编号[{}]请求信息{}", param.getSeqNum(), param.getBizCode(), new Gson().toJson(param));
		ValidatorUtils.validateApiEntity(param);
		return getRtnRisk(param, BizInterfaceTypeEnum.COMPANY);
	}

	private ApiResp getRtnRisk(RiskManageBizReqDTO param, BizInterfaceTypeEnum type) {
		EntReportLogEntity entity = entReportLogService.selectLastReportByTypeEntNameBizCode(param.getName(), type, param.getCreditCode(), param.getBizCode());
		RiskManageBizResponseDTO riskManageBizResponseDTO = new RiskManageBizResponseDTO();
		riskManageBizResponseDTO.setEntName(param.getName());
		riskManageBizResponseDTO.setCreditCode(param.getCreditCode());
		if (null != entity) {
			return new ApiResp().ok(param.getBizCode(), param.getSeqNum(), entity.getReportContent());
		}
		return new ApiResp().successNoData(param.getBizCode(), param.getSeqNum());
	}

	private ApiResp getEightRtnRisk(RiskManageBizReqDTO param, BizInterfaceTypeEnum type) {
		List<EntReportLogEntity> list = entReportLogService.selectLastEightReportByTypeEntName(param.getName(), type, param.getCreditCode());
		List<RiskManageBizListResponseDTO> riskManageBizResponseDTO = ejbGenerator.convert(list, RiskManageBizListResponseDTO.class);
		if (null != list && list.size() > 0) {
			return new ApiResp().ok(param.getBizCode(), param.getSeqNum(), riskManageBizResponseDTO);
		}
		return new ApiResp().successNoData(param.getBizCode(), param.getSeqNum());
	}

	private ApiResp getRtnRiskPage(RiskManageBizPageReqDTO param, BizInterfaceTypeEnum type) {
		PageUtils page = entReportLogService.queryPage(param, type);
		if (null != page && page.getList().size() > 0) {
			List<RiskManageBizListResponseDTO> riskManageBizResponseDTO = ejbGenerator.convert(page.getList(), RiskManageBizListResponseDTO.class);
			page.setList(riskManageBizResponseDTO);
			return new ApiResp().ok(param.getBizCode(), param.getSeqNum(), page);
		}
		return new ApiResp().successNoData(param.getBizCode(), param.getSeqNum());
	}

}
