package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntChangeInfoDao;
import xin.tianchuang.modules.spider.entity.EntAbnormalInfoEntity;
import xin.tianchuang.modules.spider.entity.EntChangeInfoEntity;
import xin.tianchuang.modules.spider.service.EntChangeInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entChangeInfoService")
public class EntChangeInfoServiceImpl extends ServiceImpl<EntChangeInfoDao, EntChangeInfoEntity> implements EntChangeInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntChangeInfoEntity> page = this.selectPage(
                new Query<EntChangeInfoEntity>(params).getPage(),
                new EntityWrapper<EntChangeInfoEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer deleteByEntName(String entName) {
		Wrapper<EntChangeInfoEntity> ew = new EntityWrapper<EntChangeInfoEntity>();
		ew.eq("ent_name", entName);
		return this.baseMapper.delete(ew);
	}

    @Override
    public List<EntChangeInfoEntity> selectListByName(String entName) {
        Wrapper<EntChangeInfoEntity> ew = new EntityWrapper<EntChangeInfoEntity>();
        ew.eq("ent_name", entName);
        ew.eq("data_status", DataStatusEnum.ACTIVE.key());
        return this.baseMapper.selectList(ew);
    }
    
    @Override
	public boolean insertBatch(List<EntChangeInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
