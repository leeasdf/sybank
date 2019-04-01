package xin.tianchuang.modules.api.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import xin.tianchuang.common.validator.group.AddGroup;
import xin.tianchuang.common.validator.group.UpdateGroup;

/**
 * 注册表单
 *
 * @author xx
 * @since 3.1.0 2018-01-25
 */
@ApiModel(value = "注册表单")
public class ApiRegisterForm extends BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5591157665408431004L;

	@ApiModelProperty(value = "手机号")
	@NotBlank(message = "手机号不能为空")
	private String mobile;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	@NotBlank(message = "邮箱不能为空", groups = { AddGroup.class, UpdateGroup.class })
	@Email(message = "邮箱格式不正确", groups = { AddGroup.class, UpdateGroup.class })
	private String email;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
