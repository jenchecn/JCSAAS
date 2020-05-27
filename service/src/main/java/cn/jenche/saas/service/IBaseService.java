package cn.jenche.saas.service;

import cn.jenche.core.Pager;
import cn.jenche.core.SystemException;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:29
 * @Description:
 */
public interface IBaseService<E> {
    /**
     * 根据Id获取数据
     *
     * @param id Id
     * @return E
     */
    E ONE_BYID(String id);

    /**
     * 获取所有终端数据
     *
     * @param pager 分页
     * @return 数据列表的分页形式
     */
    Pager<E> LIST_PAGES(Pager<E> pager);

    /**
     * 保存
     *
     * @param entity 保存的实体 type is {@link E}
     * @return 保存后的数据{@link E}
     */
    E SAVE(E entity);

    /**
     * 根据Id修改数据
     *
     * @param entity 保存的实体 type is {@link E}
     * @return 修改后的数据{@link E}
     */
    E UPDATE(E entity) throws SystemException;

    /**
     * 删除数据
     *
     * @param id 需要删除数据的Id
     */
    void DELETE(String id) throws SystemException;
}
