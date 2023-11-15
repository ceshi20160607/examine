package com.unique.admin.common.utils;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.util.RandomUtil;
import com.unique.admin.entity.po.AdminUser;
import com.unique.core.context.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 加密工具类
 *
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class EncryptUtil {

    /**
     * 新建用户  设置密码
     *
     * @return { com.unique.admin.entity.po.AdminUser}
     * @author UNIQUE
     * @date 2023/3/27
     */
    public static AdminUser encryUserPwd(AdminUser adminUser) {
        String salt = RandomUtil.randomString(32);
        adminUser.setSalt(salt);
        return encryUserPwdSalt(adminUser);
    }

    /**
     * 更新 用户密码
     *
     * @return { com.unique.admin.entity.po.AdminUser}
     * @author UNIQUE
     * @date 2023/3/27
     */
    public static AdminUser encryUserPwdSalt(AdminUser adminUser) {
        String md5Password = SaSecureUtil.md5BySalt(adminUser.getUsername() + Const.SEPARATOR_COLON + adminUser.getPassword(), adminUser.getSalt());
        adminUser.setPassword(md5Password);
        return adminUser;
    }

    /**
     * 校验用户密码
     *
     * @return { java.lang.Boolean}
     * @author UNIQUE
     * @date 2023/3/27
     */
    public static Boolean checkUserPwd(AdminUser adminUser, String pwd) {
        String md5Password = SaSecureUtil.md5BySalt(adminUser.getUsername() + Const.SEPARATOR_COLON + pwd, adminUser.getSalt());
        return md5Password.equals(adminUser.getPassword());
    }
}
