package xin.tianchuang.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;

import xin.tianchuang.modules.sys.entity.SysUserRoleEntity;



/**
 * 用户与角色对应关系
 * 
 * @author hui.deng
 * 
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
