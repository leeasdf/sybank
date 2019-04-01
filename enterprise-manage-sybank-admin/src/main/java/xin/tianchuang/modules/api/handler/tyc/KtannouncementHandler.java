package xin.tianchuang.modules.api.handler.tyc;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;
import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementDefendantDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.Open386KtannouncementPlaintiffDTO;
import xin.tianchuang.modules.api.bean.api.tyc.response.ResponsePageNumResultDTO;
import xin.tianchuang.modules.api.dto.TycApiRespDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.spider.entity.EntKtannounceInfoEntity;
import xin.tianchuang.modules.spider.entity.EntKtannouncePeopleInfoEntity;

import xin.tianchuang.modules.spider.service.EntKtannounceInfoService;
import xin.tianchuang.modules.spider.service.EntKtannouncePeopleInfoService;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author denghui
 */
public class KtannouncementHandler implements QueryHandler<List<Open386KtannouncementDTO>> {

	private static final Logger logger = LoggerFactory.getLogger(KtannouncementHandler.class);

	@Autowired
	private EntKtannounceInfoService entKtannounceInfoService;
	@Autowired
	private EntKtannouncePeopleInfoService entKtannouncePeopleInfoService;

	@Override
	public BaseRespnseDTO<List<Open386KtannouncementDTO>> parseData(BaseApiRequestDTO param, String apiData) {
		// http://124.207.122.29:18080/dmp-service-web/service/tianyancha/ktannouncement?appId=a8e319a8b6f64b3e91024e7792a2c701&companyName=%E8%85%BE%E8%AE%AF%E7%A7%91%E6%8A%80%EF%BC%88%E6%B7%B1%E5%9C%B3%EF%BC%89%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&sign=ce7d7a9af35c3a02da77650103dd0ae4
		// String apiData =
		// "{\"data\":{\"total\":1149,\"items\":[{\"startDate\":\"1536025800000\",\"plaintiff\":[{\"type\":1,\"id\":1629564924,\"name\":\"青岛薇薇新娘婚纱摄影有限公司\"}],\"plaintiffId\":\"1629564924\",\"courtroom\":\"知识产权第四法庭\",\"caseReason\":\"\",\"court\":\"成都市中级人民法院\",\"uni\":\"403fd55cbf0e966e8604e8991ba196a7\",\"searchType\":\"null\",\"litigant\":\"\",\"id\":\"11823315\",\"_type\":\"35\",\"judge\":\"\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/1629564924&singlequote& target=&singlequote&_blank&singlequote&>青岛薇薇新娘婚纱摄影有限公司</a>\"],\"defendantId\":\"3037736824,22822\",\"contractors\":\"\",\"caseNo\":\"(2018)川01民初1825号\",\"eventTime\":\"1536025800000\",\"defendant\":[{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"},{\"id\":0,\"name\":\"双流区薇薇新娘婚纱摄影店\"}]},{\"startDate\":\"1536025800000\",\"plaintiff\":[{\"type\":1,\"id\":1629564924,\"name\":\"青岛薇薇新娘婚纱摄影有限公司\"}],\"plaintiffId\":\"1629564924\",\"courtroom\":\"知识产权第四法庭\",\"court\":\"成都市中级人民法院\",\"searchType\":\"null\",\"uni\":\"3e497269ef147eadce4fb9a1e1e84464\",\"litigant\":\"\",\"id\":\"12021181\",\"_type\":\"35\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/1629564924&singlequote& target=&singlequote&_blank&singlequote&>青岛薇薇新娘婚纱摄影有限公司</a>\"],\"defendantId\":\"3037736824,22822\",\"contractors\":\"\",\"caseNo\":\"(2018)川01民初1825号\",\"eventTime\":\"1536025800000\",\"defendant\":[{\"id\":0,\"name\":\"双流区薇薇新娘婚纱摄影店\"},{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}]},{\"startDate\":\"1531963800000\",\"plaintiff\":[{\"type\":1,\"id\":729371275,\"name\":\"上海江浪流体机械制造有限公司\"}],\"plaintiffId\":\"729371275\",\"courtroom\":\"第十一法庭\",\"caseReason\":\"商标权权属、侵权纠纷\",\"court\":\"徐汇\",\"uni\":\"eae75dbebf4b14424513d8bc18846527\",\"searchType\":\"null\",\"litigant\":\"\",\"id\":\"4712511\",\"_type\":\"35\",\"judge\":\"于是\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/729371275&singlequote& target=&singlequote&_blank&singlequote&>上海江浪流体机械制造有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/308083333&singlequote& target=&singlequote&_blank&singlequote&>上海边锋泵业制造有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/2989488864&singlequote& target=&singlequote&_blank&singlequote&>边锋机械（集团）有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"defendantId\":\"308083333,2989488864,22822\",\"contractors\":\"民三庭\",\"caseNo\":\"（2018）沪0104民初10143号\",\"eventTime\":\"1531963800000\",\"defendant\":[{\"type\":1,\"id\":2989488864,\"name\":\"边锋机械（集团）有限公司\"},{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"},{\"type\":1,\"id\":308083333,\"name\":\"上海边锋泵业制造有限公司\"}]},{\"startDate\":\"1531893600000\",\"plaintiff\":[{\"type\":1,\"id\":2320488611,\"name\":\"上海如迪流体输送设备有限公司\"}],\"plaintiffId\":\"2320488611\",\"courtroom\":\"第十一法庭\",\"caseReason\":\"商标权权属、侵权纠纷\",\"court\":\"徐汇\",\"uni\":\"475112511f7ed102764dafbeffa7b3e1\",\"searchType\":\"null\",\"litigant\":\"\",\"id\":\"4712512\",\"_type\":\"35\",\"judge\":\"于是\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/2320488611&singlequote& target=&singlequote&_blank&singlequote&>上海如迪流体输送设备有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/308083333&singlequote& target=&singlequote&_blank&singlequote&>上海边锋泵业制造有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/2989488864&singlequote& target=&singlequote&_blank&singlequote&>边锋机械（集团）有限公司</a>\"],\"defendantId\":\"308083333,2989488864,22822\",\"contractors\":\"民三庭\",\"caseNo\":\"（2018）沪0104民初10146号\",\"eventTime\":\"1531893600000\",\"defendant\":[{\"type\":1,\"id\":308083333,\"name\":\"上海边锋泵业制造有限公司\"},{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"},{\"type\":1,\"id\":2989488864,\"name\":\"边锋机械（集团）有限公司\"}]},{\"startDate\":\"1531875600000\",\"plaintiff\":[{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}],\"plaintiffId\":\"22822\",\"courtroom\":\"二号楼三层第七法庭\",\"court\":\"河南省高级人民法院\",\"searchType\":\"null\",\"uni\":\"590c052ec8889951424493eb5a552287\",\"litigant\":\"\",\"id\":\"8494755\",\"_type\":\"35\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"defendantId\":\"\",\"contractors\":\"\",\"eventTime\":\"1531875600000\",\"defendant\":[]},{\"startDate\":\"1531288800000\",\"plaintiff\":[{\"type\":1,\"id\":2323987050,\"name\":\"道美科技（上海）有限公司\"}],\"plaintiffId\":\"2323987050\",\"courtroom\":\"本部第十二调解室\",\"caseReason\":\"侵害商标权纠纷\",\"court\":\"浦东\",\"uni\":\"4735d57b96220108bf092aa8bfddf9ae\",\"searchType\":\"null\",\"litigant\":\"\",\"id\":\"10198958\",\"_type\":\"35\",\"judge\":\"张毅\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/2323987050&singlequote& target=&singlequote&_blank&singlequote&>道美科技（上海）有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/1129001143&singlequote& target=&singlequote&_blank&singlequote&>北京友宝在线科技股份有限公司</a>\"],\"defendantId\":\"22822,1129001143\",\"contractors\":\"民三庭\",\"caseNo\":\"（2018）沪0115民初44902号\",\"eventTime\":\"1531288800000\",\"defendant\":[{\"type\":1,\"id\":1129001143,\"name\":\"北京友宝在线科技股份有限公司\"},{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}]},{\"startDate\":\"1531098000000\",\"plaintiff\":[{\"type\":1,\"id\":2321783322,\"name\":\"杭州壹脉科技有限公司\"}],\"courtroom\":\"第二法庭\",\"caseReason\":\"网络侵权责任纠纷\",\"court\":\"杭州市滨江区人民法院\",\"searchType\":\"null\",\"uni\":\"926c75ab6e207a344b44bb88c5de34e2\",\"litigant\":\"\",\"id\":\"10573494\",\"_type\":\"35\",\"judge\":\"季隽虹\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/2321783322&singlequote& target=&singlequote&_blank&singlequote&>杭州壹脉科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"contractors\":\"民一庭\",\"caseNo\":\"（2018）浙0108民初2681号\",\"eventTime\":\"1531098000000\",\"defendant\":[{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}]},{\"startDate\":\"1530167400000\",\"plaintiff\":[{\"type\":1,\"id\":3074604407,\"name\":\"唐山小马识途企业管理咨询有限公司\"}],\"plaintiffId\":\"3074604407\",\"courtroom\":\"第五审判庭\",\"court\":\"唐山市路南区人民法院\",\"searchType\":\"null\",\"uni\":\"4825cd1289661e2abff71d4b00d598fb\",\"litigant\":\"\",\"id\":\"6587272\",\"_type\":\"35\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/3074604407&singlequote& target=&singlequote&_blank&singlequote&>唐山小马识途企业管理咨询有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"defendantId\":\"\",\"contractors\":\"\",\"eventTime\":\"1530167400000\",\"defendant\":[]},{\"startDate\":\"1530146700000\",\"plaintiff\":[{\"id\":0,\"name\":\"张明翰\"}],\"plaintiffId\":\"\",\"courtroom\":\"第16法庭A503\",\"caseReason\":\"人格权纠纷\",\"court\":\"\",\"uni\":\"a0f9af6f7845e1a988c6a5905d341711\",\"searchType\":\"null\",\"litigant\":\"\",\"id\":\"4712513\",\"_type\":\"35\",\"judge\":\"张瑞雪\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\"],\"defendantId\":\"22822\",\"contractors\":\"\",\"caseNo\":\"（2018）粤0105民初5194号\",\"eventTime\":\"1530146700000\",\"defendant\":[{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}]},{\"startDate\":\"1530061200000\",\"plaintiff\":[{\"id\":0,\"name\":\"杨文军\"}],\"plaintiffId\":\"\",\"courtroom\":\"知识产权第四法庭\",\"court\":\"成都市中级人民法院\",\"searchType\":\"null\",\"uni\":\"dde5e0873ed06f559c8106503bf49fc5\",\"litigant\":\"\",\"id\":\"12026983\",\"_type\":\"35\",\"connList\":[\"<a href=&singlequote&https://www.tianyancha.com/company/22822&singlequote& target=&singlequote&_blank&singlequote&>北京百度网讯科技有限公司</a>\",\"<a href=&singlequote&https://www.tianyancha.com/company/2328615931&singlequote& target=&singlequote&_blank&singlequote&>四川省森悦旅游资源开发有限公司</a>\"],\"defendantId\":\"22822,2328615931\",\"contractors\":\"\",\"caseNo\":\"(2017)川01民初1085号\",\"eventTime\":\"1530061200000\",\"defendant\":[{\"type\":1,\"id\":2328615931,\"name\":\"四川省森悦旅游资源开发有限公司\"},{\"type\":1,\"id\":22822,\"name\":\"北京百度网讯科技有限公司\"}]}]},\"seqNum\":\"43ab4e39bbf94c0c9b7747b86ac56cd3\",\"bizCode\":\"\",\"message\":\"查询成功\",\"status\":10}";

		//
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Type jsonType = new TypeToken<TycApiRespDTO<ResponsePageNumResultDTO<Open386KtannouncementDTO>>>() {
		}.getType(); //
		TycApiRespDTO<ResponsePageNumResultDTO<Open386KtannouncementDTO>> dtos = gson.fromJson(apiData, jsonType);
		if (dtos == null) { // 成功
			BaseRespnseDTO<List<Open386KtannouncementDTO>> rtnDTO = new BaseRespnseDTO<List<Open386KtannouncementDTO>>();
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SYS_BUZY.key());
			rtnDTO.setMsg("接口响应数据为空");
			return rtnDTO;
		}

		Integer status = dtos.getStatus();
		String uuid = dtos.getSeqNum();
		String entName = param.getName();

		BaseRespnseDTO<List<Open386KtannouncementDTO>> rtnDTO = new BaseRespnseDTO<List<Open386KtannouncementDTO>>();
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
		entKtannounceInfoService.deleteByEntName(entName);
		// 成功无数据情况
		if (TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key() == status) {
			rtnDTO.setRemark("查询成功无数据");
			return rtnDTO;
		}
		// 查询成功
		ResponsePageNumResultDTO<Open386KtannouncementDTO> data = dtos.getData();
		if (null == data) {
			logger.error("[{}]data节点数据返回为空", param.getSeqNum());
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			return rtnDTO;
		}
		// 保存数据
		List<Open386KtannouncementDTO> items = data.getItems();
		if (null == items || items.isEmpty()) {
			rtnDTO.setCode(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
			rtnDTO.setMsg(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
			rtnDTO.setRemark("查询成功，返回节点无数据");
			return rtnDTO;
		}

		List<EntKtannounceInfoEntity> list = new ArrayList<EntKtannounceInfoEntity>(items.size());
		List<EntKtannouncePeopleInfoEntity> peopleInfoEntityList = Lists.newArrayList();
		List<String> connLs = null;
		EntKtannounceInfoEntity entity = null;
		List<Open386KtannouncementPlaintiffDTO> plaintiffLs = null;
		for (Open386KtannouncementDTO item : items) {
			entity = new EntKtannounceInfoEntity();
			BeanUtils.copyProperties(item, entity);
			entity.setEntId(param.getEntListInfo().getId());
			entity.setEntName(entName);
			entity.setCreditCode(param.getEntListInfo().getCreditCode());
			connLs = item.getConnList();
			if (null != connLs && connLs.size() >= 1) {
				String connStr = Joiner.on(",").join(connLs);
				entity.setConnList(connStr);
			}
			list.add(entity);

			plaintiffLs = item.getPlaintiff();
			String tableId = entity.getTableId();
			if (null != plaintiffLs && plaintiffLs.size() > 0) {
				entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
				EntKtannouncePeopleInfoEntity plaintiffEntity = null;
				for (Open386KtannouncementPlaintiffDTO plaintiff : plaintiffLs) {
					plaintiffEntity = new EntKtannouncePeopleInfoEntity();
					BeanUtils.copyProperties(plaintiff, plaintiffEntity);
					plaintiffEntity.setPeopleType(EntKtannouncePeopleTypeEnum.PLAINTIFF.key());
					plaintiffEntity.setTableId(Long.valueOf(tableId));
					peopleInfoEntityList.add(plaintiffEntity);
				}
			}
			List<Open386KtannouncementDefendantDTO> defendantLs = item.getDefendant();
			if (null != defendantLs && defendantLs.size() > 0) {
				entKtannouncePeopleInfoService.deleteByTableIdAndType(tableId, EntKtannouncePeopleTypeEnum.DEFENDANT.key());
				EntKtannouncePeopleInfoEntity defendantEntity = null;
				for (Open386KtannouncementDefendantDTO defendant : defendantLs) {
					defendantEntity = new EntKtannouncePeopleInfoEntity();
					BeanUtils.copyProperties(defendant, defendantEntity);
					defendantEntity.setPeopleType(EntKtannouncePeopleTypeEnum.DEFENDANT.key());
					defendantEntity.setTableId(Long.valueOf(tableId));
					peopleInfoEntityList.add(defendantEntity);
				}
			}
		}
		if (peopleInfoEntityList.size() > 0) {
			entKtannouncePeopleInfoService.insertBatch(peopleInfoEntityList);
		}
		entKtannounceInfoService.insertBatch(list);
		// 返回数据
		rtnDTO.setData(items);
		rtnDTO.setRemark("查询成功");
		logger.info("统一响应数据：{}", new Gson().toJson(rtnDTO));
		return rtnDTO;
	}
}
