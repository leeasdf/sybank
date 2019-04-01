package xin.tianchuang.modules.api.form;

import io.swagger.annotations.ApiModelProperty;

import org.apache.commons.lang3.StringUtils;

import xin.tianchuang.common.bean.BaseDTO;

import com.baomidou.mybatisplus.toolkit.IdWorker;

public class BaseForm extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -921034792512127744L;

	@ApiModelProperty(value = "appId")
	private String appId;

	@ApiModelProperty(value = "token")
	private String tokenKey;

	@ApiModelProperty(value = "uuid")
	private String uuid;

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

	public String getUuid() {
		return StringUtils.isBlank(uuid) ? IdWorker.get32UUID() : uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
