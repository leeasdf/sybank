
package xin.tianchuang.modules.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.job.entity.ScheduleJobEntity;
import xin.tianchuang.modules.job.service.ScheduleJobService;

/**
 * 定时任务
 *
 * @author hui.deng
 * @since 1.2.0 2016-11-28
 */
@RestController
@RequestMapping("/api/schedule")
@Api(value = "定时任务", tags = { "定时任务" })
@ApiIgnore
public class ScheduleTaskController {
	@Autowired
	private ScheduleJobService scheduleJobService;
	
	/**
	 * 定时任务列表
	 */
	@GetMapping("/list")
	@ApiOperation(value = "定时任务列表", notes = "")
	public R list(@RequestParam Map<String, Object> params){
		List<ScheduleJobEntity> list = scheduleJobService.queryList(params);;
		return R.ok().put("data", list);
	}
	
	/**
	 * 定时任务信息
	 */
	@GetMapping("/info/{jobId}")
	@ApiOperation(value = "定时任务信息", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jobId", value = "任务id", dataType = "int", paramType = "query")
	})
	public R info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity schedule = scheduleJobService.selectById(jobId);
		
		return R.ok().put("schedule", schedule);
	}
	
	/**
	 * 保存定时任务
	 */
	@PostMapping("/save")
	@ApiOperation(value = "定时任务信息", notes = "")
	public R save(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);
		
		scheduleJobService.save(scheduleJob);
		
		return R.ok();
	}
	
	/**
	 * 修改定时任务
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改定时任务", notes = "")
	public R update(@RequestBody ScheduleJobEntity scheduleJob){
		ValidatorUtils.validateEntity(scheduleJob);
				
		scheduleJobService.update(scheduleJob);
		
		return R.ok();
	}
	
	/**
	 * 删除定时任务
	 */
	@PostMapping("/delete")
	@ApiOperation(value = "删除定时任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jobId", value = "任务id", dataType = "int", paramType = "query")
	})
	public R delete(@RequestBody Long[] jobIds){
		scheduleJobService.deleteBatch(jobIds);
		
		return R.ok();
	}
	
	/**
	 * 立即执行任务
	 */
	@PostMapping("/run")
	@ApiOperation(value = "立即执行任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jobId", value = "任务id", dataType = "int", paramType = "query")
	})
	public R run(@RequestBody Long[] jobIds){
		scheduleJobService.run(jobIds);
		
		return R.ok();
	}
	
	/**
	 * 暂停定时任务
	 */
	@PostMapping("/pause")
	@ApiOperation(value = "暂停定时任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jobId", value = "任务id", dataType = "int", paramType = "query")
	})
	public R pause(@RequestBody Long[] jobIds){
		scheduleJobService.pause(jobIds);
		
		return R.ok();
	}
	
	/**
	 * 恢复定时任务
	 */
	@PostMapping("/resume")
	@ApiOperation(value = "恢复定时任务", notes = "")
	@ApiImplicitParams({ @ApiImplicitParam(name = "jobId", value = "任务id", dataType = "int", paramType = "query")
	})
	public R resume(@RequestBody Long[] jobIds){
		scheduleJobService.resume(jobIds);
		
		return R.ok();
	}

}
