package cn.jenche.core;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/21 15:28
 * @Description: 分页
 */
@Data
public class Pager<T> {
    public Pager() {
    }

    /**
     * @param pageNo   页码
     * @param pageSize 页面大小
     */
    public Pager(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * @param pageNo         页码
     * @param pageSize       页面大小
     * @param totalPagesSize 总页数
     * @param totalRecord    总记录数
     */
    public Pager(int pageNo, int pageSize, int totalPagesSize, long totalRecord) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPagesSize = totalPagesSize;
        this.totalRecord = totalRecord;
    }

    public Pageable getPageable() {
        return sort == null ? PageRequest.of(pageNo - 1, pageSize) : PageRequest.of(pageNo - 1, pageSize, sort);
    }

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 页面大小
     */
    private int pageSize = 20;

    /**
     * 总页数
     */
    private int totalPagesSize = 0;

    /**
     * 总记录数
     */
    private long totalRecord = 0;

    /**
     * Sort
     */
    private Sort sort;

    /**
     * 记录数据
     */
    private List<T> recordData = null;

    /**
     * 将spring的Page数据转换成自定义的Pager
     *
     * @param data 需要转换的数据{@link Page<T>}
     * @return {@link Pager<T>}
     */
    public Pager<T> convert(Page<T> data) {
        int pageNumber = data.getNumber() + 1;
        Pager<T> pager = new Pager<T>(pageNumber, data.getSize(), data.getTotalPages(), data.getTotalElements());
        pager.setRecordData(data.getContent());
        return pager;
    }
}
