package xin.tianchuang.common.exception;

/**
 * 自定义Api异常
 * 
 * @author hui.deng
 * 
 * @date 2016年10月27日 下午10:11:27
 */
public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public ApiException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public ApiException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public ApiException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public ApiException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
