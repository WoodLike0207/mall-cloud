package com.lb.order.controller;

import com.lb.mall.entity.Orders;
import com.lb.order.service.OrderTimeOutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderTimeOutQueryController {
    @Autowired
    private OrderTimeOutQueryService orderTimeOutQueryService;

    @GetMapping("/order/query/timeout")
    public List<Orders> query(){
        return orderTimeOutQueryService.listOrders();
    }
}
