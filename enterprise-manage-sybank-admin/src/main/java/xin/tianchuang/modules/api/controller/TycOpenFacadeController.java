package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open368HolderDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open369InverstDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open370ChangeinfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open371AnnualreportDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open372BranchDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open384LawSuitDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open385CourtAnnouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open389ZhixinginfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open391AbnormalDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open404EquityInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open421MortgageInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open422OwnTaxDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open429BidsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open439TmDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open440PatentsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open441CopyRegDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open442IcpDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open733CopyRegWorksDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open767CreditChinaV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open777DishonestV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open782EmploymentsV2DTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open783OneKeyCDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.OpenBaseinfoSetDTO;
import xin.tianchuang.modules.api.biz.TycOpenBiz;

@RestController
@RequestMapping("/api/open/tyc")
@Api(value = "三方数据对接接口", tags = { "天眼查-三方数据的对接接口" })
@ApiIgnore
public class TycOpenFacadeController {

	private static Logger logger = LoggerFactory.getLogger(TycOpenFacadeController.class);

	@Resource
	private TycOpenBiz tycOpenBiz;

	// 1、工商信息
	@ResponseBody
	@PostMapping("/baseinfoV3")
	@ApiOperation(value = "获取企业基本信息（含主要人员）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
	})
	public R getBaseinfoV3(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		OpenBaseinfoSetDTO dto = tycOpenBiz.getBaseinfoV3(param);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@PostMapping("/holder")
	@ApiOperation(value = "股东信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getHolder(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open368HolderDTO> dto = tycOpenBiz.getHolder(param);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@PostMapping("/invest")
	@ApiOperation(value = "对外投资", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getInvest(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		ValidatorUtils.validateApiEntity(param);
		List<Open369InverstDTO> dto = tycOpenBiz.getInvest(param);
		return R.ok().put("data", dto);
	}

	@ResponseBody
	@PostMapping("/changeinfo")
	@ApiOperation(value = "变更记录", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getChangeinfo(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		ValidatorUtils.validateApiEntity(param);
		List<Open370ChangeinfoDTO> dto = tycOpenBiz.getChangeinfo(param);
		return R.ok().put("data", dto);
	}

	// test:中林集团江苏聚成木业
	@ResponseBody
	@PostMapping("/annualreport")
	@ApiOperation(value = "企业年报", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
	})
	public R getAnnualreport(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open371AnnualreportDTO> dto = tycOpenBiz.getAnnualReport(param);
		return R.ok().put("data", dto);
	}

	// test:宿迁市怡口商贸有限公司
	@ResponseBody
	@PostMapping("/branch")
	@ApiOperation(value = "分支机构", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getBranch(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open372BranchDTO> dto = tycOpenBiz.getBranch(param);
		return R.ok().put("data", dto);
	}

	// 2、知识产权

	// 作品著作权
	@ResponseBody
	@PostMapping("/copyRegWorks")
	@ApiOperation(value = "作品著作权", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCopyRegWorks(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open733CopyRegWorksDTO> dto = tycOpenBiz.getCopyRegWorks(param);
		return R.ok().put("data", dto);
	}

	// 网站备案
	@ResponseBody
	@PostMapping("/icp")
	@ApiOperation(value = " 网站备案", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getIcp(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open442IcpDTO> dto = tycOpenBiz.getIcp(param);
		return R.ok().put("data", dto);
	}

	// 著作权
	@ResponseBody
	@PostMapping("/copyReg")
	@ApiOperation(value = "著作权", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCopyReg(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open441CopyRegDTO> dto = tycOpenBiz.getCopyReg(param);
		return R.ok().put("data", dto);
	}

	// 专利
	@ResponseBody
	@PostMapping("/patents")
	@ApiOperation(value = "专利", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getPatents(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open440PatentsDTO> dto = tycOpenBiz.getPatents(param);
		return R.ok().put("data", dto);
	}

	// 商标信息
	@ResponseBody
	@PostMapping("/tm")
	@ApiOperation(value = "商标信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getTm(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open439TmDTO> dto = tycOpenBiz.getTm(param);
		return R.ok().put("data", dto);
	}

	// 3、经营风险
	// 行政处罚-信用中国（新版）
	@ResponseBody
	@PostMapping("/creditChinaV2")
	@ApiOperation(value = "行政处罚-信用中国（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCreditChinaV2(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open767CreditChinaV2DTO> dto = tycOpenBiz.getCreditChinaV2(param);
		return R.ok().put("data", dto);
	}

	// 欠税公告
	@ResponseBody
	@PostMapping("/ownTax")
	@ApiOperation(value = "欠税公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getOweTax(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open422OwnTaxDTO> dto = tycOpenBiz.getOweTax(param);
		return R.ok().put("data", dto);
	}

	// 动产抵押
	@ResponseBody
	@PostMapping("/mortgageInfo")
	@ApiOperation(value = "动产抵押", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getMortgageInfo(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open421MortgageInfoDTO> dto = tycOpenBiz.getMortgageInfo(param);
		return R.ok().put("data", dto);
	}

	// 股权出质
	@ResponseBody
	@PostMapping("/equityInfo")
	@ApiOperation(value = "股权出质", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getEquityInfo(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open404EquityInfoDTO> dto = tycOpenBiz.getEquityInfo(param);
		return R.ok().put("data", dto);
	}

	// 经营异常
	@ResponseBody
	@PostMapping("/abnormal")
	@ApiOperation(value = "经营异常", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getAbnormal(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open391AbnormalDTO> dto = tycOpenBiz.getAbnormal(param);
		return R.ok().put("data", dto);
	}

	// 4、司法风险
	// 失信人 test:宿迁丰农肥业有限公司
	@ResponseBody
	@PostMapping("/dishonest")
	@ApiOperation(value = "失信人", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getDishonest(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open777DishonestV2DTO> dto = tycOpenBiz.getDishonest(param);
		return R.ok().put("data", dto);
	}

	// 被执行人 test:宿迁丰农肥业有限公司
	@ResponseBody
	@PostMapping("/zhixinginfo")
	@ApiOperation(value = "被执信人", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getZhixinginfo(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open389ZhixinginfoDTO> dto = tycOpenBiz.getZhixinginfo(param);
		return R.ok().put("data", dto);
	}

	// 开庭公告 test:宿迁万泰服饰有限公司
	@ResponseBody
	@PostMapping("/ktannouncement")
	@ApiOperation(value = "开庭公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getKtannouncement(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open386KtannouncementDTO> dto = tycOpenBiz.getKtannouncement(param);
		return R.ok().put("data", dto);
	}

	// test:宿迁万泰服饰有限公司
	@ResponseBody
	@PostMapping("/courtAnnouncement")
	@ApiOperation(value = "法院公告", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getCourtAnnouncement(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open385CourtAnnouncementDTO> dto = tycOpenBiz.getCourtAnnouncement(param);
		return R.ok().put("data", dto);
	}

	// test:宿迁市苏通物流有限公司
	@ResponseBody
	@PostMapping("/lawSuit")
	@ApiOperation(value = "法律诉讼", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getLawSuit(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open384LawSuitDTO> dto = tycOpenBiz.getLawSuit(param);
		return R.ok().put("data", dto);
	}

	// 5、经营信息

	// 招投标 test:宿迁博兴再生资源有限公司
	@ResponseBody
	@PostMapping("/bids")
	@ApiOperation(value = "招投标", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getBids(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open429BidsDTO> dto = tycOpenBiz.getBids(param);
		return R.ok().put("data", dto);
	}

	// 招聘 test:宿迁尚爵贸易有限公司
	@ResponseBody
	@PostMapping("/employmentsV2")
	@ApiOperation(value = "招聘（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getEmploymentsV2(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open782EmploymentsV2DTO> dto = tycOpenBiz.getEmploymentsV2(param);
		return R.ok().put("data", dto);
	}

	// 6、舆情信息
	// 获取公司新闻列表 test:东山电子科技（泗阳）有限公司
	@ResponseBody
	@PostMapping("/news")
	@ApiOperation(value = "获取公司新闻列表", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
			@ApiImplicitParam(name = "pageNum", dataType = "int", paramType = "query"), //
	})
	public R getNews(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		List<Open446NewsDTO> dto = tycOpenBiz.getNews(param);
		return R.ok().put("data", dto);
	}

	// 7、上市信息
	// 企业简介
	@ResponseBody
	@PostMapping("/companyInfo")
	@ApiOperation(value = "企业简介", notes = "暂停用")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
			@ApiImplicitParam(name = "name", dataType = "int", value = "企业名称", paramType = "query"), //
	})
	@Deprecated
	public R getCompanyInfo(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		boolean flag = tycOpenBiz.getCompanyInfo(param);
		return R.ok().put("data", flag);
	}

	// 8、关系发现
	// 企业图谱（新版）
	@ResponseBody
	@PostMapping("/oneKey/c")
	@ApiOperation(value = "企业图谱（新版）", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
	})
	public R getOneKeyC(@RequestBody BizRequestParamDTO param) throws Exception {
		ValidatorUtils.validateApiEntity(param);
		Open783OneKeyCDTO dto = tycOpenBiz.getOneKeyC(param);
		return R.ok().put("data", dto);
	}

	// 9、其他信息
	// @ResponseBody
	// @PostMapping("/xgbaseinfoV2")
	// @ApiOperation(value = "香港公司、社会组织、律所", notes = "")
	// @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
	// @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query") })
	// public R getXgbaseinfoV2(@RequestBody BizRequestParamDTO param) throws Exception
	// {ValidatorUtils.validateApiEntity(param);
	// Open459XgbaseinfoV2DTO dto = tycOpenBiz.getXgbaseinfoV2(param);
	// return R.ok().put("data", dto);
	// }

	// @ResponseBody
	// @PostMapping("/baseinfoList")
	// @ApiOperation(value = "获取企业基本信息（含主要人员）", notes = "")
	// @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "公司id", dataType = "int", paramType = "query"), //
	// @ApiImplicitParam(name = "name", dataType = "String", value = "企业名称", paramType = "query"), //
	// })
	// public R baseinfoList() throws Exception {ValidatorUtils.validateApiEntity(param);
	// List<String> list = new ArrayList<>();
	// list.add("宿迁功赟装饰工程有限公司");
	// list.add("宿迁华億纺织有限公司");
	// list.add("宿迁市东昇物业管理有限公司");
	// list.add("宿迁市仁嚞服装有限公司");
	// list.add("宿迁市卉昳商贸有限公司");
	// list.add("宿迁市土垚康电子商务有限公司");
	// list.add("宿迁市子昉工贸有限公司");
	// list.add("宿迁市格丝嫚服饰有限公司");
	// list.add("宿迁市琻闽贸易有限公司");
	// list.add("宿迁市瞳眬商贸有限公司");
	// list.add("宿迁市苏璟商贸有限公司");
	// list.add("宿迁市辀到安装服务有限公司");
	// list.add("宿迁康芃人力资源有限公司");
	// list.add("宿迁德俽科技有限公司");
	// list.add("宿迁焱垚装饰材料有限公司");
	// list.add("宿迁燚笑园林绿化工程有限公司");
	// list.add("宿迁瑞昉商贸有限公司");
	// list.add("宿迁瑞紫玥泽商贸有限公司");
	// list.add("宿迁璟蚨缘商贸有限公司");
	// list.add("宿迁祥昇实业有限公司");
	// list.add("宿迁红昇沉水植物有限公司");
	// list.add("宿迁腾雲电子商务有限公司");
	// list.add("宿迁译赟电子商务有限公司");
	// list.add("宿迁隆萓商贸有限公司");
	// list.add("江苏企芃装饰工程有限公司");
	// list.add("江苏台昇家具有限公司");
	// list.add("江苏康芃劳保用品有限公司");
	// list.add("江苏志鋆机械科技有限公司");
	// list.add("江苏拓杬贸易有限公司");
	// list.add("江苏昇茂物流有限公司");
	// list.add("江苏晶昇源照明有限公司");
	// list.add("江苏永昇建设工程有限公司");
	// list.add("江苏润桹商贸有限公司");
	// list.add("江苏瑧尔商贸有限公司");
	// list.add("江苏璟天建设有限公司");
	// list.add("江苏璟天节能科技有限公司");
	// list.add("江苏瞾浦实业有限公司");
	// list.add("江苏萬德福生态农业发展有限公司");
	// list.add("江苏薪昇新材料有限公司");
	// list.add("江苏赟创电子商务有限公司");
	// list.add("江苏轩祐食品有限公司");
	// list.add("江苏长昇塑业有限公司");
	// list.add("江苏骉语电子科技有限公司");
	// list.add("江苏骎骎电子商务有限公司");
	// list.add("泗阳东之昇工贸有限公司");
	// list.add("泗阳乾昇商贸有限公司");
	// list.add("泗阳京芃汽贸有限公司");
	// list.add("泗阳县俊巴萬文化传媒有限公司");
	// list.add("泗阳县华宬物业管理有限公司");
	// list.add("泗阳县华昇置业有限公司");
	// list.add("泗阳县昌璟鞋业有限公司");
	// list.add("泗阳县梓芃纺织品有限公司");
	// list.add("泗阳县珺亮商贸有限公司");
	// list.add("泗阳县珺瑒商贸有限公司");
	// list.add("泗阳县璟晟电子商务有限公司");
	// list.add("泗阳县羴祥养羊专业合作社");
	// list.add("泗阳县鑫昇五金有限公司");
	// list.add("泗阳垚乾星汽车销售服务有限公司");
	// list.add("泗阳垚达贸易有限公司");
	// list.add("泗阳孞翼电子商务有限公司");
	// list.add("泗阳宏昇商贸有限公司");
	// list.add("泗阳日昇昌商贸有限公司");
	// list.add("泗阳昇熙跆拳道有限公司");
	// list.add("泗阳昇顺贸易有限公司");
	// list.add("泗阳江瑄实业有限公司");
	// list.add("泗阳炜烜电子商务有限公司");
	// list.add("泗阳煜珅电子科技有限公司");
	// list.add("泗阳玥源商贸有限公司");
	// list.add("泗阳玥皓贸易有限公司");
	// list.add("泗阳璟润光伏材料有限公司");
	// list.add("泗阳璟琰电子商务有限公司");
	// list.add("泗阳璟鸿装饰工程有限公司");
	// list.add("泗阳腾昇电子科技有限公司");
	// list.add("泗阳馫馫食品有限公司");
	// list.add("泗阳驰宬物流有限公司");
	//
	// List<Open365BaseinfoV3DTO> dtos = new ArrayList<>();
	// for (String name : list) {
	// BizRequestParamDTO param = new BizRequestParamDTO();
	// param.setName(name);
	// OpenBaseinfoSetDTO setDto = tycOpenBiz.getBaseinfoV3(param);
	// Open365BaseinfoV3DTO dto = new Open365BaseinfoV3DTO();
	// BeanUtils.copyProperties(setDto, dto);
	// dtos.add(dto);
	// }
	// return R.ok().put("data", dtos);
	// }
}
