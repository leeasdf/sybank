package xin.tianchuang.modules.spider.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 企业名录信息
 * 
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:11
 */
@Mapper
public interface EntListInfoDao extends BaseMapper<EntListInfoEntity> {

    @Select(
            "select * from (" +
            "SELECT rownumber() over(order by ID asc) as rowid , a.* from" +
            "(select * from ENT_LIST_INFO) a" +
            ") tmp where  tmp.rowid > #{startNum} and tmp.rowid <= #{startNum}+#{size}"
    )
    List<EntListInfoEntity> getPageEntListInfo(@Param("startNum") Integer startNum, @Param("size") Integer size);
}
