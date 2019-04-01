package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntLawsuitInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:01
 */
@Mapper
public interface EntLawsuitInfoDao extends BaseMapper<EntLawsuitInfoEntity> {

	boolean insertBatch(List<EntLawsuitInfoEntity> list);
	
}
