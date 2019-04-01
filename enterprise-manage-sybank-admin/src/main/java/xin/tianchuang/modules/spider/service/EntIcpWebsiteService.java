package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntIcpWebsiteEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:06
 */
public interface EntIcpWebsiteService extends IService<EntIcpWebsiteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

