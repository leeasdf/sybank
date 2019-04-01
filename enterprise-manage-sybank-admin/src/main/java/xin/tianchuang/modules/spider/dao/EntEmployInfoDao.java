package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:01
 */
@Mapper
public interface EntEmployInfoDao extends BaseMapper<EntEmployInfoEntity> {

	boolean insertBatch(List<EntEmployInfoEntity> list);
	
}
