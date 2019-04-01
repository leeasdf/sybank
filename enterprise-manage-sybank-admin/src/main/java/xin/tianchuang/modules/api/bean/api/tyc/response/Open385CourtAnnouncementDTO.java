package xin.tianchuang.modules.api.bean.api.tyc.response;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Open385CourtAnnouncementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8597231029095204391L;

	@SerializedName("id")
	private Long tableId;// id
	@SerializedName("announce_id")
	private Long announceId;// 公告id
	private String bltnno;// 公告号 varchar(50)
	private String bltnstate;// 公告状态号 varchar(20)
	private String bltntype;// 公告类型 varchar(10)
	private String bltntypename;// 公告类型名称 varchar(100)
	private String caseno;// 案件号 varchar(200)
	private String content;// 案件内容 text
	private String courtflag;// 无用
	private String courtcode;// 法院名 varchar(500)
	private String customno;// 无用
	private String dealgrade;// 处理等级 varchar(10)
	private String dealgradename;// 处理等级名称 varchar(50)
	private String judge;// 法官 varchar(50)
	private String judgephone;// 法官电话 varchar(50)
	private String mobilephone;// 手机号 varchar(50)
	private String party1;// 原告 text
	private String party2;// 当事人 text
	private List<Open385CompanyListDTO> companyList;// 公司列表
	private String party1Str;// 跳转到天眼查链接
	private String party2Str;// 跳转到天眼查链接
	private String province;// 省份 varchar(50)
	private String publishdate;// 刊登日期
	private String publishpage;// 刊登版面 varchar(50)
	private String reason;// 原因 varchar(500)
	private String showtxtdate;// 无用
	private String tmpsaversn;// 无用

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Long getAnnounceId() {
		return announceId;
	}

	public void setAnnounceId(Long announceId) {
		this.announceId = announceId;
	}

	public String getBltnno() {
		return bltnno;
	}

	public void setBltnno(String bltnno) {
		this.bltnno = bltnno;
	}

	public String getBltnstate() {
		return bltnstate;
	}

	public void setBltnstate(String bltnstate) {
		this.bltnstate = bltnstate;
	}

	public String getBltntype() {
		return bltntype;
	}

	public void setBltntype(String bltntype) {
		this.bltntype = bltntype;
	}

	public String getBltntypename() {
		return bltntypename;
	}

	public void setBltntypename(String bltntypename) {
		this.bltntypename = bltntypename;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourtflag() {
		return courtflag;
	}

	public void setCourtflag(String courtflag) {
		this.courtflag = courtflag;
	}

	public String getCourtcode() {
		return courtcode;
	}

	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}

	public String getCustomno() {
		return customno;
	}

	public void setCustomno(String customno) {
		this.customno = customno;
	}

	public String getDealgrade() {
		return dealgrade;
	}

	public void setDealgrade(String dealgrade) {
		this.dealgrade = dealgrade;
	}

	public String getDealgradename() {
		return dealgradename;
	}

	public void setDealgradename(String dealgradename) {
		this.dealgradename = dealgradename;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getJudgephone() {
		return judgephone;
	}

	public void setJudgephone(String judgephone) {
		this.judgephone = judgephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getParty1() {
		return party1;
	}

	public void setParty1(String party1) {
		this.party1 = party1;
	}

	public String getParty2() {
		return party2;
	}

	public void setParty2(String party2) {
		this.party2 = party2;
	}

	public List<Open385CompanyListDTO> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Open385CompanyListDTO> companyList) {
		this.companyList = companyList;
	}

	public String getParty1Str() {
		return party1Str;
	}

	public void setParty1Str(String party1Str) {
		this.party1Str = party1Str;
	}

	public String getParty2Str() {
		return party2Str;
	}

	public void setParty2Str(String party2Str) {
		this.party2Str = party2Str;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getPublishpage() {
		return publishpage;
	}

	public void setPublishpage(String publishpage) {
		this.publishpage = publishpage;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getShowtxtdate() {
		return showtxtdate;
	}

	public void setShowtxtdate(String showtxtdate) {
		this.showtxtdate = showtxtdate;
	}

	public String getTmpsaversn() {
		return tmpsaversn;
	}

	public void setTmpsaversn(String tmpsaversn) {
		this.tmpsaversn = tmpsaversn;
	}

}
