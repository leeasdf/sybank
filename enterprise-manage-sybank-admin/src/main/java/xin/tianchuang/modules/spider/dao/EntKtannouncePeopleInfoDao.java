package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;

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
public interface EntKtannouncePeopleInfoDao extends BaseMapper<EntKtannouncePeopleInfoEntity> {

	boolean insertBatch(List<EntKtannouncePeopleInfoEntity> list);
	
}
