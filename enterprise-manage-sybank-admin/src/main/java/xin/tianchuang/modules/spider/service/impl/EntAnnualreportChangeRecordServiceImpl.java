package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportChangeRecordDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportChangeRecordEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportChangeRecordService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportChangeRecordService")
public class EntAnnualreportChangeRecordServiceImpl extends ServiceImpl<EntAnnualreportChangeRecordDao, EntAnnualreportChangeRecordEntity> implements EntAnnualreportChangeRecordService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportChangeRecordEntity> page = this.selectPage(new Query<EntAnnualreportChangeRecordEntity>(params).getPage(), new EntityWrapper<EntAnnualreportChangeRecordEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportChangeRecordEntity> ew = new EntityWrapper<EntAnnualreportChangeRecordEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportChangeRecordEntity> list) {
		return baseMapper.insertBatch(list);
	}
}
