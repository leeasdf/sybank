package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportOutGuaranteeInfoDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportOutGuaranteeInfoEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportOutGuaranteeInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportOutGuaranteeInfoService")
public class EntAnnualreportOutGuaranteeInfoServiceImpl extends ServiceImpl<EntAnnualreportOutGuaranteeInfoDao, EntAnnualreportOutGuaranteeInfoEntity> implements
		EntAnnualreportOutGuaranteeInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportOutGuaranteeInfoEntity> page = this.selectPage(new Query<EntAnnualreportOutGuaranteeInfoEntity>(params).getPage(),
				new EntityWrapper<EntAnnualreportOutGuaranteeInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportOutGuaranteeInfoEntity> ew = new EntityWrapper<EntAnnualreportOutGuaranteeInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportOutGuaranteeInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
