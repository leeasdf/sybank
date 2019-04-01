package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.EntBaseLegalOfficeDao;
import xin.tianchuang.modules.spider.entity.EntBaseLegalOfficeEntity;
import xin.tianchuang.modules.spider.service.EntBaseLegalOfficeService;


@Service("entBaseLegalOfficeService")
public class EntBaseLegalOfficeServiceImpl extends ServiceImpl<EntBaseLegalOfficeDao, EntBaseLegalOfficeEntity> implements EntBaseLegalOfficeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntBaseLegalOfficeEntity> page = this.selectPage(
                new Query<EntBaseLegalOfficeEntity>(params).getPage(),
                new EntityWrapper<EntBaseLegalOfficeEntity>()
        );

        return new PageUtils(page);
    }

}
