package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntCourtAnnounceCompanyEntity;

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
public interface EntCourtAnnounceCompanyDao extends BaseMapper<EntCourtAnnounceCompanyEntity> {

	boolean insertBatch(List<EntCourtAnnounceCompanyEntity> list);
	
}
