package com.unique.field.service.impl;

import com.unique.field.entity.po.FieldAuth;
import com.unique.field.mapper.FieldAuthMapper;
import com.unique.field.service.IFieldAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义字段关联角色表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-11-23
 */
@Service
public class FieldAuthServiceImpl extends ServiceImpl<FieldAuthMapper, FieldAuth> implements IFieldAuthService {

}
