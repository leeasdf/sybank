package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntCourtAnnounceInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;

@Service("entCourtAnnounceInfoService")
public class EntCourtAnnounceInfoServiceImpl extends ServiceImpl<EntCourtAnnounceInfoDao, EntCourtAnnounceInfoEntity> implements EntCourtAnnounceInfoService {

	@Resource
	private EntCourtAnnounceInfoDao entCourtAnnounceInfoDao;
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntCourtAnnounceInfoEntity> page = this.selectPage(new Query<EntCourtAnnounceInfoEntity>(params).getPage(), new EntityWrapper<EntCourtAnnounceInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntCourtAnnounceInfoEntity> ew = new EntityWrapper<EntCourtAnnounceInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntCourtAnnounceInfoEntity> selectListByEntName(String entName) {
		Wrapper<EntCourtAnnounceInfoEntity> ew = new EntityWrapper<EntCourtAnnounceInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public List<EntCourtAnnounceInfoEntity> selectListByEntNameBltntype(String entName, String bltntypename) {
		Wrapper<EntCourtAnnounceInfoEntity> ew = new EntityWrapper<EntCourtAnnounceInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.eq("bltntypename", bltntypename);
		return this.baseMapper.selectList(ew);
	}

	@Override
	public Integer countAccused(String entName) {
		return entCourtAnnounceInfoDao.countAccused("%" + entName + "%");
	}
	@Override
	public boolean insertBatch(List<EntCourtAnnounceInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
