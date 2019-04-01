package xin.tianchuang.modules.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:02
 */
@Mapper
public interface EntZhixingInfoDao extends BaseMapper<EntZhixingInfoEntity> {

    @Select("select sum(exec_money) from ENT_ZHIXING_INFO where ent_name = #{entName}  group by ent_name")
    Double sumExecMoney(@Param("entName") String entName);

	boolean insertBatch(List<EntZhixingInfoEntity> list);
}
