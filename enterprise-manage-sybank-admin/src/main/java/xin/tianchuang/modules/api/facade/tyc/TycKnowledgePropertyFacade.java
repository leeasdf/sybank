package xin.tianchuang.modules.api.facade.tyc;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTnIcpDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPatentDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnSoftwareRightAuthorDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnTrademarkDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnWorksRightDTO;

/**
 * 天眼查-知识产权
 * 
 * @author denghui
 *
 */
public interface TycKnowledgePropertyFacade {

	/**
	 * 商标信息
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTnTrademarkDTO> getTmInfo(String name, String creditCode);

	/**
	 * 专利信息
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTnPatentDTO> getPatent(String name, String creditCode);

	/**
	 * 软件著作权
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTnSoftwareRightAuthorDTO> getCopyright(String name, String creditCode);

	/**
	 * 作品著作权
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTnWorksRightDTO> getCopyrightWorks(String name, String creditCode);

	/**
	 * 网站备案
	 * 
	 * @param name
	 * @param creditCode
	 * @return
	 */
	List<RptTnIcpDTO> getIcp(String name, String creditCode);

}
