package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntDishonestInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;
import xin.tianchuang.modules.spider.service.EntDishonestInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entDishonestInfoService")
public class EntDishonestInfoServiceImpl extends ServiceImpl<EntDishonestInfoDao, EntDishonestInfoEntity> implements EntDishonestInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntDishonestInfoEntity> page = this.selectPage(new Query<EntDishonestInfoEntity>(params).getPage(), new EntityWrapper<EntDishonestInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntDishonestInfoEntity> ew = new EntityWrapper<EntDishonestInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntDishonestInfoEntity> selectListByEntName(String entName) {
		Wrapper<EntDishonestInfoEntity> ew = new EntityWrapper<EntDishonestInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntDishonestInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
