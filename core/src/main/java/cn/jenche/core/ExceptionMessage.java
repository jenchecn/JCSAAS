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
    S_20_NOT_IMPLEMENT(20, "0000"),     //未知的错误
    S_20_DATA_NOTEXISTS(20, "0001"),    //数据不存在
    S_20_DELETE_ERROR(20, "0002"),      //删除数据出错
    S_20_FINDFIELD_ERROR(20, "0003"),   //
    S_20_DATA_EXISTS(20, "0004"),       //数据已经存在
    S_20_DELETE_EXISTS_PART(20, "0005"), //存在子数据不允许删除
    S_20_NOTEXISTS_ID(20, "0006"),       //Id不存在 ---所以不能更新数据，常规使用在更新上
    S_20_UPDATE_ERROR(20, "0007"),        //更新出错，这可能是新数据与旧数据冲突或者更新的Id不存在
    S_20_CLIENT_DISENABLE(20, "0008"),    //终端停用

    //50 发生在Controller层，一般为数据的DTO传输层，一般为数据的校验或者传输的参数异常
    C_50_DATA_IS_EMPTY(50, "0001"),      //返回的数据为空
    C_50_PARAMS_EXCPTION(50, "0009"),    //参数异常

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
