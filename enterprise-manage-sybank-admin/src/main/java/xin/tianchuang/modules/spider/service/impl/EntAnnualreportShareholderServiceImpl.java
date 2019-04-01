package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportShareholderDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportShareholderEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportShareholderService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportShareholderService")
public class EntAnnualreportShareholderServiceImpl extends ServiceImpl<EntAnnualreportShareholderDao, EntAnnualreportShareholderEntity> implements EntAnnualreportShareholderService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportShareholderEntity> page = this.selectPage(new Query<EntAnnualreportShareholderEntity>(params).getPage(), new EntityWrapper<EntAnnualreportShareholderEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportShareholderEntity> ew = new EntityWrapper<EntAnnualreportShareholderEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportShareholderEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
