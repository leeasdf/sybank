package xin.tianchuang.modules.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-03-21 17:00:07
 */
@TableName("ENT_COURT_ANNOUNCE_INFO")
public class EntCourtAnnounceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer entId;
	/**
	 * 
	 */
	private String entName;
	/**
	 * 
	 */
	private String creditCode;
	/**
	 * 
	 */
	private Long tableId;
	/**
	 * 
	 */
	private Long announceId;
	/**
	 * 
	 */
	private String bltnno;
	/**
	 * 
	 */
	private String bltnstate;
	/**
	 * 
	 */
	private String bltntype;
	/**
	 * 
	 */
	private String bltntypename;
	/**
	 * 
	 */
	private String caseno;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String courtflag;
	/**
	 * 
	 */
	private String courtcode;
	/**
	 * 
	 */
	private String customno;
	/**
	 * 
	 */
	private String dealgrade;
	/**
	 * 
	 */
	private String dealgradename;
	/**
	 * 
	 */
	private String judge;
	/**
	 * 
	 */
	private String judgephone;
	/**
	 * 
	 */
	private String mobilephone;
	/**
	 * 
	 */
	private String party1;
	/**
	 * 
	 */
	private String party2;
	/**
	 * 
	 */
	private String party1Str;
	/**
	 * 
	 */
	private String party2Str;
	/**
	 * 
	 */
	private String province;
	/**
	 * 
	 */
	private String publishdate;
	/**
	 * 
	 */
	private String publishpage;
	/**
	 * 
	 */
	private String reason;
	/**
	 * 
	 */
	private String showtxtdate;
	/**
	 * 
	 */
	private String tmpsaversn;
	/**
	 * 
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value = "update_time", fill = FieldFill.UPDATE)
	private Date updateTime;
	/**
	 * 
	 */
	@TableField(value = "data_status", fill = FieldFill.INSERT)
	private Integer dataStatus;
	/**
	 * 
	 */
	@Version
	private Integer version;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setEntId(Integer entId) {
		this.entId = entId;
	}
	/**
	 * 获取：
	 */
	public Integer getEntId() {
		return entId;
	}
	/**
	 * 设置：
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}
	/**
	 * 获取：
	 */
	public String getEntName() {
		return entName;
	}
	/**
	 * 设置：
	 */
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	/**
	 * 获取：
	 */
	public String getCreditCode() {
		return creditCode;
	}
	/**
	 * 设置：
	 */
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	/**
	 * 获取：
	 */
	public Long getTableId() {
		return tableId;
	}
	/**
	 * 设置：
	 */
	public void setAnnounceId(Long announceId) {
		this.announceId = announceId;
	}
	/**
	 * 获取：
	 */
	public Long getAnnounceId() {
		return announceId;
	}
	/**
	 * 设置：
	 */
	public void setBltnno(String bltnno) {
		this.bltnno = bltnno;
	}
	/**
	 * 获取：
	 */
	public String getBltnno() {
		return bltnno;
	}
	/**
	 * 设置：
	 */
	public void setBltnstate(String bltnstate) {
		this.bltnstate = bltnstate;
	}
	/**
	 * 获取：
	 */
	public String getBltnstate() {
		return bltnstate;
	}
	/**
	 * 设置：
	 */
	public void setBltntype(String bltntype) {
		this.bltntype = bltntype;
	}
	/**
	 * 获取：
	 */
	public String getBltntype() {
		return bltntype;
	}
	/**
	 * 设置：
	 */
	public void setBltntypename(String bltntypename) {
		this.bltntypename = bltntypename;
	}
	/**
	 * 获取：
	 */
	public String getBltntypename() {
		return bltntypename;
	}
	/**
	 * 设置：
	 */
	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}
	/**
	 * 获取：
	 */
	public String getCaseno() {
		return caseno;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setCourtflag(String courtflag) {
		this.courtflag = courtflag;
	}
	/**
	 * 获取：
	 */
	public String getCourtflag() {
		return courtflag;
	}
	/**
	 * 设置：
	 */
	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}
	/**
	 * 获取：
	 */
	public String getCourtcode() {
		return courtcode;
	}
	/**
	 * 设置：
	 */
	public void setCustomno(String customno) {
		this.customno = customno;
	}
	/**
	 * 获取：
	 */
	public String getCustomno() {
		return customno;
	}
	/**
	 * 设置：
	 */
	public void setDealgrade(String dealgrade) {
		this.dealgrade = dealgrade;
	}
	/**
	 * 获取：
	 */
	public String getDealgrade() {
		return dealgrade;
	}
	/**
	 * 设置：
	 */
	public void setDealgradename(String dealgradename) {
		this.dealgradename = dealgradename;
	}
	/**
	 * 获取：
	 */
	public String getDealgradename() {
		return dealgradename;
	}
	/**
	 * 设置：
	 */
	public void setJudge(String judge) {
		this.judge = judge;
	}
	/**
	 * 获取：
	 */
	public String getJudge() {
		return judge;
	}
	/**
	 * 设置：
	 */
	public void setJudgephone(String judgephone) {
		this.judgephone = judgephone;
	}
	/**
	 * 获取：
	 */
	public String getJudgephone() {
		return judgephone;
	}
	/**
	 * 设置：
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**
	 * 获取：
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * 设置：
	 */
	public void setParty1(String party1) {
		this.party1 = party1;
	}
	/**
	 * 获取：
	 */
	public String getParty1() {
		return party1;
	}
	/**
	 * 设置：
	 */
	public void setParty2(String party2) {
		this.party2 = party2;
	}
	/**
	 * 获取：
	 */
	public String getParty2() {
		return party2;
	}
	/**
	 * 设置：
	 */
	public void setParty1Str(String party1Str) {
		this.party1Str = party1Str;
	}
	/**
	 * 获取：
	 */
	public String getParty1Str() {
		return party1Str;
	}
	/**
	 * 设置：
	 */
	public void setParty2Str(String party2Str) {
		this.party2Str = party2Str;
	}
	/**
	 * 获取：
	 */
	public String getParty2Str() {
		return party2Str;
	}
	/**
	 * 设置：
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：
	 */
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	/**
	 * 获取：
	 */
	public String getPublishdate() {
		return publishdate;
	}
	/**
	 * 设置：
	 */
	public void setPublishpage(String publishpage) {
		this.publishpage = publishpage;
	}
	/**
	 * 获取：
	 */
	public String getPublishpage() {
		return publishpage;
	}
	/**
	 * 设置：
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：
	 */
	public void setShowtxtdate(String showtxtdate) {
		this.showtxtdate = showtxtdate;
	}
	/**
	 * 获取：
	 */
	public String getShowtxtdate() {
		return showtxtdate;
	}
	/**
	 * 设置：
	 */
	public void setTmpsaversn(String tmpsaversn) {
		this.tmpsaversn = tmpsaversn;
	}
	/**
	 * 获取：
	 */
	public String getTmpsaversn() {
		return tmpsaversn;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	/**
	 * 设置：
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public Integer getVersion() {
		return version;
	}
}
