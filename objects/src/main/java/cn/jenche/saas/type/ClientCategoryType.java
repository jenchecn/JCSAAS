package cn.jenche.saas.type;

import lombok.Getter;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 13:40
 * @Description:
 */

public enum ClientCategoryType {
    V1("1", "普通槟榔机"),
    V2("2", "冷藏槟榔机");

    @Getter
    private final String code;

    @Getter
    private final String desc;

    ClientCategoryType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
