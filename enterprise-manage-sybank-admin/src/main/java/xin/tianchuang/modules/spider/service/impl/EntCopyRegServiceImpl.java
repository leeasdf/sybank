package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntCopyRegDao;
import xin.tianchuang.modules.spider.entity.EntCopyRegEntity;
import xin.tianchuang.modules.spider.service.EntCopyRegService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entCopyRegService")
public class EntCopyRegServiceImpl extends ServiceImpl<EntCopyRegDao, EntCopyRegEntity> implements EntCopyRegService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntCopyRegEntity> page = this.selectPage(new Query<EntCopyRegEntity>(params).getPage(), new EntityWrapper<EntCopyRegEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntCopyRegEntity> ew = new EntityWrapper<EntCopyRegEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntCopyRegEntity> selectByEntName(String entName) {
		Wrapper<EntCopyRegEntity> ew = new EntityWrapper<EntCopyRegEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	@Override
	public boolean insertBatch(List<EntCopyRegEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
