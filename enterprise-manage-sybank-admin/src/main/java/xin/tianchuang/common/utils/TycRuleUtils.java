package xin.tianchuang.common.utils;

public final class TycRuleUtils {
	// public static String getAmount(String amount) {
	// return StringUtils.isNotBlank(amount) ? amount.replace("人民币", "").replace("万元", "").replace("万", "").replace(" ",
	// "") : null;
	// }

	public static String getArea(String address) {
		String area = "";
		if (address.indexOf("裴圩") != -1) {
			area = "裴圩镇";
		} else if (address.indexOf("高渡") != -1) {
			area = "高渡镇";
		} else if (address.indexOf("新袁") != -1) {
			area = "新袁镇";
		} else if (address.indexOf("李口") != -1) {
			area = "李口镇";
		} else if (address.indexOf("黄圩") != -1) {
			area = "黄圩乡";
		} else if (address.indexOf("来安") != -1) {
			area = "来安街道";
		} else if (address.indexOf("卢集") != -1) {
			area = "卢集镇";
		} else if (address.indexOf("城厢") != -1) {
			area = "城厢街道";
		} else if (address.indexOf("临河") != -1) {
			area = "临河镇";
		} else if (address.indexOf("大兴") != -1) {
			area = "大兴村";
		} else if (address.indexOf("城南") != -1) {
			area = "城南新城";
		} else if (address.indexOf("庄圩") != -1) {
			area = "庄圩乡";
		} else if (address.indexOf("里仁") != -1) {
			area = "里仁乡";
		} else if (address.indexOf("爱园") != -1) {
			area = "爱园镇";
		} else if (address.indexOf("王集") != -1) {
			area = "王集新城";
		} else if (address.indexOf("魏圩") != -1) {
			area = "魏圩村";
		} else if (address.indexOf("八集") != -1) {
			area = "八集乡";
		} else if (address.indexOf("穿城") != -1) {
			area = "穿城村";
		} else if (address.indexOf("三庄") != -1) {
			area = "三庄乡";
		} else if (address.indexOf("张家圩") != -1) {
			area = "张家圩镇";
		} else if (address.indexOf("南刘集") != -1) {
			area = "南刘集乡";
		} else if (address.indexOf("史集") != -1) {
			area = "史集街道";
		} else if (address.indexOf("经济开发区") != -1 || address.indexOf("桃源") != -1 || address.indexOf("众兴") != -1 || address.indexOf("城西") != -1 || address.indexOf("西康") != -1) {
			area = "县城";
		} else {
			area = "全部";
		}

		return area;
	}

}
