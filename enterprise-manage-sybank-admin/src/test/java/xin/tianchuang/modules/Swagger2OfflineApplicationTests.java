//package xin.tianchuang.modules;
//
//import com.alibaba.fastjson.JSON;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.operation.preprocess.Preprocessors;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import springfox.documentation.staticdocs.SwaggerResultHandler;
//import xin.tianchuang.modules.api.bean.api.loan.request.CommonApiCompanyReqDTO;
//import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
//
//import java.io.BufferedWriter;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/asciidoc/snippets")
//@WebAppConfiguration
//public class Swagger2OfflineApplicationTests {
//
//    private String snippetDir = "target/generated-snippets";
//    private String outputDir = "target/asciidoc";
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    @Before
//    public void setupMockMvc() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @After
//    public void Test() throws Exception {
//        // 得到swagger.json,写入outputDir目录中
////        mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
////                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
////                .andExpect(status().isOk())
////                .andReturn();
//        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
//        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
////        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
////                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
////                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
////                .withExamples(snippetDir)
////                .build()
////                .intoFolder(outputDir);// 输出
//
////        //    输出Ascii格式
////        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
////                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
////                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
////                .build();
////
////        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
////                .withConfig(config)
////                .build()
////                .toFolder(Paths.get(outputDir));
//
////        mockMvc.perform(RestDocumentationRequestBuilders.get("/v2/api-docs")
////                .accept(MediaType.APPLICATION_JSON))
////                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andReturn();
////
////        // 读取上一步生成的swagger.json转成asciiDoc,写入到outputDir
////        // 这个outputDir必须和插件里面<generated></generated>标签配置一致
////        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
////                .withPathsGroupedBy(GroupBy.TAGS)// 按tag排序
////                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)// 格式
////                .withExamples(snippetDir)
////                .build()
////                .intoFolder(outputDir);// 输出
//    }
//
//
//    @Test
//    public void testGetBaseinfoSet() {
//        try {
//            CommonApiCompanyReqDTO reqDTO = new CommonApiCompanyReqDTO();
//            reqDTO.setName("中亚新材料科技泗阳有限公司");
//            reqDTO.setBizCode("2323232232");
////            mockMvc.perform(post("/api/common/baseinfoSet")
////                    .contentType(MediaType.APPLICATION_JSON)
////                    .content(JSON.toJSONString(reqDTO))
////                    .accept(MediaType.APPLICATION_JSON))
////                    .andExpect(status().is2xxSuccessful())
////                    .andDo(MockMvcRestDocumentation.document("/api/common/baseinfoSet", preprocessResponse(prettyPrint())));
//
//            mockMvc.perform(get("/api/common/baseinfoSet")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(JSON.toJSONString(reqDTO))
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andDo(document("/api/common/baseinfoSet",
//                            Preprocessors.preprocessResponse(Preprocessors.prettyPrint())))
//                    .andExpect(status().isOk());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void testGetBaseinfoV3() {
//        try {
//            BizRequestParamDTO reqDTO = new BizRequestParamDTO();
////            reqDTO.setName("江苏乐家冷弯型钢股份有限公司");
//            reqDTO.setName("泗阳致远中学");
//            mockMvc.perform(post("/api/open/tyc/baseinfoV3")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(JSON.toJSONString(reqDTO))
//                    .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is2xxSuccessful())
//                    .andDo(document("/api/open/tyc/baseinfoV3", preprocessResponse(prettyPrint())))
//                    .andReturn();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void createSpringfoxSwaggerJson() throws Exception {
//
//        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
//        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        MockHttpServletResponse response = mvcResult.getResponse();
//        String swaggerJson = response.getContentAsString();
//        Files.createDirectories(Paths.get(outputDir));
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)) {
//            writer.write(swaggerJson);
//        }
//    }
//}