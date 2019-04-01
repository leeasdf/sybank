package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBaseFoundationInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseFoundationInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseFoundationInfoService;

@Service("entBaseFoundationInfoService")
public class EntBaseFoundationInfoServiceImpl extends ServiceImpl<EntBaseFoundationInfoDao, EntBaseFoundationInfoEntity> implements EntBaseFoundationInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBaseFoundationInfoEntity> page = this.selectPage(new Query<EntBaseFoundationInfoEntity>(params).getPage(), new EntityWrapper<EntBaseFoundationInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntBaseFoundationInfoEntity selectOneByName(String entName) {
		EntBaseFoundationInfoEntity entity = new EntBaseFoundationInfoEntity();
		entity.setName(entName);
		return this.baseMapper.selectOne(entity);
	}

}
