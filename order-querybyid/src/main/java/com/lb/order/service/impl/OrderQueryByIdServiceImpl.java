package com.lb.order.service.impl;

import com.lb.mall.entity.Orders;
import com.lb.order.dao.OrdersMapper;

import com.lb.order.service.OrderQueryByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderQueryByIdServiceImpl implements OrderQueryByIdService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Orders queryOrderById(String orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        return orders;
    }
}
