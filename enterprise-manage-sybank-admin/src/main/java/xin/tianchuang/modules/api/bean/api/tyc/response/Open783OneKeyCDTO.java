package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open783OneKeyCDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8532521944034820535L;
	private List<Open783OneKeyCNodesDTO> nodes;
	private List<Open783OneKeyCRelationshipsDTO> relationships;

	public List<Open783OneKeyCNodesDTO> getNodes() {
		return nodes;
	}

	public void setNodes(List<Open783OneKeyCNodesDTO> nodes) {
		this.nodes = nodes;
	}

	public List<Open783OneKeyCRelationshipsDTO> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Open783OneKeyCRelationshipsDTO> relationships) {
		this.relationships = relationships;
	}

}