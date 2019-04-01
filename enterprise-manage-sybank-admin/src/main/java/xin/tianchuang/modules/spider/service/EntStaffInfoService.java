package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntStaffInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2019-01-28 16:31:11
 */
public interface EntStaffInfoService extends IService<EntStaffInfoEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 根据企业名称删除数据
	 * 
	 * @param name
	 * @return
	 */
	Integer deleteByEntName(String entName);

	Integer selectByCondition(EntStaffInfoEntity staffInfoEntity);

	List<EntStaffInfoEntity> selectListByName(String entName);
}
