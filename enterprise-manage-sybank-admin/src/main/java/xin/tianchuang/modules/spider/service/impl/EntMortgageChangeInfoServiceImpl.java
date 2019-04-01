package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntMortgageChangeInfoDao;
import xin.tianchuang.modules.spider.entity.EntMortgageChangeInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePeopleInfoEntity;
import xin.tianchuang.modules.spider.service.EntMortgageChangeInfoService;

@Service("entMortgageChangeInfoService")
public class EntMortgageChangeInfoServiceImpl extends ServiceImpl<EntMortgageChangeInfoDao, EntMortgageChangeInfoEntity> implements EntMortgageChangeInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntMortgageChangeInfoEntity> page = this.selectPage(new Query<EntMortgageChangeInfoEntity>(params).getPage(), new EntityWrapper<EntMortgageChangeInfoEntity>());

		return new PageUtils(page);
	}
	@Override
	public boolean insertBatch(List<EntMortgageChangeInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

	@Override
	public List<EntMortgageChangeInfoEntity> selectListByEntNameAndRegNum(String name, String regNum) {
		Wrapper<EntMortgageChangeInfoEntity> ew = new EntityWrapper<EntMortgageChangeInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("reg_num", regNum);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}

	@Override
	public Integer deleteByEntNameAndRegNum(String entName, String regNum) {
		Wrapper<EntMortgageChangeInfoEntity> ew = new EntityWrapper<EntMortgageChangeInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("reg_num", regNum);
		return this.baseMapper.delete(ew);
	}
}
