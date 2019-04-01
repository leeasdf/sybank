package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntNewsInfoDao;
import xin.tianchuang.modules.spider.entity.EntNewsInfoEntity;
import xin.tianchuang.modules.spider.service.EntNewsInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entNewsInfoService")
public class EntNewsInfoServiceImpl extends ServiceImpl<EntNewsInfoDao, EntNewsInfoEntity> implements EntNewsInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntNewsInfoEntity> page = this.selectPage(new Query<EntNewsInfoEntity>(params).getPage(), new EntityWrapper<EntNewsInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntNewsInfoEntity> ew = new EntityWrapper<EntNewsInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntNewsInfoEntity> selectByEntName(String entName) {
		Wrapper<EntNewsInfoEntity> ew = new EntityWrapper<EntNewsInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntNewsInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
