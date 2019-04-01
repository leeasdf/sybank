package xin.tianchuang.modules.spider.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xin.tianchuang.modules.spider.entity.EntReportLogEntity;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-02-27 11:17:27
 */
@Mapper
public interface EntReportLogDao extends BaseMapper<EntReportLogEntity> {

    @Select(
            "select * from ( " +
                    " SELECT rownumber() over(order by ID asc) as rowid , a.* from " +
                    " (select * from ent_report_log " +
                    " where data_status=1 " +
                    " and interface_type = #{type} " +
                    " and create_time>=  #{startTime}  and create_time<=  #{endTime}  ) a " +
                    " ) tmp where  tmp.rowid > #{startRows} and tmp.rowid <= #{endRows} "
    )
	List<EntReportLogEntity> selectPage(@Param("type") Integer type, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("startRows") int startRows,
			@Param("endRows") int endRows);
}
