package xin.tianchuang.common.constant;

import java.math.BigDecimal;

import xin.tianchuang.common.enums.EntKtannouncePeopleTypeEnum;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;

/**
 * Created by lee on 2019/3/7.
 */
public final class TycWeightPointsConstant {


    /**
     * 注册资本变量
     * 距今时长（当前日期减changeTime返回结果）
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> REGISTERED_CAPITAL_DURATION_TIME =
            ImmutableRangeMap.<Integer, BigDecimal>builder()
                    .put(Range.closed(0, 12), BigDecimal.ONE)
                    .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
                    .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
                    .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
                    .put(Range.greaterThan(60), BigDecimal.ZERO)
                    .build();

    /**
     * 注册资本变量
     * 变化方向（contentAfter返回值减去contentBefore返回值，若大于0则为增资，小于0则为减资
     * 增资	0
     * 减资	1
     */
    public static final RangeMap<Double, BigDecimal> REGISTERED_CAPITAL_DIRECTION = ImmutableRangeMap.<Double, BigDecimal>builder()
            .put(Range.greaterThan(0.0), BigDecimal.ZERO)
            .put(Range.lessThan(0.0), BigDecimal.ONE)
            .build();

    /**
     * 法定代表人变量
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> LEGAL = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 股东/投资人变量
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> SHAREHOLDER_OR_INVESTOR = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();


    /**
     * 经营范围变量=SUM(距今时长权重）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> SCOPE_OF_BUSINESS = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 董监高变量=SUM(距今时长权重）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> DONG_JIAN_GAO = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();


    /**
     * 住所变量=SUM(距今时长权重）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> ADDRESS = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 企业类型变量=SUM(距今时长权重）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> ENTPRISE_TYPE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();
    /**
     * 企业名称变量=SUM(距今时长权重）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> ENTPRISE_NAME = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 开庭公告加权数量
     * 开庭公告日期距今时长（当前日期减386-startDate返回结果）
     * 单位 ：月
     * [0,6]	1
     * (6,12]	1
     * (12,24]	0.8
     * (24,60]	0.4
     * (60,Inf]	0.2
     */
    public static final RangeMap<Integer, BigDecimal> KT_ANNOUNCENENT_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 6), BigDecimal.ONE)
            .put(Range.openClosed(6, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.8"))
            .put(Range.openClosed(24, 60), new BigDecimal("0.4"))
            .put(Range.greaterThan(60), new BigDecimal("0.2"))
            .build();

    /**
     * 开庭公告加权数量
     * 开庭公告身份（根据386-plaintiff_name（原告名称）、386-defendant_name（被告名称）判断企业身份）
     * 被告/被上诉人	1
     * 原告/上诉人	0.3
     */
    public static final ImmutableMap<Integer, BigDecimal> KT_ANNOUNCENENT_IDENTITY = ImmutableMap.<Integer, BigDecimal>builder()
            .put(EntKtannouncePeopleTypeEnum.DEFENDANT.key(), BigDecimal.ONE)
            .put(EntKtannouncePeopleTypeEnum.PLAINTIFF.key(), new BigDecimal("0.3"))
            .build();


    /**
     * 裁判文书加权数量
     * 注：根据385-bltntypename返回结果 先选出 裁判文书类"	"裁判文书日期距今时长
     * （当前日期减385-publishdate返回结果）"
     * 距今时长
     * 单位 ：月
     * [0,6]	1
     * (6,12]	1
     * (12,24]	0.8
     * (24,60]	0.4
     * (60,Inf]	0.2
     */
    public static final RangeMap<Integer, BigDecimal> JUDICIAL_DOCUMENTS_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 6), BigDecimal.ONE)
            .put(Range.openClosed(6, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.8"))
            .put(Range.openClosed(24, 60), new BigDecimal("0.4"))
            .put(Range.greaterThan(60), new BigDecimal("0.2"))
            .build();


    /**
     * 裁判文书加权数量
     * 裁判文书身份（根据385-party1（原告）；385-party2（当事人）；判断企业身份）
     * 被告/被上诉人	1
     * 原告/上诉人	0.3
     */
    public static final ImmutableMap<Integer, BigDecimal> JUDICIAL_DOCUMENTS_INDENTITY = ImmutableMap.<Integer, BigDecimal>builder()
            .put(EntKtannouncePeopleTypeEnum.DEFENDANT.key(), BigDecimal.ONE)
            .put(EntKtannouncePeopleTypeEnum.PLAINTIFF.key(), new BigDecimal("0.3"))
            .build();


    /**
     * 法院公告
     * 注：根据385-bltntypename返回结果 剔除 裁判文书类"	"法院公告日期距今时长（当前日期减385-publishdate返回结果）"
     * 距今时长
     * 单位 ：月
     * [0,6]	1
     * (6,12]	0.5
     * (12,inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> COURT_ANNOUNCEMENT_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 6), BigDecimal.ONE)
            .put(Range.openClosed(6, 12), new BigDecimal("0.5"))
            .put(Range.greaterThan(12), BigDecimal.ZERO)
            .build();

    /**
     * 法院公告
     * 法院公告身份
     * （根据385-party1（原告）；385-party2（当事人）；判断企业身份）"
     * 被告/被上诉人	1
     * 原告/上诉人	0.3
     */
    public static final ImmutableMap<Integer, BigDecimal> COURT_ANNOUNCEMENT_INDENTITY = ImmutableMap.<Integer, BigDecimal>builder()
            .put(EntKtannouncePeopleTypeEnum.DEFENDANT.key(), BigDecimal.ONE)
            .put(EntKtannouncePeopleTypeEnum.PLAINTIFF.key(), new BigDecimal("0.3"))
            .build();

    /**
     * 执行信息加权数量
     * 被执行人日期距今时长 （当前日期减389-caseCreateTime返回结果）
     * 距今时长
     * 单位 ：月
     * [0,6]	1
     * (6,12]	1
     * (12,24]	0.8
     * (24,60]	0.4
     * (60,Inf]	0.2
     */
    public static final RangeMap<Integer, BigDecimal> ZHI_XING_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 6), BigDecimal.ONE)
            .put(Range.openClosed(6, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.8"))
            .put(Range.openClosed(24, 60), new BigDecimal("0.4"))
            .put(Range.greaterThan(60), new BigDecimal("0.2"))
            .build();

    /**
     * 执行信息加权数量
     * 被执行人执行标的389-execMoney返回值/10000"
     * 单位:万
     * [0,10]	0.2
     * (10,50]	0.4
     * (50,200]	0.6
     * (200,500]	0.8
     * (500,Inf)	1
     */
    public static final RangeMap<Integer, BigDecimal> ZHI_XING_MONEY = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 10), new BigDecimal("0.2"))
            .put(Range.openClosed(10, 50), new BigDecimal("0.4"))
            .put(Range.openClosed(50, 200), new BigDecimal("0.6"))
            .put(Range.openClosed(200, 500), new BigDecimal("0.8"))
            .put(Range.greaterThan(500), BigDecimal.ONE)
            .build();

    /**
     * 专利加权数量（当前日期减440-applicationTime返回结果）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> PATENT_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 专利加权数量
     * 类型440-patentType返回结果"
     * 发明授权	1
     * 发明公告	0.8
     * 实用新型	0.6
     * 外观设计	0.3
     */
    public static final ImmutableMap<String, BigDecimal> PATENT_TYPE = ImmutableMap.<String, BigDecimal>builder()
            .put("发明授权", BigDecimal.ONE)
            .put("发明专利", BigDecimal.ONE)
            .put("pct发明", BigDecimal.ONE)
            .put("发明", new BigDecimal("0.8"))
            .put("发明公告", new BigDecimal("0.8"))
            .put("实用新型", new BigDecimal("0.6"))
            .put("pct实用新型", new BigDecimal("0.6"))
            .put("外观设计", new BigDecimal("0.3"))
            .put("外观专利", new BigDecimal("0.3"))
            .build();

    /**
     * 商标加权数量 距今时长 (当前日期减439-appDate返回结果）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> TRADEMARK_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 软件著作权加权数量 	"距今时长（当前日期减441-eventTime返回结果）"
     * *距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> SOFTWARE_COPYRIGHT_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();


    /**
     * 作品著作权加权数量 	"距今时长（当前日期减773-eventTime返回结果）"
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> WORKS_COPYRIGHT_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();

    /**
     * 新闻舆情加权数量 距今时长（当前日期减446-time返回结果）
     * 距今时长
     * 单位 ：月
     * [0,12]	1
     * (12,24]	0.75
     * (24,36]	0.5
     * (36,60]	0.25
     * (60,Inf]	0
     */
    public static final RangeMap<Integer, BigDecimal> NEWS_DATE = ImmutableRangeMap.<Integer, BigDecimal>builder()
            .put(Range.closed(0, 12), BigDecimal.ONE)
            .put(Range.openClosed(12, 24), new BigDecimal("0.75"))
            .put(Range.openClosed(24, 36), new BigDecimal("0.5"))
            .put(Range.openClosed(36, 60), new BigDecimal("0.25"))
            .put(Range.greaterThan(60), BigDecimal.ZERO)
            .build();


	/**
	 * 新闻负面词汇
	 */
	public static final ImmutableSet<String> NEWS_BAD_WORDS = ImmutableSet.of("瘟", "瘟疫", "疾病", "病", "罚", "失信被执行人", "被执行人", "失信", "查封", "涉案", "刑拘", "冻结", "败诉", "败退", "败走", "曝光", "被捕", "被查", "被罚",
			"被封", "被否", "被告", "被判", "被迫", "被收回", "濒危", "兵败", "剥夺", "驳回", "不当", "撤资", "抽贷", "处分", "曝光", "丑闻", "串通", "大跌", "暴跌", "灾害", "灾", "亏损", "存风险", "存在风险", "政策风险", "下滑", "沦为", "烂摊子", "约谈");

	/**
	 * 变更事项规则 企业类型
	 */
	public static final ImmutableSet<String> ENTPRISE_TYPE_WORDS = ImmutableSet.of("合伙类型", "合伙企业类型", "合伙企业类型变更", "企业类型", "企业类型（经济性质）变更", "企业类型变更", "企业类型大类", "市场主体类型", "市场主体类型变更", "市场主体类型变更变更",
			"详细企业类型", "详细企业类型变更");

	/**
	 * 行业类型
	 */
	public static final ImmutableSet<String> INDUSTRY_TYPE_WORDS = ImmutableSet.of("行业代码变更", "行业代码", "行业类型", "所属行业", "行业门类", "经济性质", "重点热点行业", "经济性质变更", "行业类型变更", "行业类别或行业代码");

	/**
	 * 董监高变量 词汇
	 */
	public static final ImmutableSet<String> DONG_JIAN_GAO_WORDS = ImmutableSet.of("财务负责人", "财务负责人备案", "财务负责人信息", "董监事备案", "董事", "董事（理事）、经理、监事", "董事、监事、经理/委员", "董事、监事、经理及联合管理委员会委员", "董事备案", "董事成员",
			"董事长或执行董事成员", "高管人员", "高级管理人员备案", "高级管理人员备案 ", "高级管理人员备案（董事、监事、经理等）", "高级管理人员备案（董事、监事、经理等）变更", "管理人员", "管理人员(执行事务合伙人)", "监事", "监事备案", "监事成员", "监事信息", "企业总经理变更", "主要人员", "主要人员备案",
			"主要人员变更（董事会成员、监事、经理变更)", "主要人员变更（董事会成员、监事、经理变更）", "主要人员变更(董事会成员、监事、经理变更)");

	/**
	 * 法定代表人变量 词汇
	 */
	public static final ImmutableSet<String> LEGAL_WORDS = ImmutableSet.of("变更经营者", "法定代表变更", "法定代表人", "法定代表人（负责人）", "法定代表人（负责人）变更", "法定代表人(负责人、董事长、首席代表)变更", "法定代表人（负责人、董事长、首席代表)变更",
			"法定代表人（负责人、董事长、首席代表）变更", "法定代表人(负责人、独资投资人)", "法定代表人（负责人、独资投资人)", "法定代表人（负责人、独资投资人）", "法定代表人(负责人、独资投资人)变更", "法定代表人(负责人、首席代表)", "法定代表人变更", "法定代表人姓名", "法定代表人姓名变更", "负责人",
			"负责人（法定代表人、首席代表、合伙事务执行人等）变更", "负责人变更", "负责人变更（法定代表人、负责人、首席代表、个体户经营者、投资人、合伙事务执行人等变更）", "负责人变更（法定代表人、负责人、首席代表、合伙事务执行人等变更）", "负责人变更（法定代表人、负责人、首席代表、合伙事务执行人等变更）变",
			"负责人变更（法定代表人、负责人、首席代表、合伙事务执行人等变更）变更", "负责人姓名", "负责人姓名变更", "经营者", "经营者变更", "经营者变更（家庭经营的）", "经营者名称变更", "经营者信息", "经营者信息变更", "经营者姓名", "经营者姓名变更", "首席代表", "首席代表变更");

	/**
	 * 股东变更 词汇
	 */
	public static final ImmutableSet<String> SHAREHOLDER_OR_INVESTOR_WORDS = ImmutableSet.of("出资比例", "出资比例备案", "出资比例变更", "出资比例变更(%)", "出资成员(股权、成员)", "出资成员（股权、成员)变更", "出资成员（股权、成员）变更", "出资额",
			"出资额(万元)", "出资额变更", "出资额变更(万元)", "出资额变更仅适用于合伙企业及个人独资企业", "出资额及出资方式变更", "出资方式", "出资方式(个体独资)变更", "出资方式(实收资本)", "出资方式变更", "发起人变更", "发起人名称", "发起人名称变更", "法人股东", "公司股东(发起人)信息", "股东（出资情况）",
			"股东（出资情况）变更", "股东（发起人）认缴出资额", "股东(股权)备案变更", "股东（投资人）", "股东、出资额、出资比例变更", "股东、发起人（出资情况）", "股东、发起人、出资人（出资情况）", "股东、发起人备案", "股东、发起人变更", "股东、发起人名称变更", "股东、投资人变更（股权转让）", "股东备案", "股东变更",
			"股东变更(股权转让)", "股东发起人", "股东改变姓名或名称", "股东或股份发起人改变", "股东或股份发起人改变姓名或名称", "股东或股份发起人改变姓名或名称变更", "股东名称变更", "股东名录", "股东名录变更", "股权", "股权备案", "股权变更和公证书", "股权出质变更", "股权出质变更备案", "股权出质设立", "股权出质设立备案",
			"股权出质注销", "股权出质注销备案", "股权解除质押备案", "股权质押备案", "股权质押登记（备案）", "股权转让股权变更", "管理人员(合伙企业投资人)", "合伙企业类型", "合伙企业类型变更", "合伙起始日期", "合伙人", "合伙人备案", "合伙人变更", "合伙人数", "合伙人数变更", "合伙人信息（非自然人）",
			"合伙人信息（自然人）", "合伙人信息备案", "合伙人姓名或名称", "合伙人姓名或名称变更", "认缴出资变更", "认缴出资额", "认缴出资额 币种", "认缴出资额 折万美元", "认缴出资额（万元）", "认缴出资额<br>币种", "认缴出资额<br>折万美元", "认缴出资额折万美元", "认缴出资金额(万元)", "认缴出资数额(万元)",
			"认缴的出资额", "认缴的出资方式", "认缴的出资时间", "认缴额信息", "认缴或实缴出资金额", "实缴出资备案", "实缴出资额", "实缴出资额 折万美元", "实缴出资额<br>币种", "实缴出资额<br>折万美元", "实缴出资额折万美元", "实缴出资金额(万元)", "实缴出资数额(万元)", "实缴的出资额", "实缴的出资方式",
			"实缴的出资时间", "实缴额信息", "投资方变更", "投资方情况变更", "投资人", "投资人（股权）备案", "投资人(股权)备案", "投资人(股权)变更", "投资人（股权)变更", "投资人（股权）变更", "投资人（股权内部转让）备案", "投资人备案", "投资人变更", "投资人变更（包括出资额、出资方式、出资日期、投资人名",
			"投资人变更（包括出资额、出资方式、出资日期、投资人名称等）", "投资人变更（包括出资额、出资方式、出资日期、投资人名称等）变更", "投资人股权内部转让、出资信息备案", "投资人强制转让股权信息", "投资人认缴出资信息", "投资人实缴出资信息", "投资人信息变更", "投资人信息变更（包括投资人、出资额、出资方式、出资日期、投资人名称等）", "投资人姓名",
			"投资人姓名变更", "投资人姓名或名称", "投资者（股东、发起人）", "投资者变更", "投资者名称（姓名)", "投资者名称(姓名)", "投资者名称（姓名）", "投资者名称(姓名)变更", "投资者名称（姓名)变更", "投资者名称（姓名）变更", "投资者名称备案", "投资者名称或姓名", "投资者人数", "投资总额", "投资总额 币种",
			"投资总额 折万美元", "投资总额(万元)", "投资总额（万元）", "投资总额币种", "投资总额变更", "投资总额变更变更", "投资总额折美元（万美元）", "投资总额折万美元", "外方认缴资本变更", "外方实缴出资数额(万元)", "外方实缴出资数额折万美元", "外方投资总额", "中方认缴出资数额(万元)", "中方认缴出资数额折万美元",
			"中方实缴出资数额(万元)", "中方实缴出资数额折万美元", "自然人股东");

	/**
	 * 经营范围 词汇
	 */
	public static final ImmutableSet<String> SCOPE_OF_BUSINESS_WORDS = ImmutableSet.of("行业代码", "行业代码变更", "行业类别或行业代码", "行业类型", "行业类型变更", "行业门类", "兼营变更", "兼营范围", "经济性质", "经济性质变更", "经营(业务)范围", "经营范围",
			"经营范围(业务范围)变更", "经营范围（业务范围)变更", "经营范围（业务范围）变更", "经营范围备案", "经营范围变更", "经营范围变更（含业务范围变更）", "经营范围变更（含业务范围变更）1000变更", "经营范围变更（含业务范围变更）变更", "经营范围变更4D6（含业务范围变更）", "经营范围及方式", "经营范围兼营", "经营方式",
			"经营方式变更", "经营方式变更变更", "经营类别", "经营类别变更", "前置许可经营项目", "前置许可经营项目变更", "前置许可信息", "所属行业", "许可经营项目", "许可经营项目变更", "许可经营项目变更变更", "许可信息", "业务范围", "业务范围变更", "重点热点行业", "主营范围", "主营项目类别");

	/**
	 * 注册地址 词汇
	 */
	public static final ImmutableSet<String> ADDRESS_WORDS = ImmutableSet.of("场所（经营或许可）", "地址", "地址变更", "地址变更（住所地", "地址变更（住所地址、经营场所", "地址变更（住所地址、经营场所、驻在地址等变更）", "地址变更(住所地址、经营场所、驻在地址等变更）",
			"地址变更（住所地址、经营场所、驻在地址等变更）变更", "地址变更（住所地址、经营场所、驻在地址等变更?", "合伙人姓名及住所、承担责任方式、认缴或实缴的出资额、出资方式、评估方式变更", "经营场所", "经营场所备案", "经营场所备案信息", "经营场所变更", "经营场所产权变更", "经营地址", "经营地址变更", "企业住所", "企业住所变更",
			"实际经营场所", "业务场所变更", "营业(经营)场所", "营业场所", "营业场所变更", "营业场所所在行政区划", "主要经营场所", "主要经营场所变更", "住所", "住所(地址)", "住所(经营场所)变更", "住所(营?场所、地址)变更", "住所(营业场所、地址)变更", "住所（营业场所、地址)变更", "住所（营业场所、地址）变更",
			"住所(营业场所、地址)门牌号变更", "住所/经营场所", "住所变更", "住所或经营场所信息", "驻在场所", "驻在地址", "驻在地址变更", "驻在期限", "驻在期限变更", "驻在期限截止日期", "驻在期限至变更");

	/**
	 * 名称变更全匹配 词汇
	 */
	public static final ImmutableMap<String, String> ENTPRISE_NAME_WORDS_EQ = ImmutableMap.of("名称", "名称变更");
	/**
	 * 股东变更全匹配 词汇
	 */
	public static final ImmutableMap<String, String> LEGAL_WORDS_EQ = ImmutableMap.of("经营者名称变更", "法定代表人变更");

	public static final ImmutableMap<String, String> SHAREHOLDER_OR_INVESTOR_WORDS_EQ = ImmutableMap.of("发起人名称变更", "股东/投资人变更", "股东、发起人名称变更", "股东/投资人变更", "股东或股份发起人改变姓名或名称变更", "股东/投资人变更", "股东名称变更",
			"股东变更", "合伙人姓名或名称变更", "股东/投资人变更");

	public static final ImmutableSet<String> ENTPRISE_NAME_WORDS = ImmutableSet.of("机构名称", "集团名称变更", "名称变更", "名称变更（字号名称、集团名称等）", "名称变更（字号名称、集团名称等）变更", "名称简称", "名称简称变更", "名称预核准号", "名称字号", "企业(机构)名称",
			"企业集团名称", "企业名称", "企业名称（外文）", "企业名称变更", "外国（地区）企业名称", "外国(地区)企业名称", "主机构名称", "主机构注册号", "字号名称", "字号名称变更"
	);

    /**
     * 注册资本变更 词汇
     */
	public static final ImmutableSet<String> REGISTERED_CAPITAL_DIRECTION_WORDS = ImmutableSet.of("出资方式(注册资本)", "实收资本", "实收资本 折万美元", "实收资本(或外资中方实收资本)", "实收资本（或外资中方实收资本）", "实收资本(或外资中方实收资本)变更",
			"实收资本（金）", "实收资本(万元)", "实收资本备案", "实收资本币种", "实收资本变更", "实收资本变更(万元)", "实收资本变更变更", "实收资本折人民币(万元)", "实收资本折万美元", "外方实收资本", "外方实收资本(万元)", "外方实收资本出资比例", "外方实收资本出资方式", "外方实收资本折万美元", "外方注册资本",
			"外方注册资本 折万美元", "外方注册资本(金)(万元)", "外方注册资本(金)出资比例(%)", "外方注册资本变更", "外方注册资本出资方式", "外方注册资本折万美元变更", "中方实收资本(万元)", "中方实收资本出资比例(%)", "中方实收资本出资方式", "中方实收资本折万美元", "中方注册资本", "中方注册资本 折万美元",
			"中方注册资本(金)(万元)", "中方注册资本(金)出资比例", "中方注册资本(金)折万美元", "中方注册资本变更", "中方注册资本出资方式", "中方注册资本折万美元变更", "注册资本", "注册资本(或外资中方认缴资本)", "注册资本（或外资中方认缴资本)", "注册资本（或外资中方认缴资本）", "注册资本(或外资中方认缴资本)变更",
			"注册资本(金) 折万美元", "注册资本(金)币种", "注册资本（金)变更", "注册资本(金)变更", "注册资本（金）变更", "注册资本(金)变更(万元)", "注册资本(金)折人民币(万元)", "注册资本(万元)", "注册资本（万元）", "注册资本(资金数额)变更", "注册资本币种", "注册资本变更",
			"注册资本变更（注册资本、注册资金、成员出资总额等变更）", "注册资本变更（注册资金、资金数额等变更）", "注册资本变更（注册资金、资金数额等变更）变更", "注册资本折美元（万美元）", "注册资本折万美元", "注册资金", "注册资金（万元）", "注册资金(万元)", "注册资金变更", "资金", "资金数额", "资金数额（万元）", "资金数额（元）",
			"资金数额币种", "资金数额变更", "资金数额折人民币", "资金数额折万美元");

}
