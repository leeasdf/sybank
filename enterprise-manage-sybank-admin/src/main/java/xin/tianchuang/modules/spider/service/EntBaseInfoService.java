package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:11
 */
public interface EntBaseInfoService extends IService<EntBaseInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	EntBaseInfoEntity selectOneByEntName(String name);

	EntBaseInfoEntity selectOneByCreditCode(String creditCode);

	List<EntBaseInfoEntity> selectByCreateDate(String beginDate);

	EntBaseInfoEntity selectOneByTycId(Long id);

	EntBaseInfoEntity selectByEntId(Integer id);

}
