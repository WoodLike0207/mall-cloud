package com.lb.api.controller;

import com.lb.api.service.UserLoginService;
import com.lb.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/user/login")
    public ResultVo login(@RequestParam("username") String username,
                          @RequestParam("password") String password){
        return userLoginService.checkLogin(username, password);
    }
}
