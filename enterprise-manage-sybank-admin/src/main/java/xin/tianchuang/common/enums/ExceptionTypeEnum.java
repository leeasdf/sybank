package xin.tianchuang.common.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * Created by yp-tc-m-7179 on 2018/10/26.
 */
public enum ExceptionTypeEnum implements IEnum {
    SPIDER_EXCEPTION(1, "爬虫异常");
    private  int key;
    private String desc;

    ExceptionTypeEnum(int key, String desc) {
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
