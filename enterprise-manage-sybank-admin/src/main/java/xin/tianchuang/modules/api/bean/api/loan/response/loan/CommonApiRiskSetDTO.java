package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
@ApiModel(value = "企业-经营风险-行政处罚）")
public class CommonApiRiskSetDTO {

    //经营异常
    private List<AbnormalDTO> abnormals;

    //行政处罚-信用中国新版
    private List<PunishCreditChinaDTO> punishCreditChinas;

    private List<OwnTaxDTO> ownTaxs;

    //股权出质
    private List<EquityInfoDTO> equityInfos;
    //动产抵押
    private List<MortgageInfoDTO> mortgageInfos;

    public List<EquityInfoDTO> getEquityInfos() {
        return equityInfos;
    }

    public void setEquityInfos(List<EquityInfoDTO> equityInfos) {
        this.equityInfos = equityInfos;
    }

    public List<MortgageInfoDTO> getMortgageInfos() {
        return mortgageInfos;
    }

    public void setMortgageInfos(List<MortgageInfoDTO> mortgageInfos) {
        this.mortgageInfos = mortgageInfos;
    }

    public List<AbnormalDTO> getAbnormals() {
        return abnormals;
    }

    public void setAbnormals(List<AbnormalDTO> abnormals) {
        this.abnormals = abnormals;
    }

    public List<PunishCreditChinaDTO> getPunishCreditChinas() {
        return punishCreditChinas;
    }

    public void setPunishCreditChinas(List<PunishCreditChinaDTO> punishCreditChinas) {
        this.punishCreditChinas = punishCreditChinas;
    }

    public List<OwnTaxDTO> getOwnTaxs() {
        return ownTaxs;
    }

    public void setOwnTaxs(List<OwnTaxDTO> ownTaxs) {
        this.ownTaxs = ownTaxs;
    }
}
