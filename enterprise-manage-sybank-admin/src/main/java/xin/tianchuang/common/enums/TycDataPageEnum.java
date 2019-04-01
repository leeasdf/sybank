package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * API接口参数-数据类型
 * 
 * @author denghui
 *
 */
public enum TycDataPageEnum implements IEnum {
	/**
	 * api接口参数
	 */
	INVEST(1, "对外投资"), //
	CHANGE(2, "变更记录"), //
	BRANCHES(3, "分支机构"), //

	LAWSUIT(4, "法律诉讼"), //
	COURT_NOTICE(5, "法院公告"), //
	DISHONEST(6, "失信人"), //
	ZHI_XING(7, "被执行人"), //
	ANNOUNCEMENT_COURT(8, "开庭公告"), //

	ABNORMAL(9, "XXXX"), //
	PUNISH(32, "行政处罚[工商局]"), //
	PENALTIES(10, "行政处罚[信用中国]"), //
	CLEAR(33, "清算信息"), //
	ILLEGAL(11, "严重违法"), //
	OWING_TAX(12, "欠税公告"), //

	TRADEMARK(13, "商标信息"), //
	PATENT(14, "专利信息"), //
	SOFTWARE_RIGHT(15, "软件著作权"), //
	WORKS_RIGHT(16, "作品著作权"), //

	ICP(17, "网站备案"), //
	CHECK(18, "抽查检查"), //
	BID(19, "招投标"), //
	TAX_CREDIT(20, "税务评级"), //

	IMPORT_EXPORT(21, "进出口信用"), //
	EQUITY(22, "股权质押"), //
	JUDICIAL_AID(23, "司法协助"), //
	MORTGAGE(24, "动产抵押"), //
	JUDICIAL_SALE(25, "司法拍卖"), //
	LICENSING_XYZG(26, "行政许可[信用中国]"), //
	CERTIFICATE(27, "资质证书"), //
	PRODUCT(28, "资质证书"), //
	BOND(29, "资质证书"), //
	PURCHASELAND(30, "资质证书"), //
	REPORT(31, "企业年报") //
	;

	private int key;
	private String desc;

	TycDataPageEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public int key() {
		return key;
	}

	public String desc() {
		return desc;
	}

	@Override
	public Serializable getValue() {
		return key;
	}

}
