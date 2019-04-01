package xin.tianchuang.modules.job.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.enums.ApiStatusEnum;
import xin.tianchuang.common.enums.ChannelTypeEnum;
import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
import xin.tianchuang.common.utils.DateUtils;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.biz.TycOpenBizTask;
import xin.tianchuang.modules.api.dto.SysTaskReqDTO;
import xin.tianchuang.modules.api.dto.SysTaskRespDTO;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import xin.tianchuang.modules.spider.entity.SysTaskResultEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;
import xin.tianchuang.modules.spider.service.EntListInfoService;
import xin.tianchuang.modules.spider.service.SysTaskResultService;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 对于api_log日志中处于网络等超时情况的数据进行定时补偿 //
 * <p>
 * 对所有企业名录的数据按照每季度的频次进行更新（频次待确定）
 *
 * @author 邓辉
 */
@Component("tycProcessTask")
public class TycProcessTask {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final int DEFAULT_THREAD_NUM = 10;
	private static final int MAX_THREAD_NUM = 20;

	private static final int DEFAULT_PAGE_SIZE = 500;
	private static final int MAX_LIST_SIZE = 1000;

	private static final int DEFAULT_RETRY_TIMES = 3;

	private static final String THREAD_NUM = "thread";
	private static final String PAGE_SIZE = "size";

	private static final String BIZ_CODE_PREFIX = "TASK";

	@Autowired
	private TycOpenBizTask tycOpenBizTask;
	@Autowired
	private EntListInfoService entListInfoService;

	@Autowired
	private SysTaskResultService sysTaskResultService;

	@Autowired
	private ApiLogService apiLogService;

	/**
	 * interfaceType 参数接口名称， thread 参数线程池大小 size 参数分页大小
	 *
	 * @param params
	 *            json格式的 例子：{ "interfaceType": "HOLDER","thread":20,"size":50 }
	 */
	public void job(String params) {

		if (params == null) {
			logger.error("参数不能为空");
			return;
		}

		JSONObject jsonObject = JSONObject.parseObject(params);
		if (null == jsonObject) {
			logger.error("参数不能为空");
			return;
		}
		String interfaceName = jsonObject.getString("interfaceType");
		if (StringUtils.isBlank(interfaceName)) {
			logger.error("接口名称不能为空");
			return;
		}

		Integer threadNum = jsonObject.getInteger(THREAD_NUM);
		Integer size = jsonObject.getInteger(PAGE_SIZE);

		threadNum = getThreadNum(threadNum);
		size = getSize(size);

		try {
			TycInterfaceTypeEnum interfaceTypeEnum = TycInterfaceTypeEnum.transfar(interfaceName);
			if (null != interfaceTypeEnum) {
				doWorker(interfaceTypeEnum, threadNum, size);
			}
		} catch (Exception e) {
			logger.error("全量定时批量任务异常", e);
		}
	}

	/**
	 * 新增企业的全量接口调用跑批任务 thread 线程数量 size 每个线程一次跑的企业数 每个企业在跑26个接口
	 *
	 * @param params
	 */
	public void newEnterpriseJob(String params) {
		try {
			if (params == null) {
				int threadNum = getThreadNum(null);
				int size = getSize(null);

				doWorkerAddNewEnt(threadNum, size);
			} else {
				JSONObject jsonObject = JSONObject.parseObject(params);
				Integer threadNum = jsonObject.getInteger(THREAD_NUM);
				Integer size = jsonObject.getInteger(PAGE_SIZE);
				threadNum = getThreadNum(threadNum);
				size = getSize(size);

				doWorkerAddNewEnt(threadNum, size);
			}
		} catch (Exception e) {
			logger.error("新增企业的全量接口调用跑批任务定时异常", e);

		}
	}

	private int getSize(Integer size) {
		if (size == null || size == 0) {
			size = DEFAULT_PAGE_SIZE;
		} else if (size >= MAX_LIST_SIZE) {
			size = MAX_LIST_SIZE;
		}
		return size;
	}

	private int getThreadNum(Integer threadNum) {
		if (threadNum == null || threadNum == 0) {
			threadNum = DEFAULT_THREAD_NUM;
		} else if (threadNum >= MAX_THREAD_NUM) {
			threadNum = MAX_THREAD_NUM;
		}
		return threadNum;
	}

	/**
	 * 异常补偿定时任务 thread 线程数量 size 每个线程一次跑的企业数 每个企业在跑26个接口 每次跑一个小时之前的数据 轮询次数 默认3 次
	 *
	 * @param params
	 */
	public void processRetry(String params) {
		try {
			if (params != null) {
				JSONObject jsonObject = JSONObject.parseObject(params);
				Integer threadNum = jsonObject.getInteger(THREAD_NUM);
				threadNum = getThreadNum(threadNum);
				processRetry(threadNum);
			} else {
				int threadNum = getThreadNum(null);
				processRetry(threadNum);
			}
		} catch (Exception e) {
			logger.error("异常补偿定时异常", e);

		}
	}

	private void processRetry(Integer threadNum) {
		logger.info("新增企业开始定时任务调用全量接口开始。");
		long start = System.currentTimeMillis();

		Date time = DateUtils.addDateHours(new Date(), -1);
		// 线程命名
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("time-task-pool-%d").setDaemon(true).build();
		ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500), threadFactory);
		// 查询执行中的日志
		List<ApiLogEntity> list = apiLogService.selectListByStatusAndRetryTiemsAndTime(ApiStatusEnum.PROCESS, DEFAULT_RETRY_TIMES, time);
		BaseApiRequestDTO req = null;
		for (ApiLogEntity apiLogEntity : list) {
			// 设置为重试
			req = JSONObject.parseObject(apiLogEntity.getReqInfo(), BaseApiRequestDTO.class);
			final SysTaskReqDTO param = new SysTaskReqDTO();
			BeanUtils.copyProperties(req, param);
			param.setRetry(true);
			// 将日志传入更新字段就行
			param.setApiLogEntity(apiLogEntity);
			// 线程处理
			TycInterfaceTypeEnum interfaceTypeEnum = TycInterfaceTypeEnum.transfar(apiLogEntity.getInterfaceType());
			executorService.execute(() -> tycOpenBizTask.getApiRespData(param, interfaceTypeEnum));
		}

		long end = System.currentTimeMillis();
		logger.info("调用完毕结束。耗时:{}秒", (end - start) / 1000.0);

	}

	private void doWorkerAddNewEnt(int threadNum, int size) throws Exception {
		logger.info("新增企业开始定时任务调用全量接口开始。");
		long start = System.currentTimeMillis();
		// 创建时间是昨天的
		Date endTime = DateUtils.initDateByDay();
		Date startTime = DateUtils.addDateDays(endTime, -1);
		List<EntListInfoEntity> entListInfoEntities = entListInfoService.getEntListByCreateTime(startTime, endTime);
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("time-task-pool-%d").setDaemon(true).build();
		ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500), threadFactory);
		//
		int totalCount = entListInfoEntities.size();
		// 计算需要的线程数量 总条数/每个线程跑的数量=需要的线程数量
		Integer totalPage = getTimeByListSize(totalCount, size);
		// 如果只要循环一次 sublist.size()==entCount;
		int num = size;
		// 26个接口每一个跑一次
		List<Future<List<SysTaskRespDTO>>> futureList = null;
		List<EntListInfoEntity> entlist = null;
		Future<List<SysTaskRespDTO>> future = null;
		for (TycInterfaceTypeEnum interfaceTypeEnum : TycInterfaceTypeEnum.values()) {
			futureList = new ArrayList<Future<List<SysTaskRespDTO>>>(totalPage);
			for (int currPage = 0; currPage < totalPage; currPage++) {
				// 最后一次是尾数个数
				if (currPage == totalPage - 1) {
					num = totalCount - currPage * size;
				}
				entlist = entListInfoEntities.subList(currPage * size, currPage * size + num);
				final List<SysTaskReqDTO> parmList = initParam(entlist, interfaceTypeEnum);
				// 线程处理
				future = executorService.submit(() -> tycOpenBizTask.getApiRespDataList(parmList, interfaceTypeEnum));
				futureList.add(future);
			}
			saveTaskResult(futureList, totalCount, interfaceTypeEnum);
		}

		long end = System.currentTimeMillis();
		logger.info("调用完毕结束。耗时:{}秒", (end - start) / 1000.0);
	}

	private void doWorker(TycInterfaceTypeEnum interfaceTypeEnum, Integer threadNum, Integer pageSize) throws Exception {
		long start = System.currentTimeMillis();
		Integer totalCount = entListInfoService.getCount();
		Integer totalPage = getTimeByListSize(totalCount, pageSize);
		logger.info("[{}][{}]定时任务准备处理企业名录总笔数[{}]，分[{}]批次处理。", interfaceTypeEnum.desc(), interfaceTypeEnum.key(), totalCount, totalPage);
		// 线程命名
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("time-task-pool-%d").setDaemon(true).build();
		ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500), threadFactory);
		// 10000多企业怕内存不够 处理消耗内存过大 分页查询处理
		List<EntListInfoEntity> entList = null;
		List<Future<List<SysTaskRespDTO>>> futureList = new ArrayList<Future<List<SysTaskRespDTO>>>(totalPage);
		Future<List<SysTaskRespDTO>> future = null;
		int startNum = 0;
		for (int currPage = 0; currPage < totalPage; currPage++) {
			startNum = currPage * pageSize;
			entList = entListInfoService.getPageEntInfo(startNum, pageSize);
			if (null == entList || entList.isEmpty()) {
				logger.info("未查询到数据");
				continue;
			}

			final List<SysTaskReqDTO> parmList = initParam(entList, interfaceTypeEnum);
			// 线程处理
			future = executorService.submit(() -> tycOpenBizTask.getApiRespDataList(parmList, interfaceTypeEnum));
			futureList.add(future);
			logger.info("[{}][{}]定时任务准备处理企业名录开始第[{}]条，第[{}]页处理。", interfaceTypeEnum.desc(), interfaceTypeEnum.key(), startNum, currPage);
		}

		saveTaskResult(futureList, totalCount, interfaceTypeEnum);
		long end = System.currentTimeMillis();
		logger.info("定时调用接口[{}]-[{}]调用完毕结束。总共耗时:{}秒", interfaceTypeEnum.desc(), interfaceTypeEnum.key(), (end - start) / 1000.0);

	}

	private List<SysTaskReqDTO> initParam(List<EntListInfoEntity> entList, TycInterfaceTypeEnum interfaceTypeEnum) {
		if (null == entList || entList.isEmpty()) {
			logger.info("未查询到数据");
			return null;
		}

		List<SysTaskReqDTO> parmList = new ArrayList<>(entList.size());
		SysTaskReqDTO param = null;
		// 组装参数
		for (EntListInfoEntity entInfo : entList) {
			param = new SysTaskReqDTO();
			param.setBizCode(BIZ_CODE_PREFIX + UUID.randomUUID().toString().replace("-", "") + interfaceTypeEnum.key());
			param.setSeqNum(UUID.randomUUID().toString().replace("-", ""));
			param.setChannelType(ChannelTypeEnum.SYS.key());
			param.setName(entInfo.getName());
			param.setCreditCode(entInfo.getCreditCode());
			param.setCompanyId(entInfo.getTycId());
			param.setEntId(entInfo.getId());
			param.setEntListInfo(entInfo);
			parmList.add(param);
		}
		return parmList;
	}

	/**
	 * 这个地方用到了get 所以会阻塞 只能是一个接口掉完才去掉第二个没有多个接口同时并发 要同时并发可以讲这个提出到for外面去计算 计算的时候取每个对象的接口类型分别统计
	 * SysTaskRespDTO.getInterfaceName()
	 */
	private void saveTaskResult(List<Future<List<SysTaskRespDTO>>> futureList, Integer batchListSize, TycInterfaceTypeEnum interfaceTypeEnum) throws Exception {
		if (null == futureList || futureList.size() <= 0) {
			logger.info("处理结果为空");
			return;
		}

		int sucessCount = 0;
		int errorCount = 0;
		int unknownCount = 0;
		StringBuffer errorIdSb = new StringBuffer();
		StringBuffer unknownIdSb = new StringBuffer();

		// 遍历一遍
		while (futureList.size() > 0) {
			Iterator<Future<List<SysTaskRespDTO>>> futureIterable = futureList.iterator();
			List<SysTaskRespDTO> resDTOList = null;
			// 遍历一遍
			while (futureIterable.hasNext()) {
				Future<List<SysTaskRespDTO>> future = futureIterable.next();
				if (future.isDone() && !future.isCancelled()) {
					resDTOList = future.get();
					for (SysTaskRespDTO res : resDTOList) {
						switch (res.getResStatus()) {
						case SysTaskRespDTO.SUCCESS:
							sucessCount++;
							break;
						case SysTaskRespDTO.FAIL:
							errorCount++;
							errorIdSb.append(res.getEntId()).append(",");
							break;
						case SysTaskRespDTO.UNKNOWN:
							unknownCount++;
							unknownIdSb.append(res.getEntId()).append(",");
							break;
						}
					}
					futureIterable.remove();
				} else {
					// 避免CPU高速轮循，可以休息一下。
					Thread.sleep(1);
				}
			}
		}

		SysTaskResultEntity resultEntity = new SysTaskResultEntity();
		resultEntity.setSucessCount(sucessCount);
		resultEntity.setErrorCount(errorCount);
		resultEntity.setUnknownCount(unknownCount);
		//数据库设置的varchar（6000） 超过 5800个字符截取掉 防止字段超长
		if(errorIdSb.length()> 5800){
			resultEntity.setErrorEntId(errorIdSb.substring(0,5800));
		}else {
			resultEntity.setErrorEntId(errorIdSb.toString());
		}
		if(unknownIdSb.length()> 5800){
			resultEntity.setUnknownEntId(unknownIdSb.substring(0,5800));
		}else {
			resultEntity.setUnknownEntId(unknownIdSb.toString());
		}

		resultEntity.setCount(batchListSize);
		resultEntity.setInterfaceType(interfaceTypeEnum.key());

		sysTaskResultService.insert(resultEntity);

		logger.info("定时调用接口[{}]-[{}]调用完毕结束。总共:{},成功:{},失败:{},未知:{}", interfaceTypeEnum.desc(), interfaceTypeEnum.key(), batchListSize, sucessCount, errorCount, unknownCount);

	}

	private Integer getTimeByListSize(Integer count, Integer size) {
		return count % size == 0 ? count / size : count / size + 1;
	}

}
