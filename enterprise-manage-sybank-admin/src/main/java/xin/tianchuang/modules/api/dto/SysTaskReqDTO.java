package xin.tianchuang.modules.api.dto;

import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;

/**
 * Created by lee on 2019/3/9.
 */
public class SysTaskReqDTO extends BaseApiRequestDTO {

    private Integer entId;

    private boolean retry;

    private ApiLogEntity  apiLogEntity;


    public ApiLogEntity getApiLogEntity() {
        return apiLogEntity;
    }

    public void setApiLogEntity(ApiLogEntity apiLogEntity) {
        this.apiLogEntity = apiLogEntity;
    }

    public boolean getRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }
}
