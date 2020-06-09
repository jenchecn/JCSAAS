package cn.jenche.saas.type;

import lombok.Getter;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/9 09:55
 * @Description: 管理员角色
 */
public enum AdminRule {
    ADMINISTRATOR(0, "高级管理员"),
    OPERATOR(1, "基本操作员"),
    MAINTAINER(100, "设备维护人员"),
    SERVICE(101, "设备运维人员");

    @Getter
    private final int code;

    @Getter
    private final String desc;

    AdminRule(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
