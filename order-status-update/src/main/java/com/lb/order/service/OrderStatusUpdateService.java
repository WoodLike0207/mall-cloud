package com.lb.order.service;

import com.lb.mall.entity.Orders;

public interface OrderStatusUpdateService {
    int updateStatus(Orders order);
}
