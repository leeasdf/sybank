
package xin.tianchuang.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.sys.dao.SysLogDao;
import xin.tianchuang.modules.sys.entity.SysLogEntity;
import xin.tianchuang.modules.sys.service.SysLogService;

import java.util.Map;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");
        String operation = (String)params.get("operation");
        String ip = (String)params.get("ip");
        Page<SysLogEntity> page = this.selectPage(
            new Query<SysLogEntity>(params).getPage(),
            new EntityWrapper<SysLogEntity>() //
            .like(StringUtils.isNotBlank(username),"username", username) //
            .like(StringUtils.isNotBlank(operation),"operation", operation) //
            .like(StringUtils.isNotBlank(ip),"ip", ip) //
            .orderBy("create_date", false)
        );

        return new PageUtils(page);
    }
}
