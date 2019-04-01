package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntPunishCreditChinaEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:05
 */
@Mapper
public interface EntPunishCreditChinaDao extends BaseMapper<EntPunishCreditChinaEntity> {

	boolean insertBatch(List<EntPunishCreditChinaEntity> list);
	
}
