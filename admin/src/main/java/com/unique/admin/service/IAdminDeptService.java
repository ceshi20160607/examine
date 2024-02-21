package com.unique.admin.service;

import com.unique.admin.entity.po.AdminDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unique.core.common.BasePage;
import com.unique.core.bo.SearchBO;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
public interface IAdminDeptService extends IService<AdminDept> {

    BasePage<List<AdminDept>> queryPageList(SearchBO search);
}
