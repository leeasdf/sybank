package xin.tianchuang.modules.sys.service;

import java.util.Set;

import xin.tianchuang.modules.sys.entity.SysUserEntity;
import xin.tianchuang.modules.sys.entity.SysUserTokenEntity;

/**
 * shiro相关接口
 * @author hui.deng
 * 
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
