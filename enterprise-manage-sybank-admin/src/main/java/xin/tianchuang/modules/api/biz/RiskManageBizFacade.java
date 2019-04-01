package xin.tianchuang.modules.api.biz;

import xin.tianchuang.modules.api.bean.api.loan.request.RiskManageBizReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewEntReqDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.RiskManageNewRntResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseIndustyDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.risk.TycDataHandleResponseBlackDTO;

import java.util.List;


public interface RiskManageBizFacade {

	TycDataHandleResponseDTO tycReport(RiskManageBizReqDTO param);

    List<TycDataHandleResponseIndustyDTO> getAllNameAndIndustry();

    RiskManageNewRntResponseDTO addNewEntListInfo(List<RiskManageNewEntReqDTO> riskManageNewEntReqDTOList);

    TycDataHandleResponseBlackDTO blackReport(RiskManageBizReqDTO param);

	List<TycDataHandleResponseBlackDTO> blackListReport(
			List<RiskManageBizReqDTO> param);
}
