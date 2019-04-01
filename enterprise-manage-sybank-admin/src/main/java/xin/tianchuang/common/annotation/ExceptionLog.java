package xin.tianchuang.common.annotation;

import java.lang.annotation.*;

/**
 * Created by yp-tc-m-7179 on 2018/10/23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionLog {
    String value() default "";
}
