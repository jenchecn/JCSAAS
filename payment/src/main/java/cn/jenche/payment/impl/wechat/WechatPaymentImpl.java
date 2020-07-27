package cn.jenche.payment.impl.wechat;

import cn.jenche.payment.AbstractPayment;
import cn.jenche.payment.IPayment;
import cn.jenche.payment.constant.WechatConstant;
import cn.jenche.payment.model.wechat.WechatMinUnifiedOrder;
import cn.jenche.payment.util.wechat.HttpUtil;
import cn.jenche.payment.util.wechat.WXUtil;
import cn.jenche.payment.util.wechat.WxSignUtil;
import cn.jenche.payment.util.wechat.XMLUtil;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: lettger
 * @Date: 2020/7/25 4:03 下午
 */
public class WechatPaymentImpl extends AbstractPayment implements IPayment {


    /**
     * 调用统一下单接口
     * @param wechatMinUnifiedOrder
     * @return
     */
    @Override
    public Map<String, String> minUnfiedOrder(WechatMinUnifiedOrder wechatMinUnifiedOrder) {
        String requestXml =	createAppXml(wechatMinUnifiedOrder);
        if (requestXml != null) {
            String resultXml = HttpUtil.post(WechatConstant.UNIFIED_ORDER, requestXml);
            if(resultXml != null) {
                try {
                    return XMLUtil.doXMLParse(resultXml);
                } catch (JDOMException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 生成请求下单xml
     * @param wechatMinUnifiedOrder
     * @return
     */
    private String createAppXml(WechatMinUnifiedOrder wechatMinUnifiedOrder) {
        String requestXML = null;
        try {
            SortedMap<Object, Object> params = new TreeMap<Object, Object>();
            params.put("appid", wechatMinUnifiedOrder.getAppid());
            params.put("mch_id", wechatMinUnifiedOrder.getMch_id());
            params.put("sub_appid", wechatMinUnifiedOrder.getSub_appid());
            params.put("sub_mch_id", wechatMinUnifiedOrder.getSub_mch_id());
            params.put("nonce_str", WXUtil.getNonceStr());
            params.put("body", wechatMinUnifiedOrder.getBody());
            params.put("out_trade_no", wechatMinUnifiedOrder.getOutTradeNo());
            params.put("total_fee", wechatMinUnifiedOrder.getTotalFee());
            params.put("spbill_create_ip", wechatMinUnifiedOrder.getSpbill_create_ip());
            params.put("notify_url",wechatMinUnifiedOrder.getNotify_url());
            params.put("sub_openid", wechatMinUnifiedOrder.getSub_openid());
            params.put("trade_type", "JSAPI");
            String sign = WxSignUtil.createSign("UTF-8",wechatMinUnifiedOrder.getApi_key(), params);
            params.put("sign", sign);
            requestXML = XMLUtil.getRequestXml(params);
        } catch (Exception e) {
            requestXML = null;
        }
        return requestXML;
    }
}
