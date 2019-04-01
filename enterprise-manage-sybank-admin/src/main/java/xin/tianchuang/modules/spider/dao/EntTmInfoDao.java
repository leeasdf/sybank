package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:06
 */
@Mapper
public interface EntTmInfoDao extends BaseMapper<EntTmInfoEntity> {

	boolean insertBatch(List<EntTmInfoEntity> list);
	
}
