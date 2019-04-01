package xin.tianchuang.modules.api.bean.v1;

import com.baomidou.mybatisplus.annotations.TableId;

/**
 * Created by yp-tc-m-7179 on 2018/12/24.
 */
public class QccPatentApiDTO {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 企业名称
     */
    private String entName;
    /**
     * 信用代码
     */
    private String creditCode;
    /**
     * 文档类型
     */
    private String documentTypes;
    /**
     * 代理人
     */
    private String agent;
    /**
     * 法律状态日期
     */
    private String legalStatusDate;
    /**
     * 审查官
     */
    private String primaryExaminer;
    /**
     * 助理审查官
     */
    private String assiantExaminer;
    /**
     * 引用
     */
    private String cites;
    /**
     * 其他参考文献
     */
    private String otherReferences;
    /**
     * 专利图片
     */
    private String patentImage;
    /**
     * 国际专利分类号（IPC）
     */
    private String ipcList;
    /**
     * 申请号
     */
    private String applicationNumber;
    /**
     * 申请日
     */
    private String applicationDate;
    /**
     * 公开（公告）号
     */
    private String publicationNumber;
    /**
     * 公开（公告）日
     */
    private String publicationDate;
    /**
     * 法律状态详情
     */
    private String legalStatusDesc;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要介绍
     */
    private String abstractText;
    /**
     * 专利代理机构
     */
    private String agency;
    /**
     * 类型名称
     */
    private String kindCodeDesc;
    /**
     * 国际专利分类详情
     */
    private String ipcDesc;
    /**
     * 发明人
     */
    private String inventorStringList;
    /**
     * 申请人
     */
    private String assigneestringList;
    /**
     * 法律状态历史记录
     */
    private String patentLegalHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(String documentTypes) {
        this.documentTypes = documentTypes;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getLegalStatusDate() {
        return legalStatusDate;
    }

    public void setLegalStatusDate(String legalStatusDate) {
        this.legalStatusDate = legalStatusDate;
    }

    public String getPrimaryExaminer() {
        return primaryExaminer;
    }

    public void setPrimaryExaminer(String primaryExaminer) {
        this.primaryExaminer = primaryExaminer;
    }

    public String getAssiantExaminer() {
        return assiantExaminer;
    }

    public void setAssiantExaminer(String assiantExaminer) {
        this.assiantExaminer = assiantExaminer;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getOtherReferences() {
        return otherReferences;
    }

    public void setOtherReferences(String otherReferences) {
        this.otherReferences = otherReferences;
    }

    public String getPatentImage() {
        return patentImage;
    }

    public void setPatentImage(String patentImage) {
        this.patentImage = patentImage;
    }

    public String getIpcList() {
        return ipcList;
    }

    public void setIpcList(String ipcList) {
        this.ipcList = ipcList;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLegalStatusDesc() {
        return legalStatusDesc;
    }

    public void setLegalStatusDesc(String legalStatusDesc) {
        this.legalStatusDesc = legalStatusDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getKindCodeDesc() {
        return kindCodeDesc;
    }

    public void setKindCodeDesc(String kindCodeDesc) {
        this.kindCodeDesc = kindCodeDesc;
    }

    public String getIpcDesc() {
        return ipcDesc;
    }

    public void setIpcDesc(String ipcDesc) {
        this.ipcDesc = ipcDesc;
    }

    public String getInventorStringList() {
        return inventorStringList;
    }

    public void setInventorStringList(String inventorStringList) {
        this.inventorStringList = inventorStringList;
    }

    public String getAssigneestringList() {
        return assigneestringList;
    }

    public void setAssigneestringList(String assigneestringList) {
        this.assigneestringList = assigneestringList;
    }

    public String getPatentLegalHistory() {
        return patentLegalHistory;
    }

    public void setPatentLegalHistory(String patentLegalHistory) {
        this.patentLegalHistory = patentLegalHistory;
    }
}
