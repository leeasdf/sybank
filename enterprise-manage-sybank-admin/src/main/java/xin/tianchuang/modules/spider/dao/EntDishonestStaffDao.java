package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntDishonestStaffEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-02-20 16:53:27
 */
@Mapper
public interface EntDishonestStaffDao extends BaseMapper<EntDishonestStaffEntity> {

	boolean insertBatch(List<EntDishonestStaffEntity> list);
	
}
