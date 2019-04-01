package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportInfoDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportInfoEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportInfoService")
public class EntAnnualreportInfoServiceImpl extends ServiceImpl<EntAnnualreportInfoDao, EntAnnualreportInfoEntity> implements EntAnnualreportInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportInfoEntity> page = this.selectPage(new Query<EntAnnualreportInfoEntity>(params).getPage(), new EntityWrapper<EntAnnualreportInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBlongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportInfoEntity> ew = new EntityWrapper<EntAnnualreportInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}

	@Override
	public EntAnnualreportInfoEntity selectByEntNameBelongYear(String entName, String belongYear) {
		EntAnnualreportInfoEntity entity = new EntAnnualreportInfoEntity();
		entity.setEntName(entName);
		entity.setBelongYear(belongYear);

		return this.baseMapper.selectOne(entity);
	}

}
