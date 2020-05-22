package cn.jenche.core;

import lombok.Getter;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/12 12:19
 * @Description: 系统异常消息定义，此处只定义了异常的代码，在自定义的系统异常中定义了异常值
 */
public enum ExceptionMessage {
    //起始两位数定义为异常发生的位置
    //10 发生在Dao层，一般为数据库操作出现的异常

    //20 发生在service层，一般为业务逻辑出现的异常
    DATA_NOTEXISTS(20, "0001"),
    DELETE_ERROR(20, "0002"),
    ;

    @Getter
    int code = 0;
    @Getter
    String msg = "";

    ExceptionMessage(int exType, String exCode) {
        String _code = String.valueOf(exType).concat(exCode);
        this.msg = LocalI18nResources.getInstance().getMessage(_code);
        this.code = Integer.parseInt(_code);
    }
}