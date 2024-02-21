package com.unique.core.utils;

import cn.hutool.extra.mail.MailUtil;
import com.unique.core.bo.SendEmailBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *  发送邮件工具类
 * @author UNIQUE
 * @create 2023-03-07
 * @verson 1.0.0
 */
@Slf4j
@Component
public class EmailUtil {

    public static void sendEmailProcess(SendEmailBO sendEmailBO) {
        for (String email : sendEmailBO.getEmails()) {
            MailUtil.send(email, "测试", "邮件来自Hutool测试", false);
        }
    }

    public static void sendEmailHtmlProcess(SendEmailBO sendEmailBO) {
        for (String email : sendEmailBO.getEmails()) {
            MailUtil.send(email, "测试", "<a>邮件来自Hutool测试</a>", true);
        }
    }

}
