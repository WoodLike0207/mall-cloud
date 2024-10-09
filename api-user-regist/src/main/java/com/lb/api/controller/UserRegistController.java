package com.lb.api.controller;

import com.lb.api.service.UserRegistService;
import com.lb.mall.beans.Users;
import com.lb.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserRegistController {
    @Autowired
    private UserRegistService userRegistService;

    @PostMapping("/user/regist")
    public ResultVo regist(@RequestBody Users user){
        ResultVo vo = userRegistService.regist(user.getUsername(), user.getPassword());
        return vo;
    }
}
