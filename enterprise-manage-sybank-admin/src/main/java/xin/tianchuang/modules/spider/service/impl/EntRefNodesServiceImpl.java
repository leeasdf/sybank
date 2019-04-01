package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntRefNodesDao;
import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;
import xin.tianchuang.modules.spider.service.EntRefNodesService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entRefNodesService")
public class EntRefNodesServiceImpl extends ServiceImpl<EntRefNodesDao, EntRefNodesEntity> implements EntRefNodesService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntRefNodesEntity> page = this.selectPage(new Query<EntRefNodesEntity>(params).getPage(), new EntityWrapper<EntRefNodesEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntRefNodesEntity> ew = new EntityWrapper<EntRefNodesEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntRefNodesEntity> selectListByEntName(String entName) {
		Wrapper<EntRefNodesEntity> ew = new EntityWrapper<EntRefNodesEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntRefNodesEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
