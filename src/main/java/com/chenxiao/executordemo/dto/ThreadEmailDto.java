package com.chenxiao.executordemo.dto;

import com.chenxiao.executordemo.service.EmailSendService;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

/**
 * @name:
 * @Author: cx
 * @date: 2021/1/28
 * @describe:
 */
@AllArgsConstructor
public class ThreadEmailDto implements Callable<Boolean> {
    private String userEmail;
    private String subject;
    private String content;
    private EmailSendService emailSendService;

    @Override
    public Boolean call() throws Exception {
        emailSendService.sendEmail(subject, content, userEmail);
        return true;
    }
}
