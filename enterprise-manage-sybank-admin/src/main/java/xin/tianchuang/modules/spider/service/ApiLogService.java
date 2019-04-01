package xin.tianchuang.modules.spider.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import xin.tianchuang.common.enums.ApiStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-20 19:01:50
 */
public interface ApiLogService extends IService<ApiLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ApiLogEntity> selectListByStatusAndRetryTiemsAndTime(ApiStatusEnum process, Integer defaultRetryTimes, Date time);
}

