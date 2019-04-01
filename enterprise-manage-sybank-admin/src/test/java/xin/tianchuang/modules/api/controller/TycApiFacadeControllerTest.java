//package xin.tianchuang.modules.api.controller;
//
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import xin.tianchuang.modules.BaseControllerTest;
//import xin.tianchuang.modules.api.form.ApiQueryForm;
//
//import com.google.gson.Gson;
//
//public class TycApiFacadeControllerTest extends BaseControllerTest {
//
//	// private String tokenId =
//	// "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwIiwiZXhwIjoxNTM5ODU0MDQ0LCJ1c2VySWQiOjAsImlhdCI6MTUzOTI0OTI0NH0.XJBWSvsVmpj5EdJZZyCOywm-MeJs5lWqxMG3dovdGzsZwxxZjTH535zVy-qUb3Nz87XJSffTMEDEAA5-AoC0Kg";
//	private String appId = "111111";
//	private String tokenId = "a3e33b69c0bae57f3c46a33c27026104";
//	ApiQueryForm apiQueryForm;
//
//	@Before
//	public void init() throws Exception {
//		apiQueryForm = new ApiQueryForm();
//		apiQueryForm.setAppId(appId);
//		apiQueryForm.setTokenKey(tokenId);
//		apiQueryForm.setCreditCode("");
//		apiQueryForm.setName("云南福润餐饮有限公司");
//	}
//
//	@Test
//	public void testGetGxstBaseInfo() throws Exception {
//		String uri = "/api/v1/getGxstBaseInfo";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetStaff() throws Exception {
//		String uri = "/api/v1/getStaff";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetHolder() throws Exception {
//		String uri = "/api/v1/getHolder";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetInvest() throws Exception {
//		String uri = "/api/v1/getInvest";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetChange() throws Exception {
//		String uri = "/api/v1/getChange";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetBranch() throws Exception {
//		String uri = "/api/v1/getBranch";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetTmInfo() throws Exception {
//		String uri = "/api/v1/getTmInfo";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetPatent() throws Exception {
//		String uri = "/api/v1/getPatent";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetCopyright() throws Exception {
//		String uri = "/api/v1/getCopyright";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetCopyrightWorks() throws Exception {
//		String uri = "/api/v1/getCopyrightWorks";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetIcp() throws Exception {
//		String uri = "/api/v1/getIcp";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetAnnouncement() throws Exception {
//		String uri = "/api/v1/getAnnouncement";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetLawsuit() throws Exception {
//		String uri = "/api/v1/getLawsuit";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetCourt() throws Exception {
//		String uri = "/api/v1/getCourt";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetDishonest() throws Exception {
//		String uri = "/api/v1/getDishonest";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetZhixing() throws Exception {
//		String uri = "/api/v1/getZhixing";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetAbnormal() throws Exception {
//		String uri = "/api/v1/getAbnormal";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetPunish() throws Exception {
//		String uri = "/api/v1/getPunish";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetIllegal() throws Exception {
//		String uri = "/api/v1/getIllegal";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetEquity() throws Exception {
//		String uri = "/api/v1/getEquity";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetOwntax() throws Exception {
//		String uri = "/api/v1/getOwntax";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetBid() throws Exception {
//		String uri = "/api/v1/getBid";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetTaxCredit() throws Exception {
//		String uri = "/api/v1/getTaxCredit";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetCheck() throws Exception {
//		String uri = "/api/v1/getCheck";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetImportAndExport() throws Exception {
//		String uri = "/api/v1/getImportAndExport";
//		getResult(uri, apiQueryForm);
//	}
//
//	@Test
//	public void testGetTcxyIpr() throws Exception {
//		String uri = "/api/v1/getTcxyIpr";
//		getResult(uri, apiQueryForm);
//	}
//
//	private void getResult(String uri, ApiQueryForm a) throws Exception {
//		ResultActions perform = mvc.perform(MockMvcRequestBuilders.get(uri) //
//				.param("appId", appId) //
//				.param("tokenKey", tokenId)//
//				.contentType(MediaType.APPLICATION_JSON_UTF8) //
//				.content(new Gson().toJson(a)) // 请求实体
//				.accept(MediaType.APPLICATION_JSON) // 断言返回结果是json
//				);
//		// 得到返回结果
//		// MvcResult mvcResult = perform.andReturn();
//		// 拿到请求返回码
//		// MockHttpServletResponse response = mvcResult.getResponse();
//		// 拿到结果
//		// String result = response.getContentAsString();
//		perform.andExpect(MockMvcResultMatchers.status().isOk()) //
//				.andDo(MockMvcResultHandlers.print()) //
//				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")) //
//				);
//	}
//
//}
