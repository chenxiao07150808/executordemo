package com.chenxiao.executordemo.controller;

import com.baidubce.services.iothub.model.BaseResponse;
import com.chenxiao.executordemo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @name:
 * @Author: cx
 * @date: 2021/1/28
 * @describe:
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(value = "all/mail/send",method = RequestMethod.GET)
    public BaseResponse sendAllUerEmail(){
        BaseResponse response = new BaseResponse();
        try {
            threadService.sentAllEmails();
            response.setMessage("成功");

        }catch (Exception e){
            response.setMessage(e.getMessage());
        }
        return response;
    }
}