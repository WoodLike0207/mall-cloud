package com.lb.user.dao;

import com.lb.mall.beans.Users;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserMapper extends Mapper<Users>, MySqlMapper<Users> {
}
