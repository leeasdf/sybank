package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:11
 */
@Mapper
public interface EntStaffInfoDao extends BaseMapper<EntStaffInfoEntity> {

	boolean insertBatch(List<EntStaffInfoEntity> list);
	
}
