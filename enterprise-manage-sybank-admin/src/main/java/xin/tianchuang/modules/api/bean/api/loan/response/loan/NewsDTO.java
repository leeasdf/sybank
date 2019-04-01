package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yp-tc-m-7179 on 2019/3/7.
 */
@ApiModel(value = "企业-其它信息-新闻）")
public class NewsDTO {
    /**
     *
     */
    @ApiModelProperty(name = "title", value = "新闻标题")
    private String title;
    /**
     *
     */
    @ApiModelProperty(name = "url", value = "链接")
    private String url;
    /**
     *
     */
    @ApiModelProperty(name = "website", value = "来源")
    private String website;
    /**
     *
     */
    @ApiModelProperty(name = "time", value = "时间")
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
