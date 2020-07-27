package cn.jenche.payment;

import cn.jenche.payment.model.wechat.WechatMinUnifiedOrder;

import java.util.Map;

/**
 * @Author: lettger
 * @Date: 2020/7/25 4:02 下午
 */
public abstract class AbstractPayment implements IPayment {

    @Override
    public Map<String, String> minUnfiedOrder(WechatMinUnifiedOrder wechatMinUnifiedOrder) {
        return null;
    }
}
