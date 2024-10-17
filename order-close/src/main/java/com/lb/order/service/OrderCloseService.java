package com.lb.order.service;

public interface OrderCloseService {
    int closeOrder(String orderId,int closeType);
}
