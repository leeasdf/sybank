package xin.tianchuang.common.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.exception.ApiException;
import xin.tianchuang.common.exception.SpiderException;

/**
 * hibernate-validator校验工具类
 *
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author hui.deng
 * 
 * @date 2017-03-15 10:50
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws SpiderException  校验不通过，则报Exception异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws SpiderException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new SpiderException(msg.toString());
        }
    }
    
    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws SpiderException  校验不通过，则报Exception异常
     */
    public static void validateApiEntity(Object object, Class<?>... groups)
    		throws ApiException {
    	Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
    	if (!constraintViolations.isEmpty()) {
    		StringBuilder msg = new StringBuilder();
    		for(ConstraintViolation<Object> constraint:  constraintViolations){
    			msg.append(constraint.getMessage()).append("<br>");
    		}
    		throw new ApiException(msg.toString(), TcxyApiStatusCodeEnum.PARAM_ERR.key());
    	}
    }
}
