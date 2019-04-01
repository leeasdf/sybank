package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntPatentsInfoDao;
import xin.tianchuang.modules.spider.entity.EntPatentsInfoEntity;
import xin.tianchuang.modules.spider.service.EntPatentsInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entPatentsInfoService")
public class EntPatentsInfoServiceImpl extends ServiceImpl<EntPatentsInfoDao, EntPatentsInfoEntity> implements EntPatentsInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntPatentsInfoEntity> page = this.selectPage(new Query<EntPatentsInfoEntity>(params).getPage(), new EntityWrapper<EntPatentsInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntPatentsInfoEntity> ew = new EntityWrapper<EntPatentsInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntPatentsInfoEntity> selectByEntName(String entName) {
		Wrapper<EntPatentsInfoEntity> ew = new EntityWrapper<EntPatentsInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntPatentsInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
