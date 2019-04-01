package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportSocialSecurityDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportSocialSecurityEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportSocialSecurityService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportSocialSecurityService")
public class EntAnnualreportSocialSecurityServiceImpl extends ServiceImpl<EntAnnualreportSocialSecurityDao, EntAnnualreportSocialSecurityEntity> implements EntAnnualreportSocialSecurityService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportSocialSecurityEntity> page = this.selectPage(new Query<EntAnnualreportSocialSecurityEntity>(params).getPage(), new EntityWrapper<EntAnnualreportSocialSecurityEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntAnnualreportSocialSecurityEntity> ew = new EntityWrapper<EntAnnualreportSocialSecurityEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public Integer deleteByAnnanlreportId(Long annaulreportId) {
		Wrapper<EntAnnualreportSocialSecurityEntity> ew = new EntityWrapper<EntAnnualreportSocialSecurityEntity>();
		ew.eq("annaulreport_id", annaulreportId);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportSocialSecurityEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
