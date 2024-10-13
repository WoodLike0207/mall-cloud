package com.lb.user.controller;

import com.lb.mall.entity.Users;
import com.lb.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserSaveController {
    @Autowired
    private UserSaveService userSaveService;

    @PostMapping("/save")
    public int saveUser(@RequestBody Users user){
        return userSaveService.saveUser(user);
    }
}
