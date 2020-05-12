package cn.jenche.core;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/12 12:17
 * @Description:
 */
public class SystemException extends Exception {


    public SystemException() {
        super();
    }

    /**
     * @param exceptionMessage 异常消息的枚举
     */
    public SystemException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMsg());
    }

    public SystemException(ExceptionMessage exceptionMessage, Throwable cause) {
        super(exceptionMessage.getMsg(), cause);
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
