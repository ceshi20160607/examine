package com.unique.field.service.impl;

import com.unique.field.entity.po.Field;
import com.unique.field.mapper.FieldMapper;
import com.unique.field.service.IFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义字段表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@Service
public class FieldServiceImpl extends ServiceImpl<FieldMapper, Field> implements IFieldService {

}
