//package xin.tianchuang.modules.sys.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import xin.tianchuang.common.component.redis.RedisKeys;
//import xin.tianchuang.common.utils.RedisUtils;
//import xin.tianchuang.modules.sys.entity.SysMenuEntity;
//
///**
// * 系统配置Redis
// *
// * @author hui.deng
// * 
// * @date 2017/7/18 21:08
// */
//@Component
//public class SysMenuRedis {
//	@Autowired
//	private RedisUtils redisUtils;
//
//	public void saveOrUpdate(SysMenuEntity config) {
//		if (config == null) {
//			return;
//		}
//		String key = RedisKeys.getSysMenuKey(config.getMenuId());
//		redisUtils.set(key, config);
//	}
//
//	public void delete(String configKey) {
//		String key = RedisKeys.getSysConfigKey(configKey);
//		redisUtils.delete(key);
//	}
//
//	public SysMenuEntity get(String configKey) {
//		String key = RedisKeys.getSysConfigKey(configKey);
//		return redisUtils.get(key, SysMenuEntity.class);
//	}
//}
