package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportWebInfoDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportWebInfoEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportWebInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportWebInfoService")
public class EntAnnualreportWebInfoServiceImpl extends ServiceImpl<EntAnnualreportWebInfoDao, EntAnnualreportWebInfoEntity> implements EntAnnualreportWebInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportWebInfoEntity> page = this.selectPage(new Query<EntAnnualreportWebInfoEntity>(params).getPage(), new EntityWrapper<EntAnnualreportWebInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportWebInfoEntity> ew = new EntityWrapper<EntAnnualreportWebInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportWebInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
