
package xin.tianchuang.modules.sys.service;


import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.sys.entity.SysLogEntity;


/**
 * 系统日志
 * 
 * @author hui.deng
 * 
 * @date 2017-03-08 10:40:56
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
