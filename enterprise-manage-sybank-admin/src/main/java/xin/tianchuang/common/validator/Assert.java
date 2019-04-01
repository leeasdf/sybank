package xin.tianchuang.common.validator;

import org.apache.commons.lang.StringUtils;

import xin.tianchuang.common.exception.SpiderException;

/**
 * 数据校验
 * @author hui.deng
 * 
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new SpiderException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new SpiderException(message);
        }
    }
}
