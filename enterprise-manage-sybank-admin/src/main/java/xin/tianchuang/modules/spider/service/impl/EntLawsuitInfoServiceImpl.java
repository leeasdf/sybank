package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntLawsuitInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntLawsuitInfoEntity;
import xin.tianchuang.modules.spider.service.EntLawsuitInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entLawsuitInfoService")
public class EntLawsuitInfoServiceImpl extends ServiceImpl<EntLawsuitInfoDao, EntLawsuitInfoEntity> implements EntLawsuitInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntLawsuitInfoEntity> page = this.selectPage(new Query<EntLawsuitInfoEntity>(params).getPage(), new EntityWrapper<EntLawsuitInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntLawsuitInfoEntity> ew = new EntityWrapper<EntLawsuitInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntLawsuitInfoEntity> selectListByEntName(String entName) {
		Wrapper<EntLawsuitInfoEntity> ew = new EntityWrapper<EntLawsuitInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntLawsuitInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
