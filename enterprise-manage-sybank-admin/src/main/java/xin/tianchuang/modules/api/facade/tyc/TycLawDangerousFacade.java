package xin.tianchuang.modules.api.facade.tyc;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTnAnnouncementcourtDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnCourtNoticeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnDishonestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnLawsuitDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnZhixingDTO;

/**
 * 天眼查对外-司法风险接口
 * 
 * @author denghui
 *
 */
public interface TycLawDangerousFacade {
	/**
	 * 开庭公告信息
	 * 
	 * @return
	 */
	public List<RptTnAnnouncementcourtDTO> getAnnouncement(String name, String creditCode);

	/**
	 * 法律诉讼信息
	 * 
	 * @return
	 */
	public List<RptTnLawsuitDTO> getLawsuit(String name, String creditCode);

	/**
	 * 法院公告信息
	 * 
	 * @return
	 */
	public List<RptTnCourtNoticeDTO> getCourt(String name, String creditCode);

	/**
	 * 失信人信息
	 * 
	 * @return
	 */
	public List<RptTnDishonestDTO> getDishonest(String name, String creditCode);

	/**
	 * 被执行人信息
	 * 
	 * @return
	 */
	public List<RptTnZhixingDTO> getZhixing(String name, String creditCode);

}
