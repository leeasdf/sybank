package xin.tianchuang.modules.api.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.toolkit.IdWorker;

/**
 * api 搜索表单
 * 
 * @author denghui
 *
 */
@ApiModel(value = "api搜索表单")
public class ApiSearchForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -462946210471565082L;

	@ApiModelProperty(value = "企业名称")
	@NotBlank(message = "企业名称不能为空")
	private String name;

	@ApiModelProperty(value = "uuid")
	private String uuid;

	public String getName() {
		return StringUtils.isNotBlank(name) ? fixName(name) : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return StringUtils.isBlank(uuid) ? IdWorker.get32UUID() : uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	private String fixName(String name) {
		// 替换对应的英文括号为中文括号
		if (StringUtils.isNotBlank(name)) {
			if (name.indexOf('(') > -1) {
				name = name.replace("(", "（");
			}
			if (name.indexOf(')') > -1) {
				name = name.replace(")", "）");
			}
		}
		return name;
	}
}
