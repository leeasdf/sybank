package xin.tianchuang.modules.api.biz;

import java.util.List;

import xin.tianchuang.common.enums.BizInterfaceTypeEnum;
import xin.tianchuang.modules.api.bean.api.loan.request.*;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizBaseinfoSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizCompanyInfoDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizHolderRelationsSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizIndexDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizJudicialSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizKnowleageSetDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizListedCompanyDTO;
import xin.tianchuang.modules.api.bean.api.loan.response.loan.LoanBizNewsDTO;

public interface LoanBizFacade {

	/**
	 * 根据企业名称，查询企业名录基本信息
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	LoanBizCompanyInfoDTO getEntList(LoanBizCompanyReqDTO param) throws Exception;

	/**
	 * 根据创建时间查询企业名录列表信息
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<LoanBizCompanyInfoDTO> getCompanyList(LoanBizCompanyListReqDTO param) throws Exception;

	/**
	 * 工商集合
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	LoanBizBaseinfoSetDTO getBaseinfoSet(LoanBizCompanyReqDTO param) throws Exception;

	/**
	 * 司法集合
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	LoanBizJudicialSetDTO getJudicialSet(LoanBizCompanyReqDTO param) throws Exception;

	/**
	 * 舆情集合
	 * 
	 * @param param
	 * @return
	 */
	List<LoanBizNewsDTO> getNewsSet(LoanBizCompanyReqDTO param);

	/**
	 * 查询上市基本信息
	 * 
	 * @param param
	 * @return
	 */
	LoanBizListedCompanyDTO getListedCompany(LoanBizCompanyReqDTO param);

	/**
	 * 知识产权集合
	 * 
	 * @param param
	 * @return
	 */
	LoanBizKnowleageSetDTO getKnowleageList(LoanBizCompanyReqDTO param);

	/**
	 * 根据企业名称查询股东信息集合 规则：①如果股东为自然人股东，则返回相应信息；②如果股东为企业股东，这需要获得对应的法人姓名和统一社会信用代码
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<LoanBizHolderRelationsSetDTO> getHoldersSet(LoanBizViewReqDTO param) throws Exception;

	boolean saveReport(LoanBizReportReqDTO param, BizInterfaceTypeEnum interfaceType);

	boolean saveReport(LoanBizReportTimeReqDTO param, BizInterfaceTypeEnum interfaceType);

    LoanBizIndexDTO getIndex( LoanBizCompanyReqDTO param);
}
