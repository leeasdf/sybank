package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntStaffPositionEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:10
 */
@Mapper
public interface EntStaffPositionDao extends BaseMapper<EntStaffPositionEntity> {

	boolean insertBatch(List<EntStaffPositionEntity> list);
	
}
