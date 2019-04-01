package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntCourtAnnounceCompanyDao;
import xin.tianchuang.modules.spider.entity.EntCourtAnnounceCompanyEntity;
import xin.tianchuang.modules.spider.service.EntCourtAnnounceCompanyService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entCourtAnnounceCompanyService")
public class EntCourtAnnounceCompanyServiceImpl extends ServiceImpl<EntCourtAnnounceCompanyDao, EntCourtAnnounceCompanyEntity> implements EntCourtAnnounceCompanyService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntCourtAnnounceCompanyEntity> page = this.selectPage(new Query<EntCourtAnnounceCompanyEntity>(params).getPage(), new EntityWrapper<EntCourtAnnounceCompanyEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByTycTableId(Long tableId) {
		Wrapper<EntCourtAnnounceCompanyEntity> ew = new EntityWrapper<EntCourtAnnounceCompanyEntity>();
		ew.eq("table_id", tableId);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntCourtAnnounceCompanyEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
