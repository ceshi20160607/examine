package com.unique.admin.service;

import com.unique.admin.entity.po.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unique.admin.entity.vo.AdminUserVO;
import com.unique.core.common.BasePage;
import com.unique.core.bo.SearchBO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
public interface IAdminUserService extends IService<AdminUser> {

    BasePage<List<AdminUserVO>> queryPageList(SearchBO search);
}
