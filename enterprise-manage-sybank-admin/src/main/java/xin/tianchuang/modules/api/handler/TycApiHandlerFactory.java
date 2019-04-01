package xin.tianchuang.modules.api.handler;

import java.util.Map;

import xin.tianchuang.common.enums.TycInterfaceTypeEnum;

/**
 * 
 * @author denghui
 * @param <T>
 *
 */
public class TycApiHandlerFactory<T> {

	/**
	 * 处理器
	 */
	private Map<String, QueryHandler<T>> queryHandlers;

	public QueryHandler<T> create(TycInterfaceTypeEnum interfaceType) {
		return queryHandlers.get(interfaceType.key());
	}

	public Map<String, QueryHandler<T>> getQueryHandlers() {
		return queryHandlers;
	}

	public void setQueryHandlers(Map<String, QueryHandler<T>> queryHandlers) {
		this.queryHandlers = queryHandlers;
	}

}
