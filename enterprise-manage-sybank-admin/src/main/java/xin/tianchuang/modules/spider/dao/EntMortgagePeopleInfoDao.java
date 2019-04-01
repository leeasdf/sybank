package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntMortgagePeopleInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:04
 */
@Mapper
public interface EntMortgagePeopleInfoDao extends BaseMapper<EntMortgagePeopleInfoEntity> {

	boolean insertBatch(List<EntMortgagePeopleInfoEntity> list);
	
}
