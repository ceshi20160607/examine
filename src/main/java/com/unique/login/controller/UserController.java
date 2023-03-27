package com.unique.login.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.unique.admin.common.utils.EncryptUtil;
import com.unique.admin.entity.bo.UserBO;
import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.service.IAdminUserService;
import com.unique.core.common.Result;
import com.unique.core.common.enums.UserStatusEnum;
import com.unique.core.context.Const;
import com.unique.core.enums.SystemCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author UNIQUE
 * @create 2023-03-25
 * @verson 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IAdminUserService iAdminUserService;


    @RequestMapping("doLogin")
    public Result doLogin(@RequestBody UserBO userBO) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        List<AdminUser> list = iAdminUserService.lambdaQuery().eq(AdminUser::getUsername, userBO.getUsername()).eq(AdminUser::getStatus, UserStatusEnum.NORMAL.getType()).list();
        if (CollectionUtil.isNotEmpty(list)) {
            AdminUser adminUser = list.get(0);
            StpUtil.login(adminUser.getId());
            if (EncryptUtil.checkUserPwd(adminUser, userBO.getPassword())) {
                SaSession session = StpUtil.getSession();
                session.set(Const.DEFAULT_SESSION_USER_KEY + adminUser.getId(), adminUser);
                return Result.ok(StpUtil.getTokenInfo());
            }
        }
        return Result.error(SystemCodeEnum.SYSTEM_NOT_LOGIN);
    }

    @RequestMapping("isLogin")
    public Result isLogin() {
        return Result.ok("是否登录：" + StpUtil.isLogin());
    }


    @RequestMapping("logout")
    public Result logout() {
        StpUtil.logout();
        return Result.ok();
    }
}
