package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHolderInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:10
 */
public interface EntHolderInfoService extends IService<EntHolderInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String name);

	List<EntHolderInfoEntity> selectListByName(String name);
}

