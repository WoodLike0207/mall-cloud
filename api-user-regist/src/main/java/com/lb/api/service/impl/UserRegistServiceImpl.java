package com.lb.api.service.impl;

import com.lb.api.feign.UserCheckClient;
import com.lb.api.feign.UserSaveClient;
import com.lb.api.service.UserRegistService;
import com.lb.mall.beans.Users;
import com.lb.mall.utils.MD5Utils;
import com.lb.mall.vo.RespStatus;
import com.lb.mall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRegistServiceImpl implements UserRegistService {
    @Autowired
    private UserCheckClient userCheckClient;
    @Autowired
    private UserSaveClient userSaveClient;

    @Override
    public ResultVo regist(String name, String password) {
        synchronized (this){
            Users user = userCheckClient.check(name);

            if (user == null){
                String md5Pwd = MD5Utils.md5(password);
                user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());

                int i = userSaveClient.saveUser(user);
                if (i > 0){
                    return new ResultVo(RespStatus.OK,"注册成功",user);
                }else {
                    return new ResultVo(RespStatus.NO,"注册失败",null);
                }
            } else if (user.getUsername() == null) { // 服务降级
                return new ResultVo(RespStatus.NO,"网络出现故障，请重试",null);
            }else {
                return new ResultVo(RespStatus.NO,"用户名已被注册，请更换用户名!",null);
            }
        }
    }
}
