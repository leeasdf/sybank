package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBranchInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntBranchInfoEntity;
import xin.tianchuang.modules.spider.service.EntBranchInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entBranchInfoService")
public class EntBranchInfoServiceImpl extends ServiceImpl<EntBranchInfoDao, EntBranchInfoEntity> implements EntBranchInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBranchInfoEntity> page = this.selectPage(new Query<EntBranchInfoEntity>(params).getPage(), new EntityWrapper<EntBranchInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntBranchInfoEntity> ew = new EntityWrapper<EntBranchInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntBranchInfoEntity> selectListByName(String entName) {
		Wrapper<EntBranchInfoEntity> ew = new EntityWrapper<EntBranchInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntBranchInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
