package com.unique.core.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author UNIQUE
 * @create 2023-01-28 11:46
 * @verson 1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T> {
}
