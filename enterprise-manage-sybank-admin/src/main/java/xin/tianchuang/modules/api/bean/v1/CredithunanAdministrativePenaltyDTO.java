package xin.tianchuang.modules.api.bean.v1;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
public class CredithunanAdministrativePenaltyDTO implements Serializable {
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
     * 行政处罚决定书文号
     */
    private String caseNo;
    /**
     * 行政相对人名称
     */
    private String caseObject;
    /**
     * 法定代表人（或单位负责人）
     */
    private String representative;
    /**
     * 执法部门
     */
    private String lowDepartment;
    /**
     * 作出行政处罚的日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date punishmentDate;
    /**
     * 行政处罚决定书（全文或摘要）
     */
    private String content;
    /**
     * 发布日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date issueDate;
    /**
     * 爬虫表数据记录id
     */
    private Long spiderId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    /**
     * 备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的
     */
    private String remark;
    /**
     * 版本号
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer version;
    /**
     * 数据状态
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer dataStatus;


    /**
     * 设置：案件名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }
    /**
     * 获取：案件名称
     */
    public String getCaseName() {
        return caseName;
    }
    /**
     * 设置：行政处罚决定书文号
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }
    /**
     * 获取：行政处罚决定书文号
     */
    public String getCaseNo() {
        return caseNo;
    }
    /**
     * 设置：行政相对人名称
     */
    public void setCaseObject(String caseObject) {
        this.caseObject = caseObject;
    }
    /**
     * 获取：行政相对人名称
     */
    public String getCaseObject() {
        return caseObject;
    }
    /**
     * 设置：法定代表人（或单位负责人）
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }
    /**
     * 获取：法定代表人（或单位负责人）
     */
    public String getRepresentative() {
        return representative;
    }
    /**
     * 设置：执法部门
     */
    public void setLowDepartment(String lowDepartment) {
        this.lowDepartment = lowDepartment;
    }
    /**
     * 获取：执法部门
     */
    public String getLowDepartment() {
        return lowDepartment;
    }
    /**
     * 设置：作出行政处罚的日期
     */
    public void setPunishmentDate(Date punishmentDate) {
        this.punishmentDate = punishmentDate;
    }
    /**
     * 获取：作出行政处罚的日期
     */
    public Date getPunishmentDate() {
        return punishmentDate;
    }
    /**
     * 设置：行政处罚决定书（全文或摘要）
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 获取：行政处罚决定书（全文或摘要）
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：发布日期
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    /**
     * 获取：发布日期
     */
    public Date getIssueDate() {
        return issueDate;
    }
    /**
     * 设置：爬虫表数据记录id
     */
    public void setSpiderId(Long spiderId) {
        this.spiderId = spiderId;
    }
    /**
     * 获取：爬虫表数据记录id
     */
    public Long getSpiderId() {
        return spiderId;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * 获取：备注，若记录有变对应将原来的spiderid存入以便于追踪轨迹 如：123，345 由原来spider表的123，和345 两条更新过来这个记录对于表三条记录中spiderid对应最新的
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    /**
     * 获取：版本号
     */
    public Integer getVersion() {
        return version;
    }
    /**
     * 设置：数据状态
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }
    /**
     * 获取：数据状态
     */
    public Integer getDataStatus() {
        return dataStatus;
    }
}
