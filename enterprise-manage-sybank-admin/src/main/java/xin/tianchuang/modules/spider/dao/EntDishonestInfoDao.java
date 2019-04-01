package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:03
 */
@Mapper
public interface EntDishonestInfoDao extends BaseMapper<EntDishonestInfoEntity> {

	boolean insertBatch(List<EntDishonestInfoEntity> list);
	
}
