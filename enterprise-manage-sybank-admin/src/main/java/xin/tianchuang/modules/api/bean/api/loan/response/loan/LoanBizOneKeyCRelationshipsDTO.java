package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "企业关系图谱-返回对象模型")
public class LoanBizOneKeyCRelationshipsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9187619869367737037L;

	@ApiModelProperty(name = "startNode", value = "开始节点")
	private String startNode;

	@ApiModelProperty(name = "id", value = "节点id")
	private String id;
	@ApiModelProperty(name = "type", value = "节点类型")
	private String type;
	@ApiModelProperty(name = "endNode", value = "结束节点")
	private String endNode;
	@ApiModelProperty(name = "properties", value = "关系属性")
	private LoanBizOneKeyCNodesRelationshipsPropertiesDTO properties;

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEndNode() {
		return endNode;
	}

	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}

	public LoanBizOneKeyCNodesRelationshipsPropertiesDTO getProperties() {
		return properties;
	}

	public void setProperties(LoanBizOneKeyCNodesRelationshipsPropertiesDTO properties) {
		this.properties = properties;
	}

}
