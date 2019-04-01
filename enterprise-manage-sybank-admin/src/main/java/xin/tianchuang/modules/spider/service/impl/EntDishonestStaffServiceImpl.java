package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntDishonestStaffDao;
import xin.tianchuang.modules.spider.entity.EntDishonestStaffEntity;
import xin.tianchuang.modules.spider.service.EntDishonestStaffService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entDishonestStaffService")
public class EntDishonestStaffServiceImpl extends ServiceImpl<EntDishonestStaffDao, EntDishonestStaffEntity> implements EntDishonestStaffService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntDishonestStaffEntity> page = this.selectPage(new Query<EntDishonestStaffEntity>(params).getPage(), new EntityWrapper<EntDishonestStaffEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameAndCasecode(String entName,String casecode) {
		Wrapper<EntDishonestStaffEntity> ew = new EntityWrapper<EntDishonestStaffEntity>();
		ew.eq("ent_name", entName).eq("casecode",casecode);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntDishonestStaffEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
