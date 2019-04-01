package xin.tianchuang.modules.api.facade.tyc;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTnAbnormalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnEquityDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnIllegalDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnOwingTaxDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPenaltiesDTO;

/**
 * 天眼查对外-经营风险接口
 * @author denghui
 *
 */
public interface TycManageDangerousFacade {
	/**
	 * 经营异常信息
	 * @return
	 */
	public List<RptTnAbnormalDTO> getAbnormal(String name, String creditCode);
	/**
	 * 行政处罚信息
	 * @return
	 */
	public List<RptTnPenaltiesDTO> getPunish(String name, String creditCode);
	/**
	 * 严重违法信息
	 * @return
	 */
	public List<RptTnIllegalDTO> getIllegal(String name, String creditCode);
	/**
	 * 股权出质信息
	 * @return
	 */
	public List<RptTnEquityDTO> getEquity(String name, String creditCode);
	/**
	 * 动产抵押信息
	 * @return
	 */
//	public String getZhixing(String name, String creditCode);
	/**
	 * 欠税公告信息
	 * @return
	 */
	public List<RptTnOwingTaxDTO> getOwntax(String name, String creditCode);
	/**
	 * 司法拍卖信息
	 * @return
	 */
//	public String getZhixing(String name, String creditCode);
	
	
}
