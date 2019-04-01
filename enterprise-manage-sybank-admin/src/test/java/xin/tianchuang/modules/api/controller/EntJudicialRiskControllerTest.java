//package xin.tianchuang.modules.api.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
//import xin.tianchuang.modules.BaseControllerTest;
//import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
//import xin.tianchuang.modules.api.handler.QueryHandler;
//import xin.tianchuang.modules.api.handler.TycApiHandlerFactory;
//import xin.tianchuang.modules.api.handler.tyc.BranchHandler;
//import xin.tianchuang.modules.spider.entity.EntListInfoEntity;
//import xin.tianchuang.modules.spider.service.EntListInfoService;
//
//import java.util.UUID;
//
///**
// * Created by lee on 2019/2/28.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EntJudicialRiskControllerTest {
//
//
////    @Autowired
////    BranchHandler handler;
//    @Autowired
//    private TycApiHandlerFactory tycApiHandlerFactory;
//
//    @Autowired
//    private EntListInfoService entListInfoService;
//
//    @Test
//    public void TestlawSuit(){
//        BaseApiRequestDTO dto = new BaseApiRequestDTO();
//        dto.setName("北京百度网讯科技有限公司深圳分公司");
//        dto.setSeqNum(UUID.randomUUID().toString());
//        dto.setBizCode(UUID.randomUUID().toString());
//        QueryHandler handlder = tycApiHandlerFactory.create(TycInterfaceTypeEnum.BRANCH);
//        handlder.parseData(dto,null);
//    }
//
//    @Test
//    public void testUpdate(){
//       EntListInfoEntity entity= entListInfoService.selectOneByName("中亚新材料科技泗阳有限公司");
//       entListInfoService.updateById(entity);
//    }
//
//
//}