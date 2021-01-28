package com.chenxiao.executordemo.service;

import com.chenxiao.executordemo.dto.ThreadEmailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @name:
 * @Author: cx
 * @date: 2021/1/28
 * @describe:
 */
@Slf4j
@Service
public class ThreadService {

    private final EmailSendService emailSendService;
    private final UserService userService;

    @Autowired
    public ThreadService(EmailSendService emailSendService, UserService userService) {
        this.emailSendService = emailSendService;
        this.userService = userService;
    }

    public void sentAllEmails() throws InterruptedException {
        Set<String> set = userService.selectAllUserEmails();

       log.info("接收的邮件列表:{}", set);

       if(set != null && !set.isEmpty()){
           ExecutorService executorService = newFixedThreadPool(10);

           List<ThreadEmailDto> list = new LinkedList<>();

           set.forEach(s->list.add(new ThreadEmailDto(s, "春节到了！","春运开始了",emailSendService)));

           executorService.invokeAll(list);
       }
    }
}
