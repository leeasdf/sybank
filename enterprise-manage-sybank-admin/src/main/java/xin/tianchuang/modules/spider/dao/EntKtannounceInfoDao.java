package xin.tianchuang.modules.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:03
 */
@Mapper
public interface EntKtannounceInfoDao extends BaseMapper<EntKtannounceInfoEntity> {

    @Select("select count(distinct table_id) from ENT_KTANNOUNCE_PEOPLE_INFO where people_type=2 and name like #{likeEntName}")
    Integer countAccused(@Param("likeEntName") String likeEntName);

	boolean insertBatch(List<EntKtannounceInfoEntity> list);
}
