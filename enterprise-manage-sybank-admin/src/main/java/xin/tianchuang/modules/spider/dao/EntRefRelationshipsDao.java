package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-02-20 21:47:37
 */
@Mapper
public interface EntRefRelationshipsDao extends BaseMapper<EntRefRelationshipsEntity> {

	boolean insertBatch(List<EntRefRelationshipsEntity> list);
	
}
