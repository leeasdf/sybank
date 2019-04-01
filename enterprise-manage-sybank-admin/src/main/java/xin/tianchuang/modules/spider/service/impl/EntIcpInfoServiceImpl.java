package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntIcpInfoDao;
import xin.tianchuang.modules.spider.entity.EntIcpInfoEntity;
import xin.tianchuang.modules.spider.service.EntIcpInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entIcpInfoService")
public class EntIcpInfoServiceImpl extends ServiceImpl<EntIcpInfoDao, EntIcpInfoEntity> implements EntIcpInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntIcpInfoEntity> page = this.selectPage(new Query<EntIcpInfoEntity>(params).getPage(), new EntityWrapper<EntIcpInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String name) {
		Wrapper<EntIcpInfoEntity> ew = new EntityWrapper<EntIcpInfoEntity>();
		ew.eq("ent_name", name);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntIcpInfoEntity> selectByEntName(String name) {
		Wrapper<EntIcpInfoEntity> ew = new EntityWrapper<EntIcpInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntIcpInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
