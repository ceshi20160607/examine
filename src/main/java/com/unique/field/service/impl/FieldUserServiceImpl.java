package com.unique.field.service.impl;

import com.unique.field.entity.po.FieldUser;
import com.unique.field.mapper.FieldUserMapper;
import com.unique.field.service.IFieldUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 自定义字段关联用户表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@Service
public class FieldUserServiceImpl extends ServiceImpl<FieldUserMapper, FieldUser> implements IFieldUserService {

}
