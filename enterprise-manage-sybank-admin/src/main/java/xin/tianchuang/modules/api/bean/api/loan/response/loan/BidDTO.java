package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-其它信息-招投标）")
public class BidDTO {

    /**
     *
     */
    @ApiModelProperty(name = "purchaser", value = "采购人")
    private String purchaser;
    /**
     *
     */
    @ApiModelProperty(name = "publishTime", value = "发布时间")
    private String publishTime;
    /**
     *
     */
    @ApiModelProperty(name = "link", value = "详细信息链接")
    private String link;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "pid", value = "id")
//    private String pid;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "searchType", value = "无用")
//    private String searchType;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "uni", value = "无用")
//    private String uni;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "bidUrl", value = "天眼查链接")
//    private String bidUrl;
    /**
     *
     */
    @ApiModelProperty(name = "intro", value = "正文简介")
    private String intro;
    /**
     *
     */
    @ApiModelProperty(name = "content", value = "正文信息")
    private String content;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "uniqueHash", value = "无用")
//    private String uniqueHash;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "tableId", value = "id")
//    private String tableId;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "type", value = "无用")
//    private String type;
    /**
     *
     */
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "recordHash", value = "无用")
//    private String recordHash;
    /**
     *
     */
    @ApiModelProperty(name = "abs", value = "摘要信息")
    private String abs;
    /**
     *
     */
    @ApiModelProperty(name = "connList", value = "公司列表")
    private String connList;
    /**
     *
     */
    @ApiModelProperty(name = "proxy", value = "代理机构")
    private String proxy;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "eventTime", value = "无用")
//    private String eventTime;
//    /**
//     *
//     */
//    @ApiModelProperty(name = "uuid", value = "登记日期")
//    private String uuid;


    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getConnList() {
        return connList;
    }

    public void setConnList(String connList) {
        this.connList = connList;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }
}
