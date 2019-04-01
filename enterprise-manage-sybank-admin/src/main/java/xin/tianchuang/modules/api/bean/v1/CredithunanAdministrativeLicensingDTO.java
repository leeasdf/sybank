package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
public class CredithunanAdministrativeLicensingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

//    /**
//     * 主键
//     */
//    @TableId
//    private Long id;
    /**
     * 案件名称
     */
    private String caseName;
    /**
     * 行政许可决定书文号
     */
    private String caseNo;
    /**
     * 行政相对人名称
     */
    private String caseObject;
    /**
     * 法定代表人（或单位负责人）
     */
    private String legalRepresentative;
    /**
     * 执法部门
     */
    private String lawEnforcingDepartment;
    /**
     * 作出行政许可的日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date licensingDate;
    /**
     * 行政许可决定书（全文或摘要）
     */
    private String content;
    /**
     * 发布时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date publishTime;

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
     * 备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的
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
     * 设置：????
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }
    /**
     * 获取：????
     */
    public String getCaseName() {
        return caseName;
    }
    /**
     * 设置：?????????
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }
    /**
     * 获取：?????????
     */
    public String getCaseNo() {
        return caseNo;
    }
    /**
     * 设置：???????
     */
    public void setCaseObject(String caseObject) {
        this.caseObject = caseObject;
    }
    /**
     * 获取：???????
     */
    public String getCaseObject() {
        return caseObject;
    }
    /**
     * 设置：?????????????
     */
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }
    /**
     * 获取：?????????????
     */
    public String getLegalRepresentative() {
        return legalRepresentative;
    }
    /**
     * 设置：????
     */
    public void setLawEnforcingDepartment(String lawEnforcingDepartment) {
        this.lawEnforcingDepartment = lawEnforcingDepartment;
    }
    /**
     * 获取：????
     */
    public String getLawEnforcingDepartment() {
        return lawEnforcingDepartment;
    }
    /**
     * 设置：?????????
     */
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }
    /**
     * 获取：?????????
     */
    public Date getLicensingDate() {
        return licensingDate;
    }
    /**
     * 设置：??????????????
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 获取：??????????????
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：????
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    /**
     * 获取：????
     */
    public Date getPublishTime() {
        return publishTime;
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
