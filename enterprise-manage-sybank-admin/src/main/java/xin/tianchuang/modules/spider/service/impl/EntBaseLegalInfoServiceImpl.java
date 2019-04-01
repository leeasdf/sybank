package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.EntBaseLegalInfoDao;
import xin.tianchuang.modules.spider.entity.EntBaseLegalInfoEntity;
import xin.tianchuang.modules.spider.service.EntBaseLegalInfoService;


@Service("entBaseLegalInfoService")
public class EntBaseLegalInfoServiceImpl extends ServiceImpl<EntBaseLegalInfoDao, EntBaseLegalInfoEntity> implements EntBaseLegalInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntBaseLegalInfoEntity> page = this.selectPage(
                new Query<EntBaseLegalInfoEntity>(params).getPage(),
                new EntityWrapper<EntBaseLegalInfoEntity>()
        );

        return new PageUtils(page);
    }

}
