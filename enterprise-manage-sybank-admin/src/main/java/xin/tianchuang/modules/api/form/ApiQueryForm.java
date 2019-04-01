package xin.tianchuang.modules.api.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.apache.commons.lang3.StringUtils;

/**
 * api 查询表单
 * 
 * @author denghui
 *
 */
@ApiModel(value = "api查询表单")
public class ApiQueryForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7717000676161291807L;

	@ApiModelProperty(value = "企业名称")
	private String name;

	@ApiModelProperty(value = "统一社会信用代码")
	private String creditCode;

	@ApiModelProperty(value = "当前页数，默认第一页，每页20条", example="1")
	private Integer pageNum;

	@ApiModelProperty(value = "页面大小，默认20", example="10")
	private Integer pageSize = 20;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return StringUtils.isNotBlank(name) ? fixName(name) : name;
	}

	public void setName(String enterpriseName) {
		this.name = enterpriseName;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
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
