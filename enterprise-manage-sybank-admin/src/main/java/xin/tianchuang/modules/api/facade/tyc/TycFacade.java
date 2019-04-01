package xin.tianchuang.modules.api.facade.tyc;

import com.alibaba.fastjson.JSONObject;

/**
 * 天眼查对外接口
 * 
 * @author denghui
 *
 */
public interface TycFacade {

	/**
	 * 获取企业数据
	 * 
	 * @param requestJsonParam
	 * @return
	 */
	public JSONObject getEnterpriseData(String requestJsonParam);

	// 公司背景
	public JSONObject getBackGround(String name, String creditCode, JSONObject re);

	// 公司发展
	// @Deprecated
	// public String getDevelope(String name, String creditCode);

	// 司法风险
	public JSONObject getLawDangerous(String name, String creditCode, JSONObject re);

	// 经营风险
	public JSONObject getManageDangerous(String name, String creditCode, JSONObject re);

	// 经营状况
	public JSONObject getManageStatus(String name, String creditCode, JSONObject re);

	// 知识产权
	public JSONObject getKnowledgeProperty(String name, String creditCode, JSONObject re);

	// 历史信息
}