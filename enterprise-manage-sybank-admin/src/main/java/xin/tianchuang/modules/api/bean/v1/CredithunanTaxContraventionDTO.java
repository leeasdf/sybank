package xin.tianchuang.modules.api.bean.v1;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuzhengliang on 2018/11/1.
 */
public class CredithunanTaxContraventionDTO implements Serializable {
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
     * 社会信用统一代码
     */
    private String creditCode;
    /**
     * 注册地址
     */
    private String registerAddress;
    /**
     * 法定代表人
     */
    private String legal;
    /**
     * 身份证号
     */
    private String certificationNo;
    /**
     * 实施检查单位
     */
    private String checkUnit;
    /**
     * 公告日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date declarationDate;
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
     * 信息资源更新时间
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
     * 设置：社会信用统一代码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }
    /**
     * 获取：社会信用统一代码
     */
    public String getCreditCode() {
        return creditCode;
    }
    /**
     * 设置：注册地址
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
    /**
     * 获取：注册地址
     */
    public String getRegisterAddress() {
        return registerAddress;
    }
    /**
     * 设置：法定代表人
     */
    public void setLegal(String legal) {
        this.legal = legal;
    }
    /**
     * 获取：法定代表人
     */
    public String getLegal() {
        return legal;
    }
    /**
     * 设置：身份证号
     */
    public void setCertificationNo(String certificationNo) {
        this.certificationNo = certificationNo;
    }
    /**
     * 获取：身份证号
     */
    public String getCertificationNo() {
        return certificationNo;
    }
    /**
     * 设置：实施检查单位
     */
    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }
    /**
     * 获取：实施检查单位
     */
    public String getCheckUnit() {
        return checkUnit;
    }
    /**
     * 设置：公告日期
     */
    public void setDeclarationDate(Date declarationDate) {
        this.declarationDate = declarationDate;
    }
    /**
     * 获取：公告日期
     */
    public Date getDeclarationDate() {
        return declarationDate;
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
     * 设置：信息资源更新时间
     */
    public void setSourceTime(Date sourceTime) {
        this.sourceTime = sourceTime;
    }
    /**
     * 获取：信息资源更新时间
     */
    public Date getSourceTime() {
        return sourceTime;
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
