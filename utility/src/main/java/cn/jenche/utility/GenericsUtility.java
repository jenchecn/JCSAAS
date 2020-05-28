package cn.jenche.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 16:57
 * @Description: 用于Class的工具，查找泛型中的方法或者字段
 */
public class GenericsUtility {
    private static GenericsUtility instance;

    public static GenericsUtility GetInstance() {
        if (instance == null) {
            instance = new GenericsUtility();
        }
        return instance;
    }

    /**
     * 查找实体或者类中的字段名找到数据
     *
     * @param t         实体或者类
     * @param fieldName 字段名称
     * @param <T>       实体或者类的类型
     * @return {@link Object}
     */
    public <T> Object findFieldBy(T t, String fieldName) {
        Field[] declaredFields = getAllFields(t);

        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                try {
                    field.setAccessible(true);
                    return field.get(t);
                } catch (IllegalAccessException e) {
                    return null;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private <E> Field[] getAllFields(E entity) {
        Class<E> clazz = (Class<E>) entity.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = (Class<E>) clazz.getSuperclass();
        }

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
