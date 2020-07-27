package cn.jenche.payment.util.wechat;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

/**
 * 微信支付工具
 * 
 * @author lettger
 *
 */
public class WxSignUtil {
	//支付密钥

	/**
	 * sign签名
	 * 
	 * @param characterEncoding
	 * @param params
	 * @param API_KEY
	 * @return
	 */
	public static String createSign(String characterEncoding,String API_KEY, SortedMap<Object, Object> params) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<Object, Object>> es = params.entrySet();
		Iterator<Entry<Object, Object>> it = es.iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = (Entry<Object, Object>) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		/** 支付密钥必须参与加密，放在字符串最后面 */
		sb.append("key=" + API_KEY);
		/** 记得最后一定要转换为大写 */
		return MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
	}
}
