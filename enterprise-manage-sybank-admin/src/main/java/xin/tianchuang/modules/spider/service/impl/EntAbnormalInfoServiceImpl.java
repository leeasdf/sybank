package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAbnormalInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.service.EntAbnormalInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAbnormalInfoService")
public class EntAbnormalInfoServiceImpl extends ServiceImpl<EntAbnormalInfoDao, EntAbnormalInfoEntity> implements EntAbnormalInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAbnormalInfoEntity> page = this.selectPage(new Query<EntAbnormalInfoEntity>(params).getPage(), new EntityWrapper<EntAbnormalInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntAbnormalInfoEntity> ew = new EntityWrapper<EntAbnormalInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntAbnormalInfoEntity> selectListByEntName(String name) {
		Wrapper<EntAbnormalInfoEntity> ew = new EntityWrapper<EntAbnormalInfoEntity>();
		ew.eq("ent_name", name).eq("data_status", DataStatusEnum.ACTIVE.key());
		return this.baseMapper.selectList(ew);
	}

	@Override
	public boolean insertBatch(List<EntAbnormalInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

	

}
