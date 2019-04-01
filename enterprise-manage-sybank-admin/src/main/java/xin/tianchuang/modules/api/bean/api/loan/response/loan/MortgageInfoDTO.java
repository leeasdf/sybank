package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by lee on 2019/3/16.
 */
@ApiModel(value = "企业-经营风险-动产抵押")
public class MortgageInfoDTO {
    @ApiModelProperty(name = "baseInfo", value = "基本信息")
    private MortgageInfoBaseInfoDTO baseInfo;
    @ApiModelProperty(name = "changeInfoList", value = "变更信息")
    private List<MortgageChangeInfoListDTO> changeInfoList;
    @ApiModelProperty(name = "pawnInfoList", value = "质押信息")
    private List<MortgagePawnInfoListDTO> pawnInfoList;
    @ApiModelProperty(name = "peopleInfo", value = "抵押权人信息")
    private List<MortgagePeopleInfoDTO> peopleInfo;

    public MortgageInfoBaseInfoDTO getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(MortgageInfoBaseInfoDTO baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<MortgageChangeInfoListDTO> getChangeInfoList() {
        return changeInfoList;
    }

    public void setChangeInfoList(List<MortgageChangeInfoListDTO> changeInfoList) {
        this.changeInfoList = changeInfoList;
    }

    public List<MortgagePawnInfoListDTO> getPawnInfoList() {
        return pawnInfoList;
    }

    public void setPawnInfoList(List<MortgagePawnInfoListDTO> pawnInfoList) {
        this.pawnInfoList = pawnInfoList;
    }

    public List<MortgagePeopleInfoDTO> getPeopleInfo() {
        return peopleInfo;
    }

    public void setPeopleInfo(List<MortgagePeopleInfoDTO> peopleInfo) {
        this.peopleInfo = peopleInfo;
    }
}
