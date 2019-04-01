package xin.tianchuang.modules.api.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;
import xin.tianchuang.modules.api.handler.QueryHandler;

/**
 * Created by yp-tc-m-7179 on 2019/3/11.
 * @param <T>
 */
@Component
public class TranMidWareComponent<T> {

    @Transactional(rollbackFor = Exception.class)
    public <K> BaseRespnseDTO<K> transactionParse(QueryHandler<K> handler, BaseApiRequestDTO param, String apiData){
        return handler.parseData(param,apiData);
    }
}
