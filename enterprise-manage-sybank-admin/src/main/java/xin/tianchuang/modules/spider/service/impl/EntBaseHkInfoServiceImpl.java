package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.EntBaseHkInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseHkInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseHkInfoService;


@Service("entBaseHkInfoService")
public class EntBaseHkInfoServiceImpl extends ServiceImpl<EntBaseHkInfoDao, EntBaseHkInfoEntity> implements EntBaseHkInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntBaseHkInfoEntity> page = this.selectPage(
                new Query<EntBaseHkInfoEntity>(params).getPage(),
                new EntityWrapper<EntBaseHkInfoEntity>()
        );

        return new PageUtils(page);
    }

}
