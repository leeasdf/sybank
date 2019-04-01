package xin.tianchuang.modules.spider.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntMortgagePawnInfoDao;
import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;
import xin.tianchuang.modules.spider.service.EntMortgagePawnInfoService;

import java.util.List;
import java.util.Map;

@Service("entMortgagePawnInfoService")
public class EntMortgagePawnInfoServiceImpl extends ServiceImpl<EntMortgagePawnInfoDao, EntMortgagePawnInfoEntity> implements EntMortgagePawnInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntMortgagePawnInfoEntity> page = this.selectPage(new Query<EntMortgagePawnInfoEntity>(params).getPage(), new EntityWrapper<EntMortgagePawnInfoEntity>());

		return new PageUtils(page);
	}
	@Override
	public boolean insertBatch(List<EntMortgagePawnInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}

	@Override
	public List<EntMortgagePawnInfoEntity> selectListByEntNameAndRegNum(String name, String regNum) {
		Wrapper<EntMortgagePawnInfoEntity> ew = new EntityWrapper<EntMortgagePawnInfoEntity>();
		ew.eq("ent_name", name);
		ew.eq("reg_num", regNum);
		ew.eq("data_status", DataStatusEnum.ACTIVE.key());
		return selectList(ew);
	}

	@Override
	public Integer deleteByEntNameAndRegNum(String entName, String regNum) {
		Wrapper<EntMortgagePawnInfoEntity> ew = new EntityWrapper<EntMortgagePawnInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("reg_num", regNum);
		return this.baseMapper.delete(ew);
	}
}
