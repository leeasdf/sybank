package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntZhixingInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntZhixingInfoEntity;
import xin.tianchuang.modules.spider.service.EntZhixingInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;

@Service("entZhixingInfoService")
public class EntZhixingInfoServiceImpl extends ServiceImpl<EntZhixingInfoDao, EntZhixingInfoEntity> implements EntZhixingInfoService {

	@Resource
	private EntZhixingInfoDao entZhixingInfoDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntZhixingInfoEntity> page = this.selectPage(new Query<EntZhixingInfoEntity>(params).getPage(), new EntityWrapper<EntZhixingInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntZhixingInfoEntity> ew = new EntityWrapper<EntZhixingInfoEntity>();
		ew.eq("ent_name", entName).eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntZhixingInfoEntity> selectListByEntName(String entName) {
		Wrapper<EntZhixingInfoEntity> ew = new EntityWrapper<EntZhixingInfoEntity>();
		ew.eq("ent_name", entName).eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public Double sumExecMoney(String entName) {
		return entZhixingInfoDao.sumExecMoney(entName);
	}
	@Override
	public boolean insertBatch(List<EntZhixingInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
