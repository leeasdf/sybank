package xin.tianchuang.modules.api.facade.commonApi;

import xin.tianchuang.modules.api.bean.api.loan.request.CommonApiCompanyReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.*;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 *
 */
public interface CommonApiFacade {

    CommonApiBaseinfoSetDTO getBaseinfoSet(CommonApiCompanyReqDTO param);

    CommonApiJudicialSetDTO getJudicialSet(CommonApiCompanyReqDTO param);

    CommonApiRiskSetDTO getRiskSet(CommonApiCompanyReqDTO param);

    CommonApiBizKnowleageSetDTO getKnowleageList(CommonApiCompanyReqDTO param);

    CommonApiMoreSetDTO getMore(CommonApiCompanyReqDTO param);
}
