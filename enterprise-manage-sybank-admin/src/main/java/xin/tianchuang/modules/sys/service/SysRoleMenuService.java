package xin.tianchuang.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;

import xin.tianchuang.modules.sys.entity.SysRoleMenuEntity;



/**
 * 角色与菜单对应关系
 * 
 * @author hui.deng
 * 
 * @date 2016年9月18日 上午9:42:30
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
	
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
	
}
