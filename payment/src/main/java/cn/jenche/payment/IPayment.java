package cn.jenche.payment;

import cn.jenche.payment.model.wechat.WechatMinUnifiedOrder;

import java.util.Map;

/**
 * @Author: lettger
 * @Date: 2020/7/25 1:47 下午
 */
public interface IPayment {


    /**
     * 微信小程序支付
     * @param wechatMinUnifiedOrder
     * @return
     */
    Map<String, String> minUnfiedOrder(WechatMinUnifiedOrder wechatMinUnifiedOrder);

//    Map<String,String> wechatQueryOrder();
}
