package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntStaffPositionEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:10
 */
public interface EntStaffPositionService extends IService<EntStaffPositionEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByName(String entName, String name);
}

