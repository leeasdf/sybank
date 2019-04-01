package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntMortgageBaseInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:05
 */
@Mapper
public interface EntMortgageBaseInfoDao extends BaseMapper<EntMortgageBaseInfoEntity> {

    boolean insertBatch(List<EntMortgageBaseInfoEntity> list);
}
