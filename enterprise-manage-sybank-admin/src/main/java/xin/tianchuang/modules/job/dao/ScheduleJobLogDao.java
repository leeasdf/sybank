
package xin.tianchuang.modules.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.job.entity.ScheduleJobLogEntity;

/**
 * 定时任务日志
 *
 * @author xx
 * @since 1.2.0 2016-11-28
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
