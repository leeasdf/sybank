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
import xin.tianchuang.modules.spider.dao.EntMortgagePeopleInfoDao;
import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;
import xin.tianchuang.modules.spider.entity.EntMortgagePeopleInfoEntity;
import xin.tianchuang.modules.spider.service.EntMortgagePeopleInfoService;

@Service("entMortgagePeopleInfoService")
public class EntMortgagePeopleInfoServiceImpl extends ServiceImpl<EntMortgagePeopleInfoDao, EntMortgagePeopleInfoEntity> implements EntMortgagePeopleInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntMortgagePeopleInfoEntity> page = this.selectPage(new Query<EntMortgagePeopleInfoEntity>(params).getPage(), new EntityWrapper<EntMortgagePeopleInfoEntity>());

		return new PageUtils(page);
	}
	@Override
	public boolean insertBatch(List<EntMortgagePeopleInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

	@Override
	public List<EntMortgagePeopleInfoEntity> selectListByEntNameAndRegNum(String name, String regNum) {
		Wrapper<EntMortgagePeopleInfoEntity> ew = new EntityWrapper<EntMortgagePeopleInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("reg_num", regNum);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}

	@Override
	public Integer deleteByEntNameAndRegNum(String entName, String regNum) {
		Wrapper<EntMortgagePeopleInfoEntity> ew = new EntityWrapper<EntMortgagePeopleInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("reg_num", regNum);
		return this.baseMapper.delete(ew);
	}
}
