package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntRefRelationshipsDao;
import xin.tianchuang.modules.spider.entity.EntRefRelationshipsEntity;
import xin.tianchuang.modules.spider.service.EntRefRelationshipsService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entRefRelationshipsService")
public class EntRefRelationshipsServiceImpl extends ServiceImpl<EntRefRelationshipsDao, EntRefRelationshipsEntity> implements EntRefRelationshipsService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntRefRelationshipsEntity> page = this.selectPage(new Query<EntRefRelationshipsEntity>(params).getPage(), new EntityWrapper<EntRefRelationshipsEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntRefRelationshipsEntity> ew = new EntityWrapper<EntRefRelationshipsEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntRefRelationshipsEntity> selectListByEntName(String entName) {
		Wrapper<EntRefRelationshipsEntity> ew = new EntityWrapper<EntRefRelationshipsEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntRefRelationshipsEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
