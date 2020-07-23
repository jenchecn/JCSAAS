package cn.jenche.saas.service;

import cn.jenche.core.Pager;
import cn.jenche.core.SystemException;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:29
 * @Description: 服务基础接口
 */
public interface IBaseService<E> {
    /**
     * 根据Id获取数据
     *
     * @param id Id
     * @return E
     * @throws SystemException 系统自定义异常
     */
    E ONE_BYID(String id) throws SystemException;

    /**
     * 获取所有终端数据
     *
     * @param pager 分页
     * @return 数据列表的分页形式
     * @throws SystemException 系统自定义异常
     */
    Pager<E> LIST_PAGES(Pager<E> pager) throws SystemException;

    /**
     * 保存
     *
     * @param entity 保存的实体 type is {@link E}
     * @return 保存后的数据{@link E}
     * @throws SystemException 系统自定义异常
     */
    E SAVE(E entity) throws SystemException;

    /**
     * 根据Id修改数据
     *
     * @param entity 保存的实体 type is {@link E}
     * @return 修改后的数据{@link E}
     * @throws SystemException 系统自定义异常
     */
    E UPDATE(E entity) throws SystemException;


    /**
     * 删除数据
     *
     * @param ids 需要删除数据的Id
     * @throws SystemException 系统自定义异常
     */
    void DELETE(Serializable... ids) throws SystemException;

    /**
     * 获取全部
     *
     * @return {@link List}
     */
    List<E> FINDALL();
}
