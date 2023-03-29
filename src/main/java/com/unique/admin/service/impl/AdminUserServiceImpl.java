package com.unique.admin.service.impl;

import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.mapper.AdminUserMapper;
import com.unique.admin.service.IAdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.core.common.BasePage;
import com.unique.core.common.bo.SearchBO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public BasePage<List<Map<String, Object>>> queryPageList(SearchBO search) {
        return getBaseMapper().queryPageList(search.parse(), search);
    }
}
