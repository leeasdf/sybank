package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/8.
 */
@ApiModel(value = "企业-其它信息-关联图谱）")
public class OneKeyNodeDTO {

	@ApiModelProperty(name = "nodes", value = "关系节点")
    private List<LoanBizOneKeyCNodesDTO> refNodes;

	@ApiModelProperty(name = "relationships", value = "关系")
    private List<LoanBizOneKeyCRelationshipsDTO> refRelationships;

	public List<LoanBizOneKeyCNodesDTO> getRefNodes() {
		return refNodes;
	}

	public void setRefNodes(List<LoanBizOneKeyCNodesDTO> refNodes) {
		this.refNodes = refNodes;
	}

	public List<LoanBizOneKeyCRelationshipsDTO> getRefRelationships() {
		return refRelationships;
	}

	public void setRefRelationships(List<LoanBizOneKeyCRelationshipsDTO> refRelationships) {
		this.refRelationships = refRelationships;
	}


}
