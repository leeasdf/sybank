package xin.tianchuang.modules.api.bean.api.loan.response.risk;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lee on 2019/3/11.
 */
@ApiModel(value = "高管驾驶舱-添加新的去企业名单返回对象 模型")
public class RiskManageNewRntResponseDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7634034060446773578L;

	/**
     * 总企业数
     */
    @ApiModelProperty(name = "totalCount", value = "总企业数")
    private Integer totalCount;

    /**
     * 新增企业数
     */
    @ApiModelProperty(name = "addCount", value = "新增企业数")
    private Integer addCount;

    /**
     * 已经存在数
     */
    @ApiModelProperty(name = "existCount", value = "已经存在数")
    private Integer existCount;

    /**
     * 存在的结果记录
     */
    @ApiModelProperty(name = "existList", value = "存在的结果记录")
    private List<RiskManageNewEntReqDTO> existList;


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getAddCount() {
        return addCount;
    }

    public void setAddCount(Integer addCount) {
        this.addCount = addCount;
    }

    public Integer getExistCount() {
        return existCount;
    }

    public void setExistCount(Integer existCount) {
        this.existCount = existCount;
    }

    public List<RiskManageNewEntReqDTO> getExistList() {
        return existList;
    }

    public void setExistList(List<RiskManageNewEntReqDTO> existList) {
        this.existList = existList;
    }
}
