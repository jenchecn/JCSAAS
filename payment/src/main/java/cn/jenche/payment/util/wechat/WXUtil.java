package cn.jenche.payment.util.wechat;

import java.util.Random;

public class WXUtil {

	/**
	 * 获取32位随机字符串
	 * 
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}

	/**
	 * 时间戳
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

}
