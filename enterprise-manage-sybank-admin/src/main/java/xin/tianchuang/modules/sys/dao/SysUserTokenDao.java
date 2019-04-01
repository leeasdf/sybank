package xin.tianchuang.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.sys.entity.SysUserTokenEntity;

/**
 * 系统用户Token
 * 
 * @author hui.deng
 * 
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);

}
