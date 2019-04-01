package xin.tianchuang.common.enums;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;

public enum TysDataStateEnum implements IEnum {
	INIT(0, "未采集"), //
	FINISH(1, "采集成功"), //
	UNKNOWN(3, "采集"), //
	NOT_FOUND(4, "爬取未发现企业"), //
	ERROR(5, "爬取异常企业"), //
	NEW(6, "新增初始化采集"), //
	RENAME(7, "已修改名称的旧企业"), //
	WAIT(9, "等待采集"), //
	;

	private Integer key;
	private String desc;

	TysDataStateEnum(int key, String desc) {
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
