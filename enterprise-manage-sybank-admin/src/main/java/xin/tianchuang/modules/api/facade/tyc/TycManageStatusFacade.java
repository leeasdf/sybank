package xin.tianchuang.modules.api.facade.tyc;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTnBidDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCheckDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnImportExportDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTaxCreditDTO;

/**
 * 天眼查-经营状况
 * 
 * @author denghui
 *
 */
public interface TycManageStatusFacade {
	// 招投标信息
	List<RptTnBidDTO> getBid(String name, String creditCode);

	// 债券信息
	// 购地信息
	// 招聘信息
	List<RptTnTaxCreditDTO> getTaxCredit(String name, String creditCode);

	// 抽查检查
	List<RptTnCheckDTO> getCheck(String name, String creditCode);

	// 产品信息
	// 进出口信用
	List<RptTnImportExportDTO> getImportAndExport(String name, String creditCode);
	// 资质证书
	// String getCertificate(String name, String creditCode);
	// 微信公众号
	// String getWechat(String name, String creditCode);

}
