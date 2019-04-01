package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntEquityInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEquityInfoEntity;
import xin.tianchuang.modules.spider.service.EntEquityInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entEquityInfoService")
public class EntEquityInfoServiceImpl extends ServiceImpl<EntEquityInfoDao, EntEquityInfoEntity> implements EntEquityInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntEquityInfoEntity> page = this.selectPage(new Query<EntEquityInfoEntity>(params).getPage(), new EntityWrapper<EntEquityInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntEquityInfoEntity> ew = new EntityWrapper<EntEquityInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntEquityInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

	@Override
	public List<EntEquityInfoEntity> selectListByEntName(String name) {
		Wrapper<EntEquityInfoEntity> ew = new EntityWrapper<EntEquityInfoEntity>();
		ew.eq("ent_name", name).eq("data_status",DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}
}
