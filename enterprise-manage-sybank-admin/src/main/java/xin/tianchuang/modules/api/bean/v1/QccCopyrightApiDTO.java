package xin.tianchuang.modules.api.bean.v1;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lee on 2018/12/20.
 */
public class QccCopyrightApiDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 分类号
     */
    private String category;
    /**
     * 发布日期
     */

    private Date publishDate;
    /**
     * 版本号
     */

    private Integer versionNo;
    /**
     * 登记号
     */

    private String registerNo;
    /**
     * 登记批准日期
     */

    private Date registerAperDate;
    /**
     * 软件全称
     */

    private String name;
    /**
     * 软件简称
     */

    private String shortName;
    /**
     * 软件著作权人
     */

    private String owner;
    /**
     * 关键字(公司名或keyNo)
     */
    private String entName;
    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 设置：分类号
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * 获取：分类号
     */
    public String getCategory() {
        return category;
    }
    /**
     * 设置：发布日期
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    /**
     * 获取：发布日期
     */
    public Date getPublishDate() {
        return publishDate;
    }
    /**
     * 设置：版本号
     */
    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }
    /**
     * 获取：版本号
     */
    public Integer getVersionNo() {
        return versionNo;
    }
    /**
     * 设置：登记号
     */

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }
    /**
     * 获取：登记号
     */
    public String getRegisterNo() {
        return registerNo;
    }
    /**
     * 设置：登记批准日期
     */
    public void setRegisterAperDate(Date registerAperDate) {
        this.registerAperDate = registerAperDate;
    }
    /**
     * 获取：登记批准日期
     */
    public Date getRegisterAperDate() {
        return registerAperDate;
    }
    /**
     * 设置：软件全称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取：软件全称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：软件简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
     * 获取：软件简称
     */
    public String getShortName() {
        return shortName;
    }
    /**
     * 设置：软件著作权人
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * 获取：软件著作权人
     */
    public String getOwner() {
        return owner;
    }
    /**
     * 设置：关键字(公司名或keyNo)
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }
    /**
     * 获取：关键字(公司名或keyNo)
     */
    public String getEntName() {
        return entName;
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

}
