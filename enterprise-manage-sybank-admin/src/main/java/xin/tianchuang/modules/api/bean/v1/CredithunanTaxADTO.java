package xin.tianchuang.modules.api.bean.v1;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
public class CredithunanTaxADTO implements Serializable {

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
     * 纳税人识别号
     */
    private String taxpayerNo;
    /**
     * 组织机构代码
     */
    private String orgCode;
    /**
     * 负责人
     */
    private String responsiblePerson;
    /**
     * 主管税务机关
     */
    private String taxAuthorities;
    /**
     * 信用等级
     */
    private String creditLevel;
    /**
     * 评价年度
     */
    private String year;
    /**
     * 税务类型：国税/地税
     */
    private String taxType;
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
     * 信息资源更新时间(网站更新 表头)
     */
    private Date sourceTime;
    /**
     * 更新时间(信用等级 表中)
     */
    private Date taxUpdateTime;
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
     * 设置：纳税人名称
     */
    public void setTaxpayer(String taxpayer) {
        this.taxpayer = taxpayer;
    }
    /**
     * 获取：纳税人名称
     */
    public String getTaxpayer() {
        return taxpayer;
    }
    /**
     * 设置：纳税人识别号
     */
    public void setTaxpayerNo(String taxpayerNo) {
        this.taxpayerNo = taxpayerNo;
    }
    /**
     * 获取：纳税人识别号
     */
    public String getTaxpayerNo() {
        return taxpayerNo;
    }
    /**
     * 设置：组织机构代码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    /**
     * 获取：组织机构代码
     */
    public String getOrgCode() {
        return orgCode;
    }
    /**
     * 设置：负责人
     */
    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }
    /**
     * 获取：负责人
     */
    public String getResponsiblePerson() {
        return responsiblePerson;
    }
    /**
     * 设置：主管税务机关
     */
    public void setTaxAuthorities(String taxAuthorities) {
        this.taxAuthorities = taxAuthorities;
    }
    /**
     * 获取：主管税务机关
     */
    public String getTaxAuthorities() {
        return taxAuthorities;
    }
    /**
     * 设置：信用等级
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }
    /**
     * 获取：信用等级
     */
    public String getCreditLevel() {
        return creditLevel;
    }
    /**
     * 设置：评价年度
     */
    public void setYear(String year) {
        this.year = year;
    }
    /**
     * 获取：评价年度
     */
    public String getYear() {
        return year;
    }
    /**
     * 设置：税务类型：国税/地税
     */
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
    /**
     * 获取：税务类型：国税/地税
     */
    public String getTaxType() {
        return taxType;
    }
    /**
     * 设置：信息名称
     */
    public void setInfomationName(String infomationName) {
        this.infomationName = infomationName;
    }
    /**
     * 获取：信息名称
     */
    public String getInfomationName() {
        return infomationName;
    }
    /**
     * 设置：数据来源
     */
    public void setSource(String source) {
        this.source = source;
    }
    /**
     * 获取：数据来源
     */
    public String getSource() {
        return source;
    }
    /**
     * 设置：信息类型
     */
    public void setInfomationType(String infomationType) {
        this.infomationType = infomationType;
    }
    /**
     * 获取：信息类型
     */
    public String getInfomationType() {
        return infomationType;
    }
    /**
     * 设置：信息资源更新时间(网站更新 表头)
     */
    public void setSourceTime(Date sourceTime) {
        this.sourceTime = sourceTime;
    }
    /**
     * 获取：信息资源更新时间(网站更新 表头)
     */
    public Date getSourceTime() {
        return sourceTime;
    }
    /**
     * 设置：更新时间(信用等级 表中)
     */
    public void setTaxUpdateTime(Date taxUpdateTime) {
        this.taxUpdateTime = taxUpdateTime;
    }
    /**
     * 获取：更新时间(信用等级 表中)
     */
    public Date getTaxUpdateTime() {
        return taxUpdateTime;
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
