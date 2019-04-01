package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportBaseInfoDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportBaseInfoEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportBaseInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportBaseInfoService")
public class EntAnnualreportBaseInfoServiceImpl extends ServiceImpl<EntAnnualreportBaseInfoDao, EntAnnualreportBaseInfoEntity> implements EntAnnualreportBaseInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportBaseInfoEntity> page = this.selectPage(new Query<EntAnnualreportBaseInfoEntity>(params).getPage(), new EntityWrapper<EntAnnualreportBaseInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameReportYear(String entName, String reportYear) {
		Wrapper<EntAnnualreportBaseInfoEntity> ew = new EntityWrapper<EntAnnualreportBaseInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("report_year", reportYear);
		return this.baseMapper.delete(ew);
	}

	@Override
	public EntAnnualreportBaseInfoEntity selectByEntNameReportYear(String entName, String belongYear) {
		EntAnnualreportBaseInfoEntity entity = new EntAnnualreportBaseInfoEntity();
		entity.setEntName(entName);
		entity.setBelongYear(belongYear);

		return this.baseMapper.selectOne(entity);

	}
}
