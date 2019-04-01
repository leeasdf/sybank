package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportOutboundInvestmentDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportOutboundInvestmentEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportOutboundInvestmentService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportOutboundInvestmentService")
public class EntAnnualreportOutboundInvestmentServiceImpl extends ServiceImpl<EntAnnualreportOutboundInvestmentDao, EntAnnualreportOutboundInvestmentEntity> implements
		EntAnnualreportOutboundInvestmentService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportOutboundInvestmentEntity> page = this.selectPage(new Query<EntAnnualreportOutboundInvestmentEntity>(params).getPage(),
				new EntityWrapper<EntAnnualreportOutboundInvestmentEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportOutboundInvestmentEntity> ew = new EntityWrapper<EntAnnualreportOutboundInvestmentEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportOutboundInvestmentEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}