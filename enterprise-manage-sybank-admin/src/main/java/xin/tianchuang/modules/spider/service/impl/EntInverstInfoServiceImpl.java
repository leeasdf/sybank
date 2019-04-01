package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntInverstInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntInverstInfoEntity;
import xin.tianchuang.modules.spider.service.EntInverstInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entInverstInfoService")
public class EntInverstInfoServiceImpl extends ServiceImpl<EntInverstInfoDao, EntInverstInfoEntity> implements EntInverstInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntInverstInfoEntity> page = this.selectPage(new Query<EntInverstInfoEntity>(params).getPage(), new EntityWrapper<EntInverstInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntInverstInfoEntity> ew = new EntityWrapper<EntInverstInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntInverstInfoEntity> selectListByName(String name) {
		Wrapper<EntInverstInfoEntity> ew = new EntityWrapper<EntInverstInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}
	
	@Override
	public boolean insertBatch(List<EntInverstInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
