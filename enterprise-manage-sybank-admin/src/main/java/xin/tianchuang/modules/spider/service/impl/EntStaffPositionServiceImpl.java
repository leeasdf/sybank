package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntStaffPositionDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntStaffPositionEntity;
import xin.tianchuang.modules.spider.service.EntStaffPositionService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entStaffPositionService")
public class EntStaffPositionServiceImpl extends ServiceImpl<EntStaffPositionDao, EntStaffPositionEntity> implements EntStaffPositionService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntStaffPositionEntity> page = this.selectPage(new Query<EntStaffPositionEntity>(params).getPage(), new EntityWrapper<EntStaffPositionEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByName(String entName, String name) {
		Wrapper<EntStaffPositionEntity> ew = new EntityWrapper<EntStaffPositionEntity>();
		ew.eq("ent_name", entName);
		ew.eq("name", name);
		return this.baseMapper.delete(ew);
	}
	
	@Override
	public boolean insertBatch(List<EntStaffPositionEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
