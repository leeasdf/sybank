package xin.tianchuang.modules.api.facade.tyc;

import java.util.List;

import xin.tianchuang.modules.api.bean.v1.RptTnBasicInfoDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnBranchesDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnChangeDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnInvestDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnPersonDTO;
import xin.tianchuang.modules.api.bean.v1.RptTnShareholdersDTO;

/**
 * 天眼查对外-公司背景接口
 * @author denghui
 *
 */
public interface TycBackgroundFacade {
	 /**
	 * 工商信息
	 * @return
	 */
	public RptTnBasicInfoDTO getGxstBaseInfo(String name, String creditCode);
	/**
	 * 高管人员信息
	 * @return
	 */
	public List<RptTnPersonDTO> getStaff(String name, String creditCode);
	/**
	 * 股东信息
	 * @return
	 */
	public List<RptTnShareholdersDTO> getHolder(String name, String creditCode);
	/**
	 * 对外投资信息
	 * @return
	 */
	public List<RptTnInvestDTO> getInvest(String name, String creditCode);
	/**
	 * 变更记录信息
	 * @return
	 */
	public List<RptTnChangeDTO> getChange(String name, String creditCode);
	/**
	 * 公司年报
	 * @return
	 */
//	public String getReport(String name, String creditCode);
	/**
	 * 分支机构信息
	 * @return
	 */
	public List<RptTnBranchesDTO> getBranch(String name, String creditCode);
	
	
}
