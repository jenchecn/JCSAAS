package cn.jenche.saas.api;

import cn.jenche.core.Pager;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/29 11:12
 * @Description: 这个方法是用来通过反射返回结果
 */
public class BaseExtension<E, T> {

    private final T t;

    public BaseExtension(T t) {
        this.t = t;
    }

    /**
     * 获取方法{@link Method}
     *
     * @param methodName 方法名
     * @param aClass     参数类型
     * @return {@link Method}
     */
    public Method getMethod(String methodName, Class<? extends Pager> aClass) {
        return ReflectionUtils.findMethod(t.getClass(), methodName, aClass);
    }

    /**
     * 通过反射获取List数据
     *
     * @param pager      分页
     * @param methodName 方法名
     * @return {@link Pager<E>}
     */
    @SuppressWarnings(value = "unchecked")
    public Pager<E> list(Pager<E> pager, String methodName) {
        return (Pager<E>) ReflectionUtils.invokeMethod(getMethod(methodName, pager.getClass()), t, pager);
    }
}
