package com.lb.user.service.impl;

import com.lb.mall.entity.Users;
import com.lb.user.dao.UserMapper;
import com.lb.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSaveServiceImpl implements UserSaveService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Users user) {
        return userMapper.insertUseGeneratedKeys(user);
    }
}
