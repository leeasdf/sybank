package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntTmInfoDao;
import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;
import xin.tianchuang.modules.spider.service.EntTmInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entTmInfoService")
public class EntTmInfoServiceImpl extends ServiceImpl<EntTmInfoDao, EntTmInfoEntity> implements EntTmInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntTmInfoEntity> page = this.selectPage(new Query<EntTmInfoEntity>(params).getPage(), new EntityWrapper<EntTmInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntTmInfoEntity> ew = new EntityWrapper<EntTmInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntTmInfoEntity> selectByEntName(String entName) {
		Wrapper<EntTmInfoEntity> ew = new EntityWrapper<EntTmInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	
	@Override
	public boolean insertBatch(List<EntTmInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
