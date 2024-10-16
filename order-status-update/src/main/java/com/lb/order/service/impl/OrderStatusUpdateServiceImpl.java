package com.lb.order.service.impl;

import com.lb.mall.entity.Orders;
import com.lb.order.dao.OrdersMapper;
import com.lb.order.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusUpdateServiceImpl implements OrderStatusUpdateService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int updateStatus(Orders order) {
        int i = ordersMapper.updateByPrimaryKey(order);
        return i;
    }
}
