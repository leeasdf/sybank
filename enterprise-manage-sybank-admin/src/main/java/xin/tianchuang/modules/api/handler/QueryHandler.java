package xin.tianchuang.modules.api.handler;

import xin.tianchuang.modules.api.bean.api.tyc.BaseRespnseDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BaseApiRequestDTO;

/**
 * 
 * @author denghui
 * @param <T>
 *
 */
public interface QueryHandler<T> {

	public BaseRespnseDTO<T> parseData(BaseApiRequestDTO param, String apiData);


}
