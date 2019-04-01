package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntKtannounceInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;
import xin.tianchuang.modules.spider.service.EntKtannounceInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;

@Service("entKtannounceInfoService")
public class EntKtannounceInfoServiceImpl extends ServiceImpl<EntKtannounceInfoDao, EntKtannounceInfoEntity> implements EntKtannounceInfoService {

	@Resource
	private EntKtannounceInfoDao entKtannounceInfoDao;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntKtannounceInfoEntity> page = this.selectPage(new Query<EntKtannounceInfoEntity>(params).getPage(), new EntityWrapper<EntKtannounceInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntKtannounceInfoEntity> ew = new EntityWrapper<EntKtannounceInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntKtannounceInfoEntity> selectListByEntName(String entName) {
		Wrapper<EntKtannounceInfoEntity> ew = new EntityWrapper<EntKtannounceInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public Integer countAccused(String entName) {
		return entKtannounceInfoDao.countAccused("%" + entName + "%");
	}
	
	@Override
	public boolean insertBatch(List<EntKtannounceInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
