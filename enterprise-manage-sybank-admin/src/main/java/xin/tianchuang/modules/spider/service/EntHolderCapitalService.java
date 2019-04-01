package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHolderCapitalEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:10
 */
public interface EntHolderCapitalService extends IService<EntHolderCapitalEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);

	List<EntHolderCapitalEntity> selectListByPerson(String entName, String holderName);

	Integer deleteByEntNameHolderNameType(String entName, String holderName, int type);

}
