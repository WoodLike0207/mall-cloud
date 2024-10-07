package com.lb.api.service;

import com.lb.mall.vo.ResultVo;

public interface UserLoginService {
    ResultVo checkLogin(String name, String password);
}
