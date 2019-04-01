package xin.tianchuang.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xin.tianchuang.common.enums.TycInterfaceTypeEnum;
import xin.tianchuang.modules.api.handler.QueryHandler;
import xin.tianchuang.modules.api.handler.TycApiHandlerFactory;
import xin.tianchuang.modules.api.handler.tyc.AbnormalHandler;
import xin.tianchuang.modules.api.handler.tyc.AnnualreportHandler;
import xin.tianchuang.modules.api.handler.tyc.BaseInfoV3Handler;
import xin.tianchuang.modules.api.handler.tyc.BidsHandler;
import xin.tianchuang.modules.api.handler.tyc.BranchHandler;
import xin.tianchuang.modules.api.handler.tyc.ChangeinfoHandler;
import xin.tianchuang.modules.api.handler.tyc.CopyRegHandler;
import xin.tianchuang.modules.api.handler.tyc.CopyRegWorksHandler;
import xin.tianchuang.modules.api.handler.tyc.CourtAnnouncementHandler;
import xin.tianchuang.modules.api.handler.tyc.CreditChinaV2Handler;
import xin.tianchuang.modules.api.handler.tyc.DishonestV2Handler;
import xin.tianchuang.modules.api.handler.tyc.EmploymentsV2Handler;
import xin.tianchuang.modules.api.handler.tyc.EquityInfoHandler;
import xin.tianchuang.modules.api.handler.tyc.HolderHandler;
import xin.tianchuang.modules.api.handler.tyc.IcpHandler;
import xin.tianchuang.modules.api.handler.tyc.InverstHandler;
import xin.tianchuang.modules.api.handler.tyc.KtannouncementHandler;
import xin.tianchuang.modules.api.handler.tyc.LawSuitHandler;
import xin.tianchuang.modules.api.handler.tyc.MortgageInfoHandler;
import xin.tianchuang.modules.api.handler.tyc.NewsHandler;
import xin.tianchuang.modules.api.handler.tyc.OneKeyCHandler;
import xin.tianchuang.modules.api.handler.tyc.OwnTaxHandler;
import xin.tianchuang.modules.api.handler.tyc.PatentsHandler;
import xin.tianchuang.modules.api.handler.tyc.TmHandler;
import xin.tianchuang.modules.api.handler.tyc.ZhixinginfoHandler;

import com.google.common.collect.Maps;

/**
 * 路由API配置信息
 * @author denghui
 *
 */
@Configuration
public class RouterApiConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public TycApiHandlerFactory queryHandlers() {
		Map<String, QueryHandler> queryHandlers = Maps.newHashMap();
		queryHandlers.put(TycInterfaceTypeEnum.BASEINFO_V3.key(), baseinfoV3());
		queryHandlers.put(TycInterfaceTypeEnum.HOLDER.key(), holder());
		queryHandlers.put(TycInterfaceTypeEnum.INVERST.key(), inverst());
		queryHandlers.put(TycInterfaceTypeEnum.CHANGEINFO.key(), changeinfo());
		queryHandlers.put(TycInterfaceTypeEnum.BRANCH.key(), branch());
		queryHandlers.put(TycInterfaceTypeEnum.LAW_SUIT.key(), lawSuit());
		queryHandlers.put(TycInterfaceTypeEnum.COURT_ANNOUNCEMENT.key(), courtAnnouncement());
		queryHandlers.put(TycInterfaceTypeEnum.DISHONEST_V2.key(), dishonestV2());
		queryHandlers.put(TycInterfaceTypeEnum.ZHIXINGINFO.key(), zhixinginfo());
		queryHandlers.put(TycInterfaceTypeEnum.KTANNOUNCEMENT.key(), ktannouncement());
		queryHandlers.put(TycInterfaceTypeEnum.ABNORMAL.key(), abnormal());
		queryHandlers.put(TycInterfaceTypeEnum.CREDIT_CHINA_V2.key(), creditChinaV2());
		queryHandlers.put(TycInterfaceTypeEnum.EQUITY_INFO.key(), equityInfo());
		queryHandlers.put(TycInterfaceTypeEnum.MORTGAGE_INFO.key(), mortgageInfo());
		queryHandlers.put(TycInterfaceTypeEnum.OWN_TAX.key(), own_tax());
		queryHandlers.put(TycInterfaceTypeEnum.BIDS.key(), bids());
		queryHandlers.put(TycInterfaceTypeEnum.EMPLOYMENTS_V2.key(), employmentsV2());
		queryHandlers.put(TycInterfaceTypeEnum.TM.key(), tm());
		queryHandlers.put(TycInterfaceTypeEnum.PATENTS.key(), patents());
		queryHandlers.put(TycInterfaceTypeEnum.COPY_REG_WORKS.key(), copyRegWorks());
		queryHandlers.put(TycInterfaceTypeEnum.COPY_REG.key(), copyReg());
		queryHandlers.put(TycInterfaceTypeEnum.ICP.key(), icp());
		queryHandlers.put(TycInterfaceTypeEnum.NEWS.key(), news());
		queryHandlers.put(TycInterfaceTypeEnum.ONE_KEY_C.key(), oneKeyC());
		queryHandlers.put(TycInterfaceTypeEnum.ANNUALREPORT.key(), annualreport());
//		queryHandlers.put(TycInterfaceTypeEnum.COMPANY_INFO.key(), companyInfo());
//		queryHandlers.put(TycInterfaceTypeEnum.XGBASEINFO_V2.key(), xgbaseinfoV2());

		TycApiHandlerFactory tycApiHandlerFactory = new TycApiHandlerFactory();
		tycApiHandlerFactory.setQueryHandlers(queryHandlers);
		return tycApiHandlerFactory;
	}

	@Bean
	public BaseInfoV3Handler baseinfoV3() {
		return new BaseInfoV3Handler();
	}

	@Bean
	public HolderHandler holder() {
		return new HolderHandler();
	}

	@Bean
	public InverstHandler inverst() {
		return new InverstHandler();
	}

	@Bean
	public ChangeinfoHandler changeinfo() {
		return new ChangeinfoHandler();
	}

	@Bean
	public BranchHandler branch() {
		return new BranchHandler();
	}

	@Bean
	public LawSuitHandler lawSuit() {
		return new LawSuitHandler();
	}

	@Bean
	public CourtAnnouncementHandler courtAnnouncement() {
		return new CourtAnnouncementHandler();
	}

	@Bean
	public DishonestV2Handler dishonestV2() {
		return new DishonestV2Handler();
	}

	@Bean
	public ZhixinginfoHandler zhixinginfo() {
		return new ZhixinginfoHandler();
	}

	@Bean
	public KtannouncementHandler ktannouncement() {
		return new KtannouncementHandler();
	}

	@Bean
	public AbnormalHandler abnormal() {
		return new AbnormalHandler();
	}

	@Bean
	public CreditChinaV2Handler creditChinaV2() {
		return new CreditChinaV2Handler();
	}

	@Bean
	public EquityInfoHandler equityInfo() {
		return new EquityInfoHandler();
	}

	@Bean
	public MortgageInfoHandler mortgageInfo() {
		return new MortgageInfoHandler();
	}

	@Bean
	public OwnTaxHandler own_tax() {
		return new OwnTaxHandler();
	}

	@Bean
	public BidsHandler bids() {
		return new BidsHandler();
	}

	@Bean
	public EmploymentsV2Handler employmentsV2() {
		return new EmploymentsV2Handler();
	}

	@Bean
	public TmHandler tm() {
		return new TmHandler();
	}

	@Bean
	public PatentsHandler patents() {
		return new PatentsHandler();
	}

	@Bean
	public CopyRegWorksHandler copyRegWorks() {
		return new CopyRegWorksHandler();
	}

	@Bean
	public CopyRegHandler copyReg() {
		return new CopyRegHandler();
	}

	@Bean
	public IcpHandler icp() {
		return new IcpHandler();
	}

	@Bean
	public NewsHandler news() {
		return new NewsHandler();
	}

	@Bean
	public OneKeyCHandler oneKeyC() {
		return new OneKeyCHandler();
	}

	@Bean
	public AnnualreportHandler annualreport() {
		return new AnnualreportHandler();
	}

//	@Bean
//	public CompanyInfoHandler companyInfo() {
//		return new CompanyInfoHandler();
//	}

//	@Bean
//	public XgbaseinfoV2Handler xgbaseinfoV2() {
//		return new XgbaseinfoV2Handler();
//	}
}
