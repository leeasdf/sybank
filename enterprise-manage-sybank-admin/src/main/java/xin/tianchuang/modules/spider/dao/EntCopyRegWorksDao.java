package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntCopyRegWorksEntity;
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
public interface EntCopyRegWorksDao extends BaseMapper<EntCopyRegWorksEntity> {

	boolean insertBatch(List<EntCopyRegWorksEntity> list);
	
}
