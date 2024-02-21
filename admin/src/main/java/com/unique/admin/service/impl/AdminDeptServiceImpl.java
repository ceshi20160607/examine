package com.unique.admin.service.impl;

import com.unique.admin.entity.po.AdminDept;
import com.unique.admin.mapper.AdminDeptMapper;
import com.unique.admin.service.IAdminDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.core.common.BasePage;
import com.unique.core.bo.SearchBO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@Service
public class AdminDeptServiceImpl extends ServiceImpl<AdminDeptMapper, AdminDept> implements IAdminDeptService {

    @Override
    public BasePage<List<AdminDept>> queryPageList(SearchBO search) {
        return getBaseMapper().queryPageList(search.parse(), search);
    }
}
