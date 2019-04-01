package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntPunishCreditChinaDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntPunishCreditChinaEntity;
import xin.tianchuang.modules.spider.service.EntPunishCreditChinaService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entPunishCreditChinaService")
public class EntPunishCreditChinaServiceImpl extends ServiceImpl<EntPunishCreditChinaDao, EntPunishCreditChinaEntity> implements EntPunishCreditChinaService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntPunishCreditChinaEntity> page = this.selectPage(new Query<EntPunishCreditChinaEntity>(params).getPage(), new EntityWrapper<EntPunishCreditChinaEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntPunishCreditChinaEntity> ew = new EntityWrapper<EntPunishCreditChinaEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntPunishCreditChinaEntity> selectListByEntName(String name) {
		Wrapper<EntPunishCreditChinaEntity> ew = new EntityWrapper<EntPunishCreditChinaEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntPunishCreditChinaEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
