package xin.tianchuang.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;
import xin.tianchuang.common.utils.ApiResp;

/**
 * 异常处理器
 * 
 * @author hui.deng
 * @param <T>
 * 
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class ApiExceptionHandler<T> {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 * 
	 * @param <T>
	 */
	@ExceptionHandler(ApiException.class)
	public static <T> ApiResp<T> handleException(ApiException e) {
		ApiResp<T> r = new ApiResp<T>();
		r.setStatus(e.getCode());
		r.setMessage(e.getMessage());
		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public static <T> ApiResp<T> handlerNoFoundException(Exception e) {
		return new ApiResp<T>().error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ApiResp<T> handleDuplicateKeyException(DuplicateKeyException e) {
		logger.error(e.getMessage(), e);
		return new ApiResp<T>().error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public ApiResp<T> handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return new ApiResp<T>().error(TcxyApiStatusCodeEnum.SYS_ERR.key(), TcxyApiStatusCodeEnum.SYS_ERR.desc());
	}
}
