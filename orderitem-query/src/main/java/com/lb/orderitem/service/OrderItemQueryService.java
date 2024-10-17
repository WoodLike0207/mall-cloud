package com.lb.orderitem.service;

import com.lb.mall.entity.OrderItem;

import java.util.List;

public interface OrderItemQueryService {
    List<OrderItem> queryOrderItem(String orderId);
}
