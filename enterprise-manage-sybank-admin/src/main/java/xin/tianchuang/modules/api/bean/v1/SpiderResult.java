package xin.tianchuang.modules.api.bean.v1;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpiderResult {
	// 爬虫名称
//	private String crawlName;
	// 爬取状态
	private int status;
	//爬虫机器
//	private String hostname;
	private Exception  exception;
	private String exceptioninfo;
	private String queueName;

	// 爬取时间
	private String spiderTime;
	// 爬取内容
	private String result;
	//任务源
	private String task;
	// 本条是否过滤掉，false保存，true不保存
	private boolean skip = false;
	// 扩展参数
	private Map<String, Object> extend = new LinkedHashMap<String, Object>();

	public void putExtend(String key, Object value) {
		extend.put(key, value);
	}

	public String getExceptioninfo() {
		return exceptioninfo;
	}

	public void setExceptioninfo(String exceptioninfo) {
		this.exceptioninfo = exceptioninfo;
	}

	public Exception  getException() {
		return exception;
	}

	public void setException(Exception  exception) {
		this.exception = exception;
	}

	public Object getExtend(String key) {
		Object o = extend.get(key);
		if (o == null) {
			return null;
		}
		return extend.get(key);
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void removeExtend(String key) {
		extend.remove(key);
	}

//	public String getCrawlName() {
//		return crawlName;
//	}
//
//	public void setCrawlName(String crawlName) {
//		this.crawlName = crawlName;
//	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSpiderTime() {
		return spiderTime;
	}

	public void setSpiderTime(String spiderTime) {
		this.spiderTime = spiderTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

//	public String getHostname() {
//		return hostname;
//	}
//
//	public void setHostname(String hostname) {
//		this.hostname = hostname;
//	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}
