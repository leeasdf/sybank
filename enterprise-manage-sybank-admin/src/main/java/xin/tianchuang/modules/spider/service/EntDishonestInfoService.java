package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntDishonestInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:03
 */
public interface EntDishonestInfoService extends IService<EntDishonestInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);

	List<EntDishonestInfoEntity> selectListByEntName(String name);
}

