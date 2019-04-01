package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntEmployInfoDao;
import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;
import xin.tianchuang.modules.spider.service.EntEmployInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entEmployInfoService")
public class EntEmployInfoServiceImpl extends ServiceImpl<EntEmployInfoDao, EntEmployInfoEntity> implements EntEmployInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntEmployInfoEntity> page = this.selectPage(new Query<EntEmployInfoEntity>(params).getPage(), new EntityWrapper<EntEmployInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntEmployInfoEntity> ew = new EntityWrapper<EntEmployInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntEmployInfoEntity> selectByEntName(String name) {
		Wrapper<EntEmployInfoEntity> ew = new EntityWrapper<EntEmployInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntEmployInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
