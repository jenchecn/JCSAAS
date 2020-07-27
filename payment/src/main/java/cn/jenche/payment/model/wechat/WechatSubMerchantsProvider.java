package cn.jenche.payment.model.wechat;

/**
 * @Author: lettger
 * @Date: 2020/7/27 11:11 上午
 * 子商户基本信息
 */
public class WechatSubMerchantsProvider extends WechatServiceProvider{

    /**
     * 小程序的APPID	不是必传
     */
    private String sub_appid;


    /**
     * 子商户号
     */
    private String sub_mch_id;

    /**
     * 用户子标识 必传字段
     */
    private String sub_openid;


    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }
}
