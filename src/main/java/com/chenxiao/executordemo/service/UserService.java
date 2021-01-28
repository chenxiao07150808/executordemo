package com.chenxiao.executordemo.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @name:
 * @Author: cx
 * @date: 2021/1/28
 * @describe:
 */
@Service
public class UserService {

    public Set<String> selectAllUserEmails(){
        Set<String> emails = new HashSet<>();
        emails.add("1750071760@qq.com");
        emails.add("chenxiao9839@126.com");
        return emails;
    }
}
