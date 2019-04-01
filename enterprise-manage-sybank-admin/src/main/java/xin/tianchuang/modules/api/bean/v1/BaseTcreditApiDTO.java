package xin.tianchuang.modules.api.bean.v1;

import xin.tianchuang.common.bean.BaseDTO;


public class BaseTcreditApiDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 405388670709105331L;

	/**
	 * 授权码
	 */
	private String appId;

	/**
	 * 验证密钥，MD5(url+tokenId+param)，param为形如key=value的字 符串，逗号分隔，按key的字典序排列
	 */
	private String tokenKey;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

}
