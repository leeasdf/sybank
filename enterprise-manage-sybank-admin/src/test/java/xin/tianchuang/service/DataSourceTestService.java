//
//package xin.tianchuang.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import xin.tianchuang.datasources.DataSourceNames;
//import xin.tianchuang.datasources.annotation.DataSource;
//import xin.tianchuang.modules.sys.entity.SysUserEntity;
//import xin.tianchuang.modules.sys.service.SysUserService;
//
///**
// * 测试多数据源
// *
// * @author xx
// * @since 3.1.0 2018-01-28
// */
//@Service
//public class DataSourceTestService {
//    @Autowired
//    private SysUserService sysUserService;
//
//    public SysUserEntity queryUser(Long userId){
//        return sysUserService.selectById(userId);
//    }
//
//    @DataSource(name = DataSourceNames.SECOND)
//    public SysUserEntity queryUser2(Long userId){
//        return sysUserService.selectById(userId);
//    }
//}
