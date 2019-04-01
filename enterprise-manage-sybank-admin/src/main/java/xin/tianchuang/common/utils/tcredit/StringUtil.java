package xin.tianchuang.common.utils.tcredit;

import java.util.Random;

/**
 * 
 * @author chenguang.li
 * @date 2016年4月28日下午1:28:39
 *
 *       com.yeepay.credit.api.core.util
 */
public class StringUtil {
	/**
	 * <p>
	 * 全角字符转半角字符
	 * 
	 * @param src
	 * @return
	 * @date 2016年4月28日
	 */
	public static String sbc2Dbc(String src) {
		if (src == null) {
			return src;
		}
		StringBuilder buf = new StringBuilder(src.length());
		char[] ca = src.toCharArray();
		for (int i = 0; i < src.length(); i++) {
			if (ca[i] >= 65281 && ca[i] <= 65374) { // 如果位于全角！到全角～区间内
				buf.append((char) (ca[i] - 65248));
			} else if (ca[i] == 12288) { // 如果是全角空格
				buf.append(' ');
			} else { // 不处理全角空格，全角！到全角～区间外的字符
				buf.append(ca[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * <p>
	 * 半角字符转全角字符
	 * 
	 * @param src
	 * @return
	 * @date 2016年4月28日
	 */
	public static String dbc2Sbc(String src) {
		if (src == null) {
			return src;
		}
		StringBuilder buf = new StringBuilder(src.length());
		char[] ca = src.toCharArray();
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] == ' ') { // 如果是半角空格，直接用全角空格替代
				buf.append(12288);
			} else if ((ca[i] >= 33) && (ca[i] <= 126)) { // 字符是!到~之间的可见字符
				buf.append((char) (ca[i] + 65248));
			} else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理
				buf.append(ca[i]);
			}
		}
		return buf.toString();
	}
	
	public static String generateIp() {
		Random r = new Random();
		return r.nextInt(254) + "." + r.nextInt(254) + "." + r.nextInt(254)
				+ "." + r.nextInt(254);
	}
	
	public static void main(String[] args) {
		System.out.println(sbc2Dbc("，"));
	}

	/**
	 * 首字母变小写
	 * @param str
	 * @return
	 */
	public static String lowCaseFirstChar(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);

	}

	/**
	 * 首字母变大写
	 * @param str
	 * @return
	 */
	public static String UpCaseFirstChar(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);

	}
}
