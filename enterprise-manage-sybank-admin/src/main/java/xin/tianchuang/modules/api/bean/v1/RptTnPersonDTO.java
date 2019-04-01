package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;

/**
 * 主要人员
 * 
 * @author hui.deng
 * @email
 * @date 2018-09-07 11:17:21
 */

public class RptTnPersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2953734704927356568L;

	/**
	 * 主要人员id
	 */
	private String legalId;
	/**
	 * 主要人员名称 varchar(50)
	 */
	private String name;
	/**
	 * 职位 varchar(31)
	 */
	private String job;

	//toco 拥有公司个数
	//array typeJoin 职位
	// logo varchar(150)
	// type 1-公司 2-人
	/**
	 * 设置：主要人员名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：主要人员名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：职位
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * 获取：职位
	 */
	public String getJob() {
		return job;
	}

	public String getLegalId() {
		return legalId;
	}

	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}

}
