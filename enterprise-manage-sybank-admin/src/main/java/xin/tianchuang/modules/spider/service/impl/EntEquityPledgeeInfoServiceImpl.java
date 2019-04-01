package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.enums.EntEquityPledgeeTypeEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntEquityPledgeeInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntEquityPledgeeInfoEntity;
import xin.tianchuang.modules.spider.service.EntEquityPledgeeInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entEquityPledgeeInfoService")
public class EntEquityPledgeeInfoServiceImpl extends ServiceImpl<EntEquityPledgeeInfoDao, EntEquityPledgeeInfoEntity> implements EntEquityPledgeeInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntEquityPledgeeInfoEntity> page = this.selectPage(new Query<EntEquityPledgeeInfoEntity>(params).getPage(), new EntityWrapper<EntEquityPledgeeInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public boolean insertBatch(List<EntEquityPledgeeInfoEntity> list) {
		return baseMapper.insertBatch(list);

	}

	@Override
	public List<EntEquityPledgeeInfoEntity> selectListByEntNameAndTypeAndRegNumber(String name, EntEquityPledgeeTypeEnum entEquityPledgeeTypeEnum, String regNumber) {
		Wrapper<EntEquityPledgeeInfoEntity> ew = new EntityWrapper<EntEquityPledgeeInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("reg_number", regNumber);
		ew.eq("type", entEquityPledgeeTypeEnum.key());
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}

	@Override
	public Integer deleteByEntNameAndRegNumberAndType(String entName, String regNumber, int type) {
		Wrapper<EntEquityPledgeeInfoEntity> ew = new EntityWrapper<EntEquityPledgeeInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("reg_number", regNumber);
		ew.eq("type", type);
		return this.baseMapper.delete(ew);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntEquityPledgeeInfoEntity> ew = new EntityWrapper<EntEquityPledgeeInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}
}
