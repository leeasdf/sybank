package xin.tianchuang.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xin.tianchuang.common.enums.tcxy.TcxyApiStatusCodeEnum;

import com.google.gson.Gson;

/**
 * 返回数据
 * 
 * @author hui.deng
 * 
 * @date 2016年10月27日 下午9:59:27
 */
@ApiModel(value = "业务系统返回对象模型")
public class ApiResp<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6702024225265250374L;

	private static Logger logger = LoggerFactory.getLogger(ApiResp.class);

	@ApiModelProperty(name = "status", value = "返回码", example = "10")
	private Integer status;

	@ApiModelProperty(name = "message", value = "返回信息", example = "成功")
	private String message;

	@ApiModelProperty(name = "bizCode", value = "请求业务代码")
	private String bizCode;

	@ApiModelProperty(name = "seqNum", value = "返回业务代码")
	private String seqNum;

	private T data;

	public ApiResp() {
		this.setStatus(TcxyApiStatusCodeEnum.SUCCESS.key());
		this.setMessage(TcxyApiStatusCodeEnum.SUCCESS.desc());
	}

	// public ApiResp<Map<String, Object>> ok(Map<String, Object> map) {
	// ApiResp<Map<String, Object>> r = new ApiResp<Map<String, Object>>();
	// r.putAll(map);
	// return r;
	// }

	public ApiResp<T> error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	public ApiResp<T> error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	public ApiResp<T> error(int code, String msg) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setStatus(code);
		apiResp.setMessage(msg);
		logger.error("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> successNoData(String bizCode, String seqNum) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setStatus(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.key());
		apiResp.setMessage(TcxyApiStatusCodeEnum.SUCCESS_NO_DATA.desc());
		apiResp.setBizCode(bizCode);
		apiResp.setSeqNum(seqNum);
		logger.error("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> error(int code, String msg, String bizCode, String seqNum) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setStatus(code);
		apiResp.setMessage(msg);
		apiResp.setBizCode(bizCode);
		apiResp.setSeqNum(seqNum);
		logger.error("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> ok() {
		return new ApiResp<T>();
	}

	public ApiResp<T> ok(String msg) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setMessage(msg);
		logger.info("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> ok(T data) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setData(data);
		logger.info("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> ok(String bizCode, String seqNum) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setBizCode(bizCode);
		apiResp.setSeqNum(seqNum);
		logger.info("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	public ApiResp<T> ok(String bizCode, String seqNum, T data) {
		ApiResp<T> apiResp = new ApiResp<T>();
		apiResp.setBizCode(bizCode);
		apiResp.setSeqNum(seqNum);
		apiResp.setData(data);
		logger.info("{}", new Gson().toJson(apiResp));
		return apiResp;
	}

	// @Override
	// public ApiResp<T> put(String key, Object value) {
	// super.put(key, value);
	// return this;
	// }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
