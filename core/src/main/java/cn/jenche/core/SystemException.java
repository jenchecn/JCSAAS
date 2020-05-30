package cn.jenche.core;

import lombok.Getter;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/12 12:17
 * @Description:
 */
public class SystemException extends Exception {

    @Getter
    private int errCode = -1;

    public SystemException() {
        super();
    }

    /**
     * @param exceptionMessage 异常消息的枚举
     */
    public SystemException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMsg());
        this.errCode = exceptionMessage.getCode();
    }

    public SystemException(ExceptionMessage exceptionMessage, String message) {
        super(exceptionMessage.getMsg().concat(message));
        this.errCode = exceptionMessage.getCode();
    }

    public SystemException(ExceptionMessage exceptionMessage, Throwable cause) {
        super(exceptionMessage.getMsg(), cause);
        this.errCode = exceptionMessage.getCode();
    }

    public SystemException(String message) {
        super(message);
    }
}
