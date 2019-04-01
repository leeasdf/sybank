package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseLawInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:10
 */
public interface EntBaseLawInfoService extends IService<EntBaseLawInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	EntBaseLawInfoEntity selectOneByName(String entName);
}

