package cn.jenche.utility;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/7/24 15:02
 * @Description:
 */
public class CalculateUtility {
    /**
     * 根据折扣计算销售价格
     *
     * @param price    原价
     * @param discount 折扣
     * @return {@link Double}
     */
    public static double goodsOfPrice(double price, int discount) {
        double dis = 100.00 - discount;

        double pr = 0.00;
        if (dis > 0) {
            pr = price * (dis / 100);
            return pr;
        }

        return pr;
    }
}
