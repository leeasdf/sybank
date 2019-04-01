package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.spider.dao.SysTaskResultDao;
import xin.tianchuang.modules.spider.entity.SysTaskResultEntity;
import xin.tianchuang.modules.spider.service.SysTaskResultService;


@Service("sysTaskResultService")
public class SysTaskResultServiceImpl extends ServiceImpl<SysTaskResultDao, SysTaskResultEntity> implements SysTaskResultService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysTaskResultEntity> page = this.selectPage(
                new Query<SysTaskResultEntity>(params).getPage(),
                new EntityWrapper<SysTaskResultEntity>()
        );

        return new PageUtils(page);
    }

}
