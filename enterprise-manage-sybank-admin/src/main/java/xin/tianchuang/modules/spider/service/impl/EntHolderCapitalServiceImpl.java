package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntHolderCapitalDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntHolderCapitalEntity;
import xin.tianchuang.modules.spider.service.EntHolderCapitalService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entHolderCapitalService")
public class EntHolderCapitalServiceImpl extends ServiceImpl<EntHolderCapitalDao, EntHolderCapitalEntity> implements EntHolderCapitalService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntHolderCapitalEntity> page = this.selectPage(new Query<EntHolderCapitalEntity>(params).getPage(), new EntityWrapper<EntHolderCapitalEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntHolderCapitalEntity> ew = new EntityWrapper<EntHolderCapitalEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public Integer deleteByEntNameHolderNameType(String entName, String holderName, int type) {
		Wrapper<EntHolderCapitalEntity> ew = new EntityWrapper<EntHolderCapitalEntity>();
		ew.eq("ent_name", entName);
		ew.eq("holder_name", holderName);
		ew.eq("type", type);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntHolderCapitalEntity> selectListByPerson(String entName, String holderName) {
		Wrapper<EntHolderCapitalEntity> ew = new EntityWrapper<EntHolderCapitalEntity>();
		ew.eq("ent_name", entName);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		ew.eq("holder_name", holderName);
		return this.baseMapper.selectList(ew);
	}

	@Override
	public boolean insertBatch(List<EntHolderCapitalEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
