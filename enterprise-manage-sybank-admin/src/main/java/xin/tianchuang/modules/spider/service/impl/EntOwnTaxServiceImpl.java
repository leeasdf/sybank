package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntOwnTaxDao;
import xin.tianchuang.modules.spider.entity.EntOwnTaxEntity;
import xin.tianchuang.modules.spider.service.EntOwnTaxService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entOwnTaxService")
public class EntOwnTaxServiceImpl extends ServiceImpl<EntOwnTaxDao, EntOwnTaxEntity> implements EntOwnTaxService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntOwnTaxEntity> page = this.selectPage(new Query<EntOwnTaxEntity>(params).getPage(), new EntityWrapper<EntOwnTaxEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntOwnTaxEntity> ew = new EntityWrapper<EntOwnTaxEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntOwnTaxEntity> selectListByEntName(String name) {
		Wrapper<EntOwnTaxEntity> ew = new EntityWrapper<EntOwnTaxEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntOwnTaxEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

}
