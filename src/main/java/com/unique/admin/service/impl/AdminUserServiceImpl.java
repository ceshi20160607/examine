package com.unique.admin.service.impl;

import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.mapper.AdminUserMapper;
import com.unique.admin.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
