package xin.tianchuang.modules.api.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.enums.*;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.utils.TycRuleUtils;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCompanyInfoDTO;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.*;
import xin.tianchuang.modules.api.bean.imports.ImportParseBaseDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.spider.entity.*;
import xin.tianchuang.modules.spider.service.*;
import xin.tianchuang.modules.sys.controller.AbstractController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * TODO 本地文件导入
 * 
 * @author idea
 * @version 1.0
 * @since 2018年10月29日 上午11:26
 **/
@RestController
@RequestMapping("/api/import")
@ApiIgnore
@Deprecated
public class EntImportController extends AbstractController {

	private static final Splitter splitter = Splitter.on(",");

	private static final String rootPath = "M://workspace//enterprise-manage-sybank//project//02_数据处理//数据接口导入//12106_26_all";

	@Autowired
	private EntListInfoService entListInfoService;
	@Autowired
	private EntBaseInfoService entBaseInfoService;
	@Autowired
	private EntBaseSocialInfoService entBaseSocialInfoService;
	@Autowired
	private EntStaffInfoService entStaffInfoService;
	@Autowired
	private EntStaffPositionService entStaffPositionService;

	@Autowired
	private EntBaseFoundationInfoService entBaseFoundationInfoService;
	@Autowired
	private EntBaseInstitutionInfoService entBaseInstitutionInfoService;
	@Autowired
	private EntBaseLawInfoService entBaseLawInfoService;

	/**
	 * 企业名录数据excel导入
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/list")
	public R list(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {

		return R.ok();
	}

	/**
	 * 获取企业基本信息，需要回写企业名录表
	 * 
	 * @throws IOException
	 */
	@GetMapping("/baseinfo")
	public R baseinfoV3(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
		if (StringUtils.isBlank(path)) {
			path = rootPath + "//获取企业基本信息含主要人员//";
			fileName = "callSuccessful.txt_file3.txt";
		}
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				// 这里处理一行字符串
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<Open365BaseinfoV3DTO>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<Open365BaseinfoV3DTO>> result = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<Open365BaseinfoV3DTO> dtos = result.getResult();
				Integer status = dtos.getStatus();
				String name = result.getCname();

				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					Open365BaseinfoV3DTO data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}

					EntBaseInfoEntity dbBaseInfoEntity = entBaseInfoService.selectOneByEntName(name);
					Integer entId = null; // 企业id
					String creditCode = null;
					EntBaseInfoEntity baseInfoEntity = null;
					if (null == dbBaseInfoEntity) {
						EntListInfoEntity entity = entListInfoService.selectByNameCreditCode(name, null);
						if (null == entity) {
							entity = new EntListInfoEntity();
							BeanUtils.copyProperties(data, entity);
							entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
							entity.setCollectDate(new Date());
							entity.setBaseinfoFlag(YesOrNoEnum.YES.key());
							entListInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);
							entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
							entity.setCollectDate(new Date());
							entity.setBaseinfoFlag(YesOrNoEnum.YES.key());
							entListInfoService.updateById(entity);
						}
						entId = entity.getId();

						baseInfoEntity = new EntBaseInfoEntity();
						BeanUtils.copyProperties(data, baseInfoEntity);
						baseInfoEntity.setEntId(entity.getId());
						baseInfoEntity.setEntName(name);
						entBaseInfoService.insert(baseInfoEntity);
					} else {
						EntListInfoEntity entity = entListInfoService.selectByNameEntityType(name, EntEntityTypeEnum.COMPANY.key());
						BeanUtils.copyProperties(data, entity);
						entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
						entity.setCollectDate(new Date());
						entListInfoService.updateById(entity);
						entId = entity.getId();

						BeanUtils.copyProperties(data, dbBaseInfoEntity);
						entBaseInfoService.updateById(dbBaseInfoEntity);
					}

					Open365BaseinfoV3StaffDTO open365BaseinfoV3StaffDTO = data.getStaffList();
					if (null != open365BaseinfoV3StaffDTO && null != open365BaseinfoV3StaffDTO.getResult() && open365BaseinfoV3StaffDTO.getResult().size() > 0) {
						// 先删除 在插入
						String entName = data.getName();
						entStaffInfoService.deleteByEntName(entName);

						List<String> typeJoinLs = null;
						for (Open365BaseinfoV3StaffChildDTO staffChild : open365BaseinfoV3StaffDTO.getResult()) {
							EntStaffInfoEntity staffInfoEntity = new EntStaffInfoEntity();
							BeanUtils.copyProperties(staffChild, staffInfoEntity);

							staffInfoEntity.setEntId(entId);
							staffInfoEntity.setEntName(entName);
							staffInfoEntity.setCreditCode(creditCode);

							typeJoinLs = staffChild.getTypeJoin();
							String str = Joiner.on(",").join(typeJoinLs);
							staffInfoEntity.setTypeJoin(str);
							boolean insertFlag = entStaffInfoService.insert(staffInfoEntity);

							if (insertFlag) {
								entStaffPositionService.deleteByName(entName, staffInfoEntity.getName());
								for (String type : typeJoinLs) {

									EntStaffPositionEntity entity = new EntStaffPositionEntity();

									entity.setEntId(entId);
									entity.setEntName(entName);
									entity.setCreditCode(creditCode);
									entity.setName(staffInfoEntity.getName());
									entity.setPositon(type);
									entStaffPositionService.insert(entity);
								}
							}
						}
					}

				} else if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) { // 查询成功 无数据

					EntListInfoEntity entity = new EntListInfoEntity();
					entity.setEntityType(EntEntityTypeEnum.COMPANY.key());
					entity.setCollectDate(new Date());
					entity.setBaseinfoFlag(YesOrNoEnum.NO.key());
					entListInfoService.insert(entity);

				}

				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	// /**
	// * 股东信息
	// *
	// * @throws IOException
	// */
	// @GetMapping("/holder")
	// public R holder(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 对外投资
	// *
	// * @throws IOException
	// */
	// @GetMapping("/inverst")
	// public R inverst(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 变更记录
	// *
	// * @throws IOException
	// */
	// @GetMapping("/changeinfo")
	// public R changeinfo(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 分支机构
	// *
	// * @throws IOException
	// */
	// @GetMapping("/branch")
	// public R branch(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 法律诉讼
	// *
	// * @throws IOException
	// */
	// @GetMapping("/law_suit")
	// public R lawSuit(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 法院公告
	// *
	// * @throws IOException
	// */
	// @GetMapping("/court_announcement")
	// public R courtAnnouncement(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 失信人（新版）
	// *
	// * @throws IOException
	// */
	// @GetMapping("/dishonest_v2")
	// public R dishonestV2(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 被执行人
	// *
	// * @throws IOException
	// */
	// @GetMapping("/zhixinginfo")
	// public R zhixinginfo(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 开庭公告
	// *
	// * @throws IOException
	// */
	// @GetMapping("/ktannouncement")
	// public R ktannouncement(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 招投标
	// *
	// * @throws IOException
	// */
	// @GetMapping("/bids")
	// public R bids(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 招聘（新版）
	// *
	// * @throws IOException
	// */
	// @GetMapping("/employments_v2")
	// public R employmentsV2(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 商标信息
	// *
	// * @throws IOException
	// */
	// @GetMapping("/tm")
	// public R tm(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 专利
	// *
	// * @throws IOException
	// */
	// @GetMapping("/patents")
	// public R patents(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 作品著作权
	// *
	// * @throws IOException
	// */
	// @GetMapping("/copy_reg_works")
	// public R copyRegWorks(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 著作权
	// *
	// * @throws IOException
	// */
	// @GetMapping("/copy_reg")
	// public R copyReg(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 网站备案
	// *
	// * @throws IOException
	// */
	// @GetMapping("/icp")
	// public R icp(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 获取公司新闻列表
	// *
	// * @throws IOException
	// */
	// @GetMapping("/news")
	// public R news(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 企业图谱（新版）
	// *
	// * @throws IOException
	// */
	// @GetMapping("/one_key_c")
	// public R oneKeyC(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException
	// {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 371-企业年报
	// *
	// * @throws IOException
	// */
	// @GetMapping("/annualreport")
	// public R annualreport(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	// /**
	// * 企业简介
	// *
	// * @throws IOException
	// */
	// @GetMapping("/company_info")
	// public R companyInfo(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws
	// IOException {
	// if (Strings.isNullOrEmpty(path)) {
	// path = rootPath + "//获取企业基本信息（含主要人员）//";
	// fileName = "callSuccessful.txt_file3.txt";
	// }
	// File file = new File(path, fileName);
	// Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
	// public boolean processLine(String line) throws IOException {
	// System.out.println(line);
	// splitter.split(line).forEach(System.out::println);
	// // 这里处理一行字符串
	// return true;// 如果是false，则会中断读取操作
	// }
	//
	// public String getResult() {
	// return null;// 返回的结果。可以自定义
	// }
	// });
	//
	// return R.ok("导入成功");
	// }
	//
	/**
	 * 香港公司、社会组织、律所
	 * 
	 * @throws IOException
	 */
	@GetMapping("/xgbaseinfo_v2")
	public R xgbaseinfoV2(@RequestParam("path") String path, @RequestParam("fileName") String fileName) throws IOException {
		if (StringUtils.isBlank(path)) {
			path = rootPath + "//获取企业基本信息（含主要人员）//";
			fileName = "callSuccessful.txt_file3.txt";
		}
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				logger.info("企业信息数据 response：{}", apiData);
				//
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<Open459XgbaseinfoV2DTO>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<Open459XgbaseinfoV2DTO>> results = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<Open459XgbaseinfoV2DTO> dtos = results.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					Open459XgbaseinfoV2DTO data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}
					Integer entityType = data.getEntityType();
					String entName = results.getCname();
					EntListInfoEntity listInfoEntity = entListInfoService.selectByNameEntityType(entName, entityType);

					List<String> phoneList = data.getPhoneList();
					String phoneStr = Joiner.on(",").join(phoneList);
					if (null == listInfoEntity) {
						listInfoEntity = new EntListInfoEntity();
						BeanUtils.copyProperties(data, listInfoEntity);

						listInfoEntity.setPhoneList(phoneStr);

						entListInfoService.insert(listInfoEntity);
					} else {
						BeanUtils.copyProperties(data, listInfoEntity);
						listInfoEntity.setPhoneList(phoneStr);
						entListInfoService.updateById(listInfoEntity);
					}
					// TODO 法人信息存储
					List<Open459XgbaseinfoV2LegalInfoDTO> legalInfo = data.getLegalInfo();

					if (EntEntityTypeEnum.COMPANY.key() == entityType) {
						EntBaseInfoEntity entity = entBaseInfoService.selectOneByEntName(entName);
						if (null == entity) {
							entity = new EntBaseInfoEntity();
							BeanUtils.copyProperties(data, entity);

							entity.setPhoneList(phoneStr);

							entBaseInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);

							entity.setPhoneList(phoneStr);

							entBaseInfoService.updateById(entity);
						}
						// } else if (EntEntityTypeEnum.HK.key() == entityType) {
						// EntBaseHkInfoEntity entBaseHkInfoEntity = new EntBaseHkInfoEntity();
					} else if (EntEntityTypeEnum.SOCIAL.key() == entityType) {
						EntBaseSocialInfoEntity entity = entBaseSocialInfoService.selectOneByName(entName);
						if (null == entity) {
							entity = new EntBaseSocialInfoEntity();
							BeanUtils.copyProperties(data, entity);
							entBaseSocialInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);
							entBaseSocialInfoService.updateById(entity);
						}
					} else if (EntEntityTypeEnum.LAW.key() == entityType) {

						EntBaseLawInfoEntity entity = entBaseLawInfoService.selectOneByName(entName);
						if (null == entity) {
							entity = new EntBaseLawInfoEntity();
							BeanUtils.copyProperties(data, entity);
							entity.setPhoneList(phoneStr);
							entBaseLawInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);
							entity.setPhoneList(phoneStr);
							entBaseLawInfoService.updateById(entity);
						}

					} else if (EntEntityTypeEnum.INSTITUTION.key() == entityType) {
						EntBaseInstitutionInfoEntity entity = entBaseInstitutionInfoService.selectOneByName(entName);
						if (null == entity) {
							entity = new EntBaseInstitutionInfoEntity();
							BeanUtils.copyProperties(data, entity);
							entBaseInstitutionInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);
							entBaseInstitutionInfoService.updateById(entity);
						}

					} else if (EntEntityTypeEnum.FOUNDATION.key() == entityType) {
						EntBaseFoundationInfoEntity entity = entBaseFoundationInfoService.selectOneByName(entName);
						if (null == entity) {
							entity = new EntBaseFoundationInfoEntity();
							BeanUtils.copyProperties(data, entity);
							entBaseFoundationInfoService.insert(entity);
						} else {
							BeanUtils.copyProperties(data, entity);
							entBaseFoundationInfoService.updateById(entity);
						}
					}

				}
				// 这里处理一行字符串
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	@GetMapping("/export")
	public void testExportEntList() throws Exception {
		Wrapper<EntListInfoEntity> ew = new EntityWrapper<EntListInfoEntity>();
		// 企业名称 统一社会信用代码 法人姓名 企业性质 注册资金 成立时间 行业门类 注册地址 是否上市 区域
		List<EntListInfoEntity> list = entListInfoService.selectList(ew);
		File file = new File("D:\\test.txt");
		Files.write("企业名称	统一社会信用代码	法人姓名	企业性质	注册资金	成立时间	行业门类	是否上市	区域	地址\n".getBytes(), file);

		for (EntListInfoEntity entListInfoEntity : list) {
			LoanBizCompanyInfoDTO dto = new LoanBizCompanyInfoDTO();
			BeanUtils.copyProperties(entListInfoEntity, dto);

			String area = ""; // 区域
			if (StringUtils.isNotBlank(entListInfoEntity.getRegLocation())) {
				area = TycRuleUtils.getArea(entListInfoEntity.getRegLocation());
			} else {
				if (StringUtils.isNoneBlank(entListInfoEntity.getName())) {
					area = TycRuleUtils.getArea(entListInfoEntity.getName());
				}
			}

			if (StringUtils.isNotBlank(area)) {
				dto.setArea(area);
			}
				Files.append(dto.toString(), file, Charsets.UTF_8);

		}

	}

	/**
	 * from EntPublicOpinionInfoController
	 * Created by lee on 2019/3/1.
	 * 4.1.2.6.舆情信息
	 * Public opinion information
	 */

	private ExecutorService executorService = Executors.newFixedThreadPool(5);
	//446 - 获取公司新闻列表
	@Autowired
	private EntNewsInfoService entNewsInfoService;
	/**
	 * 446 - 获取公司新闻列表
	 * 1.先5个线程跑了大概一个半小时 问题数据->bak.txt
	 * 2.大概有200行 其内容中有引号没有转译破坏了json结构所以手动处理大概1小时bak.json
	 * 3。跑bak.json-->问题数据bak1.json  20多条
	 * 4.企业名称有繁体字啥的名称不对 根据ccode找到正确的名称再跑 bak2.json 4条
	 * 5，转译小问题处理掉
	 *
	 * @throws IOException
	 */
	@RequestMapping("/446news")
	public R news() throws IOException {
		String path = rootPath + "/获取公司新闻列表/";
		String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="bak2.json";

		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "wenti.json")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							// 这里处理一行字符串
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>>> result = gson.fromJson(apiData, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>> dtos = result.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}

							String entName = result.getCname();
							// 保存数据
							List<Open446NewsDTO> items = dtos.getData().getItems();
							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							if (null != items && items.size() > 0) {
								// 先删除 在新增
								entNewsInfoService.deleteByEntName(entName);
								for (Open446NewsDTO item : items) {
									EntNewsInfoEntity entity = new EntNewsInfoEntity();
									BeanUtils.copyProperties(item, entity);

									entity.setEntId(listInfoEntity.getId());
									entity.setEntName(entName);
									entity.setCreditCode(listInfoEntity.getCreditCode());

									entNewsInfoService.insert(entity);
								}
							}
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
							try {
								bw.write(apiData);
								bw.newLine();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				});
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}


	/**
	 * from EntOneKeyController
	 */
	@Autowired
	private EntRefNodesService entRefNodesService;
	@Autowired
	private EntRefRelationshipsService entRefRelationshipsService;

	/**
	 * 企业图谱（新版）
	 *
	 * @throws IOException
	 */
	@GetMapping("/one_key_c")
	public R oneKeyC(String file1, String file2) throws IOException {
		String path = rootPath + "/企业图谱新版/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, file1);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file2)));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<Open783OneKeyCDTO>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<Open783OneKeyCDTO>> wrapper = gson.fromJson(line, jsonType);
							TycApiRespDTO<Open783OneKeyCDTO> dtos = wrapper.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}
							Integer status = dtos.getStatus();
							String uuid = dtos.getSeqNum();
							String message = dtos.getMessage();
							if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
								Open783OneKeyCDTO data = dtos.getData();
								if (null == data) {
									throw new SpiderException("data节点数据返回为空");
								}
								// 保存数据
								// 先删除 在新增

								EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(wrapper.getCname());
								if (null == listInfoEntity) {
									throw new SpiderException("系统异常，请稍后再试");
								}

								String entName = listInfoEntity.getName();

								List<Open783OneKeyCNodesDTO> nodes = data.getNodes();
								if (null != nodes && nodes.size() >= 1) {
									entRefNodesService.deleteByEntName(entName);
									for (Open783OneKeyCNodesDTO dto : nodes) {
										EntRefNodesEntity entity = new EntRefNodesEntity();
										BeanUtils.copyProperties(dto, entity);

										Open783OneKeyCNodesPropertiesDTO properties = dto.getProperties();
										if (null != properties) {
											BeanUtils.copyProperties(properties, entity);
										}
										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());

										List<String> labelsList = dto.getLabels();
										String labels = Joiner.on(",").join(labelsList);
										entity.setLabels(labels);

										entRefNodesService.insert(entity);

									}

								}

								List<Open783OneKeyCRelationshipsDTO> relationships = data.getRelationships();
								if (null != nodes && nodes.size() >= 1) {
									entRefRelationshipsService.deleteByEntName(entName);
									for (Open783OneKeyCRelationshipsDTO dto : relationships) {
										EntRefRelationshipsEntity entity = new EntRefRelationshipsEntity();
										BeanUtils.copyProperties(dto, entity);

										Open783OneKeyCNodesRelationshipsPropertiesDTO properties = dto.getProperties();
										if (null != properties) {
											BeanUtils.copyProperties(properties, entity);
											List<String> labelsList = properties.getLabels();

											String labels = Joiner.on(",").join(labelsList);
											entity.setLabels(labels);
										}

										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());

										entRefRelationshipsService.insert(entity);

									}
								}
							}
						} catch (Exception e) {
							logger.error("数据异常", e);
							try {
								bw.write(line);
								bw.newLine();
							} catch (IOException e1) {
								logger.error("写文件异常", e1);
							}
						}
					}
				});
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * from EntManagementInformationController
	 * Created by lee on 2019/2/28.
	 * 4.1.2.4.经营信息
	 * Management information
	 */
	//429-招投标
	@Autowired
	private EntBidsInfoService entBidsInfoService;

	//782-- 招聘（新版）
	@Autowired
	private EntEmployInfoService entEmployInfoService;


	/**
	 * 429 - 招投标
	 *
	 * 先跑一遍  字段扩充 conlist 换成clob
	 * 结构问题 多了一个[] ---> 找到换掉  有两种 },[{"publishTime"  和 }],[{"publishTime" 吧 ]] ---> ]  25行
	 * 网页内容找出来 复制到工具转义在回来处理 16行
	 * @throws IOException
	 */
	@RequestMapping("/429bids")
	public R bids() throws IOException {
		String path = rootPath + "/招投标/";
		String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="add.txt";

		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "wenti.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				executorService.execute(new Runnable() {
											@Override
											public void run() {
												try {
													// 这里处理一行字符串
													Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
													Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>>>>(){}.getType(); //
													ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>>> result = gson.fromJson(apiData, jsonType);
													TycApiRespDTO<ResponsePageNumResultDTO<Open429BidsDTO>> dtos = result.getResult();
													if (dtos == null) { // 成功
														throw new SpiderException("数据返回为空");
													}

													String entName = result.getCname();
													// 保存数据
													List<Open429BidsDTO> items = dtos.getData().getItems();
													EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
													if (null == listInfoEntity) {
														throw new SpiderException("系统异常，请稍后再试");
													}
													if (null != items && items.size() > 0) {

														entBidsInfoService.deleteByEntName(entName);

														List<String> connLs = null;
														for (Open429BidsDTO item : items) {
															EntBidsInfoEntity entity = new EntBidsInfoEntity();
															BeanUtils.copyProperties(item, entity);

															entity.setEntId(listInfoEntity.getId());
															entity.setEntName(entName);
															entity.setCreditCode(listInfoEntity.getCreditCode());

															connLs = item.getConnList();
															String connStr = Joiner.on(",").join(connLs);
															entity.setConnList(connStr);

															entBidsInfoService.insert(entity);
														}
													}
												} catch (Exception e) {
													logger.error(e.getMessage(), e);
													try {
														bw.write(apiData);
														bw.newLine();
													} catch (IOException e1) {
														e1.printStackTrace();
													}
													e.printStackTrace();
												}
											}
										}
				);
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}


	/**
	 * 782 - 招聘（新版）
	 *
	 * 字段超长 所以整体表字段都扩大了
	 * 后面还有超长的 又一次扩大部分数据
	 * 文件里面"/"的处理 识别为转义字符了
	 * 文件有些""的处理
	 * @throws IOException
	 */
	@RequestMapping("/782employmentsV2")
	public R employmentsV2() throws IOException {
		String path = rootPath + "/招聘新版/";
		String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="add.txt";

		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "wenti.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				try {
					// 这里处理一行字符串
					Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
					Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>>>>() {
					}.getType(); //
					ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>>> result = gson.fromJson(apiData, jsonType);
					TycApiRespDTO<ResponsePageNumResultDTO<Open782EmploymentsV2DTO>> dtos = result.getResult();
					if (dtos == null) { // 成功
						throw new SpiderException("数据返回为空");
					}

					String entName = result.getCname();
					// 保存数据
					List<Open782EmploymentsV2DTO> items = dtos.getData().getItems();
					EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
					if (null == listInfoEntity) {
						throw new SpiderException("系统异常，请稍后再试");
					}
					if (null != items && items.size() > 0) {

						entEmployInfoService.deleteByEntName(entName);
						for (Open782EmploymentsV2DTO item : items) {
							EntEmployInfoEntity entity = new EntEmployInfoEntity();
							BeanUtils.copyProperties(item, entity);

							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());


							entEmployInfoService.insert(entity);

						}
					}
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					try {
						bw.write(apiData);
						bw.newLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}


	/**
	 * from EntJudicialRiskController
	 * Created by lee on 2019/2/28.
	 * 4.1.2.2.司法风险
	 * Judicial Risk
	 */
	//384-法律诉讼
	@Autowired
	private EntLawsuitInfoService entLawsuitInfoService;

	//385-法院公告
	@Autowired
	private EntCourtAnnounceInfoService entCourtAnnounceInfoService;
	@Autowired
	private EntCourtAnnounceCompanyService entCourtAnnounceCompanyService;

	//386-开庭公告
	@Autowired
	private EntKtannounceInfoService entKtannounceInfoService;
	@Autowired
	private EntKtannouncePeopleInfoService entKtannouncePeopleInfoService;


	//777 - 失信人（新版）
	@Autowired
	private EntDishonestInfoService entDishonestInfoService;
	@Autowired
	private EntDishonestStaffService entDishonestStaffService;


	//389-被执行人
	@Autowired
	private EntZhixingInfoService entZhixingInfoService;


	/**
	 * 384 - 法律诉讼
	 *
	 * @throws IOException
	 */
	@RequestMapping("/384lawSuit")
	public R lawSuit() throws IOException {
		String path = rootPath + "/法律诉讼/";
		String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="test1.json";
		String file2 = "error.txt";
		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file2)));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData)  {
				try {
					// 这里处理一行字符串
					Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
					Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>>>>() {
					}.getType(); //
					ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>>> result = gson.fromJson(apiData, jsonType);
					TycApiRespDTO<ResponsePerPageNumResultDTO<Open384LawSuitDTO>> dtos = result.getResult();
					if (dtos == null) { // 成功
						throw new SpiderException("数据返回为空");
					}

					String entName = result.getCname();
					// 保存数据
					List<Open384LawSuitDTO> items = dtos.getData().getItems();
					EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
					if (null == listInfoEntity) {
						throw new SpiderException("系统异常，请稍后再试");
					}
					// 保存数据

					if (null == items || items.isEmpty()) {
						throw new SpiderException("系统异常，请稍后再试");
					}
					entLawsuitInfoService.deleteByEntName(entName);
					List<String> connLs = null;
					List<EntLawsuitInfoEntity> list = new ArrayList<EntLawsuitInfoEntity>(items.size());
					for (Open384LawSuitDTO item : items) {

						EntLawsuitInfoEntity entity = new EntLawsuitInfoEntity();
						BeanUtils.copyProperties(item, entity);
						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

						connLs = item.getConnList();
						String connStr = Joiner.on(",").join(connLs);
						entity.setConnList(connStr);
						list.add(entity);
					}
					entLawsuitInfoService.insertBatch(list);
				}catch (Exception e){
					logger.error(apiData, e);
					try {
						bw.write(apiData);
						bw.newLine();
						bw.flush();
					} catch (IOException e1) {
						logger.error("写文件异常", e1);
					}
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}

	/**
	 * 385 - 法院公告
	 * courtAnnouncement
	 */
	@RequestMapping("/385courtAnnouncement")
	public R courtAnnouncement() throws IOException {
		String path = rootPath + "/法院公告/";
		String fileName = "callSuccessful.txt_file3.txt";
//           String fileName="test1.json";

		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				// 这里处理一行字符串
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>>> result = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open385CourtAnnouncementDTO>> dtos = result.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}
				String entName = result.getCname();
				// 保存数据
				List<Open385CourtAnnouncementDTO> items = dtos.getData().getItems();
				EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
				if (null == listInfoEntity) {
					throw new SpiderException("系统异常，请稍后再试");
				}
				if (null != items && items.size() > 0) {
					// 先删除 在新增
					entCourtAnnounceInfoService.deleteByEntName(entName);
					for (Open385CourtAnnouncementDTO item : items) {

						EntCourtAnnounceInfoEntity entity = new EntCourtAnnounceInfoEntity();
						BeanUtils.copyProperties(item, entity);

						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

//                        try {
						entCourtAnnounceInfoService.insert(entity);
//                        } catch (Exception e) {
//                            logger.error(e.getMessage(),e);
//                            e.printStackTrace();
//                        }

						List<Open385CompanyListDTO> companyList = item.getCompanyList();
						if (null != companyList && companyList.size() > 0) {
//                            List<EntCourtAnnounceCompanyEntity> list= new ArrayList<>();
							Long tableId = entity.getTableId();

							entCourtAnnounceCompanyService.deleteByTycTableId(tableId);

							for (Open385CompanyListDTO company : companyList) {
								EntCourtAnnounceCompanyEntity companyEntity = new EntCourtAnnounceCompanyEntity();
								BeanUtils.copyProperties(company, companyEntity);

								companyEntity.setTableId(tableId);

//                                list.add(companyEntity);
//                                try {
								entCourtAnnounceCompanyService.insert(companyEntity);
//                                } catch (Exception e) {
//                                    logger.error(e.getMessage(),e);
//                                    e.printStackTrace();
//                                }
							}
//                            try {
//                                entCourtAnnounceCompanyService.insertBatch(list);
//                            } catch (Exception e) {
//                                logger.error(e.getMessage(),e);
//                                e.printStackTrace();
//                            }
						}
					}
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}

	/**
	 * 386 - 开庭公告
	 * ktannouncement
	 */
	@RequestMapping("/386ktannouncement")
	public R ktannouncement() throws IOException {
		String path = rootPath + "/开庭公告/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				// 这里处理一行字符串
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>>> result = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<ResponsePerPageNumResultDTO<Open386KtannouncementDTO>> dtos = result.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				String entName = result.getCname();
				// 保存数据
				List<Open386KtannouncementDTO> items = dtos.getData().getItems();
				EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
				if (null == listInfoEntity) {
					throw new SpiderException("系统异常，请稍后再试");
				}
				if (null != items && items.size() > 0) {

					entKtannounceInfoService.deleteByEntName(entName);
					List<String> connLs = null;
					for (Open386KtannouncementDTO item : items) {

						EntKtannounceInfoEntity entity = new EntKtannounceInfoEntity();
						BeanUtils.copyProperties(item, entity);


						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

						connLs = item.getConnList();
						String connStr = Joiner.on(",").join(connLs);
						entity.setConnList(connStr);

//                        try {
						entKtannounceInfoService.insert(entity);
//                        } catch (Exception e) {
//                            logger.error(e.getMessage(),e);
//                            e.printStackTrace();
//                        }

						List<Open386KtannouncementPlaintiffDTO> plaintiffLs = item.getPlaintiff();
						String tableId = entity.getTableId();
						if (null != plaintiffLs && plaintiffLs.size() > 0) {
							entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
							for (Open386KtannouncementPlaintiffDTO plaintiff : plaintiffLs) {
								EntKtannouncePeopleInfoEntity plaintiffEntity = new EntKtannouncePeopleInfoEntity();
								BeanUtils.copyProperties(plaintiff, plaintiffEntity);
								plaintiffEntity.setPeopleType(EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
								plaintiffEntity.setTableId(Long.valueOf(tableId));

//                                try {
								entKtannouncePeopleInfoService.insert(plaintiffEntity);
//                                } catch (Exception e) {
//                                    logger.error(e.getMessage(),e);
//                                    e.printStackTrace();
//                                }
							}
						}

						List<Open386KtannouncementDefendantDTO> defendantLs = item.getDefendant();
						if (null != defendantLs && defendantLs.size() > 0) {
							entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.DEFENDANT.key());
							for (Open386KtannouncementDefendantDTO defendant : defendantLs) {
								EntKtannouncePeopleInfoEntity defendantEntity = new EntKtannouncePeopleInfoEntity();
								BeanUtils.copyProperties(defendant, defendantEntity);
								defendantEntity.setPeopleType(EntKtannouncePeopleTypeEnum.DEFENDANT.key());
								defendantEntity.setTableId(Long.valueOf(tableId));

//                                try {
								entKtannouncePeopleInfoService.insert(defendantEntity);
//                                } catch (Exception e) {
//                                    logger.error(e.getMessage(),e);
//                                    e.printStackTrace();
//                                }
							}
						}
					}
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");

	}

	/**
	 * 777 - 失信人（新版）
	 */
	@RequestMapping("/777dishonestV2")
	public R dishonestV2() throws IOException {
		String path = rootPath + "/失信人（新版）/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				// 这里处理一行字符串
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>>> result = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open777DishonestV2DTO>> dtos = result.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				String entName = result.getCname();
				// 保存数据
				List<Open777DishonestV2DTO> items = dtos.getData().getItems();
				EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
				if (null == listInfoEntity) {
					throw new SpiderException("系统异常，请稍后再试");
				}
				if (null != items && items.size() > 0) {
					entDishonestInfoService.deleteByEntName(entName);

					for (Open777DishonestV2DTO item : items) {

						EntDishonestInfoEntity entity = new EntDishonestInfoEntity();
						BeanUtils.copyProperties(item, entity);

						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

						try {
							entDishonestInfoService.insert(entity);
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
							e.printStackTrace();
						}

						List<Open777DishonestV2StaffDTO> staffLs = item.getStaff();
						if (null != staffLs && staffLs.size() >= 1) {
							entDishonestStaffService.deleteByEntNameAndCasecode(entName,entity.getCasecode());
							for (Open777DishonestV2StaffDTO staff : staffLs) {
								EntDishonestStaffEntity entDishonestStaffEntity = new EntDishonestStaffEntity();
								BeanUtils.copyProperties(staff, entDishonestStaffEntity);

								entDishonestStaffEntity.setEntId(listInfoEntity.getId());
								entDishonestStaffEntity.setEntName(entName);
								entDishonestStaffEntity.setCasecode(entity.getCasecode());
								entDishonestStaffEntity.setCreditCode(listInfoEntity.getCreditCode());

								try {
									entDishonestStaffService.insert(entDishonestStaffEntity);
								} catch (Exception e) {
									logger.error(e.getMessage(), e);
									e.printStackTrace();
								}
							}
						}
					}
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");

	}


	/**
	 * 389 - 被执行人
	 */
	@RequestMapping("/389zhixinginfo")
	public R zhixinginfo() throws IOException {
		String path = rootPath + "/被执行人/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				// 这里处理一行字符串
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>>> result = gson.fromJson(apiData, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open389ZhixinginfoDTO>> dtos = result.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				String entName = result.getCname();
				// 保存数据
				List<Open389ZhixinginfoDTO> items = dtos.getData().getItems();
				EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
				if (null == listInfoEntity) {
					throw new SpiderException("系统异常，请稍后再试");
				}

				// 保存数据
				if (null != items && items.size() > 0) {
					entZhixingInfoService.deleteByEntName(entName);
					for (Open389ZhixinginfoDTO item : items) {

						EntZhixingInfoEntity entity = new EntZhixingInfoEntity();
						BeanUtils.copyProperties(item, entity);

						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

//                        try {
						entZhixingInfoService.insert(entity);
//                        } catch (Exception e) {
//                            logger.error(e.getMessage(), e);
//                            e.printStackTrace();
//                        }
					}
				}
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");

	}

	/**
	 * from EntImportOperationRiskController
	 * Created by yp-tc-m-7179 on 2019/2/28.
	 * 经营异常数据导入
	 */

	@Autowired
	private EntAbnormalInfoService entAbnormalInfoService;

	@Autowired
	private EntPunishCreditChinaService entPunishCreditChinaService;
	@Autowired
	private EntEquityPledgeeInfoService entEquityPledgeeInfoService;
	@Autowired
	private EntEquityInfoService entEquityInfoService;
	@Autowired
	private EntMortgageBaseInfoService entMortgageBaseInfoService;
	@Autowired
	private EntMortgagePeopleInfoService entMortgagePeopleInfoService;
	@Autowired
	private EntMortgagePawnInfoService entMortgagePawnInfoService;
	@Autowired
	private EntMortgageChangeInfoService entMortgageChangeInfoService;
	@Autowired
	private EntOwnTaxService entOwnTaxService;

	/**
	 * 经营异常
	 *
	 * @throws IOException
	 */
	@GetMapping("/abnormal")
	public R abnormal() throws IOException {
		String path = rootPath + "/经营异常/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open391AbnormalDTO>> dtos = wrapper.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}
				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				ResponsePageNumResultDTO<Open391AbnormalDTO> data = dtos.getData();
				if (null == data) {
					throw new SpiderException("data节点数据返回为空");
				}
				// 保存数据
				List<Open391AbnormalDTO> items = data.getItems();
				if (null != items && items.size() > 0) {
					// 先删除 在新增
					String entName = wrapper.getCname();
					entAbnormalInfoService.deleteByEntName(entName);
					EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
					for (Open391AbnormalDTO item : items) {
						EntAbnormalInfoEntity entity = new EntAbnormalInfoEntity();
						BeanUtils.copyProperties(item, entity);
						if (null == listInfoEntity) {
							throw new SpiderException("系统异常，请稍后再试");
						}
						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());
						entAbnormalInfoService.insert(entity);
						//更新flag
						listInfoEntity.setAbnormalFlag(YesOrNoEnum.YES.key());
					}
					entListInfoService.updateById(listInfoEntity);
				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}

	/**
	 * 767-行政处罚--信用中国（新版）
	 *
	 * @throws IOException
	 */
	@GetMapping("/credit_china_v2")
	public R creditChinaV2() throws IOException {
		String path = rootPath + "/行政处罚信用中国新版/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);

		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				try {
					Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
					Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>>>>() {
					}.getType(); //
					ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>>> wrapper = gson.fromJson(line, jsonType);
					TycApiRespDTO<ResponsePageNumResultDTO<Open767CreditChinaV2DTO>> dtos = wrapper.getResult();
					if (dtos == null) { // 成功
						throw new SpiderException("数据返回为空");
					}
					Integer status = dtos.getStatus();
					String uuid = dtos.getSeqNum();
					String message = dtos.getMessage();
					ResponsePageNumResultDTO<Open767CreditChinaV2DTO> data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}
					// 保存数据
					List<Open767CreditChinaV2DTO> items = data.getItems();

					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = wrapper.getCname();
						entPunishCreditChinaService.deleteByEntName(entName);
						for (Open767CreditChinaV2DTO item : items) {
							EntPunishCreditChinaEntity entity = new EntPunishCreditChinaEntity();
							BeanUtils.copyProperties(item, entity);
							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());
							entPunishCreditChinaService.insert(entity);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 股权出质
	 *
	 * @throws IOException
	 */
	@GetMapping("equity_info")
	public R equityInfo() throws IOException {
		String path = rootPath + "/股权出质/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open404EquityInfoDTO>> dtos = wrapper.getResult();

				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}
				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				ResponsePageNumResultDTO<Open404EquityInfoDTO> data = dtos.getData();
				if (null == data) {
					throw new SpiderException("data节点数据返回为空");
				}
				// 保存数据
				List<Open404EquityInfoDTO> items = data.getItems();
				if (null != items && items.size() > 0) {
					// 先删除 在新增
					String entName = wrapper.getCname();
					entEquityInfoService.deleteByEntName(entName);
					for (Open404EquityInfoDTO item : items) {
						EntEquityInfoEntity entity = new EntEquityInfoEntity();
						BeanUtils.copyProperties(item, entity);
						EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
						if (null == listInfoEntity) {
							throw new SpiderException("系统异常，请稍后再试");
						}
						entity.setEntId(listInfoEntity.getId());
						entity.setEntName(entName);
						entity.setCreditCode(listInfoEntity.getCreditCode());

						entEquityInfoService.insert(entity);

						List<Open404EquityInfoPledgeeListDTO> companyLs = item.getCompanyList();
						if (null != companyLs && companyLs.size() > 0) {
							entEquityPledgeeInfoService.deleteByEntNameAndRegNumberAndType(entName,entity.getRegNumber(), EntEquityPledgeeTypeEnum.COMPANY.key());
							for (Open404EquityInfoPledgeeListDTO company : companyLs) {
								EntEquityPledgeeInfoEntity companyEntity = new EntEquityPledgeeInfoEntity();
								BeanUtils.copyProperties(company, companyEntity);

								companyEntity.setEntId(listInfoEntity.getId());
								companyEntity.setEntName(entName);
								companyEntity.setType(EntEquityPledgeeTypeEnum.COMPANY.key());
								companyEntity.setRegNumber(entity.getRegNumber());

								entEquityPledgeeInfoService.insert(companyEntity);
							}
						}

						List<Open404EquityInfoPledgeeListDTO> pledgeeLs = item.getPledgeeList();
						if (null != pledgeeLs && pledgeeLs.size() > 0) {
							entEquityPledgeeInfoService.deleteByEntNameAndRegNumberAndType(entName,entity.getRegNumber(), EntEquityPledgeeTypeEnum.PLEDGEE.key());
							for (Open404EquityInfoPledgeeListDTO pledgee : pledgeeLs) {
								EntEquityPledgeeInfoEntity pledgeeEntity = new EntEquityPledgeeInfoEntity();
								BeanUtils.copyProperties(pledgee, pledgeeEntity);
								pledgeeEntity.setEntId(listInfoEntity.getId());
								pledgeeEntity.setEntName(entName);
								pledgeeEntity.setType(EntEquityPledgeeTypeEnum.PLEDGEE.key());
								pledgeeEntity.setRegNumber(entity.getRegNumber());

								entEquityPledgeeInfoService.insert(pledgeeEntity);
							}
						}

						List<Open404EquityInfoPledgeeListDTO> pledgorLs = item.getPledgorList();
						if (null != pledgorLs && pledgorLs.size() > 0) {
							entEquityPledgeeInfoService.deleteByEntNameAndRegNumberAndType(entName,entity.getRegNumber(), EntEquityPledgeeTypeEnum.PLEDGOR.key());
							for (Open404EquityInfoPledgeeListDTO pledgor : pledgorLs) {
								EntEquityPledgeeInfoEntity pledgorEntity = new EntEquityPledgeeInfoEntity();
								BeanUtils.copyProperties(pledgor, pledgorEntity);
								pledgorEntity.setEntId(listInfoEntity.getId());
								pledgorEntity.setEntName(entName);
								pledgorEntity.setType(EntEquityPledgeeTypeEnum.PLEDGOR.key());
								pledgorEntity.setRegNumber(entity.getRegNumber());

								entEquityPledgeeInfoService.insert(pledgorEntity);
							}
						}

					}
				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 动产抵押
	 *
	 * @throws IOException
	 */
	@GetMapping("/mortgage_info")
	public R mortgageInfo() throws IOException {
		String rootPath1="/Users/lee/IdeaProjects/enterprise-manage-sybank/project/02_数据处理/12106_26_all";
		String path = rootPath1 + "/动产抵押/";
		String fileName = "test.json";
		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "bak.txt")));

		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(final String line) throws IOException {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
				try {
					Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
					Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>>>>() {
					}.getType(); //
					ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>>> wrapper = gson.fromJson(line, jsonType);
					TycApiRespDTO<ResponsePageNumResultDTO<Open421MortgageInfoDTO>> dtos = wrapper.getResult();
					if (dtos == null) { // 成功
						throw new SpiderException("数据返回为空");
					}

					Integer status = dtos.getStatus();
					String uuid = dtos.getSeqNum();
					String message = dtos.getMessage();
					if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
						ResponsePageNumResultDTO<Open421MortgageInfoDTO> data = dtos.getData();
						if (null == data) {
							throw new SpiderException("data节点数据返回为空");
						}
						// 保存数据
						List<Open421MortgageInfoDTO> items = data.getItems();
						if (null != items && items.size() > 0) {
							// 先删除 在新增
							String entName = wrapper.getCname();
							entMortgageBaseInfoService.deleteByEntName(entName);
							for (Open421MortgageInfoDTO item : items) {
								// 基本信息
								EntMortgageBaseInfoEntity entity = new EntMortgageBaseInfoEntity();
								BeanUtils.copyProperties(item.getBaseInfo(), entity);

								EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
								if (null == listInfoEntity) {
									throw new SpiderException("系统异常，请稍后再试");
								}
								entity.setEntId(listInfoEntity.getId());
								entity.setEntName(entName);
								entity.setCreditCode(listInfoEntity.getCreditCode());

								entMortgageBaseInfoService.insert(entity);

								// 变更信息
								List<Open421MortgageChangeInfoListDTO> changeInfoList = item.getChangeInfoList();
								if (null != changeInfoList && changeInfoList.size() > 0) {
									List<EntMortgageChangeInfoEntity> list = new ArrayList<>();
									entMortgageChangeInfoService.deleteByEntNameAndRegNum(entName,entity.getRegNum());
									for (Open421MortgageChangeInfoListDTO changeInfo : changeInfoList) {
										EntMortgageChangeInfoEntity changeInfoEntity = new EntMortgageChangeInfoEntity();
										BeanUtils.copyProperties(changeInfo, changeInfoEntity);

										changeInfoEntity.setEntId(listInfoEntity.getId());
										changeInfoEntity.setEntName(entName);
										changeInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
										changeInfoEntity.setRegNum(entity.getRegNum());
										list.add(changeInfoEntity);
									}
									entMortgageChangeInfoService.insertBatch(list);
								}
								// 资产信息
								List<Open421MortgagePawnInfoListDTO> pawnInfoList = item.getPawnInfoList();
								if (null != pawnInfoList && pawnInfoList.size() > 0) {
									List<EntMortgagePawnInfoEntity> list = new ArrayList<>();
									entMortgagePawnInfoService.deleteByEntNameAndRegNum(entName,entity.getRegNum());
									for (Open421MortgagePawnInfoListDTO pawn : pawnInfoList) {
										EntMortgagePawnInfoEntity pawnEntity = new EntMortgagePawnInfoEntity();
										BeanUtils.copyProperties(pawn, pawnEntity);
										pawnEntity.setEntId(listInfoEntity.getId());
										pawnEntity.setEntName(entName);
										pawnEntity.setCreditCode(listInfoEntity.getCreditCode());
										pawnEntity.setRegNum(entity.getRegNum());
										list.add(pawnEntity);
									}
									entMortgagePawnInfoService.insertBatch(list);
								}
								// 抵押信息
								List<Open421MortgagePeopleInfoDTO> peopleInfo = item.getPeopleInfo();
								if (null != peopleInfo && peopleInfo.size() > 0) {
									List<EntMortgagePeopleInfoEntity> list = new ArrayList<>();
									entMortgagePeopleInfoService.deleteByEntNameAndRegNum(entName,entity.getRegNum());
									for (Open421MortgagePeopleInfoDTO people : peopleInfo) {
										EntMortgagePeopleInfoEntity peopleEntity = new EntMortgagePeopleInfoEntity();
										BeanUtils.copyProperties(people, peopleEntity);

										peopleEntity.setEntId(listInfoEntity.getId());
										peopleEntity.setEntName(entName);
										peopleEntity.setCreditCode(listInfoEntity.getCreditCode());
										peopleEntity.setRegNum(entity.getRegNum());
										list.add(peopleEntity);
									}
									entMortgagePeopleInfoService.insertBatch(list);
								}
							}
						}
					}
				} catch (Exception e) {
					try {
						bw.write(line);
						bw.flush();
						bw.newLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
                    }
                });
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 欠税公告
	 *
	 * @throws IOException
	 */
	@GetMapping("/own_tax")
	public R ownTax() throws IOException {
		String path = rootPath + "/欠税公告/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "bak.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>>> wrapper = gson.fromJson(line, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open422OwnTaxDTO>> dtos = wrapper.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}
							Integer status = dtos.getStatus();
							String uuid = dtos.getSeqNum();
							String message = dtos.getMessage();
							if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
								ResponsePageNumResultDTO<Open422OwnTaxDTO> data = dtos.getData();
								if (null == data) {
									throw new SpiderException("data节点数据返回为空");
								}
								// 保存数据
								List<Open422OwnTaxDTO> items = data.getItems();
								if (null != items && items.size() > 0) {
									// 先删除 在新增
									String entName = wrapper.getCname();
									entOwnTaxService.deleteByEntName(entName);
									for (Open422OwnTaxDTO item : items) {
										EntOwnTaxEntity entity = new EntOwnTaxEntity();
										BeanUtils.copyProperties(item, entity);
										EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
										if (null == listInfoEntity) {
											throw new SpiderException("系统异常，请稍后再试");
										}
										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());
										entOwnTaxService.insert(entity);
									}
								}
							}
						} catch (Exception e) {
							try {
								bw.write(line);
								bw.newLine();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				});
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		bw.flush();
		bw.close();
		return R.ok("导入成功");
	}

/**
 * from EntImportIntellectualPropertyController
 * Created by yp-tc-m-7179 on 2019/2/28.
 */
@Autowired
private EntTmInfoService entTmInfoService;
	@Autowired
	private EntPatentsInfoService entPatentsInfoService;
	@Autowired
	private EntCopyRegWorksService entCopyRegWorksService;
	@Autowired
	private EntCopyRegService entCopyRegService;
	@Autowired
	private EntIcpInfoService entIcpInfoService;

	/**
	 * 商标信息
	 *
	 * @throws IOException 问题：
	 *                     1.connList多级
	 *                     2.tmFlow、category字段加长
	 *                     3.4.9m
	 */
	@GetMapping("/tm")
	public R tm(String file1, String file2) throws IOException {
		String path = rootPath + "/商标信息/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "bak1.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>>> wrapper = gson.fromJson(line, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open439TmDTO>> dtos = wrapper.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}
							Integer status = dtos.getStatus();
							String uuid = dtos.getSeqNum();
							String message = dtos.getMessage();
							if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
								ResponsePageNumResultDTO<Open439TmDTO> data = dtos.getData();
								if (null == data) {
									throw new SpiderException("data节点数据返回为空");
								}
								// 保存数据
								List<Open439TmDTO> items = data.getItems();
								if (null != items && items.size() > 0) {
									// 先删除 在新增
									String entName = wrapper.getCname();
									entTmInfoService.deleteByEntName(entName);
									List<String> connLs = null;
									for (Open439TmDTO item : items) {
										EntTmInfoEntity entity = new EntTmInfoEntity();
										BeanUtils.copyProperties(item, entity);
										EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());
										connLs = item.getConnList();
										String connStr = Joiner.on(",").join(connLs);
										entity.setConnList(connStr);
										entTmInfoService.insert(entity);
									}
								}
							}
						} catch (Exception e) {
							try {
								bw.write(line);
								bw.newLine();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				});
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 专利
	 * 问题：
	 * 1.connList多级
	 * 2.多处出现特殊字符："rn"，例如：[ rn
	 * 3.多处字符串有多余字符:main_cat_num-["H04M1/725"] 、 APPLICANT_NAME-["宿迁王氏蜜蜂园有限公司"]
	 * 4.文件大小10.8m
	 *
	 * @throws IOException
	 */
	@GetMapping("/patents")
	public R patents(String file1, String file2) throws IOException {
		String path = rootPath + "/专利/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, file1);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file2)));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
//                executorService.execute(new Runnable() {
//                    @Override
//                    public void run() {
				try {
					JSONArray items = JSON.parseObject(line).getJSONObject("result").getJSONObject("data").getJSONArray("items");
					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = JSON.parseObject(line).getString("cname");
						entPatentsInfoService.deleteByEntName(entName);
						List<String> connLs = null;
						for (int i = 0; i < items.size(); i++) {
							EntPatentsInfoEntity entity = new EntPatentsInfoEntity();
							Open440PatentsDTO item = JSON.parseObject(items.getString(i), Open440PatentsDTO.class);
							BeanUtils.copyProperties(item, entity);
							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());
							connLs = item.getConnList();
							String connStr = Joiner.on(",").join(connLs);
							entity.setConnList(connStr);
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());
//							if (item.getMainCatNum() != null) {
//								entity.setMainCatNum(item.getMainCatNum().replaceAll("\\[\"", "").replaceAll("\"\\]", ""));}
//							if (item.getApplicantname() != null) {
//								entity.setApplicantname(item.getApplicantname().replaceAll("\\[\"", "").replaceAll("\"\\]", ""));}
							try {
								entPatentsInfoService.insert(entity);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					logger.error("数据异常", e);
					try {
						bw.write(line);
						bw.newLine();
					} catch (IOException e1) {
						logger.error("写文件异常", e1);
					}

				}
//                    }
//                });
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 作品著作权
	 *
	 * @throws IOException
	 */
	@GetMapping("/copy_reg_works")
	public R copyRegWorks(String file1, String file2) throws IOException {
		String path = rootPath + "/作品著作权/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open733CopyRegWorksDTO>> dtos = wrapper.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}
				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					ResponsePageNumResultDTO<Open733CopyRegWorksDTO> data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}
					// 保存数据
					List<Open733CopyRegWorksDTO> items = data.getItems();
					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = wrapper.getCname();
						entCopyRegWorksService.deleteByEntName(entName);
						for (Open733CopyRegWorksDTO item : items) {
							EntCopyRegWorksEntity entity = new EntCopyRegWorksEntity();
							BeanUtils.copyProperties(item, entity);

							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());

							entCopyRegWorksService.insert(entity);
						}
					}

				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 著作权
	 *
	 * @throws IOException
	 */
	@GetMapping("/copy_reg")
	public R copyReg() throws IOException {
		String path = rootPath + "/著作权/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open441CopyRegDTO>> dtos = wrapper.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					ResponsePageNumResultDTO<Open441CopyRegDTO> data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}
					// 保存数据
					List<Open441CopyRegDTO> items = data.getItems();
					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = wrapper.getCname();
						entCopyRegService.deleteByEntName(entName);
						List<String> connLs = null;
						for (Open441CopyRegDTO item : items) {
							EntCopyRegEntity entity = new EntCopyRegEntity();
							BeanUtils.copyProperties(item, entity);

							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());

							connLs = item.getConnList();
							String connStr = Joiner.on(",").join(connLs);
							entity.setConnList(connStr);

							entCopyRegService.insert(entity);
						}
					}
				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 网站备案
	 * 空指针问题
	 * @throws IOException
	 */
	@GetMapping("/icp")
	public R icp() throws IOException {
		String path = rootPath + "/网站备案/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open442IcpDTO>> dtos = wrapper.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}

				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					ResponsePageNumResultDTO<Open442IcpDTO> data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}
					// 保存数据
					List<Open442IcpDTO> items = data.getItems();
					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = wrapper.getCname();
						entIcpInfoService.deleteByEntName(entName);

						List<String> webSiteLs = null;
						for (Open442IcpDTO item : items) {
							EntIcpInfoEntity entity = new EntIcpInfoEntity();
							BeanUtils.copyProperties(item, entity);

							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							entity.setEntId(listInfoEntity.getId());
							entity.setEntName(entName);
							entity.setCreditCode(listInfoEntity.getCreditCode());

							webSiteLs = item.getWebSite();
							if (webSiteLs != null) {
								String str = Joiner.on(",").join(webSiteLs);
								entity.setWebsites(str);
							}
							entIcpInfoService.insert(entity);
						}
					}
				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * from EntBusinessInformation1Controller
	 * Created by lee on 2019/3/2.
	 * 4.1.2.1.工商信息
	 */
	//372-分支机构
	@Autowired
	private EntBranchInfoService entBranchInfoService;


	//371-企业年报
	@Autowired
	private EntAnnualreportInfoService entAnnualreportInfoService;
	@Autowired
	private EntAnnualreportWebInfoService entAnnualreportWebInfoService;
	@Autowired
	private EntAnnualreportSocialSecurityService entAnnualreportSocialSecurityService;
	@Autowired
	private EntAnnualreportShareholderService entAnnualreportShareholderService;
	@Autowired
	private EntAnnualreportBaseInfoService entAnnualreportBaseInfoService;
	@Autowired
	private EntAnnualreportChangeRecordService entAnnualreportChangeRecordService;
	@Autowired
	private EntAnnualreportEquityChangeInfoService entAnnualreportEquityChangeInfoService;
	@Autowired
	private EntAnnualreportOutboundInvestmentService entAnnualreportOutboundInvestmentService;
	@Autowired
	private EntAnnualreportOutGuaranteeInfoService entAnnualreportOutGuaranteeInfoService;


	/**
	 * 372 - 分支机构
	 *
	 * 1、处理 },[{"regStatus":"注销"   和   }],[{"regStatus":"注销"    --->   },{"regStatus":"注销"    ]] --> ]
	 * 不完整
	 *
	 * 2、处理 }],[{   和 },[{ ---> },{
	 *  ]] --> ]
	 *
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/372branch")
	public R branch() throws IOException {
		String path = rootPath + "/分支机构/";
		String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="add.txt";

		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "wenti.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							// 这里处理一行字符串
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<
									ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>>>
									>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>>>
									result = gson.fromJson(apiData, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open372BranchDTO>> dtos = result.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}

							String entName = result.getCname();
							// 保存数据
							List<Open372BranchDTO> items = dtos.getData().getItems();
							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							if (null != items && items.size() > 0) {
								// 先删除 在新增
								entBranchInfoService.deleteByEntName(entName);
								for (Open372BranchDTO item : items) {

									EntBranchInfoEntity entity = new EntBranchInfoEntity();
									BeanUtils.copyProperties(item, entity);

									entity.setEntId(listInfoEntity.getId());
									entity.setEntName(entName);
									entity.setCreditCode(listInfoEntity.getCreditCode());

									entBranchInfoService.insert(entity);
								}
							}
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
							try {
								bw.write(apiData);
								bw.flush();
								bw.newLine();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				});
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}

	/**
	 * 371 - 企业年报
	 *  字段扩大 爬虫程序问题补充数据 企业有三个bak中1、3、6行
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/371annualreport")
	public R annualreport() throws IOException {
		String path = rootPath + "/企业年报/";
		String fileName = "callSuccessful.txt_file3.txt";
//          String fileName="bak.txt";

		File file = new File(path, fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "bak.txt")));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String apiData) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							// 这里处理一行字符串
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<
									ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>>>
									>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>>>
									result = gson.fromJson(apiData, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open371AnnualreportDTO>> dtos = result.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}

							String entName = result.getCname();
							// 保存数据
							List<Open371AnnualreportDTO> items = dtos.getData().getItems();
							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							if (null != items && items.size() > 0) {

								for (Open371AnnualreportDTO item : items) {
									Open371AnnualreportBaseInfoDTO baseInfo = item.getBaseInfo();
									String belongYear = baseInfo.getReportYear();

									entAnnualreportInfoService.deleteByEntNameBlongYear(entName, belongYear);

									EntAnnualreportInfoEntity entAnnualreportInfoEntity = new EntAnnualreportInfoEntity();
									BeanUtils.copyProperties(item, entAnnualreportInfoEntity);
									entAnnualreportInfoEntity.setEntId(listInfoEntity.getId());
									entAnnualreportInfoEntity.setEntName(entName);
									entAnnualreportInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
									entAnnualreportInfoEntity.setBelongYear(belongYear);

									entAnnualreportInfoService.insert(entAnnualreportInfoEntity);

									entAnnualreportBaseInfoService.deleteByEntNameReportYear(entName, belongYear);
									EntAnnualreportBaseInfoEntity baseInfoEntity = new EntAnnualreportBaseInfoEntity();
									BeanUtils.copyProperties(baseInfo, baseInfoEntity);

									baseInfoEntity.setEntId(listInfoEntity.getId());
									baseInfoEntity.setEntName(entName);
									baseInfoEntity.setCreditCode(listInfoEntity.getCreditCode());
									baseInfoEntity.setBelongYear(belongYear);

									entAnnualreportBaseInfoService.insert(baseInfoEntity);

									List<Open371AnnualreportChangeRecordDTO> changeRecordList = item.getChangeRecordList();
									if (null != changeRecordList && changeRecordList.size() > 0) {
										entAnnualreportChangeRecordService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportChangeRecordDTO dto : changeRecordList) {
											EntAnnualreportChangeRecordEntity entity = new EntAnnualreportChangeRecordEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportChangeRecordService.insert(entity);
										}
									}

									List<Open371AnnualreportEquityChangeInfoDTO> equityChangeInfoList = item.getEquityChangeInfoList();
									if (null != equityChangeInfoList && equityChangeInfoList.size() > 0) {
										entAnnualreportEquityChangeInfoService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportEquityChangeInfoDTO dto : equityChangeInfoList) {
											EntAnnualreportEquityChangeInfoEntity entity = new EntAnnualreportEquityChangeInfoEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportEquityChangeInfoService.insert(entity);
										}
									}

									List<Open371AnnualreportOutGuaranteeInfoDTO> outGuaranteeInfoList = item.getOutGuaranteeInfoList();
									if (null != outGuaranteeInfoList && outGuaranteeInfoList.size() > 0) {
										entAnnualreportOutGuaranteeInfoService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportOutGuaranteeInfoDTO dto : outGuaranteeInfoList) {
											EntAnnualreportOutGuaranteeInfoEntity entity = new EntAnnualreportOutGuaranteeInfoEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportOutGuaranteeInfoService.insert(entity);
										}
									}
									List<Open371AnnualreportOutboundInvestmentDTO>
											outboundInvestmentList = item.getOutboundInvestmentList();
									if (null != outboundInvestmentList && outboundInvestmentList.size() > 0) {
										entAnnualreportOutboundInvestmentService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportOutboundInvestmentDTO dto : outboundInvestmentList) {
											EntAnnualreportOutboundInvestmentEntity
													entity = new EntAnnualreportOutboundInvestmentEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportOutboundInvestmentService.insert(entity);
										}
									}
									List<Open371AnnualreportShareholderDTO> shareholderList = item.getShareholderList();
									if (null != shareholderList && shareholderList.size() > 0) {
										entAnnualreportShareholderService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportShareholderDTO dto : shareholderList) {
											EntAnnualreportShareholderEntity entity = new EntAnnualreportShareholderEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportShareholderService.insert(entity);
										}
									}

									List<Open371AnnualreportWebInfoDTO> webInfoList = item.getWebInfoList();
									if (null != webInfoList && webInfoList.size() > 0) {
										entAnnualreportWebInfoService.deleteByEntNameBelongYear(entName, belongYear);
										for (Open371AnnualreportWebInfoDTO dto : webInfoList) {
											EntAnnualreportWebInfoEntity entity = new EntAnnualreportWebInfoEntity();
											BeanUtils.copyProperties(dto, entity);

											entity.setEntId(listInfoEntity.getId());
											entity.setEntName(entName);
											entity.setCreditCode(listInfoEntity.getCreditCode());
											entity.setBelongYear(belongYear);

											entAnnualreportWebInfoService.insert(entity);
										}
									}

									Open371AnnualreportReportSocialSecurityInfoDTO
											reportSocialSecurityInfo = item.getReportSocialSecurityInfo();
									if (null != reportSocialSecurityInfo) {
										entAnnualreportSocialSecurityService
												.deleteByAnnanlreportId(reportSocialSecurityInfo.getAnnaulreportId());

										EntAnnualreportSocialSecurityEntity entity = new EntAnnualreportSocialSecurityEntity();
										BeanUtils.copyProperties(reportSocialSecurityInfo, entity);

										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());
										entity.setBelongYear(belongYear);

										entAnnualreportSocialSecurityService.insert(entity);
									}
								}
							}
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
							try {
								bw.write(apiData);
								bw.flush();
								bw.newLine();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							e.printStackTrace();
						}
					}
				});
				return true;
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});
		return R.ok("导入成功");
	}


/**
 * from EntBusinessInformation2Controller
 * Created by lee on 2019/3/2.
 * 4.1.2.1.工商信息
 */


	@Autowired
	private EntHolderInfoService entHolderInfoService;
	@Autowired
	private EntHolderCapitalService entHolderCapitalService;
	@Autowired
	private EntInverstInfoService entInverstInfoService;
	@Autowired
	private EntChangeInfoService entChangeInfoService;

	/**
	 * 股东信息
	 */
	@GetMapping("/holder")
	public R holder(String file1, String file2) throws IOException {
		String path = rootPath + "/股东信息/";
//        String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, file1);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file2)));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>>> wrapper = gson.fromJson(line, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open368HolderDTO>> dtos = wrapper.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}
							Integer status = dtos.getStatus();
							String uuid = dtos.getSeqNum();
							String message = dtos.getMessage();
							BaseRespnseDTO<List<Open368HolderDTO>> rtnDTO = new BaseRespnseDTO<List<Open368HolderDTO>>();
							rtnDTO.setRtnSerialNo(uuid);
							rtnDTO.setCode(status);
							rtnDTO.setMsg(message);
							if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
								ResponsePageNumResultDTO<Open368HolderDTO> data = dtos.getData();
								if (null == data) {
									throw new SpiderException("data节点数据返回为空");
								}
								List<Open368HolderDTO> items = data.getItems();
								if (null != items && items.size() > 0) {
									// 先删除 在新增
									String entName = wrapper.getCname();
									entHolderInfoService.deleteByEntName(entName);
									for (Open368HolderDTO item : items) {

										EntHolderInfoEntity holderInfoEntity = new EntHolderInfoEntity();
										BeanUtils.copyProperties(item, holderInfoEntity);

										EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
										if (null == listInfoEntity) {
											throw new SpiderException("系统异常，请稍后再试");
										}

										holderInfoEntity.setEntId(listInfoEntity.getId());
										holderInfoEntity.setEntName(entName);
										holderInfoEntity.setCreditCode(listInfoEntity.getCreditCode());

										entHolderInfoService.insert(holderInfoEntity);

										List<Open368HolderCapitalDTO> capitalLs = item.getCapital();
										if (null != capitalLs && capitalLs.size() > 0) {
											entHolderCapitalService.deleteByEntNameHolderNameType(entName, item.getName(), HolderCaptialEnum.CAPITAL.key());
											for (Open368HolderCapitalDTO capital : capitalLs) {
												EntHolderCapitalEntity capitalEntity = new EntHolderCapitalEntity();
												BeanUtils.copyProperties(capital, capitalEntity);

												capitalEntity.setEntName(entName);
												capitalEntity.setHolderName(holderInfoEntity.getName());
												capitalEntity.setType(HolderCaptialEnum.CAPITAL.key());
												entHolderCapitalService.insert(capitalEntity);

											}
										}

										List<Open368HolderCapitalActlDTO> capitalActlLs = item.getCapitalActl();
										if (null != capitalActlLs && capitalActlLs.size() > 0) {
											entHolderCapitalService.deleteByEntNameHolderNameType(entName, item.getName(), HolderCaptialEnum.CAPITAL_ACTL.key());
											for (Open368HolderCapitalActlDTO capitalActl : capitalActlLs) {
												EntHolderCapitalEntity capitalActlEntity = new EntHolderCapitalEntity();
												BeanUtils.copyProperties(capitalActl, capitalActlEntity);

												capitalActlEntity.setEntName(entName);
												capitalActlEntity.setHolderName(holderInfoEntity.getName());
												capitalActlEntity.setType(HolderCaptialEnum.CAPITAL_ACTL.key());
												entHolderCapitalService.insert(capitalActlEntity);
											}
										}
									}
								}
							}
						} catch (Exception e) {
							logger.error(line, e);
							try {
								bw.write(line);
								bw.newLine();
							} catch (IOException e1) {
								logger.error("写文件异常", e1);
							}
						}
					}
				});
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 对外投资
	 *
	 * @throws IOException
	 */
	@GetMapping("/inverst")
	public R inverst() throws IOException {
		String path = rootPath + "/对外投资/";
		String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, fileName);
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
				Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>>>>() {
				}.getType(); //
				ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>>> wrapper = gson.fromJson(line, jsonType);
				TycApiRespDTO<ResponsePageNumResultDTO<Open369InverstDTO>> dtos = wrapper.getResult();
				if (dtos == null) { // 成功
					throw new SpiderException("数据返回为空");
				}
				Integer status = dtos.getStatus();
				String uuid = dtos.getSeqNum();
				String message = dtos.getMessage();
				if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
					ResponsePageNumResultDTO<Open369InverstDTO> data = dtos.getData();
					if (null == data) {
						throw new SpiderException("data节点数据返回为空");
					}

					List<Open369InverstDTO> items = data.getItems();
					if (null != items && items.size() > 0) {
						// 先删除 在新增
						String entName = wrapper.getCname();
						entInverstInfoService.deleteByEntName(entName);
						for (Open369InverstDTO item : items) {

							EntInverstInfoEntity inverstInfoEntity = new EntInverstInfoEntity();
							BeanUtils.copyProperties(item, inverstInfoEntity);

							EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
							if (null == listInfoEntity) {
								throw new SpiderException("系统异常，请稍后再试");
							}
							inverstInfoEntity.setEntId(listInfoEntity.getId());
							inverstInfoEntity.setEntName(entName);
							inverstInfoEntity.setCreditCode(listInfoEntity.getCreditCode());

							entInverstInfoService.insert(inverstInfoEntity);

						}
					}
				}
				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

	/**
	 * 变更记录
	 * 刚哥指导的翻页中括号问题
	 *
	 */
	@GetMapping("/changeinfo")
	public R changeinfo(String file1, String file2) throws IOException {
		String path = rootPath + "/变更记录/";
//        String fileName = "callSuccessful.txt_file3.txt";
		File file = new File(path, file1);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, file2)));
		Files.asCharSource(file, Charset.defaultCharset()).readLines(new LineProcessor<String>() {
			public boolean processLine(String line) throws IOException {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
							Type jsonType = new TypeToken<ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>>>>() {
							}.getType(); //
							ImportParseBaseDTO<TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>>> wrapper = gson.fromJson(line, jsonType);
							TycApiRespDTO<ResponsePageNumResultDTO<Open370ChangeinfoDTO>> dtos = wrapper.getResult();
							if (dtos == null) { // 成功
								throw new SpiderException("数据返回为空");
							}
							Integer status = dtos.getStatus();
							String uuid = dtos.getSeqNum();
							String message = dtos.getMessage();
							if (TcxyApiStatusCodeEnum.SUCCESS.key() == status) { // 查询成功 有数据
								ResponsePageNumResultDTO<Open370ChangeinfoDTO> data = dtos.getData();
								if (null == data) {
									throw new SpiderException("data节点数据返回为空");
								}

								List<Open370ChangeinfoDTO> items = data.getItems();
								if (null != items && items.size() > 0) {
									// 先删除 在新增
									String entName = wrapper.getCname();
									entChangeInfoService.deleteByEntName(entName);
									for (Open370ChangeinfoDTO item : items) {

										EntChangeInfoEntity entity = new EntChangeInfoEntity();
										BeanUtils.copyProperties(item, entity);

										EntListInfoEntity listInfoEntity = entListInfoService.selectOneByName(entName);
										if (null == listInfoEntity) {
											throw new SpiderException("系统异常，请稍后再试");
										}
										entity.setEntId(listInfoEntity.getId());
										entity.setEntName(entName);
										entity.setCreditCode(listInfoEntity.getCreditCode());

										entChangeInfoService.insert(entity);

									}
								}
							}
						} catch (Exception e) {
							logger.error(line, e);
							try {
								bw.write(line);
								bw.newLine();
								bw.flush();
							} catch (IOException e1) {
								logger.error("写文件异常", e1);
							}
						}
					}
				});

				return true;// 如果是false，则会中断读取操作
			}

			public String getResult() {
				return null;// 返回的结果。可以自定义
			}
		});

		return R.ok("导入成功");
	}

}
