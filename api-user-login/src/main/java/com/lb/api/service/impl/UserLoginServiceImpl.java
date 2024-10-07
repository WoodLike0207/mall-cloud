package com.lb.api.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lb.api.service.UserLoginService;
import com.lb.api.service.feign.UserCheckClient;
import com.lb.mall.beans.Users;
import com.lb.mall.utils.MD5Utils;
import com.lb.mall.vo.RespStatus;
import com.lb.mall.vo.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserCheckClient userCheckClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResultVo checkLogin(String name, String password) {
        Users user = userCheckClient.check(name);

        if (user == null){
            return new ResultVo(RespStatus.NO,"login fail",null);
        }else {
            String md5Pwd = MD5Utils.md5(password);
            if (user.getPassword().equals(md5Pwd)){

                JwtBuilder builder = Jwts.builder();

                String token = builder.setSubject(name)      // 主题，就是token中携带的数据
                        .setIssuedAt(new Date())             // 设置token的生成时间
                        .setId(user.getUserId() + "")   // 设置用户id 为token id
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))  // 设置token的过期时间
                        .signWith(SignatureAlgorithm.HS256, "MALL666")  // 设置加密方式和加密密码
                        .compact();

                // 当⽤户登录成功之后，以token为key 将⽤户信息保存到redis
                try {
                    String userInfo = objectMapper.writeValueAsString(user);
                    stringRedisTemplate.boundValueOps(token).set(userInfo,30, TimeUnit.MINUTES);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }


                return new ResultVo(RespStatus.OK,token, user);
            }else {
                return new ResultVo(RespStatus.NO,"login fail",null);
            }
        }
    }
}
