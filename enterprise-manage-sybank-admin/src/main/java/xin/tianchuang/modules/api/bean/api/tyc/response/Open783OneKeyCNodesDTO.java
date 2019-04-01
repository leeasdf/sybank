package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open783OneKeyCNodesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880139469527975289L;

	@SerializedName("id")
	private String nodeId; // 节点id

	private Open783OneKeyCNodesPropertiesDTO properties;

	private List<String> labels; // 节点标签

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Open783OneKeyCNodesPropertiesDTO getProperties() {
		return properties;
	}

	public void setProperties(Open783OneKeyCNodesPropertiesDTO properties) {
		this.properties = properties;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

}
