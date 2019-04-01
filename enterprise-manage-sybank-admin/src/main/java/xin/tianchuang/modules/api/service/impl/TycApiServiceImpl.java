package xin.tianchuang.modules.api.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestHeadParamDTO;
import xin.tianchuang.modules.api.bean.api.tyc.request.BizRequestParamDTO;
import xin.tianchuang.modules.api.service.TycApiService;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

@Component
public class TycApiServiceImpl<T> implements TycApiService<Object> {

	@Override
	public <K> Object queryApi(BizRequestParamDTO param, BizRequestHeadParamDTO head, Class<Object> cls) throws Exception {
		String token = head.getToken();
		Connection connect = Jsoup.connect(head.getUrl());
		connect.header("Authorization", token);
		Map<String, String> beanToMap = Maps.newHashMap();;
		if (null != param.getName()) {
			beanToMap.put("name", param.getName());
		}
		if (null != param.getCompanyId()) {
			beanToMap.put("id", "" + param.getCompanyId());
		}

		if (null != param.getPageNum()) {
			beanToMap.put("pageNum", "" + param.getPageNum());
		}
		if (null != param.getPageSize()) {
			beanToMap.put("pageSize", "" + param.getPageSize());
		}

		if (null == beanToMap || beanToMap.size() <= 0) {
			// TODO 自定义异常
			throw new Exception("请求参数不能为空");
		}
		Response execute = connect.ignoreContentType(true).method(Method.GET).data(beanToMap).execute();
		String body = execute.body();
		if (StringUtils.isBlank(body)) {
			// TODO 自定义异常
			throw new Exception("");
		}
		// TODO 是否考虑重试
		return JSON.parseObject(body, cls);

	}

}
