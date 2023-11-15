package com.unique.admin.service.impl;

import com.unique.admin.entity.po.AdminUserRole;
import com.unique.admin.mapper.AdminUserRoleMapper;
import com.unique.admin.service.IAdminUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色对应关系表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Service
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements IAdminUserRoleService {

}
