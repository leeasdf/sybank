package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntStaffInfoDao;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;
import xin.tianchuang.modules.spider.entity.EntStaffPositionEntity;
import xin.tianchuang.modules.spider.service.EntStaffInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entStaffInfoService")
public class EntStaffInfoServiceImpl extends ServiceImpl<EntStaffInfoDao, EntStaffInfoEntity> implements EntStaffInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntStaffInfoEntity> page = this.selectPage(new Query<EntStaffInfoEntity>(params).getPage(), new EntityWrapper<EntStaffInfoEntity>());
		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntStaffInfoEntity> ew = new EntityWrapper<EntStaffInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public Integer selectByCondition(EntStaffInfoEntity staffInfoEntity) {
		Wrapper<EntStaffInfoEntity> wrapper = new EntityWrapper<>();
		wrapper.and("ent_id", staffInfoEntity.getEntId());
		wrapper.and("ent_name", staffInfoEntity.getName());
		wrapper.and("type", staffInfoEntity.getType());
		wrapper.and("type_join", staffInfoEntity.getTypeJoin());

		return this.baseMapper.selectCount(wrapper);
	}

	@Override
	public List<EntStaffInfoEntity> selectListByName(String entName) {
		Wrapper<EntStaffInfoEntity> ew = new EntityWrapper<EntStaffInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntStaffInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
