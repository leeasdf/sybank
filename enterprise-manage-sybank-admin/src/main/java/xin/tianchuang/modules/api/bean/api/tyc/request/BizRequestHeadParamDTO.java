package xin.tianchuang.modules.api.bean.api.tyc.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BizRequestHeadParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5407052692044482552L;

	/**
	 * 请求token
	 */
	@NotBlank(message = "访问token不能为空")
	private String token;

	/**
	 * 请求地址
	 */
	@NotBlank(message = "请求地址不能为空")
	private String url;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
