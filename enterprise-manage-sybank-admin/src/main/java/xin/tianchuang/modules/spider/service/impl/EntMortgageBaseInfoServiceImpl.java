package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntMortgageBaseInfoDao;
import xin.tianchuang.modules.spider.entity.EntMortgageBaseInfoEntity;
import xin.tianchuang.modules.spider.service.EntMortgageBaseInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entMortgageBaseInfoService")
public class EntMortgageBaseInfoServiceImpl extends ServiceImpl<EntMortgageBaseInfoDao, EntMortgageBaseInfoEntity> implements EntMortgageBaseInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntMortgageBaseInfoEntity> page = this.selectPage(new Query<EntMortgageBaseInfoEntity>(params).getPage(), new EntityWrapper<EntMortgageBaseInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntMortgageBaseInfoEntity> ew = new EntityWrapper<EntMortgageBaseInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

	@Override
	public List<EntMortgageBaseInfoEntity> selectListByEntName(String name) {
		Wrapper<EntMortgageBaseInfoEntity> ew = new EntityWrapper<EntMortgageBaseInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("data_status",DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}

	@Override
	public boolean insertBatch(List<EntMortgageBaseInfoEntity> list){
		return baseMapper.insertBatch(list);
	}
}
