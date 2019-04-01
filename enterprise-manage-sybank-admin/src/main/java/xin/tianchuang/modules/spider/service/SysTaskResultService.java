package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.SysTaskResultEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-03-09 16:21:28
 */
public interface SysTaskResultService extends IService<SysTaskResultEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

