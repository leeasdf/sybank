package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.EntIcpWebsiteDao;
import xin.tianchuang.modules.spider.entity.EntIcpWebsiteEntity;
import xin.tianchuang.modules.spider.service.EntIcpWebsiteService;


@Service("entIcpWebsiteService")
public class EntIcpWebsiteServiceImpl extends ServiceImpl<EntIcpWebsiteDao, EntIcpWebsiteEntity> implements EntIcpWebsiteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntIcpWebsiteEntity> page = this.selectPage(
                new Query<EntIcpWebsiteEntity>(params).getPage(),
                new EntityWrapper<EntIcpWebsiteEntity>()
        );

        return new PageUtils(page);
    }

}
