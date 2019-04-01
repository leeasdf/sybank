package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntRefNodesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-20 21:47:37
 */
public interface EntRefNodesService extends IService<EntRefNodesEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);

	List<EntRefNodesEntity> selectListByEntName(String entName);
}

