package com.unique.core.common;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangzhiwei
 * 默认分页
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
    private List<OrderItem> orders = new ArrayList<>();


    /**
     * 额外数据
     */
    private Object extraData;


    @Override
    public List<OrderItem> orders() {
        return orders;
    }

    @Override
    public List<T> getRecords() {
        return this.list;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        this.list=records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.totalRow;
    }

    @Override
    public IPage<T> setTotal(long total) {
        this.totalRow = total;
        return this;
    }

    @Override
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public IPage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.pageNumber;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.pageNumber = current;
        return this;
    }
}
