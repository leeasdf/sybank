package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBidsInfoDao;
import xin.tianchuang.modules.spider.entity.EntBidsInfoEntity;
import xin.tianchuang.modules.spider.service.EntBidsInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entBidsInfoService")
public class EntBidsInfoServiceImpl extends ServiceImpl<EntBidsInfoDao, EntBidsInfoEntity> implements EntBidsInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntBidsInfoEntity> page = this.selectPage(new Query<EntBidsInfoEntity>(params).getPage(), new EntityWrapper<EntBidsInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntBidsInfoEntity> ew = new EntityWrapper<EntBidsInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntBidsInfoEntity> selectByEntName(String name) {
		Wrapper<EntBidsInfoEntity> ew = new EntityWrapper<EntBidsInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntBidsInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
