package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntDishonestStaffEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-20 16:53:27
 */
public interface EntDishonestStaffService extends IService<EntDishonestStaffEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntNameAndCasecode(String entName,String casecode);
}

