package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业关系图谱节点-返回对象模型")
public class LoanBizOneKeyCNodesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6259953022030158032L;

	@ApiModelProperty(name = "id", value = "节点id")
	private String id; // 节点id

	@ApiModelProperty(name = "properties", value = "关系节点属性")
	private LoanBizOneKeyCNodesPropertiesDTO properties;

	@ApiModelProperty(name = "labels", value = "节点标签")
	private List<String> labels; // 节点标签

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LoanBizOneKeyCNodesPropertiesDTO getProperties() {
		return properties;
	}

	public void setProperties(LoanBizOneKeyCNodesPropertiesDTO properties) {
		this.properties = properties;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

}
