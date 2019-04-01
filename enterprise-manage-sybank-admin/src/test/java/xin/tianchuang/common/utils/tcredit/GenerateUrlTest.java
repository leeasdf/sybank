//package xin.tianchuang.common.utils.tcredit;
//
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//public class GenerateUrlTest {
//
//    private static final String appId = "a8e319a8b6f64b3e91024e7792a2c701";
//    private static final String tokenId = "5f69b81d04f14dfea669252892a25d0f";
//    private static final String baseUrl = "http://124.207.122.29:18080/dmp-service-web";
//
//    // 天创接口
//    private static final String getEnterprisePersonInfoUrl = "/service/tcredit/getEnterprisePersonInfo";
//    private static final String getAuthMotorVehicleInfoB = "/service/tcredit/getAuthMotorVehicleInfoB";
//    private static final String getRadar = "/service/tcredit/getRadar";
//    private static final String getRiskAssessmentBeeSmellV2 = "/service/tcredit/getRiskAssessmentBeeSmellV2";
//    private static final String getInfernalProbe = "/service/tcredit/getInfernalProbe";
//    private static final String getBadInfoB = "/service/tcredit/getBadInfoB";
//    private static final String getIndustryCommerceInfo = "/service/tcredit/getIndustryCommerceInfo";
//    private static final String getVserifyIdcardC = "/service/tcredit/getVserifyIdcardC";
//    private static final String getUnionpayTransactionVariableB = "/service/tcredit/getUnionpayTransactionVariableB";
//    private static final String getVerifyBankcardInfoDetail4 = "/service/tcredit/getVerifyBankcardInfoDetail4";
//    private static final String getVerifyMobileInfo3C = "/service/tcredit/getVerifyMobileInfo3C";
//    private static final String getConsumingProbe01 = "/service/tcredit/getConsumingProbe01";
//    private static final String getCmccOnlineTime = "/service/tcredit/getCmccOnlineTime";
//    private static final String getCmccState = "/service/tcredit/getCmccState";
//    private static final String getCreditProbe01 = "/service/tcredit/getCreditProbe01";
//
//    // Linkface接口
//    private static final String idcardOcr = "/service/linkface/idcardOcr";
//    private static final String checkLiveness = "/service/linkface/checkLiveness";
//    private static final String livenessImage = "/service/linkface/livenessImage";
//    private static final String livenessIdnumberVerification = "/service/linkface/livenessIdnumberVerification";
//
//    // 百度OCR接口
//    private static final String businessLicense = "/service/baidu/businessLicense";
//    private static final String vatInvoice = "/service/baidu/vatInvoice";
//
//    // 天眼查接口
//    private static final String tm = "/service/tianyancha/tm";    // 商标信息
//    private static final String copyRegWorks = "/service/tianyancha/copyRegWorks";    // 作品著作权
//    private static final String employmentsV2 = "/service/tianyancha/employmentsV2";    // 招聘_新版
//    private static final String oneKeyC = "/service/tianyancha/oneKeyC";    // 企业图谱_新版
//    private static final String news = "/service/tianyancha/news";    // 获取公司新闻列表
//    private static final String icp = "/service/tianyancha/icp";    // 网站备案
//    private static final String companyInfo = "/service/tianyancha/companyInfo";    // 企业简介_上市信息类接口
//    private static final String copyReg = "/service/tianyancha/copyReg";    // 著作权
//    private static final String bids = "/service/tianyancha/bids";    // 招投标
//    private static final String patents = "/service/tianyancha/patents";    // 天眼查专利
//    private static final String equityInfo = "/service/tianyancha/equityInfo";    // 股权出质
//    private static final String mortgageInfo = "/service/tianyancha/mortgageInfo";    // 动产抵押
//    private static final String creditChinaV2 = "/service/tianyancha/creditChinaV2";    // 行政处罚_信用中国_新版
//    private static final String abnormal = "/service/tianyancha/abnormal";    // 经营异常
//    private static final String ktannouncement = "/service/tianyancha/ktannouncement";    // 开庭公告
//    private static final String zhixinginfo = "/service/tianyancha/zhixinginfo";    // 被执行人
//    private static final String dishonestV2 = "/service/tianyancha/dishonestV2";    // 失信人_新版
//    private static final String courtAnnouncement = "/service/tianyancha/courtAnnouncement";    // 法院公告
//    private static final String lawSuit = "/service/tianyancha/lawSuit";    // 法律诉讼
//    private static final String branch = "/service/tianyancha/branch";    // 分支机构
//    private static final String changeinfo = "/service/tianyancha/changeinfo";    // 变更记录
//    private static final String annualreport = "/service/tianyancha/annualreport";    // 企业年报
//    private static final String inverst = "/service/tianyancha/inverst";    // 对外投资
//    private static final String holder = "/service/tianyancha/holder";    // 股东信息
//    private static final String baseinfoV3 = "/service/tianyancha/baseinfoV3";    // 获取企业基本信息_含主要人员
//    private static final String ownTax = "/service/tianyancha/ownTax";    // 欠税公告
//
//    // Mock接口
//    private static final String preCredit = "/service/tcredit/preCredit";
//    private static final String formalCredit = "/service/tcredit/formalCredit";
//    private static final String enterpriseNature = "/service/tcredit/enterpriseNature";
//
//
//
//
//    // Variable
//    private static final String name = "韦宏贵";
//    private static final String mobile = "18820601856";
//    private static final String idcard = "45272819940617271X";
//    private static final String bankcard = "6212262010011873905";
//    private static final String plate = "皖A261V0";
//    private static final String plateType = "02";
//    private static final String companyName = "腾讯科技（深圳）有限公司";
//    private static final String companyId = "25476889";
//    private static final String uniformCreditCode = "5101822400837";
//    private static final String idType = "01";
//    private static final String licNumber = "45272819940617271X";
//    private static final String motions = "BLINK";
//    private static final String complexity = "0";
//    private static final String liveness_data_file = "/data/pic/checkLiveness.mp4";
////    private static final String liveness_data_url = "";
//    private static final String anti_hack = "true";
//    private static final String imageId = "001000010101";
//    private static final String image = "/data/pic/abc.jpg";
//    private static final String image2 = "/data/pic/timg.jpg";
//    private static final String image3 = "/data/pic/bbbbb.jpg";
////    private static final String detect_direction = "";
////    private static final String accuracy = "";
//
//
//    //-------------------------天创接口start------------------------
//    @Test
//    public void getEnterprisePersonInfo() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("idcard", idcard);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 企业工商信息：" + baseUrl + getEnterprisePersonInfoUrl + "?" + finalParam);
//    }
//
//    @Test
//    public void getAuthMotorVehicleInfoB() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("plate", plate);
//        paramMap.put("plateType", plateType);
//        paramMap.put("name", name);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 车辆驾驶信息 -车辆信息验证_标准版：" + baseUrl + getAuthMotorVehicleInfoB + "?" + finalParam);
//    }
//
//    @Test
//    public void getRadar() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 风控信息 申请探针：" + baseUrl + getRadar + "?" + finalParam);
//    }
//
//    @Test
//    public void getRiskAssessmentBeeSmellV2() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 风控信息 生活探针：" + baseUrl + getRiskAssessmentBeeSmellV2 + "?" + finalParam);
//    }
//
//    @Test
//    public void getInfernalProbe() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 风控信息天创 无间探针：" + baseUrl + getInfernalProbe + "?" + finalParam);
//    }
//
//    @Test
//    public void getBadInfoB() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 公安信息 个人不良信息：" + baseUrl + getBadInfoB + "?" + finalParam);
//    }
//
//    @Test
//    public void getIndustryCommerceInfo() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("companyName", companyName);
//        paramMap.put("uniformCreditCode", uniformCreditCode);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 企业工商信息 - 企业工商信息查询_标准版：" + baseUrl + getIndustryCommerceInfo + "?" + finalParam);
//    }
//
//    @Test
//    public void getVserifyIdcardC() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 身份信息 个人身份认证：" + baseUrl + getVserifyIdcardC + "?" + finalParam);
//    }
//
//    @Test
//    public void getUnionpayTransactionVariableB() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        paramMap.put("bankcard", bankcard);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 银行卡产品 银行卡交易特征及评分：" + baseUrl + getUnionpayTransactionVariableB + "?" + finalParam);
//    }
//
//    @Test
//    public void getVerifyBankcardInfoDetail4() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("mobile", mobile);
//        paramMap.put("bankcard", bankcard);
//        paramMap.put("idType", idType);
//        paramMap.put("licNumber", licNumber);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 银行卡产品 银行卡四要素验证详情版：" + baseUrl + getVerifyBankcardInfoDetail4 + "?" + finalParam);
//    }
//
//    @Test
//    public void getVerifyMobileInfo3C() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("mobile", mobile);
//        paramMap.put("idcard", idcard);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 运营商信息 运营商三要素验证：" + baseUrl + getVerifyMobileInfo3C + "?" + finalParam);
//    }
//
//    /**
//     * 消费探针
//     */
//    @Test
//    public void getConsumingProbe01() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 消费探针：" + baseUrl + getConsumingProbe01 + "?" + finalParam);
//    }
//
//    /**
//     * 信用探针
//     */
//    @Test
//    public void getCreditProbe01() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 信用探针：" + baseUrl + getCreditProbe01 + "?" + finalParam);
//    }
//
//    /**
//     * 运营商在网时长
//     */
//    @Test
//    public void getCmccOnlineTime() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 运营商在网时长：" + baseUrl + getCmccOnlineTime + "?" + finalParam);
//    }
//
//    /**
//     * 运营商状态
//     */
//    @Test
//    public void getCmccState() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("idcard", idcard);
//        paramMap.put("mobile", mobile);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天创API - 运营商状态：" + baseUrl + getCmccState + "?" + finalParam);
//    }
//
//    //-------------------------天创接口end------------------------
//
//
//
//
//
//
//
//
//
//
//    //-------------------------Linkface OCR接口start------------------------
//
//    @Test
//    public void idcardOcr() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("file", image3);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Linkface接口 - OCR - 身份证识别：" + baseUrl + idcardOcr + "?" + finalParam);
//    }
//
//    @Test
//    public void checkLiveness() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("motions", motions);
//        paramMap.put("complexity", complexity);
//        paramMap.put("anti_hack", anti_hack);
//        paramMap.put("liveness_data_file", liveness_data_file);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Linkface接口 - 活体检测：" + baseUrl + checkLiveness + "?" + finalParam);
//    }
//
//    @Test
//    public void livenessImage() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("image_id", imageId);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Linkface接口 - 活体检测 - 从视频中提取人脸图片：" + baseUrl + livenessImage + "?" + finalParam);
//    }
//
//    @Test
//    public void livenessIdnumberVerification() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("name", name);
//        paramMap.put("id_number", idcard);
////        paramMap.put("liveness_data_file", "/data/pic/");   // 活体检测SDK返回的protobuf文件
////        paramMap.put("liveness_data_url", "");    // 活体检测SDK返回的protobuf文件的url
////        paramMap.put("liveness_data_id", "");     // 活体检测SDK返回的protobuf文件的id
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Linkface接口 - 人证比对 - 评分：" + baseUrl + livenessIdnumberVerification + "?" + finalParam);
//    }
//    //-------------------------Linkface接口end------------------------
//
//
//
//
//
//
//
//
//
//
//    //-------------------------百度OCR接口start------------------------
//    @Test
//    public void businessLicense() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("image", image);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("百度OCR - 营业执照识别：" + baseUrl + businessLicense + "?" + finalParam);
//    }
//
//    @Test
//    public void vatInvoice() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("image", image2);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("百度OCR - 增值税发票识别：" + baseUrl + vatInvoice + "?" + finalParam);
//    }
//
//    //-------------------------百度OCR接口end------------------------
//
//
//
//
//
//
//
//
//
//
//    //-------------------------天眼查接口start------------------------
//    @Test
//    public void tycTest() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("companyName", companyName);
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("天眼查 - 商标信息：" + baseUrl + tm + "?" + finalParam);
//        System.out.println("天眼查 - 作品著作权：" + baseUrl + copyRegWorks + "?" + finalParam);
//        System.out.println("天眼查 - 招聘_新版：" + baseUrl + employmentsV2 + "?" + finalParam);
//        System.out.println("天眼查 - 获取公司新闻列表：" + baseUrl + news + "?" + finalParam);
//        System.out.println("天眼查 - 网站备案：" + baseUrl + icp + "?" + finalParam);
//        System.out.println("天眼查 - 企业简介_上市信息类接口：" + baseUrl + companyInfo + "?" + finalParam);
//        System.out.println("天眼查 - 著作权：" + baseUrl + copyReg + "?" + finalParam);
//        System.out.println("天眼查 - 招投标：" + baseUrl + bids + "?" + finalParam);
//        System.out.println("天眼查 - 天眼查专利：" + baseUrl + patents + "?" + finalParam);
//        System.out.println("天眼查 - 股权出质：" + baseUrl + equityInfo + "?" + finalParam);
//        System.out.println("天眼查 - 动产抵押：" + baseUrl + mortgageInfo + "?" + finalParam);
//        System.out.println("天眼查 - 行政处罚_信用中国_新版：" + baseUrl + creditChinaV2 + "?" + finalParam);
//        System.out.println("天眼查 - 经营异常：" + baseUrl + abnormal + "?" + finalParam);
//        System.out.println("天眼查 - 开庭公告：" + baseUrl + ktannouncement + "?" + finalParam);
//        System.out.println("天眼查 - 被执行人：" + baseUrl + zhixinginfo + "?" + finalParam);
//        System.out.println("天眼查 - 失信人_新版：" + baseUrl + dishonestV2 + "?" + finalParam);
//        System.out.println("天眼查 - 法院公告：" + baseUrl + courtAnnouncement + "?" + finalParam);
//        System.out.println("天眼查 - 法律诉讼：" + baseUrl + lawSuit + "?" + finalParam);
//        System.out.println("天眼查 - 分支机构：" + baseUrl + branch + "?" + finalParam);
//        System.out.println("天眼查 - 变更记录：" + baseUrl + changeinfo + "?" + finalParam);
//        System.out.println("天眼查 - 企业年报：" + baseUrl + annualreport + "?" + finalParam);
//        System.out.println("天眼查 - 对外投资：" + baseUrl + inverst + "?" + finalParam);
//        System.out.println("天眼查 - 股东信息：" + baseUrl + holder + "?" + finalParam);
//        System.out.println("天眼查 - 获取企业基本信息_含主要人员：" + baseUrl + baseinfoV3 + "?" + finalParam);
//        System.out.println("天眼查 - 欠税公告：" + baseUrl + ownTax + "?" + finalParam);
//        paramMap.clear();
//        paramMap.put("appId", appId);
//        paramMap.put("companyId", companyId);
//        sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        finalParam = ParamMap2String(paramMap);
//        System.out.println("天眼查 - 企业图谱_新版：" + baseUrl + oneKeyC + "?" + finalParam);
//    }
//
//    //-------------------------天眼查接口end------------------------
//
//
//
//
//
//
//
//
//
//
//    //-------------------------Mock接口start------------------------
//
//    /**
//     * 预授信
//     */
//    @Test
//    public void preCredit() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("IDNum", "440301197110292910");
//        paramMap.put("lname", "马化腾");
//        paramMap.put("company", "腾讯科技(北京)有限公司");
//        paramMap.put("uscc", "91110108772551611J");
//        paramMap.put("bizCode", "1");
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Mock - 预授信：" + baseUrl + preCredit + "?" + finalParam);
//    }
//
//    /**
//     * 正式授信
//     */
//    @Test
//    public void formalCredit() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("phoneNum", "17000000000");
//        paramMap.put("bankNum", "6228481101100634315");
//        paramMap.put("taxAccount", "mht123");
//        paramMap.put("taxPassword", "qwer");
//        paramMap.put("IDNum", "440301197110292910");
//        paramMap.put("lname", "马化腾");
//        paramMap.put("company", "腾讯科技(北京)有限公司");
//        paramMap.put("uscc", "91110108772551611J");
////        paramMap.put("bizCode", "1");
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Mock - 正式授信：" + baseUrl + formalCredit + "?" + finalParam);
//    }
//
//    /**
//     * 客户等级/营销等级以及企业性质
//     */
//    @Test
//    public void enterpriseNature() {
//        Map<String, String> paramMap = new HashMap<String, String>();
//        paramMap.put("appId", appId);
//        paramMap.put("company", "腾讯科技(北京)有限公司");
//        paramMap.put("uscc", "91110108772551611J");
////        paramMap.put("bizCode", "1");
//        String sign = SignUtil.signature(tokenId, paramMap);
//        paramMap.put("sign", sign);
//        String finalParam = ParamMap2String(paramMap);
//        System.out.println("Mock - 客户等级/营销等级以及企业性质：" + baseUrl + enterpriseNature + "?" + finalParam);
//    }
//
//    //-------------------------Mock接口end------------------------
//
//
//
//
//
//
//
//
//
//
//    private String ParamMap2String(Map<String, String> paramMap) {
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
////            String value = entry.getValue();
//            if (org.apache.commons.lang.StringUtils.isBlank(entry.getValue())) {
//                sb.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
//            } else {
//                try {
//                    sb.append(String.format("%s=%s&", entry.getKey(), URLEncoder.encode(entry.getValue(), "UTF-8")));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }
//
//}
