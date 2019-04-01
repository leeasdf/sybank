/**
 *
 */
package xin.tianchuang.common.utils.tcredit;

import java.util.Map;

public class SignUtil {
    /**
     * 签名算法
     *
     * @param appSecret
     *            客户密钥
     * @param params
     *            参数
     * @return
     */
    public static String signature(String appSecret, Map<String, String> params) {
        String paramStr = ParamUtil.sortMap(params);
        StringBuilder sb = new StringBuilder();
        sb.append(paramStr).append(appSecret);
        return MD5Util.md5(sb.toString());
    }

    public static String signature(String signStr) {
        return MD5Util.md5(signStr);
    }

	// public static void main(String[] args) {
	// System.out.println(signature("appKey=1234512345"));
	// }
}

