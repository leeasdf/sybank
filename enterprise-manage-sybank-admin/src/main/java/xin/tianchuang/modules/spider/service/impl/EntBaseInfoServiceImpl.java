package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBaseInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entBaseInfoService")
public class EntBaseInfoServiceImpl extends ServiceImpl<EntBaseInfoDao, EntBaseInfoEntity> implements EntBaseInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBaseInfoEntity> page = this.selectPage(new Query<EntBaseInfoEntity>(params).getPage(), new EntityWrapper<EntBaseInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public EntBaseInfoEntity selectOneByEntName(String name) {
		EntBaseInfoEntity entity = new EntBaseInfoEntity();
		entity.setEntName(name);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public EntBaseInfoEntity selectOneByCreditCode(String creditCode) {
		EntBaseInfoEntity entity = new EntBaseInfoEntity();
		entity.setCreditCode(creditCode);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public List<EntBaseInfoEntity> selectByCreateDate(String beginDate) {
		Wrapper<EntBaseInfoEntity> ew = new EntityWrapper<EntBaseInfoEntity>();
		ew.ge("create_time", beginDate);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public EntBaseInfoEntity selectOneByTycId(Long id) {
		EntBaseInfoEntity entity = new EntBaseInfoEntity();
		entity.setTycId(id);
		return this.baseMapper.selectOne(entity);
	}

	@Override
	public EntBaseInfoEntity selectByEntId(Integer entId) {
		EntBaseInfoEntity entity = new EntBaseInfoEntity();
		entity.setEntId(entId);
		return this.baseMapper.selectOne(entity);
	}
}
