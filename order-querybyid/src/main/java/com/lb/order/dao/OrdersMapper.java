package com.lb.order.dao;

import com.lb.mall.entity.Orders;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface OrdersMapper extends Mapper<Orders>, MySqlMapper<Orders> {
}
