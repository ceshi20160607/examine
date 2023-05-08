package com.unique.core.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unique.core.config.SaTokenConfigure;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认分页
 * @author UNIQUE
 * @date 2023/3/25
 */
public class BasePage<T> implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    private List<T> list = new ArrayList<>();
    /**
     * 总数
     */
    private long totalRow = 0;

    /**
     * 每页显示条数，默认 15
     */
    private long pageSize = 15;

    /**
     * 当前页
     */
    private long pageNumber = 1;

    /**
     * 排序字段信息
     */
    private final List<OrderItem> orders = new ArrayList<>();


    /**
     * 额外数据
     */
    private Object extraData;

    public BasePage() {

    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public BasePage(long current, long size) {
        this(current, size, 0);
    }


    public BasePage(long current, long size, long total) {
        if (current > 1) {
            this.pageNumber = current;
        }
        this.pageSize = size;
        this.totalRow = total;
    }


    @Override
    @JsonIgnore
    public List<T> getRecords() {
        return this.list;
    }

    public List<T> getList() {
        return this.list;
    }

    @JsonSerialize(using = SaTokenConfigure.NumberSerializer.class)
    public Long getTotalRow() {
        return this.totalRow;
    }

    @JsonSerialize(using = SaTokenConfigure.NumberSerializer.class)
    public Long getTotalPage() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    @JsonSerialize(using = SaTokenConfigure.NumberSerializer.class)
    public Long getPageSize() {
        return this.pageSize;
    }

    @JsonSerialize(using = SaTokenConfigure.NumberSerializer.class)
    public Long getPageNumber() {
        return this.pageNumber;
    }


    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public List<OrderItem> orders() {
        return orders;
    }

    @Override
    public BasePage<T> setRecords(List<T> records) {
        this.list = records;
        return this;
    }

    @Override
    @JsonIgnore
    public long getTotal() {
        return this.totalRow;
    }

    @Override
    public BasePage<T> setTotal(long total) {
        this.totalRow = total;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public BasePage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.pageNumber;
    }

    @Override
    public BasePage<T> setCurrent(long current) {
        this.pageNumber = current;
        return this;
    }


}
