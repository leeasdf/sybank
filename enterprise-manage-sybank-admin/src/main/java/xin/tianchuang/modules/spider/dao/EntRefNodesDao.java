package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
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
public interface EntRefNodesDao extends BaseMapper<EntRefNodesEntity> {

	boolean insertBatch(List<EntRefNodesEntity> list);
	
}
