package com.unique.login.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.unique.admin.common.utils.EncryptUtil;
import com.unique.admin.entity.bo.UserBO;
import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.service.IAdminUserService;
import com.unique.core.common.Result;
import com.unique.core.enums.UserStatusEnum;
import com.unique.core.context.Const;
import com.unique.core.enums.SystemCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author UNIQUE
 * @create 2023-03-25
 * @verson 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class LoginUserController {

    @Autowired
    private IAdminUserService iAdminUserService;


    @PostMapping("doLogin")
    public Result doLogin(@RequestBody UserBO userBO) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        List<AdminUser> list = iAdminUserService.lambdaQuery().eq(AdminUser::getUsername, userBO.getUsername()).eq(AdminUser::getStatus, UserStatusEnum.NORMAL.getType()).list();
        if (CollectionUtil.isNotEmpty(list)) {
            AdminUser adminUser = list.get(0);
            if (EncryptUtil.checkUserPwd(adminUser, userBO.getPassword())) {
                StpUtil.login(adminUser.getId(), userBO.getDeviceType().getRemarks());
                SaSession session = StpUtil.getSession();
                session.set(Const.DEFAULT_SESSION_USER_KEY + adminUser.getId(), adminUser);
                log.info("****:"+StpUtil.getTokenInfo().toString());
                return Result.ok(StpUtil.getTokenInfo());
            }
        }
        return Result.error(SystemCodeEnum.SYSTEM_NOT_LOGIN);
    }

    @GetMapping("isLogin")
    public Result isLogin() {
        return Result.ok("是否登录：" + StpUtil.isLogin());
    }


    @GetMapping("logout")
    public Result logout() {
        StpUtil.logout();
        return Result.ok();
    }
}
