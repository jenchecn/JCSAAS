package cn.jenche.payment.model.wechat;

/**
 * @Author: lettger
 * @Date: 2020/7/27 11:06 上午
 *  服务商基本信息
 */
public class WechatServiceProvider {

    /**
     * 服务商的APPID
     */
    private String appid;


    /**
     * 签名使用，服务商apiKey
     */
    private String api_key;

    /**
     * 商户号
     */
    private String mch_id;


    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
