package xin.tianchuang.common.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class BaseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1499177556300303612L;

	/**
	 * 重写toString使更容易查看对象的属性值
	 */
	@Override
	public String toString() {
		try {
			return JSON.toJSONString(this);
		} catch (Exception e) {
			return super.toString();
		}
	}
}
