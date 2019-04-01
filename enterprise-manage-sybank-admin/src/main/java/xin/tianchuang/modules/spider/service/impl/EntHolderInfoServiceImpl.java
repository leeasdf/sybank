package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHolderInfoDao;
import xin.tianchuang.modules.spider.entity.EntHolderInfoEntity;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;
import xin.tianchuang.modules.spider.service.EntHolderInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entHolderInfoService")
public class EntHolderInfoServiceImpl extends ServiceImpl<EntHolderInfoDao, EntHolderInfoEntity> implements EntHolderInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntHolderInfoEntity> page = this.selectPage(new Query<EntHolderInfoEntity>(params).getPage(), new EntityWrapper<EntHolderInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String name) {
		Wrapper<EntHolderInfoEntity> ew = new EntityWrapper<EntHolderInfoEntity>();
		ew.eq("ent_name", name);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntHolderInfoEntity> selectListByName(String name) {
		Wrapper<EntHolderInfoEntity> ew = new EntityWrapper<EntHolderInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	
	@Override
	public boolean insertBatch(List<EntHolderInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
