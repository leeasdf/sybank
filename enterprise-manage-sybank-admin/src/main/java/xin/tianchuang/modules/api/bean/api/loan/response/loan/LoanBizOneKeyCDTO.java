package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "企业关系-返回对象模型")
public class LoanBizOneKeyCDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8449922063718948762L;

	@ApiModelProperty(name = "nodes", value = "关系节点")
	private List<LoanBizOneKeyCNodesDTO> nodes;

	@ApiModelProperty(name = "relationships", value = "关系")
	private List<LoanBizOneKeyCRelationshipsDTO> relationships;

	public List<LoanBizOneKeyCNodesDTO> getNodes() {
		return nodes;
	}

	public void setNodes(List<LoanBizOneKeyCNodesDTO> nodes) {
		this.nodes = nodes;
	}

	public List<LoanBizOneKeyCRelationshipsDTO> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<LoanBizOneKeyCRelationshipsDTO> relationships) {
		this.relationships = relationships;
	}

}