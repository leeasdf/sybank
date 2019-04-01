package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Open733CopyRegWorksDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6739637080225352268L;
	@SerializedName("createTime")
	private Long worksCreateTime;// 创建时间 毫秒数
	private String regtime;// 登记日期
	private String authorNationality;// 著作权人姓名/名称 varchar(50)
	private String publishtime;// 发布日期
	private String regnum;// 登记号 varchar(50)
	private String finishTime;// 创作完成日期
	private String type;// 作品类别 varchar(50)
	private String fullname;// 作品名称 varchar(255)

	public Long getWorksCreateTime() {
		return worksCreateTime;
	}

	public void setWorksCreateTime(Long worksCreateTime) {
		this.worksCreateTime = worksCreateTime;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getAuthorNationality() {
		return authorNationality;
	}

	public void setAuthorNationality(String authorNationality) {
		this.authorNationality = authorNationality;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
