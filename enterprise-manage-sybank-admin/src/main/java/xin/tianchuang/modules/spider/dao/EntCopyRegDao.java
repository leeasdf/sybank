package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntCopyRegEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:07
 */
@Mapper
public interface EntCopyRegDao extends BaseMapper<EntCopyRegEntity> {

	boolean insertBatch(List<EntCopyRegEntity> list);
	
}
