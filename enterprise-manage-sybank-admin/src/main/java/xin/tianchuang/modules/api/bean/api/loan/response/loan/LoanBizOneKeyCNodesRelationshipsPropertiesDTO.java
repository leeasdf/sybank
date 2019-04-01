package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业关系标签-返回对象模型")
public class LoanBizOneKeyCNodesRelationshipsPropertiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2177362078289450531L;

	@ApiModelProperty(name = "labels", value = "关系标签")
	private List<String> labels; // 关系标签

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

}