package xin.tianchuang.modules.api.bean.v1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
public class CredithunanAbnormalNoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
//    /**
//     * 主键
//     */
//    @TableId
//    private Long id;
    /**
     * 纳税人名称
     */
    private String taxpayer;
    /**
     * 组织机构代码
     */
    private String organizeCode;
    /**
     * 法定代表人
     */
    private String legalRepresentative;
    /**
     * 身份证件号
     */
    private String identityCard;
    /**
     * 主管税务机关
     */
    private String taxAuthority;
    /**
     * 公告日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date declarationDate;
    /**
     * 非正常户认定日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date affirmDate;
    /**
     * 生产经营地址
     */
    private String businessAddress;
    /**
     * 信息名称
     */
    private String infomationName;
    /**
     * 数据来源
     */
    private String source;
    /**
     * 信息类型
     */
    private String infomationType;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date sourceTime;
    /**
     * 爬虫表数据记录id
     */
    private Long spiderId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 数据状态
     */
    private Integer dataStatus;

    /**
     * 设置：?????
     */
    public void setTaxpayer(String taxpayer) {
        this.taxpayer = taxpayer;
    }
    /**
     * 获取：?????
     */
    public String getTaxpayer() {
        return taxpayer;
    }
    /**
     * 设置：??????
     */
    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }
    /**
     * 获取：??????
     */
    public String getOrganizeCode() {
        return organizeCode;
    }
    /**
     * 设置：?????
     */
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }
    /**
     * 获取：?????
     */
    public String getLegalRepresentative() {
        return legalRepresentative;
    }
    /**
     * 设置：?????
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
    /**
     * 获取：?????
     */
    public String getIdentityCard() {
        return identityCard;
    }
    /**
     * 设置：??????
     */
    public void setTaxAuthority(String taxAuthority) {
        this.taxAuthority = taxAuthority;
    }
    /**
     * 获取：??????
     */
    public String getTaxAuthority() {
        return taxAuthority;
    }
    /**
     * 设置：????
     */
    public void setDeclarationDate(Date declarationDate) {
        this.declarationDate = declarationDate;
    }
    /**
     * 获取：????
     */
    public Date getDeclarationDate() {
        return declarationDate;
    }
    /**
     * 设置：????????
     */
    public void setAffirmDate(Date affirmDate) {
        this.affirmDate = affirmDate;
    }
    /**
     * 获取：????????
     */
    public Date getAffirmDate() {
        return affirmDate;
    }
    /**
     * 设置：??????
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
    /**
     * 获取：??????
     */
    public String getBusinessAddress() {
        return businessAddress;
    }
    /**
     * 设置：????
     */
    public void setInfomationName(String infomationName) {
        this.infomationName = infomationName;
    }
    /**
     * 获取：????
     */
    public String getInfomationName() {
        return infomationName;
    }
    /**
     * 设置：????
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * 获取：????
     */
    public String getSource() {
        return source;
    }
    /**
     * 设置：????
     */
    public void setInfomationType(String infomationType) {
        this.infomationType = infomationType;
    }
    /**
     * 获取：????
     */
    public String getInfomationType() {
        return infomationType;
    }
    /**
     * 设置：????????
     */
    public void setSourceTime(Date sourceTime) {
        this.sourceTime = sourceTime;
    }
    /**
     * 获取：????????
     */
    public Date getSourceTime() {
        return sourceTime;
    }
    /**
     * 设置：???????id
     */
    public void setSpiderId(Long spiderId) {
        this.spiderId = spiderId;
    }
    /**
     * 获取：???????id
     */
    public Long getSpiderId() {
        return spiderId;
    }
    /**
     * 设置：????
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：????
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：????
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 获取：????
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：??????????????spiderid????????? ??123?345 ???spider??123??345 ??????????????????spiderid?????
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：??????????????spiderid????????? ??123?345 ???spider??123??345 ??????????????????spiderid?????
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：???
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * 获取：???
     */
    public Integer getVersion() {
        return version;
    }
    /**
     * 设置：????
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }
    /**
     * 获取：????
     */
    public Integer getDataStatus() {
        return dataStatus;
    }
}
