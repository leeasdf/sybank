package xin.tianchuang.modules.spider.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntBaseLawInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseLawInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseLawInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entBaseLawInfoService")
public class EntBaseLawInfoServiceImpl extends ServiceImpl<EntBaseLawInfoDao, EntBaseLawInfoEntity> implements EntBaseLawInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntBaseLawInfoEntity> page = this.selectPage(
                new Query<EntBaseLawInfoEntity>(params).getPage(),
                new EntityWrapper<EntBaseLawInfoEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public EntBaseLawInfoEntity selectOneByName(String entName) {
		EntBaseLawInfoEntity entity = new EntBaseLawInfoEntity();
		entity.setName(entName);
		return this.baseMapper.selectOne(entity);
	}

}
