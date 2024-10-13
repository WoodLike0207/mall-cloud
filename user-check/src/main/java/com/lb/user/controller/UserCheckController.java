package com.lb.user.controller;

import com.lb.mall.entity.Users;
import com.lb.user.service.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserCheckController {

    @Autowired
    private UserCheckService userCheckService;

    @GetMapping("/check")
    public Users check(String username){
        return userCheckService.queryUser(username);
    }
}
