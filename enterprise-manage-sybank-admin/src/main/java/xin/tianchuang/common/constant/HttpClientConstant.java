/**
 * 
 */
package xin.tianchuang.common.constant;


/**
 * httpClient请求常量
 * @author denghui
 *
 */
public final class HttpClientConstant {

	public final static String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
	
	public final static String ACCEPT_ENCODING = "gzip, deflate";
	
	public final static String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.8";
	
	/**
	 * google
	 */
	public final static String USER_AGENT_GOOGLE = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.10";
	
	/**
	 * firefox
	 */
	public final static String USER_AGENT_FIREFOX = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0";
	
	public final static String CONTENT_LENGTH  = "90";
	/**
	 * 请求超时时间
	 */
	public final static Integer CONNECTION_TIMEOUT = 12 *1000; //设置请求超时时间
	
	public final static Integer SOCKET_TIMEOUT = 60 *1000; //设置请求超时时间
	
	public final static Integer CONNECTION_REQUEST_TIMEOUT = 60 *1000; //设置请求超时时间
	
	/**
	 * 等待超时时间
	 */
	public final static Integer WAIT_TIMEROUT = 2 * 1000;
	
	public final static Long CONN_MANAGER_TIMEOUT  = 500L;
}
