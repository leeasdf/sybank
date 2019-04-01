package xin.tianchuang.modules.api.service;

import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestHeadParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;

public interface TycApiService<T> {

	public <K> T queryApi(BizRequestParamDTO param, BizRequestHeadParamDTO head, Class<T> cls) throws Exception;

}
