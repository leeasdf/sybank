
package xin.tianchuang.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @author xx
 * @since 2.0.0
 */
public class MapUtils extends HashMap<String, Object> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1515480153589481768L;

	@Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
