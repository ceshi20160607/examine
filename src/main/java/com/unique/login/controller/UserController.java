package com.unique.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.service.IAdminUserService;
import com.unique.core.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result doLogin(String username, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        List<AdminUser> list = iAdminUserService.lambdaQuery().eq(AdminUser::getUsername, username).eq(AdminUser::getPassword, pwd).list();
        if(CollectionUtil.isNotEmpty(list)) {
            StpUtil.login(list.get(0).getId());
            return Result.ok(StpUtil.getTokenInfo());
        }
        return Result.error();
    }

    @RequestMapping("isLogin")
    public Result isLogin() {
        return Result.ok("是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("tokenInfo")
    public Result tokenInfo() {
        return Result.ok(StpUtil.getTokenInfo());
    }

    @RequestMapping("logout")
    public Result logout() {
        StpUtil.logout();
        return Result.ok();
    }
}
