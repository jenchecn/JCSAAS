package cn.jenche.payment.model.wechat;

/**
 * @Author: lettger
 * @Date: 2020/7/27 11:15 上午
 * 微信小程序统一下单参数
 */
public class WechatMinUnifiedOrder extends WechatSubMerchantsProvider {

    /**
     * 终端IP
     */
    private String spbill_create_ip;

    /**
     * 通知地址
     */
    private String notify_url;

    /**
     * 交易类型
     */
    private String trade_type;


    /**
     * 商品描述
     */
    private String body;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 总金额
     */
    private int totalFee;

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }


}
