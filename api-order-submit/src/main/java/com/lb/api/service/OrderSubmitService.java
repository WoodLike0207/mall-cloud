package com.lb.api.service;

import com.lb.mall.beans.Orders;

import java.util.Map;

public interface OrderSubmitService {
    Map<String, String> addOrder(String cids, Orders order);
}
