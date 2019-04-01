package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

public enum KtannouncementsBltntypeEnum implements StrEnum {

	T_62  ("62","裁判文书"),
	T_132 ("132","起诉状副本及开庭公告"),
	T_60  ("60","起诉状，上诉状副本"),
	T_66  ("66","执行文书"),
	T_63  ("63","公示催告"),
	
	T_65  ("65","宣告失踪、死亡"),
	T_61  ("61","开庭传票"),
	T_152 ("152","更正"),
	T_64  ("64","破产文书"),
	T_195 ("195","清算公告"),
	
	T_193 ("193","仲裁文书"),
	T_194 ("194","拍卖公告"),
	T_133 ("133","其他"),
	T_192 ("192","海事文书"),
	T_191 ("191","司法鉴定书"),
	
	T_190 ("190","遗失声明"),
	T_196 ("196","行政处罚通知书"),
	T_68  ("68","无主财产认定公告"),
	T_254 ("254","公益诉讼"),
	T_255 ("255","送达公告"),

	;

	private String key;
	private String desc;

	KtannouncementsBltntypeEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}
}
