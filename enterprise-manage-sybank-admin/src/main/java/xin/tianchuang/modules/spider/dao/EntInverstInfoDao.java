package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntInverstInfoEntity;

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
public interface EntInverstInfoDao extends BaseMapper<EntInverstInfoEntity> {

	boolean insertBatch(List<EntInverstInfoEntity> list);
	
}
