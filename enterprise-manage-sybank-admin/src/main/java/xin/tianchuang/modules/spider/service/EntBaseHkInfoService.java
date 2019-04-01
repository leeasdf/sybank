package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseHkInfoEntity;

import java.util.Map;

/**
 * 香港公司信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:11
 */
public interface EntBaseHkInfoService extends IService<EntBaseHkInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

