package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open783OneKeyCRelationshipsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6916066489333776626L;
	private String startNode;
	@SerializedName("id")
	private String refId;
	private String type;
	private String endNode;
	private Open783OneKeyCNodesRelationshipsPropertiesDTO properties;

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
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

	public Open783OneKeyCNodesRelationshipsPropertiesDTO getProperties() {
		return properties;
	}

	public void setProperties(Open783OneKeyCNodesRelationshipsPropertiesDTO properties) {
		this.properties = properties;
	}

}
