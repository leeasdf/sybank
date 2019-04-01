package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBaseInstitutionInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseInstitutionInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseInstitutionInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entBaseInstitutionInfoService")
public class EntBaseInstitutionInfoServiceImpl extends ServiceImpl<EntBaseInstitutionInfoDao, EntBaseInstitutionInfoEntity> implements EntBaseInstitutionInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBaseInstitutionInfoEntity> page = this.selectPage(new Query<EntBaseInstitutionInfoEntity>(params).getPage(), new EntityWrapper<EntBaseInstitutionInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntBaseInstitutionInfoEntity selectOneByName(String entName) {
		EntBaseInstitutionInfoEntity entity = new EntBaseInstitutionInfoEntity();
		entity.setName(entName);
		return this.baseMapper.selectOne(entity);
	}

}
