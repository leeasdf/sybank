package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntAnnualreportShareholderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:08
 */
@Mapper
public interface EntAnnualreportShareholderDao extends BaseMapper<EntAnnualreportShareholderEntity> {

	boolean insertBatch(List<EntAnnualreportShareholderEntity> list);
	
}
