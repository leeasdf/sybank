package xin.tianchuang.common.utils.tcredit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

/**
 * API参数管理工具
 * 
 * @author lei.sun-1
 * @date 2016年4月18日
 */
public class ParamUtil {

	/**
	 * 生成参数字符串，参数key按字典序排列
	 * 
	 * @param param
	 *            参数
	 * @return
	 */
	public static String sortParam(Map<String, String> param) {
		if (null == param || 0 == param.size()) {
			return "";
		}
		// 排序键
		Iterator<String> iterator = param.keySet().iterator();
		String[] arr = new String[param.size()];
		for (int i = 0; iterator.hasNext(); i++) {
			arr[i] = iterator.next();
		}
		Arrays.sort(arr);
		// 生成字符串
		StringBuffer sb = new StringBuffer();
		for (String key : arr) {
			String value = param.get(key);
			if (StringUtils.isNotBlank(value)) {
				sb.append(key).append("=").append(value).append(",");
			}
		}
		// 检查结果
		if (sb.length() > 0) {
			return sb.substring(0, sb.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * 获取请求IP
	 * 
	 * @param request
	 *            请求
	 * @return
	 */
	public static String getSourceIp(HttpServletRequest request) {
		String fromSource = "X-Real-IP";
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
			fromSource = "X-Forwarded-For";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			fromSource = "Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			fromSource = "WL-Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			fromSource = "request.getRemoteAddr";
		}
		return String.format("%s:%s", fromSource, ip);
	}

	/**
	 * 生成TokenKey
	 * 
	 * @param url
	 *            地址
	 * @param tokenId
	 *            客户REST代码
	 * @param param
	 *            参数
	 * @return
	 */
	public static String getTokenKey(String url, String tokenId, Map<String, String> param) {
		String paramStr = ParamUtil.sortParam(param);
		return MD5Util.md5(url + tokenId + paramStr);
	}

	/**
	 * 若参数不为空，则添加到参数列表中
	 * 
	 * @param param
	 *            参数列表
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public static void addParam(Map<String, String> param, String key, String value) {
		if (null != param && StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
			param.put(key, value.trim());
		}
	}

	/**
	 * 将模糊查询的字段添加上%
	 * 
	 * @param key
	 * @return
	 */
	public static String fuzzySearch(String key) {
		return StringUtils.isBlank(key) ? null : "%" + key + "%";
	}

	public static String tranStr(String str) {
		return StringUtils.isBlank(str) ? null : str;
	}

	/**
	 * 格式化参数，按key按字典序排列并以&隔开，生成形如key1=value1&key2=value2...的字符串
	 *
	 * @param params
	 *            参数map
	 * @return
	 */
	public static String sortMap(Map<String, String> params) {
		if (null == params || params.size() == 0) {
			return ""; // 参数map为空时返回空串
		}

		// 按key排序
		StringBuffer sb = new StringBuffer();
		Map<String, String> sortMap = new TreeMap<String, String>(new Comparator<String>() {
			// 实现比较器
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		});
		sortMap.putAll(params);
		for (Map.Entry<String, String> entry : sortMap.entrySet()) {
			if (entry.getKey() != null && entry.getKey().trim().length() != 0 && entry.getValue() != null && entry.getValue().trim().length() != 0) {
				sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
			}
		}

		// 返回结果字符串
		if (sb.length() > 1) {
			return sb.substring(1);
		} else {
			return "";
		}
	}

	/**
	 * 转换参数map
	 *
	 * @param map
	 * @return
	 */
	public static Map<String, String> convertMap(Map<String, String[]> map) {
		Map<String, String> params = Maps.newHashMap();;
		if (map != null && map.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String[]> entity : map.entrySet()) {
				String key = entity.getKey();
				String[] arr = entity.getValue();
				String value = "";
				if (arr != null && arr.length > 0) {
					sb.delete(0, sb.length());
					// 将字符串数组转为字符串，中间以逗号隔开
					for (String item : arr) {
						sb.append(",").append(item);
					}
					if (sb.length() > 0) {
						value = sb.substring(1);
						params.put(key, value);
					}
				}
			}
		}
		return params;
	}
}
