package com.unique.admin.common.utils;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailUtil;
import com.unique.admin.entity.po.AdminUser;
import com.unique.core.context.Const;
import com.unique.examine.entity.po.ExamineRecordLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 发送邮件工具类
 *
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class EncryptUtil {

    public static AdminUser encryUserPwd(AdminUser adminUser) {
        String salt = RandomUtil.randomString(32);
        adminUser.setSalt(salt);
        return encryUserPwdSalt(adminUser);
    }

    public static AdminUser encryUserPwdSalt(AdminUser adminUser) {
        String md5Password = SaSecureUtil.md5BySalt(adminUser.getUsername() + Const.SEPARATOR_COLON + adminUser.getPassword(), adminUser.getSalt());
        adminUser.setPassword(md5Password);
        return adminUser;
    }

    public static Boolean checkUserPwd(AdminUser adminUser, String pwd) {
        String md5Password = SaSecureUtil.md5BySalt(adminUser.getUsername() + Const.SEPARATOR_COLON + pwd, adminUser.getSalt());
        return md5Password.equals(adminUser.getPassword());
    }
}
