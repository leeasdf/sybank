package xin.tianchuang.modules.api.handler.tyc;

import io.jsonwebtoken.lang.Collections;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open446NewsDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

import xin.tianchuang.modules.spider.entity.EntNewsInfoEntity;
import xin.tianchuang.modules.spider.service.EntNewsInfoService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class NewsHandler implements QueryHandler<List<Open446NewsDTO>> {

    private static final Logger logger = LoggerFactory.getLogger(NewsHandler.class);

    @Autowired
    private EntNewsInfoService entNewsInfoService;

    @Override
    public BaseRespnseDTO<List<Open446NewsDTO>> parseData(BaseApiRequestDTO param, String apiData) {
        // http://124.207.122.29:18080/dmp-service-web/service/tianyancha/news?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
        // String apiData =
        // "{\"data\":[{\"title\":\"百度等侵个人隐私 工信部约谈仨企业\",\"url\":\"http://news.163.com/18/0113/13/D81KDFVE00018AOP.html\",\"website\":\"网易\",\"time\":\"2018-01-13 13:31:38\"},{\"title\":\"百度、支付宝、今日头条因用户隐私问题被工信部约谈\",\"url\":\"http://tech.sina.com.cn/roll/2018-01-13/doc-ifyqqciz6340853.shtml\",\"website\":\"新浪\",\"time\":\"2018-01-13 10:15:00\"},{\"title\":\"工信部约谈三家互联网企业 要求百度等整改用户信息使用\",\"url\":\"http://news.163.com/18/0113/08/D811SSKI00018AOQ.html\",\"website\":\"网易\",\"time\":\"2018-01-13 08:03:00\"},{\"title\":\"工信部就个人信息保护问题约谈百度、今日头条等企业\",\"url\":\"http://www.cnr.cn/xjfw/2014xjfw/2014hy/20180113/t20180113_524097566.shtml\",\"website\":\"中国广播网\",\"time\":\"2018-01-13 06:29:16\"},{\"title\":\"工信部一日约谈 百度、支付宝等三企业\",\"url\":\"http://tech.sina.com.cn/i/2018-01-13/doc-ifyqqciz6226096.shtml\",\"website\":\"新浪\",\"time\":\"2018-01-13 02:20:20\"},{\"title\":\"工信部约谈百度支付宝今日头条\",\"url\":\"http://news.ifeng.com/a/20180113/55086027_0.shtml\",\"website\":\"凤凰网\",\"time\":\"2018-01-13 02:00:34\"},{\"title\":\"工信部责令支付宝、今日头条、百度整改\",\"url\":\"http://news.163.com/18/0113/01/D80B1LDT000187VI.html\",\"website\":\"网易\",\"time\":\"2018-01-13 01:28:38\"},{\"title\":\"WEMONEY晚报:百度、支付宝等因违规使用个人信息被约谈;微信用户...\",\"url\":\"http://finance.ifeng.com/a/20180112/15924598_0.shtml\",\"website\":\"凤凰网\",\"time\":\"2018-01-12 21:07:39\"},{\"title\":\"工信部就个人信息保护约谈百度、支付宝、今日头条\",\"url\":\"http://forex.cnfol.com/shixunsudi/20180112/25894113.shtml\",\"website\":\"外汇网\",\"time\":\"2018-01-12 15:24:19\"},{\"title\":\"工信部:就加强用户个人信息保护约谈百度、支付宝和今日头条\",\"url\":\"http://www.newhua.com/2018/0112/320605.shtml\",\"website\":\"牛华网\",\"time\":\"2018-01-12 14:47:00\"},{\"title\":\"责令整改!百度、支付宝、今日头条被工信部约谈\",\"url\":\"http://mt.sohu.com/it/p/216232135_99958797\",\"website\":\"搜狐\",\"time\":\"2018-01-12 14:45:00\"},{\"title\":\"工信部约谈百度、支付宝、今日头条 违规使用个人信息须立即整改\",\"url\":\"http://finance.ifeng.com/a/20180112/15923846_0.shtml\",\"website\":\"凤凰网\",\"time\":\"2018-01-12 14:40:32\"},{\"title\":\"工信部约谈百度支付宝今日头条 要求加强用户个人信息保护\",\"url\":\"http://www.ccn.com.cn/html/news/xiaofeiyaowen/2018/0112/337052.html\",\"website\":\"中国消费网\",\"time\":\"2018-01-12 13:50:00\"},{\"title\":\"你的个人信息安全吗?工信部约谈百度蚂蚁金服今日头条\",\"url\":\"http://it.sohu.com/20180112/n527945651.shtml\",\"website\":\"搜狐科技\",\"time\":\"2018-01-12 13:07:00\"},{\"title\":\"工信部约谈今日头条、百度、支付宝\",\"url\":\"http://mil.news.sina.com.cn/2018-01-12/doc-ifyqptqv8227514.shtml\",\"website\":\"新浪\",\"time\":\"2018-01-12 12:54:00\"},{\"title\":\"工信部就今日约谈百度、支付宝、今日头条\",\"url\":\"http://it.sohu.com/20180112/n527931857.shtml\",\"website\":\"搜狐科技\",\"time\":\"2018-01-12 11:29:00\"},{\"title\":\"中消协支持对百度提起公益诉讼\",\"url\":\"http://ln.people.com.cn/n2/2018/0111/c378328-31131489.html\",\"website\":\"人民网辽宁站\",\"time\":\"2018-01-11 10:41:00\"},{\"title\":\"百度APP被起诉问题不止于百度\",\"url\":\"http://news.10jqka.com.cn/20180110/c602402292.shtml\",\"website\":\"同花顺金融网\",\"time\":\"2018-01-10 09:46:58\"},{\"title\":\"APP被起诉问题不止于百度_观点评论_财经_中金在线\",\"url\":\"http://news.cnfol.com/guandianpinglun/20180110/25880972.shtml\",\"website\":\"中金在线\",\"time\":\"2018-01-10 08:34:02\"},{\"title\":\"中消协支持江苏消保委对百度提起公益诉讼\",\"url\":\"http://legal.people.com.cn/n1/2018/0110/c42510-29755624.html\",\"website\":\"人民网\",\"time\":\"2018-01-10 08:14:00\"}],\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";
        // "{\"data\":{\"items\":[{\"website\":\"新浪\",\"time\":\"2019-02-18 09:37:00\",\"title\":\"新文化:子公司与百度网讯签订聚屏推广服务业务合作合同\",\"url\":\"http://finance.sina.com.cn/roll/2019-02-18/doc-ihqfskcp6163578.shtml\"},{\"website\":\"中金在线\",\"time\":\"2019-02-17 18:12:02\",\"title\":\"新文化子公司与百度网讯签约\",\"url\":\"http://sc.stock.cnfol.com/jysgg/20190217/27259458.shtml\"},{\"website\":\"中金在线\",\"time\":\"2019-02-17 17:31:06\",\"title\":\"新文化(300336.SZ)与百度网讯签订合作合同 预计经营业绩产生积极...\",\"url\":\"http://sc.stock.cnfol.com/ggzixun/20190217/27259405.shtml\"},{\"website\":\"中国财经信息网\",\"time\":\"2019-02-17 17:07:13\",\"title\":\"[公告]新文化:关于全资子公司与北京百度网讯科技有限公司签订《...\",\"url\":\"http://www.cfi.net.cn/p20190217000241.html\"},{\"website\":\"人民网\",\"time\":\"2019-02-16 17:42:00\",\"title\":\"百度大麦网传播有害信息被处罚\",\"url\":\"http://it.people.com.cn/n1/2019/0216/c1009-30758487.html\"},{\"website\":\"人民网\",\"time\":\"2019-02-16 09:10:00\",\"title\":\"百度、大麦网因传播有害信息被处罚\",\"url\":\"http://yn.people.com.cn/n2/2019/0216/c378440-32645389.html\"},{\"website\":\"新浪\",\"time\":\"2019-02-16 04:09:00\",\"title\":\"百度、大麦网因传播有害信息被罚\",\"url\":\"http://finance.sina.com.cn/roll/2019-02-16/doc-ihrfqzka6216674.shtml\"},{\"website\":\"本溪网\",\"time\":\"2019-02-15 18:20:00\",\"title\":\"中国互金协会更新会员名单,爱财集团位列其中(附部分名单)\",\"url\":\"http://www.ibenxi.com/finance/caijing/20190215/1291.html\"},{\"website\":\"光明网\",\"time\":\"2019-02-15 16:56:00\",\"title\":\"百度、大麦网因传播有害信息被处罚\",\"url\":\"http://tech.gmw.cn/2019-02/15/content_32511732.htm\"},{\"website\":\"网易\",\"time\":\"2019-02-15 16:51:16\",\"title\":\"百度、大麦网因传播有害信息被处罚\",\"url\":\"http://3g.163.com/money/article/E82Q6OKB002580S6.html\"},{\"website\":\"财经网\",\"time\":\"2019-02-15 16:16:00\",\"title\":\"收集个人信息未放款 用户诉百度\"有钱花\"侵犯隐私权\",\"url\":\"http://tech.caijing.com.cn/20190215/4563106.shtml\"},{\"website\":\"财经网\",\"time\":\"2019-02-15 15:24:00\",\"title\":\"百度、大麦网因传播有害信息被“扫黄打非”部门处罚\",\"url\":\"http://tech.caijing.com.cn/20190215/4563084.shtml\"},{\"website\":\"中国网科技频道\",\"time\":\"2019-02-15 12:02:00\",\"title\":\"百度“有钱花”被用户起诉侵犯隐私权\",\"url\":\"http://tech.china.com.cn/internet/20190215/352185.shtml\"},{\"website\":\"凤凰科技\",\"time\":\"2019-02-14 19:04:01\",\"title\":\"氪星晚报 | 腾讯游戏发布12条直播禁令;百度被“扫黄打非”部门...\",\"url\":\"http://tech.ifeng.com/a/20190214/45310294_0.shtml\"},{\"website\":\"和讯科技\",\"time\":\"2019-02-14 18:09:46\",\"title\":\"百度、大麦网因传播淫秽色情等有害信息被处罚\",\"url\":\"http://tech.hexun.com/2019-02-14/196135541.html\"},{\"website\":\"新浪\",\"time\":\"2019-02-12 19:56:00\",\"title\":\"互金协更新会员名单 部分公司经营异常资格需待审核\",\"url\":\"http://finance.sina.com.cn/money/bank/dsfzf/2019-02-12/doc-ihrfqzka5237506.shtml\"},{\"website\":\"民主与法制网\",\"time\":\"2019-01-29 09:10:39\",\"title\":\"“抖音”起诉“百度”“奇虎”商标侵权\",\"url\":\"http://www.mzyfz.com/cms/benwangzhuanfang/xinwenzhongxin/zuixinbaodao/html/1040/2019-01-29/content-1382331.html\"},{\"website\":\"TOM娱乐\",\"time\":\"2019-01-24 10:33:00\",\"title\":\"抖音起诉百度、奇虎商标侵权 索赔500万\",\"url\":\"http://ent.tom.com/201901/1096685584.html\"},{\"website\":\"凤凰科技\",\"time\":\"2019-01-23 19:12:03\",\"title\":\"氪星晚报 | 百度搜索引擎业务陷入争议;罗永浩退出锤子科技董事...\",\"url\":\"http://tech.ifeng.com/a/20190123/45297738_0.shtml\"},{\"website\":\"中华网财经\",\"time\":\"2019-01-23 17:48:00\",\"title\":\"抖音起诉百度、360商标侵权\",\"url\":\"https://finance.china.com/tech/13001906/20190123/35067313.html\"}]},\"seqNum\":\"188a593de8694f0aacb521b858da87d8\",\"bizCode\":\"\",\"message\":\"成功\",\"status\":10}";

        //
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>>>() {
        }.getType(); //
        TycApiRespDTO<ResponsePageNumResultDTO<Open446NewsDTO>> dtos = gson.fromJson(apiData, jsonType);
        if (dtos == null) { // 成功
            BaseRespnseDTO<List<Open446NewsDTO>> rtnDTO = new BaseRespnseDTO<List<Open446NewsDTO>>();
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
            rtnDTO.setMsg("接口响应数据为空");
            return rtnDTO;
        }

        Integer status = dtos.getStatus();
        String uuid = dtos.getSeqNum();
        String entName = param.getName();

        BaseRespnseDTO<List<Open446NewsDTO>> rtnDTO = new BaseRespnseDTO<List<Open446NewsDTO>>();
        rtnDTO.setRtnSerialNo(uuid);
        rtnDTO.setRespStr(apiData);
        rtnDTO.setCode(status);
        rtnDTO.setMsg(dtos.getMessage());
        // 非正常情况
        if (TcxyApiStatusCodeEnum.SUCCESS.key() != status && TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() != status) {
            rtnDTO.setRemark("查询失败");
            return rtnDTO;
        } 
        // 先删除 在新增
        entNewsInfoService.deleteByEntName(entName);
        // 成功无数据情况
        if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
            rtnDTO.setRemark("查询成功无数据");
            return rtnDTO;
        }
        // 查询成功
        ResponsePageNumResultDTO<Open446NewsDTO> data = dtos.getData();
        if (null == data) {
            logger.error("[{}]data节点数据返回为空", param.getSeqNum());
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
            rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
            return rtnDTO;
        }
        // 保存数据
        List<Open446NewsDTO> items = data.getItems();
        if (Collections.isEmpty(items)) {
            rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
            rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
            rtnDTO.setRemark("查询成功，返回节点无数据");
            return rtnDTO;
        }
        List<EntNewsInfoEntity> newsInfoEntityList = new ArrayList<EntNewsInfoEntity>(items.size());

        for (Open446NewsDTO item : items) {
            EntNewsInfoEntity entity = new EntNewsInfoEntity();
            BeanUtils.copyProperties(item, entity);
            entity.setEntId(param.getEntListInfo().getId());
            entity.setEntName(entName);
            entity.setCreditCode(param.getEntListInfo().getCreditCode());
            newsInfoEntityList.add(entity);
        }
        entNewsInfoService.insertBatch(newsInfoEntityList);
        // 返回数据
        rtnDTO.setData(items);
        rtnDTO.setRemark("查询成功");
        logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
        return rtnDTO;
    }
}
