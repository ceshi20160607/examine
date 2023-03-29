package com.unique.admin.service;

import com.unique.admin.entity.po.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unique.core.common.BasePage;
import com.unique.core.common.bo.SearchBO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
public interface IAdminUserService extends IService<AdminUser> {

    BasePage<List<Map<String, Object>>> queryPageList(SearchBO search);
}
