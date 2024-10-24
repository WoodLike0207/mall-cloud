package com.lb.order.service;

import com.lb.mall.entity.Orders;

public interface OrderQueryByIdService {
    Orders queryOrderById(String orderId);
}
