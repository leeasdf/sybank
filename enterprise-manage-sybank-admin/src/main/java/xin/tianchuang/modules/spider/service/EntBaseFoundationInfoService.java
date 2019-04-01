package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseFoundationInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:10
 */
public interface EntBaseFoundationInfoService extends IService<EntBaseFoundationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	EntBaseFoundationInfoEntity selectOneByName(String entName);
}

