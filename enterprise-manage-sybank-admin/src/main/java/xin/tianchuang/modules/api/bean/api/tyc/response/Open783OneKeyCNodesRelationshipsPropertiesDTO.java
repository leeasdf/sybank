package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

public class Open783OneKeyCNodesRelationshipsPropertiesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7289780928230927587L;
	private List<String> labels; // 关系标签

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

}