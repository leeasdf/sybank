package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBaseSocialInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseSocialInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseSocialInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entBaseSocialInfoService")
public class EntBaseSocialInfoServiceImpl extends ServiceImpl<EntBaseSocialInfoDao, EntBaseSocialInfoEntity> implements EntBaseSocialInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBaseSocialInfoEntity> page = this.selectPage(new Query<EntBaseSocialInfoEntity>(params).getPage(), new EntityWrapper<EntBaseSocialInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntBaseSocialInfoEntity selectOneByName(String entName) {
		EntBaseSocialInfoEntity entity = new EntBaseSocialInfoEntity();
		entity.setName(entName);
		return this.baseMapper.selectOne(entity);
	}

}
