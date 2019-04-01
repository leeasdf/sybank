package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntTmInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:06
 */
public interface EntTmInfoService extends IService<EntTmInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);

	List<EntTmInfoEntity> selectByEntName(String name);

	public boolean insertBatch(List<EntTmInfoEntity> list);
}
