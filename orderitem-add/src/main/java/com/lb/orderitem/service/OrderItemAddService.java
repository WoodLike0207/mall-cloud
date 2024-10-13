package com.lb.orderitem.service;

import com.lb.mall.entity.ShoppingCartVO;

import java.util.List;

public interface OrderItemAddService {

    int save(List<ShoppingCartVO> list, String orderId);
}
