package cn.jenche.saas.type;

import lombok.Getter;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 13:40
 * @Description:
 */

public enum ClientCategoryType {
    V1(10, "普通槟榔机"),
    V2(20, "冷藏槟榔机");

    @Getter
    private final int code;

    @Getter
    private final String name;

    ClientCategoryType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
