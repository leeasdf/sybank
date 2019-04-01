
package xin.tianchuang.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author hui.deng
 * 
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
