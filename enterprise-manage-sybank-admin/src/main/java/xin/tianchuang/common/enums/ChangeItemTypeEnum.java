package xin.tianchuang.common.enums;

import xin.tianchuang.common.enums.base.StrEnum;

/**
 * Created by lee on 2019/3/19.
 */
public enum ChangeItemTypeEnum implements StrEnum {

    REG_CAPITAL("REG_CAPITAL", "注册资本变更"), //
    LEGAL("LEGAL", "法定代表人变更"), //
    BUSINESS_SCOPE("BUSINESS_SCOPE", "经营范围变更"), //
    HOLDER("HOLDER", "股东变更"), //
    INDUSTRY("INDUSTRY", "行业类型变更"), //
    REG_LOCATION("REG_LOCATION", "住所变量"), //
    NAME("NAME","名称变更"),
    DONGJIANGAO("DONGJIANGAO", "董监高变更"), //
    ENTERPRISETYPE("ENTERPRISETYPE", "企业类型变更"), //
    ;


    private String key;
    private String desc;

    ChangeItemTypeEnum(String key, String desc) {
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
