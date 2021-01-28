package com.chenxiao.executordemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @name:
 * @Author: cx
 * @date: 2021/1/28
 * @describe: 邮件发送操作
 */
@Slf4j
@Service
public class EmailSendService {

    private final Environment environment;

    private final JavaMailSender javaMailSender;


    @Autowired
    public EmailSendService(Environment environment, JavaMailSender javaMailSender) {
        this.environment = environment;
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送简单的邮件消息
     * @param subject  项目
     * @param content  内容
     * @param tos  其他参数
     */
    public void sendEmail(String subject, String content, String ... tos){
        try {
            // 设置邮箱内容
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(subject);
            message.setText(content);
            message.setTo(tos);
            // 设置邮箱的发送方
            message.setFrom(environment.getProperty("mail.send.from"));
            // 发送邮箱
            javaMailSender.send(message);
            log.info("发送邮箱成功, {}", tos);
        }catch (Exception e){
            log.error("--发送简单的邮件消息,发生异常：",e.fillInStackTrace());
        }
    }
}
